package com.example.scanme.ui.scanmeaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.scanme.R
import com.example.scanme.databinding.ActivityScanMeActionBinding
import com.example.scanme.ui.resultScanMe.DetailScanMe

class ScanMeActionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityScanMeActionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_me_action)

        binding = ActivityScanMeActionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanAction.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_scan_action->{
                var move = Intent (this,DetailScanMe::class.java)
                startActivity(move)
            }
        }
    }
}