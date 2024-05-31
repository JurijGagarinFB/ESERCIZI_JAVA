import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static Tools.Utility.*;

/**
 * Classe principale per la gestione di un'applicazione di rubrica telefonica.
 * Questo programma consente all'utente di aggiungere, visualizzare, verificare,
 * eliminare e chiamare contatti, visualizzare la cronologia delle chiamate
 * e svolgere attività amministrative.
 */
public class Main {

    /**
     * Metodo principale per eseguire l'applicazione della rubrica telefonica.
     *
     * @param args argomenti da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        final int nContatti = 5; // Numero massimo di contatti
        Scanner tastiera = new Scanner(System.in); // Scanner per l'input da tastiera
        Contatto[] gestore = new Contatto[nContatti]; // Array di contatti
        String[] opzioni = {
                "Rubrica Telefonica", "1 - Inserimento", "2 - Visualizza",
                "3 - Verifica presenza contatto", "4 - Elimina Contatto",
                "5 - Chiama Contatto", "6 - Cronologia Chiamate",
                "7 - Impostazioni Amministratore", "8 - Salva su file",
                "9 - Carica da file", "10 - Fine"
        };

        boolean fine = false; // Variabile per controllare la fine del programma
        int trovato; // Variabile per tenere traccia del contatto trovato
        String password = "admin"; // Password dell'amministratore
        boolean utenteAmministratore = false, cambioNascosti = false; // Variabili di stato

        String[] admin = {
                "Impostazioni Amministratore", "1 - Login Amministratore",
                "2 - Logout Amministratore", "3 - Cambia Password",
                "4 - Visualizza contatti nascosti", "5 - Cambia contatti nascosti",
                "6 - Esci dalle Impostazioni"
        };
        int contaContatti = 0; // Contatore per il numero di contatti
        Contatto[] cronologia = new Contatto[9999]; // Array per la cronologia delle chiamate
        int numeroChiamateEffettuate = 0; // Contatore per il numero di chiamate effettuate

        do {
            switch (menu(opzioni, tastiera)) { // Menu principale
                case 1 -> { // Inserimento contatto
                    if (nContatti > contaContatti) { // Verifica se c'è spazio per nuovi contatti
                        boolean presente = false; // Variabile per controllare se il contatto è già presente
                        Contatto dettagli = LeggiContatto(tastiera); // Legge i dettagli del contatto
                        for (int i = 0; i < contaContatti; i++) {
                            if (dettagli.nome.equals(gestore[i].nome) && dettagli.numTelefono.equals(gestore[i].numTelefono)) {
                                System.out.println("La persona con questo nome e numero di telefono è già presente!");
                                presente = true;
                                break;
                            }
                        }
                        if (!presente) { // Se il contatto non è presente, aggiungilo all'array
                            gestore[contaContatti] = dettagli;
                            contaContatti++;
                        }
                    } else {
                        System.out.println("Finiti contatti"); // Se l'array è pieno, stampa un messaggio
                    }
                }
                case 2 -> { // Visualizza contatti
                    if (contaContatti > 0) { // Verifica se ci sono contatti da visualizzare
                        Visualizza(gestore, contaContatti); // Visualizza i contatti
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare");
                    }
                }
                case 3 -> { // Verifica presenza contatto
                    if (contaContatti > 0) { // Verifica se ci sono contatti
                        if (verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti) != -1) {
                            System.out.println("Contatto presente");
                        } else {
                            System.out.println("Contatto non presente");
                            System.out.println("Aggiunta del nuovo contatto...");
                            gestore[contaContatti] = LeggiContatto(tastiera); // Legge e aggiunge il nuovo contatto
                            contaContatti++;
                            System.out.println("Contatto aggiunto con successo.");
                        }
                    } else {
                        System.out.println("Non ci sono contatti");
                    }
                }
                case 4 -> { // Elimina contatto
                    System.out.println("Quale contatto vuoi eliminare?");
                    trovato = verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti);
                    if (trovato != -1) {
                        gestore = eliminaContatto(gestore, contaContatti, trovato); // Elimina il contatto
                        contaContatti--;
                    } else {
                        System.out.println("Contatto non trovato!");
                    }
                }
                case 5 -> { // Chiama contatto
                    System.out.println("Quale contatto vuoi chiamare?");
                    trovato = verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti);
                    if (trovato != -1) {
                        gestore[trovato].numChiamate++;
                        System.out.println("Chiamata effettuata");
                        cronologia[numeroChiamateEffettuate] = gestore[trovato]; // Aggiunge il contatto alla cronologia delle chiamate
                        numeroChiamateEffettuate++;
                    } else {
                        System.out.println("Contatto non trovato");
                    }
                }
                case 6 -> { // Visualizza cronologia chiamate
                    System.out.println("Visualizzazione cronologia chiamate");
                    for (int i = numeroChiamateEffettuate - 1; i >= 0; i--) {
                        if (cronologia[i] != null && !cronologia[i].nascosto) {
                            System.out.println(cronologia[i].anagrafica());
                        }
                    }
                }
                case 7 -> { // Impostazioni amministratore
                    boolean fineAmministratore = false, nuovaPasswordOk;
                    String inserimentoPassword, controlloNuovaPassword;
                    do {
                        switch (menu(admin, tastiera)) {
                            case 1 -> {
                                System.out.println("Login Amministratore");
                                if (!utenteAmministratore) { // Se non è già loggato come amministratore
                                    System.out.println("Inserisci la password: ");
                                    inserimentoPassword = tastiera.nextLine();
                                    if (inserimentoPassword.equals(password)) {
                                        System.out.println("Accesso Confermato");
                                        utenteAmministratore = true;
                                    } else {
                                        System.out.println("Password Errata");
                                    }
                                } else {
                                    System.out.println("Hai già fatto il login!");
                                }
                            }
                            case 2 -> {
                                System.out.println("Logout Amministratore");
                                utenteAmministratore = false;
                                System.out.println("Logout Effettuato");
                            }
                            case 3 -> {
                                System.out.println("Cambio Password");
                                System.out.println("Inserire la password corrente (default 'admin'): ");
                                inserimentoPassword = tastiera.nextLine();
                                if (inserimentoPassword.equals(password)) {
                                    do {
                                        nuovaPasswordOk = false;
                                        System.out.println("Inserire la nuova password: ");
                                        inserimentoPassword = tastiera.nextLine();
                                        controlloNuovaPassword = inserimentoPassword;
                                        System.out.println("Reinserire la nuova password: ");
                                        inserimentoPassword = tastiera.nextLine();
                                        if (inserimentoPassword.equals(controlloNuovaPassword)) {
                                            password = inserimentoPassword;
                                            System.out.println("Password cambiata con successo!");
                                            nuovaPasswordOk = true;
                                        } else {
                                            System.out.println("La password non corrisponde, riprovare!");
                                        }
                                    } while (!nuovaPasswordOk);
                                } else {
                                    System.out.println("La password non corrisponde");
                                }
                            }
                            case 4 -> {
                                System.out.println("Visualizzazione contatti nascosti");
                                if (utenteAmministratore) {
                                    for (int i = 0; i < contaContatti; i++) {
                                        if (gestore[i].nascosto) {
                                            System.out.println(gestore[i].anagrafica());
                                        }
                                    }
                                } else {
                                    System.out.println("Non sei un amministratore!");
                                }
                            }
                            case 5 -> {
                                System.out.println("Cambio contatti nascosti");
                                if (utenteAmministratore) {
                                    cambioNascosti = true;
                                    trovato = verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti);
                                    if (trovato != -1) {
                                        gestore[trovato].nascosto = !gestore[trovato].nascosto;
                                        System.out.println("Aggiornato status visibilità");
                                    } else {
                                        System.out.println("Contatto non trovato");
                                    }
                                } else {
                                    System.out.println("Non sei un amministratore!");
                                }
                            }
                            case 6 -> {
                                System.out.println("Uscita impostazioni");
                                fineAmministratore = true;
                            }
                        }
                    } while (!fineAmministratore);
                }
                case 8 -> { // Salva su file
                    try {
                        scriviFile("Archivio.csv", gestore, contaContatti); // Scrive i contatti su file
                    } catch (IOException x) {
                        System.out.println("Errore: " + x.toString());
                    }
                    System.out.println("Scrittura fatta");
                }
                case 9 -> { // Carica da file
                    try {
                        contaContatti = leggiFile("Archivio.csv", gestore); // Legge i contatti da file
                    } catch (IOException x) {
                        System.out.println("Errore: " + x.toString());
                    }
                    System.out.println("Lettura fatta");
                }
                case 10 -> fine = true; // Termina il programma
            }
        } while (!fine);
        System.out.println("Fine programma");
    }

    /**
     * Metodo per leggere i dettagli di un contatto.
     *
     * @param tastiera Scanner per leggere l'input da tastiera
     * @return il contatto creato
     */
    public static Contatto LeggiContatto(Scanner tastiera) {
        Contatto contatto = new Contatto();

        System.out.println("Inserisci il nome");
        contatto.nome = tastiera.nextLine();
        System.out.println("Inserisci il numero di telefono");
        contatto.numTelefono = tastiera.nextLine();

        return contatto;
    }

