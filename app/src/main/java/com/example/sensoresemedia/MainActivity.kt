package com.example.sensoresemedia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnAcelerometro = findViewById<Button>(R.id.btnAcelerometro)
        val btnToque = findViewById<Button>(R.id.btnToque)
        val btnMedia = findViewById<Button>(R.id.btnMedia)

        btnAcelerometro.setOnClickListener {
            startActivity(Intent(this, AcelerometroActivity::class.java))
        }

        btnToque.setOnClickListener {
            startActivity(Intent(this, ToqueActivity::class.java))
        }

        btnMedia.setOnClickListener {
            startActivity(Intent(this, MediaActivity::class.java))
        }
    }
}