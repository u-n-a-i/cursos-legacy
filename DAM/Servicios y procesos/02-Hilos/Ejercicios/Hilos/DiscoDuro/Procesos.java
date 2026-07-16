import java.io.File;

public class Procesos {
    public static void main(String[] args) {
        try {
            // En Windows: "cmd", "/c", "dir C:\\"
            ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/");
            pb.redirectOutput(new File("output.txt"));
            Process p = pb.start();

            int exitCode = p.waitFor();
            System.out.println("Proceso finalizado, código: " + exitCode);
            System.out.println("Salida guardada en output.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
