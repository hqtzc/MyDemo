package zc.test.com.mydemo.start;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.adapter.DatabindAdapter;
import zc.test.com.mydemo.base.BaseActivity;
import zc.test.com.mydemo.bean.DataBindBean;

public class TestDataBindingActivity extends BaseActivity {

    @BindView(R.id.recyclerview_db)
    RecyclerView recyclerviewDb;

    @Override
    protected int getContentView() {
        return R.layout.activity_test_data_binding;
    }

    @Override
    protected void init() {
//        DataBindingUtil.setContentView(this,R.layout.activity_test_data_binding);
        recyclerviewDb.setLayoutManager(new LinearLayoutManager(this));
        List<DataBindBean> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DataBindBean user = new DataBindBean();
            user.name.set("wu");
            user.age.set(i);
            users.add(user);
        }
        DatabindAdapter adapter = new DatabindAdapter(users, this);
        recyclerviewDb.setAdapter(adapter);

    }
}