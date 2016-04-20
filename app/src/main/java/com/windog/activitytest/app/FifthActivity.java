package com.windog.activitytest.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.windog.activitytest.R;
import com.windog.activitytest.adapter.MsgAdapter;
import com.windog.activitytest.bean.Msg;

import java.util.ArrayList;
import java.util.List;

public class FifthActivity extends BaseActivity {

    List<Msg> msgList = new ArrayList<Msg>();
    ListView msgListview;
    EditText editText;
    Button btnSendMsg;
    MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fifth);

        initMsg();

        msgAdapter = new MsgAdapter(FifthActivity.this, R.layout.item_msg, msgList);

        msgListview = (ListView) findViewById(R.id.msg_listview);
        editText = (EditText) findViewById(R.id.msg_content);
        btnSendMsg = (Button) findViewById(R.id.msg_Send);

        msgListview.setAdapter(msgAdapter);

        //代码走到这里，界面已经显示出来了。下面就是按下button的逻辑
        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FifthActivity.this,"hh",Toast.LENGTH_SHORT).show();

                String content = editText.getText().toString();
                if (!"".equals(content)) {
                    msgList.add(new Msg(content, Msg.TYPE_SEND));
                    //数据发生变化时，自动刷新数据集（adapter）
                    msgAdapter.notifyDataSetChanged();

                    //sets the currently selected item (listview定位到最后一行，消息发出，界面自动上移)，不写这句，稍微有点影响体验
                    msgListview.setSelection(msgList.size());

                    editText.setText("");
                }
            }
        });

    }

    public void initMsg() {
        msgList.add(new Msg("Hello!!", Msg.TYPE_RECEIVED));
        msgList.add(new Msg("Nice to see you!!", Msg.TYPE_SEND));
        msgList.add(new Msg("Don't be sad to me because I roam , it keeps me alive!!", Msg.TYPE_RECEIVED));
        msgList.add(new Msg("Gorgeous!!", Msg.TYPE_SEND));
    }
}
