import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMD {
    public static void main(String[] args) {
        // Detectar SO
        String os = System.getProperty("os.name").toLowerCase();
        String[] comando;

        if (os.contains("win")) {
            comando = new String[] { "cmd.exe", "/c", "tasklist" };
        } else {
            comando = new String[] { "bash", "-c", "ps aux" };
        }

        try {
            ProcessBuilder builder = new ProcessBuilder(comando);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
