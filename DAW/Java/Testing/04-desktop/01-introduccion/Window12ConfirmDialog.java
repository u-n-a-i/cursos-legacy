import javax.swing.*;
import java.awt.*;

public class Window12ConfirmDialog extends JFrame {
    Container panel;
    public Window12ConfirmDialog(){
        super("Confirmar antes de ejecutar una tarea");

        panel = getContentPane();

        panel.setLayout(new FlowLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 4, 4));

        JLabel name = new JLabel("Nombre: ", JLabel.RIGHT);
        JTextField nameField = new JTextField();
        formPanel.add(name);
        formPanel.add(nameField);
        JLabel lastname = new JLabel("Apellido: ", JLabel.RIGHT);
        JTextField lastnameField = new JTextField();
        formPanel.add(lastname);
        formPanel.add(lastnameField);

        JLabel taxNumber = new JLabel("Rut: ", JLabel.RIGHT);
        JTextField taxNumberField = new JTextField();
        formPanel.add(taxNumber);
        formPanel.add(taxNumberField);

        JRadioButton morning = new JRadioButton("Grupo mañana", true);
        JRadioButton afternoon = new JRadioButton("Grupo tarde");
        formPanel.add(morning);
        formPanel.add(afternoon);

        int option = JOptionPane.showConfirmDialog(
                this,
                formPanel,
                "Introduzca los datos",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
        System.out.println(option);

        if (option == JOptionPane.OK_OPTION){
            System.out.println("hemos seleccionado OK");
            String nameValue = nameField.getText();
            System.out.println(nameValue);
            JOptionPane.showMessageDialog(this, "ejecutado con exito!", "alerta", JOptionPane.INFORMATION_MESSAGE);
        } else if (option == JOptionPane.CANCEL_OPTION){
            System.out.println("hemos seleccionado Cancelar");
            JOptionPane.showMessageDialog(this, "ejecutado con error!", "alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Window12ConfirmDialog();
    }
}
