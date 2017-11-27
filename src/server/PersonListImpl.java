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
        //todo: hier die Personenliste füllen, gegebenfalls aus einer Datei einlesen, wenn dann Doc-Kommentar anpassen
        Collections.sort(personList);
    }

    /**
     * Implementierung des "PersonListInterface"
     * Clientanfragen greifen über das Interface auf
     * diese (entfernte) Methode zu
     */
    @Override
    public ArrayList<String> getPersonsByName(String name) throws RemoteException {
        ArrayList<String> resultList = new ArrayList<>();

        //todo: resultList mit der Methode Person.toString() mit übereinstimmenden Nachnamen füllen. Wenn keine übereinstimmung -> return leere liste;

        return resultList;
    }
}
