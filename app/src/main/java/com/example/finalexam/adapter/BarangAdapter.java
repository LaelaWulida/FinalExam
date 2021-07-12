package com.example.finalexam.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexam.R;
import com.example.finalexam.database.Barang;

import java.util.ArrayList;

//menambahkan file BarangAdapter yang akan kita gunakan untuk data binding dengan RecyclerView
public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {
    //ArrayList  adalah  kelas  yang  memungkinkan  pembuatan  list  objek  array  yang  ukurannya dapat berubah secara dinamis
    // atau bisa dibilang ukuran ArrayList dapat berubah sesuai dengan jumlah data yang dimasukkan.
    private ArrayList<Barang> listData;

    public BarangAdapter(ArrayList<Barang> listData) {
        this.listData = listData = listData;
    }

    //kelas turunan
    @Override
    //metode ini dipanggil ketika ViewHolder kustom harus diinisialisasi. Kita menentukan layout yang harus digunakan masing-masing item dari RecyclerView.
    // Hal ini dilakukan oleh memompa layout menggunakan LayoutInflater, melewatkan output ke constructor dari ViewHolder kustom.
    //onViewCreated() hanya dipanggil jika view dari onCreateView() tidak null
    public BarangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //menghubungkan layout inflate yang telah kita buat dengan adapter
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    //Metode ini sangat mirip dengan metode getView dari adapter ListView
    //di sini adalah di mana Anda harus menetapkan nilai-nilai dari field nama pembeli, nama barang, jumlah bayar, harga, dan uang bayar dari CardView.
    public void onBindViewHolder(BarangViewHolder holder, int position) {
        String np,nb,jb, harga,uangbyr;

        //get(position) untuk mengembalikan posisi cursor saat ini dalam rangkaian baris.
        np = listData.get(position).getNamapembeli();
        nb = listData.get(position).getNamabarang();
        jb = listData.get(position).getJumlahbeli();
        harga = listData.get(position).getHarga();
        uangbyr = listData.get(position).getUangbayar();

        //mengatur warna, dan size dari text
        holder.txtnmpem.setTextColor(Color.BLUE);
        holder.txtnmpem.setTextSize(20);
        holder.txtnmpem.setText(np);
        holder.txtnmbrg.setText(nb);
        holder.txtjmlbrg.setText(jb);

    }

    @Override
    //mengembalikan jumlah entri dalam database
    // list data tidak boleh null
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    //Di dalam constructor dari ViewHolder kustom kita, menginisialisasi views yang termasuk ke dalam item dari RecyclerView kita.
    public class BarangViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView txtnmpem, txtnmbrg, txtjmlbrg;
        public BarangViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            txtnmpem = (TextView) view.findViewById(R.id.txtNamaPem);
            txtnmbrg = (TextView) view.findViewById(R.id.txtNamaBrg);
            txtjmlbrg = (TextView) view.findViewById(R.id.txtJml);
        }


    }
}
