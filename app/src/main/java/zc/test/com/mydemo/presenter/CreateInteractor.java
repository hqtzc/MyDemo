package zc.test.com.mydemo.presenter;

import java.util.List;

import zc.test.com.mydemo.bean.HtmlBean;

public interface CreateInteractor {

    //返回bean
    void returnApp(HtmlBean bean);

    void returnError(String msg);

}
