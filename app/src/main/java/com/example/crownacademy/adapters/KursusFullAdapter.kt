package com.example.crownacademy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.databinding.KursusFullItemLayoutBinding
import com.example.crownacademy.models.KursusModel

class KursusFullAdapter (val onClick : (KursusModel) -> Unit, val kursusList : ArrayList<KursusModel>) : RecyclerView.Adapter<KursusFullAdapter.KursusFullViewHolder>() {
    inner class KursusFullViewHolder (val binding : KursusFullItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: KursusModel) {
            binding.apply {
                tvModul.text = "${item.modul} Modul"
                tvTitle.text = item.title
                tvRating.text = "${item.rating} Rating"
                if(item.harga > 0){
                    tvHarga.text = "$${item.harga}"
                }else{
                    tvHarga.text = "Gratis"
                }
                root.setOnClickListener {
                    onClick(item)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KursusFullViewHolder {
        val binding = KursusFullItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KursusFullViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return kursusList.count()
    }

    override fun onBindViewHolder(holder: KursusFullViewHolder, position: Int) {
        holder.bind(kursusList[position])
    }
}