package com.casa.letslearnandrecite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.casa.letslearnandrecite.learn.LearnNowActivity;

public class MainActivity extends AppCompatActivity {

    //Bikin Media Player kalo mau mainin musik
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();
        //Pilih lagunya disini
        mp = MediaPlayer.create(this, R.raw.contoh_musik);

        playMusikBackground();

        ImageView learnNowButton = findViewById(R.id.learnNowButton);
        learnNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, LearnNowActivity.class);
                startActivity(myIntent);
            }
        });


        ImageView closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO masukin fungsi setting button loh
                Toast.makeText(getApplicationContext(), "ini setting button yaa", Toast.LENGTH_SHORT).show();
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

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
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
