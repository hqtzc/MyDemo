package com.gucetong.xyay.lib_gucetong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author hsq
 * on 2019/5/27 11:31
 *
 */

public class StretchScrollView extends ScrollView {
    private boolean isScrolledToTop = true;
    private boolean isScrolledToBottom;

    public StretchScrollView(Context context) {
        super(context);
    }

    public StretchScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StretchScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (getScrollY() == 0) {    // 小心踩坑1: 这里不能是getScrollY() <= 0
            setScrolledToTop(true);
            setScrolledToBottom(false);
        } else if (getScrollY() + getHeight() - getPaddingTop()-getPaddingBottom() == getChildAt(0).getHeight()) {
            // 小心踩坑2: 这里不能是 >=
            // 小心踩坑3（可能忽视的细节2）：这里最容易忽视的就是ScrollView上下的padding　
            setScrolledToTop(false);
            setScrolledToBottom(true);
        } else {
            setScrolledToTop(false);
            setScrolledToBottom(false);
        }
    }


    public boolean isScrolledToTop() {
        return isScrolledToTop;
    }

    public void setScrolledToTop(boolean scrolledToTop) {
        isScrolledToTop = scrolledToTop;
    }

    public boolean isScrolledToBottom() {
        return isScrolledToBottom;
    }

    public void setScrolledToBottom(boolean scrolledToBottom) {
        isScrolledToBottom = scrolledToBottom;
    }
}
