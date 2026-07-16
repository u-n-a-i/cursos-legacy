package fundamentos;
/*
 * Crea una clase en JAVA Swing que simula una ventana de login, con nombre de usuario y contraseña. 
 * La contraseña debe contener como mínimo 8 caracteres, mínimo una mayúscula, una minúscula y un número.
 * Además, se debe añadir una caja de texto adicional para la veriﬁcación de la contraseña y que ambas
 * coincidan. Si todo es correcto, se deben vaciar las cajas de texto y mostrar un mensaje de retroalimentación
 * por consola. Si hay algún tipo de error, se deberá mostrar un mensaje de error personalizado por consola.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ValidadorDeLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JPasswordField campoVerifica;
    private JButton btnLogin;

    public ValidadorDeLogin() {
        super("Ventana de Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 30, 20, 30)); // (al contrario de CSS) top, left, bottom, right

        // Componentes
        campoUsuario = new JTextField();
        campoPassword = new JPasswordField();
        campoVerifica = new JPasswordField();
        btnLogin = new JButton("Iniciar sesión");

        // Evento
        btnLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String pass = new String(campoPassword.getPassword());
            String verifica = new String(campoVerifica.getPassword());

            if (!pass.equals(verifica)) {
                System.out.println("Las contraseñas no coinciden.");
                return;
            }

            if (!validarPassword(pass)) {
                System.out.println(
                        "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número.");
                return;
            }

            // Feedback
            campoUsuario.setText("");
            campoPassword.setText("");
            campoVerifica.setText("");
            System.out.println("Login correcto. Bienvenido, " + usuario + ".");
        });

        // Añadir componentes al panel
        panel.add(new JLabel("Usuario:"));
        panel.add(campoUsuario);
        panel.add(new JLabel("Contraseña:"));
        panel.add(campoPassword);
        panel.add(new JLabel("Verificar contraseña:"));
        panel.add(campoVerifica);
        panel.add(new JLabel()); // espacio vacío
        panel.add(btnLogin);

        add(panel);
        setVisible(true);
    }

    // Validación de contraseña
    private boolean validarPassword(String pass) {
        return pass.length() >= 8 &&
                pass.matches(".*[A-Z].*") &&
                pass.matches(".*[a-z].*") &&
                pass.matches(".*\\d.*");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ValidadorDeLogin());
    }
}
