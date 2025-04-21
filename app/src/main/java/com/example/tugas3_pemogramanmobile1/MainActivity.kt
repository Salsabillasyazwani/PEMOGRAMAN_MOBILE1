package com.example.tugas3_pemogramanmobile1

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etNama: EditText
    private lateinit var etNoHp: EditText
    private lateinit var etTempatLahir: EditText
    private lateinit var etTanggalLahir: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnDaftar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etNama = findViewById(R.id.etNama)
        etNoHp = findViewById(R.id.etNoHp)
        etTempatLahir = findViewById(R.id.etTempatLahir)
        etTanggalLahir = findViewById(R.id.etTanggalLahir)
        etAlamat = findViewById(R.id.etAlamat)
        etEmail = findViewById(R.id.etEmail)
        btnDaftar = findViewById(R.id.btnDaftar)

        //tombol daftar
        btnDaftar.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val noHp = etNoHp.text.toString().trim()
            val tempatLahir = etTempatLahir.text.toString().trim()
            val tanggalLahir = etTanggalLahir.text.toString().trim()
            val alamat = etAlamat.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (nama.isEmpty() || noHp.isEmpty() || tempatLahir.isEmpty() ||
                tanggalLahir.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("NAMA", nama)
                intent.putExtra("NO_HP", noHp)
                intent.putExtra("TEMPAT_LAHIR", tempatLahir)
                intent.putExtra("TANGGAL_LAHIR", tanggalLahir)
                intent.putExtra("ALAMAT", alamat)
                intent.putExtra("EMAIL", email)
                startActivity(intent)
            }
        }
        }
}