package com.casa.letslearnandrecite.learn.hijaiyah;

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

public class HijaiyahActivity extends AppCompatActivity implements HurufAdapter.HurufClickListener {

    private List<Huruf> hurufList = new ArrayList<>();
    private RecyclerView hurufRecyclerView;
    private HurufAdapter hurufAdapter;
    private ImageView hurufImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);

        hurufImageView = findViewById(R.id.hurufImageView);

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

    public void isiDataHuruf() {
        //Tambah data ke RecyclerView
        hurufList.add(new Huruf("Alif", R.drawable.alif));
        hurufList.add(new Huruf("Ba", R.drawable.ba));
        hurufList.add(new Huruf("Ta", R.drawable.ta));
        hurufList.add(new Huruf("Sa", R.drawable.sa));
        hurufList.add(new Huruf("Ja", R.drawable.ja));
        hurufList.add(new Huruf("Ha", R.drawable.ha));
        hurufList.add(new Huruf("Kho", R.drawable.kho));
        hurufList.add(new Huruf("Da", R.drawable.da));
        hurufList.add(new Huruf("Dza", R.drawable.dza));
        hurufList.add(new Huruf("Ro", R.drawable.ro));
        hurufList.add(new Huruf("Dzal", R.drawable.dzal));
        hurufList.add(new Huruf("Sya", R.drawable.sya));
        hurufList.add(new Huruf("Syin", R.drawable.syin));
        hurufList.add(new Huruf("So", R.drawable.so));
        hurufList.add(new Huruf("Dot", R.drawable.dot));
        hurufList.add(new Huruf("To", R.drawable.to));
        hurufList.add(new Huruf("Zo", R.drawable.zo));
        hurufList.add(new Huruf("Ain", R.drawable.ain));
        hurufList.add(new Huruf("Goin", R.drawable.goin));
        hurufList.add(new Huruf("Fa", R.drawable.fa));
        hurufList.add(new Huruf("Qof", R.drawable.qof));
        hurufList.add(new Huruf("Kal", R.drawable.kal));
        hurufList.add(new Huruf("Lam", R.drawable.lam));
        hurufList.add(new Huruf("Mim", R.drawable.mim));
        hurufList.add(new Huruf("Nun", R.drawable.nun));
        hurufList.add(new Huruf("Wau", R.drawable.wau));
        hurufList.add(new Huruf("Haha", R.drawable.haha));
        hurufList.add(new Huruf("Ya", R.drawable.ya));
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


