package com.example.sensoresemedia

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView

class ToqueActivity : Activity() {

    private lateinit var tvPosicao: TextView
    private lateinit var tvEstado: TextView
    private lateinit var bolinha: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_toque)

        tvPosicao = findViewById(R.id.tvPosicao)
        tvEstado = findViewById(R.id.tvEstado)
        bolinha = findViewById(R.id.bolinha)

        val tela = findViewById<FrameLayout>(R.id.telaToque)

        val btnAcelerometro = findViewById<Button>(R.id.btnAcelerometro)
        val btnMedia = findViewById<Button>(R.id.btnMedia)

        btnMedia.setOnClickListener {
            startActivity(Intent(this, MediaActivity::class.java))
        }

        btnAcelerometro.setOnClickListener {
            startActivity(Intent(this, AcelerometroActivity::class.java))
        }

        tela.setOnTouchListener { _, event ->

            when (event.action) {

                MotionEvent.ACTION_DOWN,
                MotionEvent.ACTION_MOVE -> {

                    // Posiciona a bolinha onde o dedo está
                    bolinha.x = event.x - bolinha.width / 2
                    bolinha.y = event.y - bolinha.height / 2

                    bolinha.visibility = View.VISIBLE

                    // Mostra a posição X e Y
                    tvPosicao.text =
                        "X: %.0f   Y: %.0f".format(event.x, event.y)

                    tvEstado.text = "Tocando"
                }

                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL -> {

                    bolinha.visibility = View.INVISIBLE

                    tvEstado.text = "Soltou"
                }
            }

            true
        }

    }
}