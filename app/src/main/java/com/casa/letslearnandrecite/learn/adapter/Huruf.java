package com.casa.letslearnandrecite.learn.adapter;

public class Huruf {
    private String nama;
    private int gambar;
    private int suara;

    public Huruf() {
    }

    public Huruf(String nama, int gambar, int suara) {
        this.nama = nama;
        this.gambar = gambar;
        this.suara = suara;
    }

    public Huruf(String nama, int gambar) {
        this.nama = nama;
        this.gambar = gambar;
        this.suara = -1;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getSuara() {
        return suara;
    }

    public void setSuara(int suara) {
        this.suara = suara;
    }
}
