package com.jyh.sixthspace.live.ui.fragment;


import android.support.v7.app.AppCompatActivity;

import com.jyh.sixthspace.live.R;


import com.jyh.sixthspace.live.databinding.FragmentLiveMainBinding;
import com.jyh.sixthspace.live.ui.adapter.LiveMainPagerAdapter;
import com.jyh.sixthspace.sdk.base.LazyFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/4/13.
 */

public class LiveMainFragment extends LazyFragment<FragmentLiveMainBinding> {
    LiveMainPagerAdapter adapter;

    @Override
    public int setFragmentView() {
        return R.layout.fragment_live_main;
    }

    @Override
    public void initViews() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(jyhBinding.toolBar);
        adapter = new LiveMainPagerAdapter(getChildFragmentManager());
        jyhBinding.vpMain.setAdapter(adapter);
        jyhBinding.tabLayout.setupWithViewPager(jyhBinding.vpMain);
    }

    @Override
    public void onFirstUserVisible() {
        List<String> list = new ArrayList<String>();
        list.add("推荐");
        list.add("手游");
        list.add("娱乐");
        list.add("游戏");
        list.add("趣玩");

        jyhBinding.tabLayout.addTab(jyhBinding.tabLayout.newTab().setText("推荐"));
        jyhBinding.tabLayout.addTab(jyhBinding.tabLayout.newTab().setText("手游"));
        jyhBinding.tabLayout.addTab(jyhBinding.tabLayout.newTab().setText("娱乐"));
        jyhBinding.tabLayout.addTab(jyhBinding.tabLayout.newTab().setText("游戏"));
        jyhBinding.tabLayout.addTab(jyhBinding.tabLayout.newTab().setText("趣玩"));
        jyhBinding.vpMain.setOffscreenPageLimit(list.size());
        adapter.setData(list);
    }

}
