package com.example.scanme.ui.riwayat

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scanme.Repository.RiwayatRepository
import com.example.scanme.db.Riwayat

class RiwayatViewModel(application: Application)  : ViewModel() {
    private val mRiwayatRepository: RiwayatRepository = RiwayatRepository(application)
    fun getAllNotes(): LiveData<List<Riwayat>> = mRiwayatRepository.getAllNotes()
}