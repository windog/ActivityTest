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
 * <p/>
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

        View view = null;
        ViewHolder viewHolder;   //自定义内部类

        if (convertView == null) {    //判断convertview是否为空，避免重复加载布局，提高性能
            LayoutInflater.from(getContext()).inflate(resourceId, null);    //用layoutflater给当前子项添加布局
            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView) view.findViewById(R.id.item_image);
            viewHolder.name = (TextView) view.findViewById(R.id.item_name);
            viewHolder.speak = (TextView) view.findViewById(R.id.item_speak);

            view.setTag(viewHolder);  //viewholder存储在view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); //获取出来
        }

        //给子项中的每一个控件设置，分别去model中去找数据，最后再返回此子项的view
        //当控件都存储在viewholder中，就用viewholder来设置即可
        viewHolder.image.setImageResource(animal.getImageId());
        viewHolder.name.setText(animal.getName());
        viewHolder.speak.setText(animal.getSpeak());

        return view;
    }

    //自定义内部类！！！viewHolder
    //加静态是为了在多个地方使用这个 Holder的时候，类只需加载一次，如果只是使用了一次，加不加也没所谓！
    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView speak;
    }
}
