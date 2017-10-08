package com.jyh.sixthspace.live.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jyh.sixthspace.live.R;

import com.jyh.sixthspace.live.databinding.FragmentLiveTypeItemsBinding;
import com.jyh.sixthspace.live.viewmodel.LiveReHotViewModel;
import com.jyh.sixthspace.sdk.bean.live.HomeHotColumn;
import com.jyh.sixthspace.sdk.utlis.ImgLoadUtils;
import com.jyh.sixthspace.sdk.utlis.UIUtils;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/10/9.
 */

public class LiveReHotTypeAdapter extends RecyclerView.Adapter<LiveReHotTypeAdapter.LiveReHotViewHolder> {
    List<HomeHotColumn> list = new ArrayList<>();

    @Override
    public LiveReHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentLiveTypeItemsBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_live_type_items, parent, false);
        LiveReHotViewHolder hotViewHolder = new LiveReHotViewHolder(itemBinding.getRoot());
        hotViewHolder.setBind(itemBinding);
        return hotViewHolder;
    }

    @Override
    public void onBindViewHolder(LiveReHotViewHolder holder, int position) {
        holder.setData(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LiveReHotViewHolder extends RecyclerView.ViewHolder {
        private FragmentLiveTypeItemsBinding bind;
        private Context mContext;

        public LiveReHotViewHolder(View itemView) {
            super(itemView);
        }

        public void setBind(FragmentLiveTypeItemsBinding binding) {
            this.bind = binding;
            this.mContext = itemView.getContext();
        }

        public void setData(HomeHotColumn info) {
//            if (bind.getModel() == null) {
//                bind.setModel(new LiveReHotViewModel(info, mContext));
//            } else {
//                bind.getModel().setData(info);
//            }
            ImgLoadUtils.loadImgByUrlcenterCrop( bind.img, info.getRoom_src());
            bind.tvRoomName.setText(info.getNickname());
            bind.tvNickname.setText(info.getNickname());
            bind.tvOnlineNum.setText(info.getOnline()+"");
        }
    }

    public void setData(List<HomeHotColumn> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();

    }
}
