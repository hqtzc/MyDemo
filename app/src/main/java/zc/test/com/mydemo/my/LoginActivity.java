package zc.test.com.mydemo.my;


import android.os.Bundle;

import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseActivity;
import zc.test.com.mydemo.base.BaseApplication;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void init() {
        BaseApplication.getInstance().addActivity(this);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }
}
