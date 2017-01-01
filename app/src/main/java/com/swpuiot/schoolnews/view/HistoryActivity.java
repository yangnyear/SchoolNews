package com.swpuiot.schoolnews.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.swpuiot.schoolnews.R;
import com.swpuiot.schoolnews.utils.HistoryUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
   private List<HistoryUtils.HistoryItem> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        inilazition();
    }



    public void inilazition() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_history));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.lv);

       history = HistoryUtils.getHistory();
        ArrayList<String> historyTitles = new ArrayList<>();
        for (HistoryUtils.HistoryItem historyItem : history) {
            historyTitles.add(historyItem.title);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historyTitles);
        if (listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HistoryUtils.HistoryItem historyItem = history.get(position);
        String url = historyItem.url;
        String title = historyItem.title;
        Intent intent = new Intent(HistoryActivity.this, WebActivity.class);
        intent.putExtra(WebActivity.ACTION_TITLE, title);
        intent.putExtra(WebActivity.ACTION_URL, url);
        startActivity(intent);
    }
}
