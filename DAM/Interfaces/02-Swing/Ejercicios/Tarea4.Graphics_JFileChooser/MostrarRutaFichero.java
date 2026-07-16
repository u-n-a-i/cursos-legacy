import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class MostrarRutaFichero extends JFrame {

    private JTextField txtRuta;
    private JButton btnBuscar;

    public MostrarRutaFichero() {
        super("Mostrar ruta fichero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 150);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta
        JLabel lblMensaje = new JLabel("Pulsa en el botón y elige una ruta");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblMensaje, gbc);

        // Campo de texto
        txtRuta = new JTextField();
        txtRuta.setEditable(false); // Solo lectura
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        add(txtRuta, gbc);

        // Botón
        btnBuscar = new JButton("...");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(btnBuscar, gbc);

        // evento btn
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSelectorArchivos();
            }
        });
    }

    private void mostrarSelectorArchivos() {
        JFileChooser selector = new JFileChooser();

        // Filtro para mostrar solo archivos .txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        selector.setFileFilter(filtro);

        // Mostrar cuadro de diálogo
        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File fichero = selector.getSelectedFile();
            txtRuta.setText(fichero.getAbsolutePath()); // Muestra la ruta completa
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MostrarRutaFichero().setVisible(true);
        });
    }
}
