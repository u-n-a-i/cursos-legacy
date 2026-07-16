package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImagenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)

        val imageView = findViewById<ImageView>(R.id.imageViewAnimal)

        // Recuperar el nombre de la imagen pasada desde MainActivity
        val nombreImagen = intent.getStringExtra("imagen")

        // Obtener el id del recurso drawable usando su nombre
        val idImagen = resources.getIdentifier(nombreImagen, "drawable", packageName)

        // Mostrar la imagen
        imageView.setImageResource(idImagen)
    }
}
