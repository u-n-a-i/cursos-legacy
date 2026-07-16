import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FormAccesoMR implements ActionListener {

    private final int ANCHO = 400;
    private final int ALTURA = 200;

    private JFrame ventana;
    private JLabel pregunta;
    private JButton si;
    private JButton no;
    private boolean respuesta;

    public FormAccesoMR() {
        // Crear la ventana
        ventana = new JFrame("Acceso de movilidad reducida");
        ventana.setSize(ANCHO, ALTURA);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(3, 1)); // Etiqueta + 2 botones

        // Crear la etiqueta con la pregunta
        pregunta = new JLabel("¿La atracción tiene acceso de movilidad reducida?", JLabel.CENTER);
        ventana.add(pregunta);

        // Crear los botones
        si = new JButton("Sí");
        no = new JButton("No");

        ventana.add(si);
        ventana.add(no);

        // Mostrar la ventana
        ventana.setVisible(true);
    }

    public void anadirListenerBotones() {
        si.addActionListener(this);
        no.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == si) {
            respuesta = true;
        } else if (evento.getSource() == no) {
            respuesta = false;
        }
        // Puedes cerrar la ventana o imprimir la respuesta si lo deseas
        System.out.println("Respuesta: " + (respuesta ? "Sí" : "No"));
        ventana.dispose(); // Cierra la ventana después de responder
    }

    public static void main(String[] args) {
        FormAccesoMR form = new FormAccesoMR();
        form.anadirListenerBotones();
    }
}
