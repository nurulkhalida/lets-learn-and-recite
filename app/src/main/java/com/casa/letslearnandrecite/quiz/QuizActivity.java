package com.casa.letslearnandrecite.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.casa.letslearnandrecite.R;

public class QuizActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mp = MediaPlayer.create(this, R.raw.backsound_gollygee);
        playMusikBackground();
        hideSystemUI();

        ImageView tebakHarakat = findViewById(R.id.tebaHarakat);
        tebakHarakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(QuizActivity.this, GuessHarakat.class);
                startActivity(myIntent);

            }
        });
        ImageView tebakBacaan = findViewById(R.id.tebakBacaan);
        tebakBacaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(QuizActivity.this, GuessReading.class);
                startActivity(myIntent);

            }
        });
        ImageView tebakHuruf = findViewById(R.id.tebakHuruf);
        tebakHuruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(QuizActivity.this, GuessLetter. class);
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

    //Fullscreen
    private void hideSystemUI()  {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
    private void playMusikBackground() {
        mp.start();
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