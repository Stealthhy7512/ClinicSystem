public class Person {
    private String name;
    private final long nationalId;

    public Person(String name, long nationalId) {
        this.name = name;
        this.nationalId = nationalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getNationalId() {
        return nationalId;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | ID: " + nationalId;
    }
}
