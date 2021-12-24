package com.example.scanme.ui.scanmeaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.scanme.data.data.DataEntity
import com.example.scanme.data.datadummy.DataDumy
import com.example.scanme.databinding.ItemScanBeforeChoseBinding
import com.example.scanme.helper.MyDiffUTil

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


                itemView.setOnClickListener{
                    if (DataDumy.dummyDataAfterChose().size == 3){
                        Toast.makeText(itemView.context, "DATA IDIKASI SUDAH TERISI", Toast.LENGTH_SHORT).show()
                    }else{
                        var data = ArrayList<DataEntity>()
                        data.add(dataIndikasi)
                        DataDumy.setAfterChose(data)
                        Toast.makeText(itemView.context, "chose ${dataIndikasi.content}", Toast.LENGTH_SHORT).show()

                    }
                }

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