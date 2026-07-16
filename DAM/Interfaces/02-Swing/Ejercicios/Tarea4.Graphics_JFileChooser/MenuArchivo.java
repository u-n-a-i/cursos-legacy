import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class MenuArchivo extends JFrame {

    private JTextField txtRuta;

    public MenuArchivo() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 150);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Crear barra de menú
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuArchivo = new JMenu("File");
        JMenuItem itemAbrir = new JMenuItem("Abrir...");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Agregar opciones al menú
        menuArchivo.add(itemAbrir);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);
        barraMenu.add(menuArchivo);
        setJMenuBar(barraMenu);

        // Campo de texto para mostrar la ruta
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtRuta = new JTextField();
        txtRuta.setEditable(false);
        add(txtRuta, gbc);

        // Evento para abrir
        itemAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSelectorArchivos();
            }
        });

        // evento para salir
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });
    }

    // Método para mostrar el selector de archivos
    private void mostrarSelectorArchivos() {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        selector.setAcceptAllFileFilterUsed(false); // Desactivar "Todos los archivos"
        selector.setFileFilter(filtro);

        int resultado = selector.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File fichero = selector.getSelectedFile();
            txtRuta.setText(fichero.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuArchivo().setVisible(true);
        });
    }
}
