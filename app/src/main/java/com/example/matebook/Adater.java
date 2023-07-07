package com.example.matebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class Adater extends BaseAdapter {
    Context context;
    private ArrayList<duixiang> arrayList;
    public Adater(Context context,ArrayList<duixiang> arraylist)
    {
        this.context = context;
        this.arrayList = arraylist;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.listview,null);
        duixiang d = arrayList.get(i);
        TextView textView = (TextView) view1.findViewById(R.id.title1);
        TextView textView1 = (TextView) view1.findViewById(R.id.author1);
        TextView textView3 = (TextView) view1.findViewById(R.id.time1);
        textView.setText(d.getTitle());
        textView1.setText(d.getAuthor());
        textView3.setText(d.getTime());
        return view1;
    }
}
