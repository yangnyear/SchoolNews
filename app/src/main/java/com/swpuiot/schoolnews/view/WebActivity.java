package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.swpuiot.schoolnews.R;

public class WebActivity extends AppCompatActivity {

    public static final String ACTION_TITLE = "ACTION_TITLE";
    public static final String ACTION_URL = "ACTION_URL";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) (findViewById(R.id.toolbar));
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = (ProgressBar) findViewById(R.id.pb_wait);
        showProgressBar(true);
        WebView webView = (WebView) findViewById(R.id.wv);
        if (webView != null)
            webView.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();

        if (intent != null) {
            // 标题
            String title = intent.getStringExtra(ACTION_TITLE);
            if (title != null && getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }

            // URL
            String url = intent.getStringExtra(ACTION_URL);
            if (!TextUtils.isEmpty(url) && url.startsWith("http://")) {
                // 1. 加载网页
                if (webView != null)
                    webView.loadUrl(url);
                // 2. 隐藏进度条
                showProgressBar(false);
            }


        }

    }

    private void showProgressBar(boolean show) {
        if (progressBar == null) return;
        progressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
