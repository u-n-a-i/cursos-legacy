import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FormularioConImagen extends JFrame {
    private JRadioButton opcion1, opcion2, opcion3, opcion4;
    private JButton btnSalir;
    private JLabel imagenLabel;

    public FormularioConImagen() {
        super("Formulario con imagen");
        setSize(600, 400);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Selecciona la imagen");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(titulo, BorderLayout.WEST);

        btnSalir = new JButton("Salir");
        panelSuperior.add(btnSalir, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel inferior
        JPanel panelInferior = new JPanel(new GridLayout(1, 2, 10, 10));

        // Panel de opciones
        JPanel panelOpciones = new JPanel(new GridLayout(4, 1, 5, 5));
        opcion1 = new JRadioButton("Perro");
        opcion2 = new JRadioButton("Gato");
        opcion3 = new JRadioButton("Tigre");
        opcion4 = new JRadioButton("León");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcion1);
        grupo.add(opcion2);
        grupo.add(opcion3);
        grupo.add(opcion4);

        panelOpciones.add(opcion1);
        panelOpciones.add(opcion2);
        panelOpciones.add(opcion3);
        panelOpciones.add(opcion4);

        // Panel de imagen
        imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);

        panelInferior.add(panelOpciones);
        panelInferior.add(imagenLabel);

        add(panelInferior, BorderLayout.CENTER);

        // Cambiar imagen
        ActionListener cambiarImagen = e -> {
            String ruta = "";
            if (opcion1.isSelected())
                ruta = "img/perro.jpg";
            else if (opcion2.isSelected())
                ruta = "img/gato.jpg";
            else if (opcion3.isSelected())
                ruta = "img/tigre.jpg";
            else if (opcion4.isSelected())
                ruta = "img/leon.jpg";

            ImageIcon icono = new ImageIcon(System.getProperty("user.dir") + "/" + ruta);
            Image imagen = icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imagenLabel.setIcon(new ImageIcon(imagen));
        };

        opcion1.addActionListener(cambiarImagen);
        opcion2.addActionListener(cambiarImagen);
        opcion3.addActionListener(cambiarImagen);
        opcion4.addActionListener(cambiarImagen);

        // confirmación de salida
        btnSalir.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que quieres salir?", "Confirmación",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        // Prevenir el cierre con la X
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                btnSalir.doClick();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioConImagen();
    }
}
