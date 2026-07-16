import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GeneradorNumeros extends JFrame {

    private JSpinner spinner1, spinner2;
    private JTextField txtResultado;
    private JButton btnGenerar;
    private Random random;

    public GeneradorNumeros() {
        super("Generador de números");
        random = new Random();

        setSize(320, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(235, 238, 245)); // gris claro

        // Etiquetas
        JLabel lbl1 = new JLabel("Número 1:");
        lbl1.setBounds(40, 40, 100, 25);
        add(lbl1);

        spinner1 = new JSpinner(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
        spinner1.setBounds(160, 40, 80, 25);
        add(spinner1);

        JLabel lbl2 = new JLabel("Número 2:");
        lbl2.setBounds(40, 85, 100, 25);
        add(lbl2);

        spinner2 = new JSpinner(new SpinnerNumberModel(8, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
        spinner2.setBounds(160, 85, 80, 25);
        add(spinner2);

        JLabel lblRes = new JLabel("Número generado:");
        lblRes.setBounds(40, 130, 130, 25);
        add(lblRes);

        txtResultado = new JTextField();
        txtResultado.setBounds(180, 130, 60, 25);
        txtResultado.setEditable(false);
        add(txtResultado);

        // Botón
        btnGenerar = new JButton("Generar");
        btnGenerar.setBounds(100, 190, 120, 35);
        add(btnGenerar);

        // Evento
        btnGenerar.addActionListener(e -> {
            int n1 = (int) spinner1.getValue();
            int n2 = (int) spinner2.getValue();
            int min = Math.min(n1, n2);
            int max = Math.max(n1, n2);
            int numAleatorio = random.nextInt(max - min + 1) + min;
            txtResultado.setText(String.valueOf(numAleatorio));
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GeneradorNumeros();
    }
}
