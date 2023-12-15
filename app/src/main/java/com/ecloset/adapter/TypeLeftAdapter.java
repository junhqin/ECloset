package com.ecloset.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ecloset.R;


public class TypeLeftAdapter extends BaseAdapter {
    private Context mContext;
    private int mSelect = 0;//选中项
    private String[] titles = new String[]{"上衣", "下装", "外套", "配件", "包包", "配饰","鞋子"};
    public TypeLeftAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_type, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText(titles[position]);

        if (mSelect == position) {
            convertView.setBackgroundResource(R.drawable.type_item_background_selector);  //选中项背景
            holder.tv_name.setTextColor(Color.parseColor("#BB86FC"));
        } else {
            convertView.setBackgroundResource(R.drawable.bg2);  //其他项背景
            holder.tv_name.setTextColor(Color.parseColor("#323437"));
        }
        return convertView;
    }
    public String changeSelected(int positon) { //刷新方法
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
        return titles[positon];
    }

    static class ViewHolder {
        private TextView tv_name;
    }



}
