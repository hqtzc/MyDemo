package zc.test.com.mydemo.presenter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zc.test.com.mydemo.constants.NetWorkConfig;

public class RegisterPresenter {

    private Context mContext;
    private RegistInteractor mView;

    public RegisterPresenter(Context  context, Activity activity) {
        mContext =context;
        mView=(RegistInteractor)activity;
    }

    public RegisterPresenter(Fragment fragment) {
        mView=(RegistInteractor)fragment;
    }

    public void getImageCode() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(NetWorkConfig.VERIFY).build();
        mOkHttpClient
                .newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        byte[] bytes = response.body().bytes();
                        Log.e("图形验证码", "==" + bytes);
                        //获取session的操作，session放在cookie头，且取出后含有“；”，取出后为下面的 s （也就是jsesseionid）
                        Headers headers = response.headers();
                        List<String> cookies = headers.values("Set-Cookie");
                        Log.e("********22", cookies.toString());
                        try{
                            String session = cookies.get(0);
                            String s = session.substring(0, session.indexOf(";"));
                            Log.e("********", "" + s);
                            mView.getBitmapFromByte(bytes);
                        }catch (IndexOutOfBoundsException e){}

                    }
                });

    }

}
