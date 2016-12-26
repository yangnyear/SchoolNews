package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.MypagerAdapter;
import com.swpuiot.schoolnews.emtity.HradMessages;
import com.swpuiot.schoolnews.emtity.MasResponseEmpty;
import com.swpuiot.schoolnews.emtity.UserResponseEmpty;

import org.apache.http.Header;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<Fragment> viewList;
    private ViewPager viewPager;
    private MyDataActivity.HeadImageFragment headImageFragment;
    private ActionFragment actionFragment;
    private StudentsUnitionFragment studentsUnitionFragment;
    private MyFragment myFragment;
    public UserResponseEmpty.DateBean userDataBean;
    public List<HradMessages> mlist = new ArrayList<HradMessages>();
    public List<HradMessages> mylist = new ArrayList<HradMessages>();

    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.Bellow_page);

        //加载底部导航栏
        radioGroup = (RadioGroup) findViewById(R.id.navi_radiogroup);
        findViewById(R.id.betton_head).setOnClickListener(this);
        findViewById(R.id.betton_scecond).setOnClickListener(this);
        findViewById(R.id.betton_thired).setOnClickListener(this);
        findViewById(R.id.betton_fourth).setOnClickListener(this);

        //访问网络，获得message
        AsyncHttpClient test = new AsyncHttpClient();
        test.get("http://www.bug666.cn:8090/getAllMessages", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                ObjectMapper objectMapper = new ObjectMapper();
                MasResponseEmpty masResponseEmpty = new MasResponseEmpty();
                try {
                    masResponseEmpty = objectMapper.readValue(bytes, MasResponseEmpty.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mlist.clear();

                //获取message数组，然后将不同类型的message分开放到两个数组中
                for (int j = 0; j < masResponseEmpty.getContent().size(); j++) {
                    if (masResponseEmpty.getContent().get(j).isFlag()) {
                        mlist.add(new HradMessages(masResponseEmpty.getContent().get(j).getTitle(),
                                masResponseEmpty.getContent().get(j).getContent(),
                                masResponseEmpty.getContent().get(j).getImageUrl(),
                                (long) masResponseEmpty.getContent().get(j).getId()));
                    } else if (!masResponseEmpty.getContent().get(j).isFlag()) {
                        mylist.add(new HradMessages(masResponseEmpty.getContent().get(j).getTitle(),
                                masResponseEmpty.getContent().get(j).getContent(),
                                masResponseEmpty.getContent().get(j).getImageUrl(),
                                (long) masResponseEmpty.getContent().get(j).getId()));
                    }
                }
                if (headImageFragment != null) {
                    headImageFragment.notifyDataSetChanged();
                }
                if (actionFragment != null) {
                    actionFragment.notifyDataSetChanged();
                }

            }

            //访问不成功
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(MainActivity.this, "网络异常，请检查网络", Toast.LENGTH_SHORT).show();

            }
        });




        viewList = new ArrayList<Fragment>();

        headImageFragment = new MyDataActivity.HeadImageFragment();
        actionFragment = new ActionFragment();
        studentsUnitionFragment = new StudentsUnitionFragment();
        myFragment = new MyFragment();
        headImageFragment.setMlist(mlist);
        actionFragment.setMlist(mylist);

        viewList.add(headImageFragment);
        viewList.add(actionFragment);
        viewList.add(studentsUnitionFragment);
        viewList.add(myFragment);
        //创建pagerAdapter适配器
        MypagerAdapter mypagerAdapter = new MypagerAdapter(getSupportFragmentManager(), viewList);
        //加载适配器
        viewPager.setAdapter(mypagerAdapter);
        //检查监听滑动
        viewPager.setOnPageChangeListener(this);
        radioGroup.check(R.id.betton_head);
    }

    public void toLoginAct() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    userDataBean = (UserResponseEmpty.DateBean) data.getSerializableExtra("DataBean_data");
                    TextView textView = (TextView) myFragment.getView().findViewById(R.id.text_username);
                    TextView text_xiao = (TextView) myFragment.getView().findViewById(R.id.text_user_xiao);
                    textView.setText(userDataBean.getName());
                    text_xiao.setText(userDataBean.getMajor());
                    com.facebook.drawee.view.SimpleDraweeView sdv = (SimpleDraweeView) myFragment.getView().findViewById(R.id.image_mylogo);
                    Uri uri = Uri.parse(userDataBean.getSetLogoSrc());
                    sdv.setImageURI(uri);

                    ImagePipeline imagePipeline = Fresco.getImagePipeline();
                    imagePipeline.evictFromMemoryCache(uri);
                    imagePipeline.evictFromDiskCache(uri);
                    imagePipeline.evictFromCache(uri);
                }
        }
    }

    public void toMyDatact() {
        Intent intent = new Intent(MainActivity.this, MyDataActivity.class);
        intent.putExtra("user_imfo", userDataBean);
        startActivity(intent);
    }
    public void toUnitionAdministrationActivity(){
        Intent intent=new Intent(MainActivity.this,DepartmentAdministrationActivity.class);
        startActivity(intent);
    }
    public void toHistoryActivity(){
        Intent intent=new Intent(MainActivity.this,HistoryActivity.class);
        startActivity(intent);
    }
    public void toMyCouncernActivity(){
        Intent intent=new Intent(MainActivity.this,MyConcernActivity.class);
        startActivity(intent);
    }


    @Override
    public void finish() {
        ViewGroup view = (ViewGroup) getWindow().getDecorView();
        view.removeAllViews();
        super.finish();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.betton_head);

                break;
            case 1:
                radioGroup.check(R.id.betton_scecond);
                break;
            case 2:
                radioGroup.check(R.id.betton_thired);
                break;
            case 3:
                radioGroup.check(R.id.betton_fourth);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.betton_fourth:
                viewPager.setCurrentItem(3, true);
                break;
            case R.id.betton_thired:
                viewPager.setCurrentItem(2, true);
                break;
            case R.id.betton_scecond:
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.betton_head:
                viewPager.setCurrentItem(0, true);
                break;
            default:
                break;
        }
    }
//    public List getFirstGridViewList(){
//        List<GridViewentity>gridViewentityList=new ArrayList<GridViewentity>();{
//            new GridViewentity(R.drawable.face_01,"快乐石工");
//            new GridViewentity(R.drawable.face_02,"灵动计科");
//            new GridViewentity(R.drawable.face_03,"呆萌化工");
//            new GridViewentity(R.drawable.face_04,"静默土建");
//            new GridViewentity(R.drawable.face_05,"优雅外语");
//            new GridViewentity(R.drawable.face_06,"多彩材科");
//            new GridViewentity(R.drawable.face_07,"幸福法学");
//            new GridViewentity(R.drawable.face_08,"缤纷艺术");
//        }
//        return gridViewentityList;
//    }
//    public List getScendGridViewList(){
//        List<GridViewentity>gridViewentityList=new ArrayList<GridViewentity>();{
//            new GridViewentity(R.drawable.face_09,"无限地科");
//            new GridViewentity(R.drawable.face_10,"刚强体育");
//            new GridViewentity(R.drawable.face_11,"竞彩电信");
//            new GridViewentity(R.drawable.face_12,"奋进机电");
//        }
//        return gridViewentityList;
//    }
}
