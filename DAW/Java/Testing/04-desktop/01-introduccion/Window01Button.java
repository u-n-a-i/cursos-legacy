import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window01Button extends JFrame implements ActionListener{

    public Window01Button(){
        super("Ejemplo de Boton y eventos");

        JButton button = new JButton("Aceptar");
        button.addActionListener( event -> System.out.println("Boton pulsado!"));
        button.addActionListener( this );
        button.addActionListener(new ButtonClickListener());

        button.setSize(100, 50);
        getContentPane().add(button);
        setSize(200, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Window01Button();
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
