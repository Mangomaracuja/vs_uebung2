package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
        try {
            FileReader fr = new FileReader("C:\\Users\\Manuel\\Documents\\vs\\vs_uebung2\\src\\server\\Namen.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            do {
                line = br.readLine();
                addPerson(line);
            } while (line != null);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(personList);
    }

    private void addPerson(String line){
        if(line == null) return;
        StringTokenizer tokenizer = new StringTokenizer(line,";");
        Person p = new Person(tokenizer.nextToken(";"),tokenizer.nextToken(";"));
        personList.add(p);
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
