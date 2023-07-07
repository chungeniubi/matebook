package com.example.matebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Datebase extends SQLiteOpenHelper {
    public static final String CREATE_BIJI = "Create table jiayou("+"id integer primary key autoincrement,"
            +"title text,"+"author text,"+"content text,"+"time text)";
    private Context mcontext;
    public Datebase(Context context,String name,SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,name,factory,version);
        mcontext = context;

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BIJI);
        Toast.makeText(mcontext,"Create Succeed!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
