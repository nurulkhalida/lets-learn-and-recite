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
        hurufList.add(new Huruf("Alif", R.drawable.alifdom, R.raw.alif_dammah));
        hurufList.add(new Huruf("Ba", R.drawable.baadom, R.raw.ba_dammah));
        hurufList.add(new Huruf("Ta", R.drawable.taadom, R.raw.ta_dammah));
        hurufList.add(new Huruf("Sa", R.drawable.tsudom, R.raw.tsa_dammah));
        hurufList.add(new Huruf("Ja", R.drawable.jaadom, R.raw.ja_dammah));
        hurufList.add(new Huruf("Ha", R.drawable.haadom, R.raw.ha_dammah));
        hurufList.add(new Huruf("Kho", R.drawable.khodom, R.raw.kho_dammah));
        hurufList.add(new Huruf("Da", R.drawable.daadom, R.raw.da_dammah));
        hurufList.add(new Huruf("Da", R.drawable.dzuu, R.raw.dza_dammah));
        hurufList.add(new Huruf("Da", R.drawable.raadom, R.raw.ro_dammah));
        hurufList.add(new Huruf("Da", R.drawable.zuu, R.raw.dzal_dammah));
        hurufList.add(new Huruf("Da", R.drawable.sun, R.raw.sa_dammah));
        hurufList.add(new Huruf("Da", R.drawable.syaadom, R.raw.sya_dammah));
        hurufList.add(new Huruf("Da", R.drawable.shoddom, R.raw.so_dammah));
        hurufList.add(new Huruf("Da", R.drawable.dhoddom, R.raw.do_dammah));
        hurufList.add(new Huruf("Da", R.drawable.thodom, R.raw.to_dammah));
        hurufList.add(new Huruf("Da", R.drawable.zaadom, R.raw.tzo_dammah));
        hurufList.add(new Huruf("Da", R.drawable.aindom, R.raw.ain_dammah));
        hurufList.add(new Huruf("Da", R.drawable.faadom, R.raw.fa_dammah));
        hurufList.add(new Huruf("Da", R.drawable.qoodom, R.raw.qof_dammah));
        hurufList.add(new Huruf("Da", R.drawable.kafdom, R.raw.kal_dammah));
        hurufList.add(new Huruf("Da", R.drawable.lamdom, R.raw.lam_dammah));
        hurufList.add(new Huruf("Da", R.drawable.mimdom, R.raw.mim_dammah));
        hurufList.add(new Huruf("Da", R.drawable.nundom, R.raw.nun_dammah));
        hurufList.add(new Huruf("Da", R.drawable.waadom, R.raw.wau_dammah));
        hurufList.add(new Huruf("Da", R.drawable.haadom, R.raw.ha_dammah));
        hurufList.add(new Huruf("Da", R.drawable.yaadom, R.raw.ya_dammah));
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

