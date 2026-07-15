package clases_integradas;

import java.io.File;
import java.io.IOException;

public class ClaseFile {
    public static void main(String[] args) {
        /*
        La clase File en Java (de java.io.File) se usa para trabajar con archivos y directorios: crearlos,
        eliminarlos, renombrarlos, verificar si existen, etc. No se usa para leer o escribir contenido directamente,
        solo para manipular los archivos como "objetos del sistema de archivos".
         */
        File archivo = new File("src\\clases_integradas\\archivo.txt");

        // Crear archivo y verificar si existe
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un archivo");
            e.printStackTrace();
        }

        // Ver información
        if (archivo.exists()) {
            System.out.println("Ruta: " + archivo.getAbsolutePath());
            System.out.println("Se puede escribir: " + archivo.canWrite());
            System.out.println("Se puede leer: " + archivo.canRead());
            System.out.println("Tamaño (bytes): " + archivo.length());
        }

        if (archivo.delete()) {
            System.out.println("Archivo eliminando");
        } else {
            System.out.println("No se pudo eliminar el archivo");
        }
    }
}
