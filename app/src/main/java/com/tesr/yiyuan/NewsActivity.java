package com.tesr.yiyuan;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.tesr.yiyuan.news.NewBean;
import com.tesr.yiyuan.news.NewContentBean;
import com.tesr.yiyuan.news.NewsListAdapter;
import com.tesr.yiyuan.news.NewsService;
import com.tesr.yiyuan.tool.AndroidScheduler;
import com.tesr.yiyuan.tool.LogUtil;
import com.tesr.yiyuan.tool.UrlTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
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
    @BindViews({R.id.tv_new_name, R.id.tv_new_page})
    List<TextView> textViews;
    private Context context;
    // 本来打算做几个模块的，想到自己这个项目只是个demo ，后面有时间可以完善下 做个完整的新闻demo吧
    // 目前已做随机刷新 模块内容（机智如我）
    private String[] titles = new String[]{
            "头条", "社会", "国内", "国际", "娱乐",
            "体育", "军事", "科技", "财经", "时尚"};
    protected Handler mHandler = new Handler();
    private List<NewContentBean> news = new ArrayList<>();
    private NewsListAdapter adapter;
    private String newsType = "头条";
    private int newsPage = 1;
    private int newsPageSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        initPullToRefreshListView();
        listView.setOnItemClickListener(this);
        loadNews(titles[0], newsPage);
        adapter = new NewsListAdapter(this, news);
        listView.setAdapter(adapter);
    }

    private void initPullToRefreshListView() {
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        ILoadingLayout startLabels = listView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在刷新...");
        startLabels.setReleaseLabel("释放立即刷新");

        ILoadingLayout endLabels = listView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉刷新");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("释放立即刷新");
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                newsType = titles[(int) (Math.random() * (titles.length))];
                newsPage = 1;
                loadNews(newsType, newsPage);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                if (newsPage == newsPageSize) {
                    Toast.makeText(NewsActivity.this, "我是有底线的！", Toast.LENGTH_SHORT).show();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(100);
                            listView.onRefreshComplete();
                        }
                    });
                    return;
                }
                newsPage++;
                loadNews(newsType, newsPage);
            }
        });
    }

    private void loadNews(String newsType, int newsPage) {
        Map<String, String> params = new HashMap<>();
        params.put("showapi_appid", UrlTools.appid);
        params.put("showapi_sign", UrlTools.secret);
        params.put("channelId", "");
        params.put("channelName", "");
        params.put("title", newsType);
        params.put("page", "" + newsPage);
        params.put("needContent", "0");
        params.put("needHtml", "0");
        params.put("needAllList", "0");
        params.put("maxResult", "50");
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

    private void handleResult(final String json) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                news.clear();
                NewBean newBean = new Gson().fromJson(json, NewBean.class);
                NewBean.ShowapiResBodyBean.PagebeanBean pagebeanBean = newBean.getShowapi_res_body().getPagebean();
                newsPageSize = pagebeanBean.getAllPages();
                List<NewBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlistBeans = newBean.getShowapi_res_body().getPagebean().getContentlist();

                for (int i = 0; i < contentlistBeans.size(); i++) {
                    int images = contentlistBeans.get(i).getImageurls().size();
                    String urls = null;
                    if (images != 0) {
                        for (int a = 0; a < images; a++) {
                            urls = contentlistBeans.get(i).getImageurls().get(0).getUrl();
                        }
                    }
                    String title = contentlistBeans.get(i).getTitle();
                    String link = contentlistBeans.get(i).getLink();
                    String source = contentlistBeans.get(i).getSource();
                    String time = contentlistBeans.get(i).getPubDate();
                    String imageUrl = null;
                    if (images == 0) {
                        imageUrl = "null_image_url";
                    } else {
                        imageUrl = urls;
                    }
                    NewContentBean contentBean = new NewContentBean();
                    contentBean.setTitle(title);
                    contentBean.setUrl(link);
                    contentBean.setSource(source);
                    contentBean.setTime(time);
                    contentBean.setImagUrl(imageUrl);
                    news.add(contentBean);
                }
                listView.getRefreshableView().setSelection(1);  //回到第一行item
                adapter.notifyDataSetInvalidated();
                textViews.get(0).setText("NEWS - " + newsType);  // 暂时写在这里
                textViews.get(1).setText("" + newsPage + " - " + newsPageSize);  // 暂时写在这里
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startWebActivity(news.get(i - 1).getUrl());
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


