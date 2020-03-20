package com.xc.screenshootdemo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.xc.screenshootdemo.R;
import com.xc.screenshootdemo.util.PopuUtil;
import com.xc.screenshootdemo.util.ScreenShoot;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：
 */

public class ScrollviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scroll_view_activvity);

        Glide.with(this)
                .load(R.drawable.img1)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        ((ImageView) findViewById(R.id.iv_scroll_view_1)).setImageBitmap(resource);
                    }
                });

        Glide.with(this)
                .load(R.drawable.img2)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        ((ImageView) findViewById(R.id.iv_scroll_view_2)).setImageBitmap(resource);
                    }
                });

        Glide.with(this)
                .load(R.drawable.img1)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        ((ImageView) findViewById(R.id.iv_scroll_view_3)).setImageBitmap(resource);
                    }
                });
    }

    public void scrollViewOnclick(View view) {
        Bitmap bitmap = ScreenShoot.shotScrollView((ScrollView) findViewById(R.id.scroll_view));
        PopuUtil.showPopu(ScrollviewActivity.this, bitmap, view);
    }
}
