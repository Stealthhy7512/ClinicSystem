package GUI;

import javax.swing.*;
import java.awt.*;
import Main.*;

public class AdminSectionPage extends JFrame {

    JButton addSectionButton = new JButton("Add Section");
    JButton manageSectionsButton = new JButton("Manage Sections");

    JButton editHospitalButton = new JButton("Edit Hospital Details");
    JButton back = new JButton("Back");


    JPanel addSection = new JPanel(new BorderLayout(5, 5));
    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));

    JPanel editHospital = new JPanel(new BorderLayout(5, 5));
    JPanel editHospitalLabel = new JPanel(new GridLayout(0, 1, 2, 2));


    public AdminSectionPage(JFrame frame, Hospital hospital) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //this.setLayout(new BorderLayout()); // Use BorderLayout for simplicity
        this.setTitle("Hospital " + hospital.getName() + " (" + hospital.getId() + ")");
        this.setLayout(null);

        // Set up add section panel
        label.add(new JLabel("ID", SwingConstants.RIGHT));
        label.add(new JLabel("Name", SwingConstants.RIGHT));
        addSection.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField id = new JTextField();
        controls.add(id);
        JTextField name = new JTextField();
        controls.add(name);
        addSection.add(controls, BorderLayout.CENTER);
        
        // Set up edit hospital panel
        editHospitalLabel.add(new JLabel("ID", SwingConstants.RIGHT));
        editHospitalLabel.add(new JLabel("Name", SwingConstants.RIGHT));
        editHospital.add(editHospitalLabel, BorderLayout.WEST);

        JPanel editControls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField h_id = new JTextField();
        h_id.setText(String.valueOf(hospital.getId()));
        editControls.add(h_id);
        h_id.setEditable(false);
        JTextField h_name = new JTextField();
        h_name.setText(hospital.getName());
        editControls.add(h_name);
        editHospital.add(editControls, BorderLayout.CENTER);

        // Set up add sections button
        addSectionButton.setBounds(20, 25, 200, 50);
        addSectionButton.setFocusable(false);
        addSectionButton.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(frame, addSection, "Add Section", JOptionPane.PLAIN_MESSAGE);
                if (!id.getText().isEmpty() && !name.getText().isEmpty()) {
                    hospital.addSection(new Section(Integer.parseInt(id.getText()), name.getText()));
                }
            } catch (DuplicateInfoException DuplicateInfoError) {
                JOptionPane.showMessageDialog(frame, "Section already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
        this.add(addSectionButton);

        // Set up manage sections button
        manageSectionsButton.setBounds(20, 100, 200, 50);
        manageSectionsButton.setFocusable(false);
        manageSectionsButton.addActionListener(e -> {
            new AdminViewSectionsPage(this, hospital);
            this.setVisible(false);
        });
        this.add(manageSectionsButton);

        // Set up edit section button
        editHospitalButton.setBounds(220, 300, 150, 50);
        editHospitalButton.setFocusable(false);
        editHospitalButton.addActionListener( e -> {
            JOptionPane.showMessageDialog(frame, editHospital, "Edit Hospital Details", JOptionPane.PLAIN_MESSAGE);
            hospital.setName(h_name.getText());
        });
        this.add(editHospitalButton);

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
