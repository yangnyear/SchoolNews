package com.swpuiot.schoolnews.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.HradMessages;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/9.
 */
public class HeadMessageAdapterr extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public HeadMessageAdapterr(Context context, List<HradMessages> mlist) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        HEAD_MESSAGElIST = mlist;
    }

    private List<HradMessages> HEAD_MESSAGElIST;

    @Override
    public int getCount() {
        return HEAD_MESSAGElIST.size();
    }

    @Override
    public Object getItem(int position) {
        return HEAD_MESSAGElIST.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHoulder viewHoulder;
        if (convertView == null) {
            viewHoulder = new ViewHoulder();
            view = layoutInflater.inflate(R.layout.head_item, null);
            viewHoulder.title = (TextView) view.findViewById(R.id.head_message_title);
            viewHoulder.content = (TextView) view.findViewById(R.id.head_messa_content);
            viewHoulder.image = (com.facebook.drawee.view.SimpleDraweeView) view.findViewById(R.id.img_msg);
            view.setTag(viewHoulder);
        } else {
            view = convertView;
            viewHoulder = (ViewHoulder) view.getTag();
        }
        HradMessages hrad_messages = HEAD_MESSAGElIST.get(position);
        viewHoulder.title.setText(hrad_messages.getMessageTitle());
        viewHoulder.content.setText(hrad_messages.getMessagecontant());
        if (hrad_messages.getMsgImgId() != null)
            viewHoulder.image.setImageURI(Uri.parse(hrad_messages.getMsgImgId()));
        return view;
    }

    public class ViewHoulder {
        public TextView title;
        public TextView content;
        public com.facebook.drawee.view.SimpleDraweeView image;
    }
}

