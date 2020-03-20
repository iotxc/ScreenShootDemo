package com.xc.screenshootdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.xc.screenshootdemo.R;

import java.util.List;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：
 */

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewHolder> {

    private List<Integer> icons;
    private Context mContext;

    public RecycleviewAdapter(List<Integer> icons, Context context) {
        this.icons = icons;
        mContext = context;
    }

    @Override
    public RecycleviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.img_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecycleviewAdapter.MyViewHolder holder, int position) {
        Glide.with(mContext).load(icons.get(position)).asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.mImageView.setImageBitmap(resource);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return icons==null?0:icons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv);
        }
    }
}
