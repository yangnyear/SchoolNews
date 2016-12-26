package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.DepartmentAdministrationAdapter;
import com.swpuiot.schoolnews.emtity.UserEntity;

public class DepartmentAdministrationActivity extends AppCompatActivity {
    private ListView listViewOfDepartmentAdministration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unition_administration);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_unitionadministration));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listViewOfDepartmentAdministration= (ListView) findViewById(R.id.list_department_administration);
        final DepartmentAdministrationAdapter departmentAdministrationAdapter=new DepartmentAdministrationAdapter(DepartmentAdministrationActivity.this);
        listViewOfDepartmentAdministration.setAdapter(departmentAdministrationAdapter);
        listViewOfDepartmentAdministration.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserEntity administrar= (UserEntity) departmentAdministrationAdapter.getItem(position);
                if (administrar.getContent().equals("发送消息")){
                    // TODO: 2016/12/26 访问发送消息网页
                }else if (administrar.getContent().equals("提交文件")){
                    Intent intent=new Intent(DepartmentAdministrationActivity.this,SendFileActivity.class);
                    startActivity(intent);
                }else if (administrar.getContent().equals("例会安排")){
                    // TODO: 2016/12/26 开启例会安排Activity
                }else if (administrar.getContent().equals("内部通知")){
                    // TODO: 2016/12/26 内部通知Activity
                }else if (administrar.getContent().equals("部门信息")){
                    // TODO: 2016/12/26 到部门信息Activity
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
