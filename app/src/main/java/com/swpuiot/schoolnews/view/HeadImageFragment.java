package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.HeadMessageAdapterr;
import com.swpuiot.schoolnews.emtity.HradMessages;

import java.util.List;

public class HeadImageFragment extends Fragment {
    private HeadMessageAdapterr headMessageAdapterr;
    private ListView listView;
    List<HradMessages> mlist;

    public void setMlist(List<HradMessages> mlist) {
        this.mlist = mlist;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_headimage, container, false);
        headMessageAdapterr = new HeadMessageAdapterr(getActivity(), mlist);
        listView= (ListView) view.findViewById(R.id.head_news);
        listView.setAdapter(headMessageAdapterr);
        if(headMessageAdapterr!=null)
            headMessageAdapterr.notifyDataSetChanged();

        return view;

    }
}
