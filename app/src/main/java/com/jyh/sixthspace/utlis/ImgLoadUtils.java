package com.jyh.sixthspace.utlis;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jyh.sixthspace.R;
import com.jyh.sixthspace.SixthApplication;

/**
 * Created by Administrator on 2017/4/27.
 */

public class ImgLoadUtils {
    public static  void loadImgByUrl( ImageView imageView,String url){
        Glide.with(SixthApplication.getContext()).load(url).into(imageView);
    }
    public static  void loadImgByUrlfitCenter( ImageView imageView,String url){
        Glide.with(SixthApplication.getContext()).load(url).fitCenter().placeholder(R.color.alpha_15_white).into(imageView);
    }
    public static  void loadImgByUrlfitCenter( ImageView imageView,int url){
        Glide.with(SixthApplication.getContext()).load(url).fitCenter().placeholder(R.color.alpha_15_white).into(imageView);
    }
    public static  void loadImgByUrlcenterCrop( ImageView imageView,String url){
        Glide.with(SixthApplication.getContext()).load(url).centerCrop().placeholder(R.color.alpha_15_white).into(imageView);
    }

    public static  void loadImgByUrlcenterCrop( ImageView imageView,int url){
        Glide.with(SixthApplication.getContext()).load(url).centerCrop().placeholder(R.color.alpha_15_white).into(imageView);
    }

}
