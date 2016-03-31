package com.windog.activitytest.bean;

/**
 * Created by windog on 2016/3/31.
 */
public class Animal {

    private int imageId;
    private String name;
    private String speak;

    public Animal(int imageId, String name, String speak) {
        this.imageId = imageId;
        this.name = name;
        this.speak = speak;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }
}
