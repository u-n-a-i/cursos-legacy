import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class MiniEncuesta extends JFrame {
    private JRadioButton radioWindows, radioLinux, radioMac;
    private JCheckBox checkProgramacion, checkDisenio, checkAdministracion;
    private JSlider sliderHoras;
    private JLabel labelHoras;
    private JButton btnEnviar;

    public MiniEncuesta() {
        super("Mini encuesta");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        // Sistema operativo
        JLabel labelSistema = new JLabel("Elige un sistema operativo");
        add(labelSistema);

        ButtonGroup grupoSO = new ButtonGroup();
        radioWindows = new JRadioButton("Windows");
        radioLinux = new JRadioButton("Linux");
        radioMac = new JRadioButton("Mac");

        grupoSO.add(radioWindows);
        grupoSO.add(radioLinux);
        grupoSO.add(radioMac);

        add(radioWindows);
        add(radioLinux);
        add(radioMac);

        // Especialidad
        JLabel labelEspecialidad = new JLabel("Elige tu especialidad");
        add(labelEspecialidad);

        checkProgramacion = new JCheckBox("Programación");
        checkDisenio = new JCheckBox("Diseño gráfico");
        checkAdministracion = new JCheckBox("Administración");

        add(checkProgramacion);
        add(checkDisenio);
        add(checkAdministracion);

        // Horas
        JLabel labelHorasTitulo = new JLabel("Horas que dedicas en el ordenador");
        add(labelHorasTitulo);

        sliderHoras = new JSlider(0, 10, 0);
        add(sliderHoras);

        labelHoras = new JLabel("0");
        add(labelHoras);

        sliderHoras.addChangeListener(e -> {
            labelHoras.setText(String.valueOf(sliderHoras.getValue()));
        });

        // Botón enviar
        btnEnviar = new JButton("Generar");
        add(btnEnviar);

        btnEnviar.addActionListener(e -> {
            String so = radioWindows.isSelected() ? "Windows"
                    : radioLinux.isSelected() ? "Linux"
                            : radioMac.isSelected() ? "Mac"
                                    : "Ninguno";

            StringBuilder especialidades = new StringBuilder();
            if (checkProgramacion.isSelected())
                especialidades.append("Programación ");
            if (checkDisenio.isSelected())
                especialidades.append("Diseño gráfico ");
            if (checkAdministracion.isSelected())
                especialidades.append("Administración ");

            int horas = sliderHoras.getValue();

            JOptionPane.showMessageDialog(this,
                    "Sistema operativo: " + so + "\n" +
                            "Especialidades: " + (especialidades.length() > 0 ? especialidades.toString() : "Ninguna")
                            + "\n" +
                            "Horas en el ordenador: " + horas,
                    "Resultados de la encuesta",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniEncuesta();
    }
}
