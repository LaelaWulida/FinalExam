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

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {
    private ArrayList<Barang> listData;

    public BarangAdapter(ArrayList<Barang> listData) {
        this.listData = listData = listData;
    }

    @Override
    public BarangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BarangViewHolder holder, int position) {
        String np,nb,jb, harga,uangbyr;

        np = listData.get(position).getNamapembeli();
        nb = listData.get(position).getNamabarang();
        jb = listData.get(position).getJumlahbeli();
        harga = listData.get(position).getHarga();
        uangbyr = listData.get(position).getUangbayar();

        holder.txtnmpem.setTextColor(Color.BLUE);
        holder.txtnmpem.setTextSize(20);
        holder.txtnmpem.setText(np);
        holder.txtnmbrg.setText(nb);
        holder.txtjmlbrg.setText(jb);

    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

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
