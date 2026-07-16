import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;

public class CuentaAtrasApp extends JFrame {
    private JTextField campoSegundos;
    private JButton botonIniciar;
    private JButton botonCancelar;
    private JProgressBar barraProgreso;
    private JLabel etiquetaTiempo;
    private Thread hiloCuentaAtras;

    public CuentaAtrasApp() {
        super("Cuenta atrás con barra de progreso");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        campoSegundos = new JTextField();
        botonIniciar = new JButton("Iniciar");
        botonCancelar = new JButton("Cancelar");
        barraProgreso = new JProgressBar();
        etiquetaTiempo = new JLabel("Tiempo restante: ", SwingConstants.CENTER);

        add(new JLabel("Introduce segundos:", SwingConstants.CENTER));
        add(campoSegundos);
        add(etiquetaTiempo);
        add(barraProgreso);
        add(botonIniciar);
        add(botonCancelar);

        botonIniciar.addActionListener(e -> iniciarCuentaAtras());
        botonCancelar.addActionListener(e -> cancelarCuentaAtras());
    }

    private void iniciarCuentaAtras() {
        if (hiloCuentaAtras != null && hiloCuentaAtras.isAlive()) {
            JOptionPane.showMessageDialog(this, "Ya hay una cuenta atrás en curso.");
            return;
        }

        int segundos;
        try {
            segundos = Integer.parseInt(campoSegundos.getText());
            if (segundos <= 0)
                throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce un número válido de segundos.");
            return;
        }

        barraProgreso.setMaximum(segundos);
        barraProgreso.setValue(segundos);
        etiquetaTiempo.setText("Tiempo restante: " + segundos + " segundos");

        hiloCuentaAtras = new Thread(() -> {
            for (int i = segundos; i >= 0; i--) {
                final int tiempoRestante = i;
                SwingUtilities.invokeLater(() -> {
                    barraProgreso.setValue(tiempoRestante);
                    etiquetaTiempo.setText("Tiempo restante: " + tiempoRestante + " segundos");
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    SwingUtilities.invokeLater(() -> etiquetaTiempo.setText("Cuenta atrás cancelada."));
                    return;
                }
            }

            SwingUtilities.invokeLater(() -> {
                etiquetaTiempo.setText("¡Cuenta atrás finalizada!");
                JOptionPane.showMessageDialog(this, "¡Tiempo completado!");
            });
        });

        hiloCuentaAtras.start();
    }

    private void cancelarCuentaAtras() {
        if (hiloCuentaAtras != null && hiloCuentaAtras.isAlive()) {
            hiloCuentaAtras.interrupt();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CuentaAtrasApp().setVisible(true));
    }
}
