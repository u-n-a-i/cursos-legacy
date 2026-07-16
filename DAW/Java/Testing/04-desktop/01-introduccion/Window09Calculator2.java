import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window09Calculator2 extends JFrame implements ActionListener {

    Container container;
    String total = "";
    String operation = "";
    int aux;
    JLabel result;
    JLabel view;

    public Window09Calculator2() throws HeadlessException {
        super("Ejemplo Calculadora");
        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));

        JPanel panelTop = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel panelCenter = new JPanel(new GridLayout(5, 3, 5, 5));
        JPanel panelRight = new JPanel(new GridLayout(5, 1, 5, 5));

        container.add(panelTop, BorderLayout.NORTH);
        container.add(panelCenter, BorderLayout.CENTER);
        container.add(panelRight, BorderLayout.EAST);

        panelTop.add(this.view = new JLabel("", SwingConstants.RIGHT));
        panelTop.add(this.result = new JLabel("0", SwingConstants.RIGHT));
        view.setFont(new Font("Serif", Font.PLAIN, 16));
        result.setFont(new Font("Serif", Font.BOLD, 20));

        Border border = panelTop.getBorder();
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panelTop.setBorder(new CompoundBorder(border, margin));

        JButton buttonAC = new JButton("AC");
        JButton buttonAdd = new JButton("+");
        JButton buttonSubt = new JButton("-");
        JButton buttonDiv = new JButton("/");
        JButton buttonMult = new JButton("*");
        JButton buttonEqual = new JButton("=");

        panelCenter.add(buttonAC);
        panelCenter.add(new JLabel());
        panelCenter.add(new JLabel());

        for(int i = 9; i >= 0; i--){
            JButton button = new JButton(String.valueOf(i));
            panelCenter.add(button);
            button.addActionListener( event -> {
                String value = event.getActionCommand();
                total += value;
                this.view.setText(view.getText().concat(value));
                System.out.println(total);
            });
        }

        panelRight.add(buttonAdd);
        panelRight.add(buttonSubt);
        panelRight.add(buttonDiv);
        panelRight.add(buttonMult);
        panelRight.add(buttonEqual);

        buttonAdd.addActionListener(this);
        buttonSubt.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonMult.addActionListener(this);
        buttonEqual.addActionListener(event -> {
            int value = 0;
            int numA = this.aux;
            int numB = Integer.parseInt(this.total);

            value = switch (this.operation) {
                case "+" ->  numA + numB;
                case "-" -> numA - numB;
                case "*" -> numA * numB;
                case "/" -> numA / numB;
                default -> value;
            };
            total = String.valueOf(value);
            result.setText(total);
        });
        buttonAC.addActionListener(event -> {
            this.total = "";
            this.operation = "";
            this.aux = 0;
            view.setText("");
            result.setText("0");
        });

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.operation = e.getActionCommand();
        this.aux = Integer.parseInt(this.total);
        this.total = "";
        this.view.setText(view.getText().concat(operation));
    }

    public static void main(String[] args) {
        new Window09Calculator2();
    }
}
