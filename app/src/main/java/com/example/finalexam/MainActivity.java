package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.finalexam.adapter.BarangAdapter;
import com.example.finalexam.database.Barang;
import com.example.finalexam.database.DBController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BarangAdapter adapter;
    private ArrayList<Barang> barangArrayList;
    DBController controller = new DBController(this);
    String np, nb, jb;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //penyesuain ke xml
        recyclerView = findViewById(R.id.recycleView);
        fab = findViewById(R.id.floatingBtn);
        //memanggil method BacaData
        BacaData();
        //membuat objek ArrayList dari BarangAdpater
        adapter = new BarangAdapter(barangArrayList);
        //untuk membuat daftar dari recycleView mennjadi linier layout pada MainActivity
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        //memanggil layoutmanager di reciclerView
        recyclerView.setLayoutManager(layoutManager);
        //memanggil adapter di reciclerView
        recyclerView.setAdapter(adapter);

        //Mendefinisikan floating button dari activity
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            ////Mendefinisikan button save dari activity
            public void onClick(View v) {
                //Menentukan perpindahan activity
                Intent intent = new Intent(MainActivity.this,BarangBaru.class);
                //memulai perintah inten
                startActivity(intent);
            }
        });

    }
    //membuat class BacaData
    public void BacaData(){
        //metode untuk mengembalikan elemen pada posisi yang ditentukan dalam daftar ini
        ArrayList<HashMap<String,String>> daftarBarang = controller.getAllBarang();
        //membuat objek array list
        barangArrayList = new ArrayList<>();

        //membuat pengulangan
        for (int i=0;i<daftarBarang.size();i++){
            //membuat objek barang
            Barang brg = new Barang();

            //untuk mendapatkan text dan mengubahnya menjadi string
            brg.setNamapembeli(daftarBarang.get(i).get("Nama Pembeli").toString());
            brg.setNamabarang(daftarBarang.get(i).get("Nama Barang").toString());
            brg.setJumlahbeli(daftarBarang.get(i).get("Jumlah Beli").toString());
            brg.setHarga(daftarBarang.get(i).get("Harga").toString().toString());
            brg.setUangbayar(daftarBarang.get(i).get("Uang Bayar").toString());
            //Menambahkan barang ke daftar barangArrayList
            barangArrayList.add(brg);
        }
    }
}