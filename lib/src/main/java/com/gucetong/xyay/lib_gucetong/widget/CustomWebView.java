package com.gucetong.xyay.lib_gucetong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * author:  hsq
 * date  : 2019-05-29
 * desc  :
 */

public class CustomWebView extends WebView {

    public CustomWebView(Context context) {
        this(context, null);
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        if (clampedY && scrollY == 0){
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }
}
