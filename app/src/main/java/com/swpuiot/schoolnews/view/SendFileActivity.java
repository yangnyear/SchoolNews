package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.swpuiot.schoolnews.R;

public class SendFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_file);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_sendfile));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
