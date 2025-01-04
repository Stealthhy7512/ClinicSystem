package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Main.*;

public class AdminHospitalPage extends JFrame {
    JButton addHospitalButton = new JButton("Add Hospitals");
    JButton manageHospitalsButton = new JButton("Manage Hospitals");
    JButton back = new JButton("Back");
    JPanel addHospital = new JPanel(new BorderLayout(5, 5));
    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
    public AdminHospitalPage(JFrame frame, CRS crs) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //this.setLayout(new BorderLayout()); // Use BorderLayout for simplicity
        this.setTitle("Clinic System");
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

        label.add(new JLabel("ID", SwingConstants.RIGHT));
        label.add(new JLabel("Name", SwingConstants.RIGHT));
        addHospital.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField id = new JTextField();
        controls.add(id);
        JTextField name = new JTextField();
        controls.add(name);
        addHospital.add(controls, BorderLayout.CENTER);

        addHospitalButton.setBounds(20, 25, 200, 50);
        addHospitalButton.setFocusable(false);
        addHospitalButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, addHospital, "Add Hospital", JOptionPane.PLAIN_MESSAGE);
        if (!id.getText().isEmpty() && !name.getText().isEmpty()) {
            crs.addHospital(new Hospital(Integer.parseInt(id.getText()), name.getText()));
            }
        });

        manageHospitalsButton.setBounds(20, 100, 200, 50);
        manageHospitalsButton.setFocusable(false);
        manageHospitalsButton.addActionListener(e -> {
            new AdminViewHospitalsPage(this, crs);
            this.setVisible(false);
        });

        back.setBounds(20, 300, 100, 50);
        back.setFocusable(false);
        back.addActionListener(e -> {
            this.dispose();
            frame.setVisible(true);
        });

        this.add(addHospitalButton);
        this.add(manageHospitalsButton);
        this.add(back);
        this.setVisible(true);
    }
}
