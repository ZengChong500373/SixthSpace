package com.jyh.sixthspace.live.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jyh.sixthspace.live.ui.fragment.LiveCommonFragment;
import com.jyh.sixthspace.live.ui.fragment.LiveReCommedFrament;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */

public class LiveMainPagerAdapter extends FragmentStatePagerAdapter {
    List<String> list;

    public LiveMainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LiveReCommedFrament();
        }
        return LiveCommonFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        if (list == null)
            return 0;
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();

    }
}
