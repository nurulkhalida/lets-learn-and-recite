package com.casa.letslearnandrecite.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.casa.letslearnandrecite.learn.fathah.FathahActivity;
import com.casa.letslearnandrecite.learn.kasroh.KasrohActivity;
import com.casa.letslearnandrecite.R;
import com.casa.letslearnandrecite.learn.hijaiyah.HijaiyahActivity;

public class LearnNowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_now);

        ImageView buttonHijaiyah = findViewById(R.id.buttonHijaiyah);
        buttonHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LearnNowActivity.this, HijaiyahActivity.class);
                startActivity(myIntent);

            }
        });

        ImageView buttonKasroh = findViewById(R.id.buttonKasroh);
        buttonKasroh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LearnNowActivity.this, KasrohActivity.class);
                startActivity(myIntent);
            }
        });

        ImageView buttonFathah = findViewById(R.id.buttonFathah);
        buttonFathah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LearnNowActivity.this, FathahActivity.class);
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

