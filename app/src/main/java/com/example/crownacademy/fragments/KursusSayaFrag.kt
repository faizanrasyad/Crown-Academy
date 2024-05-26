package com.example.crownacademy.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.ModulKursus
import com.example.crownacademy.R
import com.example.crownacademy.adapters.KursusAdapter
import com.example.crownacademy.databinding.FragmentKursusSayaBinding
import com.example.crownacademy.models.KursusModel
import com.example.crownacademy.repos.data

class KursusSayaFrag : Fragment() {

    private lateinit var binding : FragmentKursusSayaBinding

    lateinit var rvKursus : RecyclerView
    lateinit var kursusArrayList : ArrayList<KursusModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data.getData()
        kursusArrayList = data.kursusArrayList
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentKursusSayaBinding.inflate(inflater, container, false)
        val view = binding.root

        rvKursus = binding.rvKursus
        rvKursus.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvKursus.setHasFixedSize(true)
        rvKursus.adapter = KursusAdapter(::onClickKursus, kursusArrayList)

        return view
    }

    fun onClickKursus(kursusModel: KursusModel) {
        data.titleSelectedKursus = kursusModel.title
        startActivity(Intent(context, ModulKursus::class.java))
    }
}