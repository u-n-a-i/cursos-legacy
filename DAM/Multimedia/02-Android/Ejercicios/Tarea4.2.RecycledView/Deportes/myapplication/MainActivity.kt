package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Deporte

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listaDeportes = listOf(
            Deporte("Fútbol", "Deporte de equipo.", "El fútbol se juega en..."),
            Deporte("Baloncesto", "Se juega con una pelota y una canasta.", "El baloncesto se juega en..."),
            Deporte("Tenis", "Deporte de raqueta.", "El tenis se juega en una pista..."),
            Deporte("Natación", "Deporte acuático.", "La natación se practica en una piscina...")
        )

        val adapter = DeporteAdapter(listaDeportes) { deporte ->
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("nombre", deporte.nombre)
            intent.putExtra("descripcion", deporte.descripcionLarga)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
