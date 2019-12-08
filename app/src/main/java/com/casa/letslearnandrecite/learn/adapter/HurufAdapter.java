package com.casa.letslearnandrecite.learn.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.casa.letslearnandrecite.R;

import java.util.List;

public class HurufAdapter extends RecyclerView.Adapter<HurufAdapter.HurufViewHolder> {

    public interface HurufClickListener {
        void onHurufClicked(Huruf huruf);
    }

    private List<Huruf> hurufList;
    private HurufClickListener clickListener;

    public class HurufViewHolder extends RecyclerView.ViewHolder {
        public ImageView hurufImageView;

        public HurufViewHolder(View view) {
            super(view);
            hurufImageView = view.findViewById(R.id.hurufImageView);
        }
    }


    public HurufAdapter(List<Huruf> hurufList, HurufClickListener clickListener) {
        this.hurufList = hurufList;
        this.clickListener = clickListener;
    }

    @Override
    public HurufViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_huruf, parent, false);

        return new HurufViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HurufViewHolder holder, int position) {
        final Huruf huruf = hurufList.get(position);
        holder.hurufImageView.setImageResource(huruf.getGambar());
        holder.hurufImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onHurufClicked(huruf);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hurufList.size();
    }
}
