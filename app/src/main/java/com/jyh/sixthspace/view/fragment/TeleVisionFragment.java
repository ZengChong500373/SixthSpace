package com.jyh.sixthspace.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jyh.sixthspace.R;
import com.jyh.sixthspace.databinding.FragmentTelevisionBinding;

/**
 * Created by Administrator on 2017/4/13.
 */

public class TeleVisionFragment extends Fragment {
    FragmentTelevisionBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_television, container, false);
        return binding.getRoot();
    }
}
