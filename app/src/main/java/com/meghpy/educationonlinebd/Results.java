package com.meghpy.educationonlinebd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Results extends AppCompatActivity {

    LinearLayout hsc, national, ssc, tec, jsc, psc;
    String[] urls = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        hsc = findViewById(R.id.hsc);
        national = findViewById(R.id.national);
        ssc = findViewById(R.id.ssc);
        tec = findViewById(R.id.tec);
        jsc = findViewById(R.id.jsc);
        psc = findViewById(R.id.psc);


        urls[0] = "https://www.nu.ac.bd/results";
        urls[1] = "http://180.211.164.133/result_arch";
        urls[2] = "http://180.211.137.51";


        //==================


        hsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });


        national.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, Websites.class);
                intent.putExtra("links", urls[0]);
                startActivity(intent);
            }
        });


        ssc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, Websites.class);
                intent.putExtra("links", urls[1]);
                startActivity(intent);
            }
        });

        jsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });

        psc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, Websites.class);
                intent.putExtra("links", urls[2]);
                startActivity(intent);
            }
        });

    }

}
