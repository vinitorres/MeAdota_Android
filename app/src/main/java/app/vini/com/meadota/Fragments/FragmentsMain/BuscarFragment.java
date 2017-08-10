package app.vini.com.meadota.Fragments.FragmentsMain;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.vini.com.meadota.Model.OpcaoButton;
import app.vini.com.meadota.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment {

    private RecyclerView recyclerView;
    private Context context;

    private ArrayList<OpcaoButton> listaBotoes;

    public BuscarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_buscar, container, false);
        context = getActivity().getApplicationContext();

//        opcaoButtonAdapter = new OpcaoButtonAdapter(listaBotoes,context);
//
//        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvOpcoesBusca);
//
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(opcaoButtonAdapter);
//        recyclerView.setHasFixedSize(true);
//
//        initializeData();

        return inflater.inflate(R.layout.fragment_buscar, container, false);
    }

    private void initializeData(){
        listaBotoes = new ArrayList<>();
        listaBotoes.add(new OpcaoButton(R.string.cachorros_text,R.drawable.ic_btn_dog));
        listaBotoes.add(new OpcaoButton(R.string.cachorros_text,R.drawable.ic_btn_cat));

    }

}
