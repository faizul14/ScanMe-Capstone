package com.example.scanme.ui.resultScanMe

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.scanme.R

class DetailScanMe : AppCompatActivity() {

    companion object{
        const val SCAN_NUM = "extra"
        const val SCAN_STATUS = "extra"
    }

    private lateinit var mscanStatus : String
    private lateinit var scanNum : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_scan_me)

        val scanStatus : TextView = findViewById(R.id.status_scan)
        val scanRange : TextView = findViewById(R.id.range_scan)
        val bundle = intent.extras
        scanNum = bundle!!.getString("hasilNumScan").toString()
        mscanStatus = bundle!!.getString("hasilScan").toString()

        val imghapy : ImageView = findViewById(R.id.img_hapy)
        val imgsad : ImageView = findViewById(R.id.img_sad)

        if (mscanStatus.equals("true")){
            scanStatus.text = "ANDA BAIK-BAIK SAJA"
            imghapy.visibility = View.VISIBLE
            imgsad.visibility = View.GONE

        }else{
            scanStatus.text = "ANDA MEMPUNYAI GEJALA KESEHATAN MENTAL"
            imgsad.visibility = View.VISIBLE
            imghapy.visibility = View.GONE
        }
        scanRange.text = "$scanNum %"
    }
}