package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.UserAdapter;
import com.swpuiot.schoolnews.emtity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class MyFragment extends Fragment {
    private List<UserEntity>userOfList=new ArrayList<UserEntity>();
    private LinearLayout linearLayout;
    private TextView textMy;
    private ListView mlistview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my,container,false);

        linearLayout= (LinearLayout) view.findViewById(R.id.ll_login);
        textMy= (TextView) view.findViewById(R.id.text_username);
        mlistview= (ListView) view.findViewById(R.id.list_user);
        mlistview.setAdapter(new UserAdapter(getActivity()));

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textMy.getText().toString().equals("登录")) {
                    return;
                }
                MainActivity activity = (MainActivity) getActivity();
                activity.toLoginAct();

            }
        });
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserEntity user = userOfList.get(position);
                if (user.getContent().equals("个人资料")) {

                }
            }
        });



        return view;
    }

}
