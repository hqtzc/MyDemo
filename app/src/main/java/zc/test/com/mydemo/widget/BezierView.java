package zc.test.com.mydemo.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RemoteViews;

import zc.test.com.mydemo.R;

/**
 * Implementation of App Widget functionality.
 */
public class BezierView extends View {

    private Paint mpaint;
    private Path mpath;
    private Point startpoint;
    private Point endpoint;
    private Point assistpoint;
    private int mScreenHeight;
    private int mScreenWidth;

    public BezierView(Context context) {
        super(context,null);
        init(context);
    }

    public BezierView(Context context,AttributeSet attrs) {
        super(context,attrs);
        init(context);
    }

    public BezierView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mpaint = new Paint();
        mpath = new Path();
        //抗锯齿
        mpaint.setAntiAlias(true);
        //防抖动
        mpaint.setDither(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mScreenHeight = h;
        mScreenWidth = w;

//        mStartX = 0;
//        mStartY = mScreenHeight/2;
//
//        mCenterX = mScreenWidth / 2;
//        mCenterY = mScreenHeight;
//
//        mEndX = mScreenWidth;
//        mEndY = mScreenHeight/2;
        startpoint = new Point(120,100);
        endpoint = new Point(520,120);
        assistpoint = new Point(300,260);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔颜色
        mpaint.setColor(Color.BLACK);
        //画笔宽
        mpaint.setStrokeWidth(5);
        //空心
        mpaint.setStyle(Paint.Style.STROKE);
        //实心
//        mpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //重置路径
        mpath.reset();
        //起点
        mpath.moveTo(startpoint.x,startpoint.y);
        //重要的这句
        mpath.quadTo(assistpoint.x,assistpoint.y,endpoint.x,endpoint.y);
        //画路径
        canvas.drawPath(mpath,mpaint);
        //画辅助点
//        canvas.drawPoint(assistpoint.x,assistpoint.y,mpaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                assistpoint.x = (int)event.getX();
                assistpoint.y = (int)event.getY();
                invalidate();
                break;

        }
        return true;
    }


}

