package com.h5200002.berfin_meryem_tuzcu_final.adaptor;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;



import com.h5200002.berfin_meryem_tuzcu_final.R;

import com.h5200002.berfin_meryem_tuzcu_final.model.SongModel;
import com.h5200002.berfin_meryem_tuzcu_final.util.GlideUtil;


public class SongAdaptor extends RecyclerView.Adapter<SongViewHolder> {

    List<SongModel> songs;
    Context context;
    OnItemClickListener onItemClickListener;




    public interface OnItemClickListener {

        void onItemClick(SongModel clickSong);

        void onClick(int position);
    }

    public SongAdaptor(List<SongModel> songs, Context context, OnItemClickListener onItemClickListener) {
        this.songs = songs;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_song, parent,false);
        SongViewHolder songViewHolder =new SongViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(songs.get(songViewHolder.getAdapterPosition()));
            }
        });

        return songViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder viewHolder, int position) {

        viewHolder.txtName.setText(songs.get(position).getName());
        viewHolder.txtAlbum.setText(songs.get(position).getAlbum());
        viewHolder.txtYear.setText(songs.get(position).getYear());


        GlideUtil.resmiIndiripGoster(context, songs.get(position).getResimURL(),viewHolder.imgSong);
    }

    @Override
    public int getItemCount() {

        return songs.size();
    }


}

