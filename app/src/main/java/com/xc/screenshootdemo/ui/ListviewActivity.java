package com.xc.screenshootdemo.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.xc.screenshootdemo.R;
import com.xc.screenshootdemo.adapter.ListViewToBitmapAdapter;
import com.xc.screenshootdemo.util.PopuUtil;
import com.xc.screenshootdemo.util.ScreenShoot;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：activity截图
 */

public class ListviewActivity extends AppCompatActivity {

    private ListViewToBitmapAdapter mListViewToBitmapAdapter;
    private List<Integer> icons = new ArrayList<>();
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_view_activity);

        mListView = findViewById(R.id.list_view);

        for (int i = 0; i < 10; i++) {
            icons.add(R.drawable.img1);
            icons.add(R.drawable.img2);
        }

        mListViewToBitmapAdapter = new ListViewToBitmapAdapter(icons, this);

        mListView.setAdapter(mListViewToBitmapAdapter);

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {

                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:    //当停止滚动时
                        Toast.makeText(ListviewActivity.this, "" +
                                        mListView.getFirstVisiblePosition() + "/" + 10,
                                Toast.LENGTH_SHORT).show();

                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:    //滚动时

                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:   //手指抬起，但是屏幕还在滚动状态

                        break;


                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    public void listViewOnClick(View view) {
        Bitmap bitmap = ScreenShoot.shotListView(mListView);
        PopuUtil.showPopu(ListviewActivity.this, ScreenShoot.compressBitmap(bitmap), view);
    }
}
