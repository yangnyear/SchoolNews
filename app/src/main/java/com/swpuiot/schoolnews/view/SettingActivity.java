package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.UserResponseEmpty;

public class SettingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private UserResponseEmpty.DateBean aUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbar= (Toolbar) findViewById(R.id.toolbar_settinginformation);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        aUser = (UserResponseEmpty.DateBean) getIntent().getSerializableExtra("user_imfo");


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
