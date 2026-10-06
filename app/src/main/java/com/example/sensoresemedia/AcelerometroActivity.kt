package com.example.sensoresemedia

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AcelerometroActivity : Activity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var acelerometro: Sensor? = null

    private lateinit var tvX: TextView
    private lateinit var tvY: TextView
    private lateinit var tvZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_acelerometro)

        tvX = findViewById(R.id.tvX)
        tvY = findViewById(R.id.tvY)
        tvZ = findViewById(R.id.tvZ)

        sensorManager =
            getSystemService(Context.SENSOR_SERVICE) as SensorManager

        acelerometro =
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (acelerometro == null) {
            tvX.text = "Acelerômetro não disponível"

        }
        val btnMedia = findViewById<Button>(R.id.btnMedia)
        val btnToque = findViewById<Button>(R.id.btnToque)

        btnToque.setOnClickListener {
            startActivity(Intent(this, ToqueActivity::class.java))
        }

        btnMedia.setOnClickListener {
            startActivity(Intent(this, MediaActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        acelerometro?.let {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_UI
            )
        }
    }

    override fun onPause() {
        super.onPause()

        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {

        tvX.text = "X (lados): %.2f".format(event.values[0])
        tvY.text = "Y (frente/trás): %.2f".format(event.values[1])
        tvZ.text = "Z (cima/baixo): %.2f".format(event.values[2])
    }

    override fun onAccuracyChanged(
        sensor: Sensor?,
        accuracy: Int
    ) {
    }
}