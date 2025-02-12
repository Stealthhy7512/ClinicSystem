package Main;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CRS crs = new CRS();
//        crs.loadTablesToDisk("C://Users/kaany/Desktop/Java/ClinicSystem/load.ser");
//        for (Hospital hospital : crs.getHospitals().values()) {
//            System.out.println("hospital " + hospital);
//        }
        System.out.println(crs.getPatients());
        Doctor d1 = new Doctor("kaan", 123, 456);
        Doctor d2 = new Doctor("kaan", 789, 465);


        Section s1 = new Section(1, "S1");
        s1.addDoctor(d1);
        s1.addDoctor(d2);

        Section s2 = new Section(2, "S2");
//        Main.Section falseSec = new Main.Section(1, "S3");

        Hospital h1 = new Hospital(1, "L'Hopital");
        crs.addHospital(h1);


        h1.addSection(s1);
        h1.addSection(s2);


        //System.out.println(h1.getSection(1));
        //System.out.println(h1.getSection("S2"));

        //h1.listSections();

        Schedule sch1 = new Schedule(3);
        sch1.setDoctor(d1);

        Patient p1 = new Patient("patient1", 12345);
        crs.addPatient(p1);

        System.out.println(sch1.getDoctor());
        System.out.println(d1.getSchedule());


        sch1.addRendezvous(p1, new Date(2024, 11, 20));
        sch1.addRendezvous(p1, new Date(2024, 11, 21));
        sch1.addRendezvous(p1, new Date(2024, 11, 20));
        sch1.addRendezvous(p1, new Date(2024, 11, 20));
        sch1.addRendezvous(p1, new Date(2024, 11, 20));

        for (Rendezvous rendezvous : sch1.getSessions()) {
            crs.addRendezvous(rendezvous);
        }
        crs.saveTablesToDisk("C://Users/kaany/Desktop/Java/ClinicSystem/load.ser");

        sch1.listSessions();

        System.out.println(sch1.countSessionsForDay(new Date(2024, 11, 20)));
    }
}
