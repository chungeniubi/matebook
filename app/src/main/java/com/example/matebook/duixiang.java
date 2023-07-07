package com.example.matebook;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class duixiang  {
    private String title;
    private String author;
    private String time;
    private int id;

    public duixiang(String title, String author, String time) {
        this.title = title;
        this.author = author;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
