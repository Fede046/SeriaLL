import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestioneClienti {
    private static final String FILE_NAME = "clienti.ser";
    private List<Cliente> clienti;

    public GestioneClienti() {
        this.clienti = new ArrayList<>();
    }

    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }
    //serializzando
    public void salvaClienti() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(clienti);
            System.out.println("Clienti salvati con successo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //deserializzando
    public void caricaClienti() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            clienti = (List<Cliente>) ois.readObject();
            System.out.println("Clienti caricati con successo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stampaClienti() {
        for (Cliente cliente : clienti) {
            System.out.println(cliente);
        }
    }

    public static void main(String[] args) {
        GestioneClienti gestioneClienti = new GestioneClienti();

        // Aggiunta di nuovi clienti
        gestioneClienti.aggiungiCliente(new Cliente("Mario Rossi", 40, "Via Roma 1"));
        gestioneClienti.aggiungiCliente(new Cliente("Luigi Bianchi", 35, "Via Milano 2"));

        // Salvataggio clienti su disco
        gestioneClienti.salvaClienti();

        // Caricamento clienti da disco
        gestioneClienti.caricaClienti();

        // Stampa dei clienti
        gestioneClienti.stampaClienti();
    }
}

