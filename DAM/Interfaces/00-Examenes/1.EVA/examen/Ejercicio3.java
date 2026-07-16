package examen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Ejercicio3 extends JFrame implements ActionListener, ItemListener {

    private JLabel lblMensaje;
    private JRadioButton rbRed, rbBlue, rbGreen, rbYellow;
    private JRadioButton rbBlack, rbGray, rbLightGray, rbWhite;
    private JComboBox<String> comboColor;
    private JCheckBox chkUsaHola;
    private JMenuItem menuHola, menuAdios;
    private JRadioButtonMenuItem menuFondoNegro, menuFondoGris, menuFondoBlanco;
    private ButtonGroup grupoColores, grupoFondos, grupoMenuFondos;

    public Ejercicio3() {
        super("Seleccionador de opciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuControl = new JMenu("Control");
        JMenu menuColorFondo = new JMenu("Color de Fondo");

        menuHola = new JMenuItem("Usa 'HOLA'");
        menuAdios = new JMenuItem("Usa 'ADIOS'");
        menuHola.addActionListener(this);
        menuAdios.addActionListener(this);
        menuControl.add(menuHola);
        menuControl.add(menuAdios);

        menuFondoNegro = new JRadioButtonMenuItem("Negro", true);
        menuFondoGris = new JRadioButtonMenuItem("Gris");
        menuFondoBlanco = new JRadioButtonMenuItem("Blanco");

        grupoMenuFondos = new ButtonGroup();
        grupoMenuFondos.add(menuFondoNegro);
        grupoMenuFondos.add(menuFondoGris);
        grupoMenuFondos.add(menuFondoBlanco);

        menuColorFondo.add(menuFondoNegro);
        menuColorFondo.add(menuFondoGris);
        menuColorFondo.add(menuFondoBlanco);

        menuFondoNegro.addActionListener(this);
        menuFondoGris.addActionListener(this);
        menuFondoBlanco.addActionListener(this);

        menuBar.add(menuControl);
        menuBar.add(menuColorFondo);
        setJMenuBar(menuBar);

        JPanel panelCentral = new JPanel(new GridLayout(1, 3, 10, 10));

        JPanel panelIzq = new JPanel(new GridLayout(4, 1));
        rbRed = new JRadioButton("Red", true);
        rbBlue = new JRadioButton("Blue");
        rbGreen = new JRadioButton("Green");
        rbYellow = new JRadioButton("Yellow");
        grupoColores = new ButtonGroup();
        grupoColores.add(rbRed);
        grupoColores.add(rbBlue);
        grupoColores.add(rbGreen);
        grupoColores.add(rbYellow);

        panelIzq.add(rbRed);
        panelIzq.add(rbBlue);
        panelIzq.add(rbGreen);
        panelIzq.add(rbYellow);

        rbRed.addItemListener(this);
        rbBlue.addItemListener(this);
        rbGreen.addItemListener(this);
        rbYellow.addItemListener(this);

        lblMensaje = new JLabel("ADIOS", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Serif", Font.BOLD, 50));
        lblMensaje.setForeground(Color.RED);
        lblMensaje.setBackground(Color.BLACK);
        lblMensaje.setOpaque(true);

        JPanel panelDer = new JPanel(new GridLayout(4, 1));
        rbBlack = new JRadioButton("Black", true);
        rbGray = new JRadioButton("Gray");
        rbLightGray = new JRadioButton("Light Gray");
        rbWhite = new JRadioButton("White");
        grupoFondos = new ButtonGroup();
        grupoFondos.add(rbBlack);
        grupoFondos.add(rbGray);
        grupoFondos.add(rbLightGray);
        grupoFondos.add(rbWhite);

        panelDer.add(rbBlack);
        panelDer.add(rbGray);
        panelDer.add(rbLightGray);
        panelDer.add(rbWhite);

        rbBlack.addItemListener(this);
        rbGray.addItemListener(this);
        rbLightGray.addItemListener(this);
        rbWhite.addItemListener(this);

        panelCentral.add(panelIzq);
        panelCentral.add(lblMensaje);
        panelCentral.add(panelDer);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        comboColor = new JComboBox<>(new String[] { "Red", "Blue", "Green", "Yellow" });
        comboColor.addActionListener(this);
        chkUsaHola = new JCheckBox("Usa 'HOLA'");
        chkUsaHola.addItemListener(this);
        panelInferior.add(comboColor);
        panelInferior.add(chkUsaHola);

        add(panelInferior, BorderLayout.SOUTH);

        setSize(550, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        actualizarColores();
        if (e.getSource() == chkUsaHola) {
            lblMensaje.setText(chkUsaHola.isSelected() ? "HOLA" : "ADIOS");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == comboColor) {
            actualizarColores();
        } else if (src == menuHola) {
            lblMensaje.setText("HOLA");
        } else if (src == menuAdios) {
            lblMensaje.setText("ADIOS");
        } else if (src == menuFondoNegro) {
            lblMensaje.setBackground(Color.BLACK);
        } else if (src == menuFondoGris) {
            lblMensaje.setBackground(Color.GRAY);
        } else if (src == menuFondoBlanco) {
            lblMensaje.setBackground(Color.WHITE);
        }
    }

    private void actualizarColores() {

        Color colorTexto = switch (comboColor.getSelectedItem().toString()) {
            case "Blue" -> Color.BLUE;
            case "Green" -> Color.GREEN;
            case "Yellow" -> Color.YELLOW;
            default -> Color.RED;
        };
        lblMensaje.setForeground(colorTexto);

        if (rbBlack.isSelected())
            lblMensaje.setBackground(Color.BLACK);
        else if (rbGray.isSelected())
            lblMensaje.setBackground(Color.GRAY);
        else if (rbLightGray.isSelected())
            lblMensaje.setBackground(Color.LIGHT_GRAY);
        else if (rbWhite.isSelected())
            lblMensaje.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio3::new);
    }
}
