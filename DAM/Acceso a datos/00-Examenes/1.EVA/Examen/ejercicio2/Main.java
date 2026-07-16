package com.example.ejercicio2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void leerLibrosDesdeXML(String rutaFichero) {
        try {
            JAXBContext contexto = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(new File(rutaFichero));

            for (Libro libro : biblioteca.getLibro()) {
                if ("Ficción".equalsIgnoreCase(libro.getGenero())) {
                    System.out.println(libro.getTitulo());
                }
            }
        } catch (JAXBException e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        leerLibrosDesdeXML("libros.xml");
    }
}
