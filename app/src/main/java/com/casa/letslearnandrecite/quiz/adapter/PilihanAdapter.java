package com.casa.letslearnandrecite.quiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.casa.letslearnandrecite.R;

import java.util.List;

public class PilihanAdapter extends RecyclerView.Adapter<PilihanAdapter.PilihanViewHolder> {

    public interface PilihanClickListener {
        void onPilihanClicked(Pilihan pilihan);
    }

    private List<Pilihan> pilihanList;
    private PilihanAdapter.PilihanClickListener clickListener;

    public class PilihanViewHolder extends RecyclerView.ViewHolder {
        public TextView pilihanTextView;

        public PilihanViewHolder(View view) {
            super(view);
            pilihanTextView = view.findViewById(R.id.bg_quiz_option);
        }
    }


    public PilihanAdapter(List<Pilihan> pilihanList, PilihanAdapter.PilihanClickListener clickListener) {
        this.pilihanList = pilihanList;
        this.clickListener = clickListener;
    }

    @Override
    public PilihanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quiz_pilihan, parent, false);

        return new PilihanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PilihanViewHolder holder, int position) {
        final Pilihan pilihan = pilihanList.get(position);
        holder.pilihanTextView.setText(pilihan.getPilih());
        holder.pilihanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPilihanClicked(pilihan);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pilihanList.size();
    }
}
