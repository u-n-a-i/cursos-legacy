import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FormularioProductos extends JFrame {
    private JTextField txtNombre, txtPrecio;
    private JButton btnAgregar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public FormularioProductos() {
        // Ventana
        super("Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para los campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos y botón
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(20);
        btnAgregar = new JButton("Agregar Producto");

        // Agregar componentes al panel
        panelEntrada.add(lblNombre);
        panelEntrada.add(txtNombre);
        panelEntrada.add(lblPrecio);
        panelEntrada.add(txtPrecio);
        panelEntrada.add(new JLabel()); // Espacio vacío
        panelEntrada.add(btnAgregar);

        // Configuración de la tabla
        String[] columnas = { "Nombre", "Precio" };
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Agregar componentes a la ventana
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Acción del botón Agregar
        btnAgregar.addActionListener(e -> {
            agregarProducto();
        });

    }

    private void agregarProducto() {
        String nombre = txtNombre.getText().trim();
        String precioText = txtPrecio.getText().trim();

        // Validar nombre no vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del producto no puede estar vacío.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();
            return;
        }

        // Validar precio double
        double precio;
        try {
            precio = Double.parseDouble(precioText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un valor numérico válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            txtPrecio.requestFocus();
            return;
        }

        // Agregar a la tabla
        modeloTabla.addRow(new Object[] { nombre, precio });

        // Limpiar campos
        txtNombre.setText("");
        txtPrecio.setText("");

        // Devolver el foco al campo nombre
        txtNombre.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioProductos().setVisible(true);
        });
    }
}