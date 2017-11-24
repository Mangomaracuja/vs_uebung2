package server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    /**
     * Registriert den server mit dem ihn
     * bekannten öffentlichen Methoden
     */
    private static void createServer() {
        try {
            // Namensdienst (Registry) mit dem Standardport 1099 registrieren
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("server : Registry wurde erzeugt.");

            // Personenliste wird in der Registry unter
            // dem eindeutigen Namen "PersonList" angemeldet
            Naming.rebind("PersonList", new PersonListImpl());
            System.out.println("server : Personenliste registriert");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createServer();
    }
}
