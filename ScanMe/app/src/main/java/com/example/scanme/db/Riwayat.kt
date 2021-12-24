package com.example.scanme.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
class Riwayat(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "statusscan")
    var statusscan: String? = null,

    @ColumnInfo(name = "statusnum")
    var statusnum: Double? = 0.0
) : Parcelable


