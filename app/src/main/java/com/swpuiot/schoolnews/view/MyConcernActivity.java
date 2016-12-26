package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.swpuiot.schoolnews.R;

public class MyConcernActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_concern);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_councern));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
