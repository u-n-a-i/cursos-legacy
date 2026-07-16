package fundamentos;

/*
 * Crea una clase en JAVA Swing que reciba dos enteros en dos JTextField y muestre en un JLabel el
 * resultado de sumar ambos enteros. Se debe comprobar previamente si el contenido introducido en ambas
 * cajas de texto se corresponde con un entero válido.
 */

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SumarEnteros extends JFrame {
    private JTextField campo1, campo2;
    private JLabel resultado;

    public SumarEnteros() {
        // Ventana
        super("Sumar enteros");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 1));

        // Componentes
        campo1 = new JTextField();
        campo2 = new JTextField();
        JButton btnSumar = new JButton("Sumar");
        resultado = new JLabel("Resultado: ");

        // Evento
        btnSumar.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(campo1.getText());
                int num2 = Integer.parseInt(campo2.getText());
                int suma = num1 + num2;
                resultado.setText("Resultado: " + suma);
            } catch (NumberFormatException ex) {
                System.out.println("Solo números enteros: " + ex);
            }
        });

        // Añadir componentes
        add(new JLabel("Primer número:"));
        add(campo1);
        add(new JLabel("Segundo número:"));
        add(campo2);
        add(btnSumar);
        add(resultado);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SumarEnteros();
    }

}
