package com.jyh.sixthspace.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jyh.sixthspace.R;
import com.jyh.sixthspace.databinding.FragmentRecommendRecyclerItemBinding;
import com.jyh.sixthspace.sdk.model.VideoInfo;
import com.jyh.sixthspace.viewmodel.RecommendRecyclerItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */

public class RecommendRecyclerAdapter extends RecyclerView.Adapter<RecommendRecyclerAdapter.RecommendViewHolder> {
    List<VideoInfo> list;
    Context mContext;
    public RecommendRecyclerAdapter() {
        this.list = Collections.emptyList();
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentRecommendRecyclerItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_recommend_recycler_item,
                        parent, false);
        RecommendViewHolder holder = new RecommendViewHolder(binding.getRoot());
        this.mContext=parent.getContext();
        holder.setBind(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecommendViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecommendViewHolder extends RecyclerView.ViewHolder {
        private FragmentRecommendRecyclerItemBinding binding;

        public RecommendViewHolder(View itemView) {
            super(itemView);
        }

        public void setBind(FragmentRecommendRecyclerItemBinding binding) {
            this.binding = binding;
        }

        public void setData(VideoInfo info) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new RecommendRecyclerItemViewModel(info,mContext));
            } else {
                binding.getViewModel().setData(info);
            }
        }

    }

    public void setData(List<VideoInfo> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
