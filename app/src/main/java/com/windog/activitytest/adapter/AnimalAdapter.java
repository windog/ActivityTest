package com.windog.activitytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.windog.activitytest.R;
import com.windog.activitytest.bean.Animal;

import java.util.List;

/**
 * Created by windog on 2016/3/31.
 *
 * Listview与Adapter的使用，主要代码都在Adapter中
 * 最常用，也最方便的 adapter就是 ArrayAdapter
 */
public class AnimalAdapter extends ArrayAdapter<Animal> {

    private int resourceId;

    //构造方法自己写，（当前的context，子项布局文件ID，数据源）
    public AnimalAdapter(Context context, int resource, List<Animal> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    //每个子项被滚动到屏幕内时，会调用此方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = getItem(position);     //getItem可以得到当前子项的animal实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);    //用layoutflater给当前子项添加布局

        //给子项中的每一个控件设置，分别去model中去找数据，最后再返回此子项的view
        ImageView image = (ImageView) view.findViewById(R.id.item_image);
        TextView name = (TextView) view.findViewById(R.id.item_name);
        TextView speak = (TextView) view.findViewById(R.id.item_speak);

        image.setImageResource(animal.getImageId());
        name.setText(animal.getName());
        speak.setText(animal.getSpeak());

        return view;
    }
}
