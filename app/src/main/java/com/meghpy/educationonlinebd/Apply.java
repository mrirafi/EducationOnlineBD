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

public class Apply extends AppCompatActivity {

    LinearLayout hsc, hons,degree, tec;
    String[] urls=new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        hsc = findViewById(R.id.hsc);
        hons = findViewById(R.id.hons);
        degree = findViewById(R.id.degree);
        tec = findViewById(R.id.tec);

        urls[0]="https://xiclassadmissiongovbd.com/apply-online/";
        urls[1]="http://app55.nu.edu.bd/nu-web/application/honsApplicationForm";
        urls[2]="http://app55.nu.edu.bd/nu-web/application/degpApplicationForm";
        urls[3]="http://btebadmission.gov.bd/website/";



        hsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apply.this, Websites.class);
                intent.putExtra("links", urls[0]);
                startActivity(intent);
            }
        });
        hons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apply.this, Websites.class);
                intent.putExtra("links", urls[1]);
                startActivity(intent);
            }
        });

        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apply.this, Websites.class);
                intent.putExtra("links", urls[2]);
                startActivity(intent);
            }
        });

        tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apply.this, Websites.class);
                intent.putExtra("links", urls[3]);
                startActivity(intent);
            }
        });

        //----------------------------------------------
    }
}