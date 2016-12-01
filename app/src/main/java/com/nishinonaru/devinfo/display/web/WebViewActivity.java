package com.nishinonaru.devinfo.display.web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.nishinonaru.devinfo.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWvDetail;
    private static final String TAG = "WebViewActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        init();
        act();
    }

    private void act() {
//        mWvDetail.loadUrl("http://m.pcauto.com.cn/");
        mWvDetail.loadUrl("http://www.androidchina.net/");
    }

    private void init() {
        mWvDetail = (WebView) findViewById(R.id.wvContent);
    }
}
