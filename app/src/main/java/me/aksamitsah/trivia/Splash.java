package me.aksamitsah.trivia;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_TIMER = 3000;
    TextView brandName, txt_brand_sub;
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash);

        brandName = findViewById(R.id.txt_brand);
        txt_brand_sub = findViewById(R.id.txt_brand_sub);

        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        brandName.setAnimation(sideAnim);
        txt_brand_sub.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Function.intentActivitySplash(Splash.this, MainScreen.class);
                finish();
            }
        }, SPLASH_TIMER);
    }
}