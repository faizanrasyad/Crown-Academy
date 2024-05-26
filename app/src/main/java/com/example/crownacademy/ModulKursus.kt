package com.example.crownacademy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.adapters.ModulAdapter
import com.example.crownacademy.databinding.ActivityModulKursusBinding
import com.example.crownacademy.models.ModulModel
import com.example.crownacademy.repos.data

class ModulKursus : AppCompatActivity() {

    private lateinit var binding : ActivityModulKursusBinding

    lateinit var rvModul : RecyclerView
    lateinit var modulArrayList : ArrayList<ModulModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityModulKursusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            tvTitle.text = data.titleSelectedKursus
            btnBack.setOnClickListener {
                onBackPressed()
            }
        }

        data.getData()
        modulArrayList = data.modulArrayList

        rvModul = binding.rvModul
        rvModul.layoutManager = LinearLayoutManager(this ,LinearLayoutManager.VERTICAL, false)
        rvModul.adapter = ModulAdapter(::onClickModul, modulArrayList)
        rvModul.hasFixedSize()

    }

    fun onClickModul(modulModel: ModulModel) {
        data.selectedModul = modulModel
        startActivity(Intent(this, ArtikelKursus::class.java))
    }
}