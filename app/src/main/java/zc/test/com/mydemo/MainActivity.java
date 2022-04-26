package zc.test.com.mydemo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import zc.test.com.mydemo.adapter.NavigationAdapter;
import zc.test.com.mydemo.base.BaseActivity;
import zc.test.com.mydemo.base.BaseApplication;
import zc.test.com.mydemo.base.FragmentPagerAdapter;
import zc.test.com.mydemo.entity.TabEntity;
import zc.test.com.mydemo.main.ContactFragment;
import zc.test.com.mydemo.main.HomeFragment;
import zc.test.com.mydemo.main.MoreFragment;
import zc.test.com.mydemo.main.MsgFragment;
import zc.test.com.mydemo.widget.NoScrollViewPager;

public class MainActivity extends BaseActivity implements NavigationAdapter.OnNavigationListener {
    @BindView(R.id.vp_home_pager)
    NoScrollViewPager vpHomePager;
    @BindView(R.id.rv_home_navigation)
    RecyclerView rvHomeNavigation;
//    @BindView(R.id.custombar)
//    Toolbar custombar;SettingsActivity

    private static final String INTENT_KEY_IN_FRAGMENT_INDEX = "fragmentIndex";
    private static final String INTENT_KEY_IN_FRAGMENT_CLASS = "fragmentClass";

    private boolean isChanged;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private static Boolean isExit = false;

    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private View mDecorView;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private NavigationAdapter mNavigationAdapter;
    private FragmentPagerAdapter<Fragment> mPagerAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void init() {
//        custombar.setBackground(gradientDrawable);
//        StatusBarUtil.setGradientColor(MainActivity.this, custombar);//设置渐变色
        BaseApplication.getInstance().addActivity(this);

        mPagerAdapter = new FragmentPagerAdapter<>(this);
        mPagerAdapter.addFragment(HomeFragment.newInstance(""));
        mPagerAdapter.addFragment(MsgFragment.newInstance(""));
        mPagerAdapter.addFragment(ContactFragment.newInstance(""));
        mPagerAdapter.addFragment(MoreFragment.newInstance(""));
        vpHomePager.setAdapter(mPagerAdapter);


        mNavigationAdapter = new NavigationAdapter(this);
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_index),
                ContextCompat.getDrawable(this, R.drawable.home_home_selector)));
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_found),
                ContextCompat.getDrawable(this, R.drawable.home_found_selector)));
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_message),
                ContextCompat.getDrawable(this, R.drawable.home_message_selector)));
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_me),
                ContextCompat.getDrawable(this, R.drawable.home_me_selector)));
        mNavigationAdapter.setOnNavigationListener(this);
        rvHomeNavigation.setAdapter(mNavigationAdapter);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 保存当前 Fragment 索引位置
        outState.putInt(INTENT_KEY_IN_FRAGMENT_INDEX, vpHomePager.getCurrentItem());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // 恢复当前 Fragment 索引位置
        switchFragment(savedInstanceState.getInt(INTENT_KEY_IN_FRAGMENT_INDEX));
    }

    private void switchFragment(int fragmentIndex) {
        if (fragmentIndex == -1) {
            return;
        }

        switch (fragmentIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
                vpHomePager.setCurrentItem(fragmentIndex);
                mNavigationAdapter.setSelectedPosition(fragmentIndex);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
                vpHomePager.setCurrentItem(position);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0) {
            exitBy2Click(); // 调用双击退出函数
            return false;
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 双击退出函数
     */
    private void exitBy2Click() {
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            ((BaseApplication) getApplication()).exit();
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };


}
