package com.jyh.sixthspace.live.ui.fragment;

import com.jyh.sixthspace.live.R;

import com.jyh.sixthspace.live.databinding.FragmentLiveBinding;
import com.jyh.sixthspace.sdk.base.LazyFragment;

/**
 * Created by Administrator on 2017/9/30.
 */

public class LiveReCommedFrament extends LazyFragment<FragmentLiveBinding> {

    @Override
    public int setFragmentView() {
        return R.layout.fragment_live;
    }

    @Override
    public void onFirstUserVisible() {

      jyhBinding.tvDemo.setText("LiveReCommedFrament");
    }
}
