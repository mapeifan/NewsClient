package com.fly.kuaixun.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.fly.kuaixun.R;
import com.fly.kuaixun.bean.NewBean;
import com.fly.kuaixun.bean.NewContentBean;
import com.fly.kuaixun.adapter.NewsListAdapter;
import com.fly.kuaixun.mode.NewsService;
import com.fly.kuaixun.tool.AndroidScheduler;
import com.fly.kuaixun.tool.UrlTool;

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

public class NewsFragment extends Fragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.listView)
    PullToRefreshListView listView;
    protected Handler mHandler = new Handler();
    private List<NewContentBean> news = new ArrayList<>();
    private NewsListAdapter adapter;
    private String mMovieGenres;
    private int newsPage = 1;
    private int newsPageSize;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        initUi(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initUi(View view) {
        if (getArguments() != null) {
            mMovieGenres = getArguments().getString("type");
        }
        initPullToRefreshListView();
        listView.setOnItemClickListener(this);
        loadNews(mMovieGenres, newsPage);
        if(mContext!=null){
            adapter = new NewsListAdapter(mContext, news);
            listView.setAdapter(adapter);
        }
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
                //  newsType = titles[(int) (Math.random() * (titles.length))];  //随机去掉
                newsPage = 1;
                loadNews(mMovieGenres, newsPage);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                if (newsPage == newsPageSize) {
                    Toast.makeText(getActivity(), "我是有底线的！", Toast.LENGTH_SHORT).show();
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
                loadNews(mMovieGenres, newsPage);
            }
        });
    }

    private void loadNews(String newsType, int newsPage) {
        Map<String, String> params = new HashMap<>();
        params.put("showapi_appid", UrlTool.appid);
        params.put("showapi_sign", UrlTool.secret);
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
                .baseUrl(UrlTool.APP_URL)
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
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i>=1){
            String url=news.get(i - 1).getUrl();
            startWebActivity(url);
        }else {
            String url="https://github.com/mapeifan/NewsClient";
            startWebActivity(url);
        }
    }

    private void startWebActivity(String url) {
        Intent intent = new Intent(mContext, WebActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
