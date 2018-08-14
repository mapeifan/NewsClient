package com.tesr.yiyuan;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.tesr.yiyuan.news.NewBean;
import com.tesr.yiyuan.news.NewContentBean;
import com.tesr.yiyuan.news.NewsListAdapter;
import com.tesr.yiyuan.news.NewsService;
import com.tesr.yiyuan.tool.AndroidScheduler;
import com.tesr.yiyuan.tool.UrlTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class NewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.listView)
    PullToRefreshListView listView;
    private Context context;
    private String[] titles = new String[]{    // 本来打算做几个模块的，想到自己这个项目只是个demo ，后面有时间可以完善下 做个完整的新闻demo吧
            "头条", "社会", "国内", "国际", "娱乐",
            "体育", "军事", "科技", "财经", "时尚"};
    protected Handler mHandler = new Handler();
    private   List<NewContentBean> news = new ArrayList<>();
    private NewsListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context=this;
        initPullToRefreshListView();
        listView.setOnItemClickListener(this);
        loadNews();
        adapter = new NewsListAdapter(this, news);
        listView.setAdapter(adapter);
    }
    private void initPullToRefreshListView() {
        // 下拉刷新
        listView.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新");
        listView.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        listView.getLoadingLayoutProxy(true, false).setReleaseLabel("释放立即刷新");
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                loadNews();
            }
        });
    }
    private void loadNews(){
        Map<String, String> params = new HashMap<>();
        params.put("showapi_appid", UrlTools.appid);
        params.put("showapi_sign", UrlTools.secret);
        params.put("channelId", "");
        params.put("channelName", "");
        params.put("title", "头条");
        params.put("page", "1");
        params.put("needContent", "0");
        params.put("needHtml", "0");
        params.put("needAllList", "0");
        params.put("maxResult", "200");
        params.put("id", "");
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(UrlTools.APP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        NewsService newsService = retrofit.create(NewsService.class);
        newsService.getNewsData(params).subscribeOn(Schedulers.io()).observeOn(AndroidScheduler.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                listView.onRefreshComplete();
            }

            @Override
            public void onError(Throwable e) {
                listView.onRefreshComplete();
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                String json = null;
                try {
                    json = new String(responseBody.bytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
                handleResult(json);
            }
        });

    }
    private  void handleResult(final String json) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                news.clear();
                NewBean newBean = new Gson().fromJson(json, NewBean.class);
                List<NewBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlistBeans = newBean.getShowapi_res_body().getPagebean().getContentlist();
                for (int i = 0; i < contentlistBeans.size(); i++) {
                    String title = contentlistBeans.get(i).getTitle();
                    String link = contentlistBeans.get(i).getLink();
                    String source=contentlistBeans.get(i).getSource();
                    String time=contentlistBeans.get(i).getPubDate();
                    NewContentBean contentBean=new NewContentBean();
                    contentBean.setTitle(title);
                    contentBean.setUrl(link);
                    contentBean.setSource(source);
                    contentBean.setTime(time);
                    news.add(contentBean);
                }
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startWebActivity(news.get(i-1).getUrl());
    }
    private void startWebActivity(String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


