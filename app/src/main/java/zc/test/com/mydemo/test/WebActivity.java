package zc.test.com.mydemo.test;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import zc.test.com.mydemo.R;
import zc.test.com.mydemo.base.BaseActivity;
import zc.test.com.mydemo.constants.Constants;
import zc.test.com.mydemo.constants.NetWorkConfig;
import zc.test.com.mydemo.widget.ProgressWebView;


/**
 * web嵌套页
 */
public class WebActivity extends BaseActivity {

    @BindView(R.id.webview_web)
    ProgressWebView webviewWeb;



    @Override
    protected int getContentView() {
        return R.layout.activity_web;
    }

    @Override
    protected void init() {
        WebSettings webSettings = webviewWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);// 设置支持JavaScript脚本
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);//允许DCOM
        //自适应屏幕 
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        webviewWeb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webviewWeb.canGoBack()) {  //表示按返回键 时的操作
                        webviewWeb.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        webviewWeb.setWebViewClient(new MyWebViewClient());

        webviewWeb.loadUrl(NetWorkConfig.SHUIXI_QTURL);

//        webviewOneliuctu.loadDataWithBaseURL(null, htm_star+str+htm_end, "text/html", "utf-8", null);
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(url.equals("")){
                return false;
            }
            if(url.startsWith("http:") || url.startsWith("https:") ) {
                view.loadUrl(url);
                return false;
            }else{
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    WebActivity.this.startActivity(intent);
                }catch (ActivityNotFoundException e){
                }
                return true;
            }
        }
    }

}