import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MoverCirculo extends JFrame {

    private int circuloEjeX = 250;
    private final int CIRCULOEJEY = 150;
    private final int DIAMETRO = 90;
    private JButton btnIzquierda, btnDerecha;

    public MoverCirculo() {
        super("Mover circulo");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel para el circulo
        JPanel panelCirculo = new JPanel() {

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(circuloEjeX, CIRCULOEJEY, DIAMETRO, DIAMETRO);
            };
        };
        add(panelCirculo, BorderLayout.CENTER);

        // Botones
        btnIzquierda = new JButton("Izquierda");
        btnDerecha = new JButton("Derecha");

        // Panel para los btn
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnIzquierda);
        panelBotones.add(btnDerecha);
        add(panelBotones, BorderLayout.SOUTH);

        // eventos btn
        btnIzquierda.addActionListener(e -> {
            circuloEjeX -= 10;
            panelCirculo.repaint();
        });

        btnDerecha.addActionListener(e -> {
            circuloEjeX += 10;
            panelCirculo.repaint();
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MoverCirculo().setVisible(true);
        });
    }
}
