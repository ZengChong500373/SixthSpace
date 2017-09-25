package com.jyh.sixthspace.live;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jyh.sixthspace.live.databinding.FragmentLiveBinding;


/**
 * Created by Administrator on 2017/4/13.
 */

public class DemoLiveFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLiveBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live, container, false);
        return binding.getRoot();
    }
}
