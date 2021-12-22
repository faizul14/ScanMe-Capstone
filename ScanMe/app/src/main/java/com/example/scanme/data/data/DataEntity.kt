package com.example.scanme.data.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var identitas : String,
    var content : String,
    var bobot : Double
) : Parcelable
