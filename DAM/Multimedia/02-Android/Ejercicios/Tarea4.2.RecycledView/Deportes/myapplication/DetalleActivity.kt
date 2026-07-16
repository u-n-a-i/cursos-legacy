package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val tvNombre = findViewById<TextView>(R.id.tvNombreDetalle)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcionDetalle)

        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("descripcion")

        tvNombre.text = nombre
        tvDescripcion.text = descripcion
    }
}
