package zc.test.com.mydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zc.test.com.mydemo.R;
import zc.test.com.mydemo.bean.DataBindBean;

import static zc.test.com.mydemo.BR.dc;


/**
 * @desc:
 * @author: zc
 * @date: 2021/5/6
 */
public class DatabindAdapter extends RecyclerView.Adapter {

    private final List<DataBindBean> list;
    private final Context context;

    public DatabindAdapter(List<DataBindBean> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_databing, parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setVariable(dc,list.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
