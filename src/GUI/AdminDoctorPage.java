package GUI;

import javax.swing.*;
import java.awt.*;

import Main.*;

public class AdminDoctorPage extends JFrame {

    JButton addDoctorButton = new JButton("Add Doctor");
    JButton manageDoctorsButton = new JButton("Manage Doctors");

    JButton editSectionButton = new JButton("Edit Section Details");
    JButton back = new JButton("Back");

    JPanel addDoctor = new JPanel(new BorderLayout(5, 5));
    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));

    JPanel editSection = new JPanel(new BorderLayout(5, 5));
    JPanel editSectionLabel = new JPanel(new GridLayout(0, 1, 2, 2));

    public AdminDoctorPage(JFrame frame, Section section, CRS crs) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Section " + section.getName() + " (" + section.getId() + ")");
        this.setLayout(null);

        // Set up add doctor panel
        label.add(new JLabel("National ID", SwingConstants.RIGHT));
        label.add(new JLabel("Name", SwingConstants.RIGHT));
        label.add(new JLabel("Diploma ID", SwingConstants.RIGHT));
        label.add(new JLabel("Max Patients per Day", SwingConstants.RIGHT));
        addDoctor.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField id = new JTextField();
        controls.add(id);
        JTextField name = new JTextField();
        controls.add(name);
        JTextField diplomaId = new JTextField();
        controls.add(diplomaId);
        JTextField maxPatientsPerDay = new JTextField();
        controls.add(maxPatientsPerDay);
        addDoctor.add(controls, BorderLayout.CENTER);

        // Set up edit hospital panel
        editSectionLabel.add(new JLabel("ID", SwingConstants.RIGHT));
        editSectionLabel.add(new JLabel("Name", SwingConstants.RIGHT));
        editSection.add(editSectionLabel, BorderLayout.WEST);

        JPanel editControls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField s_id = new JTextField();
        s_id.setText(String.valueOf(section.getId()));
        editControls.add(s_id);
        s_id.setEditable(false);
        JTextField h_name = new JTextField();
        h_name.setText(section.getName());
        editControls.add(h_name);
        editSection.add(editControls, BorderLayout.CENTER);

        // Set up add sections button
        addDoctorButton.setBounds(20, 25, 200, 50);
        addDoctorButton.setFocusable(false);
        addDoctorButton.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(frame, addDoctor, "Add Doctor", JOptionPane.PLAIN_MESSAGE);
                if (!name.getText().isEmpty() && !id.getText().isEmpty() &&
                        !diplomaId.getText().isEmpty() && !maxPatientsPerDay.getText().isEmpty()) {
                    section.addDoctor(new Doctor(name.getText(), Long.parseLong(id.getText()), Integer.parseInt(diplomaId.getText()),
                                    new Schedule(Integer.parseInt(maxPatientsPerDay.getText()))));
                }
            } catch (DuplicateInfoException DuplicateInfoError) {
                JOptionPane.showMessageDialog(frame, "Doctor already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(addDoctorButton);

        // Set up manage sections button
        manageDoctorsButton.setBounds(20, 100, 200, 50);
        manageDoctorsButton.setFocusable(false);
        manageDoctorsButton.addActionListener(e -> {
            new AdminViewDoctorsPage(this, section, crs);
            this.setVisible(false);
        });
        this.add(manageDoctorsButton);

        // Set up edit section button
        editSectionButton.setBounds(220, 300, 150, 50);
        editSectionButton.setFocusable(false);
        editSectionButton.addActionListener( e -> {
            JOptionPane.showMessageDialog(frame, editSection, "Edit Section Details", JOptionPane.PLAIN_MESSAGE);
            section.setName(h_name.getText());
        });
        this.add(editSectionButton);

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
