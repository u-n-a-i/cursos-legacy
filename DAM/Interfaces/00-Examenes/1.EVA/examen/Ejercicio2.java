package examen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Ejercicio2 extends JFrame {
    private final JLabel mainLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel subLabel = new JLabel("", SwingConstants.CENTER);
    private final JPanel centerPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel(new BorderLayout());
    private final Random random = new Random();

    private int minimo = 1;
    private int maximo = 100;
    private int suposicionActual;
    private int intentos;

    public Ejercicio2() {
        super("Adivina un número");
        iniciarInterfaz();
    }

    private void iniciarInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        mainLabel.setFont(mainLabel.getFont().deriveFont(18f));
        subLabel.setFont(subLabel.getFont().deriveFont(14f));
        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(mainLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 6)));
        centerPanel.add(subLabel);
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        mostrarEstadoInicial();

        setSize(400, 220);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarEstadoInicial() {
        minimo = 1;
        maximo = 100;
        intentos = 0;
        mainLabel.setText("Piensa un numero del 1 al 100");
        subLabel.setText("");

        bottomPanel.removeAll();
        JButton readyBtn = new JButton("Estoy listo");
        readyBtn.addActionListener(this::alPulsarListo);
        bottomPanel.add(envolverAnchoCompleto(readyBtn), BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    private void alPulsarListo(ActionEvent e) {
        hacerIntento();
    }

    private void hacerIntento() {
        if (minimo > maximo) {
            // Evitar falta de coherencia. Si es 5 no puede ser mayor que 3 y luego menor
            // que 2
            JOptionPane.showMessageDialog(this, "¿Estas seguro que sabes tu número?. Se reinicia el juego.", "Error",
                    JOptionPane.WARNING_MESSAGE);
            mostrarEstadoInicial();
            return;
        }
        suposicionActual = random.nextInt(maximo - minimo + 1) + minimo;
        intentos++;
        mainLabel.setText("¿Es tu número " + suposicionActual + "?");
        subLabel.setText("");

        mostrarBotonesAdivinar();
    }

    private void mostrarBotonesAdivinar() {
        bottomPanel.removeAll();

        JPanel tresBtn = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton siBtn = new JButton("Si, ese es mi numero");
        JButton abajoBtn = new JButton("Mi numero es mas bajo que " + suposicionActual);
        JButton altoBtn = new JButton("Mi numero es mas alto que " + suposicionActual);

        siBtn.addActionListener(ev -> alAcertar());
        abajoBtn.addActionListener(ev -> {
            maximo = suposicionActual - 1;
            hacerIntento();
        });
        altoBtn.addActionListener(ev -> {
            minimo = suposicionActual + 1;
            hacerIntento();
        });

        tresBtn.add(siBtn);
        tresBtn.add(abajoBtn);
        tresBtn.add(altoBtn);

        bottomPanel.add(tresBtn, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    private void alAcertar() {
        mainLabel.setText("¡Adivinado!");
        subLabel.setText("Intentos: " + intentos);

        bottomPanel.removeAll();
        JButton restartBtn = new JButton("Reiniciar");
        restartBtn.addActionListener(ev -> mostrarEstadoInicial());
        bottomPanel.add(envolverAnchoCompleto(restartBtn), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JPanel envolverAnchoCompleto(JButton btn) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(btn, BorderLayout.CENTER);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio2::new);
    }
}