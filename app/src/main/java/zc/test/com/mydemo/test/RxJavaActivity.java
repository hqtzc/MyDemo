package zc.test.com.mydemo.test;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseActivity;

/**
 * 测试rxjava
 */
public class RxJavaActivity extends BaseActivity {
    private static final String TAG = "Rxjava";
    private Disposable mDisposable1;

    @Override
    protected int getContentView() {
        return R.layout.activity_rx_java;
    }

    @Override
    protected void init() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // RxJava的流式操作
        Observable.fromIterable(list)
                .subscribe(new Observer<Integer>() {
                    // 2. 通过通过订阅（subscribe）连接观察者和被观察者
                    // 3. 创建观察者 & 定义响应事件的行为
                    // 1. 定义Disposable类变量
                    private Disposable mDisposable;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                        mDisposable=d;
                    }
                    // 默认最先调用复写的 onSubscribe（）

                    @Override
                    public void onNext(Integer value) {
                        Log.d(TAG, "对Next事件"+ value +"作出响应"  );
                        if (value == 2) {
                            // 设置在接收到第二个事件后切断观察者和被观察者的连接
                            mDisposable.dispose();
                            Log.d(TAG, "已经切断了连接：" + mDisposable.isDisposed());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }

        });

        // 参数说明：
        // 参数1 = 第1次延迟时间；
        // 参数2 = 间隔时间数字；
        // 参数3 = 时间单位；
        Observable.interval(3,3, TimeUnit.SECONDS)
                // 该例子发送的事件序列特点：延迟3s后发送事件，每隔1秒产生1个数字（从0开始递增1，无限个）
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                        mDisposable1=d;
                    }
                    // 默认最先调用复写的 onSubscribe（）

                    @Override
                    public void onNext(Long value) {
                        Log.d(TAG, "接收到了事件"+ value  );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }

                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mDisposable1!=null && mDisposable1.isDisposed()==false){
            mDisposable1.dispose();
        }
    }
}