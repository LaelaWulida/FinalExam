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

        recyclerView = findViewById(R.id.recycleView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new BarangAdapter(barangArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BarangBaru.class);
                startActivity(intent);
            }
        });

    }
    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarBarang = controller.getAllBarang();
        barangArrayList = new ArrayList<>();

        for (int i=0;i<daftarBarang.size();i++){
            Barang brg = new Barang();

            brg.setNamapembeli(daftarBarang.get(i).get("Nama Pembeli").toString());
            brg.setNamabarang(daftarBarang.get(i).get("Nama Barang").toString());
            brg.setJumlahbeli(daftarBarang.get(i).get("Jumlah Beli").toString());
            brg.setHarga(daftarBarang.get(i).get("Harga").toString().toString());
            brg.setUangbayar(daftarBarang.get(i).get("Uang Bayar").toString());
            barangArrayList.add(brg);
        }
    }
}