package com.gucetong.xyay.lib_gucetong.utils;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gucetong.xyay.lib_gucetong.R;

/**
 * * 通用（主、子线程）的自定义Toast
 */
public class ToastUtil {
    private static final String TAG = "ToastUtil";

    private static Toast toast;
    private static Context context;

    public static void init(Application application){
        context = application.getApplicationContext();
    }

    //设置文字
    public static void showToast( String messages){
        toastProcess(messages,0x0,0x0);
    }

    //设置文字+icon
    public static void showToast(String messages,int ResId){
        toastProcess(messages,ResId,0x0);
    }

    //设置背景为绿色Success
    public static void showSuccessToast(String messages){
        toastProcess(messages, R.drawable.success,R.drawable.toast_bg_green);
    }

    //设置背景为绿色Success
    public static void showFailToast(String messages){
        toastProcess(messages,R.drawable.fail,R.drawable.toast_bg_red);
    }


    /**自定义toast
     * @param messages toast内容
     */
    private static void toastProcess(String messages,int IconResId,int BgResId) {
        int duration;
        if(messages.length()<12){
            duration=Toast.LENGTH_SHORT;
        }else{
            duration=Toast.LENGTH_LONG;
        }
        if (toast != null) {
            toast.cancel();
        }
        toast = new Toast(context.getApplicationContext());
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.coustom_toast, null);
        LinearLayout bg = (LinearLayout) view.findViewById(R.id.toast_linear);
        ImageView icon = (ImageView)view.findViewById(R.id.toast_img);
        TextView text = (TextView)view.findViewById(R.id.toast_content);
        if(IconResId==0x0){
            icon.setVisibility(View.GONE);
        }else{
            icon.setVisibility(View.VISIBLE);
            icon.setImageResource(IconResId);//toasticon
        }

        //设置setBackgroundResource后要重新设置边距
        int left = bg.getPaddingLeft();
        int top = bg.getPaddingTop();
        int right = bg.getPaddingRight();
        int bottom = bg.getPaddingBottom();
        if(BgResId==0x0){
            bg.setBackgroundResource(R.drawable.toast_bg_normal);
        }else{
            bg.setBackgroundResource(BgResId);
        }
        bg.setPadding(left, top, right, bottom);

        text.setText(messages); //toast内容
        //获取屏幕高度
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        //Toast的Y坐标是屏幕高度的1/3，不会出现不适配的问题
        toast.setGravity(Gravity.BOTTOM, 0, height / 3);
        //setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
        toast.setDuration(duration);
        //setDuration方法：设置持续时间，以毫秒为单位。该方法是设置补间动画时间长度的主要方法
        toast.setView(view);
        //添加视图文件
        toast.show();
    }




}


