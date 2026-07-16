import java.io.File;

public class pruebaSeparador {
    public static void main(String[] args) throws Exception {
        File fichero1 = new File("ficheros" + File.separator + "reporte.txt");
        //Comprobar si existe el fichero
        if(fichero1.exists()){
            System.out.println("El fichero existe.");
        } else {
            System.out.println("El fichero no existe.");
        }
    }
}