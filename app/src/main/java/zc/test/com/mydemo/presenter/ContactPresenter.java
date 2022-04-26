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
import zc.test.com.mydemo.constants.NetWorkConfig;
import zc.test.com.mydemo.service.OKHttpUpdateHttpService;

public class ContactPresenter {

    private Context mContext;
    private ContactInteractor mView;
    private OKHttpUpdateHttpService ok;

    public ContactPresenter(Context  context, Activity activity) {
        mContext =context;
        mView=(ContactInteractor)activity;
    }

    public ContactPresenter(Fragment fragment) {
        mView=(ContactInteractor)fragment;
    }

    public void getData(int page,int page_num,int category_id) {
        ConcurrentMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("category_id",""+category_id);
        map.put("page", "" + page);
        map.put("page_num", ""+page_num);
        ok = OKHttpUpdateHttpService.getInstance();
        ok.asyncGet(NetWorkConfig.ARTICLE_INFO, map, new IUpdateHttpService.Callback() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("config************", "" + result);
                jsonData(result);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.getError();
            }
        });
    }
    private void jsonData(String result) {
        Gson gson = new Gson();
        try {
            ContactBean newsInfo = gson.fromJson(result, ContactBean.class);
            if(newsInfo!=null){
                mView.getBean(newsInfo);
            }else{
                mView.getEmpty();
            }
            if (newsInfo.getCode() == 0) {
                List<ContactBean.DataBeanX.DataBean> list = newsInfo.getData().getData();
                mView.getList(list);
            } else {
                mView.getEmpty();
            }
        }catch (JsonSyntaxException e){
            mView.getEmpty();
        }
    }


}
