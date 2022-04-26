package zc.test.com.mydemo.main;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gucetong.xyay.lib_gucetong.nicedialog.BaseNiceDialog;
import com.gucetong.xyay.lib_gucetong.nicedialog.NiceDialog;
import com.gucetong.xyay.lib_gucetong.nicedialog.ViewConvertListener;
import com.gucetong.xyay.lib_gucetong.nicedialog.ViewHolder;
import com.gucetong.xyay.lib_gucetong.permission.UsesPermission;
import com.gucetong.xyay.lib_gucetong.permission.com_hjq_permissions.Permission;
import com.gucetong.xyay.lib_gucetong.utils.LogUtils;
import com.gucetong.xyay.lib_gucetong.utils.SnackbarUtils;
import com.gucetong.xyay.lib_gucetong.utils.ToastUtil;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseFragment;
import zc.test.com.mydemo.constants.NetWorkConfig;
import zc.test.com.mydemo.dialog.CommonDialog;
import zc.test.com.mydemo.presenter.RegistInteractor;
import zc.test.com.mydemo.presenter.RegisterPresenter;
import zc.test.com.mydemo.service.OKHttpUpdateHttpService;
import zc.test.com.mydemo.test.RxJavaActivity;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * desc
 * name:zc
 * createTime:2020/2/26 16:58
 */
public class HomeFragment extends BaseFragment implements RegistInteractor {
    @BindView(R.id.btn_popdialog)
    Button btnPopdialog;
    Unbinder unbinder;
    @BindView(R.id.txt_main)
    TextView txtMain;
    @BindView(R.id.btn_show)
    Button btnShow;
    @BindView(R.id.scroll_home)
    NestedScrollView scrollHome;
    @BindView(R.id.txt_show_path)
    ImageView txtShowPath;
    @BindView(R.id.img_code)
    ImageView imgCode;
    @BindView(R.id.btn_mysuccess)
    Button btnMysuccess;
    @BindView(R.id.btn_myfail)
    Button btnMyfail;
    private String param;
    private boolean isChanged;
    private OKHttpUpdateHttpService ok;
    private Handler mHandler = new Handler();
    private RegisterPresenter mRegisterPresenter;
    private Activity mContext;
    /*用来标识请求照相功能的*/
    private static final int CAMERA_WITH_DATA = 101;
    /*用来标识请求相册*/
    private static final int REQUEST_IMAGE = 102;
    private LoadingPopupView loadingPopup;

