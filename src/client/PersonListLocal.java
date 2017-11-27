package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import server.PersonList;

public class PersonListLocal {
    private static PersonListLocal instance;
    private PersonList personList;

    /**
     * mit Hilfe des Singleton Muster kann nur eine Instanz dieser Klasse erzeugt werden.
     */
    public static PersonListLocal getInstance() {
        if (instance == null) {
            instance = new PersonListLocal();
        }
        return instance;
    }

    /**
     * Standard Konstruktor der Die registry abfrägt und eine referenz auf die auf dem Server befindliche
     * PersonList in die Klassenintere schreibt.
     */
    private PersonListLocal() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);

            personList = (PersonList) registry.lookup("PersonList");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Liefert die auf dem server befindliche Personenliste
     */
    public ArrayList<String> getPersonList(String name) {
        if (instance != null) {
            try {
                // über das Interface wird die Personenliste von dem server geladen
                return personList.getPersonsByName(name);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
