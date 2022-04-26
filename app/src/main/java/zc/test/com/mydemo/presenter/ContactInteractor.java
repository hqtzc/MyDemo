package zc.test.com.mydemo.presenter;
import java.util.List;
import zc.test.com.mydemo.bean.ContactBean;

public interface ContactInteractor {

    //返回bean
    void getBean(ContactBean bean);

    //返回bean下的list
    void getList(List<ContactBean.DataBeanX.DataBean> list);

    //返回空
    void getEmpty();

    //返回错误
    void getError();
}
