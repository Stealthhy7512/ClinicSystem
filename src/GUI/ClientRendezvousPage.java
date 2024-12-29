package GUI;

import Main.*;

import javax.swing.*;
import java.util.LinkedList;

public class ClientRendezvousPage extends JFrame {
    private JLabel sectionLabel = new JLabel("Choose section");
    private JComboBox sectionBox = new JComboBox();

    private JLabel hospitalLabel = new JLabel("Choose hospital");
    private JComboBox hospitalBox = new JComboBox();

    private JLabel doctorLabel = new JLabel("Choose doctor");
    private JComboBox doctorBox = new JComboBox();

    private JButton back = new JButton("Back");

    public ClientRendezvousPage(JFrame frame, CRS crs) {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Create Rendezvous");
        this.setLayout(null);

        sectionBox.addItem(null);
        for (Hospital hospital : crs.getHospitals().values()) {
            for (Section section : hospital.getSectionLinkedList()) {
                boolean exists = false;
                for (int i = 0; i < sectionBox.getItemCount(); ++i) {
                    if (sectionBox.getItemAt(i) != null && sectionBox.getItemAt(i).equals(section.getName())) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    sectionBox.addItem(section.getName());
                }
            }
        }

        sectionLabel.setBounds(20, 30, 100, 20);
        sectionBox.setBounds(20, 50, 250, 30);
        sectionBox.addActionListener(e -> {
            hospitalBox.removeAllItems();
            hospitalBox.setEnabled(false);
            if (sectionBox.getSelectedItem() != null) {
                hospitalBox.setEnabled(true);
                for (Hospital hospital : crs.getHospitals().values()) {
                    if (hospital.getSection((String)sectionBox.getSelectedItem()) != null) {
                        hospitalBox.addItem(hospital.getName());
                    }
                }
            }

        });
        this.add(sectionLabel);
        this.add(sectionBox);

        hospitalLabel.setBounds(20, 120, 100, 20);
        hospitalBox.setBounds(20, 140, 250, 30);
        hospitalBox.setEnabled(false);
        hospitalBox.addActionListener(e -> {
            doctorBox.removeAllItems();
            doctorBox.setEnabled(false);
// TODO fix adding of duplicate doctors
            if (hospitalBox.getSelectedItem() != null) {
                doctorBox.setEnabled(true);
                for (Hospital hospital : crs.getHospitals().values()) {
                    for (int i = 0; i < hospitalBox.getItemCount(); ++i) {
                        if (hospitalBox.getItemAt(i) != null && hospital.getName().equals(hospitalBox.getItemAt(i))) {
                            for (Section section : hospital.getSectionLinkedList()) {
                                for (int j = 0; j < sectionBox.getItemCount(); ++j) {
                                    if (sectionBox.getItemAt(j) != null) {
                                        for (Doctor doctor : section.getDoctorLinkedList()) {
                                            boolean exists = false;
                                            for (int k = 0; k < doctorBox.getItemCount(); ++k) {
                                                if (doctorBox.getItemAt(i) != null && doctorBox.getItemAt(i).equals(doctor.getName())) {
                                                    exists = true;
                                                    break;
                                                }
                                            }
                                            if (!exists) {
                                                doctorBox.addItem(doctor.getName());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        });

        this.add(hospitalLabel);
        this.add(hospitalBox);

        doctorLabel.setBounds(20, 210, 100, 20);
        doctorBox.setBounds(20, 230, 250, 30);
        doctorBox.setEnabled(false);
        this.add(doctorLabel);
        this.add(doctorBox);

        // Set up back button
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
