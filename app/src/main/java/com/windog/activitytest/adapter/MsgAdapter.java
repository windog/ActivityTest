package com.windog.activitytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.windog.activitytest.R;
import com.windog.activitytest.bean.Msg;

import java.util.List;

/**
 * Created by windog on 2016/4/2.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

    int itemId;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        itemId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view;

        ViewHolder viewHolder;
        if (convertView == null){

            view = LayoutInflater.from(getContext()).inflate(itemId, null);
            viewHolder = new ViewHolder();

            viewHolder.magLeftLay = (LinearLayout) view.findViewById(R.id.msg_left_layout);
            viewHolder.magRightLay = (LinearLayout) view.findViewById(R.id.msg_right_layout);
            viewHolder.msgLeft = (TextView) view.findViewById(R.id.msg_left);
            viewHolder.msgRight = (TextView) view.findViewById(R.id.msg_right);

            view.setTag(viewHolder);
        }else {
            view = convertView ;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (msg.getType() == Msg.TYPE_RECEIVED) {
            viewHolder.magLeftLay.setVisibility(View.VISIBLE);
            viewHolder.magRightLay.setVisibility(View.GONE);

            viewHolder.msgLeft.setText(msg.getContent());
        } else if (msg.getType() == msg.TYPE_SEND) {
            viewHolder.magRightLay.setVisibility(View.VISIBLE);
            viewHolder.magLeftLay.setVisibility(View.GONE);

            viewHolder.msgRight.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder{
        LinearLayout magLeftLay;
        LinearLayout magRightLay;
        TextView msgLeft;
        TextView msgRight;

    }

}
