package com.swpuiot.schoolnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.swpuiot.schoolnews.view.WebActivity;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 羊荣毅_L on 2016/12/18.
 */
public class BannerLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        String u = (String) path;
        Uri uri = Uri.parse(u);
        imageView.setImageURI(uri);
    }

    @Override
    public ImageView createImageView(final Context context) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
        simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title="西南石油大学";
                String url="http://www.baidu.com";
                Intent headIntent=new Intent(context,WebActivity.class);
                headIntent.putExtra(WebActivity.ACTION_TITLE, title);
                headIntent.putExtra(WebActivity.ACTION_URL, url);
                context.startActivity(headIntent);
            }
        });
        return simpleDraweeView;
    }

}
