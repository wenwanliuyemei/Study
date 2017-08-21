package com.xm.study.home.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：xm on 2017/1/3 11:35
 * 描述：Activity的装载类
 */
public class ActivityHolder {
    Map<String, Class<? extends Activity>> mActivityMap;
    List<String> mNaneList;

    public ActivityHolder() {
        mActivityMap = new HashMap<>();
        mNaneList = new ArrayList<>();
    }

    public void addActivity(String name, Class<? extends Activity> activity) {
        if (!mActivityMap.containsKey(name)) {
            mNaneList.add(name);
            mActivityMap.put(name, activity);
        }
    }

    public List<String> getmNaneList() {
        return mNaneList;
    }

    public Class<? extends Activity> getActivity(String name) {
        return mActivityMap.get(name);
    }
}
