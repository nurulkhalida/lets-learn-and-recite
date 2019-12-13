package com.casa.letslearnandrecite.learn.kasroh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.casa.letslearnandrecite.R;
import com.casa.letslearnandrecite.learn.adapter.Huruf;
import com.casa.letslearnandrecite.learn.adapter.HurufAdapter;

import java.util.ArrayList;
import java.util.List;

public class KasrohActivity extends AppCompatActivity implements HurufAdapter.HurufClickListener  {

    private List<Huruf> hurufList = new ArrayList<>();
    private RecyclerView hurufRecyclerView;
    private HurufAdapter hurufAdapter;
    private ImageView hurufImageView;

    MediaPlayer mpSuara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);

        hurufImageView = findViewById(R.id.hurufImageView);
        hurufImageView.setImageResource(R.drawable.alif_kasroh);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        isiDataHuruf();
        settingRecyclerView();
    }

    @Override
    public void onHurufClicked(Huruf huruf) {
        //Ganti gambar hurufnya setiap di click
        hurufImageView.setImageResource(huruf.getGambar());

        if (mpSuara != null && mpSuara.isPlaying()){
            //hapus suara sebelumnya
            mpSuara.release();
        }
        //masukin suara baru
        mpSuara = MediaPlayer.create(this, huruf.getSuara());
        //play suara
        mpSuara.start();
    }

    public void isiDataHuruf() {
        //Tambah data ke RecyclerView
        hurufList.add(new Huruf("Alif Kasroh", R.drawable.alif_kasroh, R.raw.alif_kasroh));
        hurufList.add(new Huruf("Ba Kasroh", R.drawable.ba_kasroh, R.raw.ba_kasroh));
        hurufList.add(new Huruf("Ta Kasroh", R.drawable.ta_kasroh, R.raw.ta_kasroh));
        hurufList.add(new Huruf("Sa Kasroh", R.drawable.sa_kasroh, R.raw.tsa_kasroh));
        hurufList.add(new Huruf("Ja Kasroh", R.drawable.ja_kasroh, R.raw.ja_kasroh));
        hurufList.add(new Huruf("Ha Kasroh", R.drawable.ha_kasroh, R.raw.ha_kasroh));
        hurufList.add(new Huruf("Kho Kasroh", R.drawable.kho_kasroh, R.raw.kho_kasroh));
        hurufList.add(new Huruf("Di Kasroh", R.drawable.di_kasroh, R.raw.da_kasroh));
        hurufList.add(new Huruf("Dza Kasroh", R.drawable.dza_kasroh, R.raw.dza_kasroh));
        hurufList.add(new Huruf("Ro Kasroh", R.drawable.ro_kasroh, R.raw.ro_kasroh));
        hurufList.add(new Huruf("Dzal Kasroh", R.drawable.dzal_kasroh, R.raw.dzal_kasroh));
        hurufList.add(new Huruf("Sya Kasroh", R.drawable.sya_kasroh, R.raw.sya_kasroh));
        hurufList.add(new Huruf("Syin Kasroh", R.drawable.syin_kasroh, R.raw.syin_kasroh));
        hurufList.add(new Huruf("So Kasroh", R.drawable.so_kasroh, R.raw.so_kasroh));
        hurufList.add(new Huruf("Dot Kasroh", R.drawable.dot_kasroh, R.raw.do_kasroh));
        hurufList.add(new Huruf("To Kasroh", R.drawable.to_kasroh, R.raw.to_kasroh));
        hurufList.add(new Huruf("Zo Kasroh", R.drawable.zo_kasroh, R.raw.tzo_kasroh));
        hurufList.add(new Huruf("Ain Kasroh", R.drawable.ain_kasroh, R.raw.ain_kasroh));
        //TODO INPUT SUARA GOIN KASROH
        hurufList.add(new Huruf("Goin Kasroh", R.drawable.goin_kasroh, R.raw.alif));
        hurufList.add(new Huruf("Fa Kasroh", R.drawable.fa_kasroh, R.raw.fa_kasroh));
        hurufList.add(new Huruf("Qof Kasroh", R.drawable.qof_kasroh, R.raw.qof_kasroh));
        hurufList.add(new Huruf("Kal Kasroh", R.drawable.kal_kasroh, R.raw.kal_kasroh));
        hurufList.add(new Huruf("Lam Kasroh", R.drawable.lam_kasroh, R.raw.lam_kasroh));
        hurufList.add(new Huruf("Mim Kasroh", R.drawable.mim_kasroh, R.raw.mim_kasroh));
        hurufList.add(new Huruf("Nun Kasroh", R.drawable.nun_kasroh, R.raw.nun_kasroh));
        hurufList.add(new Huruf("Wau Kasroh", R.drawable.wau_kasroh, R.raw.wau_kasroh));
        hurufList.add(new Huruf("Haha Kasroh", R.drawable.haha_kasroh, R.raw.haha_kasroh));
        hurufList.add(new Huruf("Ya Kasroh", R.drawable.ya_kasroh, R.raw.ya_kasroh));
    }

    public void settingRecyclerView() {
        //Setting Recycler View supaya horizontal
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        hurufRecyclerView = findViewById(R.id.hurufHijaiyahRecyclerView);
        //Masukin data hurufList ke adapter
        hurufAdapter = new HurufAdapter(hurufList, this);
        hurufRecyclerView.setLayoutManager(mLayoutManager);
        hurufRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //Masukin Adapter ke RecyclerView
        hurufRecyclerView.setAdapter(hurufAdapter);
    }
}
