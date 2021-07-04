package com.example.finalexam.database;

public class Barang {
    String namapembeli, namabarang, jumlahbeli,harga,uangbayar;

    public Barang(){

    }

    public Barang(String namapembeli, String namabarang, String jumlahbeli, String harga, String uangbayar) {
        this.namapembeli = namapembeli;
        this.namabarang = namabarang;
        this.jumlahbeli = jumlahbeli;
        this.harga = harga;
        this.uangbayar = uangbayar;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getJumlahbeli() {
        return jumlahbeli;
    }

    public void setJumlahbeli(String jumlahbeli) {
        this.jumlahbeli = jumlahbeli;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getUangbayar() {
        return uangbayar;
    }

    public void setUangbayar(String uangbayar) {
        this.uangbayar = uangbayar;
    }
}
