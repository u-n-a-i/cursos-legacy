import java.io.*;

public class Main {

    // Método para guardar un objeto de tipo Persona en un fichero
    public static void guardarObjeto(Persona persona, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(persona);
            System.out.println("Objeto guardado correctamente en " + filename);
        } catch (IOException e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }

    // Método para recuperar un objeto de tipo Persona de un fichero
    public static Persona recuperarObjeto(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Persona) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar el objeto: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // 1.a. Creamos el objeto Persona
        Persona persona = new Persona(1, "Ana", 30, "12345678Z");

        // Guardamos el objeto Persona en un fichero
        guardarObjeto(persona, "persona1.dat");

        // 1.b. Recuperamos el objeto Persona del fichero
        Persona recuperada = recuperarObjeto("persona1.dat");
        System.out.println("Objeto recuperado: " + recuperada);

        // 1.c. Modificamos sus propiedades y volvemos a guardarlo
        if (recuperada != null) {
            recuperada.setEdad(29);
            recuperada.setNombre("Anna");
            guardarObjeto(recuperada, "persona1.dat");
            System.out.println("Objeto modificado y guardado nuevamente.");
        }

        // Recuperamos de nuevo el objeto Persona del fichero para ver los cambios
        Persona modificada = recuperarObjeto("persona1.dat");
        System.out.println("Objeto modificado recuperado: " + modificada);

        // 2.a. Crear un fichero de texto utilizando FileWriter
        try (FileWriter fw = new FileWriter("texto_prueba.txt")) {
            fw.write(
                    "Esto es un texto de prueba...");
            System.out.println("Fichero de texto creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el fichero de texto: " + e.getMessage());
        }

        // 3.a. Leer un fichero de tipo imagen(binario) y mostrar su contenido por
        // pantalla
        // La img la tengo en la raíz principal en una carpeta img
        try (FileInputStream fis = new FileInputStream("img/gato.jpg")) {
            byte[] datos = fis.readAllBytes();
            System.out.println("Contenido de la imagen (bytes):");
            // Limitar para no destrozar la consola.
            for (int i = 0; i < Math.min(datos.length, 100); i++) {
                System.out.print(datos[i] + " ");
            }
            System.out.println("\n¿Se puede leer de forma correcta? Sí, aunque no se interpreta como imagen visual.");
        } catch (IOException e) {
            System.out.println("Error al leer la imagen: " + e.getMessage());
        }
    }
}
