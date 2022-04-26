package zc.test.com.mydemo.base;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private View mRootView;
    private Unbinder mUnbinder;
    private TextView tvLeftTitle;
    private ImageView imgRight1,  imgRight2, imgRight3;
    public GradientDrawable gradientDrawable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mRootView==null){
            mRootView=inflater.inflate(getLayoutRes(), container, false);
            mUnbinder= ButterKnife.bind(this,mRootView);
            init();
        }else{
           ViewGroup viewGroup=(ViewGroup) mRootView.getParent();
           if(viewGroup!=null){
               viewGroup.removeView(mRootView);
           }
        }
        return mRootView;
    }




    protected abstract void init() ;

    protected abstract int getLayoutRes();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnbinder!=Unbinder.EMPTY){
            mUnbinder.unbind();
        }
    }

}
