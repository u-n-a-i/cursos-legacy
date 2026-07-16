package com.example.ejercicio3;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Contacto {
    private String nombre;
    private String email;
    private String telefono;

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public static void guardarContactosEnXML(List<Contacto> contactos, String rutaArchivo) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element agendaElement = doc.createElement("agenda");
            doc.appendChild(agendaElement);

            for (Contacto contacto : contactos) {
                Element personaElement = doc.createElement("persona");
                agendaElement.appendChild(personaElement);

                Element nombreElement = doc.createElement("nombre");
                nombreElement.setTextContent(contacto.getNombre());
                personaElement.appendChild(nombreElement);

                Element emailElement = doc.createElement("email");
                emailElement.setTextContent(contacto.getEmail());
                personaElement.appendChild(emailElement);

                Element telefonoElement = doc.createElement("telefono");
                telefonoElement.setTextContent(contacto.getTelefono());
                personaElement.appendChild(telefonoElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

            System.out.println("Archivo generado correctamente en: " + rutaArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Juan Pérez", "juan.perez@email.com", "555-1234"));
        contactos.add(new Contacto("María López", "maria.lopez@email.com", "555-5678"));

        guardarContactosEnXML(contactos, "contactos.xml");
    }
}
