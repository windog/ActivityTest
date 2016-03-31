package com.windog.activitytest;

import android.os.Bundle;
import android.view.View;

/**
 * Created by windog on 2016/3/29.
 */
public class ThirdActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        //exit App,invoke ActivityCollector.finishAll();
       findViewById(R.id.finish_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
            }
        });
    }
}
