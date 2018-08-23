package com.fly.kuaixun.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.fly.kuaixun.R;
import com.fly.kuaixun.adapter.NewsViewPagerAdapter;
import com.fly.kuaixun.tool.ToolsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsActivity extends AppCompatActivity{
    private String[] titles = new String[]{
            "头条", "社会", "国内", "国际", "娱乐",
            "体育", "军事", "科技", "财经", "时尚"};
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;
    private NewsViewPagerAdapter mFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadMovieChannel();
    }
    /**
     * 加载电影频道
     */
    private void loadMovieChannel() {
        List<NewsFragment> mNewsFragmentList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            mNewsFragmentList.add(createListFragments(i));
        }
        if (mFragmentAdapter == null) {
            mFragmentAdapter = new NewsViewPagerAdapter(getSupportFragmentManager(), mNewsFragmentList, Arrays.asList(titles));
        } else {
            //刷新fragment
            mFragmentAdapter.setFragments(getSupportFragmentManager(), mNewsFragmentList, Arrays.asList(titles));
        }
        mVpContent.setAdapter(mFragmentAdapter);
        mTabs.setupWithViewPager(mVpContent);
        ToolsUtil.dynamicSetTabLayoutMode(mTabs);
        mTabs.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.black));

    }

    private NewsFragment createListFragments(int index) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", titles[index]);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


