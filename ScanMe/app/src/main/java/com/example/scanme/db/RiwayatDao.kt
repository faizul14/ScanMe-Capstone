package com.example.scanme.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RiwayatDao  {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Riwayat)

    @Query("SELECT * FROM riwayat")
    fun getAllNotes(): LiveData<List<Riwayat>>
}