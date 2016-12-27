package com.swpuiot.schoolnews.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/27.
 */
public class HistoryUtils {


    private static final String TAG = "HistoryUtils";

    public static class HistoryItem {

        public HistoryItem(String title, String url) {
            this.title = title;
            this.url = url;
        }

        public String title;
        public String url;

        @Override
        public String toString() {
            return "HistoryItem{" +
                    "title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (super.equals(o)) return true;
            if (!(o instanceof HistoryItem)) return false;
            HistoryItem h = (HistoryItem) o;
            return this.title.equals(h.title) && this.url.equals(h.url);
        }
    }

    public static void saveHistory(HistoryItem item) {
        Log.i(TAG, "saveHistory: " + item.toString());
        if (!items.contains(item)) items.add(item);
    }

    static ArrayList<HistoryItem> items = new ArrayList<>();

    public static List<HistoryItem> getHistory() {
        Log.i(TAG, "getHistory: ");


        return items;
    }

}
