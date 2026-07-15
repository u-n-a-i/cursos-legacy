package ampliando_conceptos.record;

public class ProductoTest {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop", 1200.50, "Electrónica");
        System.out.println("Producto 1: " + producto1);
        System.out.println("Precio con 10% de descuento: " + producto1.precioConDescuento(10));

        Producto producto2 = new Producto("Libro", 25.99, null);
        System.out.println("Producto 2: " + producto2); // La categoría será "General"

        // Intentando crear un producto con nombre inválido
        try {
            Producto producto3 = new Producto("  ", 50.0, "Ropa");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear producto 3: " + e.getMessage());
        }

        // Intentando crear un producto con precio inválido
        try {
            Producto producto4 = new Producto("Bolígrafo", -1.0, "Papelería");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear producto 4: " + e.getMessage());
        }
    }
}
