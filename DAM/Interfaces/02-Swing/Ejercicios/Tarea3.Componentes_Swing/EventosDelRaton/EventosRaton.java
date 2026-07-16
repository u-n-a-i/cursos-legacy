import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosRaton extends JFrame implements MouseListener {

    private JLabel lblTitulo, lblMensaje;
    private JButton btnPresioname;

    public EventosRaton() {
        super("DAM 2 Interfaces Eventos del Mouse");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));

        // Título
        lblTitulo = new JLabel("Eventos del Ratón", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblTitulo.setBounds(80, 30, 230, 40);
        add(lblTitulo);

        // Botón
        btnPresioname = new JButton("Presioname");
        btnPresioname.setBounds(130, 110, 140, 40);
        btnPresioname.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(btnPresioname);

        // Mensaje
        lblMensaje = new JLabel("", SwingConstants.LEFT);
        lblMensaje.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblMensaje.setBounds(30, 200, 300, 20);
        add(lblMensaje);

        // Agregar eventos de ratón al título y al botón
        lblTitulo.addMouseListener(this);
        btnPresioname.addMouseListener(this);
    }

    // ===== Métodos del MouseListener =====
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == btnPresioname)
            lblMensaje.setText("Hiciste clic en el botón");
        else if (e.getSource() == lblTitulo)
            lblMensaje.setText("Hiciste clic en el título");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btnPresioname)
            lblMensaje.setText("Presionaste el botón");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == btnPresioname)
            lblMensaje.setText("Soltaste el botón");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lblTitulo)
            lblMensaje.setText("Entraste al Título");
        else if (e.getSource() == btnPresioname)
            lblMensaje.setText("Entraste al Botón");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lblTitulo)
            lblMensaje.setText("Salió del Título");
        else if (e.getSource() == btnPresioname)
            lblMensaje.setText("Salió del Botón");
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        new EventosRaton().setVisible(true);
    }
}
