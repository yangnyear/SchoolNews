package com.swpuiot.schoolnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/11.
 */
public class UserAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;

    public UserAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }
    private List<UserEntity>listOfUser=new ArrayList<UserEntity>();{
        listOfUser.add(new UserEntity("个人资料",R.drawable.next_item_icon));
        listOfUser.add(new UserEntity("我的足迹",R.drawable.next_item_icon));
        listOfUser.add(new UserEntity("部门管理",R.drawable.next_item_icon));
        listOfUser.add(new UserEntity("关于我们",R.drawable.next_item_icon));
    }

    @Override
    public int getCount() {
        return listOfUser.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        UserViewHoder userViewHoder;
        if (convertView==null){
            userViewHoder=new UserViewHoder();
            view=inflater.inflate(R.layout.user_item,null);
            userViewHoder.textOfContent= (TextView) view.findViewById(R.id.text_user_word);
            userViewHoder.imageOfContent= (ImageView) view.findViewById(R.id.text_user_image);
            view.setTag(userViewHoder);
        }else{
            view=convertView;
            userViewHoder= (UserViewHoder) view.getTag();
        }
        UserEntity user=listOfUser.get(position);
        userViewHoder.textOfContent.setText(user.getContent());
        userViewHoder.imageOfContent.setImageResource(user.getIdOfImage());
        return view;
    }
    public class UserViewHoder{
        TextView textOfContent;
        ImageView imageOfContent;
    }
}
