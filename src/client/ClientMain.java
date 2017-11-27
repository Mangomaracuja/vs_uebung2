package client;

import java.util.ArrayList;

public class ClientMain {

    /**
     * enthält programmlogik
     * todo: kommentar spezifizieren wenn logik vorhanden
     */
    private void start(){
        //todo: Kleines Konsolenprogramm um Nachnamen einzugeben und mit diesen vom server die ergebnisse abzufragen.

        String name = "testname";
        // wir holen uns die (lokale) Personenliste
        ArrayList<String> personList = PersonListLocal.getInstance().getPersonList(name);
        //todo: null abfangen wenn keine instanz existiert -- leere liste wenn keine übereinstimmung (kann theoretisch nicht vorkommen, muss dennoch abgefangen werden)

        // es werden alle Personen ausgegeben
        for (String person : personList) {
            System.out.println(person);
        }
    }

    /**
     * Main legt beim Programmstart ein Objekt von sich selbst an und für die start Methode aus mit eigentlicher logik
     * @param args
     */
    public static void main(String[] args) {
        new ClientMain().start();
    }
}
