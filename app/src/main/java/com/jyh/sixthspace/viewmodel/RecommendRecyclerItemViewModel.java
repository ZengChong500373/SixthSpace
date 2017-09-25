package com.jyh.sixthspace.viewmodel;


import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.jyh.sixthspace.SixthApplication;

import com.jyh.sixthspace.sdk.model.VideoInfo;
import com.jyh.sixthspace.sdk.utlis.ImgLoadUtils;
import com.jyh.sixthspace.view.activity.RecommendMovieInfosActivity;


/**
 * Created by Administrator on 2017/4/18.
 */

public class RecommendRecyclerItemViewModel extends BaseObservable {
    private VideoInfo info;
  private  Context mContext;
    public RecommendRecyclerItemViewModel(VideoInfo info, Context mContext) {
        this.info = info;
        this.mContext=mContext;
    }

    public String getTitle() {
        return info.title;
    }

    public String getImgUrl() {
        return info.pic;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        ImgLoadUtils.loadImgByUrlcenterCrop(imageView, url);
    }

    public void setData(VideoInfo info) {
        this.info = info;
        notifyChange();
    }
    public void go2Activity(View view) {
        Intent intent = new Intent(SixthApplication.getContext(), RecommendMovieInfosActivity.class);
        intent.putExtra("videoInfo", info);
        mContext.startActivity(intent);
    }

}
