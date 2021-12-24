package com.example.scanme.ui.scanmeaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scanme.R
import com.example.scanme.data.data.DataEntity
import com.example.scanme.data.datadummy.DataDumy
import com.example.scanme.databinding.ActivityScanMeActionBinding
import com.example.scanme.db.Riwayat
import com.example.scanme.helper.ViewModelFactory
import com.example.scanme.helper.ViewModelFactory.Companion.getInstance
import com.example.scanme.ui.resultScanMe.DetailScanMe

class ScanMeActionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanMeActionBinding
    private lateinit var viewModel: ViewModelScanAction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_me_action)
        binding = ActivityScanMeActionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = obtainViewModel(this)
        val data = viewModel.getData()
        val actionBeforeAdapter = AdapterScanMeBeforeAction()
        val actionAfterAdapter = AdapterScanMeAfterAction()
        actionBeforeAdapter.setData(data)

        val forDataScan = ArrayList<DataEntity>()
        val dataAfterObserver : Observer<ArrayList<DataEntity>> = Observer {data ->
            actionAfterAdapter.setData(data)
            forDataScan.addAll(data)
        }
        viewModel.getAfterChose().observe(this, dataAfterObserver)

        val rvBeforeChose : RecyclerView = findViewById(R.id.rv_before)
        val rvAfterChose : RecyclerView = findViewById(R.id.rv_after)
        rvBeforeChose.setHasFixedSize(true)
        rvAfterChose.setHasFixedSize(true)
        rvBeforeChose.layoutManager = LinearLayoutManager (this)
        rvAfterChose.layoutManager = LinearLayoutManager (this, LinearLayoutManager.HORIZONTAL,false)
        rvBeforeChose.adapter = actionBeforeAdapter
        rvAfterChose.adapter = actionAfterAdapter



        binding.btnScanAction.setOnClickListener{
            if (DataDumy.dummyDataAfterChose().size == 3) {
                viewModel.countIndikasi(forDataScan[0],forDataScan[1],forDataScan[2])
                var move = Intent (this,DetailScanMe::class.java)
                val riwayat = Riwayat()
                val bundle = Bundle()
                bundle.putString("hasilNumScan", viewModel.hasilScan.toString() )
                bundle.putString("hasilScan", viewModel.statusScan.toString() )
                riwayat.statusnum = viewModel.hasilScan
                riwayat.statusscan = viewModel.statusScan.toString()
                viewModel.insert(riwayat as Riwayat)
                move.putExtras(bundle)
                startActivity(move)
                DataDumy.dataAfterChose.clear()
            }else {
                Toast.makeText(this, "MAX 3 PILIHAN INDIKASI", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): ViewModelScanAction {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ViewModelScanAction::class.java)
    }
}