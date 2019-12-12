package com.casa.letslearnandrecite.quiz;

import android.os.Bundle;
import com.casa.letslearnandrecite.R;

public class GuessReading extends GuessHarakat {

    //TODO isi soal Tebak Bacaan
    @Override
    protected void isiQuiz() {
        //soal pertama
        bikinSoal(
            "Jim",
            "ِ",
            "ب",
            "ba",
            "ف",
            "fa",
            "ج",
            "jim"
        );

        //Soal kedua
        bikinSoal(
            "Ghain",
            "",
            "غ",
            "ghain",
            "ض",
            "dho",
            "ل",
            "lam"
        );

        //soal ketiga
        bikinSoal(
            "Tha",
            "",
            "ض",
            "dha",
            "ط",
            "tha",
            "ز",
            "za"
        );

        //soal keempat
        bikinSoal(
            "Fa",
            "",
            "ف",
            "fa",
            "ت",
            "ta",
            "د",
            "dal"
        );

        //soal kelima
        bikinSoal(
            "Waw",
            "",
            "ء",
            "hamzah",
            "ع",
            "ain",
            "و",
            "waw"
        );
    }
}
