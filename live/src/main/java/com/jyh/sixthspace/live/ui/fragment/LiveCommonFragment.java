package com.jyh.sixthspace.live.ui.fragment;

import android.os.Bundle;

import com.jyh.sixthspace.live.R;
import com.jyh.sixthspace.live.databinding.FragmentLiveBinding;
import com.jyh.sixthspace.sdk.base.LazyFragment;

/**
 * Created by Administrator on 2017/9/30.
 */

public class LiveCommonFragment extends LazyFragment<FragmentLiveBinding> {
    public static LiveCommonFragment newInstance(int position) {
        Bundle args = new Bundle();
        LiveCommonFragment fragment = new LiveCommonFragment();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int setFragmentView() {
        return R.layout.fragment_live;
    }

    @Override
    public void onFirstUserVisible() {
        int   current_position = getArguments().getInt("position");


    }
}
