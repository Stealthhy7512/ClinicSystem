package GUI;

import Main.*;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientRendezvousPage extends JFrame {
    private JLabel sectionLabel = new JLabel("Choose section");
    private JComboBox sectionBox = new JComboBox();

    private JLabel hospitalLabel = new JLabel("Choose hospital");
    private JComboBox hospitalBox = new JComboBox();

    private JLabel doctorLabel = new JLabel("Choose doctor");
    private JComboBox doctorBox = new JComboBox();

    JPanel addRendezvous = new JPanel(new BorderLayout(5, 5));
    JPanel addRendezvousLabel = new JPanel(new GridLayout(0, 1, 2, 2));

    private JButton addButton = new JButton("Add Rendezvous");

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

        // Set up add rendezvous panel
        addRendezvousLabel.add(new JLabel("Patient National ID", SwingConstants.RIGHT));
        addRendezvousLabel.add(new JLabel("Patient Name", SwingConstants.RIGHT));
        addRendezvousLabel.add(new JLabel("Desired Date", SwingConstants.RIGHT));
        addRendezvous.add(addRendezvousLabel, BorderLayout.WEST);

        JPanel editControls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField p_id = new JTextField();
        //h_id.setText(String.valueOf(hospital.getId()));
        editControls.add(p_id);
        //h_id.setEditable(false);
        JTextField p_name = new JTextField();
        //h_name.setText(hospital.getName());
        editControls.add(p_name);
        JTextField date = new JTextField();
        editControls.add(date);
        addRendezvous.add(editControls, BorderLayout.CENTER);

        sectionLabel.setBounds(20, 30, 100, 20);
        sectionBox.setBounds(20, 50, 250, 30);
        sectionBox.addActionListener(e -> {
            hospitalBox.removeAllItems();
            hospitalBox.addItem(null);
            hospitalBox.setEnabled(false);
            if (sectionBox.getSelectedItem() != null) {
                hospitalBox.setEnabled(true);
//                for (Hospital hospital : crs.getHospitals().values()) {
//                    if (hospital.getSection((String)sectionBox.getSelectedItem()) != null) {
//                        hospitalBox.addItem(hospital.getName() + " (" + hospital.getId() + ")");
//                    }
//                }
                String selectedSection = (String)sectionBox.getSelectedItem();
                for (Hospital hospital : crs.getHospitals().values()) {
                    if (hospital.getSection(selectedSection) != null) {
                        hospitalBox.addItem(hospital.getName() + " (" + hospital.getId() + ")");
                    }
                }
            }
        });
        this.add(sectionLabel);
        this.add(sectionBox);

        hospitalLabel.setBounds(20, 120, 100, 20);
        hospitalBox.setBounds(20, 140, 250, 30);
        hospitalBox.setEnabled(false);
        hospitalBox.addItem(null);
        hospitalBox.addActionListener(e -> {
            doctorBox.removeAllItems();
            doctorBox.addItem(null);
            doctorBox.setEnabled(false);
            if (hospitalBox.getSelectedItem() != null) {
                doctorBox.setEnabled(true);
                String hospitalBoxSelect = (String)hospitalBox.getSelectedItem();
                int hospitalBoxSelected = Integer.parseInt(hospitalBoxSelect.substring(hospitalBoxSelect.indexOf("(")+1, hospitalBoxSelect.indexOf(")")));
                Hospital hospital = crs.getHospitals().get(hospitalBoxSelected);

                Section section = hospital.getSection((String)sectionBox.getSelectedItem());
                for (Doctor doctor : section.getDoctorLinkedList()) {
                    doctorBox.addItem(doctor.getName() + " (" + doctor.getDiplomaId() + ")");
                }
//                for (Hospital hospital : crs.getHospitals().values()) {
//                    for (int i = 0; i < hospitalBox.getItemCount(); ++i) {
//                        if (hospitalBox.getItemAt(i) != null && hospital.getName().equals(hospitalBox.getItemAt(i))) {
//                            for (Section section : hospital.getSectionLinkedList()) {
//                                for (int j = 0; j < sectionBox.getItemCount(); ++j) {
//                                    if (sectionBox.getItemAt(j) != null) {
//                                        for (Doctor doctor : section.getDoctorLinkedList()) {
//                                            boolean exists = false;
//                                            for (int k = 0; k < doctorBox.getItemCount(); ++k) {
//                                                if (doctorBox.getItemAt(i) != null && doctorBox.getItemAt(i).equals(doctor.getName())) {
//                                                    exists = true;
//                                                    break;
//                                                }
//                                            }
//                                            if (!exists) {
//                                                doctorBox.addItem(doctor.getName() + " (" + doctor.getDiplomaId() + ")");
//                                            }
//                                        }
//                                        break;
//                                    }
//                                }
//                            }
//                            break;
//                        }
//                    }
//
//                }
            }
        });

        this.add(hospitalLabel);
        this.add(hospitalBox);

        doctorLabel.setBounds(20, 210, 100, 20);
        doctorBox.setBounds(20, 230, 250, 30);
        doctorBox.setEnabled(false);
        doctorBox.addItem(null);
        doctorBox.addActionListener(e -> {
            addButton.setEnabled(false);
            if (doctorBox.getSelectedItem() != null) {
                addButton.setEnabled(true);
            }

        });
        this.add(doctorLabel);
        this.add(doctorBox);

        // Set up add rendezvous button
        addButton.setBounds(210, 300, 150, 50);
        addButton.setFocusable(false);
        addButton.setEnabled(false);
        addButton.addActionListener(e -> {
            String hospitalBoxSelect = (String)hospitalBox.getSelectedItem();
            int hospitalBoxSelected = Integer.parseInt(hospitalBoxSelect.substring(hospitalBoxSelect.indexOf("(")+1, hospitalBoxSelect.indexOf(")")));
            Hospital hospital = crs.getHospitals().get(hospitalBoxSelected);

            Section section = hospital.getSection((String)sectionBox.getSelectedItem());

            String doctorBoxSelect = (String)doctorBox.getSelectedItem();
            int doctorBoxSelected = Integer.parseInt(doctorBoxSelect.substring(doctorBoxSelect.indexOf("(")+1, doctorBoxSelect.indexOf(")")));
            Doctor doctor = section.getDoctor(doctorBoxSelected);
            JOptionPane.showMessageDialog(frame, addRendezvous, "Add Rendezvous Details", JOptionPane.PLAIN_MESSAGE);
            try {
                if (!doctor.getSchedule().addRendezvous(new Patient(p_name.getText(), Long.parseLong(p_id.getText())),
                        new SimpleDateFormat("dd/MM/yyyy").parse(date.getText()))) ;
                {
                    JOptionPane.showMessageDialog(frame, "Doctor is full.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException err) {
                err.getMessage();
            }
        });
        this.add(addButton);

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
