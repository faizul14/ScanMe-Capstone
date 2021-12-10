package com.example.scanme.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.scanme.MainActivity
import com.example.scanme.R
import com.example.scanme.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var username : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_welcome)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        username = binding.edtUsername.text.toString()
        binding.btnWelcome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_welcome ->{
                Toast.makeText(this, "welcome $username di apk Scan Me", Toast.LENGTH_SHORT).show()
                var move = Intent (this, MainActivity::class.java)
                startActivity(move)
            }
        }
    }
}