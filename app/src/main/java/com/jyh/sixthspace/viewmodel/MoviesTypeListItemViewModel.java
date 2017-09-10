package com.jyh.sixthspace.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;


import com.jyh.sixthspace.SixthApplication;
import com.jyh.sixthspace.model.VideoInfo;
import com.jyh.sixthspace.model.VideoType;
import com.jyh.sixthspace.utlis.ImgLoadUtils;
import com.jyh.sixthspace.view.activity.MovieDetailsActivity;
import com.jyh.sixthspace.view.activity.RecommendMovieInfosActivity;

/**
 * Created by Administrator on 2017/5/22.
 */

public class MoviesTypeListItemViewModel extends BaseObservable {
    private VideoType info;
    private Context mContext;

    public MoviesTypeListItemViewModel(VideoType info, Context mContext) {
        this.info=info;
        this.mContext=mContext;
    }
    public String getTitle(){
        return info.title;
    }
    public String getImgUrl() {
        return info.pic;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, int url) {
        ImgLoadUtils.loadImgByUrlcenterCrop(imageView, url);
    }
    public void setData(VideoType info){
        this.info=info;
        notifyChange();
    }

    public void go2Activity(View view) {
        Intent intent = new Intent(SixthApplication.getContext(), RecommendMovieInfosActivity.class);
        VideoInfo videoInfo=new VideoInfo();
        videoInfo.setDataId(info.dataId);
        intent.putExtra("videoInfo", videoInfo);
        mContext.startActivity(intent);
    }
}
