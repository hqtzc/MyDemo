package zc.test.com.mydemo.main;


import android.graphics.Color;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.core.widget.NestedScrollView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.gucetong.xyay.lib_gucetong.utils.LogUtils;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateParser;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseFragment;
import zc.test.com.mydemo.bean.Updatebean;
import zc.test.com.mydemo.constants.NetWorkConfig;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends BaseFragment {

    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.img5)
    ImageView img5;
    @BindView(R.id.img6)
    ImageView img6;
    @BindView(R.id.img_scroll)
    ImageView imgScroll;
    @BindView(R.id.nestscroll)
    NestedScrollView nestscroll;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.sb_gsmh)
    SeekBar sbGsmh;
    private String param;

    public static MoreFragment newInstance(String param) {
        MoreFragment fragment = new MoreFragment();
        fragment.param = param;
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_more;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void init() {

        //??????????????????widget???BounceScrollView????????????
        // Horizontal
//        OverScrollDecoratorHelper.setUpStaticOverScroll(nestscroll, OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL);
        // Vertical
//        OverScrollDecoratorHelper.setUpStaticOverScroll(nestscroll, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);

        nestscroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int i, int i1, int i2, int i3) {
                LogUtils.e("scroll", i + "--" + i1 + "--" + i2 + "--" + i3);
                if (i1 < 100) {
                    imgScroll.setVisibility(View.VISIBLE);
                } else {
                    imgScroll.setVisibility(View.GONE);
                }
            }
        });

//        nestscroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i1, int i2, int i3) {
//                LogUtils.e("scroll", i + "--" + i1 + "--" + i2 + "--" + i3);
//                if (i1 < 100) {
//                    imgScroll.setVisibility(View.VISIBLE);
//                } else {
//                    imgScroll.setVisibility(View.GONE);
//                }
//            }
//        });

        //??????
        Glide.with(this).load(R.mipmap.photo1)
                .apply(bitmapTransform(new BlurTransformation(2)))
                .into(img1);
        //??????
        Glide.with(this).load(R.mipmap.photo1)
                .apply(bitmapTransform(new GrayscaleTransformation()))
                .into(img2);
        //??????
        Glide.with(this)
                .load(R.mipmap.photo1)
                .apply(new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(20)))
                .into(img3);
        //??????
        Glide.with(this)
                .load(R.mipmap.photo1)
                .apply(bitmapTransform(new CropCircleTransformation()))
                .into(img4);
        //???????????????
        Glide.with(this)
                .load(R.mipmap.photo1)
                .apply(bitmapTransform(new CropCircleWithBorderTransformation(4, Color.BLUE)))
                .into(img5);

        sbGsmh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                LogUtils.e("blur--------------",""+progress);
                if(progress>=4){
                    //????????????
                    Glide.with(getActivity())
                            .load(R.mipmap.photo1)
                            .dontAnimate()
                            .apply(bitmapTransform(new BlurTransformation(Math.round(progress/4), 1)))// ?????????????????????,???????????????(???0.0???25.0??????)????????????25";??????????????????,?????????1???
                            .into(img6);

                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //????????????
        Glide.with(this)
                .load(R.mipmap.photo1)
                .dontAnimate()
                .apply(bitmapTransform(new BlurTransformation(25, 1)))// ?????????????????????,???????????????(???0.0???25.0??????)????????????25";??????????????????,?????????1???
                .into(img6);
    }

    @OnClick({R.id.btn_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                XUpdate.newBuild(getActivity())
                        .updateUrl("" + NetWorkConfig.CONFIG_GETCONFIGDATA)
                        .themeColor(Color.WHITE)
//                        .topResId(R.mipmap.ic_launcher)
                        .updateParser(new CustomUpdateParser()) //???????????????????????????????????????
                        .update();
                break;
        }
    }

    public class CustomUpdateParser implements IUpdateParser {
        @Override
        public UpdateEntity parseJson(String json) throws Exception {
            Updatebean result = new Gson().fromJson(json, Updatebean.class);
            if (result != null) {
                return new UpdateEntity()
                        .setHasUpdate(true)//??????????????????
                        .setIsIgnorable(false)//??????????????????
                        .setVersionCode(2)//?????????
                        .setVersionName("2.0.1")//????????????
                        .setUpdateContent("???????????????")//????????????
                        .setDownloadUrl(NetWorkConfig.HOST_URL + "/test.apk");//????????????
            }
            return null;
        }
    }
}
