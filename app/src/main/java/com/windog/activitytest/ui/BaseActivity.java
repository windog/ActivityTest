package com.windog.activitytest.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by windog on 2016/3/30.
 * 所有Activity扩展于此类，
 * 1.便于识别当前处于哪个Activity
 * 2.便于集中管理，比如随时退出程序
 *
 * 此方法并不是很优雅,但很好理解.
 * Android退出应用最优雅的方式(改进版) , evernote中有篇文章可以看到更好的方法.
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
