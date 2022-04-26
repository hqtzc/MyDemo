package zc.test.com.mydemo.main;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.gucetong.xyay.lib_gucetong.utils.ToastUtil;

import butterknife.BindView;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends BaseFragment {

    @BindView(R.id.txtinputlayout1)
    TextInputLayout txtinputlayout1;
    @BindView(R.id.txtinputlayout2)
    TextInputLayout txtinputlayout2;
    @BindView(R.id.edit_l1)
    EditText editL1;
    private String param;

    public static MsgFragment newInstance(String param) {
        MsgFragment fragment = new MsgFragment();
        fragment.param = param;
        return fragment;
    }

    @Override
    protected void init() {
        editL1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num = s.length();
                if(num<4){
                    txtinputlayout1.setError("错误"+s.toString());
                }else {
                    txtinputlayout1.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtinputlayout2.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_NULL) {
                    ToastUtil.showToast("去登录咯");
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_msg;
    }

}
