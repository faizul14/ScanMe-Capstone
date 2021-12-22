package com.example.scanme.ui.scanmeaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scanme.data.data.DataEntity
import com.example.scanme.databinding.ItemScanAfterChoseBinding
import com.example.scanme.databinding.ItemScanBeforeChoseBinding

class AdapterScanMeAfterAction:RecyclerView.Adapter<AdapterScanMeAfterAction.IndikasiViewHolder>() {
    private val listAfterIndikasi = ArrayList<DataEntity>()

    fun setData(data : List<DataEntity>){
        if (data != null){
            listAfterIndikasi.clear()
            listAfterIndikasi.addAll(data)
        }
    }

    class IndikasiViewHolder(private val binding: ItemScanAfterChoseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun data ( dataIndikasi : DataEntity){
            binding.contentAfterScan.text = dataIndikasi.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndikasiViewHolder {
        val items = ItemScanAfterChoseBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return AdapterScanMeAfterAction.IndikasiViewHolder(items)
    }

    override fun onBindViewHolder(holder: IndikasiViewHolder, position: Int) {
        holder.data(listAfterIndikasi[position])
    }

    override fun getItemCount(): Int = listAfterIndikasi.size
}