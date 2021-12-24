package com.example.scanme.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.scanme.db.Riwayat
import com.example.scanme.db.RiwayatDao
import com.example.scanme.db.RiwayatRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class RiwayatRepository(application : Application) {
    private val mNotesDao: RiwayatDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    init {
        val db = RiwayatRoomDatabase.getDatabase(application)
        mNotesDao = db.riwayatDao()
    }
    fun getAllNotes(): LiveData<List<Riwayat>> = mNotesDao.getAllNotes()
    fun insert(data: Riwayat) {
        executorService.execute { mNotesDao.insert(data) }
    }
}