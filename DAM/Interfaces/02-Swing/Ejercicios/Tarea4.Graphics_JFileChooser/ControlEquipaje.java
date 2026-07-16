import java.awt.*;
import javax.swing.*;

public class ControlEquipaje extends JFrame {
    private JSpinner spBultos;
    private JComboBox<String> comboProcedencia;
    private JButton btnSortear;
    private CirculoPanel panelCirculo;

    private int revisados = 0;
    private int noRevisados = 0;

    public ControlEquipaje() {
        super("Revisados:0  No revisados:0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Cantidad de bultos
        JLabel lblBultos = new JLabel("Cantidad de bultos:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblBultos, gbc);

        spBultos = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(spBultos, gbc);

        // Procedencia
        JLabel lblProcedencia = new JLabel("Procedencia:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblProcedencia, gbc);

        comboProcedencia = new JComboBox<>(new String[] { "Interior", "Exterior" });
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(comboProcedencia, gbc);

        // Btn sortear
        btnSortear = new JButton("Sortear");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnSortear, gbc);

        // Panel del círculo
        panelCirculo = new CirculoPanel();
        panelCirculo.setPreferredSize(new Dimension(150, 150));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(panelCirculo, gbc);

        // evento del btn
        btnSortear.addActionListener(e -> realizarSorteo());
    }

    private void realizarSorteo() {
        int bultos = (int) spBultos.getValue();

        // Validación
        if (bultos == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad de bultos mayor a 0.", "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean revisar;
        int sorteo = (int) (Math.random() * 3) + 1; // entre 1 y 3

        if (bultos > 5) {
            revisar = true; // siempre revisar si hay más de 5 bultos
        } else {
            revisar = (sorteo == 1);
        }

        // Actualizar contadores y color
        if (revisar) {
            revisados++;
            panelCirculo.setColor(Color.RED);
        } else {
            noRevisados++;
            panelCirculo.setColor(Color.GREEN);
        }

        // Actualizar título
        setTitle("Revisados:" + revisados + "  No revisados:" + noRevisados);

        // Reset de bultos
        spBultos.setValue(0);
    }

    // --- Panel para dibujar el círculo ---
    private static class CirculoPanel extends JPanel {
        private Color color = null;

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (color != null) {
                g.setColor(color);
                int d = 100;
                int x = (getWidth() - d) / 2;
                int y = (getHeight() - d) / 2;
                g.fillOval(x, y, d, d);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControlEquipaje().setVisible(true));
    }
}
