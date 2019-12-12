package com.casa.letslearnandrecite.quiz;

import android.os.Bundle;
import com.casa.letslearnandrecite.R;

public class GuessReading extends GuessHarakat {

    //TODO isi soal Tebak Bacaan
    @Override
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
    }
}
