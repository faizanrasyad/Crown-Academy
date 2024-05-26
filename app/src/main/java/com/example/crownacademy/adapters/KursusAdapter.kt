package com.example.crownacademy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.databinding.KursusItemLayoutBinding
import com.example.crownacademy.models.KursusModel

class KursusAdapter (val onClick : (KursusModel) -> Unit, val kursusList : ArrayList<KursusModel>) : RecyclerView.Adapter<KursusAdapter.KursusViewHolder>() {
    inner class KursusViewHolder (val binding : KursusItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KursusViewHolder {
        val binding = KursusItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KursusViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return kursusList.count()
    }

    override fun onBindViewHolder(holder: KursusViewHolder, position: Int) {
        holder.bind(kursusList[position])
    }
}