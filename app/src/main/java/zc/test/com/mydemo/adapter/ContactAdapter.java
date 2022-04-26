package zc.test.com.mydemo.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import zc.test.com.mydemo.R;
import zc.test.com.mydemo.bean.ContactBean;
import zc.test.com.mydemo.constants.NetWorkConfig;
import zc.test.com.mydemo.widget.CircularImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.NewViewHolder> {
    private List<ContactBean.DataBeanX.DataBean> mDataBeans;
    private  boolean mIsHome;
    private Context mContext;

    public ContactAdapter(Context context, boolean isHome, List<ContactBean.DataBeanX.DataBean> dataBeans) {
        mContext = context;
        mIsHome=isHome;
        mDataBeans=dataBeans;
    }


    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new NewViewHolder(View.inflate(viewGroup.getContext(), R.layout.item_contact, null));
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder  holder, int position) {
        Glide.with(mContext).load(NetWorkConfig.HOST_URL+mDataBeans.get(position).getCover()).error(R.drawable.ic_img_null).into(holder.home_img_news);
        holder.tvConent.setText(mDataBeans.get(position).getTitle());
        holder.tvfabutime.setText(mDataBeans.get(position).getCreate_time());
    }


    @Override
    public int getItemCount() {
        return  mDataBeans.size();
    }

    class NewViewHolder extends RecyclerView.ViewHolder {
        TextView tvConent,tvfabutime;
        CircularImageView home_img_news;
        public NewViewHolder(View itemView) {
            super(itemView);
            home_img_news = (CircularImageView)itemView.findViewById(R.id.img_helper);
            tvConent=(TextView)itemView.findViewById(R.id.tv_helper_title);
            tvfabutime=(TextView) itemView.findViewById(R.id.tv_helper_time);
        }
    }


}
