package com.swpuiot.schoolnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.GridViewentity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/25.
 */
public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater minflater;
    private List<GridViewentity> gridViewentityList=new ArrayList<GridViewentity>();{
       gridViewentityList.add(new GridViewentity(R.drawable.face_09, "无限地科"));
       gridViewentityList.add(new GridViewentity(R.drawable.face_10, "刚强体育"));
       gridViewentityList.add(new GridViewentity(R.drawable.face_11, "竞彩电信"));
       gridViewentityList.add(new GridViewentity(R.drawable.face_12, "奋进机电"));
    }

    public MyGridViewAdapter(Context context) {
        this.context = context;
        minflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return gridViewentityList.size();
    }

    @Override
    public Object getItem(int position) {
        return gridViewentityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mgridview;
        MyGridViewHoulder myGridViewHoulder;
        if (convertView == null) {
             myGridViewHoulder = new MyGridViewHoulder();
            mgridview = minflater.inflate(R.layout.gridview_iten, null);
            myGridViewHoulder.imageView= (ImageView) mgridview.findViewById(R.id.imag_mgridview);
            myGridViewHoulder.textView= (TextView) mgridview.findViewById(R.id.txt_mgridview);
            mgridview.setTag(myGridViewHoulder);
        }else {
            mgridview=convertView;
            myGridViewHoulder= (MyGridViewHoulder) mgridview.getTag();
        }
        GridViewentity gridViewentity= (GridViewentity) getItem(position);
        myGridViewHoulder.imageView.setImageResource(gridViewentity.getImageId());
        myGridViewHoulder.textView.setText(gridViewentity.getCounten());
        return mgridview;
    }

    public class MyGridViewHoulder {
        public ImageView imageView;
        public TextView textView;
    }
}
