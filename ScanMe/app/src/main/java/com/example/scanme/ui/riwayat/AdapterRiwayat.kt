package com.example.scanme.ui.riwayat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.scanme.data.data.DataEntity
import com.example.scanme.data.datadummy.DataDumy
import com.example.scanme.databinding.ItemHistoryBinding
import com.example.scanme.databinding.ItemScanBeforeChoseBinding
import com.example.scanme.db.Riwayat
import com.example.scanme.ui.scanmeaction.AdapterScanMeBeforeAction

class AdapterRiwayat:RecyclerView.Adapter<AdapterRiwayat.ContentViewHolder>() {

    private val listRiwayat = ArrayList<Riwayat>()
    fun setData(data : List<Riwayat>){
        if (data != null){
            listRiwayat.clear()
            listRiwayat.addAll(data)
        }
    }

    class ContentViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun data ( dataIndikasi : Riwayat){
            binding.riwayatStatusScan.text = dataIndikasi.statusscan

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val items = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return AdapterRiwayat.ContentViewHolder(items)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.data(listRiwayat[position])
    }

    override fun getItemCount(): Int = listRiwayat.size
}