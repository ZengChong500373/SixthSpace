package com.jyh.sixthspace.live.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jyh.sixthspace.live.R;
import com.jyh.sixthspace.live.databinding.FragmentLiveCarouseBinding;
import com.jyh.sixthspace.live.ui.holder.RecommendCarouselHolder;
import com.jyh.sixthspace.sdk.base.RecyclerViewBaseHolder;
import com.jyh.sixthspace.sdk.bean.live.HomeCarousel;
import com.jyh.sixthspace.sdk.bean.live.HomeFaceScoreColumn;
import com.jyh.sixthspace.sdk.bean.live.HomeHotColumn;
import com.jyh.sixthspace.sdk.bean.live.HomeRecommendHotCate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/7.
 */

public class LiveReCommendMainRecycleAdapter extends RecyclerView.Adapter {
    public final   int VIEWPAGER=0;
    public int Hot=1;
    public int Beautys=2;
    public int Ohter=3;
    HomeRecommendHotCate carousel=new HomeRecommendHotCate();
    List<HomeRecommendHotCate> list = new ArrayList<HomeRecommendHotCate>();
    List<HomeCarousel> homeCarouselList;
    LiveMainCarouselViewPagerAdapter carouselViewPagerAdapter;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case VIEWPAGER:
                FragmentLiveCarouseBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_live_carouse,parent,false);
                RecommendCarouselHolder    carouselHolder=new RecommendCarouselHolder(binding.getRoot());
               carouselHolder.setBind(binding);
                holder=carouselHolder;
                break;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType){
            case VIEWPAGER:
                RecommendCarouselHolder carouselHolder= (RecommendCarouselHolder) holder;
                if (carouselHolder.getBind().liveRecommendCarouse.getAdapter()==null){
                     carouselViewPagerAdapter=new LiveMainCarouselViewPagerAdapter();
                    carouselHolder.getBind().liveRecommendCarouse.setAdapter(carouselViewPagerAdapter);
                }
                carouselViewPagerAdapter.setData(homeCarouselList);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }


    public void setCarouselData(List<HomeCarousel> list) {
        carousel.setType(VIEWPAGER);
        if (list!=null){
            this.list.add(carousel);
        }else {
            this.list.remove(carousel);
        }
        homeCarouselList=list;
       notifyDataSetChanged();


    }


    public void onLoadHotSuccess(List<HomeHotColumn> list) {

    }


    public void onLoadBeautysSuccess(List<HomeFaceScoreColumn> list) {

    }


    public void onLoadOtherSuccess(List<HomeRecommendHotCate> list) {

    }
}
