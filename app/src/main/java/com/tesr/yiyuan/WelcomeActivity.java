package com.tesr.yiyuan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity implements View.OnClickListener {
    private int recLen = 3;//跳过倒计时提示3秒
    private TextView tv;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_welcome);
        initView();
        timer.schedule(task, 1000, 1000);

        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
    private void initView() {
        tv = findViewById(R.id.tv_welcome);//跳过
        tv.setOnClickListener(this);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    tv.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        tv.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    /**
     * 点击跳过
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_welcome:
                Intent intent = new Intent(WelcomeActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }

}
