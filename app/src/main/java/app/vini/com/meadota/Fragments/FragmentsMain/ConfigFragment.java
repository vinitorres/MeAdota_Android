package app.vini.com.meadota.Fragments.FragmentsMain;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import app.vini.com.meadota.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfigFragment extends Fragment {

    @BindView(R.id.btnLogout)
    Button btnLogout;

    public ConfigFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_config, container, false);
        ButterKnife.bind(this,view);



        return view;
    }

    @OnClick(R.id.btnLogout)
    public void logout(){
        FirebaseAuth.getInstance().signOut();

//        if (FirebaseAuth.getInstance() == null) {
//
//            Intent intent = new Intent(this.getContext(), InicioActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//
//        }

    }

}
