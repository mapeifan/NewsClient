package com.tesr.yiyuan.adapter;

import android.support.v4.app.FragmentManager;
import com.tesr.yiyuan.ui.NewsFragment;
import com.tesr.yiyuan.base.BaseFragmentAdapter;

import java.util.List;


public class NewsViewPagerAdapter extends BaseFragmentAdapter {
    public NewsViewPagerAdapter(FragmentManager fm, List<NewsFragment> fragmentList, List<String> mTitles) {
        super(fm, fragmentList, mTitles);
    }

    public NewsViewPagerAdapter(FragmentManager fm, List<NewsFragment> fragmentList) {
        super(fm, fragmentList);
    }
}
