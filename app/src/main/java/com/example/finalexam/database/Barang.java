package com.example.finalexam.database;

public class Barang {
    //String dari class barang
    String namapembeli, namabarang, jumlahbeli,harga,uangbayar;

    public Barang(){

    }

    public Barang(String namapembeli, String namabarang, String jumlahbeli, String harga, String uangbayar) {
        //kelas Barang yang akan menampilkan nama barng
        this.namapembeli = namapembeli;
        //kelas Barang yang akan menampilkan nama pembeli
        this.namabarang = namabarang;
        //kelas Barang yang akan menampilkan jumlah pembeli
        this.jumlahbeli = jumlahbeli;
        //kelas Barang yang akan menampilkan harga
        this.harga = harga;
        //kelas Barang yang akan menampilkan uang bayar
        this.uangbayar = uangbayar;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    //public void setNamapembeli untuk mengubah atau memberikan nilai dari kelas barang yaitu nama pembeli
    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    //memanggil metode getNamabarang untuk mengembalikan nilai dari nama barang
    public String getNamabarang() {
        return namabarang;
    }

    //public void setNamabarang untuk mengubah atau memberikan nilai dari kelas barang yaitu nama barang
    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    //memnaggil metode getJumlahbeli untuk mengembalikan nilai dari jumlah beli
    public String getJumlahbeli() {
        return jumlahbeli;
    }

    //public void setJumlahbeli untuk mengubah atau memberikan nilai dari kelas barang yaitu jumlah barang
    public void setJumlahbeli(String jumlahbeli) {
        this.jumlahbeli = jumlahbeli;
    }

    //memanggil metode getHarga untuk mengembalikan nilai dari harga
    public String getHarga() {
        return harga;
    }

    //public void setHarga untuk mengubah atau memberikan nilai dari kelas barang yaitu harga
    public void setHarga(String harga) {
        this.harga = harga;
    }

    //memanggil metoode getUangbayar untuk mengembalikan nilai dari uang bayar
    public String getUangbayar() {
        return uangbayar;
    }

    //public void setUangbayar untuk mengubah atau memberikan nilai dari kelas barang yaitu uang bayar
    public void setUangbayar(String uangbayar) {
        this.uangbayar = uangbayar;
    }
}
