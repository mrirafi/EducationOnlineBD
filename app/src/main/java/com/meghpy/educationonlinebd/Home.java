package com.meghpy.educationonlinebd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    Button result, apply, college;
    ImageView share;

    String[] urls = new String[6];

    CardView privacy, donation, birth, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        result = findViewById(R.id.result);
        share = findViewById(R.id.share);
        apply = findViewById(R.id.apply);
        college = findViewById(R.id.college);
        privacy = findViewById(R.id.privacy);
        donation = findViewById(R.id.donation);
        birth = findViewById(R.id.birth);
        rating = findViewById(R.id.rating);

        urls[0] = "https://sites.google.com/view/privacypolicy-educationbd/home";
        urls[1] = "https://everify.bdris.gov.bd";
        urls[2] = "http://estipend.pmeat.gov.bd";
        urls[3] = "https://www.mdrafiqulislam.com/about/";


//        rateUsOnGooglePlay();



        //-------------------------------

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
                String app_url = "https://play.google.com/store/apps/details?id=com.meghpy.educationbdresult";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));

            }
        });

        //--------------------------

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Websites.class);
                intent.putExtra("links", urls[3]);
                startActivity(intent);

            }
        });
        //--------------------------

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Websites.class);
                intent.putExtra("links", urls[0]);
                startActivity(intent);
            }
        });

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Websites.class);
                intent.putExtra("links", urls[2]);
                startActivity(intent);
                Toast.makeText(Home.this, "এইটা ধীরগতি সম্পন্ন ওয়েবসাইট,অপেক্ষা করুন", Toast.LENGTH_SHORT).show();
            }
        });

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Websites.class);
                intent.putExtra("links", urls[1]);
                startActivity(intent);
            }
        });


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Results.class);
                startActivity(intent);
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Apply.class);
                startActivity(intent);
            }
        });

        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Colleges.class);
                startActivity(intent);

            }
        });
    }


//    private void rateUsOnGooglePlay() {
//        rating.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
//                try {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                } catch (android.content.ActivityNotFoundException anfe) {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//                }
//
//            }
//        });
//    }
}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

