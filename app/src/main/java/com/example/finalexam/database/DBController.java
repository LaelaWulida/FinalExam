package com.example.finalexam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper { public DBController(Context context) { super(context, "R_Syar'i Indonesia", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table barang (id inteer primary key, namapembeli, namabarang, jumlahbarang)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists barang");
        onCreate(db);
    }

    public void insertData(HashMap<String,String > queryValues){
    SQLiteDatabase basisdata = this.getWritableDatabase();
    ContentValues nilai = new ContentValues();
    nilai.put("Nama Pembeli",queryValues.get("namapembeli"));
    nilai.put("nama barang", queryValues.get("namabarang"));
    nilai.put("jumlah beli",queryValues.get("jumlahbeli"));
    nilai.put("harga",queryValues.get("harga"));
    nilai.put("uang bayar",queryValues.get("uangbayar"));
    basisdata.insert("barang",null,nilai);
    basisdata.close();
    }

    public ArrayList<HashMap<String,String>> getAllBarang(){
        ArrayList<HashMap<String,String>> daftarBarang;
        daftarBarang = new ArrayList<HashMap<String, String>>();
        String selectQuery = "Select * from barang";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("nama pembeli", cursor.getString(0));
                map.put("nama barang",cursor.getString(1));
                map.put("jumlah beli",cursor.getString(2));
                map.put("harga",cursor.getString(3));
                map.put("uang bayar",cursor.getString(4));
                daftarBarang.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return daftarBarang;
    }
}
