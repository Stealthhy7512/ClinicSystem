package GUI;

import javax.swing.*;
import java.util.ArrayList;

import Main.*;

public class AdminViewSectionsPage extends JFrame {
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton back = new JButton("Back");

    public AdminViewSectionsPage(JFrame frame, Hospital hospital) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //this.setLayout(new BorderLayout()); // Use BorderLayout for simplicity
        this.setTitle("Sections");
        this.setLayout(null);

        int i = 0;
        for (Section section : hospital.getSectionLinkedList()) {
            buttons.add(new JButton(section.toString()));
            buttons.get(i).setBounds(10, 40*i + 20, 350, 40);
            buttons.get(i).setFocusable(false);
            buttons.get(i).addActionListener(e -> {
                new AdminDoctorPage(this, section);
                this.setVisible(false);
            });
            this.add(buttons.get(i));
            ++i;
        }

//        for (int i = 0; i < buttons.size(); ++i) {
//            buttons.get(i).setBounds(10, 40*i + 5, 250, 40);
//            buttons.get(i).setFocusable(false);
//            buttons.get(i).addActionListener(e -> {
//                //new AdminViewSectionsPage(this, )
//                this.setVisible(false);
//            });
//            this.add(buttons.get(i));
//        }

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
