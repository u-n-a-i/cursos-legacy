import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window05CopyText extends JFrame {

    JTextField fieldValue, result;

    public Window05CopyText() throws HeadlessException {
        super("Ejemplo copy text");
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Valor: "));
        fieldValue = new JTextField(5);
        panel.add(fieldValue);

        JButton button = new JButton("Copiar");
        button.addActionListener(new CopyTextActionListener());
        panel.add(button);

        result = new JTextField(10);
        panel.add(result);

        setSize(600, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame frame = new Window05CopyText();
    }

    private class CopyTextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String value = fieldValue.getText();
            result.setText(value);
        }
    }
}
