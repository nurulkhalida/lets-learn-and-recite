package com.casa.letslearnandrecite.learn.adapter;

import com.casa.letslearnandrecite.quiz.adapter.Pilihan;

import java.util.List;

public class Quiz {
    private Pilihan pertanyaan;
    private List<Pilihan> listPilihan;

    public Quiz(Pilihan pertanyaan, List<Pilihan> pilihan) {
        this.pertanyaan = pertanyaan;
        this.listPilihan = pilihan;
    }

    public Pilihan getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(Pilihan pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public List<Pilihan> getListPilihan() {
        return listPilihan;
    }

    public void setListPilihan(List<Pilihan> listPilihan) {
        this.listPilihan = listPilihan;
    }
}
