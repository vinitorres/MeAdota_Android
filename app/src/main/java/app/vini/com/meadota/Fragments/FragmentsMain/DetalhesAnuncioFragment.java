package app.vini.com.meadota.Fragments.FragmentsMain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.vini.com.meadota.Model.Anuncio;
import app.vini.com.meadota.R;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhesAnuncioFragment extends Fragment {



    Anuncio anuncio;

    public DetalhesAnuncioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_detalhes_anuncio, container, false);
        ButterKnife.bind(this,view);

        return view;


    }

}
