package com.example.scanme.ui.riwayat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scanme.databinding.FragmentRiwayatBinding
import com.example.scanme.helper.ViewModelFactory

class RiwayatFragment : Fragment() {

    private lateinit var notificationsViewModel: RiwayatViewModel
    private var _binding: FragmentRiwayatBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        notificationsViewModel = ViewModelProvider(this).get(RiwayatViewModel::class.java)
        notificationsViewModel = obtainViewModel(this)

        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val riwayatAdapter = AdapterRiwayat()
        notificationsViewModel.getAllNotes().observe(viewLifecycleOwner, Observer{data->
            if (data != null){
                riwayatAdapter.setData(data)
            }
        })
        val rvRiwayat : RecyclerView = binding.rvRiwayat
        rvRiwayat.setHasFixedSize(true)
        rvRiwayat.layoutManager = LinearLayoutManager (context)
        rvRiwayat.adapter = riwayatAdapter

        return root
    }

    private fun obtainViewModel(fragment: RiwayatFragment): RiwayatViewModel {
        val factory = ViewModelFactory.getInstance(requireActivity().application)
        return ViewModelProvider(fragment, factory).get(RiwayatViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}