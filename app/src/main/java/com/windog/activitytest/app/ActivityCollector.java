package com.windog.activitytest.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by windog on 2016/3/30.
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {          //循环判断每一个Activity是否finishing(即被destroy)
                activity.finish();
            }
        }
    }
}
