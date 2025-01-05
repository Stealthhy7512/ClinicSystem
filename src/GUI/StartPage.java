package GUI;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Main.*;

public class StartPage extends JFrame {

    JButton patientButton = new JButton();
    JButton adminButton = new JButton();
    CRS crs = new CRS();

    public StartPage() {
        crs.loadTablesToDisk("C://Users/kaany/Desktop/Java/ClinicSystem/load.ser");
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

        patientButton.setText("Patient");
        patientButton.setBounds(25, 150, 150, 50);
        patientButton.setFocusable(false);
        patientButton.addActionListener((e) -> {
            new ClientRendezvousPage(this, crs);
            this.setVisible(false);
        });
        this.add(patientButton);

        adminButton.setText("Administrator");
        adminButton.setBounds(185, 150, 150, 50);
        adminButton.setFocusable(false);
        adminButton.addActionListener((e) -> {
            new AdminHospitalPage(this, crs);
            this.setVisible(false);
        });
        this.add(adminButton);

        // Make the frame visible
        this.setVisible(true);
    }


}
