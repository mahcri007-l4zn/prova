package com.example.sensoresemedia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MediaActivity : Activity() {

    private lateinit var nota1: EditText
    private lateinit var nota2: EditText
    private lateinit var nota3: EditText
    private lateinit var nota4: EditText

    private lateinit var btnCalcular: Button
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_media)

        nota1 = findViewById(R.id.nota1)
        nota2 = findViewById(R.id.nota2)
        nota3 = findViewById(R.id.nota3)
        nota4 = findViewById(R.id.nota4)

        btnCalcular = findViewById(R.id.btnCalcular)
        resultado = findViewById(R.id.resultado)

        btnCalcular.setOnClickListener {
            calcularMedia()
        }

        val btnAcelerometro = findViewById<Button>(R.id.btnAcelerometro)
        val btntoque = findViewById<Button>(R.id.btnToque)

        btntoque.setOnClickListener {
            startActivity(Intent(this, ToqueActivity::class.java))
        }

        btnAcelerometro.setOnClickListener {
            startActivity(Intent(this, AcelerometroActivity::class.java))
        }
    }



    private fun calcularMedia() {

        val n1 = nota1.text.toString().replace(',', '.').toDoubleOrNull()
        val n2 = nota2.text.toString().replace(',', '.').toDoubleOrNull()
        val n3 = nota3.text.toString().replace(',', '.').toDoubleOrNull()
        val n4 = nota4.text.toString().replace(',', '.').toDoubleOrNull()

        if (n1 == null || n2 == null || n3 == null || n4 == null) {

            Toast.makeText(
                this,
                "Preencha as 4 notas",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val media = (n1 + n2 + n3 + n4) / 4

        resultado.text = "A média é %.2f".format(media)
    }

}