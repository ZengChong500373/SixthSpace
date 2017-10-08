package com.jyh.sixthspace.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.jyh.sixthspace.sdk.bean.live.HomeHotColumn;
import com.jyh.sixthspace.sdk.utlis.ImgLoadUtils;
import com.jyh.sixthspace.sdk.utlis.ToastUtils;

/**
 * Created by Administrator on 2017/10/9.
 */

public class LiveReHotViewModel extends BaseObservable {
    private HomeHotColumn info;
    private Context mContext;
    public LiveReHotViewModel(HomeHotColumn info, Context mContext) {
        this.info=info;
        this.mContext=mContext;
    }
    public String getImgUrl() {
        return info.getRoom_src();
    }
    public String getRoomName(){
        return info.getRoom_name();
    }
    public String getNickName(){
        return info.getNickname();
    }
    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        ImgLoadUtils.loadImgByUrlcenterCrop(imageView, url);
    }
    public void setData(HomeHotColumn info) {
        this.info = info;
        notifyChange();
    }
    public void go2Activity(View view) {
//        Intent intent = new Intent(SixthApplication.getContext(), RecommendMovieInfosActivity.class);
//        intent.putExtra("videoInfo", info);
//        mContext.startActivity(intent);
        ToastUtils.getInstance().show("LiveReHotViewModel");
    }
}
