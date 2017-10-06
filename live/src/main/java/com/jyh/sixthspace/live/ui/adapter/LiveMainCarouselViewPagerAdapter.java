package com.jyh.sixthspace.live.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jyh.sixthspace.sdk.bean.live.HomeCarousel;
import com.jyh.sixthspace.sdk.utlis.ImgLoadUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/7.
 *
 * 直播主界面推荐轮播图
 */

public class LiveMainCarouselViewPagerAdapter extends PagerAdapter {
    List<HomeCarousel> list;
    ImageView[] imgs;

    public LiveMainCarouselViewPagerAdapter() {
        imgs=new ImageView [0];
    }

    @Override
    public int getCount() {
        if (list==null)
            return 0;
        return list.size();
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
        ImageView imageView=new ImageView(container.getContext());
        ImgLoadUtils.loadImgByUrl(imageView, list.get(position).getTv_pic_url());
        imgs[position]=imageView;
        container.addView(imageView);
        return imageView;
    }


    public void setData(List<HomeCarousel> list) {
        this.list = list;
        imgs=new ImageView [list.size()];
        notifyDataSetChanged();
    }
}
