package com.swpuiot.schoolnews.view;

import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.BannerLoader;
import com.swpuiot.schoolnews.adapter.HeadMessageAdapterr;
import com.swpuiot.schoolnews.emtity.HradMessages;
import com.swpuiot.schoolnews.emtity.UserResponseEmpty;
import com.youth.banner.Banner;

import org.apache.http.Header;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyDataActivity extends ActionBarActivity {
    public static final int TAKE_PHOTO = 1;
    public static final int GCOP_PHOTO = 2;
    public static final int CHOOSE_PHOTO = 3;

    private Toolbar userInfoToolbar;
    private com.facebook.drawee.view.SimpleDraweeView imOfLogo;
    private UserResponseEmpty.DateBean aUser;
    private TextView textOfMoto;
    private TextView txtOfName;
    private TextView txtOfMajor;
    private TextView txtOfStudentid;
    private TextView txtOfGrade;
    private TextView txtOfPhhno;
    private TextView txtOfInTime;
    private TextView txtOfOutTime;
    private Uri imageuri;
    private AlertDialog dialog;

    //    public UserResponseEmpty.DateBean aUser;

    public MyDataActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        userInfoToolbar=(Toolbar) findViewById(R.id.toolbar_user);
        setSupportActionBar(userInfoToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imOfLogo = (SimpleDraweeView) findViewById(R.id.image_userlogo);
        textOfMoto = (TextView) findViewById(R.id.text_onew_name);

        txtOfName = (TextView) findViewById(R.id.txt_aname);
        txtOfStudentid = (TextView) findViewById(R.id.txt_astuid);
        txtOfMajor = (TextView) findViewById(R.id.txt_amajor);
        txtOfGrade = (TextView) findViewById(R.id.txt_agrade);
        txtOfPhhno = (TextView) findViewById(R.id.txt_aphnoe);
        txtOfInTime = (TextView) findViewById(R.id.txt_aintime);
        txtOfOutTime = (TextView) findViewById(R.id.txt_aouttime);

        aUser = (UserResponseEmpty.DateBean) getIntent().getSerializableExtra("user_imfo");
        txtOfName.setText(aUser.getName());
        txtOfStudentid.setText(aUser.getUserId() + "");
        txtOfMajor.setText(aUser.getMajor());
        txtOfGrade.setText(aUser.getGrade());
        txtOfPhhno.setText(aUser.getPhone() + "");
        txtOfInTime.setText(aUser.getInTime());
        txtOfOutTime.setText(aUser.getPutTime());

//        userInfoToolbar.inflateMenu(R.menu.main);
//        if(userInfoToolbar != null){
//            setSupportActionBar(userInfoToolbar);
//        }

        Uri uri = Uri.parse(aUser.getSetLogoSrc());
        imOfLogo.setImageURI(uri);
        imOfLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(MyDataActivity.this);
                View view = inflater.inflate(R.layout.chose_item, null);


                dialog = new AlertDialog
                        .Builder(MyDataActivity.this)
                        .setView(view)
                        .setTitle("修改头像")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();

                TextView txtOfPhHome = (TextView) view.findViewById(R.id.text_openphgm);
                TextView txtOfPhotoGreamer = (TextView) view.findViewById(R.id.text_fromphhome);
                TextView txtOfCheak = (TextView) view.findViewById(R.id.text_cheakimage);

                txtOfPhHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPhotoHome(CHOOSE_PHOTO);

                    }
                });
                txtOfPhotoGreamer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openCamera(TAKE_PHOTO);


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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void openPhotoHome(int a) {
        File outPutImage = new File(Environment.getExternalStorageDirectory(), "out_put.jpg");
        try {
            if (outPutImage.exists()) {
                outPutImage.delete();
            }
            outPutImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageuri = Uri.fromFile(outPutImage);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, a);
    }

    public void openCamera(int a) {
        File outputimage = new File(Environment.getExternalStorageDirectory(), "tempimage.jpg");

        try {
            if (outputimage.exists()) {
                outputimage.delete();
            }
            outputimage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageuri = Uri.fromFile(outputimage);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
        startActivityForResult(intent, a);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String imagePath;
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageuri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
                    startActivityForResult(intent, GCOP_PHOTO);
                }
                break;
            case GCOP_PHOTO:
                if (resultCode == RESULT_OK) {
                    if (dialog != null && dialog.isShowing()) dialog.dismiss();
                    imOfLogo.setImageURI(imageuri);

                }
                break;
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        imagePath = handleImageOnkitkat(data);
                        resettingUserLogo(imagePath);

                    } else {
                        imagePath = handleimageBefokitkat(data);
                        resettingUserLogo(imagePath);
                    }
                }
            default:
                break;
        }
    }

    private String handleImageOnkitkat(Intent data) {
        String imagepath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            String docid = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docid.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagepath = getimagepath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(uri.parse("content://downloads/public_downloads"),
                        Long.valueOf(docid));
                imagepath = getimagepath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imagepath = getimagepath(uri, null);
        }
        displayimage(imagepath);
        return imagepath;
    }

    private String handleimageBefokitkat(Intent data) {
        Uri uri = data.getData();
        String imagepath = getimagepath(uri, null);
        displayimage(imagepath);
        return imagepath;
    }

    private String getimagepath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayimage(String imagepath) {
        if (imagepath != null) {
            if (dialog != null && dialog.isShowing()) dialog.dismiss();
            String uri = "file://" + imagepath;
            imOfLogo.setImageURI(Uri.parse(uri));
        } else {
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void resettingUserLogo(String imagePath) {
        File imageFile = new File(imagePath);
        RequestParams replaceImage = new RequestParams();
        AsyncHttpClient replace = new AsyncHttpClient();
        replaceImage.put("userId", aUser.getUserId());
        try {
            replaceImage.put("file", imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        replace.post("http://www.bug666.cn:8090/upload", replaceImage, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Toast.makeText(MyDataActivity.this, "头像上传成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(MyDataActivity.this, "出问题啦，请检查网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class HeadImageFragment extends Fragment {
        private HeadMessageAdapterr headMessageAdapterr;
        private ListView listView;
        List<HradMessages> mlist;
        private View view;
        private List<String> bannarImgs = Arrays.asList(
                "http://www.bug666.cn:8080/Images/headfirst/swpu_01.jpg",
                "http://www.bug666.cn:8080/Images/headfirst/swpu_02.jpg",
                "http://www.bug666.cn:8080/Images/headfirst/swpu_03.jpg",
                "http://www.bug666.cn:8080/Images/headfirst/swpu_04.jpg"
        );


        public void setMlist(List<HradMessages> mlist) {
            this.mlist = mlist;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (view==null){
                view = inflater.inflate(R.layout.fragment_headimage, container, false);
            }

            headMessageAdapterr = new HeadMessageAdapterr(getActivity(), mlist);
            listView = (ListView) view.findViewById(R.id.head_news);
            listView.setAdapter(headMessageAdapterr);

            ((Banner) view
                    .findViewById(R.id.banner))
                    .setImageLoader(new BannerLoader())
                    .setImages(bannarImgs)
                    .isAutoPlay(true)
                    .start();


            if (headMessageAdapterr != null)
                headMessageAdapterr.notifyDataSetChanged();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Long idOfMessage=mlist.get(position).getMwssageid();
                    Intent intent=new Intent(getActivity(),VisitWebsitsActivity.class);
                    intent.putExtra("message_id",idOfMessage);
                    startActivity(intent);

                }
            });
            return view;

        }

        public void notifyDataSetChanged() {
            headMessageAdapterr.notifyDataSetChanged();
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            ((ViewGroup) view.getParent()).removeView(view);
        }


    }
}

























