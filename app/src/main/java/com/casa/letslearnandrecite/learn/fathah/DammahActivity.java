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

public class DammahActivity extends AppCompatActivity  implements HurufAdapter.HurufClickListener {

    private List<Huruf> hurufList = new ArrayList<>();
    private RecyclerView hurufRecyclerView;
    private HurufAdapter hurufAdapter;
    private ImageView hurufImageView;

    //Bikin Media Player kalo mau mainin musik
    MediaPlayer mpSuara;

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

        //Kalo ada suara yang play di hapus suara yang sebelumnya
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
        hurufList.add(new Huruf("Alif", R.drawable.alif, R.raw.alif));
        hurufList.add(new Huruf("Ba", R.drawable.ba, R.raw.ba));
        hurufList.add(new Huruf("Ta", R.drawable.ta, R.raw.ta));
        hurufList.add(new Huruf("Sa", R.drawable.sa, R.raw.tsa));
        hurufList.add(new Huruf("Ja", R.drawable.ja, R.raw.ja));
        hurufList.add(new Huruf("Ha", R.drawable.ha, R.raw.ha));
        hurufList.add(new Huruf("Kho", R.drawable.kho, R.raw.kho));
        hurufList.add(new Huruf("Da", R.drawable.da, R.raw.da));
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


