package com.windog.activitytest.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.windog.activitytest.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //继承于Activity才可以用此句，继承于其他的会出错。
        setContentView(R.layout.first_layout);

        //找到button1,触发一个toast
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked Button1", Toast.LENGTH_LONG).show();
            }
        });

        //跳转到secondActivity
        Button btn2ac2 = (Button) findViewById(R.id.to_activity2);
        btn2ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //隐式跳转到thirdActivity
        Button btn2ac3 = (Button) findViewById(R.id.to_activity3);
        btn2ac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.windog.activitytest.ACTION_START"); //action和category同时满足才可跳转
                intent.addCategory("com.windog.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //action打开浏览器
        Button btn2browser = (Button) findViewById(R.id.to_browser);
        btn2browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        //启动自定义Action
        Button btn2action = (Button) findViewById(R.id.to_action);
        btn2action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory("com.windog.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //action拨打10086
        Button btndial = (Button) findViewById(R.id.to_dial);
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        //启动activity2并期待返回值
        Button btn2result = (Button) findViewById(R.id.to2activity_result);
        btn2result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        Button btn2list = (Button) findViewById(R.id.to_listviewActivity);
        btn2list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });

        //跳转到msg界面
        Button btn2msg = (Button) findViewById(R.id.to_activity5);
        btn2msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,FifthActivity.class);
                startActivity(intent);
            }
        });
    }

    /*接收Activity2返回的data，需通过此方法
    * 可能用startActivityForResult()启动了很多个Activity，接收返回数据，都在这个方法里*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:     //先判断请求码，确定是从Activity 2回来的，再判断返回状态
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("MainActivity", returnedData);
                }
                break;
            default:
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
