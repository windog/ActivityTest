package com.windog.activitytest.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.windog.activitytest.R;

/**
 * Created by windog on 2016/3/29.
 */
public class SecondActivity extends BaseActivity {

    NetStateReceiver netStateReceiver;
    LocalBroadcastManager localBroadcastManager;
    MyLocalBroadcastReceiver myLocalBroadcastReceiver;

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

        //接受系统发出的网络变化的广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netStateReceiver = new NetStateReceiver();
        registerReceiver(netStateReceiver, intentFilter);

        //发送自定义广播
        Button btnsendmybroad = (Button) findViewById(R.id.send_myBroadcast);
        btnsendmybroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("windiscall");
                sendBroadcast(intent);
            }
        });

        //发送自定义localBroadcast,并在此接收
        Button btnsendlocal = (Button) findViewById(R.id.send_localBroadcast);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        btnsendlocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("windy");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

                //接收local广播
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("windy");
        myLocalBroadcastReceiver = new MyLocalBroadcastReceiver();
        localBroadcastManager.registerReceiver(myLocalBroadcastReceiver,intentFilter1);
    }

    //当用户不是按button返回，而是按back键返回时，会调用此方法
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello MainActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netStateReceiver);

        localBroadcastManager.unregisterReceiver(myLocalBroadcastReceiver);
    }

    class NetStateReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable() ){
                Toast.makeText(SecondActivity.this,"network is available",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(SecondActivity.this,"network is unavailable",Toast.LENGTH_LONG).show();
            }
        }
    }

    class MyLocalBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(SecondActivity.this,"接收到localBroadcast",Toast.LENGTH_SHORT).show();
        }
    }

}
