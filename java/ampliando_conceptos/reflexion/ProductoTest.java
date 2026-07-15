package ampliando_conceptos.reflexion;

import java.lang.reflect.*;

public class ProductoTest {
    public static void main(String[] args) throws Exception {
        Producto prod = new Producto("Laptop", 1200.50);
        Field[] campos = prod.getClass().getDeclaredFields(); // Obtener todos los atributos

        for (Field campo : campos) {
            if (campo.isAnnotationPresent(Metadata.class)) {
                Metadata meta = campo.getAnnotation(Metadata.class);
                campo.setAccessible(true); // Permitir acceso a atributos privados
                System.out.println("Campo: " + campo.getName() + " - " + meta.descripcion());
                System.out.println("Valor: " + campo.get(prod));
            }
        }
    }
}
