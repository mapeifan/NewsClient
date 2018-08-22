package com.tesr.yiyuan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tesr.yiyuan.ui.LoginActivity;
import com.tesr.yiyuan.ui.NewsActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends Activity implements View.OnClickListener {
    private int recLen = 3;//跳过倒计时提示3秒
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    @BindView(R.id.tv_welcome)
    TextView tv;
    @BindView(R.id.rl_welcome_break)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
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
        relativeLayout.setOnClickListener(this);
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
            case R.id.rl_welcome_break:
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
