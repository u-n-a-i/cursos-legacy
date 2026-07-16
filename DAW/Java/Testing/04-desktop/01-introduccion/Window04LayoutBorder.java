import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window04LayoutBorder extends JFrame implements ActionListener {

    public Window04LayoutBorder() {
        super("Ejemplo de Boton y eventos");

        JPanel panel = new JPanel(new BorderLayout(8, 4));

        JButton button = new JButton("Aceptar");
        button.addActionListener(event -> System.out.println("Boton pulsado!"));
        button.addActionListener(this);
        button.addActionListener(new ButtonClickListener());

        button.setSize(200, 100);
//            button.setPreferredSize(new Dimension(200, 100));
        panel.add(button, BorderLayout.CENTER);
        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("West"), BorderLayout.WEST);
        panel.add(new JButton("East"), BorderLayout.EAST);
        setContentPane(panel);
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window04LayoutBorder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton pulsado 2!");
    }

    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Boton pulsado 3!");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
