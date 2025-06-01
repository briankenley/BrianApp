package com.example.brianapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;

public class Kalkulator extends AppCompatActivity {

    EditText edtNilaiA, edtNilaiB;
    Button btnTambah, btnKali, btnBagi;
    TextView txtTitle, txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);

        txtTitle = findViewById(R.id.txtTitle);
        edtNilaiA = findViewById(R.id.edtNilaiA);
        edtNilaiB = findViewById(R.id.edtNilaiB);
        btnTambah = findViewById(R.id.btnTambah);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        txtHasil = findViewById(R.id.txtHasil);

        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName != null) {
            txtTitle.setText("Kalkulator Sederhana : " + userName);
        }


        View.OnClickListener Kalkulasi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nilai1Str = edtNilaiA.getText().toString();
                String nilai2Str = edtNilaiB.getText().toString();

                if (nilai1Str.isEmpty() || nilai2Str.isEmpty()) {
                    Toast.makeText(Kalkulator.this, "Mohon isi kedua angka", Toast.LENGTH_SHORT).show();
                    return;
                }

                double angka1 = Double.parseDouble(nilai1Str);
                double angka2 = Double.parseDouble(nilai2Str);
                double hasil = 0;

                int id = v.getId();

                if (id == R.id.btnTambah) {
                    hasil = angka1 + angka2;
                } else if (id == R.id.btnKali) {
                    hasil = angka1 * angka2;
                } else if (id == R.id.btnBagi) {
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                    } else {
                        Toast.makeText(Kalkulator.this, "Tidak bisa dibagi 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }


                if (hasil == (int) hasil) {
                    txtHasil.setText("Hasil: " + (int) hasil);
                } else {
                    txtHasil.setText("Hasil: " + hasil);
                }
            }

        };

        btnTambah.setOnClickListener(Kalkulasi);
        btnKali.setOnClickListener(Kalkulasi);
        btnBagi.setOnClickListener(Kalkulasi);
    }
}