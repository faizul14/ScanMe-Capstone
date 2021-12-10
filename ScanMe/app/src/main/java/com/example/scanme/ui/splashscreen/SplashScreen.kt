package com.example.scanme.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.scanme.R
import com.example.scanme.ui.welcome.WelcomeActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        },1500)

    }
}