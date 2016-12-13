package com.swpuiot.schoolnews.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.StudentunitionAdapter;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class StudentsUnitionFragment extends Fragment {
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_students_unition,container,false);

        listView=(ListView) view.findViewById(R.id.list_studentsunition);
        listView.setAdapter(new StudentunitionAdapter(getActivity()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });



        return view;
    }
}
