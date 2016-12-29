package com.swpuiot.schoolnews.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.swpuiot.schoolnews.R;

import org.apache.http.Header;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SendFileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final int openFilemanegger = 1;
    private Spinner academyspinner;
    private Spinner departmentSpinner;
    private ArrayAdapter<String> academyAdapter;
    private ArrayAdapter<String> departmentAdapter;
    private String academyString;
    private String depatmentString;
    private TextView textViewOfFileName;
    private Button btnOfRemoveFile;
    private LinearLayout linearLayoutOfChoseFile;
    private  File file;
    public com.facebook.drawee.view.SimpleDraweeView sendImage;

    private List<String> academyStringList = new ArrayList<String>();

    {
        academyStringList.add("校学生会");
        academyStringList.add("计科院");
        academyStringList.add("石工院");
        academyStringList.add("化工院");
        academyStringList.add("材科院");
        academyStringList.add("地科院");
        academyStringList.add("电信院");
        academyStringList.add("法学院");
        academyStringList.add("机电院");
        academyStringList.add("理学院");
        academyStringList.add("土建院");
        academyStringList.add("艺术院");
    }

    private List<String> departmentStringList = new ArrayList<String>();

    {
        departmentStringList.add("主席团");
        departmentStringList.add("办公室");
        departmentStringList.add("纪检部");
        departmentStringList.add("科技部");
        departmentStringList.add("女生部");
        departmentStringList.add("青志协");
        departmentStringList.add("生活部");
        departmentStringList.add("实践部");
        departmentStringList.add("体育部");
        departmentStringList.add("拓展办");
        departmentStringList.add("文艺部");
        departmentStringList.add("宣传部");
        departmentStringList.add("学习部");
        departmentStringList.add("组织部");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_file);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_sendfile));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        academyspinner = (Spinner) findViewById(R.id.spinner_academy);
        departmentSpinner = (Spinner) findViewById(R.id.spinner_departtment);
        textViewOfFileName= (TextView) findViewById(R.id.txt_filename);
        btnOfRemoveFile= (Button) findViewById(R.id.btn_removefile);
        sendImage= (SimpleDraweeView) findViewById(R.id.image_sendfile);
        linearLayoutOfChoseFile= (LinearLayout) findViewById(R.id.txt_selectfile);
        //创建Adapter
        academyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, academyStringList);
        //设置检查样式
        academyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departmentStringList);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner加载适配器
        academyspinner.setAdapter(academyAdapter);
        departmentSpinner.setAdapter(departmentAdapter);
        //设置点击事件监听
        academyspinner.setOnItemSelectedListener(this);
        departmentSpinner.setOnItemSelectedListener(this);
        //选择文件
        linearLayoutOfChoseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileManegger(openFilemanegger);
            }
        });
        sendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFileToservers();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        academyString = academyAdapter.getItem(position);
        depatmentString = departmentAdapter.getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //添加附件
    public void openFileManegger(int statusCoode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        //设置类型，我这里是任意类型，任意后缀的可以这样写。
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, statusCoode);
    }
    //获得文件后返回Activity.RESULT_OK
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            actualimagecursor.moveToFirst();
//            String file_path = actualimagecursor.getString(actual_image_column_index);
            String file_path = uri.getPath();
            file = new File(file_path);
            //将文件信息显示在文件列表中
            Toast.makeText(SendFileActivity.this, "点击上传提交文件: "+file.getName(), Toast.LENGTH_SHORT).show();
            textViewOfFileName.setText(file.getName());
            linearLayoutOfChoseFile.setVisibility(View.VISIBLE);
            sendImage.setVisibility(View.VISIBLE);
//            sendFileToservers();
        }

    }

    //点击发送时调用 发送文件
    public void sendFileToservers(){
        RequestParams sendFilerequstparams = new RequestParams();
        AsyncHttpClient sendFile = new AsyncHttpClient();
        //添加传递参数
        sendFilerequstparams.add("academy",academyString);
        sendFilerequstparams.add("department",depatmentString);
        try {
            sendFilerequstparams.put("fileList", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sendFile.post("http://www.bug666.cn:8090/uploadfile", sendFilerequstparams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Toast.makeText(SendFileActivity.this,"文件发送成功",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(SendFileActivity.this,"文件发送失败，请检查网络",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
