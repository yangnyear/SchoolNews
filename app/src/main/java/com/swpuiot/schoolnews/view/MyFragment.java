package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.UserAdapter;
import com.swpuiot.schoolnews.emtity.UserEntity;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class MyFragment extends Fragment {
    private LinearLayout linearLayout;
    private TextView textMy;
    private ListView mlistview;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_my, container, false);
        }

        final UserAdapter userAdapter = new UserAdapter(getActivity());

        linearLayout = (LinearLayout) view.findViewById(R.id.ll_login);
        textMy = (TextView) view.findViewById(R.id.text_username);
        mlistview = (ListView) view.findViewById(R.id.list_user);
        mlistview.setAdapter(userAdapter);

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
            MainActivity activity = (MainActivity) getActivity();

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserEntity user;
                user = (UserEntity) userAdapter.getItem(position);
                if (textMy.getText().toString().equals("登录")) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                    return;
                } else if (user.getContent().equals("个人资料")) {
                    activity.toMyDatact();
                } else if (user.getContent().equals("我的关注")) {
                    activity.toMyCouncernActivity();
                } else if (user.getContent().equals("我的足迹")) {
                    activity.toHistoryActivity();
                } else if (user.getContent().equals("部门管理")) {
                    activity.toUnitionAdministrationActivity();
                } else if (user.getContent().equals("关于我们")) {
                    Intent intent = new Intent(getActivity(), AboutOursActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
