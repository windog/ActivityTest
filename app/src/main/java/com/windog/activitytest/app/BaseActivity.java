package com.windog.activitytest.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by windog on 2016/3/30.
 * 所有Activity扩展于此类，
 * 1.便于识别当前处于哪个Activity
 * 2.便于集中管理，比如随时退出程序
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
