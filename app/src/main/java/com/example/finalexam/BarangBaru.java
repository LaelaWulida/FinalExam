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

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namapembeli = ednmpem.getText().toString().trim();
                namabarang = ednmbrg.getText().toString().trim();
                jumlahbeli = edjmlbelanja.getText().toString().trim();
                harga = edharga.getText().toString().trim();
                uangbayar = eduangbyr.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbel.setText("Total Belanja : " +total);

                if (total >= 150000)
                {
                    txtbonus.setText("Bonus : Manset");
                }else if (total >= 500000)
                {
                    txtbonus.setText("Bonus : Konektor Masker");
                } else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }
                double uangkembalian = (ub-total);

                if (ub<total){
                    txtket.setText("Keterangan : uang bayar kurang Rp" + (-uangkembalian));
                    txtuangkmb.setText("Uang Kembali Rp 0");
                }else{
                    txtket.setText("Keterangan : Tunggu Kembalian");
                    txtuangkmb.setText("Uang Kembali : " +uangkembalian);
                }
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnmpem.setText("");
                txtnmbrg.setText("");
                txttotalbel.setText("Total Belanja : Rp 0");
                txtharga.setText("");
                txtuangbyr.setText("");
                txtuangkmb.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : -");
                txtjmlbel.setText("");
                txtket.setText("Keterangan : -");
                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtnmpem.getText().toString().equals("")||txtnmbrg.getText().toString().equals("")||txtjmlbel.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data belum komplit",Toast.LENGTH_SHORT).show();
                }else{
                    namapembeli = txtnmpem.getText().toString();
                    namabarang = txtnmbrg.getText().toString();
                    jumlahbeli = txtjmlbel.getText().toString();
                    harga = txtharga.getText().toString();
                    uangbayar = txtuangbyr.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("Nama Pembeli",namapembeli);
                    qvalues.put("Nama Barang",namabarang);
                    qvalues.put("Jumlah Beli",jumlahbeli);
                    qvalues.put("Harga",harga);
                    qvalues.put("Uang Bayar",uangbayar);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(BarangBaru.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}