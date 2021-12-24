package com.example.scanme.ui.artikel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.scanme.R

class ArtikelDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel_detail)

        val content : TextView = findViewById(R.id.content_artikel)
        val title : TextView = findViewById(R.id.title_artikel)
        val bundle = intent.extras
        content.setText(bundle!!.getString("cocntent"))
        title.setText(bundle!!.getString("title"))
    }
}