package server;

import exceptions.NotComparebleException;

public class Person implements Comparable{
    private String name;
    private String vorname;

    /**
     * erzeugt neues Objekt Person mit vollständigem Namen
     *
     * @param name Nachname der Person
     * @param vorname Vorname der Person
     */
    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    /**
     * Vergleicht das Objekt mit einem übergebenen Objekt und liefert ein Integer zurück
     *
     * @param o das zu vergleichende Objekt
     * @return vergleichs Ergebnis, -1, 0, 1 wenn Objekt kleiner, gleich oder großer als o
     * @throws NotComparebleException wenn nicht verglichen werden kann
     */
    @Override
    public int compareTo(Object o) throws NotComparebleException{
        if (!(o instanceof Person)) throw new NotComparebleException(NotComparebleException.MESSAGE_1);
        Person p = (Person) o;
        if (name.compareTo(p.getName())<0)return -1;
        else if (name.compareTo(p.getName())>0)return 1;
        else return vorname.compareTo(p.getVorname());
    }

    @Override
    public String toString() {
        return String.format("%s %s", vorname, name);
    }
}
