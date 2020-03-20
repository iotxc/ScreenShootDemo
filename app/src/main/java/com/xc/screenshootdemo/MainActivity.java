package com.xc.screenshootdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xc.screenshootdemo.ui.ListviewActivity;
import com.xc.screenshootdemo.ui.PIPActivity;
import com.xc.screenshootdemo.ui.RecycleviewActivity;
import com.xc.screenshootdemo.ui.ScreenShootActivity;
import com.xc.screenshootdemo.ui.ScrollviewActivity;
import com.xc.screenshootdemo.util.PopuUtil;
import com.xc.screenshootdemo.util.ScreenShoot;

public class MainActivity extends AppCompatActivity {

    Bitmap mBitmap = null;

    int count = 0;

    ScreenShoot screenShoot = new ScreenShoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 跳转到activity截图界面
     * @param view
     */
    public void jumpActivityOnclick(View view) {
        startActivity(new Intent(this, ScreenShootActivity.class));
    }

    public void jumpScrollViewOnclick(View view) {
        startActivity(new Intent(this, ScrollviewActivity.class));
    }

    public void jumpListViewOnclick(View view) {
        startActivity(new Intent(this, ListviewActivity.class));
    }

    public void jumpRecycleviewOnclick(View view) {
        startActivity(new Intent(this, RecycleviewActivity.class));
    }

    public void jumpBackGroundOnclick(final View view) {

        screenShoot.creatShareBitmap(MainActivity.this, "http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg");

        screenShoot.setBitmapDone(new ScreenShoot.BitmapDoneListener() {
            @Override
            public void bitmapDone(Bitmap bitmap) {
                PopuUtil.showPopu(MainActivity.this, bitmap, view);
            }
        });
    }

    public void jumpPIPOnclick(View view) {
        startActivity(new Intent(this, PIPActivity.class));
    }
}
