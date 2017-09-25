package com.jyh.sixthspace.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jyh.sixthspace.sdk.model.VideoInfo;
import com.jyh.sixthspace.sdk.utlis.ImgLoadUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */

public class RecommendViewPagerAdapter extends PagerAdapter {
    List<VideoInfo> listInfo;
    Context mContext;
    ImageView [] imgs;
    public RecommendViewPagerAdapter(Context mContext) {
        this.listInfo = new ArrayList<>();
        this.mContext = mContext;
        imgs=new ImageView [0];
    }

    @Override
    public int getCount() {
        if (listInfo==null)return 0;
        return listInfo.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imgs[position]);
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(mContext);
        ImgLoadUtils.loadImgByUrl(imageView, listInfo.get(position).pic);
        imgs[position]=imageView;
        container.addView(imageView);
        return imageView;
    }


    public void setData(List<VideoInfo> list) {
        this.listInfo = list;
        imgs=new ImageView [list.size()];
        notifyDataSetChanged();
    }
}
