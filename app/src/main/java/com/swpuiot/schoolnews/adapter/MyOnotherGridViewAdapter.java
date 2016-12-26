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
public class MyOnotherGridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater minflater;
    public MyOnotherGridViewAdapter(Context context) {
        this.context = context;
        minflater = LayoutInflater.from(context);

    }
    private List<GridViewentity> gridViewentityList=new ArrayList<GridViewentity>();{
        gridViewentityList.add(new GridViewentity(R.drawable.face_01, "快乐石工"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_02, "灵动计科"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_03, "呆萌化工"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_04, "静默土建"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_05, "优雅外语"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_06, "多彩材科"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_07, "幸福法学"));
        gridViewentityList.add(new GridViewentity(R.drawable.face_08, "缤纷艺术"));
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
        GridViewentity gridViewentity= gridViewentityList.get(position);
        myGridViewHoulder.imageView.setImageResource(gridViewentity.getImageId());
        myGridViewHoulder.textView.setText(gridViewentity.getCounten());
        return mgridview;
    }

    public class MyGridViewHoulder {
        public ImageView imageView;
        public TextView textView;
    }
}
