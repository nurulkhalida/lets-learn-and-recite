package com.casa.letslearnandrecite.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.casa.letslearnandrecite.R;
import com.casa.letslearnandrecite.learn.adapter.Quiz;
import com.casa.letslearnandrecite.quiz.adapter.Pilihan;
import com.casa.letslearnandrecite.quiz.adapter.PilihanAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuessHarakat extends AppCompatActivity implements PilihanAdapter.PilihanClickListener {

    MediaPlayer mpSuara;
    private RecyclerView pilihanRecyclerView;
    private PilihanAdapter pilihanAdapter;
    private List<Quiz> listQuiz = new ArrayList<>();
    private TextView soalTextView;
    private TextView scoreTextView;
    private TextView totalScoreTextView;
    private ImageView benarImageView;
    private ImageView salahImageView;
    private ConstraintLayout quizContainer;
    private ConstraintLayout totalScoreContainer;
    private int nomorSoal = 0;
    private ImageView backImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_harakat);
        hideSystemUI();
        soalTextView = findViewById(R.id.soalText);
        scoreTextView = findViewById(R.id.scoreTextView);
        benarImageView = findViewById(R.id.benarImageView);
        salahImageView = findViewById(R.id.salahImageView);
        quizContainer = findViewById(R.id.quizContainer);
        totalScoreContainer = findViewById(R.id.totalScoreContainer);
        totalScoreTextView = findViewById(R.id.totalScoreTextView);
        backImageView = findViewById(R.id.buttonQuizBack);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settingRecyclerView();
        isiQuiz();
        tampilkanPertanyaanBerikutnya();
    }

    @Override
    public void onPilihanClicked(Pilihan pilihan) {
        int score = Integer.parseInt(scoreTextView.getText().toString());
        String soal = soalTextView.getText().toString().toLowerCase();

        if (soal.equals(pilihan.getJawab())) {
            tampilkanBenar();
            score += 10;
            scoreTextView.setText(Integer.toString(score));
        } else {
            tampilkanSalah();
        }

        nomorSoal++;
        tampilkanPertanyaanBerikutnya();
    }

    private void tampilkanPertanyaanBerikutnya() {
        boolean adaSoalBerikutnya = nomorSoal < listQuiz.size();

        if (adaSoalBerikutnya) {
            Quiz quiz = listQuiz.get(nomorSoal);

            soalTextView.setText(quiz.getPertanyaan().getPilih());
            pilihanAdapter = new PilihanAdapter(quiz.getListPilihan(), this);
            //Masukin Adapter ke RecyclerView
            pilihanRecyclerView.setAdapter(pilihanAdapter);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    sembunyikanBenarSalah();
                }
            }, 1000);
        } else {
            tampilkanTotalScore();
        }
    }

    //TODO isi soal tebak harakat
    protected void isiQuiz() {
        //soal pertama
        bikinSoal(
            "Tsi",
            "ِ",
            "بِ",
            "bi",
            "ثِ",
            "tsi",
            "جَ",
            "jim"
        );

        //Soal kedua
        bikinSoal(
            "Zi",
            "",
            "زِ",
            "zi",
            "ضُ",
            "tsa",
            "جَ",
            "jim"
        );

        //soal ketiga
        bikinSoal(
            "Da",
            "",
            "عُ ",
            "uu",
            "فِ",
            "fi",
            "دَ",
            "da"
        );

        //soal keempat
        bikinSoal(
            "Dzu",
            "",
            "ذُ",
            "dzu",
            "ثَ",
            "tsa",
            "اِ",
            "ii"
        );

        //soal kelima
        bikinSoal(
            "Khi",
            "",
            "بُ ",
            "buu",
            "لَ",
            "laa",
            "خِ",
            "ii"
        );
    }

    public void bikinSoal(
        String pertanyaanYangDiTampilkan,
        String pertanyaan,
        String pilihanYangDiTampilkan1,
        String pilihanYangDiBandingkan1,
        String pilihanYangDiTampilkan2,
        String pilihanYangDiBandingkan2,
        String pilihanYangDiTampilkan3,
        String pilihanYangDiBandingkan3
    ) {
        List<Pilihan> pilihanList = new ArrayList<>();

        pilihanList.add(new Pilihan(pilihanYangDiTampilkan1, pilihanYangDiBandingkan1));
        pilihanList.add(new Pilihan(pilihanYangDiTampilkan2, pilihanYangDiBandingkan2));
        pilihanList.add(new Pilihan(pilihanYangDiTampilkan3, pilihanYangDiBandingkan3));

        listQuiz.add (
            new Quiz(
                new Pilihan(pertanyaanYangDiTampilkan, pertanyaan),
                pilihanList
            )
        );
    }

    private void kosonginSoal() {
        listQuiz = new ArrayList<>();
    }

    public void settingRecyclerView() {
        //Setting Recycler View supaya horizontal
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        pilihanRecyclerView = findViewById(R.id.pilihanRecyclerView);
        pilihanRecyclerView.setLayoutManager(mLayoutManager);
        pilihanRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void tampilkanBenar() {
        //Kalo ada suara yang play di hapus suara yang sebelumnya
        if (mpSuara != null && mpSuara.isPlaying()){
            //hapus suara sebelumnya
            mpSuara.release();
        }
        //masukin suara baru
        mpSuara = MediaPlayer.create(this, R.raw.sound_benar);
        //play suara
        mpSuara.start();

        salahImageView.setVisibility(View.INVISIBLE);
        benarImageView.setVisibility(View.VISIBLE);
    }

    private void tampilkanSalah() {
        //Kalo ada suara yang play di hapus suara yang sebelumnya
        if (mpSuara != null && mpSuara.isPlaying()){
            //hapus suara sebelumnya
            mpSuara.release();
        }
        //masukin suara baru
        mpSuara = MediaPlayer.create(this, R.raw.sound_salah);
        //play suara
        mpSuara.start();

        benarImageView.setVisibility(View.INVISIBLE);
        salahImageView.setVisibility(View.VISIBLE);
    }

    private void sembunyikanBenarSalah() {
        benarImageView.setVisibility(View.INVISIBLE);
        salahImageView.setVisibility(View.INVISIBLE);
    }

    private void tampilkanTotalScore() {
        String totalScore = scoreTextView.getText().toString();
        quizContainer.setVisibility(View.GONE);
        totalScoreContainer.setVisibility(View.VISIBLE);
        totalScoreTextView.setText(totalScore);
    }

    //Fullscreen
    private void hideSystemUI() {
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
}
