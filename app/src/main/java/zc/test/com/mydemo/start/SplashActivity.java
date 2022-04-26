package zc.test.com.mydemo.start;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zc.test.com.mydemo.MainActivity;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseActivity;
import zc.test.com.mydemo.base.BaseApplication;
import zc.test.com.mydemo.test.WebActivity;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    private Handler mHandler;

    @Override
    protected void init() {
        BaseApplication.getInstance().addActivity(this);

        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        },1000);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }
}
