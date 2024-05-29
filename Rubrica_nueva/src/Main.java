/*
Progettare un software che permetta ad un utente di poter gestire la propria rubrica telefonica, permettendo, tramite l’inserimento di un’apposita password, di visualizzare anche eventuali contatti nascosti.
Un contatto nascosto può essere reso sempre visibile e viceversa.
Gestire la lista delle ultime chiamate, in modo che possa essere coerente con quanto sopra richiesto
*/

/*
* Rispetto a quanto scritto in verifica, ho cambiato l'ordine e il nome di alcune delle opzioni del menù,
  raggruppando anche tutte le opzioni "amministratore" (cioè quelle che hanno a che fare con la password e la visibilità dei contatti)
  in una singola opzione (la quale a sua volta stampa un menù contenente le varie opzioni amministratore), inoltre ho cambiato
  il nome di qualche metodo (ad esempio ControllaContatto ora è verificaPresenzaContatto).
* La parte più differente è la gestione della cronologia e della password.
* In quanto a cronologia, in verifica avevo scritto che avrei messo i nuovi contatti chiamati in prima posizione nell'array della cronologia
  e spostato gli altri precedentemente chiamati di un posto, mentre qui ho semplicemente messo le nuove chiamate all'ultimo posto
  e nella stampa della cronologia stampo dall'ultimo posto (quindi il contatto chiamato più recentemente) al primo (quello meno recente).
* In quanto a password, ho cambiato il rudimentale inserimento della password
  in un login, logout e ho dato la possibilità di cambiare la password (password di default "admin").

* Come richiesto, nella cronologia delle chiamate non vengono mostrate le chiamate effettuate a contatti nascosti.
* */



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Importa la classe Scanner per leggere input da tastiera
import static Tools.Utility.*; // Importa staticamente il metodo menu() dalla classe Utility