    /**
     * Metodo per visualizzare i contatti presenti.
     *
     * @param gestore array di contatti
     * @param contaContatti numero di contatti presenti
     */
    public static void Visualizza(Contatto[] gestore, int contaContatti) {
        for (int i = 0; i < contaContatti; i++) {
            if (!gestore[i].nascosto) {
                System.out.println(gestore[i].anagrafica());
            }
        }
    }

    /**
     * Metodo per verificare la presenza di un contatto.
     *
     * @param tastiera Scanner per leggere l'input da tastiera
     * @param gestore array di contatti
     * @param contaContatti numero di contatti presenti
     * @param cambioNascosti flag per considerare i contatti nascosti
     * @return indice del contatto se presente, -1 altrimenti
     */
    public static int verificaPresenzaContatto(Scanner tastiera, Contatto[] gestore, int contaContatti, boolean cambioNascosti) {
        System.out.println("Inserisci il nome");
        String nome = tastiera.nextLine();
        System.out.println("Inserisci il numero di telefono");
        String numTelefono = tastiera.nextLine();

        for (int i = 0; i < contaContatti; i++) {
            if (!cambioNascosti) { // Verifica contatti visibili
                if (gestore[i].nome.equals(nome) && gestore[i].numTelefono.equals(numTelefono) && !gestore[i].nascosto) {
                    return i;
                }
            } else { // Verifica tutti i contatti, compresi quelli nascosti
                if (gestore[i].nome.equals(nome) && gestore[i].numTelefono.equals(numTelefono)) {
                    return i;
                }
            }
        }
        return -1; // Contatto non presente
    }

