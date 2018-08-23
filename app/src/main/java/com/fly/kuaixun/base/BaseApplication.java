package com.fly.kuaixun.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.tencent.smtt.sdk.QbSdk;
import com.fly.kuaixun.tool.LogUtil;

public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback callback = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg) {
                //x5內核初始化完成的回调，
                // true表示x5内核加载成功，
                // false表示x5内核加载失败，会自动切换到系统内核。
                LogUtil.e("===浏览器内核初始化："+arg);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };

        QbSdk.initX5Environment(getApplicationContext(), callback);
    }

    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }



}
