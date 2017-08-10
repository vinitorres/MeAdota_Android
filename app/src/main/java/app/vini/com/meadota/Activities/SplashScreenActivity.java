package app.vini.com.meadota.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import app.vini.com.meadota.R;


public class SplashScreenActivity extends AppCompatActivity {

    ImageView splashIcon;
    Animation fadeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashIcon = (ImageView) findViewById(R.id.ivSplashIcon);
        loadAnimation();
    }

    private void loadAnimation(){

        fadeAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_screen_animation);
        fadeAnimation.reset();

        if(splashIcon != null){
            splashIcon.clearAnimation();
            splashIcon.startAnimation(fadeAnimation);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (FirebaseAuth.getInstance() != null) {
                    Intent loginIntent = new Intent(SplashScreenActivity.this, InicioActivity.class);
                    loginIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(loginIntent);
                    SplashScreenActivity.this.finish();
                } else {
                    Intent loginIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    loginIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(loginIntent);
                    SplashScreenActivity.this.finish();
                }
            }
        },2000);

    }

}
