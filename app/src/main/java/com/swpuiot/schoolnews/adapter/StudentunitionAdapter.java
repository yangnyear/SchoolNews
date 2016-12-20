package com.swpuiot.schoolnews.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.StudentsUnition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/8.
 */
public class StudentunitionAdapter extends BaseAdapter {
    private Context mcontext;
    private LayoutInflater minflater;
    //初始化
    public StudentunitionAdapter(Context context){
        this.mcontext=context;
        minflater=LayoutInflater.from(context);
    }
    //获得资源
    public List<StudentsUnition>students_unitions_list=new ArrayList<StudentsUnition>();{
        String uri = "http://www.bug666.cn:8080/Images/headfirst/swpu_03.jpg";
        students_unitions_list.add(new StudentsUnition("石工院学生会", uri));
        students_unitions_list.add(new StudentsUnition("化工院学生会",uri));
        students_unitions_list.add(new StudentsUnition("计科院学生会",uri));
        students_unitions_list.add(new StudentsUnition("土建院学生会",uri));
        students_unitions_list.add(new StudentsUnition("经管院学生会",uri));
        students_unitions_list.add(new StudentsUnition("外语院学生会",uri));
        students_unitions_list.add(new StudentsUnition("地科院学生会",uri));
        students_unitions_list.add(new StudentsUnition("机电院学生会",uri));
        students_unitions_list.add(new StudentsUnition("理学院学生会",uri));
        students_unitions_list.add(new StudentsUnition("电信院学生会",uri));


    }
    //返回students_unitions_list的长度
    @Override
    public int getCount() {
        return students_unitions_list.size();
    }
    //获得当前位置的资源
    @Override
    public Object getItem(int position) {
        return students_unitions_list.get(position);
    }
    //获得资源位置id
    @Override
    public long getItemId(int position) {
        return position;
    }
    //将不糊文件填充为一个对象并返回
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHoulder viewHoulder;
        if (convertView==null){
            viewHoulder=new ViewHoulder();
            view=minflater.inflate(R.layout.unition_item,null);
            viewHoulder.titletext=(TextView)view.findViewById(R.id.unition_name);
            viewHoulder.image=( com.facebook.drawee.view.SimpleDraweeView)view.findViewById(R.id.unition_image);
            view.setTag(viewHoulder);
        }
        else{
            view=convertView;
            viewHoulder= (ViewHoulder) view.getTag();
        }
        StudentsUnition studentsUnition=students_unitions_list.get(position);
        viewHoulder.titletext.setText(studentsUnition.getUnitionName());
        viewHoulder.image.setImageURI(Uri.parse(studentsUnition.getImageid()));
        return view;
    }
    public class ViewHoulder{
        public TextView titletext;
        public  com.facebook.drawee.view.SimpleDraweeView image;
    }
}
