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

public class MainActivity extends AppCompatActivity {

    LinearLayout server1, server2, server3, server4, server5, server6;
    String[] urls=new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        server1 = findViewById(R.id.server1);
        server2 = findViewById(R.id.server2);
        server3 = findViewById(R.id.server3);
        server4 = findViewById(R.id.server4);
        server5 = findViewById(R.id.server5);
        server6 = findViewById(R.id.server6);

        urls[0]="https://eboardresults.com/v2/home";
        urls[1]="http://www.educationboardresults.gov.bd";
        urls[2]="http://103.230.104.222";
        urls[3]="http://103.230.104.203";
        urls[4]="http://103.230.107.235";
        urls[5]="http://103.230.107.233";



        server1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Websites.class);
                intent.putExtra("links", urls[0]);
                startActivity(intent);
            }
        });

        server2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Websites.class);
                intent.putExtra("links", urls[1]);
                startActivity(intent);
            }
        });

        server3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Websites.class);
                intent.putExtra("links", urls[2]);
                startActivity(intent);
            }
        });

        server4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Websites.class);
                intent.putExtra("links", urls[3]);
                startActivity(intent);
            }
        });

        server5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Websites.class);
                intent.putExtra("links", urls[4]);
                startActivity(intent);
            }
        });

        server6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Websites.class);
                intent.putExtra("links", urls[5]);
                startActivity(intent);
            }
        });
    }
}