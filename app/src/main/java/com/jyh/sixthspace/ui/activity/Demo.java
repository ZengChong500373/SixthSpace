package com.jyh.sixthspace.ui.activity;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jyh.sixthspace.R;
import com.jyh.sixthspace.ui.adapter.MainPagerAdapter;

import six.jyh.com.uilibrary.StatusBarUtil;


/**
 * Created by Administrator on 2017/10/10.
 */

public class Demo extends AppCompatActivity {
    private ViewPager mVpHome;
    private MainPagerAdapter mainPagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setStatusBar();
        mVpHome = (ViewPager) findViewById(R.id.vp_main);
        mainPagerAdapter=new MainPagerAdapter(getSupportFragmentManager());
        mVpHome.setAdapter(mainPagerAdapter);

    }

    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(Demo.this, null);
    }
}
