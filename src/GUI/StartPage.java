package GUI;

import Main.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class StartPage extends JFrame {

    JButton button1 = new JButton();
    JButton button2 = new JButton();
    CRS crs = new CRS();



    public StartPage() {
        crs.loadTablesToDisk("C://Users/kaany/Desktop/Java/ClinicSystem/load.ser");
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //this.setLayout(new BorderLayout()); // Use BorderLayout for simplicity
        this.setTitle("Clinic System");
        this.setLayout(null);

//        ArrayList<JButton> buttons = new ArrayList<>();
//
//        for (Hospital hospital : crs.getHospitals().values()) {
//            buttons.add(new JButton("Hospital " + hospital));
//        }
//
//        for (JButton button : buttons) {
//            this.add(button);
//        }

//        // Set up the label
//        label1.setText("Doctors");
//        label1.setFont(new Font(null, Font.BOLD, 20));
//        label1.setForeground(Color.BLACK);
//
//        label1.setBounds(20, 30, 100, 30);
//        label1.setBackground(Color.BLUE);
//        label1.setOpaque(true);
//
//        // Add the label to the frame
//        this.add(label1, BorderLayout.CENTER);

        //DoctorsPage doctorsPage = new DoctorsPage(this);


        button1.setText("Patient");
        //button1.setPreferredSize(new Dimension(100, 100));
        button1.setBounds(25, 150, 150, 50);
        button1.setFocusable(false);
        button1.addActionListener((e) -> {

        });
        this.add(button1);

        button2.setText("Administrator");
        button2.setBounds(185, 150, 150, 50);
        button2.setFocusable(false);
        button2.addActionListener((e) -> {
            new AdminHospitalPage(this, crs);
            this.setVisible(false);
        });
        this.add(button2);

        // Make the frame visible
        this.setVisible(true);
    }


}
