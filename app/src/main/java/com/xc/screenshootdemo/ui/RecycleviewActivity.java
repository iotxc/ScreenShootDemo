package com.xc.screenshootdemo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xc.screenshootdemo.R;
import com.xc.screenshootdemo.adapter.RecycleviewAdapter;
import com.xc.screenshootdemo.util.PopuUtil;
import com.xc.screenshootdemo.util.ScreenShoot;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：activity截图
 */

public class RecycleviewActivity extends AppCompatActivity {

    private List<Integer> icons = new ArrayList<>();
    private RecycleviewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycleview_activity);

        mRecyclerView = findViewById(R.id.recycle_view);
        for (int i = 0; i < 3; i++) {
            icons.add(R.drawable.img1);
            icons.add(R.drawable.img2);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new RecycleviewAdapter(icons, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void recycleviewOnClick(View view) {
        Bitmap bitmap = ScreenShoot.shotRecyclerView(mRecyclerView);
        PopuUtil.showPopu(RecycleviewActivity.this, ScreenShoot.compressBitmap(bitmap), view);
    }
}
