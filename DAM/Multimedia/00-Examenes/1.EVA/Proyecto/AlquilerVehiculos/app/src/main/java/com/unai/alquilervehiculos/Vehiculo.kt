package com.unai.alquilervehiculos

data class Vehiculo(
    val id: Int,
    val categoria: String,
    val marca: String,
    val modelo: String,
    val matricula: String,
    val imagenResId: Int // Referencia a drawable
)
