package app.vini.com.meadota.Activities;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import app.vini.com.meadota.Fragments.FragmentsMain.AnunciosFragment;
import app.vini.com.meadota.Fragments.FragmentsMain.BuscarFragment;
import app.vini.com.meadota.Fragments.FragmentsMain.ChatFragment;
import app.vini.com.meadota.Fragments.FragmentsMain.ConfigFragment;
import app.vini.com.meadota.Fragments.FragmentsMain.NovoAnuncioFragment;
import app.vini.com.meadota.Helper.BottomNavigationViewHelper;
import app.vini.com.meadota.Activities.InicioActivity;
import app.vini.com.meadota.R;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context context;

    private TextView title;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    changeFragment(0);

                    return true;
                case R.id.navigation_anuncios:

                    changeFragment(1);

                    return true;
                case R.id.navigation_buscar:

                    changeFragment(2);

                    return true;

                case R.id.navigation_chat:

                    changeFragment(3);

                    return true;

                case R.id.navigation_config:

                    changeFragment(4);

                    return true;

            }
            return false;
        }

    };

    @Override
    protected void attachBaseContext(Context newBase) {
       // super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);

        toolbar.setPadding(0, statusBarHeight(getResources()), 0, 0);


        context = this.getApplicationContext();
        mAuth = FirebaseAuth.getInstance();

//        Utility utility = new Utility();
//        utility.getLocation(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("Login Status: ", "onAuthStateChanged:signed_in:" + user.getDisplayName());

                    changeFragment(0);


                } else {
                    // User is signed out
                    Log.d("Login Status: ", "onAuthStateChanged:signed_out");

                    Intent intent = new Intent(context, InicioActivity.class);
                    startActivity(intent);

                }
                // ...
            }
        };

    }

    private static int statusBarHeight(android.content.res.Resources res) {
        return (int) (24 * res.getDisplayMetrics().density);
    }

//    private int getStatusBarHeight() {
//        int height;
//
//        Resources myResources = getResources();
//        int idStatusBarHeight = myResources.getIdentifier("status_bar_height", "dimen", "android");
//
//        if (idStatusBarHeight > 0) {
//            height = getResources().getDimensionPixelSize(idStatusBarHeight);
//            Toast.makeText(this,
//                    "Status Bar Height = " + height,
//                    Toast.LENGTH_LONG).show();
//        }else{
//            height = 0;
//            Toast.makeText(this,
//                    "Resources NOT found",
//                    Toast.LENGTH_LONG).show();
//        }
//
//        return height;
//    }

    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
            title.setText("Perfil");
            newFragment = new NovoAnuncioFragment();
        } else if (position == 1) {
            title.setText("Anuncios");
            newFragment = new AnunciosFragment();
        } else if (position == 2) {
            title.setText("Buscar");
            newFragment = new BuscarFragment();
        } else if (position == 3) {
            title.setText("Chat");
            newFragment = new ChatFragment();
        } else if (position == 4) {
            title.setText("Config");
            newFragment = new ConfigFragment();
        }


        getFragmentManager().beginTransaction().replace(
                R.id.content, newFragment)
                .commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
