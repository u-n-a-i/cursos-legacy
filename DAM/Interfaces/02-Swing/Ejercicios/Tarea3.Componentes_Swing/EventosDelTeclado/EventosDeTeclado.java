import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosDeTeclado extends JFrame {

    private JTextArea areaEntrada, areaSalida;
    private JLabel lblContador;

    public EventosDeTeclado() {
        super("Diseño de interfaces : Ventana Eventos del Teclado");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(238, 238, 238));

        // Título
        JLabel lblTitulo = new JLabel("Eventos del Teclado", SwingConstants.CENTER);
        lblTitulo.setBounds(160, 20, 260, 40);
        add(lblTitulo);

        // Etiqueta área entrada
        JLabel lblEntrada = new JLabel("Area Entrada de Texto");
        lblEntrada.setBounds(40, 80, 200, 20);
        add(lblEntrada);

        // Área entrada
        areaEntrada = new JTextArea();
        JScrollPane scrollEntrada = new JScrollPane(areaEntrada);
        scrollEntrada.setBounds(40, 105, 500, 60);
        add(scrollEntrada);

        // Etiqueta área salida
        JLabel lblSalida = new JLabel("Area Salida de Texto");
        lblSalida.setBounds(40, 175, 200, 20);
        add(lblSalida);

        // Área salida
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane scrollSalida = new JScrollPane(areaSalida);
        scrollSalida.setBounds(40, 200, 500, 60);
        add(scrollSalida);

        // Etiquetas inferiores
        JLabel lblSalir = new JLabel("Para salir presione la tecla Escape");
        lblSalir.setBounds(40, 280, 300, 20);
        add(lblSalir);

        lblContador = new JLabel("Numero Vocales: 0");
        lblContador.setBounds(400, 280, 200, 20);
        add(lblContador);

        // Evento de teclado
        areaEntrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Salir con ESC
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }

                // Contar vocales
                String texto = areaEntrada.getText().toLowerCase();
                StringBuilder soloVocales = new StringBuilder();
                int contador = 0;

                for (char c : texto.toCharArray()) {
                    if ("aeiouáéíóú".indexOf(c) != -1) {
                        soloVocales.append(c).append(" ");
                        contador++;
                    }
                }

                areaSalida.setText(soloVocales.toString());
                lblContador.setText("Numero Vocales: " + contador);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EventosDeTeclado();
        });
    }
}
