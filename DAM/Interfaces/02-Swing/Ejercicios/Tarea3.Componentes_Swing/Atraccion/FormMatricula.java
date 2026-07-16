import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormMatricula implements ActionListener {
    private final int ANCHO = 250;
    private final int ALTO = 200;

    private JFrame ventana;
    private JLabel lMatricula;
    private JTextField tMatricula;
    private JButton matricular;

    public FormMatricula() {
        // Crear la ventana
        ventana = new JFrame("Matriculación barco");
        ventana.setSize(ANCHO, ALTO);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(3, 1)); // Etiqueta, campo de texto, botón

        // Crear la etiqueta
        lMatricula = new JLabel("Matrícula del barco:", JLabel.CENTER);
        ventana.add(lMatricula);

        // Crear el campo de texto con valor por defecto
        tMatricula = new JTextField("7º-PM-1-01-11");
        ventana.add(tMatricula);

        // Crear el botón
        matricular = new JButton("Matricular");
        ventana.add(matricular);

        // Mostrar la ventana
        ventana.setVisible(true);
    }

    public void añadirListenerBotones() {
        matricular.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {
        // Crear el barco con nombre, eslora y cabinas fijos
        Barco nuevoBarco = new Barco(null, "Barco", 13.5F, 4);

        // Asignar la matrícula introducida por el usuario
        String matriculaIngresada = tMatricula.getText();
        nuevoBarco.setMatricula(matriculaIngresada);

        // Mostrar el resultado por consola
        System.out.println("Barco matriculado:");
        System.out.println(nuevoBarco.toString());

        // Cerrar la ventana
        ventana.dispose();
    }

    // Método main para probar el formulario
    public static void main(String[] args) {
        FormMatricula form = new FormMatricula();
        form.añadirListenerBotones();
    }
}
