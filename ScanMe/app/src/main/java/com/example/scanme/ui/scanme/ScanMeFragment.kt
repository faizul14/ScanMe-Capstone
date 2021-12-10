package com.example.scanme.ui.scanme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scanme.R
import com.example.scanme.databinding.FragmentScanmeBinding
import com.example.scanme.ui.scanmeaction.ScanMeActionActivity

class ScanMeFragment : Fragment(), View.OnClickListener {

    private lateinit var dashboardViewModel: ScanMeViewModel
    private var _binding: FragmentScanmeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(ScanMeViewModel::class.java)

        _binding = FragmentScanmeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnBtnGoscan.setOnClickListener(this)

//        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_btn_goscan ->{
                val move = Intent(context, ScanMeActionActivity::class.java )
                startActivity(move)
            }
        }
    }
}