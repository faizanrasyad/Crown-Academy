package com.example.crownacademy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crownacademy.databinding.ModulItemLayoutBinding
import com.example.crownacademy.models.ModulModel

class ModulAdapter (val onClick : (ModulModel) -> Unit, val modulList : ArrayList<ModulModel>) : RecyclerView.Adapter<ModulAdapter.ModulViewHolder>(){
    var urutan : Int = 1
    inner class ModulViewHolder (val binding : ModulItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ModulModel) {
            binding.apply {
                tvTitle.text = "Modul $urutan : ${item.title}"
                urutan++
                root.setOnClickListener {
                    onClick(item)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulViewHolder {
        val binding = ModulItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModulViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modulList.count()
    }

    override fun onBindViewHolder(holder: ModulViewHolder, position: Int) {
        holder.bind(modulList[position])
    }
}