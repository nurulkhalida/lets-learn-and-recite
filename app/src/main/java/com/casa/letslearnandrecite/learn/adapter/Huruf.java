package com.casa.letslearnandrecite.learn.adapter;

public class Huruf {
    private String nama;
    private int gambar;

    public Huruf() {
    }

    public Huruf(String nama, int gambar) {
        this.nama = nama;
        this.gambar = gambar;
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
}
