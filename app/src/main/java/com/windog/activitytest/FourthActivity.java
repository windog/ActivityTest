package com.windog.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.windog.activitytest.adapter.AnimalAdapter;
import com.windog.activitytest.bean.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by windog on 2016/3/31.
 */
public class FourthActivity extends Activity {

    private List<Animal> animalList = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);

        initAnimals();

        //adapter的构造，需要（当前的context，子项布局文件ID，数据源）,这个构造方法是自己写的
        AnimalAdapter animalAdapter = new AnimalAdapter(FourthActivity.this,R.layout.animal_item,animalList);

        //然后listview，set之前new好的adapter
        ListView listView = (ListView) findViewById(R.id.animal_listview);
        listView.setAdapter(animalAdapter);
    }

    //提供数据的方法，如果以后从网络取数据，也注意要另起一个方法，代码会更明了。
    public void initAnimals(){
        Animal dog = new Animal(R.drawable.dog,"dog","Are you a dog??");
        animalList.add(dog);

        animalList.add(new Animal(R.drawable.cat,"dog","Are you a bull"));
        animalList.add(new Animal(R.drawable.bull,"bull","Are you a cat"));
        animalList.add(new Animal(R.drawable.sheep,"cat","Are you a sheep"));
        animalList.add(new Animal(R.drawable.bull,"sheep","Are you a cat"));
        animalList.add(new Animal(R.drawable.cat,"dog","Are you a bull"));
        animalList.add(new Animal(R.drawable.bull,"bull","Are you a sheep"));
        animalList.add(new Animal(R.drawable.sheep,"cat","Are you a bull"));
        animalList.add(new Animal(R.drawable.dog,"bull","Are you a sheep"));
        animalList.add(new Animal(R.drawable.sheep,"sheep","Are you a bull"));
    }
}
