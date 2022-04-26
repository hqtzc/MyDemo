package zc.test.com.mydemo.presenter;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.gucetong.xyay.lib_gucetong.utils.LogUtils;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import zc.test.com.mydemo.bean.ContactBean;
import zc.test.com.mydemo.bean.HtmlBean;
import zc.test.com.mydemo.constants.Constants;
import zc.test.com.mydemo.constants.NetWorkConfig;
import zc.test.com.mydemo.service.OKHttpUpdateHttpService;

public class CreatePresenter {

    private Context mContext;
    private CreateInteractor mView;
    private OKHttpUpdateHttpService ok;

    public CreatePresenter(Context  context, Activity activity) {
        mContext =context;
        mView=(CreateInteractor)activity;
    }

    public CreatePresenter(Fragment fragment) {
        mView=(CreateInteractor)fragment;
    }

    public void getApp() {
        ConcurrentMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("apply_id",""+ Constants.CREATE_APPLYID);
        map.put("module_id", "" + Constants.CREATE_MODULEID);
        ok = OKHttpUpdateHttpService.getInstance();
        ok.asyncGet(NetWorkConfig.CREATE_GETAPP, map, new IUpdateHttpService.Callback() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("getApp************", "" + result);
                jsonData(result);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.returnError(throwable.getMessage());
            }
        });
    }
    private void jsonData(String result) {
        Gson gson = new Gson();
        try {
            HtmlBean htmlBean = gson.fromJson(result, HtmlBean.class);
            mView.returnApp(htmlBean);
        }catch (JsonSyntaxException e){
            mView.returnError(e.getMessage());
        }
    }


}
