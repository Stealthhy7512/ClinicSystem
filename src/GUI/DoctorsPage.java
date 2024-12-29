package GUI;

import javax.swing.*;
import java.awt.*;

public class DoctorsPage extends JFrame {

    public DoctorsPage(JFrame frame) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JPanel label = new JPanel(new GridLayout(1, 10, 2, 2));

        JButton button1 = new JButton("View Doctors");
        JButton button2 = new JButton("Add Doctors");
        JButton button3 = new JButton("Find Doctors");

        button1.addActionListener(e -> JOptionPane.showMessageDialog(panel, "hello", "View Doctors", JOptionPane.PLAIN_MESSAGE));
        button2.addActionListener(e -> JOptionPane.showMessageDialog(panel, "hello", "Add Doctors", JOptionPane.PLAIN_MESSAGE));
        button3.addActionListener(e -> JOptionPane.showMessageDialog(panel, "hello", "Find Doctors", -1));


        label.add(button1);
        label.add(button2);
        label.add(button3);

        panel.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
//        JTextField username = new JTextField();
//        controls.add(username);
//        JPasswordField password = new JPasswordField();
//        controls.add(password);
//        panel.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(frame, panel, "Doctors", JOptionPane.PLAIN_MESSAGE);
    }
}
