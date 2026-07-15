package ampliando_conceptos.record;

/*
Un record es una clase especial que se utiliza para crear objetos que son principalmente contenedores de datos.
Los records son inmutables por defecto, lo que significa que una vez que se crea un objeto record,
su estado no puede ser modificado.
 */
public record Producto(String nombre, double precio, String categoria) {
    // Constructor compacto (sin la lista de parámetros)
    public Producto {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        categoria = categoria == null ? "General" : categoria.trim(); // Valor por defecto y trim
    }

    // Método adicional para aplicar un descuento
    public double precioConDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        }
        double descuento = precio * (porcentajeDescuento / 100);
        return precio - descuento;
    }
}
