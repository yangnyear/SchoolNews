package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.HeadMessageAdapterr;
import com.swpuiot.schoolnews.adapter.MyGridViewAdapter;
import com.swpuiot.schoolnews.adapter.MyOnotherGridViewAdapter;
import com.swpuiot.schoolnews.adapter.MyViewPagerAdapter;
import com.swpuiot.schoolnews.emtity.HradMessages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/8.
 */
public class ActionFragment extends Fragment {
    private HeadMessageAdapterr headMessageAdapterr;
    private ListView listView;
    public List<HradMessages> mlist;
    private View view;
    private ViewPager viewPager;
    private GridView firstGridView;
    private GridView scendGridView;
    private List<View> actionViewList = new ArrayList<View>();


    public void setMlist(List<HradMessages> mlist) {
        this.mlist = mlist;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_action, container, false);
        }

        if (viewPager==null){
            View firstView = View.inflate(getActivity(), R.layout.xiyou_pg_first_item, null);
            View scendView = View.inflate(getActivity(), R.layout.xiyou_pg_scend_item, null);

            firstGridView = (GridView) firstView.findViewById(R.id.mv_action_first);
            scendGridView = (GridView) scendView.findViewById(R.id.mv_action_scend);
            MyOnotherGridViewAdapter firstGridViewAdapter = new MyOnotherGridViewAdapter(getActivity());
            MyGridViewAdapter scendGridViewAdapter = new MyGridViewAdapter(getActivity());
            firstGridView.setAdapter(firstGridViewAdapter);
            scendGridView.setAdapter(scendGridViewAdapter);

            actionViewList.add(firstView);
            actionViewList.add(scendView);
        }



        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(actionViewList);
        viewPager=(ViewPager)view.findViewById(R.id.vp_action);
        viewPager.setAdapter(myViewPagerAdapter);

        headMessageAdapterr = new HeadMessageAdapterr(getActivity(), mlist);
        listView = (ListView) view.findViewById(R.id.list_action);
        listView.setAdapter(headMessageAdapterr);
        if (headMessageAdapterr != null)
            headMessageAdapterr.notifyDataSetChanged();
        return view;
    }

    public void notifyDataSetChanged() {
        headMessageAdapterr.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) view.getParent()).removeView(view);

    }
}
