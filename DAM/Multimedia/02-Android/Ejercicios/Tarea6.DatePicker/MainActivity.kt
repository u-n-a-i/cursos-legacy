package com.unai.ejercicios

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editNum1: EditText
    private lateinit var editNum2: EditText
    private lateinit var spinnerOperacion: Spinner
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // recoger elementos de la vista
        editNum1 = findViewById(R.id.editNum1)
        editNum2 = findViewById(R.id.editNum2)
        spinnerOperacion = findViewById(R.id.spinnerOperacion)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        // configurar array adapter para el spinner con string-array
        ArrayAdapter.createFromResource(
            this,
            R.array.operaciones,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerOperacion.adapter = adapter
        }

        // llamar a la fun al hacer click
        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val num1Str = editNum1.text.toString().trim()
        val num2Str = editNum2.text.toString().trim()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            txtResultado.text = "Resultado: Completar ambos números"
            return
        }

        val num1 = num1Str.toDoubleOrNull()
        val num2 = num2Str.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            txtResultado.text = "Resultado: Números inválidos"
            return
        }

        val operacion = spinnerOperacion.selectedItem.toString()
        var resultado: Double? = null

        when (operacion) {
            "sumar" -> resultado = num1 + num2
            "restar" -> resultado = num1 - num2
            "multiplicar" -> resultado = num1 * num2
            "dividir" -> {
                if (num2 == 0.0) {
                    txtResultado.text = "Resultado: No se puede dividir por cero"
                    return
                }
                resultado = num1 / num2
            }
        }

        txtResultado.text = "Resultado: ${"%.2f".format(resultado ?: 0.0)}"
    }
}