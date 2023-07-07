package com.example.matebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static int number = 0;
    Calendar calendar = Calendar.getInstance();
    Date date = new Date();
    String timedata = date+"";
    static Datebase database;
    private static boolean flat = true;
    private Button button;
    private ListView listView;
    static ArrayList<duixiang> arrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.floatb);
        database = new Datebase(this, "jiayou.dp", null, 1);
        if(flat)
        {
            listView = (ListView) findViewById(R.id.list_item);
            Adater adater = new Adater(MainActivity.this,arrayList);
            listView.setAdapter(adater);
            flat = false;
        }
        SQLiteDatabase db = database.getWritableDatabase();
        initSQL(database);
        /*Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Second.class);
                intent.putExtra("name",i);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Second.class);
                startActivity(intent);
            }
        });
    }

    public static void initSQL(Datebase datebase)
    {
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.query("jiayou",null,null,null,null,null,null,null);
        if(cursor.moveToFirst())
        {
            do{
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String time = cursor.getString(cursor.getColumnIndex("time"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    //String content = cursor.getString(cursor.getColumnIndex("content"));
                    duixiang d = new duixiang(title,author,time);
                    if(!arrayList.contains(d))
                    {
                        arrayList.add(d);
                    }

                }while(cursor.moveToNext());
            }

        cursor.close();
        }

    /*@Override
    protected void onResume() {
        super.onResume();
        Adater adapter = new Adater(MainActivity.this, arrayList);
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }*/




    }