public class Main { // Definizione della classe Main
    public static void main(String[] args) { // Metodo principale main()
        final int nContatti = 5; // Definisce il numero massimo di contatti
        Scanner tastiera = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input da tastiera
        Contatto[] gestore = new Contatto[nContatti]; // Crea un array di oggetti Contatto
        String[] opzioni = {"Rubrica Telefonica", "1 - Inserimento", "2 - Visualizza", "3 - Verifica presenza contatto", "4 - Elimina Contatto", "5 - Chiama Contatto", "6 - Cronologia Chiamate", "7 - Impostazioni Amministratore", "8 - Salva su file", "9 - Carica da file", "10 - Fine"}; // Array di stringhe contenente le opzioni del menu

        boolean fine = false; // Variabile booleana per verificare se il programma deve terminare
        int trovato = 0;
        String password = "admin";
        boolean utenteAmministratore = false, cambioNascosti = false;

        String[] admin = {"Impostazioni Amministratore", "1 - Login Amministratore", "2 - Logout Amministratore", "3 - Cambia Password", "4 - Visualizza contatti nascosti", "5 - Cambia contatti nascosti", "6 - Esci dalle Impostazioni"}; // Array di stringhe contenente le opzioni del menu amministratore
        int contaContatti = 0; // Contatore per il numero di contatti presenti nell'array
        Contatto[] cronologia = new Contatto[9999];
        int numeroChiamateEffettuate = 0;

        do { // Ciclo do-while per continuare il menu finché l'utente non decide di terminare
            switch (menu(opzioni, tastiera)) { // Switch statement per gestire le varie opzioni del menu
                case 1 -> { // Se l'utente sceglie 1
                    if (nContatti > contaContatti) { // Verifica se ci sono ancora slot disponibili per i contratti
                        boolean presente = false; // Variabile booleana per verificare se un contatto è già presente
                        Contatto dettagli = LeggiContatto(tastiera); // Legge i dettagli del contatto dall'input
                        for (int i = 0; i < contaContatti; i++) { // Scansione degli attuali contatti per verificare duplicati
                            if (dettagli.nome.equals(gestore[i].nome) && dettagli.numTelefono.equals(gestore[i].numTelefono)) {
                                System.out.println("La persona con questo nome e numero di telefono è già presente!"); // Stampa un messaggio se il contatto è già presente
                                presente = true; // Imposta presente a true
                                break; // Esci dal ciclo for
                            }
                        }
                        if (!presente) { // Se il contatto non è presente, lo aggiunge all'array
                            gestore[contaContatti] = dettagli; // Aggiunge il contatto all'array
                            contaContatti++; // Incrementa il numero di contatti
                        }
                    } else {
                        System.out.println("Finiti contratti"); // Stampa un messaggio se non ci sono più slot disponibili per i contratti
                    }
                }
                case 2 -> { // Se l'utente sceglie 2
                    if (contaContatti > 0) { // Verifica se ci sono contatti da visualizzare
                        Visualizza(gestore, contaContatti); // Chiama il metodo per visualizzare i contatti
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare"); // Stampa un messaggio se non ci sono contatti
                    }
                }
                case 3 -> { // Se l'utente sceglie 3
                    if (contaContatti > 0) { // Verifica se ci sono contatti
                        if (verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti) != -1) { // Verifica la presenza di un contatto specifico
                            System.out.println("Contatto presente"); // Stampa un messaggio se il contatto è presente
                        } else {
                            System.out.println("Contatto non presente"); // Stampa un messaggio se il contatto non è presente
                            System.out.println("Aggiunta del nuovo contatto..."); // Avviso di aggiunta di un nuovo contatto
                            gestore[contaContatti] = LeggiContatto(tastiera); // Legge e aggiunge il nuovo contatto all'array
                            contaContatti++; // Incrementa il numero di contatti
                            System.out.println("Contatto aggiunto con successo."); // Stampa un messaggio di conferma
                        }
                    } else {
                        System.out.println("Non ci sono contatti"); // Stampa un messaggio se non ci sono contatti
                    }
                }
                case 4 -> {
                    System.out.println("Quale contatto vuoi eliminare?");
                    trovato = verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti);
                    if (trovato != -1) { //se trova il contatto, chiama il metodo eliminaContatto
                        gestore = eliminaContatto(gestore, contaContatti, trovato);
                        contaContatti--;
                    } else {
                        System.out.println("Contatto non trovato!");
                    }
                }
                case 5 -> {
                    System.out.println("Quale contatto vuoi chiamare?"); //chiedo all'utente quale contatto chiamare e chiamo verificaPresenzaContatto
                    trovato = verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti);
                    if (trovato != -1) { //se il contatto esiste, aggiungo 1 al suo numChiamate e aggiungo il contatto all'array della cronologia
                        gestore[trovato].numChiamate++;
                        System.out.println("Chiamata effettuata");
                        cronologia[numeroChiamateEffettuate] = gestore[trovato];
                        numeroChiamateEffettuate++;
                    } else {
                        System.out.println("Contatto non trovato");
                    }
                }
                case 6 -> {
                    System.out.println("Visualizzazione cronologia chiamate"); //siccome nell'aggiunta dei contatti alla cronologia venivano aggiunti alla fine dell'array, qui l'array viene stampato dall'ultimo al primo
                    for (int i = numeroChiamateEffettuate - 1; i >= 0; i--) {
                        if (cronologia[i] != null && !cronologia[i].nascosto) { //non stampo i contatti nascosti
                            System.out.println(cronologia[i].anagrafica());
                        }
                    }
                }
                case 7 -> {
                    boolean fineAmministratore = false, nuovaPasswordOk = false;
                    String inserimentoPassword, controlloNuovaPassword;
                    do {
                        switch (menu(admin, tastiera)) {
                            case 1 -> {
                                System.out.println("Login Amministratore");
                                if (!utenteAmministratore) { //se l'utente è già amministratore riferisco che il login è già avvenuto
                                    System.out.println("Inserisci la password: "); //chiedo all'utente di inserire la password
                                    inserimentoPassword = tastiera.nextLine();
                                    if (inserimentoPassword.equals(password)) { //se ciò che viene inserito corrisponde con la password, aggiorno utenteAmministratore a true
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
                                System.out.println("Inserire la password corrente (default ''admin''): "); //chiedo all'utente di inserire la password corrente per sicurezza
                                inserimentoPassword = tastiera.nextLine();
                                if (inserimentoPassword.equals(password)) {
                                    do {
                                        nuovaPasswordOk = false;
                                        System.out.println("Inserire la nuova password: "); //chiedo all'utente di inserire la nuova password
                                        inserimentoPassword = tastiera.nextLine();
                                        controlloNuovaPassword = inserimentoPassword;
                                        System.out.println("Reinserire la nuova password: "); //chiedo all'utente di reinserire la nuova password per sicurezza
                                        inserimentoPassword = tastiera.nextLine();
                                        if (inserimentoPassword.equals(controlloNuovaPassword)) { //se la nuova password e il reinserimento combaciano, cambio la password
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
                                if (utenteAmministratore) { //se l'utente è amministratore, stampo tutti i contatti che hanno il flag nascosto a true
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
                                if (utenteAmministratore) { //se l'utente è amministratore, aggiorno il flag cambioNascosti a true (per permettere al metodo verificaPresenzaContatto di non saltare i contatti con il flag nascosto a true)
                                    cambioNascosti = true;
                                    trovato = verificaPresenzaContatto(tastiera, gestore, contaContatti, cambioNascosti);
                                    if (trovato != -1) { //se viene trovato il contatto, controllo l'attuale stato del flag nascosto e ne inverto il valore
                                        if (gestore[trovato].nascosto) {
                                            gestore[trovato].nascosto = false;
                                        } else {
                                            gestore[trovato].nascosto = true;
                                        }
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
                case 8 -> {
                    try {
                        scriviFile("Archivio.csv", gestore, contaContatti);
                    }catch (IOException x){
                        System.out.println("Errore: " + x.toString());
                    }
                    System.out.println("Scrittura fatta");
                }
                case 9 -> {
                    try {
                        contaContatti = leggiFile("Archivio.csv", gestore, contaContatti);
                    }catch (IOException x){
                        System.out.println("Errore: " + x.toString());
                    }
                    System.out.println("Lettura fatta");
                }
                case 10 -> {
                    fine = true; // Se l'utente sceglie 8, imposta fine a true per terminare il programma
                }
            }
        } while (!fine); // Continua il ciclo finché l'utente non decide di terminare
        System.out.println("Fine programma"); // Stampa un messaggio per indicare la fine del programma
    }

    // Metodo per leggere i dettagli di un contatto
    public static Contatto LeggiContatto(Scanner tastiera) {
        Contatto contatto = new Contatto(); // Crea un nuovo oggetto Contatto per il nuovo contatto

        System.out.println("Inserisci il nome");
        contatto.nome = tastiera.nextLine();
        System.out.println("Inserisci il numero di telefono");
        contatto.numTelefono = tastiera.nextLine();

        return contatto; // Restituisce il contatto appena creato
    }

    // Metodo per visualizzare i contatti presenti
    public static void Visualizza(Contatto[] gestore, int contaContatti) {
        for (int i = 0; i < contaContatti; i++) {
            if (!gestore[i].nascosto) {
                System.out.println(gestore[i].anagrafica()); // Stampa i dettagli di ogni contatto presente
            }
        }
    }

    // Metodo per verificare la presenza di un contatto
    public static int verificaPresenzaContatto(Scanner tastiera, Contatto[] gestore, int contaContatti, boolean cambioNascosti) {
        System.out.println("Inserisci il nome");
        String nome = tastiera.nextLine();
        System.out.println("Inserisci il numero di telefono");
        String numTelefono = tastiera.nextLine();

        for (int i = 0; i < contaContatti; i++) {
            if (!cambioNascosti) { //caso usato normalmente, stampa tutti i contatti tranne quelli con il flag nascosto a true
                if (gestore[i].nome.equals(nome) && gestore[i].numTelefono.equals(numTelefono) && !gestore[i].nascosto) {
                    return i; // Contatto presente
                }
            } else { //caso usato quando cambioNascosti è a true, quindi quando è necessario che il codice consideri anche i contatti con il flag nascosto a true
                if (gestore[i].nome.equals(nome) && gestore[i].numTelefono.equals(numTelefono)) {
                    return i; // Contatto presente
                }
            }
        }
        return -1; // Contatto non presente
    }

    // Metodo corretto per eliminare un contatto
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

    public static void scriviFile(String nomeFile, Contatto[] persone, int nContatti) throws IOException {
        FileWriter scrittore = new FileWriter(nomeFile);
        for (int i = 0; i< nContatti; i++){
            scrittore.write(persone[i].toString() + "\r\n");
        }
        scrittore.flush();
        scrittore.close();
    }

    public static int leggiFile(String nomeFile, Contatto[] persone, int nContatti) throws IOException {
        FileReader lettore = new FileReader(nomeFile);
        Scanner tastiera = new Scanner(lettore);
        String[] dati = null;
        String riga;
        int contaLinee = 0;
        while (tastiera.hasNextLine() && contaLinee < persone.length){
            dati = tastiera.nextLine().split(",");
            Contatto p = new Contatto();
            p.nome = dati[0];
            p.numTelefono = dati[1];
            switch(dati[3]){
                case "false":
                    p.nascosto = false;
                    break;
                case "true":
                    p.nascosto = true;
                    break;
            }
            persone[contaLinee] = p;
            contaLinee++;
        }
        return contaLinee;
    }

}
