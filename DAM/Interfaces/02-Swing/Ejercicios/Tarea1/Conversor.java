package fundamentos;
/*
 * Crea una clase en JAVA Swing que reciba un número real en un JTextField y realice una conversión
 * entre C/$ y $/C. Se tomará como ejemplo el valor del dólar en 0,91C. Se puede crear un botón por cada
 * conversión, o con un comboBox, ambas opciones serán válidas. El resultado se mostrará en un JLabel.
 * 
 * JComboBox<es genérico> -> Menú despegable
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Conversor extends JFrame {
    private JTextField campoCantidad;
    private JLabel resultado;
    private JComboBox<String> opciones;

    private static final double DOLAR_EURO = 0.91;

    public Conversor() {
        // Ventana
        super("Conversor de Divisas");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20)); // márgenes

        // Arriba: etiqueta y campo
        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEntrada.add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField(15);
        panelEntrada.add(campoCantidad);

        // medio: combo y btn
        JPanel panelControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        opciones = new JComboBox<>(new String[] { "Euros € -> Dólar $", "Dólar $ -> Euros €" });
        JButton btnConvertir = new JButton("Convertir");
        panelControles.add(opciones);
        panelControles.add(btnConvertir);

        // Abajo inferior: resultado
        JPanel panelResultado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        resultado = new JLabel("Resultado: ");
        panelResultado.add(resultado);

        // Añadir paneles
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(panelControles, BorderLayout.CENTER);
        panelPrincipal.add(panelResultado, BorderLayout.SOUTH);

        // Evento
        btnConvertir.addActionListener(e -> {
            try {
                double cantidad = Double.parseDouble(campoCantidad.getText());
                String tipo = (String) opciones.getSelectedItem();
                double conversion;

                if (tipo.equals("Euros € -> Dólar $")) {
                    conversion = cantidad / DOLAR_EURO;
                    resultado.setText(String.format("Resultado: %.2f $", conversion));
                } else {
                    conversion = cantidad * DOLAR_EURO;
                    resultado.setText(String.format("Resultado: %.2f €", conversion));
                }
            } catch (Exception ex) {
                resultado.setText("Número no válido");
            }
        });

        // Mostrar ventana
        add(panelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        /**
         * SwingUtilities.invokeLater(Conversor::new);
         * 
         * Ejecuta el código proporcionado en el hilo de despacho de eventos (EDT) de
         * Swing.
         * 
         * Swing no es thread-safe, lo que significa que sus componentes deben ser
         * creados y modificados
         * únicamente desde el Event Dispatch Thread. Este método garantiza que el
         * Runnable se ejecute
         * en ese hilo, evitando errores de concurrencia y asegurando una interfaz
         * gráfica estable.
         * 
         *
         */

        SwingUtilities.invokeLater(Conversor::new);

    }
}