package com.windog.activitytest.bean;

/**
 * Created by windog on 2016/4/2.
 */
public class Msg {
    private String content;
    private int type;

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public Msg(String content, int type) {

        this.content = content;
        this.type = type;
    }
}
