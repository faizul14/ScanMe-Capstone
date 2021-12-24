package com.example.scanme.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Riwayat::class],
    version = 1)
abstract class RiwayatRoomDatabase : RoomDatabase() {
    abstract fun riwayatDao(): RiwayatDao
    companion object {
        @Volatile
        private var INSTANCE: RiwayatRoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): RiwayatRoomDatabase {
            if (INSTANCE == null) {
                synchronized(RiwayatRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,RiwayatRoomDatabase::class.java, "riwayat_db")
                        .build()
                }
            }
            return INSTANCE as RiwayatRoomDatabase
        }
    }
}