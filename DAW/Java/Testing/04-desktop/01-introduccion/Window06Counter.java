import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window06Counter extends JFrame implements ActionListener {

    private int counter;
    private JButton button = new JButton("Count");
    private JLabel result = new JLabel("Counter: 0");
    private JButton buttonDecrement = new JButton("Decrement");

    public Window06Counter() throws HeadlessException {
        super("Ejemplo contador");

        Container panel = getContentPane();
        panel.add(button);
        panel.add(new JLabel(" - "));
        panel.add(buttonDecrement);
        panel.add(result);
        panel.setLayout(new FlowLayout());
        button.addActionListener(this);
        buttonDecrement.addActionListener( event -> {
            counter--;
            result.setText("Counter: " + counter);
        });
        setVisible(true);
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window06Counter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        result.setText("Counter: ".concat(String.valueOf(counter)));
    }
}
