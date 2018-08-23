package com.fly.kuaixun.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fly.kuaixun.R;
import com.fly.kuaixun.tool.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {
    @BindViews({R.id.edit_login_user_name, R.id.edit_login_user_password})
    List<EditText> editTexts;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dp);
        ButterKnife.bind(this);
    }
    public void Login(View view){
        if (!TextUtils.isEmpty(editTexts.get(0).getText().toString())&&!TextUtils.isEmpty(editTexts.get(1).getText().toString())){
            if (editTexts.get(0).getText().toString().equalsIgnoreCase("admin")&&editTexts.get(1).getText().toString().equalsIgnoreCase("123456")){
                Toast.makeText(this,"登录成功，即将跳转",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
            }else {
                LogUtil.e("======错误：尝试登录账户及密码："+editTexts.get(0).getText().toString());
                Toast.makeText(this,"登录失败,账户或密码错误！",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"登录失败,账户或密码为空！",Toast.LENGTH_SHORT).show();
        }
    }
}
