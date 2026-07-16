import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {
    public void lanzarSumador(int n1, int n2, String archivoSalida) {
        try {
            // Construir el comando
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "Sumador", String.valueOf(n1),
                    String.valueOf(n2));

            pb.redirectErrorStream(true); // Combina stdout y stderr

            Process proceso = pb.start();

            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }

            writer.close();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Lanzador l = new Lanzador();
        l.lanzarSumador(1, 5, "result1.txt");
        // l.lanzarSumador(6, 10, "resultados/result2.txt");
        System.out.println("Ok");
    }
}
