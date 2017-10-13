package com.jyh.sixthspace.ui.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;

import com.jyh.sixthspace.R;
import six.jyh.com.uilibrary.base.LazyFragment;
import com.jyh.sixthspace.databinding.FragmentRecommendBinding;
import com.jyh.sixthspace.sdk.bean.movie.VideoInfo;
import com.jyh.sixthspace.ui.adapter.RecommendRecyclerAdapter;
import com.jyh.sixthspace.ui.adapter.RecommendViewPagerAdapter;
import com.jyh.sixthspace.viewmodel.RecommendViewModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import six.jyh.com.uilibrary.ViewPagerIndicator.ScaleCircleNavigator;
import six.jyh.com.uilibrary.ViewPagerIndicator.ViewPagerHelper;


/**
 * Created by Administrator on 2017/4/13.
 * LazyFragment<FragmentRecommendBinding>
 */

public class RecommendFragment extends LazyFragment<FragmentRecommendBinding> implements Observer {
    RecommendViewModel recommendViewModel;
    RecommendRecyclerAdapter recyclerAdapter;
    RecommendViewPagerAdapter viewPagerAdapter;
    ScaleCircleNavigator scaleCircleNavigator;

    @Override
    public int setFragmentView() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initViews() {
        jyhBinding.recyclerRecommend.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new RecommendRecyclerAdapter();
        jyhBinding.recyclerRecommend.setAdapter(recyclerAdapter);
        viewPagerAdapter = new RecommendViewPagerAdapter(getContext());
        jyhBinding.vpRecommend.setAdapter(viewPagerAdapter);

        scaleCircleNavigator = new ScaleCircleNavigator(getContext());
        scaleCircleNavigator.setNormalCircleColor(Color.LTGRAY);
        int color = getContext().getResources().getColor(six.jyh.com.uilibrary.R.color.colorPrimary);
        scaleCircleNavigator.setSelectedCircleColor(color);
        jyhBinding.indicator.setNavigator(scaleCircleNavigator);
        ViewPagerHelper.bind(jyhBinding.indicator, jyhBinding.vpRecommend);

    }

    @Override
    public void onFirstUserVisible() {
        recommendViewModel = new RecommendViewModel();
        recommendViewModel.addObserver(this);
        jyhBinding.setRecommendViewModel(recommendViewModel);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof RecommendViewModel) {
            RecommendViewModel recommendViewModel = (RecommendViewModel) observable;
            SparseArray<List<VideoInfo>> mapInfos = recommendViewModel.getMapInfos();
            viewPagerAdapter.setData(mapInfos.get(0));
            scaleCircleNavigator.setCircleCount(mapInfos.get(0).size());
            recyclerAdapter.setData(mapInfos.get(1));
            jyhBinding.vpRecommend.setOffscreenPageLimit(mapInfos.get(1).size());
        }

    }
}
