package com.jyh.sixthspace.live;


import com.jyh.sixthspace.live.databinding.FragmentLiveBinding;
import com.jyh.sixthspace.sdk.base.LazyFragment;

/**
 * Created by Administrator on 2017/4/13.
 */

public class LiveFragment extends LazyFragment<FragmentLiveBinding> {
    @Override
    public int setFragmentView() {
        return R.layout.fragment_live;
    }

    @Override
    public void onFirstUserVisible() {
        jyhBinding.tvDemo.setText("LiveFragment nimabi");
    }
}
