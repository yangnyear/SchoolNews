package com.swpuiot.schoolnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/8.
 */
public class MypagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> viewList;

    public MypagerAdapter(FragmentManager fm, List<Fragment> viewList) {
        super(fm);
        this.viewList = viewList;
    }

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

}