    public static HomeFragment newInstance(String param) {
        HomeFragment fragment = new HomeFragment();
        fragment.param = param;
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        mContext = getActivity();
        scrollHome.setNestedScrollingEnabled(false);
        initData();
        mRegisterPresenter = new RegisterPresenter(this);
        mRegisterPresenter.getImageCode();
        imgCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRegisterPresenter.getImageCode();
            }
        });
    }

    @Override
    public void getBitmapFromByte(byte[] bytes) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (bytes != null) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    try {
                        imgCode.setImageBitmap(bitmap);
                    } catch (NullPointerException e) {
                    }
                }
            }
        });
    }


    private void initData() {
        ConcurrentMap<String, Object> map = new ConcurrentHashMap<>();
//        map.put("category_id", "6");
        ok = OKHttpUpdateHttpService.getInstance();
        ok.asyncGet(NetWorkConfig.CONFIG_GETCONFIGDATA, map, new IUpdateHttpService.Callback() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("config************", "" + result);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    /**
     * 显示dialog
     */
    private void showDaialog() {
        CommonDialog.Builder builder = new CommonDialog.Builder(mContext);
        builder.setView(R.layout.dialog_layout).showAnimation(R.style.dialog_scale_animstyle);
        final CommonDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
//        dialog.setText(R.id.tv_kaihu_name,dataBean.getBank_account_name());
        dialog.show();
        dialog.setOnClickListener(R.id.btn_queding, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    @OnClick({R.id.btn_popdialog, R.id.btn_show, R.id.btn_select_pic, R.id.btn_mysuccess, R.id.btn_myfail,R.id.btn_sn_short, R.id.btn_sn_long, R.id.btn_sn_custom,R.id.txt_btn_right,R.id.btn_loading,R.id.btn_swipe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_popdialog:
                showDaialog();
                break;
            case R.id.btn_show:
                isChanged = !isChanged;
                if (isChanged) {
                    ToastUtil.showToast("隐藏", R.mipmap.iconfont_downgrey);
                    txtMain.setVisibility(View.GONE);
                } else {
                    ToastUtil.showToast("显示");
                    txtMain.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_select_pic://选择图片
                checkPermission();
                break;
            case R.id.btn_mysuccess:
                ToastUtil.showSuccessToast("成功");
                break;
            case R.id.btn_myfail:
                ToastUtil.showFailToast("失败");
                break;
            case R.id.btn_sn_short:
                SnackbarUtils.Short(view,"显示时长:短 ").info().show();
                break;
            case R.id.btn_sn_long:
                SnackbarUtils.Long(view, "显示时长:长").info().show();
                break;
            case R.id.btn_sn_custom:
                SnackbarUtils.Custom(view, "显示时长:自定义 8秒", 8 * 1000).info().show();
                break;
            case R.id.txt_btn_right:
                startActivity(new Intent(getActivity(), RxJavaActivity.class));
                break;
            case R.id.btn_loading:
                if(loadingPopup==null){
                    loadingPopup = (LoadingPopupView) new XPopup.Builder(getContext())
                            .dismissOnBackPressed(false)
                            .asLoading("加载中")
                            .show();
                }else {
                    loadingPopup.show();
                }
                loadingPopup.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingPopup.setTitle("加载中长度变化啊");
                        loadingPopup.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadingPopup.setTitle("");
                            }
                        }, 2000);
                    }
                }, 2000);
//                loadingPopup.smartDismiss();
//                loadingPopup.dismiss();
                loadingPopup.delayDismissWith(6000, new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showToast("我消失了！！！");
                    }
                });
                break;
            case R.id.btn_swipe:

                break;
        }
    }

    //需要Manifest中也要有权限（两个地方都要有）
    String permissions[] = {Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE, Permission.CAMERA};

    /**
     * 检查权限
     */
    private void checkPermission() {
        new UsesPermission(mContext, permissions) {
            @Override
            protected String onCancelTips(int viewCancelCount, @NonNull ArrayList<String> permissions, boolean isFinal) {
                return super.onCancelTips(viewCancelCount, permissions, isFinal);
            }

            @Override
            protected String onTips(int viewTipsCount, @NonNull ArrayList<String> permissions, boolean isFinal) {
                return super.onTips(viewTipsCount, permissions, isFinal);
            }

            @Override
            protected void onTrue(@NonNull ArrayList<String> lowerPermissions) {
                //获取了全部权限执后行此函数，
                btnSelectPic();
            }

            @Override
            protected void onFalse(@NonNull ArrayList<String> rejectFinalPermissions, @NonNull ArrayList<String> rejectPermissions, @NonNull ArrayList<String> invalidPermissions) {
                //未全部授权时执行此函数
//                ToastUtils.show("请先允许程序获取权限!");
            }

            //要么实现上面两个方法即可，onTrue或onFalse只会有一个会被调用一次
            //要么仅仅实现下面这个方法，不管授权了几个权限都会调用一次
            @Override
            protected void onComplete(@NonNull ArrayList<String> resolvePermissions, @NonNull ArrayList<String> lowerPermissions, @NonNull ArrayList<String> rejectFinalPermissions, @NonNull ArrayList<String> rejectPermissions, @NonNull ArrayList<String> invalidPermissions) {
                //完成回调，可能全部已授权、全部未授权、或者部分已授权
                //通过resolvePermissions.contains(Permission.XXX)来判断权限是否已授权
            }
        };
    }



    private void btnSelectPic() {
        NiceDialog.init()
                .setLayoutId(R.layout.pop_cam_pic)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.rl_creame, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    startActivityForResult(cameraIntent, CAMERA_WITH_DATA);
                                } catch (ActivityNotFoundException e) {
                                    e.printStackTrace();
                                }
                                dialog.dismiss();
                            }
                        });
                        holder.setOnClickListener(R.id.rl_photo, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Matisse.from(HomeFragment.this)
                                        .choose(MimeType.ofImage(), false)//图片类型
                                        .countable(false)//true:选中后显示数字;false:选中后显示对号
                                        .capture(true)//选择照片时，是否显示拍照
                                        .captureStrategy(new CaptureStrategy(true, "zc.test.com.mydemo.fileprovider", "test"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                                        .maxSelectable(9)//可选的最大数
//                                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                                        .thumbnailScale(0.85f)
                                        .imageEngine(new GlideEngine())//图片加载引擎
                                        .setOnSelectedListener((uriList, pathList) -> {
                                            Log.e("onSelected", "onSelected: pathList=" + pathList);
                                        })
                                        .showSingleMediaType(true)
                                        .originalEnable(true)
                                        .maxOriginalSize(10)
                                        .theme(R.style.Matisse_Zhihu)//主题R.style.Matisse_Zhihu  暗色主题 R.style.Matisse_Dracula
                                        .autoHideToolbarOnSingleTap(true)
                                        .setOnCheckedListener(isChecked -> {
                                            Log.e("isChecked", "onCheck: isChecked=" + isChecked);
                                        })
                                        .forResult(REQUEST_IMAGE);

                                dialog.dismiss();
                            }
                        });
                        holder.setOnClickListener(R.id.rl_cancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setGravity(Gravity.BOTTOM)
//                .setHeight(120)
                .show(getFragmentManager());
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_WITH_DATA:
                Bundle bundle = data.getExtras();
                Bitmap bitMap = (Bitmap)bundle.get("data");
                if (bitMap != null)
                    bitMap.recycle();
                Glide.with(HomeFragment.this)
                        .load(bitMap)
                        .apply(bitmapTransform(new CropCircleTransformation()))
                        .error(R.mipmap.ic_launcher)
                        .into(txtShowPath);
                break;
            case REQUEST_IMAGE:
                if (data != null) {
                    List<String> paths = Matisse.obtainPathResult(data);
                    //压缩
                    Luban.with(mContext)
                            .load(paths)                                   // 传人要压缩的图片列表
                            .ignoreBy(100)                                  // 忽略不压缩图片的大小
                            .setTargetDir(getPath())                        // 设置压缩后文件存储位置
                            .setCompressListener(new OnCompressListener() { //设置回调
                                @Override
                                public void onStart() {
                                    // TODO 压缩开始前调用，可以在方法内启动 loading UI
                                    LogUtils.e("onStart", "++++");
                                }

                                @Override
                                public void onSuccess(File file) {
                                    // TODO 压缩成功后调用，返回压缩后的图片文件,如果多张图片则会多次进入此方法
                                    LogUtils.e("onSuccess", "-----" + file.getAbsolutePath());
                                    //压缩后的图片显示到view上
                                    //圆形
                                    Glide.with(HomeFragment.this)
                                            .load(file)
                                            .apply(bitmapTransform(new CropCircleTransformation()))
                                            .error(R.mipmap.ic_launcher)
                                            .into(txtShowPath);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    // TODO 当压缩过程出现问题时调用
                                    LogUtils.e("onError", "*****"+e.getMessage());
                                }
                            }).launch();    //启动压缩
                }
                break;
        }

    }

    //创建文件目录
    private String getPath() {
        String path = Environment.getExternalStorageDirectory() + "/Luban/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }

}
