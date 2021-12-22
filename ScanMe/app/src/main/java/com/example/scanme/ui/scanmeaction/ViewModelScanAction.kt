package com.example.scanme.ui.scanmeaction

import androidx.lifecycle.ViewModel
import com.example.scanme.data.data.DataEntity
import com.example.scanme.data.datadummy.DataDumy

class ViewModelScanAction : ViewModel() {
    fun getData () : List<DataEntity> = DataDumy.dummyDataIndikasi()
}