package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalexam.database.Barang;
import com.example.finalexam.database.DBController;

import java.util.HashMap;

//mempunyai Sub Class yang bernama Barang Baru dengan keyword extends ,yang digunakan untuk mewariskan sifat-sifat yang ada di dalam Super Class AppCompatActivity.
public class BarangBaru extends AppCompatActivity {
    private Button btnproses, btnreset,btnsave;
    private EditText ednmpem,ednmbrg,edjmlbelanja,edharga,eduangbyr;
    private TextView txtnmpem,txtnmbrg,txtjmlbel,txtharga,txtuangbyr,txtbonus,txttotalbel,txtuangkmb,txtket,txtJudul;
    String namapembeli, namabarang, jumlahbeli,harga,uangbayar;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_baru);

        //penyesuaian ke xml
        ednmpem = findViewById(R.id.edNmPem);
        edharga = findViewById(R.id.edHarga);
        edjmlbelanja = findViewById(R.id.edJmlBrg);
        ednmbrg = findViewById(R.id.edNmBrg);
        eduangbyr = findViewById(R.id.edUangByr);
        txtbonus = findViewById(R.id.tvBonus);
        txtharga = findViewById(R.id.tvHarga);
        txtjmlbel = findViewById(R.id.tvJmlBrg);
        txtJudul = findViewById(R.id.tvJudul);
        txtket = findViewById(R.id.tvket);
        txtnmbrg = findViewById(R.id.tvnmBrg);
        txtnmpem = findViewById(R.id.tvNmPem);
        txttotalbel = findViewById(R.id.tvTotalBelanja);
        txtuangbyr = findViewById(R.id.tvUangByr);
        txtuangkmb = findViewById(R.id.tvUangKmb);
        btnsave = findViewById(R.id.btnSave);
        btnproses = findViewById(R.id.btnProses);
        btnreset = findViewById(R.id.btnRD);

        //Mendefinisikan button proses dari activity
        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Fungsi yang terjadi jika button diklik
                //getText untuk mengambil teks pada field text dari form
                //toString ini berfungsi untuk merepresentasikan sebuah objek apapun ,menjadi sebuah String.
                //trim  untuk menghapus spasi
                namapembeli = ednmpem.getText().toString().trim();
                namabarang = ednmbrg.getText().toString().trim();
                jumlahbeli = edjmlbelanja.getText().toString().trim();
                harga = edharga.getText().toString().trim();
                uangbayar = eduangbyr.getText().toString().trim();

                //// mengembalikan nilai ganda yang diwakili oleh argumen string
                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                //rumus menghitung total
                double total = (jb * h);
//              //memunculkan sebuah teks pada text total menjadi "total belanja:" +hasil penghitungan dari total
                txttotalbel.setText("Total Belanja : " +total);

                //Jika belanja lebih dari atau sama dengan 150000 maka akan mendapatkan bonus manset
                if (total >= 150000)
                {
                    txtbonus.setText("Bonus : Manset");
                }else if (total >= 500000) //Jika belanja lebih dari atau sama dengan 50000 maka akan mendapatkan bonus konektor masker
                {
                    txtbonus.setText("Bonus : Konektor Masker");
                } else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }
                double uangkembalian = (ub-total);

                //jika uang bayar kurang dari total belanja maka akan mendapatkan keterangan "uang bayar kurang"
                if (ub<total){
                    //memunculkan sebuah teks
                    txtket.setText("Keterangan : uang bayar kurang Rp" + (-uangkembalian));
                    txtuangkmb.setText("Uang Kembali Rp 0");
                }else{ //jika uang bayar lebih dari total belanja maka akan dapat uang kembalian
                    //memunculkan sebuah teks
                    txtket.setText("Keterangan : Tunggu Kembalian");
                    txtuangkmb.setText("Uang Kembali : " +uangkembalian);
                }
            }
        });

        ////Mendefinisikan button reset dari activity
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            //Fungsi yang terjadi jika button diklik
            public void onClick(View v) {
                //memunculkan sebuah teks
                txtnmpem.setText("");
                txtnmbrg.setText("");
                txttotalbel.setText("Total Belanja : Rp 0");
                txtharga.setText("");
                txtuangbyr.setText("");
                txtuangkmb.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : -");
                txtjmlbel.setText("");
                txtket.setText("Keterangan : -");
                //code untuk menampilkan pesan
                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();
            }
        });

        //Mendefinisikan button save dari activity
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            //Fungsi yang terjadi jika button diklik
            public void onClick(View v) {
                //menggunakan equals agar semua karakter dari kedua variable tersebut harus sama
                if(txtnmpem.getText().toString().equals("")||txtnmbrg.getText().toString().equals("")||txtjmlbel.getText().toString().equals("")){
                    //code untuk menampilkan pesan
                    Toast.makeText(getApplicationContext(),"Data belum komplit",Toast.LENGTH_SHORT).show();
                }else{
                    //getText untuk mengambil teks pada field text dari form
                    //toString ini berfungsi untuk merepresentasikan sebuah objek apapun ,menjadi sebuah String.
                    namapembeli = txtnmpem.getText().toString();
                    namabarang = txtnmbrg.getText().toString();
                    jumlahbeli = txtjmlbel.getText().toString();
                    harga = txtharga.getText().toString();
                    uangbayar = txtuangbyr.getText().toString();

                    ////membuat objek hashmap
                    HashMap<String,String> qvalues = new HashMap<>();
                    //mengisi nilai ke objek qvalues
                    qvalues.put("Nama Pembeli",namapembeli);
                    qvalues.put("Nama Barang",namabarang);
                    qvalues.put("Jumlah Beli",jumlahbeli);
                    qvalues.put("Harga",harga);
                    qvalues.put("Uang Bayar",uangbayar);

                    //menambahkan data dari DBController menggunakan qvalues
                    controller.insertData(qvalues);
                    //memanggil methode callHome
                    callHome();
                }
            }
        });
    }

    //methode untuk memanggil callHome
    public void callHome(){
        ////Menentukan perpindahan activity
        Intent intent = new Intent(BarangBaru.this,MainActivity.class);
        //Memulai perintah Intent
        startActivity(intent);
        finish();
    }
}