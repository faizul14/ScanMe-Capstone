package com.example.scanme.ui.scanmeaction

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scanme.Repository.RiwayatRepository
import com.example.scanme.data.data.DataEntity
import com.example.scanme.data.datadummy.DataDumy
import com.example.scanme.db.Riwayat

class ViewModelScanAction (application : Application) : ViewModel() {

    private val mRiwayatRepository: RiwayatRepository = RiwayatRepository(application)

    fun insert(riwayat: Riwayat) {
        mRiwayatRepository.insert(riwayat)
    }

    fun getData () : List<DataEntity> = DataDumy.dummyDataIndikasi()

    private val dataAfterChose = MutableLiveData<ArrayList<DataEntity>>()
    private fun setDataAfter(){
        val  data = DataDumy.dummyDataAfterChose()
        dataAfterChose.value = data
    }
    fun getAfterChose () : LiveData<ArrayList<DataEntity>> = dataAfterChose


    var hasilScan : Double? = 0.0
    var statusScan : Boolean = false
    //true = sehat mental
    //false = sakit mental

    fun countIndikasi (m1 : DataEntity , m2 : DataEntity, m4 : DataEntity){
        if (m1.identitas == "O2" && m2.identitas == "O2"){
            val M1 = m1.bobot
            val M1SIGMA = 1 - m1.bobot
            val M2 = m2.bobot
            val M2SIGMA = 1 - m2.bobot
            val M4 = m4.bobot
            val M4SIGMA = 1 - m4.bobot

            val M3 = (M1 * M2) + (M1 * M2SIGMA) + (M1SIGMA * M2)
            val M3SIGMA = M1SIGMA * M2SIGMA

            if ( m4.identitas == "O2"){
                val M5= (M3 * M4) + (M3 * M4SIGMA) + (M3SIGMA * M4)
                val M5SIGMA = M3SIGMA * M4SIGMA

                hasilScan = M5 * 100
                statusScan = true
            }else{
                val M5= (M3 * M4) + (M3 * M4SIGMA) + (M3SIGMA * M4)
                val M5SIGMA = M3SIGMA * M4SIGMA

                val K = M3 * M4
                val M5O1 = (M3SIGMA * M4) / (1-K)
                val M5O2 = (M4SIGMA * M3) / (1-K)
                if (M5O1 > M5O2){
                    hasilScan = M5O1
                    statusScan = false
                }else{
                    hasilScan = M5O2
                    statusScan = true
                }

            }
        }else{
            val M1 = m1.bobot
            val M1SIGMA = 1 - m1.bobot
            val M2 = m2.bobot
            val M2SIGMA = 1 - m2.bobot
            val M4 = m4.bobot
            val M4SIGMA = 1 - m4.bobot

            if (m1.identitas == "02"){

                val K = M1 * M2
                val M3O1 = (M1SIGMA * M2) / (1-K)
                val M3O2 = (M2SIGMA * M1) / (1-K)
                val M3SIGMA = 1 - (M3O1 + M3O2)
                if (M3O1 > M3O2){
                   hasilScan = M3O1
                    statusScan = false
                }else{
                    hasilScan = M3O2
                    statusScan = true
                }
            }else{
                val K = M1 * M2
                val M3O1 = (M2SIGMA * M1) / (1-K)
                val M3O2 = (M1SIGMA * M2) / (1-K)
                val M3SIGMA = 1 - (M3O1 + M3O2)
                if (M3O1 > M3O2){
                    hasilScan = M3O1
                    statusScan = false
                }else{
                    hasilScan = M3O2
                    statusScan = true
                }
            }

        }

    }

    init {
        setDataAfter()
    }
}