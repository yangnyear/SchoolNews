package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.HeadMessageAdapterr;
import com.swpuiot.schoolnews.emtity.HradMessages;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/8.
 */
public class ActionFragment extends Fragment {
    private HeadMessageAdapterr headMessageAdapterr;
    private ListView listView;
    List<HradMessages> mlist;

    public void setMlist(List<HradMessages> mlist) {
        this.mlist = mlist;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_action,container,false);
        headMessageAdapterr = new HeadMessageAdapterr(getActivity(), mlist);
        listView= (ListView) view.findViewById(R.id.list_action);
        listView.setAdapter(headMessageAdapterr);
        if(headMessageAdapterr!=null)
            headMessageAdapterr.notifyDataSetChanged();


        return view;
    }
}
