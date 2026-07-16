package examen;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class Ejercicio1 extends JFrame {
    private final JTextArea textArea;
    private File currentFile;

    public Ejercicio1() {
        super("Editor - Sin nombre");
        textArea = new JTextArea(25, 80);
        interfaz();
    }

    private void interfaz() {
        JScrollPane sp = new JScrollPane(textArea);
        add(sp, BorderLayout.CENTER);

        JMenuBar mb = new JMenuBar();
        JMenu mf = new JMenu("Fichero");
        JMenuItem nuevo = new JMenuItem("Nuevo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");

        mf.add(nuevo);
        mf.add(abrir);
        mf.add(guardar);
        mf.addSeparator();
        mf.add(salir);
        mb.add(mf);
        setJMenuBar(mb);

        nuevo.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
            setTitle("Editor - Sin nombre");
        });

        abrir.addActionListener(e -> abrirArchivo());
        guardar.addActionListener(e -> guardarArchivo());
        salir.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        int option = fc.showOpenDialog(this);
        if (option != JFileChooser.APPROVE_OPTION)
            return;

        File f = fc.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            StringBuilder sb = new StringBuilder();
            String line;
            int lines = 0;
            boolean truncated = false;
            while ((line = br.readLine()) != null) {
                if (lines >= 100) {
                    truncated = true;
                    break;
                }
                if (sb.length() + line.length() + 1 > 10000) {
                    truncated = true;
                    break;
                }
                sb.append(line).append("\n");
                lines++;
            }
            textArea.setText(sb.toString());
            currentFile = f;
            setTitle("Editor - " + f.getName());
            if (truncated) {
                JOptionPane.showMessageDialog(this,
                        "Archivo cargado parcialmente (límite 100 líneas o 10.000 caracteres).",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarArchivo() {
        JFileChooser fc = new JFileChooser();
        if (currentFile != null)
            fc.setSelectedFile(currentFile);
        fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        int option = fc.showSaveDialog(this);
        if (option != JFileChooser.APPROVE_OPTION)
            return;

        File f = fc.getSelectedFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(textArea.getText());
            currentFile = f;
            setTitle("Editor - " + f.getName());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guarda:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio1::new);
    }
}
