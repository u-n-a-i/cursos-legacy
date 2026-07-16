import java.io.IOException;

public class LanzarVSCode {
    public static void main(String[] args) throws Exception {
        try {
            Process proceso = new ProcessBuilder("code").start();

            Thread.sleep(10000);

            proceso.destroy();

            // Forzar cierre
            if (proceso.isAlive()) {
                proceso.destroyForcibly();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
