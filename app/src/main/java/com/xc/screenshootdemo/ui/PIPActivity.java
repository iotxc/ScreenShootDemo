package com.xc.screenshootdemo.ui;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.xc.screenshootdemo.R;
import com.xc.screenshootdemo.util.ScreenShoot;

public class PIPActivity extends AppCompatActivity {

    ScreenShoot mScreenShoot;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pip);

        mImageView = findViewById(R.id.iv_pip);
        mScreenShoot = new ScreenShoot();
    }

    public void pipOnClick(View view) {
        Bitmap bitmap = mScreenShoot.loadBitmapFromView(mImageView);
        mScreenShoot.bitmapInBitmap(bitmap, mImageView);
    }
}
