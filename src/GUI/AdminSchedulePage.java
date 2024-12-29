package GUI;

import javax.swing.*;
import java.awt.*;
import Main.*;
public class AdminSchedulePage extends JFrame {
    JButton addRendezvousButton = new JButton("Add Rendezvous");
    JButton manageScheduleButton = new JButton("Manage Schedule");

    JButton editDoctorButton = new JButton("Edit Doctor Details");
    JButton back = new JButton("Back");

    JPanel addRendezvous = new JPanel(new BorderLayout(5, 5));
    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));

    JPanel editDoctor = new JPanel(new BorderLayout(5, 5));
    JPanel editDoctorLabel = new JPanel(new GridLayout(0, 1, 2, 2));

    public AdminSchedulePage(JFrame frame, Doctor doctor) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //this.setLayout(new BorderLayout()); // Use BorderLayout for simplicity
        this.setTitle("Doctor " + doctor.getName() + " (" + doctor.getDiplomaId() + ")");
        this.setLayout(null);

        // Set up add section panel
        label.add(new JLabel("National ID", SwingConstants.RIGHT));
        label.add(new JLabel("Name", SwingConstants.RIGHT));
        label.add(new JLabel("Diploma ID", SwingConstants.RIGHT));
        addRendezvous.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField id = new JTextField();
        controls.add(id);
        JTextField name = new JTextField();
        controls.add(name);
        JTextField diplomaId = new JTextField();
        controls.add(diplomaId);
        addRendezvous.add(controls, BorderLayout.CENTER);

        // Set up edit doctor panel
        editDoctorLabel.add(new JLabel("Diploma ID", SwingConstants.RIGHT));
        editDoctorLabel.add(new JLabel("Name", SwingConstants.RIGHT));
        editDoctor.add(editDoctorLabel, BorderLayout.WEST);

        JPanel editControls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField d_id = new JTextField();
        d_id.setText(String.valueOf(doctor.getDiplomaId()));
        editControls.add(d_id);
        d_id.setEditable(false);
        JTextField d_name = new JTextField();
        editControls.add(d_name);
        editDoctor.add(editControls, BorderLayout.CENTER);

        // Set up add sections button
        addRendezvousButton.setBounds(20, 25, 200, 50);
        addRendezvousButton.setFocusable(false);


        // Set up manage sections button
        manageScheduleButton.setBounds(20, 100, 200, 50);
        manageScheduleButton.setFocusable(false);
        manageScheduleButton.addActionListener(e -> {
            //new AdminViewDoctorsPage(this, doctor);
            this.setVisible(false);
        });
        this.add(manageScheduleButton);

        // Set up edit section button
        editDoctorButton.setBounds(220, 300, 150, 50);
        editDoctorButton.setFocusable(false);
        editDoctorButton.addActionListener( e -> {
            JOptionPane.showMessageDialog(frame, editDoctor, "Edit Hospital Details", JOptionPane.PLAIN_MESSAGE);
            doctor.setName(d_name.getText());
        });
        this.add(editDoctorButton);

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
