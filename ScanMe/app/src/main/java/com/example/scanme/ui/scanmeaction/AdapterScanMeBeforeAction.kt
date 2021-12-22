package com.example.scanme.ui.scanmeaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.scanme.data.data.DataEntity
import com.example.scanme.databinding.ItemScanBeforeChoseBinding

class AdapterScanMeBeforeAction : RecyclerView.Adapter<AdapterScanMeBeforeAction.IndikasiViewHolder>() {
    private val listBeforeAction = ArrayList<DataEntity>()
    fun setData(data : List<DataEntity>){
        if (data != null){
            listBeforeAction.clear()
            listBeforeAction.addAll(data)
        }
    }

    class IndikasiViewHolder(private val binding: ItemScanBeforeChoseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun data ( dataIndikasi : DataEntity){
            binding.contentScan.text = dataIndikasi.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndikasiViewHolder {
        val items = ItemScanBeforeChoseBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return IndikasiViewHolder(items)
    }

    override fun onBindViewHolder(holder: IndikasiViewHolder, position: Int) {
        holder.data(listBeforeAction[position])
    }

    override fun getItemCount(): Int = listBeforeAction.size
}