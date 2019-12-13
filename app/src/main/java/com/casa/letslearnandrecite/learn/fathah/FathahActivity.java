package com.casa.letslearnandrecite.learn.fathah;

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

public class FathahActivity extends AppCompatActivity implements HurufAdapter.HurufClickListener{

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
        //TODO GANTI ALIF FATHAH YAH
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
        hurufList.add(new Huruf("Alif Fathah", R.drawable.alif_kasroh, R.raw.alif_fathah));
        hurufList.add(new Huruf("Ba Fathah", R.drawable.ba_kasroh, R.raw.ba_fathah));
        hurufList.add(new Huruf("Ta Fathah", R.drawable.ta_kasroh, R.raw.ta));
        hurufList.add(new Huruf("Sa Fathah", R.drawable.sa_kasroh, R.raw.sa_fathah));
        hurufList.add(new Huruf("Ja Fathah", R.drawable.ja_kasroh, R.raw.ja_fathah));
        hurufList.add(new Huruf("Ha Fathah", R.drawable.ha_kasroh, R.raw.ha_fathah));
        hurufList.add(new Huruf("Kho Fathah", R.drawable.kho_kasroh, R.raw.kho_fathah));
        hurufList.add(new Huruf("Di Fathah", R.drawable.di_kasroh, R.raw.da_fathah));
        hurufList.add(new Huruf("Dza Fathah", R.drawable.dza_kasroh, R.raw.dza_fathah));
        hurufList.add(new Huruf("Ro Fathah", R.drawable.ro_kasroh, R.raw.ro_fathah));
        hurufList.add(new Huruf("Dzal Fathah", R.drawable.dzal_kasroh, R.raw.dzal_fathah));
        hurufList.add(new Huruf("Sya Fathah", R.drawable.sya_kasroh, R.raw.sya_fathah));
        hurufList.add(new Huruf("Syin Fathah", R.drawable.syin_kasroh,R.raw.sya_fathah));
        hurufList.add(new Huruf("So Fathah", R.drawable.so_kasroh, R.raw.so_fathah));
        hurufList.add(new Huruf("Dot Fathah", R.drawable.dot_kasroh, R.raw.do_fathah));
        hurufList.add(new Huruf("To Fathah", R.drawable.to_kasroh, R.raw.to));
        hurufList.add(new Huruf("Zo Fathah", R.drawable.zo_kasroh, R.raw.tzo_fathah));
        hurufList.add(new Huruf("Ain Fathah", R.drawable.ain_kasroh, R.raw.ain_fathah));
        //TODO GANTI SUARA GOIN FATHAH
        hurufList.add(new Huruf("Goin Fathah", R.drawable.goin_kasroh, R.raw.ain_fathah));
        hurufList.add(new Huruf("Fa Fathah", R.drawable.fa_kasroh, R.raw.fa_fathah));
        hurufList.add(new Huruf("Qof Fathah", R.drawable.qof_kasroh, R.raw.qof_fathah));
        hurufList.add(new Huruf("Kal Fathah", R.drawable.kal_kasroh, R.raw.kal_fathah));
        // TODO GANTI SUARA LAM FATHAH
        hurufList.add(new Huruf("Lam Fathah", R.drawable.lam_kasroh, R.raw.lam));
        hurufList.add(new Huruf("Mim Fathah", R.drawable.mim_kasroh, R.raw.mim_fathah));
        hurufList.add(new Huruf("Nun Fathah", R.drawable.nun_kasroh, R.raw.nun_fathah));
        hurufList.add(new Huruf("Wau Fathah", R.drawable.wau_kasroh, R.raw.wau_fathah));
        hurufList.add(new Huruf("Haha Fathah", R.drawable.haha_kasroh, R.raw.haha_fathah));
        hurufList.add(new Huruf("Ya Fathah", R.drawable.ya_kasroh, R.raw.ya_fathah));
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
