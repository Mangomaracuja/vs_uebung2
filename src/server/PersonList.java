package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PersonList extends Remote {
    /**
     * Liefert die Personenliste in einer ArrayList.
     * Diese Interface wird sowohl vom server
     * als auch vom client angesprochen
     */
    ArrayList<String> getPersonList() throws RemoteException;
}
