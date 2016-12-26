package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.adapter.StudentunitionAdapter;
import com.swpuiot.schoolnews.emtity.StudentsUnition;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class StudentsUnitionFragment extends Fragment {
    private ListView listView;
    private View view;
    private StudentunitionAdapter studentunitionAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view==null){
            view = inflater.inflate(R.layout.fragment_students_unition,container,false);
        }
        listView=(ListView) view.findViewById(R.id.list_studentsunition);
        studentunitionAdapter=new StudentunitionAdapter(getActivity());
        listView.setAdapter(studentunitionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentsUnition studentsUnition= (StudentsUnition)studentunitionAdapter.getItem(position);
                long instituteId = (long)studentsUnition.getId();
                Intent intent=new Intent(getActivity(),VisitWebsitsActivity.class);
                intent.putExtra("studentUnitionId",instituteId);
                startActivity(intent);
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
