package com.example.examen;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import java.io.File;

public class Ejercicio3 {

    public static void leerSuperheroesDesdeXML(String rutaFichero) {
        try {
            // Crear una instancia del parser DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document documento = builder.parse(new File(rutaFichero));
            documento.getDocumentElement().normalize();

            // Obtener todos los elementos <superheroe>
            NodeList listaSuperheroes = documento.getElementsByTagName("superheroe");

            System.out.println("Nombres de los superhéroes:");

            // Iterar sobre los elementos
            for (int i = 0; i < listaSuperheroes.getLength(); i++) {
                Node nodo = listaSuperheroes.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    System.out.println("- " + nombre);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        leerSuperheroesDesdeXML("superheroes.xml");
    }
}
