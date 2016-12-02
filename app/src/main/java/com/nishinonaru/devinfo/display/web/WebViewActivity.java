package com.nishinonaru.devinfo.display.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.nishinonaru.devinfo.R;
import com.nishinonaru.devinfo.data.entity.ShowItem;
import com.nishinonaru.devinfo.global.Const;

import static com.nishinonaru.devinfo.global.Util.checkNotNull;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWvDetail;
    private static final String TAG = "WebViewActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        ShowItem showItem = (ShowItem) intent.getSerializableExtra(Const.SHOW_ITEM);
        checkNotNull(showItem, "something wrong happened,error:1001");

        init();
        act(showItem);
    }

    private void act(ShowItem showItem) {
//        mWvDetail.loadUrl("http://m.pcauto.com.cn/");
        mWvDetail.loadUrl(showItem.getArticlePath());
    }

    private void init() {
        mWvDetail = (WebView) findViewById(R.id.wvContent);
    }
}
