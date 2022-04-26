package zc.test.com.mydemo.base;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import zc.test.com.mydemo.R;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder;
    public GradientDrawable gradientDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mUnbinder=ButterKnife.bind(this);
//        int mStartColor = getResources().getColor(R.color.colorPrimary);
//        int mEndColor = getResources().getColor(R.color.colorPrimaryDark);
//        int[] colors = {mStartColor, mEndColor};
//        gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimaryDark));//设置单一颜色
        init();
    }

    protected abstract int getContentView();

    protected abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
