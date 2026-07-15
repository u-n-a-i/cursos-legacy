package ampliando_conceptos.serializacion;

import java.io.*;

public class PersonaTest {
    public static void main(String[] args) {
        String filename = "src\\ampliando_conceptos\\serializacion\\persona.ser";
        Persona personaOriginal = new Persona("Juan", 30, "Ingeniero");

        // Serialización
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(personaOriginal);
            System.out.println("Objeto Persona serializado y guardado en " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialización
        Persona personaDeserializada = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            personaDeserializada = (Persona) in.readObject();
            System.out.println("Objeto Persona deserializado desde " + filename);
            System.out.println("Persona deserializada: " + personaDeserializada);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Clase Persona no encontrada durante la deserialización.");
            c.printStackTrace();
        }
    }
}
