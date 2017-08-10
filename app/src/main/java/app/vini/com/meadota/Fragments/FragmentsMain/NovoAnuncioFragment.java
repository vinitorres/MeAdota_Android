package app.vini.com.meadota.Fragments.FragmentsMain;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import app.vini.com.meadota.Adapter.ImagensSelecionadasAdapter;
import app.vini.com.meadota.Helper.DatabaseHelper;
import app.vini.com.meadota.Model.Anuncio;
import app.vini.com.meadota.R;
import app.vini.com.meadota.Util.Utility;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class NovoAnuncioFragment extends Fragment {

    @BindView(R.id.rv_galeria)
    RecyclerView rvGallery;
    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.etDescricao)
    EditText etDescricao;
    @BindView(R.id.rgGenero)
    RadioGroup rgGenero;
    private ProgressDialog mProgressDialog;


    private ImagensSelecionadasAdapter imagensAdapter;
    private Context context;
    private ArrayList<Bitmap> listaImagens;

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;
    private Bitmap bitmap;
    public long idAnuncio;
    public String latitude = "";
    public String longitude = "";
    public ArrayList<String> listaUrl;
    private DatabaseHelper databaseHelper;

    private FirebaseDatabase database;
    private FirebaseStorage storage;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public NovoAnuncioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_anuncio, container, false);
        setRetainInstance(true);
        ButterKnife.bind(this, view);
        context = container.getContext();
        mProgressDialog = new ProgressDialog(context);

        databaseHelper = new DatabaseHelper(context);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Anuncios");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        idAnuncio = Long.parseLong(child.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listaImagens = new ArrayList<>();
        listaUrl = new ArrayList<>();

        imagensAdapter = new ImagensSelecionadasAdapter(listaImagens);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 3);
        rvGallery.setLayoutManager(layoutManager);
        rvGallery.setAdapter(imagensAdapter);
        rvGallery.setHasFixedSize(true);

        carregarImagens();

        return view;
    }

    private void carregarImagens() {

        listaImagens = databaseHelper.getImages();
        listaUrl = databaseHelper.getUrls();

        imagensAdapter.update(listaImagens);


    }


    @OnClick(R.id.btn_add_image_anuncio)
    public void pegarImagem() {

        if (listaImagens.size() <= 5) {
            final CharSequence[] items = {"Take Photo", "Choose from Library",
                    "Cancel"};

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    boolean result = Utility.checkPermissionStorage(getActivity());

                    if (items[item].equals("Take Photo")) {
                        userChoosenTask = "Take Photo";
                        if (result)
                            cameraIntent();

                    } else if (items[item].equals("Choose from Library")) {
                        userChoosenTask = "Choose from Library";
                        if (result)
                            galleryIntent();

                    } else if (items[item].equals("Cancel")) {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();
        } else {
            Toast.makeText(context, "Você ja adicionou o numero maximo de fotos", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.btn_anunciar)
    public void gerarAnuncio() {

        if (etTitulo.getText().length() > 0) {

            String uidUsuario;

            uidUsuario = mAuth.getCurrentUser().getUid();

            String tituloAnuncio;

            tituloAnuncio = etTitulo.getText().toString();

            String generoAnimal;

            int index = rgGenero.indexOfChild(getView().findViewById(rgGenero.getCheckedRadioButtonId()));

            if (index == 0) {
                generoAnimal = "M";
            } else if (index == 1) {
                generoAnimal = "F";
            } else {
                generoAnimal = "";
            }

            String descricao;

            descricao = etDescricao.getText().toString();

            String dataAnuncio;

            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = df.format(c.getTime());

            dataAnuncio = formattedDate;

            listaUrl = databaseHelper.getUrls();

            Anuncio anuncio = new Anuncio(uidUsuario, tituloAnuncio, generoAnimal, descricao, dataAnuncio, latitude, longitude, listaUrl);

            mDatabase.child("Anuncios").child(String.valueOf(idAnuncio)).setValue(anuncio);

            limparTela();
        } else {
            limparTela();
        }

    }

    public void limparTela(){

        ArrayList<String> coords = databaseHelper.getLocal();

        latitude = coords.get(0);
        longitude = coords.get(1);

        for (String url : listaUrl) {
            databaseHelper.removerImage(url);
        }
        etTitulo.setText("");
        etDescricao.setText("");
        rgGenero.clearCheck();
        carregarImagens();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if (userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }

    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {

        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        salvarImage(thumbnail, String.valueOf(listaImagens.size()));
        carregarImagens();


    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getActivity().getBaseContext().getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        salvarImage(bm, String.valueOf(listaImagens.size()));
        carregarImagens();

    }

    public void salvarImage(Bitmap bm, String nome) {

        carregarImagens();

        StorageReference storageRef = storage.getReference();
        String imageNome = nome;
        StorageReference imagesRef = storageRef.child(idAnuncio + "/imagens/" + imageNome);

        bitmap = bm;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] dataFB = baos.toByteArray();

        UploadTask uploadTask = imagesRef.putBytes(dataFB);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, "Erro ao salvar imagem, tente novamente", Toast.LENGTH_SHORT).show();
                carregarImagens();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                String url = String.valueOf(taskSnapshot.getDownloadUrl());
                databaseHelper.addImage(String.valueOf(listaImagens.size()), DatabaseHelper.getBytes(bitmap), url);
                mProgressDialog.dismiss();
                carregarImagens();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                mProgressDialog.setMessage("Uploading Image....");
                mProgressDialog.show();
            }
        });

    }
}


//    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyCart.this);
//        alertDialog.setCancelable(false);
//                alertDialog.setMessage("Delete item?");
//                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int which) {
//        String title;
//
//        title = arrayList.get(position).getTitle();
//
//        dbHelper.removeSingleContact(title);
//
//        //Update your ArrayList
//        arrayList = dbHelper.getAllContacts();
//
//        //Notify your ListView adapter
//        adapter.notifyDataSetChanged();
//
//        }
//        });
//        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int which) {
//        dialog.cancel();
//        }
//        });
//        alertDialog.show();
