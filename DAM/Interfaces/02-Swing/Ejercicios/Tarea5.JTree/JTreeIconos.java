import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class JTreeIconos extends JFrame {

    private JTree arbol;
    private DefaultMutableTreeNode raiz;
    private JTextArea areaRutas;

    public JTreeIconos() {
        setTitle("DAM : Ejemplo JTree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Etiqueta superior
        JLabel lblTitulo = new JLabel("Componente JTree", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel principal con árbol y panel lateral
        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 10));

        // Crear árbol
        raiz = new DefaultMutableTreeNode("Carpeta");
        DefaultMutableTreeNode subCarpeta = new DefaultMutableTreeNode("SubCarpeta");
        DefaultMutableTreeNode archivo1 = new DefaultMutableTreeNode("Archivo1");
        DefaultMutableTreeNode archivo2 = new DefaultMutableTreeNode("Archivo2");
        DefaultMutableTreeNode archivo3 = new DefaultMutableTreeNode("Archivo3");
        DefaultMutableTreeNode archivo4 = new DefaultMutableTreeNode("Archivo4");
        DefaultMutableTreeNode archivo5 = new DefaultMutableTreeNode("Archivo5");
        DefaultMutableTreeNode archivo6 = new DefaultMutableTreeNode("Archivo6");

        subCarpeta.add(archivo3);
        subCarpeta.add(archivo4);
        subCarpeta.add(archivo5);
        subCarpeta.add(archivo6);
        raiz.add(subCarpeta);
        raiz.add(archivo1);
        raiz.add(archivo2);

        arbol = new JTree(raiz);
        arbol.setCellRenderer(new IconosPersonalizados());

        JScrollPane scrollArbol = new JScrollPane(arbol);
        panelCentro.add(scrollArbol);

        // Panel lateral
        JPanel panelLateral = new JPanel();
        panelLateral.setBackground(Color.GREEN);
        panelLateral.add(new JLabel("Titulo Panel3"));
        panelCentro.add(panelLateral);

        add(panelCentro, BorderLayout.CENTER);

        // Área inferior para mostrar rutas
        areaRutas = new JTextArea(8, 20);
        JScrollPane scrollArea = new JScrollPane(areaRutas);
        add(scrollArea, BorderLayout.SOUTH);

        // Evento al seleccionar un nodo
        arbol.addTreeSelectionListener(e -> {
            TreePath ruta = e.getPath();
            areaRutas.append("Ruta: " + ruta + "\n");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JTreeIconos().setVisible(true);
        });
    }
}
