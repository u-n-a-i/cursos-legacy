import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

public class ProcesarLibrosXML {

    public static void main(String[] args) throws Exception {
        // Cargar el documento desde la raíz principal
        File inputFile = new File("books.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList books = doc.getElementsByTagName("Book");

        // 1. Muestra por pantalla los diferentes id de cada libro utilizando la
        // librería DOM.
        System.out.println("1. IDs de los libros:");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            System.out.println("ID: " + book.getAttribute("id"));
        }

        // 2. Muestra por pantalla una lista de autores y los títulos de sus libros.
        System.out.println("\n2. Autores y títulos:");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            String author = book.getElementsByTagName("Author").item(0).getTextContent();
            String title = book.getElementsByTagName("Title").item(0).getTextContent();
            System.out.println(author + " - " + title);
        }

        // 3. Muestra por pantalla los títulos de los libros y sus precios. Ordena de
        // más económico a más caro.
        System.out.println("\n3. Títulos y precios ordenados:");
        List<Element> bookList = new ArrayList<>();
        for (int i = 0; i < books.getLength(); i++) {
            bookList.add((Element) books.item(i));
        }

        bookList.sort(Comparator
                .comparingDouble(b -> Double.parseDouble(b.getElementsByTagName("Price").item(0).getTextContent())));

        for (Element book : bookList) {
            String title = book.getElementsByTagName("Title").item(0).getTextContent();
            String price = book.getElementsByTagName("Price").item(0).getTextContent();
            System.out.println(title + " - $" + price);
        }

        // 4. Muestra los libros por su género
        System.out.println("\n4. Libros por género:");
        Map<String, List<String>> genreMap = new HashMap<>();
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            String genre = book.getElementsByTagName("Genre").item(0).getTextContent();
            String title = book.getElementsByTagName("Title").item(0).getTextContent();
            genreMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(title);
        }

        for (String genre : genreMap.keySet()) {
            System.out.println("Género: " + genre);
            for (String title : genreMap.get(genre)) {
                System.out.println("  - " + title);
            }
        }

        // 5. Traduce todas las etiquetas del XML y guardarlo en un fichero llamado
        // libros.xml
        System.out.println("\n5. Generando archivo libros.xml con etiquetas traducidas...");

        Document newDoc = builder.newDocument();
        Element catalogo = newDoc.createElement("Catalogo");
        newDoc.appendChild(catalogo);

        for (int i = 0; i < books.getLength(); i++) {
            Element oldBook = (Element) books.item(i);
            Element libro = newDoc.createElement("Libro");
            libro.setAttribute("id", oldBook.getAttribute("id"));

            Element autor = newDoc.createElement("Autor");
            autor.setTextContent(oldBook.getElementsByTagName("Author").item(0).getTextContent());
            libro.appendChild(autor);

            Element titulo = newDoc.createElement("Título");
            titulo.setTextContent(oldBook.getElementsByTagName("Title").item(0).getTextContent());
            libro.appendChild(titulo);

            Element genero = newDoc.createElement("Género");
            genero.setTextContent(oldBook.getElementsByTagName("Genre").item(0).getTextContent());
            libro.appendChild(genero);

            Element precio = newDoc.createElement("Precio");
            precio.setTextContent(oldBook.getElementsByTagName("Price").item(0).getTextContent());
            libro.appendChild(precio);

            Element fecha = newDoc.createElement("Fecha_de_publicación");
            fecha.setTextContent(oldBook.getElementsByTagName("PublishDate").item(0).getTextContent());
            libro.appendChild(fecha);

            Element descripcion = newDoc.createElement("Descripción");
            descripcion.setTextContent(oldBook.getElementsByTagName("Description").item(0).getTextContent());
            libro.appendChild(descripcion);

            catalogo.appendChild(libro);
        }

        // Guardar el nuevo XML en libros.xml
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(newDoc);
        StreamResult result = new StreamResult(new File("libros.xml"));
        transformer.transform(source, result);

        System.out.println("Archivo libros.xml creado correctamente.");
    }
}