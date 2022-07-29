package com.h5200002.berfin_meryem_tuzcu_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200002.berfin_meryem_tuzcu_final.R;

public class SongViewHolder extends RecyclerView.ViewHolder {
    ImageView imgSong;
    TextView txtName;
    TextView txtAlbum;
    TextView txtYear;

    public SongViewHolder(@NonNull View itemView) {
        super(itemView);
        imgSong=itemView.findViewById(R.id.imgSong);
        txtName= itemView.findViewById(R.id.txtName);
        txtAlbum= itemView.findViewById(R.id.txtAlbum);
        txtYear= itemView.findViewById(R.id.txtYear);
    }
}
