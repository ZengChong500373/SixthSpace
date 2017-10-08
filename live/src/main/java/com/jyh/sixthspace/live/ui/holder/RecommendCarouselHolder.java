package com.jyh.sixthspace.live.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jyh.sixthspace.live.databinding.FragmentLiveCarouseBinding;


/**
 * Created by Administrator on 2017/10/7.
 */

public class RecommendCarouselHolder extends RecyclerView.ViewHolder {
    FragmentLiveCarouseBinding binding;

    public RecommendCarouselHolder(View itemView) {
        super(itemView);
    }

    public void setBind(FragmentLiveCarouseBinding binding) {
        this.binding = binding;
    }
    public FragmentLiveCarouseBinding getBind(){
        return  binding;
    }


}
