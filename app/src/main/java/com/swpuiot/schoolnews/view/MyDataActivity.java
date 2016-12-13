package com.swpuiot.schoolnews.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.emtity.UserResponseEmpty;

public class MyDataActivity extends ActionBarActivity {
    private ImageView imOfBack;
    private com.facebook.drawee.view.SimpleDraweeView imOfLogo;
    private TextView txtOfReplace;
    private  TextView textOfMoto;
    private TextView txtOfName;
    private TextView txtOfMajor;
    private TextView txtOfStudentid;
    private TextView txtOfGrade;
    private TextView txtOfPhhno;
    private TextView txtOfInTime;
    private TextView txtOfOutTime;

//    public UserResponseEmpty.DateBean aUser;

    public MyDataActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_data);

        imOfBack= (ImageView) findViewById(R.id.im_onewback);
        imOfLogo= (SimpleDraweeView) findViewById(R.id.image_userlogo);
        txtOfReplace= (TextView) findViewById(R.id.text_replace);
        textOfMoto= (TextView) findViewById(R.id.text_onew_name);

        txtOfName= (TextView) findViewById(R.id.txt_aname);
        txtOfStudentid= (TextView) findViewById(R.id.txt_astuid);
        txtOfMajor= (TextView) findViewById(R.id.txt_amajor);
        txtOfGrade= (TextView) findViewById(R.id.txt_agrade);
        txtOfPhhno= (TextView) findViewById(R.id.txt_aphnoe);
        txtOfInTime= (TextView) findViewById(R.id.txt_aintime);
        txtOfOutTime= (TextView) findViewById(R.id.txt_aouttime);

        UserResponseEmpty.DateBean aUser= (UserResponseEmpty.DateBean) getIntent().getSerializableExtra("user_imfo");
        txtOfName.setText(aUser.getName());
        txtOfStudentid.setText(aUser.getUserId()+"");
        txtOfMajor.setText(aUser.getMajor());
        txtOfGrade.setText(aUser.getGrade());
        txtOfPhhno.setText(aUser.getPutTime());
        txtOfInTime.setText(aUser.getInTime());
        txtOfOutTime.setText(aUser.getPutTime());


        Uri uri = Uri.parse(aUser.getSetLogoSrc());
        imOfLogo.setImageURI(uri);

        imOfLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(MyDataActivity.this);
                View view = inflater.inflate(R.layout.chose_item, null);


                final AlertDialog dialog = new AlertDialog
                        .Builder(MyDataActivity.this)
                        .setTitle("更换头像")
                        .setView(view)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                TextView txtOfPhHome= (TextView) findViewById(R.id.text_openphgm);
                TextView txtOfPhotoGreamer= (TextView) findViewById(R.id.text_fromphhome);
                TextView txtOfCheak= (TextView) findViewById(R.id.text_cheakimage);

                txtOfPhHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2016/12/13  从相册选择照片
                    }
                });
                txtOfPhotoGreamer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2016/12/13 打来相机
                    }
                });
                txtOfCheak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2016/12/13  查看大图
                    }
                });
            }
        });

        txtOfReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2016/12/13 跳转到编辑界面
            }
        });

    }
}
