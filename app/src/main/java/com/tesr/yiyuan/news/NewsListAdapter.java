package com.tesr.yiyuan.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tesr.yiyuan.tool.LogUtil;
import com.tesr.yiyuan.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * “头条新闻”加载适配器
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
    //    holder.image.setImageUrl(newsBean.getImgurl());
        LogUtil.e("===adapter:"+position+newsBean.getTitle());
      //  Glide.with(this).load(url).into(holder.time);
        holder.title.setText(newsBean.getTitle());
        holder.source.setText(newsBean.getSource());
        holder.time.setText(newsBean.getTime());
        return convertView;
    }

    static class ViewHolder {
//        @BindView(R.id.image)
//        ImageView image;
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
