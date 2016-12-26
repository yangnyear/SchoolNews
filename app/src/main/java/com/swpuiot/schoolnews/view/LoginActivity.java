package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.UserResponseEmpty;

import org.apache.http.Header;

import java.io.IOException;

public class  LoginActivity extends ActionBarActivity {
    private EditText username;
    private EditText userpassword;
    private Button userlogin;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox remember;
    private TextView lostpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        username= (EditText) findViewById(R.id.edittext_username);
        userpassword= (EditText) findViewById(R.id.edittext_password);
        userlogin= (Button) findViewById(R.id.button_login);
        remember= (CheckBox) findViewById(R.id.box_load);
        lostpassword= (TextView) findViewById(R.id.text_lost);

        pref = getSharedPreferences("setting", MODE_PRIVATE);
        boolean isremenbered=pref.getBoolean("remember_password", false);

        //记住密码
        if (isremenbered){
            String load_name=pref.getString("name","");
            String load_password=pref.getString("password","");
            username.setText(load_name);
            userpassword.setText(load_password);
            remember.setChecked(true);
        }

        userlogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  name=username.getText().toString().trim();
                String password=userpassword.getText().toString().trim();
                RequestParams logimformation = new RequestParams();
                AsyncHttpClient test = new AsyncHttpClient();
                editor = pref.edit();
                //首先检查是否记住了密码
                if (remember.isChecked()) {
                    editor.putBoolean("remember_password", true);
                    editor.putString("name", name);
                    editor.putString("password", password);
                } else {
                    editor.clear();
                }
                editor.commit();
                logimformation.add("name", name);
                logimformation.add("password", password);
                test.get("http://www.bug666.cn:8090/login",logimformation, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int i, Header[] headers, byte[] bytes) {
                        ObjectMapper objectMapper=new ObjectMapper();
                        UserResponseEmpty userResponseEmpty=new UserResponseEmpty();
                        try {
                            userResponseEmpty=objectMapper.readValue(bytes, UserResponseEmpty.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (userResponseEmpty.getCode()==1){
                            Intent intent=new Intent();
                            intent.putExtra("DataBean_data", userResponseEmpty.getDate());
                            setResult(RESULT_OK,intent);
                             finish();


                            Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                        Toast.makeText(LoginActivity  .this, "网络异常，请检查网络", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
