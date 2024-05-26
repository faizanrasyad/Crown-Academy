package com.example.crownacademy.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.provider.CalendarContract.Colors
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.R
import com.example.crownacademy.databinding.KategoriItemLayoutBinding
import com.example.crownacademy.models.KategoriModel

class KategoriAdapter (val onClick : (KategoriModel) -> Unit, val kategoriList : ArrayList<KategoriModel>) : RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {
    inner class KategoriViewHolder (val binding : KategoriItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(kategoriModel: KategoriModel) {
            binding.apply {
                tvTitle.text = kategoriModel.title
                tvKursus.text = "${kategoriModel.kursus} Kursus"
                val card : CardView = cardView
                root.setOnClickListener {
                    onClick(kategoriModel)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val binding = KategoriItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  KategoriViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return kategoriList.count()
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        holder.bind(kategoriList[position])
    }
}