    /**
     * Metodo per eliminare un contatto.
     *
     * @param gestore array di contatti
     * @param contaContatti numero di contatti presenti
     * @param trovato indice del contatto da eliminare
     * @return array di contatti aggiornato
     */
    public static Contatto[] eliminaContatto(Contatto[] gestore, int contaContatti, int trovato) {
        if (trovato != -1) {
            for (int i = trovato; i < contaContatti - 1; i++) {
                gestore[i] = gestore[i + 1];
            }
            gestore[contaContatti - 1] = null; // Elimina l'ultimo contatto
        } else {
            System.out.println("Contatto non trovato!");
        }
        return gestore;
    }

    /**
     * Metodo per scrivere i contatti su un file.
     *
     * @param nomeFile nome del file su cui scrivere
     * @param persone array di contatti
     * @param nContatti numero di contatti presenti
     * @throws IOException eccezione di input/output
     */
    public static void scriviFile(String nomeFile, Contatto[] persone, int nContatti) throws IOException {
        FileWriter scrittore = new FileWriter(nomeFile); // Crea un FileWriter per scrivere i dati su file
        for (int i = 0; i < nContatti; i++) {
            scrittore.write(persone[i].toString() + "\r\n"); // Scrive i contatti su file, ogni contatto su una nuova riga
        }
        scrittore.flush(); // Assicura che tutti i dati siano scritti su file
        scrittore.close(); // Chiude il FileWriter
    }

    /**
     * Metodo per leggere i contatti da un file.
     *
     * @param nomeFile nome del file da cui leggere
     * @param persone array di contatti
     * @return numero aggiornato di contatti presenti
     * @throws IOException eccezione di input/output
     */
    public static int leggiFile(String nomeFile, Contatto[] persone) throws IOException {
        FileReader lettore = new FileReader(nomeFile); // Crea un FileReader per leggere i dati dal file
        Scanner tastiera = new Scanner(lettore); // Utilizza Scanner per leggere il contenuto del file
        String[] dati;
        int contaLinee = 0;
        while (tastiera.hasNextLine() && contaLinee < persone.length) { // Continua a leggere finché ci sono righe nel file e l'array non è pieno
            dati = tastiera.nextLine().split(","); // Divide la riga letta in campi utilizzando la virgola come delimitatore
            Contatto p = new Contatto();
            p.nome = dati[0];
            p.numTelefono = dati[1];
            p.numChiamate = Integer.parseInt(dati[2]);
            p.nascosto = Boolean.parseBoolean(dati[3]);
            persone[contaLinee] = p; // Aggiunge il contatto all'array
            contaLinee++;
        }
        return contaLinee; // Restituisce il numero aggiornato di contatti presenti
    }
}
