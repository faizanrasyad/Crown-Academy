package com.example.crownacademy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crownacademy.databinding.ActivityArtikelKursusBinding
import com.example.crownacademy.repos.data

class ArtikelKursus : AppCompatActivity() {

    private lateinit var binding : ActivityArtikelKursusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityArtikelKursusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            tvTitleKursus.text = data.titleSelectedKursus
            tvTitleModul.text = data.selectedModul.title
            tvDurasi.text = "${ data.selectedModul.durasi } Menit"
            tvMateri.text = getString(R.string.dummy_text)
            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}