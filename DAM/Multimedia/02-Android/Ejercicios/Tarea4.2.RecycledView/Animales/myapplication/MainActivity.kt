package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnGato).setOnClickListener { abrirImagen("gato") }
        findViewById<Button>(R.id.btnLeon).setOnClickListener { abrirImagen("leon") }
        findViewById<Button>(R.id.btnPerro).setOnClickListener { abrirImagen("perro") }
        findViewById<Button>(R.id.btnTigre).setOnClickListener { abrirImagen("tigre") }
    }

    private fun abrirImagen(nombre: String) {
        val intent = Intent(this, ImagenActivity::class.java)
        intent.putExtra("imagen", nombre)
        startActivity(intent)
    }
}

