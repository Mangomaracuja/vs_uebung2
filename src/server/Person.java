package server;

public class Person {
    private String name;
    private String vorname;

    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public Person() {
        this(null, null);
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }
}
