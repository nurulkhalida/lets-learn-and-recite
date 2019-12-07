package com.casa.letslearnandrecite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HijaiyahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);

        ImageView buttonHijaiyah = findViewById(R.id.buttonHijaiyah);
        buttonHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HijaiyahActivity.this, BacaHijaiyahActivity.class);
                startActivity(myIntent);

            }
        });

        ImageView buttonKasroh = findViewById(R.id.buttonKasroh);
        buttonKasroh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HijaiyahActivity.this, KarsohActivity.class);
                startActivity(myIntent);
            }
        });

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

