package com.tesr.yiyuan.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import com.tesr.yiyuan.tool.ToolsUtil;
import com.tesr.yiyuan.ui.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentAdapter extends FragmentPagerAdapter {

    List<NewsFragment> fragmentList = new ArrayList<NewsFragment>();
    private List<String> mTitles;

    public BaseFragmentAdapter(FragmentManager fm, List<NewsFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm, List<NewsFragment> fragmentList, List<String> mTitles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return !ToolsUtil.isNullOrEmpty(mTitles) ? mTitles.get(position) : "";
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //刷新fragment
    public void setFragments(FragmentManager fm, List<NewsFragment> fragments, List<String> mTitles) {
        this.mTitles = mTitles;
        if (this.fragmentList != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.fragmentList) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            ft = null;
            fm.executePendingTransactions();
        }
        this.fragmentList = fragments;
        notifyDataSetChanged();
    }
}
