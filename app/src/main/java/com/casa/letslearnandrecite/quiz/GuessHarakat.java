package com.casa.letslearnandrecite.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.casa.letslearnandrecite.R;
import com.casa.letslearnandrecite.learn.adapter.Quiz;
import com.casa.letslearnandrecite.quiz.adapter.Pilihan;
import com.casa.letslearnandrecite.quiz.adapter.PilihanAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuessHarakat extends AppCompatActivity implements PilihanAdapter.PilihanClickListener {

    private RecyclerView pilihanRecyclerView;
    private PilihanAdapter pilihanAdapter;
    private List<Quiz> listQuiz = new ArrayList<>();
    private TextView soalTextView;
    private TextView scoreTextView;
    private int nomorSoal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_harakat);
        hideSystemUI();
        soalTextView = findViewById(R.id.soalText);
        scoreTextView = findViewById(R.id.scoreTextView);

        isiQuiz();
        tampilkanQuiz();
        settingRecyclerView();
    }

    @Override
    public void onPilihanClicked(Pilihan pilihan) {
        int score = Integer.parseInt(scoreTextView.getText().toString());
        String soal = soalTextView.getText().toString().toLowerCase();
        String hasil = "";

        if (soal.equals(pilihan.getJawab())) {
            score += 10;
            hasil = "Betul";
        } else {
            hasil = "Salah";
        }

        scoreTextView.setText(Integer.toString(score));
        Toast.makeText(getApplicationContext(), hasil, Toast.LENGTH_SHORT).show();
    }

    private void tampilkanQuiz() {
        boolean adaSoalBerikutnya = nomorSoal < listQuiz.size();

        if (adaSoalBerikutnya) {
            Quiz quiz = listQuiz.get(nomorSoal);

            soalTextView.setText(quiz.getPertanyaan().getPilih());
            pilihanAdapter = new PilihanAdapter(quiz.getListPilihan(), this);
        }
    }

    private void isiQuiz() {
        //soal pertama
        bikinSoal(
            "Bi",
                "بِ",
                "ب",
                "bi",
                "ثَ",
                "tsa",
                "جَ",
                "jim"
        );
    }

    private void bikinSoal(
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
        //Masukin Adapter ke RecyclerView
        pilihanRecyclerView.setAdapter(pilihanAdapter);
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
