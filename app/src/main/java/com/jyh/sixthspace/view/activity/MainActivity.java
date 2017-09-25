package com.jyh.sixthspace.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jyh.sixthspace.R;
import com.jyh.sixthspace.databinding.ActivityMainBinding;

import com.jyh.sixthspace.sdk.utlis.StatusBarCompat;
import com.jyh.sixthspace.view.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    BottomNavigationView navigation;
    MainPagerAdapter mainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        navigation = binding.include.navigation;
        StatusBarCompat.compat(this,getResources().getColor(R.color.transparent));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mainPagerAdapter=new MainPagerAdapter(getSupportFragmentManager());
        binding.include.vpMain.setAdapter(mainPagerAdapter);
        binding.include.vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigation.setSelectedItemId(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_recommend:
                    binding.include.vpMain.setCurrentItem(0);
                    return true;
                case R.id.navigation_movies:
                    binding.include.vpMain.setCurrentItem(1);
                    return true;
                case R.id.navigation_live:
                    binding.include.vpMain.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
}
