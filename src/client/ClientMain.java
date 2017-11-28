package client;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClientMain {

    /**
     * enthält programmlogik
     * todo: kommentar spezifizieren wenn logik vorhanden
     */
    private void start() {
        clientMenue();
    }

    private void clientMenue() {
        String beenden = "q";
        Boolean notQuit = true;
        ArrayList<String> namen = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (notQuit) {
            System.out.println("=====================");
            System.out.println("Bitte Namen eingeben:\nTrennung durch ';'  \nq zum Beenden");
            System.out.println("=====================");
            System.out.print("-->");
            String test = scanner.next();
            if (test.equals(beenden)) break;
            StringTokenizer tokenizer = new StringTokenizer(test, ";");
            while (tokenizer.hasMoreTokens()) {
                namen.add(tokenizer.nextToken(";"));
            }
            serverUebergabe(namen);
            namen.clear();
        }
    }

    private void serverUebergabe(ArrayList<String> namen) {
        ArrayList<ArrayList<String>> personList = PersonListLocal.getInstance().getPersonList(namen);
        for (ArrayList<String> person : personList) {
            if (person.isEmpty()) {
                System.out.println("Name nicht vorhanden!");
            }
            int i = 1;
            for (String name : person) {

                System.out.println(i + ". " + name);
                i++;
            }
            System.out.println();
        }
    }

    /**
     * Main legt beim Programmstart ein Objekt von sich selbst an und für die start Methode aus mit eigentlicher logik
     *
     * @param args
     */
    public static void main(String[] args) {
        new ClientMain().start();
    }
}
