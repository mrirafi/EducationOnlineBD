package com.meghpy.educationonlinebd;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    Animation topAnimation, bottom;
    ImageView treed;

    ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        treed = findViewById(R.id.treed);
        topAnimation = AnimationUtils.loadAnimation(Splash.this, R.anim.up_to_down);
        bottom = AnimationUtils.loadAnimation(Splash.this, R.anim.bottom);


        progressBar = findViewById(R.id.progressBar);
        treed.setAnimation(topAnimation);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });

        thread.start();

    }

    public void doWork() {

        for (progress = 20; progress <= 100; progress = progress + 2) {

            try {
                Thread.sleep(40);
                progressBar.setProgress(progress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    //------------------

    public void startApp() {

        Intent intent = new Intent(Splash.this, Home.class);
        startActivity(intent);
        finish();

    }

}