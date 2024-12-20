public class Person {
    private String name;
    private final long nationalId;

    public Person(String name, long nationalId) {
        this.name = name;
        this.nationalId = nationalId;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | ID: " + nationalId;
    }
}
