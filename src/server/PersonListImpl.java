package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PersonListImpl extends UnicastRemoteObject implements PersonList {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Standardkonstruktor muss vorhanden sein
    public PersonListImpl() throws RemoteException {
    }

    /**
     * Implementierung des "PersonListInterface"
     * Clientanfragen greifen über das Interface auf
     * diese (entfernte) Methode zu
     */
    @Override
    public ArrayList<String> getPersonList() throws RemoteException {
        ArrayList<String> personList = new ArrayList<>();

        personList.add("Simon Michel");
        personList.add("Peter Pan");
        personList.add("Pippi Langstrumpf");

        return personList;
    }


}
