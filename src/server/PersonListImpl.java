package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;

public class PersonListImpl extends UnicastRemoteObject implements PersonList {

    private ArrayList<Person> personList;

    /**
     * Strandart Konstruktor der die PerosonListe füllt und sortiert
     * @throws RemoteException
     */
    public PersonListImpl() throws RemoteException {
        personList = new ArrayList<>();
        fillPersonList();
    }

    /**
     * füllen der PersonenListe
     */
    private void fillPersonList() {
        personList.add(new Person("Dung", "Kanuel"));
        personList.add(new Person("Stolz", "Manuel"));
        personList.add(new Person("Stolz", "Alexander"));
        personList.add(new Person("WirdWirth", "WerNixWird"));
        personList.add(new Person("Triem", "Simon"));
        personList.add(new Person("Triem", "Simone"));
        personList.add(new Person("Triem", "Nadia"));
        personList.add(new Person("Wirth", "Chris"));
        Collections.sort(personList);
    }

    /**
     * Implementierung des "PersonListInterface"
     * Clientanfragen greifen über das Interface auf
     * diese (entfernte) Methode zu
     */
    @Override
    public ArrayList<ArrayList<String>> getPersonsByName(ArrayList<String> namen) throws RemoteException {
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();

        for (String name : namen) {
            ArrayList<String> resultNames = new ArrayList<>();
            for (Person p : personList) {
                if (p.getName().equals(name)) resultNames.add(p.toString());
            }
            resultList.add(resultNames);
        }

        return resultList;
    }
}
