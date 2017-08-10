package app.vini.com.meadota.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import app.vini.com.meadota.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etEmail) EditText etLogin;
    @BindView(R.id.etSenha) EditText etSenha;

    private FirebaseAuth mAuth;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        context = this.getApplicationContext();

        mAuth = FirebaseAuth.getInstance();

    }

    @OnClick(R.id.btnLogin)
    public void logar(View view){

        if (!etLogin.getText().toString().equals("") || !etSenha.getText().toString().equals("")){
            String email = etLogin.getText().toString();
            String senha = etSenha.getText().toString();

            mAuth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d("Sucess sign in: ", "signInWithEmail:onComplete:" + task.isSuccessful());
                            Intent intent = new Intent(context,MainActivity.class);
                            startActivity(intent);

                            if (!task.isSuccessful()) {
                                Log.w("Falha sign in: ", "signInWithEmail:failed", task.getException());

                            }

                            // ...
                        }
                    });
        }

    }
}
