package zc.test.com.mydemo.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.gucetong.xyay.lib_gucetong.utils.LogUtils;
import com.gucetong.xyay.lib_gucetong.utils.ToastUtil;
import com.tencent.bugly.crashreport.CrashReport;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.utils.UpdateUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import zc.test.com.mydemo.service.OKHttpUpdateHttpService;

import static com.xuexiang.xupdate.entity.UpdateError.ERROR.CHECK_NO_NEW_VERSION;

/**
 * Created by ZC
 */
public class BaseApplication extends Application {

    private static Context context;
    private static BaseApplication instance;
    private List<Activity> activityList = new LinkedList<Activity>();
    private SharedPreferences settings;

    public BaseApplication(){

    }

    public static BaseApplication getInstance(){
        if(null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        ToastUtil.init(this);

        //是否打印Log
        LogUtils.setLogEnable(true);

        closeAndroidPDialog();

        //初始化版本更新框架
        XUpdate.get()
                .debug(true)
                .isWifiOnly(false)                                               //默认设置只在wifi下检查版本更新
                .isGet(true)                                                    //默认设置使用get请求检查版本
                .isAutoMode(false)                                              //默认设置非自动模式，可根据具体使用配置
                .param("versionCode", UpdateUtils.getVersionCode(this))         //设置默认公共请求参数
                .param("appKey", getPackageName())
                .setOnUpdateFailureListener(new OnUpdateFailureListener() {     //设置版本更新出错的监听
                    @Override
                    public void onFailure(UpdateError error) {
                        if (error.getCode() != CHECK_NO_NEW_VERSION) {          //对不同错误进行处理
                            ToastUtil.showToast(error.toString());
                        }
                    }
                })
                .supportSilentInstall(true)                                     //设置是否支持静默安装，默认是true
                .setIUpdateHttpService(new OKHttpUpdateHttpService())           //这个必须设置！实现网络请求功能。
                .init(this);                                                    //这个必须初始化

        //异常上传初始化
        CrashReport.initCrashReport(getApplicationContext(), "745186457d", false);
    }




    /**
     * 清除登录状态
     */
    public void clearLoginState(){
//        setdeletePush(getToken());
        settings = context.getSharedPreferences("tysjdb", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("userId", 0);
        editor.putString("token", "");
        editor.putString("avatar", "");
        editor.putString("trueName", "");
        editor.putString("userBalance", "0");
        editor.putBoolean("islogin",false);
        editor.commit();
    }

    /**
     * 判断是否是登录
     * @return
     */
    public boolean isLogin(){
        boolean myislogin=false;
        settings = context.getSharedPreferences("tysjdb", 0);
        boolean islogin = settings.getBoolean("islogin",false);
        String token = settings.getString("token","");
        if(islogin==true && token.isEmpty()!=true && !token.equals("")){
            myislogin=true;
        }
        return myislogin;
    }

    /**
     * 添加activity到堆栈中
     * @param activity
     */
    public void addActivity(Activity activity){
        activityList.add(activity);
    }

    /**
     * 遍历activityList中所有activity并退出
     */
    public void exit(){
        try {
            for (Activity activity : activityList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //用于在AndroidP机型上弹出（Detected problems with API...）
    private void closeAndroidPDialog(){
        if(Build.VERSION.SDK_INT>=28) {
            try {
                Class aClass = Class.forName("android.content.pm.PackageParser$Package");
                Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
                declaredConstructor.setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
                declaredMethod.setAccessible(true);
                Object activityThread = declaredMethod.invoke(null);
                Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
                mHiddenApiWarningShown.setAccessible(true);
                mHiddenApiWarningShown.setBoolean(activityThread, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
