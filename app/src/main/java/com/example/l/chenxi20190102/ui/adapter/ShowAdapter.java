package com.example.l.chenxi20190102.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.l.chenxi20190102.R;
import com.example.l.chenxi20190102.data.ShowBean;

import java.util.ArrayList;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.SubViewHolder>{
    ArrayList<ShowBean.DataBean> beanList;
    Context context;
    public void setData(Context context, ArrayList<ShowBean.DataBean> beanList) {
          this.beanList = beanList;
          this.context = context;
    }

    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        //填充子布局
        View rootView = LayoutInflater.from(context).inflate(R.layout.show_item_layout, viewGroup, false);
        //设置viewholder
        SubViewHolder subViewHolder = new SubViewHolder(rootView);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, int position) {
        subViewHolder.tv_title.setText("创建时间是："+beanList.get(position).getTuijian());
        //加载图片
        Glide.with(context).load(beanList.get(position).getTuijian()).into(subViewHolder.iv_icon);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        ImageView iv_icon;
        
        public SubViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
