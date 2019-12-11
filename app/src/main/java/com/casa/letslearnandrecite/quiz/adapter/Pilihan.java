package com.casa.letslearnandrecite.quiz.adapter;

public class Pilihan {
    private String pilih;
    private String jawab;

    public Pilihan(String pilih, String jawab) {
        this.pilih = pilih;
        this.jawab = jawab;
    }

    public String getPilih() {
        return pilih;
    }

    public void setPilih(String pilih) {
        this.pilih = pilih;
    }

    public String getJawab() {
        return jawab;
    }

    public void setJawab(String jawab) {
        this.jawab = jawab;
    }
}
