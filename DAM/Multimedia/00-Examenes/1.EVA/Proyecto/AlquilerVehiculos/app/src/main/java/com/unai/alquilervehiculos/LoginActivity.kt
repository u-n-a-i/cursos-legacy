package com.unai.alquilervehiculos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // BTN enlaces y campos para login
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val enlaceRegistro = findViewById<TextView>(R.id.enlaceRegistro)
        val usuario = findViewById<EditText>(R.id.etUsuario)
        val password = findViewById<EditText>(R.id.etPass)

        // Iniciar sesión
        btnLogin.setOnClickListener {
            val user = usuario.text.toString().trim()
            val pass = password.text.toString().trim()

            if (user == "admin" && pass == "admin") {
                val intent = Intent(this, VehiculosActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this, getString(R.string.error_login),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //Ir a registro
        enlaceRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}