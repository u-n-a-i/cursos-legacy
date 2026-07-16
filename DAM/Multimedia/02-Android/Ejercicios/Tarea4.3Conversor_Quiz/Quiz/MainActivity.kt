package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declaramos las vistas
    private lateinit var tvNumeroPregunta: TextView
    private lateinit var tvPregunta: TextView
    private lateinit var grupoOpciones: RadioGroup
    private lateinit var opcion1: RadioButton
    private lateinit var opcion2: RadioButton
    private lateinit var opcion3: RadioButton
    private lateinit var opcion4: RadioButton
    private lateinit var btnSiguiente: Button

    // Variables de control del test
    private var indicePreguntaActual = 0
    private var respuestasCorrectas = 0

    // Lista de preguntas
    private val listaPreguntas = listOf(
        Pregunta("¿Cuál es la capital de Italia?",
            listOf("París", "Londres", "Roma", "Kabul"), 2),

        Pregunta("¿Cuál es la capital de Estonia?",
            listOf("Tallin", "San Petersburgo", "Berlín", "Copenhague"), 0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajusta el contenido a las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { vista, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            vista.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Asociamos las vistas con las variables
        tvNumeroPregunta = findViewById(R.id.tvNumeroPregunta)
        tvPregunta = findViewById(R.id.tvPregunta)
        grupoOpciones = findViewById(R.id.grupoOpciones)
        opcion1 = findViewById(R.id.opcion1)
        opcion2 = findViewById(R.id.opcion2)
        opcion3 = findViewById(R.id.opcion3)
        opcion4 = findViewById(R.id.opcion4)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        // Mostramos la primera pregunta
        mostrarPregunta()

        // Botón siguiente o comprobar
        btnSiguiente.setOnClickListener {
            comprobarRespuesta()
        }
    }

    private fun mostrarPregunta() {
        val pregunta = listaPreguntas[indicePreguntaActual]
        tvNumeroPregunta.text = "Pregunta ${indicePreguntaActual + 1}/${listaPreguntas.size}"
        tvPregunta.text = pregunta.texto
        opcion1.text = pregunta.opciones[0]
        opcion2.text = pregunta.opciones[1]
        opcion3.text = pregunta.opciones[2]
        opcion4.text = pregunta.opciones[3]
        grupoOpciones.clearCheck()
        btnSiguiente.text = if (indicePreguntaActual == listaPreguntas.size - 1)
            getString(R.string.comprobar)
        else
            getString(R.string.siguiente)
    }

    private fun comprobarRespuesta() {
        val idSeleccionado = grupoOpciones.checkedRadioButtonId
        if (idSeleccionado == -1) {
            Toast.makeText(this, getString(R.string.selecciona_opcion), Toast.LENGTH_SHORT).show()
            return
        }

        val indiceSeleccionado = when (idSeleccionado) {
            R.id.opcion1 -> 0
            R.id.opcion2 -> 1
            R.id.opcion3 -> 2
            else -> 3
        }

        if (indiceSeleccionado == listaPreguntas[indicePreguntaActual].indiceCorrecto) {
            respuestasCorrectas++
        }

        indicePreguntaActual++

        if (indicePreguntaActual < listaPreguntas.size) {
            mostrarPregunta()
        } else {
            mostrarResultados()
        }
    }

    private fun mostrarResultados() {
        val incorrectas = listaPreguntas.size - respuestasCorrectas
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.titulo_resultados))
            .setMessage("${getString(R.string.correctas)}: $respuestasCorrectas\n${getString(R.string.incorrectas)}: $incorrectas")
            .setPositiveButton("OK", null)
            .setNegativeButton(getString(R.string.reiniciar)) { _, _ ->
                indicePreguntaActual = 0
                respuestasCorrectas = 0
                mostrarPregunta()
            }
            .show()
    }

    data class Pregunta(
        val texto: String,
        val opciones: List<String>,
        val indiceCorrecto: Int
    )
}