package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // lateinit parecido a la aserción definitiva(!) de TS
    // Confía que lo inicializare más tarde
    private lateinit var etKm: EditText;
    private lateinit var etMillas: EditText;
    private lateinit var btnKmAMillas: Button;
    private lateinit var btnMillasAKm: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Recuperar elementos
        etKm = findViewById(R.id.etKm);
        etMillas = findViewById(R.id.etMillas);
        btnKmAMillas = findViewById(R.id.btnKmAMillas);
        btnMillasAKm = findViewById(R.id.btnMillasAKm);

        // Eventos
        btnKmAMillas.setOnClickListener {
            val km = etKm.text.toString();
            if (km.isEmpty()){
                Toast.makeText(this, getString(R.string.toast_enter_km), Toast.LENGTH_SHORT).show()
            } else {
                val millas = km.toDouble() * 0.621371
                etMillas.setText(String.format("%.2f", millas))
            }
        }

        btnMillasAKm.setOnClickListener {
            val millas = etMillas.text.toString()
            if (millas.isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_enter_miles), Toast.LENGTH_SHORT).show()
            } else {
                val km = millas.toDouble() / 0.621371
                etKm.setText(String.format("%.2f", km))
            }
        }


        /* sirve para adaptar el layout a los bordes seguros del sistema
        barra de estado, navegación, gestos, etc.
        No es necesario para este ejercicios
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
    }
}