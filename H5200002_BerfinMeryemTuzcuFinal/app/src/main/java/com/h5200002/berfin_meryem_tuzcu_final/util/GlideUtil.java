package com.h5200002.berfin_meryem_tuzcu_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GlideUtil {
    public static void resmiIndiripGoster (Context context, String imgUrl, ImageView whichImageView )
    {
        Glide.with(context)
                .load( imgUrl)
                .centerCrop()
                .into( whichImageView );
    }


}
