package com.h5200002.berfin_meryem_tuzcu_final.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.h5200002.berfin_meryem_tuzcu_final.R;
import com.h5200002.berfin_meryem_tuzcu_final.model.SongModel;
import com.h5200002.berfin_meryem_tuzcu_final.util.Constans;
import com.h5200002.berfin_meryem_tuzcu_final.util.GlideUtil;
import com.h5200002.berfin_meryem_tuzcu_final.util.ObjectUtil;

public class DetailActivity extends AppCompatActivity {

    ImageView imgCover;
    TextView txtTitle;
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }




    private void init(){
        String clickSongString= getIntent().getStringExtra(Constans.CLICK_SONG);
        SongModel songModel= ObjectUtil.jsonStringSong(clickSongString);

        imgCover= findViewById(R.id.imgCover);
        txtTitle=findViewById(R.id.txtTitle);
        txtDetail=findViewById(R.id.txtDetail);



        txtTitle.setText(songModel.getName());
        txtDetail.setText(songModel.getExplanation());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),songModel.getImgCover(),imgCover);



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            txtTitle.setText(Html.fromHtml(songModel.getName(),Html.FROM_HTML_MODE_COMPACT));
            txtDetail.setText(Html.fromHtml(songModel.getExplanation(),Html.FROM_HTML_MODE_COMPACT));
        }
        else
        {
            txtTitle.setText(Html.fromHtml(songModel.getName()));
            txtDetail.setText(Html.fromHtml(songModel.getExplanation()));

        }

    }

}