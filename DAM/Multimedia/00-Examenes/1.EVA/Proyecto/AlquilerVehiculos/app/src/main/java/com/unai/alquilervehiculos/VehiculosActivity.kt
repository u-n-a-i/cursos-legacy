package com.unai.alquilervehiculos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VehiculosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vehiculos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewVehiculos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Datos de ejemplo
        val vehiculos = listOf(
            Vehiculo(1, "Gasolina", "Porche", "964", "4587ZXQ", R.drawable.porche),
            Vehiculo(2, "Gasolina", "Ford Mustang", "1968", "789KJH", R.drawable.ford),
            Vehiculo(3, "Gasolina", "Mercedes", "300 SL Gullwing", "123ASD", R.drawable.mercedes),
            Vehiculo(4, "Electrico", "Renault", "E5 Tech", "2580MTT", R.drawable.renault),
            Vehiculo(5, "Electrico", "Opel", "Manta GSe ElektroMOD", "3580MKT", R.drawable.opel),
            Vehiculo(6, "Electrico", "Fiat", "500e", "3080LML", R.drawable.fiat),
        )

        val adapter = VehiculoAdapter(this, vehiculos) { vehiculo ->
            val intent = Intent(this, DetalleVehiculoActivity::class.java).apply {
                putExtra("vehiculo_id", vehiculo.id)
                putExtra("categoria", vehiculo.categoria)
                putExtra("marca", vehiculo.marca)
                putExtra("modelo", vehiculo.modelo)
                putExtra("matricula", vehiculo.matricula)
                putExtra("imagen_res_id", vehiculo.imagenResId)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}