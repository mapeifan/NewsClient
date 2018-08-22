package com.tesr.yiyuan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tesr.yiyuan.bean.NewContentBean;
import com.tesr.yiyuan.R;
import com.tesr.yiyuan.tool.LogUtil;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * “FLY 快讯”加载适配器
 */

public class NewsListAdapter extends BaseAdapter {
    private Context context;
    private List<NewContentBean> newsBeens;

    public NewsListAdapter(Context context, List<NewContentBean> newsBeens) {
        this.context = context;
        this.newsBeens = newsBeens;
    }

    @Override
    public int getCount() {
        return newsBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return newsBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        NewContentBean newsBean = newsBeens.get(position);
        // LogUtil.e("===图片:"+newsBean.getTitle()+"===="+newsBean.getImagUrl());
        if (newsBean.getImagUrl().equalsIgnoreCase("null_image_url")){
            Glide.with(context).load(R.drawable.ic_empty_picture).into(holder.image);
        }else {
            Glide.with(context).load(newsBean.getImagUrl()).into(holder.image);
        }

        holder.title.setText(newsBean.getTitle());
        holder.source.setText(newsBean.getSource());
        holder.time.setText(newsBean.getTime());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView image;
        @BindView(R.id.tv_news_title)
        TextView title;
        @BindView(R.id.tv_news_source)
        TextView source;
        @BindView(R.id.tv_news_time)
        TextView time;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
