import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
 * Crea una simple lista de películas. tendremos un JComboBox, donde almacenaremos las películas,
 * que vayamos almacenando en un campo de texto. 
 * Al pulsar el botón Añadir la película que hayamos metido, se introducirá en el JComboBox.
 */

public class ListaPeliculas extends JFrame {
    private JTextField campoPelicula;
    private JComboBox<String> listaPeliculas;
    private JButton btnAgregar;
    private DefaultComboBoxModel<String> modeloCombo;

    public ListaPeliculas() {
        // Ventana
        super("Lista de películas");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes
        campoPelicula = new JTextField(20);
        add(campoPelicula);

        btnAgregar = new JButton("Añadir");
        add(btnAgregar);

        modeloCombo = new DefaultComboBoxModel<>();
        listaPeliculas = new JComboBox<>(modeloCombo);
        listaPeliculas.setPreferredSize(new Dimension(200, 25));
        add(listaPeliculas);

        // Evento
        btnAgregar.addActionListener(e -> {
            String pelicula = campoPelicula.getText().trim();

            // TO-DO: Validar
            if (!pelicula.isEmpty()) {
                // Añadir película
                modeloCombo.addElement(pelicula);
                // Limpiar campo
                campoPelicula.setText("");

            } else {
                JOptionPane.showMessageDialog(ListaPeliculas.this,
                        "Ingresa un nombre de una película.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListaPeliculas());
    }

}
