package com.blogspot.riteshcodejava.savethenote.MyDbHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.blogspot.riteshcodejava.savethenote.ShowDataActivity.DataModels;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "saveTheNote.db";
    private static final String TABLE_NAME  = "note";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT, note TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String title, String data){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("note",data);
        long hasInserted = database.insert(TABLE_NAME,null,contentValues);
        if(hasInserted == -1){
            return false;
        }else
            return true;
    }
    public ArrayList<DataModels> getData(){
        ArrayList<DataModels> dataList = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                DataModels dataModels  = new DataModels();
                dataModels.setId(cursor.getInt(0));
                dataModels.setData(cursor.getString(1));
                dataList.add(dataModels);
        }
        }
        return dataList;
    }
}
