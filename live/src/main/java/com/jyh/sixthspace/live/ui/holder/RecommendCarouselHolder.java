package com.jyh.sixthspace.live.ui.holder;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.jyh.sixthspace.live.databinding.FragmentLiveCarousesBinding;

import six.jyh.com.uilibrary.ViewPagerIndicator.ScaleCircleNavigator;
import six.jyh.com.uilibrary.ViewPagerIndicator.ViewPagerHelper;


/**
 * Created by Administrator on 2017/10/7.
 */

public class RecommendCarouselHolder extends RecyclerView.ViewHolder {
    FragmentLiveCarousesBinding binding;
    ScaleCircleNavigator scaleCircleNavigator;

    public RecommendCarouselHolder(View itemView) {
        super(itemView);
    }

    public void setBind(FragmentLiveCarousesBinding binding) {
        this.binding = binding;
    }

    public FragmentLiveCarousesBinding getBind() {
        return binding;
    }

    public void initIndicator(PagerAdapter pagerAdapter) {
        binding.liveRecommendCarouse.setAdapter(pagerAdapter);
        scaleCircleNavigator = new ScaleCircleNavigator(binding.liveRecommendCarouse.getContext());
        scaleCircleNavigator.setNormalCircleColor(Color.LTGRAY);
        int color = binding.liveRecommendCarouse.getContext().getResources().getColor(six.jyh.com.uilibrary.R.color.colorPrimary);
        scaleCircleNavigator.setSelectedCircleColor(color);
        binding.indicator.setNavigator(scaleCircleNavigator);
        ViewPagerHelper.bind(binding.indicator, binding.liveRecommendCarouse);
    }

    public void setCircleCount(int count) {
        scaleCircleNavigator.setCircleCount(count);
    }

}
