package com.casa.letslearnandrecite.quiz;

public class GuessLetter extends GuessHarakat {

    //TODO isi soal Tebak Bacaan
    @Override
    protected void isiQuiz() {
        //soal pertama
        bikinSoal(
                "نَ",
                "ِ",
                "bi",
                "بِ ",
                "lu",
                "لُ ",
                "na",
                "نَ"
        );

        //Soal kedua
        bikinSoal(
                "سُ",
                "",
                "su",
                "سُ",
                "yi",
                "يِ",
                "taَ",
                "تَ"
        );

        //soal ketiga
        bikinSoal(
                "هِ",
                "",
                "dhu",
                "ضُ",
                "gha",
                "غَ",
                "hi",
                "هِ"
        );

        //soal keempat
        bikinSoal(
                "ظُ",
                "",
                "zhu",
                "ظُ",
                "ra",
                "رَ",
                "hi",
                "حِ"
        );

        //soal kelima
        bikinSoal(
                "فِ",
                "",
                "na",
                "نَ",
                "fi",
                "فِ",
                "ku",
                "كُ"
        );
    }
}