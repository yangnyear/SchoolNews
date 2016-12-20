package com.swpuiot.schoolnews.adapter;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
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
    public ImageView createImageView(Context context) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
        return simpleDraweeView;
    }
}
