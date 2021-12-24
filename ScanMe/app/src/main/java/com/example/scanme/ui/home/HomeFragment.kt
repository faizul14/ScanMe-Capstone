package com.example.scanme.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scanme.R
import com.example.scanme.data.datadummy.DataDumy
import com.example.scanme.databinding.FragmentHomeBinding
import com.example.scanme.ui.artikel.ArtikelDetailActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })

        binding.cardView2.setOnClickListener{
            val bundle = Bundle()
            val conntent = DataDumy.mdataArtikel()[0].contentArtikel
            val title = DataDumy.mdataArtikel()[0].jdudulArtikel

            bundle.putString("cocntent", conntent)
            bundle.putString("title", title)
            val move = Intent (context, ArtikelDetailActivity::class.java)
            move.putExtras(bundle)
            startActivity(move)
        }

        binding.cardView3.setOnClickListener{
            val bundle = Bundle()
            val conntent = DataDumy.mdataArtikel()[1].contentArtikel
            val title = DataDumy.mdataArtikel()[1].jdudulArtikel

            bundle.putString("cocntent", conntent)
            bundle.putString("title", title)
            val move = Intent (context, ArtikelDetailActivity::class.java)
            move.putExtras(bundle)
            startActivity(move)
        }

        binding.cardView4.setOnClickListener{
            val bundle = Bundle()
            val conntent = DataDumy.mdataArtikel()[2].contentArtikel
            val title = DataDumy.mdataArtikel()[2].jdudulArtikel

            bundle.putString("cocntent", conntent)
            bundle.putString("title", title)
            val move = Intent (context, ArtikelDetailActivity::class.java)
            move.putExtras(bundle)
            startActivity(move)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}