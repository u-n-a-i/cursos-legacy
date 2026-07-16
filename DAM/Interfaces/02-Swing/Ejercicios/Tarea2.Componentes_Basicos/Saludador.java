import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Saludador extends JFrame {
    private JTextField campoTexto;
    private JButton btnSaludar;

    public Saludador() {
        // JFrame ventana
        super("Saludador");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes
        campoTexto = new JTextField(20);
        btnSaludar = new JButton("Saludar");

        // Evento
        btnSaludar.addActionListener(e -> {
            String nombre = campoTexto.getText();
            JOptionPane.showMessageDialog(Saludador.this,
                    "¡Hola " + (nombre.isEmpty() ? "Anónimo" : nombre) + "!",
                    "Saludo",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Añadir al panel
        add(campoTexto);
        add(btnSaludar);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Saludador());
    }

}
