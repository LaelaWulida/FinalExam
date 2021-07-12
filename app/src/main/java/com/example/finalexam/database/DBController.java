package com.example.finalexam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

//membuat objek untuk membuat, membuka, dan mengelola database.
public class DBController extends SQLiteOpenHelper { public DBController(Context context) { super(context, "R_Syar'i Indonesia", null, 1); }

    @Override
    //onCreate() akan dipanggil bila sebelumnya tidak ada database
    public void onCreate(SQLiteDatabase db) {
    //execSQL() yaitu method yang digunakan untuk mengeksekusi sintak pada SQL
        db.execSQL("create table barang (id inteer primary key, namapembeli, namabarang, jumlahbarang)");
    }

    @Override
    //onUpgrade() akan dipanggil bila ditemukan database yang sama namun memiliki
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // menghapus tabel lama jika ada
        db.execSQL("drop table if exists barang");
        //membuat table lagi
        onCreate(db);
    }

    //insert() yaitu method yang digunakan untuk menambahkan data ke dalam database
    //HashMap berfungsi sebagai memory record management, dimana setiap record dapat disimpan dalam sebuah Map
    public void insertData(HashMap<String,String > queryValues){
    //untuk menambahkan data baru
    SQLiteDatabase basisdata = this.getWritableDatabase();
    ContentValues nilai = new ContentValues();
    nilai.put("Nama Pembeli",queryValues.get("namapembeli"));
    nilai.put("nama barang", queryValues.get("namabarang"));
    nilai.put("jumlah beli",queryValues.get("jumlahbeli"));
    nilai.put("harga",queryValues.get("harga"));
    nilai.put("uang bayar",queryValues.get("uangbayar"));
    // Memasukkan Baris
    basisdata.insert("barang",null,nilai);
    //menutup koneksi database
    basisdata.close();
    }

    //metode ArrayList<HashMap<String,String>> getAllBarang() untuk mengembalikan elemen pada posisi yang ditentukan dalam daftar ini.
    public ArrayList<HashMap<String,String>> getAllBarang(){
        ArrayList<HashMap<String,String>> daftarBarang;
        // membuat objek array list dari daftarBarang
        daftarBarang = new ArrayList<HashMap<String, String>>();
        //digunakan untuk menampilkan semua data pada tabel barang.
        String selectQuery = "Select * from barang";
        //fungsi untuk mengambil 1 data
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //mengulang semua baris dan menambahkan ke daftar
        if (cursor.moveToFirst()){
            do {
                //membuat objek hashmap
                HashMap<String,String> map = new HashMap<>();
                //mengisi nilai ke objek map
                map.put("nama pembeli", cursor.getString(0));
                map.put("nama barang",cursor.getString(1));
                map.put("jumlah beli",cursor.getString(2));
                map.put("harga",cursor.getString(3));
                map.put("uang bayar",cursor.getString(4));
                //Menambahkan barang ke daftar barang
                daftarBarang.add(map);
            } while (cursor.moveToNext());
        }
        //menutup koneksi database
        db.close();
        //memanggil daftar barang
        return daftarBarang;
    }
}
