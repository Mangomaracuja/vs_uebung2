package server;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    /**
     * Registriert den server mit dem ihn
     * bekannten öffentlichen Methoden
     */
    private void createServer() {
        try {
            // Namensdienst (Registry) mit dem Standardport 1099 registrieren
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("server : Registry wurde erzeugt.");

            registry.bind("PersonList", new PersonListImpl());
            System.out.println("server : Personenliste registriert");

        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main legt beim Programmstart ein Objekt von sich selbst an und für die createServer Methode aus mit eigentlicher logik
     *
     * @param args
     */
    public static void main(String[] args) {
        new ServerMain().createServer();
    }
}
