package com.unai.alquilervehiculos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehiculoAdapter(
    private val context: Context,
    private val vehiculos: List<Vehiculo>,
    private val onItemClick: (Vehiculo) -> Unit
) : RecyclerView.Adapter<VehiculoAdapter.VehiculoViewHolder>() {

    class VehiculoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewVehiculo)
        val textViewMarcaModelo: TextView = view.findViewById(R.id.textViewMarcaModelo)
        val textViewMatricula: TextView = view.findViewById(R.id.textViewMatricula)
        val textViewCategoria: TextView = view.findViewById(R.id.textViewCategoria)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehiculo, parent, false)
        return VehiculoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehiculoViewHolder, position: Int) {
        val vehiculo = vehiculos[position]
        holder.textViewMarcaModelo.text = "${vehiculo.marca} ${vehiculo.modelo}"
        holder.textViewMatricula.text = vehiculo.matricula
        holder.textViewCategoria.text = vehiculo.categoria
        holder.imageView.setImageResource(vehiculo.imagenResId)

        holder.itemView.setOnClickListener {
            onItemClick(vehiculo)
        }
    }

    override fun getItemCount(): Int = vehiculos.size
}