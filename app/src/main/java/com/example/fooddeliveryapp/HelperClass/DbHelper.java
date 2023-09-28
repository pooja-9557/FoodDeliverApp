package com.example.fooddeliveryapp.HelperClass;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.fooddeliveryapp.Model.ModelCartShow;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DataBase_Name="Cart_Library";
    private static final String Table_Name="CartData";
    private static final String Column_1="Id";
    private static final String Column_2="Name";
    private static final String Column_3="Money";
    private static final String Column_4="Add_Cart";
    private static final String Column_5="Image";
    private  static final String Column_6="Total";

    public DbHelper(@Nullable Context context) {
        super(context, Table_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableQuery = "CREATE TABLE " + Table_Name + " (" +
                Column_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Column_2 + " TEXT, " +
                Column_3 + " INTEGER, " +
                Column_4 + " INTEGER, " +
                Column_5 + " INTEGER, " +
                Column_6 + " INTEGER)";

        db.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + Table_Name;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }
    public void InsertData(String name, int money, int no, int image, int total)
    {
        SQLiteDatabase database= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Column_2,name);
        values.put(Column_3,money);
        values.put(Column_4,no);
        values.put(Column_5,image);
        values.put(Column_6, total);
        database.insert(Table_Name,null,values);
    }

    public ArrayList<ModelCartShow> FetchData()
    {
        ArrayList<ModelCartShow> arrayList= new ArrayList<>();
        SQLiteDatabase database= getReadableDatabase();
        Cursor cursor = database.query(Table_Name, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id= cursor.getInt(cursor.getColumnIndex(Column_1));
                String name = cursor.getString(cursor.getColumnIndex(Column_2));
                int money = cursor.getInt(cursor.getColumnIndex(Column_3));
                int no = cursor.getInt(cursor.getColumnIndex(Column_4));
                int image = cursor.getInt(cursor.getColumnIndex(Column_5));
                int total= cursor.getInt(cursor.getColumnIndex(Column_6));
                ModelCartShow model = new ModelCartShow( id,image, money, no, name,total);
                arrayList.add(model);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();

        return arrayList;
    }

    public ArrayList<ModelCartShow> FetchUnique(String Name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ModelCartShow> arrayList= new ArrayList<>();
        SQLiteDatabase database= getReadableDatabase();
        String query=String.format("SELECT * FROM %s where Name = ?", Table_Name);
        Cursor cursor= db.rawQuery(query, new String[]{Name});
        if (cursor.moveToFirst()) {
            do {
                int id= cursor.getInt(cursor.getColumnIndex(Column_1));
                String name = cursor.getString(cursor.getColumnIndex(Column_2));
                int money = cursor.getInt(cursor.getColumnIndex(Column_3));
                int no = cursor.getInt(cursor.getColumnIndex(Column_4));
                int image = cursor.getInt(cursor.getColumnIndex(Column_5));
                int total= cursor.getInt(cursor.getColumnIndex(Column_6));
                ModelCartShow model = new ModelCartShow(id, image, money, no, name,total);
                arrayList.add(model);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return arrayList;
    }
    public void DataUpdate(String name, int money, int no, int image, int total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Column_2,name);
        values.put(Column_3,money);
        values.put(Column_4,no);
        values.put(Column_5,image);
        values.put(Column_6, total);
        db.update(Table_Name, values, Column_2 + "=?", new String[]{name});
        db.close();
    }



}
