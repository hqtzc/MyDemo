package zc.test.com.mydemo.main;


import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.widget.LinearLayout;

import com.gucetong.xyay.lib_gucetong.stateview.StateView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.adapter.ContactAdapter;
import zc.test.com.mydemo.base.BaseFragment;
import zc.test.com.mydemo.bean.ContactBean;
import zc.test.com.mydemo.listener.ItemClickListener;
import zc.test.com.mydemo.presenter.ContactInteractor;
import zc.test.com.mydemo.presenter.ContactPresenter;

/**
 * 联系人
 */
public class ContactFragment extends BaseFragment implements ContactInteractor {

    @BindView(R.id.recycler_contact)
    XRecyclerView recyclerContact;
    @BindView(R.id.contact_linear)
    LinearLayout contactLinear;
    private String param;
    private ContactAdapter adapter;
    List<ContactBean.DataBeanX.DataBean> dataBeans = new ArrayList<ContactBean.DataBeanX.DataBean>();
    private Handler mHandler = new Handler();
    private int page = 1;
    private boolean isrefresh = true;
    private ContactBean newsInfo;
    private ContactPresenter p;
    private StateView mStateView;

    public static ContactFragment newInstance(String param) {
        ContactFragment fragment = new ContactFragment();
        fragment.param = param;
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void init() {
        mStateView = StateView.inject(contactLinear);
        //可再自定义view
//        mStateView.setEmptyResource(R.layout.view_empty);
//        mStateView.setRetryResource(R.layout.view_retry);

//        mStateView.showEmpty();
//        mStateView.showRetry();
        mStateView.showLoading();
//        mStateView.showContent();

        //点击重试
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                p.getData(page, 20, 4);
            }
        });

        p = new ContactPresenter(this);

        //初始化XRecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerContact.setLayoutManager(layoutManager);

        recyclerContact.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerContact.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerContact.setArrowImageView(R.mipmap.iconfont_downgrey);

        //设置初始化刷新效果
        recyclerContact.getDefaultRefreshHeaderView().setRefreshTimeVisible(false);
        //自定义刷新和加载字
//        recyclerContact.getDefaultFootView().setLoadingHint(getResources().getString(R.string.load_this));
//        recyclerContact.getDefaultFootView().setNoMoreHint(getResources().getString(R.string.load_over));

//        View header = LayoutInflater.from(getActivity()).inflate(R.layout.custom_bar, null, false);
//        recyclerContact.addHeaderView(header);

        adapter = new ContactAdapter(getActivity(), false, dataBeans);
        //条目点击事件
        recyclerContact.addOnItemTouchListener(new ItemClickListener(getActivity(),
                new ItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }));
        recyclerContact.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        page = 1;
                        isrefresh = true;
                        p.getData(page, 20, 4);
                    }
                }, 100);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (newsInfo.getData() != null) {
                            int maxPage = newsInfo.getData().getLast_page();
                            if (page < maxPage) {
                                page++;
                                isrefresh = false;
                                p.getData(page, 20, 4);
                            } else {
                                if (recyclerContact != null) {
                                    recyclerContact.setNoMore(true);
                                }
                            }
                        }
                    }
                }, 100);
            }
        });
        //解决滑动卡顿
        recyclerContact.setHasFixedSize(true);
        recyclerContact.setNestedScrollingEnabled(false);
        recyclerContact.setAdapter(adapter);
        recyclerContact.refresh();

    }

    @Override
    public void onResume() {
        super.onResume();
//        initData();
    }

    @Override
    public void getBean(ContactBean bean) {
        newsInfo = bean;
    }

    @Override
    public void getList(List<ContactBean.DataBeanX.DataBean> list) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (list != null && list.size() > 0) {
                    mStateView.showContent();
                    if (isrefresh == true) {
                        dataBeans.clear();
                        dataBeans.addAll(list);
                        if (recyclerContact != null) {
                            recyclerContact.refreshComplete();
                        }
                    } else {
                        for (ContactBean.DataBeanX.DataBean db : list) {
                            dataBeans.add(db);

                        }
                        if (recyclerContact != null) {
                            recyclerContact.loadMoreComplete();
                        }
                    }
                } else {
                    if (isrefresh == true) {
                        mStateView.showEmpty();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getEmpty() {
        if (isrefresh == true) {
            mStateView.showEmpty();
        }
    }

    @Override
    public void getError() {
        if (isrefresh == true) {
            mStateView.showRetry();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (recyclerContact != null) {
            recyclerContact.destroy();
            recyclerContact = null;
        }
    }

}
