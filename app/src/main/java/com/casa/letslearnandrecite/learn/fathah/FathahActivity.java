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
        hurufImageView.setImageResource(R.drawable.alifkas);

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
        hurufList.add(new Huruf("Alif Fathah", R.drawable.alifkas, R.raw.alif_fathah));
        hurufList.add(new Huruf("Ba Fathah", R.drawable.bakas, R.raw.ba_fathah));
        hurufList.add(new Huruf("Ta Fathah", R.drawable.taakas, R.raw.ta));
        hurufList.add(new Huruf("Sa Fathah", R.drawable.tsaakas, R.raw.sa_fathah));
        hurufList.add(new Huruf("Ja Fathah", R.drawable.jaakas, R.raw.ja_fathah));
        hurufList.add(new Huruf("Ha Fathah", R.drawable.haakas, R.raw.ha_fathah));
        hurufList.add(new Huruf("Kho Fathah", R.drawable.khookas, R.raw.kho_fathah));
        hurufList.add(new Huruf("Di Fathah", R.drawable.daakas, R.raw.da_fathah));
        hurufList.add(new Huruf("Dza Fathah", R.drawable.dzakas, R.raw.dza_fathah));
        hurufList.add(new Huruf("Ro Fathah", R.drawable.raakas, R.raw.ro_fathah));
        hurufList.add(new Huruf("Dzal Fathah", R.drawable.zalkas, R.raw.dzal_fathah));
        hurufList.add(new Huruf("Sya Fathah", R.drawable.sinkas, R.raw.sya_fathah));
        hurufList.add(new Huruf("Syin Fathah", R.drawable.syakas,R.raw.sya_fathah));
        hurufList.add(new Huruf("So Fathah", R.drawable.shodkas, R.raw.so_fathah));
        hurufList.add(new Huruf("Dot Fathah", R.drawable.dhodkas, R.raw.do_fathah));
        hurufList.add(new Huruf("To Fathah", R.drawable.thokas, R.raw.to));
        hurufList.add(new Huruf("Zo Fathah", R.drawable.zhokas, R.raw.tzo_fathah));
        hurufList.add(new Huruf("Ain Fathah", R.drawable.ainkas, R.raw.ain_fathah));
        hurufList.add(new Huruf("Goin Fathah", R.drawable.ghokas, R.raw.ain_kasroh));
        hurufList.add(new Huruf("Fa Fathah", R.drawable.faakas, R.raw.fa_kasroh));
        hurufList.add(new Huruf("Qof Fathah", R.drawable.qookas, R.raw.qof_fathah));
        hurufList.add(new Huruf("Kal Fathah", R.drawable.kaakas, R.raw.kal_fathah));
        hurufList.add(new Huruf("Lam Fathah", R.drawable.laakas, R.raw.lam));
        hurufList.add(new Huruf("Mim Fathah", R.drawable.maakas, R.raw.mim_fathah));
        hurufList.add(new Huruf("Nun Fathah", R.drawable.na, R.raw.nun_fathah));
        hurufList.add(new Huruf("Wau Fathah", R.drawable.waukas, R.raw.wau_fathah));
        hurufList.add(new Huruf("Haha Fathah", R.drawable.haaakas, R.raw.haha_fathah));
        hurufList.add(new Huruf("Ya Fathah", R.drawable.yaakas, R.raw.ya_fathah));
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
