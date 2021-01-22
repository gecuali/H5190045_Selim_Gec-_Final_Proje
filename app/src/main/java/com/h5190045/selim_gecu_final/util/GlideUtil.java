package com.h5190045.selim_gecu_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190045.selim_gecu_final.R;


public class GlideUtil {
    //Verilen URL'den resmi indirir ve gerekli resim yerlerine atar
    public  static  void downloadImageAndShow(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
