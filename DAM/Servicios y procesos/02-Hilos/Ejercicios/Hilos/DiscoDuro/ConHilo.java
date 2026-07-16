// En Linux no hay C -> uso /

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.io.File;

public class ConHilo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Con Hilo");
        JTextArea area = new JTextArea();
        JButton botonSalir = new JButton("Salir");

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(area), BorderLayout.CENTER);
        frame.add(botonSalir, BorderLayout.SOUTH);

        botonSalir.addActionListener(e -> System.exit(0));

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Carga en segundo plano
        new Thread(() -> {
            File raiz = new File("/");
            listarArchivos(raiz, area);
        }).start();
    }

    public static void listarArchivos(File dir, JTextArea area) {
        File[] archivos = dir.listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                SwingUtilities.invokeLater(() -> area.append(f.getAbsolutePath() + "\n"));
                if (f.isDirectory()) {
                    listarArchivos(f, area);
                }
            }
        }
    }
}
