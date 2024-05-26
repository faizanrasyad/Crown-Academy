package com.example.crownacademy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.crownacademy.databinding.ActivityMainBinding
import com.example.crownacademy.fragments.BerandaFrag
import com.example.crownacademy.fragments.KursusFrag
import com.example.crownacademy.fragments.KursusSayaFrag
import com.example.crownacademy.fragments.ProfilFrag

class MainActivity : AppCompatActivity() {
    public lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFrag(BerandaFrag())
        binding.apply {
            bottomNavBar.setOnItemSelectedListener {
                when (it.itemId){
                    R.id.beranda -> replaceFrag(BerandaFrag())
                    R.id.kursus -> replaceFrag(KursusFrag())
                    R.id.profil -> replaceFrag(ProfilFrag())
                    R.id.kursusSaya -> replaceFrag(KursusSayaFrag())
                    else -> {}
                }
                true
            }
        }
    }

    private fun replaceFrag(frag: Fragment) {
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()

        fragTransaction.replace(R.id.frameLayout, frag)
        fragTransaction.commit()
    }
}