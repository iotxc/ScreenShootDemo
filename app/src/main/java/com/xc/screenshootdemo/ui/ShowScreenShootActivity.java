package com.xc.screenshootdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xc.screenshootdemo.R;
import com.xc.screenshootdemo.constant.Constant;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：
 */

public class ShowScreenShootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_screen_shoot_activity);

        Glide.with(this)
                .load(getIntent().getParcelableExtra(Constant.BITMAP_DATA))
                .into((ImageView) findViewById(R.id.iv_show));
    }
}
