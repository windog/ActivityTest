package com.windog.activitytest.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.windog.activitytest.R;

/**
 * Created by windog on 2016/3/29.
 */
public class SecondActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Button btn2 = (Button) findViewById(R.id.button_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello MainActivity");
                //startActivity(intent);   区别在此！！！
                setResult(RESULT_OK, intent);  //给上一个activity返回数据，第一个参数代表处理结果，第二个参数是带数据的intent
                finish();
            }
        });
    }

    //当用户不是按button返回，而是按back键返回时，会调用此方法
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello MainActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

}
