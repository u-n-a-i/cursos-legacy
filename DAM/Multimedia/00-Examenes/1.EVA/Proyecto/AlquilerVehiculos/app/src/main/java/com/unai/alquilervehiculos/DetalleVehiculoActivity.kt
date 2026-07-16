package com.unai.alquilervehiculos

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class DetalleVehiculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_vehiculo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val categoria = intent.getStringExtra("categoria") ?: ""
        val marca = intent.getStringExtra("marca") ?: ""
        val modelo = intent.getStringExtra("modelo") ?: ""
        val matricula = intent.getStringExtra("matricula") ?: ""
        val imagenResId = intent.getIntExtra("imagen_res_id", R.drawable.ic_launcher_foreground)

        findViewById<ImageView>(R.id.imageViewDetalle).setImageResource(imagenResId)
        findViewById<TextInputEditText>(R.id.editTextCategoria).setText(categoria)
        findViewById<TextInputEditText>(R.id.editTextMarca).setText(marca)
        findViewById<TextInputEditText>(R.id.editTextModelo).setText(modelo)
        findViewById<TextInputEditText>(R.id.editTextMatricula).setText(matricula)

        findViewById<Button>(R.id.buttonGuardar).setOnClickListener {
            Toast.makeText(this, getString(R.string.cambios_guardados_simulados), Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}