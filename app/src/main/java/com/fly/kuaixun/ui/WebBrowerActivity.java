package com.fly.kuaixun.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fly.kuaixun.R;
import com.github.ybq.android.spinkit.SpinKitView;

public class WebBrowerActivity extends Activity {

    private SpinKitView spinKitView;
    private WebView webView;
    private String url;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    spinKitView.setVisibility(View.VISIBLE);
                    webView.loadUrl(url);
                    break;
                case 2:
                    spinKitView.setVisibility(View.GONE);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content);
        webView = (WebView) findViewById(R.id.webview_2);
        url = getIntent().getStringExtra("url");
        initWebView();
        mHandler.sendEmptyMessage(1);

    }

    private void initWebView() {
        spinKitView =(SpinKitView)findViewById(R.id.spin_kit_2) ;
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setSavePassword(false);
//        // 设置可以支持缩放
//        webSettings.setSupportZoom(true);
//        // 扩大比例的缩放
//        webSettings.setUseWideViewPort(true);
//        // 自适应屏幕
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setDomStorageEnabled(true);//这句话必须保留。。否则无法播放优酷视频网页。。其他的可以
        webView.setWebChromeClient(new WebChromeClient());//这行最好不要丢掉
       // webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        WebView.setWebContentsDebuggingEnabled(true);   // 调试需要。。。。appium 测试
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                //webView.loadUrl(url);   // 不支持 网页内 跳转其他链接，体验不好
                return true;
            }

            @Override
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
//                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                sslErrorHandler.proceed();//忽略SSL证书错误
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView webView, String s, String s1, JsResult jsResult) {
                return super.onJsAlert(webView, s, s1, jsResult);
            }

            @Override
            public void onReceivedTitle(WebView webView, String s) {
                super.onReceivedTitle(webView, s);
            }

            @Override
            public void onProgressChanged(WebView webView, int progress) {
                super.onProgressChanged(webView, progress);
                if (progress==100){
                    mHandler.sendEmptyMessage(2);
                }
                //   LogUtil.e("============加载进度："+progress);

            }
        });

    }
}

