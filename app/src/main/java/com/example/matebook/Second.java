package com.example.matebook;

import static com.example.matebook.MainActivity.arrayList;
import static com.example.matebook.MainActivity.database;
import static com.example.matebook.MainActivity.initSQL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;

public class Second extends AppCompatActivity {
    private EditText title;
    private EditText author;
    private EditText time;
    private EditText content;

    Date data = new Date();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nihao);
        title = (EditText) findViewById(R.id.title);
        author = (EditText) findViewById(R.id.author);
        time = (EditText) findViewById(R.id.time);
        content =(EditText) findViewById(R.id.content);
        FloatingActionButton m = (FloatingActionButton) findViewById(R.id.nn);
        FloatingActionButton n = (FloatingActionButton) findViewById(R.id.jianqu);
        FloatingActionButton p = (FloatingActionButton) findViewById(R.id.back);
        Button button = (Button) findViewById(R.id.bu);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Second.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        int id = intent.getIntExtra("name",-1);
        if(id >= 0)
        {
            duixiang d = arrayList.get(id);
            SQLiteDatabase db = database.getWritableDatabase();
            String data = d.getTitle();
            Cursor cursor = db.query("jiayou",new String[]{"title","author","content","time"},"title=?",new String[]{data},null,null,null,null);
            if(cursor.moveToFirst())
            {
                do{
                    title.setText(cursor.getString(cursor.getColumnIndex("title")));
                    author.setText(cursor.getString(cursor.getColumnIndex("author")));
                    time.setText(cursor.getString(cursor.getColumnIndex("time")));
                    content.setText(cursor.getString(cursor.getColumnIndex("content")));
                }while(cursor.moveToNext());
            }

            cursor.close();

        }
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("title",title.getText().toString());
                values.put("author",author.getText().toString());
                String timedata = time.getText().toString();
                if(TextUtils.isEmpty(timedata))
                {
                    Date s = new Date();
                    String data = s+"";
                    values.put("time",data);
                }
                else{
                    values.put("time",time.getText().toString());
                }
                values.put("content",content.getText().toString());
                db.insert("jiayou",null,values);
                values.clear();
                Intent intent =new Intent(Second.this,MainActivity.class);
                startActivity(intent);
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                String data = title.getText().toString();
                db.delete("jiayou","title=?",new String[]{data});
                Intent intent =new Intent(Second.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = title.getText().toString();
                SQLiteDatabase db = database.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("content",content.getText().toString());
                db.update("jiayou",values,"title=?",new String[]{data1});
                values.clear();
                Intent intent =new Intent(Second.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}