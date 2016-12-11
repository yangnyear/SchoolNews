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

//    //返回也卡数量
//    @Override
//    public int getCount() {
//        return viewList.size();
//    }
//
//    //判断view是否来自对象
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view==object;
//    }
//
//    //实例化一个页卡
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        container.addView(viewList.get(position));
//        return viewList.get(position);
//    }
//
//    //销毁一个页卡
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewList.get(position));
//    }
}
