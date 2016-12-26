package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.swpuiot.schoolnews.R;

public class VisitWebsitsActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesg_web);
        webView= (WebView) findViewById(R.id.web_towebpage);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        Long messageid=getIntent().getLongExtra("message_id",0);
        Long instituteId=getIntent().getLongExtra("studentUnitionId",0);
        Long headId= Long.valueOf(getIntent().getIntExtra("Start_SWPU",0));
        visitMessageWebsite("message_id",messageid);
        visitMessageWebsite("studentUnitionId",instituteId);
        visitMessageWebsite("Start_SWPU",headId);



    }
    public void visitMessageWebsite(String name,Long messageId){
        if (name.equals("message_id")&&messageId!=0){
            webView.loadUrl("http://www.bug666.cn:8090/getMessage?messageId=" + messageId);
            Toast.makeText(VisitWebsitsActivity.this,"消息",Toast.LENGTH_SHORT).show();
        }else if (name.equals("studentUnitionId")&&messageId!=0) {
            // TODO: 2016/12/24 填充网址
            webView.loadUrl("" + messageId);
            Toast.makeText(VisitWebsitsActivity.this,"学生会",Toast.LENGTH_SHORT).show();
        }else if (name.equals("Start_SWPU")&&messageId!=0){
            webView.loadUrl("http://www.baidu.com/0");
            Toast.makeText(VisitWebsitsActivity.this,"西南石油门户",Toast.LENGTH_SHORT).show();
        }

    }
}
