package GUI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import Main.*;

public class AdminViewHospitalsPage extends JFrame {
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton back = new JButton("Back");

    public AdminViewHospitalsPage(JFrame frame, CRS crs) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Hospitals");
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                crs.saveTablesToDisk("C://Users/kaany/Desktop/Java/ClinicSystem/load.ser");
                // Exit status of 1 shows successful save
                System.exit(1);
                super.windowClosed(e);
            }
        });

        int i = 0;
        for (Hospital hospital : crs.getHospitals().values()) {
            buttons.add(new JButton(hospital.toString()));
            buttons.get(i).setBounds(10, 40*i + 5, 350, 40);
            buttons.get(i).setFocusable(false);
            buttons.get(i).addActionListener(e -> {
                new AdminSectionPage(this, hospital, crs);
                this.setVisible(false);
            });
            this.add(buttons.get(i));
            ++i;
        }

        back.setBounds(20, 300, 100, 50);
        back.setFocusable(false);
        back.addActionListener(e -> {
            this.dispose();
            frame.setVisible(true);
        });
        this.add(back);

        this.setVisible(true);
    }
}
