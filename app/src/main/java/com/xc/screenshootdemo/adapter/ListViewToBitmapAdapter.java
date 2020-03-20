package com.xc.screenshootdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.xc.screenshootdemo.R;

import java.util.List;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：
 */

public class ListViewToBitmapAdapter extends BaseAdapter {

    private List<Integer> icons;

    private Context mContext;

    public ListViewToBitmapAdapter(List<Integer> icons, Context context){
        this.icons = icons;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return icons==null?0:icons.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.img_item,parent,false);
            vHolder = new ViewHolder();
            vHolder.iv = ((ImageView) convertView.findViewById(R.id.iv));
            convertView.setTag(vHolder);
        }else{
            vHolder = (ViewHolder) convertView.getTag();
        }
        vHolder.iv.setImageResource(icons.get(position));
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
    }
}
