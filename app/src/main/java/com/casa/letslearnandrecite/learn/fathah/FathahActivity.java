package com.casa.letslearnandrecite.learn.fathah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    }
    //TODO NANTI DI UPDATE YAH
    public void isiDataHuruf() {
        //Tambah data ke RecyclerView
        hurufList.add(new Huruf("Alif Kasroh", R.drawable.alif_kasroh));
        hurufList.add(new Huruf("Ba Kasroh", R.drawable.ba_kasroh));
        hurufList.add(new Huruf("Ta Kasroh", R.drawable.ta_kasroh));
        hurufList.add(new Huruf("Sa Kasroh", R.drawable.sa_kasroh));
        hurufList.add(new Huruf("Ja Kasroh", R.drawable.ja_kasroh));
        hurufList.add(new Huruf("Ha Kasroh", R.drawable.ha_kasroh));
        hurufList.add(new Huruf("Kho Kasroh", R.drawable.kho_kasroh));
        hurufList.add(new Huruf("Di Kasroh", R.drawable.di_kasroh));
        hurufList.add(new Huruf("Dza Kasroh", R.drawable.dza_kasroh));
        hurufList.add(new Huruf("Ro Kasroh", R.drawable.ro_kasroh));
        hurufList.add(new Huruf("Dzal Kasroh", R.drawable.dzal_kasroh));
        hurufList.add(new Huruf("Sya Kasroh", R.drawable.sya_kasroh));
        hurufList.add(new Huruf("Syin Kasroh", R.drawable.syin_kasroh));
        hurufList.add(new Huruf("So Kasroh", R.drawable.so_kasroh));
        hurufList.add(new Huruf("Dot Kasroh", R.drawable.dot_kasroh));
        hurufList.add(new Huruf("To Kasroh", R.drawable.to_kasroh));
        hurufList.add(new Huruf("Zo Kasroh", R.drawable.zo_kasroh));
        hurufList.add(new Huruf("Ain Kasroh", R.drawable.ain_kasroh));
        hurufList.add(new Huruf("Goin Kasroh", R.drawable.goin_kasroh));
        hurufList.add(new Huruf("Fa Kasroh", R.drawable.fa_kasroh));
        hurufList.add(new Huruf("Qof Kasroh", R.drawable.qof_kasroh));
        hurufList.add(new Huruf("Kal Kasroh", R.drawable.kal_kasroh));
        hurufList.add(new Huruf("Lam Kasroh", R.drawable.lam_kasroh));
        hurufList.add(new Huruf("Mim Kasroh", R.drawable.mim_kasroh));
        hurufList.add(new Huruf("Nun Kasroh", R.drawable.nun_kasroh));
        hurufList.add(new Huruf("Wau Kasroh", R.drawable.wau_kasroh));
        hurufList.add(new Huruf("Haha Kasroh", R.drawable.haha_kasroh));
        hurufList.add(new Huruf("Ya Kasroh", R.drawable.ya_kasroh));
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
