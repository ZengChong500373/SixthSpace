package com.jyh.sixthspace.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;

import com.jyh.sixthspace.R;
import com.jyh.sixthspace.base.LazyFragment;
import com.jyh.sixthspace.databinding.FragmentRecommendBinding;
import com.jyh.sixthspace.model.VideoInfo;
import com.jyh.sixthspace.view.adapter.RecommendRecyclerAdapter;
import com.jyh.sixthspace.view.adapter.RecommendViewPagerAdapter;
import com.jyh.sixthspace.viewmodel.RecommendViewModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by Administrator on 2017/4/13.
 * LazyFragment<FragmentRecommendBinding>
 */

public class RecommendFragment extends LazyFragment<FragmentRecommendBinding> implements Observer {
    RecommendViewModel recommendViewModel;
    RecommendRecyclerAdapter recyclerAdapter;
    RecommendViewPagerAdapter viewPagerAdapter;
    @Override
    public int setFragmentView() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initViews() {
        jyhBinding.recyclerRecommend.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new RecommendRecyclerAdapter();
        jyhBinding.recyclerRecommend.setAdapter(recyclerAdapter);
        viewPagerAdapter=new RecommendViewPagerAdapter(getContext());
        jyhBinding.vpRecommend.setAdapter(viewPagerAdapter);

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
            SparseArray<List<VideoInfo>> mapInfos=recommendViewModel.getMapInfos();
            viewPagerAdapter.setData(mapInfos.get(0));
            recyclerAdapter.setData(mapInfos.get(1));
            jyhBinding.vpRecommend.setOffscreenPageLimit(mapInfos.get(1).size());
        }

    }
}
