package com.example.memelords;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Table_Name = "Meme";
    private static final String Col1 = "ID";
    private static final String Col2 = "FilePath";
    private static final String Col3 = "Publish";



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Col2 + " Text," + Col3 +" Text)";
        db.execSQL(createTable);
    }

    public DatabaseHelper(Context context) {
        super(context,Table_Name,null,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addData(String item ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col2,item);
        contentValues.put(Col2,item);

        Log.d("DB:","addData: Adding " + item + "to "+ Table_Name);

        Long result = db.insert(Table_Name,null,contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
}
