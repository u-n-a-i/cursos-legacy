// En Linux no hay C -> uso /

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

public class SinHilo extends JFrame {

    private JTextArea textArea;
    private JButton btnSalir;

    public SinHilo() {
        super("Listado de archivos - Sin hilo");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir, BorderLayout.SOUTH);

        setVisible(true);

        // Carga sin hilo (bloquea la interfaz)
        listarArchivos(new File("/"));
    }

    private void listarArchivos(File dir) {
        File[] archivos = dir.listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                textArea.append(f.getAbsolutePath() + "\n");
                if (f.isDirectory()) {
                    listarArchivos(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        new SinHilo();
    }
}