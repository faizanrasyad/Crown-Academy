package com.example.crownacademy.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.MainActivity
import com.example.crownacademy.ModulKursus
import com.example.crownacademy.R
import com.example.crownacademy.adapters.KategoriAdapter
import com.example.crownacademy.adapters.KursusAdapter
import com.example.crownacademy.databinding.FragmentBerandaBinding
import com.example.crownacademy.models.KategoriModel
import com.example.crownacademy.models.KursusModel
import com.example.crownacademy.repos.data

class BerandaFrag : Fragment() {

    private lateinit var binding : FragmentBerandaBinding

    private lateinit var rvKategori : RecyclerView
    private lateinit var kategoriArrayList : ArrayList<KategoriModel>


    private lateinit var rvKursus : RecyclerView
    private lateinit var kursusArrayList : ArrayList<KursusModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data.getData()
        kursusArrayList = data.kursusArrayList
        kategoriArrayList = data.kategoriArrayList
    }

    private fun onClickKat(kategoriModel: KategoriModel) {

    }

    private fun onClickKur(kursusModel: KursusModel) {
        data.titleSelectedKursus = kursusModel.title
        startActivity(Intent(context, ModulKursus::class.java))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBerandaBinding.inflate(inflater, container, false)
        val view = binding.root

        rvKategori = binding.rvKategori
        rvKursus = binding.rvKursus

        rvKategori.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvKursus.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        rvKategori.adapter = KategoriAdapter(::onClickKat, kategoriArrayList)
        rvKursus.adapter = KursusAdapter (::onClickKur, kursusArrayList)

        val snapHelperKursus : LinearSnapHelper = LinearSnapHelper()
        snapHelperKursus.attachToRecyclerView(rvKursus)
        rvKursus.smoothScrollBy(10, 0)

        binding.apply {
            val nama : String = data.namaUser.split('@')[0]
            if (nama == ""){
                tvNama.text = "Pengguna"
            }else{
                tvNama.text = nama
            }
            btnLihatSemuaKursus.setOnClickListener {
                (activity as MainActivity).binding.bottomNavBar.selectedItemId = R.id.kursus
            }
        }

        return view
    }
}