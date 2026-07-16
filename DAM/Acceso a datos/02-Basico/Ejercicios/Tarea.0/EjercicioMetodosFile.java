import java.io.File;
import java.io.IOException;

public class EjercicioMetodosFile {

    public static void main(String[] args) {

        // Crear directorio
        File dir = new File("ficheros");

        // crear si no existe
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directorio 'ficheros' creado correctamente.");
            }
        }

        // Crear fichero
        File archivo = new File(dir, "prueba.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Fichero 'prueba.txt' creado correctamente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Pruebas varios métodos

        System.out.println("\n--- Propiedades del archivo ---");

        System.out.println("exists(): " + archivo.exists());
        System.out.println("isFile(): " + archivo.isFile());
        System.out.println("isDirectory(): " + archivo.isDirectory());
        System.out.println("isHidden(): " + archivo.isHidden());

        System.out.println("getPath(): " + archivo.getPath());
        System.out.println("getAbsolutePath(): " + archivo.getAbsolutePath());
        System.out.println("getName(): " + archivo.getName());
        System.out.println("getParent(): " + archivo.getParent());

        System.out.println("canRead(): " + archivo.canRead());
        System.out.println("canWrite(): " + archivo.canWrite());
        System.out.println("canExecute(): " + archivo.canExecute());

        // list() y listFiles()

        System.out.println("\n--- Contenido del directorio 'ficheros' ---");

        String[] nombres = dir.list(); // devuelve los nombres (String)
        if (nombres != null) {
            for (String n : nombres) {
                System.out.println("list(): " + n);
            }
        }

        File[] archivos = dir.listFiles(); // devuelve objetos File
        if (archivos != null) {
            for (File f : archivos) {
                System.out.println("listFiles(): " + f.getName() + " (es fichero: " + f.isFile() + ")");
            }
        }

        // renameTo()

        File nuevoNombre = new File(dir, "renombrado.txt");
        if (archivo.renameTo(nuevoNombre)) {
            System.out.println("\nEl fichero fue renombrado a: " + nuevoNombre.getName());
        }

        // delete()

        if (nuevoNombre.delete()) {
            System.out.println("El fichero 'renombrado.txt' fue eliminado correctamente.");
        }

        // borrar el directorio
        if (dir.delete()) {
            System.out.println("El directorio 'ficheros' fue eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el directorio (puede que no esté vacío).");
        }
    }
}
