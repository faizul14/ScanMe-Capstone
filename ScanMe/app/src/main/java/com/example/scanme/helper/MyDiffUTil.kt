package com.example.scanme.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.scanme.data.data.DataEntity

class MyDiffUTil(
    private val mOldFavoriteList : ArrayList<DataEntity>, private val newFavoriteList : ArrayList<DataEntity>
    ) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        if (mOldFavoriteList == null){
            return 0
        }else {
            return mOldFavoriteList.size
        }
    }

    override fun getNewListSize(): Int {
        if (newFavoriteList == null){
            return 0
        }else {
            return newFavoriteList.size
        }
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFavoriteList[oldItemPosition].content == newFavoriteList[newItemPosition].content
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmploye = mOldFavoriteList[oldItemPosition]
        val newEmploye = newFavoriteList[newItemPosition]
        return oldEmploye.identitas == newEmploye.identitas && oldEmploye.content == newEmploye.content && oldEmploye.bobot == newEmploye.bobot
    }

}