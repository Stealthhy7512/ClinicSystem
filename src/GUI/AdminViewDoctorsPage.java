package GUI;

import javax.swing.*;
import java.util.ArrayList;

import Main.*;

public class AdminViewDoctorsPage extends JFrame {
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton back = new JButton("Back");

    public AdminViewDoctorsPage(JFrame frame, Section section) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //this.setLayout(new BorderLayout()); // Use BorderLayout for simplicity
        this.setTitle("Doctors");
        this.setLayout(null);

        int i = 0;
        for (Doctor doctor : section.getDoctorLinkedList()) {
            buttons.add(new JButton(doctor.toString()));
            buttons.get(i).setBounds(10, 40*i + 20, 350, 40);
            buttons.get(i).setFocusable(false);
            buttons.get(i).addActionListener(e -> {
                new AdminSchedulePage(this, doctor);
                this.setVisible(false);
            });
            this.add(buttons.get(i));
            ++i;
        }

        // Set up back button
        back.setBounds(20, 300, 100, 50);
        back.setFocusable(false);
        back.addActionListener(e -> {
            this.dispose();
            frame.setVisible(true);
        });
        this.add(back);

        // Enable frame
        this.setVisible(true);
    }
}
