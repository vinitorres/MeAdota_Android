package app.vini.com.meadota.Fragments.FragmentsMain;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import app.vini.com.meadota.Adapter.AnunciosAdapter;
import app.vini.com.meadota.Model.Anuncio;
import app.vini.com.meadota.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnunciosFragment extends Fragment {

    @BindView(R.id.rvAnuncios)
    RecyclerView rvAnuncios;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    private Context context;
    private ProgressDialog mProgressDialog;
    private AnunciosAdapter anunciosAdapter;
    private ArrayList<Anuncio> listaAnuncios;

    public AnunciosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anuncios,container,false);
        ButterKnife.bind(this,view);

        context = container.getContext();
        mProgressDialog = new ProgressDialog(context);

        listaAnuncios = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Anuncios");




        anunciosAdapter = new AnunciosAdapter(listaAnuncios);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvAnuncios.setLayoutManager(layoutManager);
        rvAnuncios.setAdapter(anunciosAdapter);
        rvAnuncios.setHasFixedSize(true);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        Anuncio anuncio = child.getValue(Anuncio.class);
                        listaAnuncios.add(anuncio);
                        anunciosAdapter.update(listaAnuncios);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }


}
