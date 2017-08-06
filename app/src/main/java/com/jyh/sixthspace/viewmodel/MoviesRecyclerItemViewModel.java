package com.jyh.sixthspace.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.jyh.sixthspace.model.VideoInfo;
import com.jyh.sixthspace.utlis.ImgLoadUtils;
import com.jyh.sixthspace.view.activity.MoviesTpyeListActivity;

/**
 * Created by Administrator on 2017/5/10.
 */

public class MoviesRecyclerItemViewModel extends BaseObservable{
    private VideoInfo info;
    private Context mContext;

    public MoviesRecyclerItemViewModel(VideoInfo info, Context mContext) {
        this.info=info;
        this.mContext=mContext;
    }
    public String getTitle(){
        return info.title;
    }
    public int getImgUrl() {
        return info.localPic;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, int url) {
        ImgLoadUtils.loadImgByUrlcenterCrop(imageView, url);
    }
    public void setData(VideoInfo info){
        this.info=info;
        notifyChange();
    }

    public void go2Activity(View view) {
        Intent intent=new Intent(mContext, MoviesTpyeListActivity.class);
        intent.putExtra("videoInfo", info);
        mContext.startActivity(intent);
    }
}
