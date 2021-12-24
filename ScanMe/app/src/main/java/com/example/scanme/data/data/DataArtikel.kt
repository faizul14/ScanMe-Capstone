package com.example.scanme.data.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataArtikel(
    var jdudulArtikel : String,
    var contentArtikel : String
) : Parcelable
