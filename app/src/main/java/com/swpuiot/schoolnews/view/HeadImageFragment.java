package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.BannerLoader;
import com.swpuiot.schoolnews.adapter.HeadMessageAdapterr;
import com.swpuiot.schoolnews.emtity.HradMessages;
import com.youth.banner.Banner;

import java.util.Arrays;
import java.util.List;

public class HeadImageFragment extends Fragment {
    private HeadMessageAdapterr headMessageAdapterr;
    private ListView listView;
    List<HradMessages> mlist;
    private View view;
    private List<String> bannarImgs = Arrays.asList(
            "http://www.bug666.cn:8080/Images/headfirst/swpu_01.jpg",
            "http://www.bug666.cn:8080/Images/headfirst/swpu_02.jpg",
            "http://www.bug666.cn:8080/Images/headfirst/swpu_03.jpg",
            "http://www.bug666.cn:8080/Images/headfirst/swpu_04.jpg"
    );


    public void setMlist(List<HradMessages> mlist) {
        this.mlist = mlist;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view==null){
            view = inflater.inflate(R.layout.fragment_headimage, container, false);
        }

        headMessageAdapterr = new HeadMessageAdapterr(getActivity(), mlist);
        listView = (ListView) view.findViewById(R.id.head_news);
        listView.setAdapter(headMessageAdapterr);

        ((Banner) view
                .findViewById(R.id.banner))
                .setImageLoader(new BannerLoader())
                .setImages(bannarImgs)
                .isAutoPlay(true)
                .start();


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
