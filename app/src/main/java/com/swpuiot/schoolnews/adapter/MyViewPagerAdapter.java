package com.swpuiot.schoolnews.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/24.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<View>viewList;
    //构造函数
    public MyViewPagerAdapter(List<View>viewList){
        this.viewList=viewList;
    }

    //返回也卡数目
    @Override
    public int getCount() {
        return viewList.size();
    }

    //判断view是否来自对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    //实例化一个叶卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    //销毁一个页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
