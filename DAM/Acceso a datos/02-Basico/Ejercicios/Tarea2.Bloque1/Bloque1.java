import java.io.File;
import java.io.IOException;

public class Bloque1 {

    public static void main(String[] args) {

        // 1. Crea un directorio llamado "dam-accesodatos"
        File directorio = new File("dam-accesodatos");
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("1. Directorio 'dam-accesodatos' creado correctamente.");
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        } else {
            System.out.println("El directorio 'dam-accesodatos' ya existe.");
        }

        // 2. Crea un fichero llamado "ejercicio1" dentro del directorio
        File ejercicio1 = new File(directorio, "ejercicio1");
        try {
            if (ejercicio1.createNewFile()) {
                System.out.println("2. Fichero 'ejercicio1' creado correctamente.");
            } else {
                System.out.println("El fichero 'ejercicio1' ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero 'ejercicio1': " + e.getMessage());
        }

        // 3. Muestra por pantalla la longitud del fichero "ejercicio1"
        System.out.println("3. Longitud del fichero 'ejercicio1': " + ejercicio1.length() + " bytes.");

        // 4. Crea un fichero llamado "ejercicio2" dentro del directorio
        File ejercicio2 = new File(directorio, "ejercicio2");
        try {
            if (ejercicio2.createNewFile()) {
                System.out.println("4. Fichero 'ejercicio2' creado correctamente.");
            } else {
                System.out.println("El fichero 'ejercicio2' ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero 'ejercicio2': " + e.getMessage());
        }

        // 5. Muestra todos los ficheros del directorio
        System.out.println("5. Contenido del directorio 'dam-accesodatos':");
        listarArchivos(directorio);

        // 6. Elimina el fichero llamado "ejercicio1"
        if (ejercicio1.exists() && ejercicio1.delete()) {
            System.out.println("6. Fichero 'ejercicio1' eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar 'ejercicio1'.");
        }

        // 7. Muestra de nuevo todos los ficheros del directorio
        System.out.println("7. Contenido actual del directorio:");
        listarArchivos(directorio);

        // 8. Elimina nuevamente el fichero llamado "ejercicio1"
        if (ejercicio1.exists()) {
            if (ejercicio1.delete()) {
                System.out.println("8. Fichero 'ejercicio1' eliminado nuevamente.");
            } else {
                System.out.println("Error al eliminar 'ejercicio1'.");
            }
        } else {
            System.out.println("8. El fichero 'ejercicio1' no existe (ya fue eliminado).");
        }

        // 9. Borra directorio sin ficheros en su interior
        if (directorio.exists()) {
            if (directorio.delete()) {
                System.out.println("9. Directorio 'dam-accesodatos' eliminado (vacío).");
            } else {
                System.out.println(
                        "9. No se pudo eliminar porque contiene ficheros. (Intentaremos con función recursiva)");
            }
        }

        // 10. Borra directorio con ficheros en su interior (función recursiva)
        if (directorio.exists()) {
            borrarDirectorio(directorio);
            System.out.println("10. Directorio 'dam-accesodatos' borrado recursivamente.");
        }
    }

    // Muestra todos los ficheros de un directorio
    private static void listarArchivos(File dir) {
        String[] archivos = dir.list();
        if (archivos != null && archivos.length > 0) {
            for (String nombre : archivos) {
                System.out.println("   - " + nombre);
            }
        } else {
            System.out.println("   (vacío)");
        }
    }

    // 10. Función recursiva para eliminar un directorio con ficheros dentro
    public static void borrarDirectorio(File directorio) {
        if (directorio.exists()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    if (f.isDirectory()) {
                        borrarDirectorio(f); // llamada recursiva
                    } else {
                        f.delete();
                    }
                }
            }
            directorio.delete(); // finalmente elimina el directorio vacío
        }
    }
}
