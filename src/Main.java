import java.util.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("kaan", 123, 456);
        Doctor d2 = new Doctor("kaan", 789, 465);

        Section s1 = new Section(1, "S1");
        s1.addDoctor(d1);
        s1.addDoctor(d2);

        Section s2 = new Section(2, "S2");
        Section falseSec = new Section(1, "S3");

        Hospital h1 = new Hospital(1, "L'Hopital");

        h1.addSection(s1);
        h1.addSection(s2);

        System.out.println(h1.getSection(1));
        System.out.println(h1.getSection("S2"));

        h1.listSections();
    }
}
