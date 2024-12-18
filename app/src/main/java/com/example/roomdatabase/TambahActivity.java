package com.example.roomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.roomdatabase.entitas.Mahasiswa;

public class TambahActivity extends AppCompatActivity {

    EditText etNama, etNPM;
    Button btnSimpan;
    AppDatabase database;
    int id = 0;
    boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tambah);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNama = findViewById(R.id.etNama);
        etNPM = findViewById(R.id.etNPM);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        if (id > 0) {
            isEdit = true;
            Mahasiswa mahasiswa = database.mahasiswaDao().get(id);
            etNama.setText(mahasiswa.fullname);
            etNPM.setText(mahasiswa.nim);
        } else {
            isEdit = false;
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.fullname = etNama.getText().toString();
                mahasiswa.nim = etNPM.getText().toString();

                if (isEdit) {
                    database.mahasiswaDao().update(id, mahasiswa.fullname, mahasiswa.nim);
                } else {
                    database.mahasiswaDao().insertAll(mahasiswa);
                }
                finish();
            }
        });
    }
}