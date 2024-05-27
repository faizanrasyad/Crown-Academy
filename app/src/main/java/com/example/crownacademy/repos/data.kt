package com.example.crownacademy.repos

import android.content.res.Resources
import android.util.Log
import com.example.crownacademy.R
import com.example.crownacademy.models.KategoriModel
import com.example.crownacademy.models.KursusModel
import com.example.crownacademy.models.ModulModel

object data {

    var namaUser : String = ""

    var titleSelectedKursus : String = ""
    lateinit var selectedModul : ModulModel

    lateinit var kategoriArrayList : ArrayList<KategoriModel>
    lateinit var titleKat : Array<String>
    lateinit var kursus : Array<Int>

    lateinit var kursusArrayList : ArrayList<KursusModel>
    lateinit var titleKur : Array<String>
    lateinit var harga : Array<Int>
    lateinit var modul : Array<Int>
    lateinit var rating : Array<Double>

    lateinit var modulArrayList : ArrayList<ModulModel>
    lateinit var titleMod : Array<String>
    lateinit var durasi : Array<Int>

    fun getData(){
        //Arrays of Kategori
        titleKat = arrayOf(
            "Desain Grafis",
            "UI/UX",
            "Web Tech",
            "Manajemen Bisnis",
            "Marketing"
        )
        kursus = arrayOf(
            3, 3, 5, 2, 3
        )

        //Arrays of Kursus
        titleKur = arrayOf(
            "Junior Desain Grafis",
            "Pengenalan UI/UX",
            "101 Web Tech",
            "Keuangan",
            "Marketing Online"
        )
        harga = arrayOf(
            0, 0, 0, 0, 0
        )
        modul = arrayOf(
            5, 2, 3, 3, 4
        )
        rating = arrayOf(
            5.0, 4.4, 4.5, 4.3, 4.8
        )

        //Arrays of Modul
        titleMod = arrayOf(
            "Pengenalan",
            "Instalasi",
            "Projek Pertama"
        )
        durasi = arrayOf(
            20, 60, 120
        )

        kategoriArrayList = arrayListOf<KategoriModel>()
        kursusArrayList = arrayListOf<KursusModel>()
        modulArrayList = arrayListOf<ModulModel>()

        for (i in titleKat.indices) {
            val kat = KategoriModel (titleKat[i], kursus[i])
            kategoriArrayList.add(kat)
        }
        for (i in titleKur.indices) {
            val kur = KursusModel (titleKat[i], harga[i], modul[i], rating[i])
            kursusArrayList.add(kur)
        }
        for (i in titleMod.indices) {
            val mod = ModulModel (titleMod[i], durasi[i])
            modulArrayList.add(mod)
        }
    }
}