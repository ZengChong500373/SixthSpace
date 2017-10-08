package com.jyh.sixthspace.live.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jyh.sixthspace.live.R;
import com.jyh.sixthspace.live.databinding.FragmentLiveTypeItemsBinding;
import com.jyh.sixthspace.sdk.bean.live.HomeHotColumn;
import com.jyh.sixthspace.sdk.bean.live.HomeRecommendHotCate;
import com.jyh.sixthspace.sdk.utlis.ImgLoadUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/10/9.
 */

public class LiveReOtherTypeAdapter extends RecyclerView.Adapter<LiveReOtherTypeAdapter.LiveReOtherViewHolder> {
    List<HomeRecommendHotCate.RoomListEntity> list = new ArrayList<>();

    @Override
    public LiveReOtherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentLiveTypeItemsBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_live_type_items, parent, false);
        LiveReOtherViewHolder hotViewHolder = new LiveReOtherViewHolder(itemBinding.getRoot());
        hotViewHolder.setBind(itemBinding);
        return hotViewHolder;
    }

    @Override
    public void onBindViewHolder(LiveReOtherViewHolder holder, int position) {
        holder.setData(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LiveReOtherViewHolder extends RecyclerView.ViewHolder {
        private FragmentLiveTypeItemsBinding bind;
        private Context mContext;

        public LiveReOtherViewHolder(View itemView) {
            super(itemView);
        }

        public void setBind(FragmentLiveTypeItemsBinding binding) {
            this.bind = binding;
            this.mContext = itemView.getContext();
        }

        public void setData(HomeRecommendHotCate.RoomListEntity info) {
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

    public void setData( List<HomeRecommendHotCate.RoomListEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();

    }
}
