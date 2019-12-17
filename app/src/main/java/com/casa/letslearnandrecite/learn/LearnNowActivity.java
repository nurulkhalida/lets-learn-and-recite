package com.casa.letslearnandrecite.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.casa.letslearnandrecite.learn.fathah.DammahActivity;
import com.casa.letslearnandrecite.learn.fathah.FathahActivity;
import com.casa.letslearnandrecite.learn.kasroh.KasrohActivity;
import com.casa.letslearnandrecite.R;
import com.casa.letslearnandrecite.learn.hijaiyah.HijaiyahActivity;

public class LearnNowActivity extends AppCompatActivity {

MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_now);
        // TODO GANTI MUSIKNYA
        mp = MediaPlayer.create(this, R.raw.backsound_gollygee);

        playMusikBackground();

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

        ImageView buttonDammah = findViewById(R.id.buttonDammah);
        buttonDammah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LearnNowActivity.this, DammahActivity.class);
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

    private void playMusikBackground() {
        //Handler ini buat nge delay lagunya selama sedetik seblum play
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Mulai lagu
                mp.start();
            }
        }, 100);
    }
    @Override
    protected void onDestroy() {
        //Stop musiknya kalo aplikasinya di stop
        mp.stop();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        //Pause musiknya kalo aplikasinya di background
        mp.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        //Lanjutin muskinya kalo balik ke aplikasi
        mp.start();
        super.onResume();
    }
}

