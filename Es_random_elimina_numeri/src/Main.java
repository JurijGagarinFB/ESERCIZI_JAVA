import java.util.Random;
import java.util.Scanner;

import static Utility.Tools.Menu;

public class Main {
    public static void main(String[] args) {
        // Scanner per la lettura dell'input da tastiera
        Scanner tastiera = new Scanner(System.in);

        // Array di stringhe per le opzioni del menu
        String[] opzioni = {
                "Menu",
                "1 Genera Random",
                "2 Visualizzazione",
                "3 Ricerca",
                "4 Cancella numero con decremento",
                "5 Cancella numero e ritorna nuovo vettore",
                "6 Fine"
        };

        // Variabile di controllo per uscire dal ciclo
        boolean esci = false; // Inizializzato a false, continua il ciclo finché non viene settato a true

        // Array che conterrà i numeri estratti
        int[] nEstratti = null;

        // Numero massimo per i numeri casuali
        final int MAXNUMERI = 100;
        int inputUtente; // Per memorizzare l'input numerico dell'utente

        // Ciclo principale che mostra il menu e gestisce le opzioni
        do {
            // Menu di selezione delle opzioni
            switch (Menu(opzioni, tastiera)) {
                case 1 -> { // Genera numeri casuali
                    System.out.println("Generazione");
                    nEstratti = generaNumeri(MAXNUMERI); // Chiama il metodo per generare numeri casuali
                }
                case 2 -> { // Visualizza i numeri generati
                    System.out.println("Visualizzazione");
                    stampaNumeri(nEstratti); // Stampa i numeri estratti
                }
                case 3 -> { // Ricerca di un numero nel vettore
                    System.out.println("Ricerca");
                    System.out.println("Inserisci il numero da cercare");
                    inputUtente = Integer.parseInt(tastiera.nextLine()); // Prende il numero da cercare
                    trovaNumeri(nEstratti, inputUtente); // Ricerca il numero nel vettore
                }
                case 4 -> { // Cancella un numero con riduzione del vettore
                    System.out.println("Cancella numero con decremento");
                    System.out.println("Inserisci il numero da cancellare");
                    inputUtente = Integer.parseInt(tastiera.nextLine()); // Prende il numero da cancellare
                    nEstratti = cancellaNumeroConDecremento(nEstratti, inputUtente); // Cancella e riduce la dimensione del vettore
                }
                case 5 -> { // Cancella un numero e genera un nuovo vettore con dimensione fissa
                    System.out.println("Cancella numero e ritorna nuovo vettore");
                    System.out.println("Inserisci il numero da cancellare");
                    inputUtente = Integer.parseInt(tastiera.nextLine()); // Prende il numero da cancellare
                    nEstratti = cancellaNumeroNuovoVettore(nEstratti, inputUtente, MAXNUMERI); // Cancella e rigenera un nuovo vettore di 20 elementi
                }
                case 6 -> { // Uscita dal programma
                    System.out.println("Fine");
                    esci = true; // Imposta esci a true per terminare il ciclo
                }
                default -> System.out.println("Opzione non valida.");
            }
        } while (!esci); // Continua fino a quando esci è false
    }

    // Metodo per generare 20 numeri casuali univoci
    public static int[] generaNumeri(int nNumeri) {
        Random numeroRandom = new Random();
        int numero, cont = 0;
        boolean presente;
        int[] vettore = new int[20]; // Vettore di 20 elementi per contenere i numeri casuali
        do {
            // Genera un numero casuale compreso tra 1 e il valore massimo
            numero = numeroRandom.nextInt(0, nNumeri) + 1;
            presente = false;
            // Verifica che il numero non sia già presente nel vettore
            for (int i = 0; i < cont; i++) {
                if (vettore[i] == numero) {
                    presente = true;
                }
            }
            // Se il numero non è presente, lo aggiunge al vettore
            if (!presente) {
                vettore[cont] = numero;
                cont++;
            }
        } while (cont < 20); // Continua fino a generare 20 numeri univoci
        return vettore;
    }

    // Metodo per stampare i numeri estratti in righe da 10
    public static void stampaNumeri(int[] nEstratti) {
        if (nEstratti == null) { // Controlla se non ci sono numeri generati
            System.out.println("Nessun numero generato.");
            return;
        }
        int conta = 0; // Contatore per formattare la stampa in righe da 10 numeri
        for (int i = 0; i < nEstratti.length; i++) {
            System.out.printf("%-4d ", nEstratti[i]); // Stampa il numero formattato
            conta++;
            if (conta == 10) { // Dopo 10 numeri va a capo
                conta = 0;
                System.out.println("");
            }
        }
        System.out.println(""); // Aggiunge una nuova riga finale
    }

    // Metodo per trovare un numero e restituire la sua posizione o -1 se non trovato
    public static int trovaNumeri(int[] nEstratti, int input) {
        if (nEstratti == null) { // Controlla se non ci sono numeri generati
            System.out.println("Nessun numero generato.");
            return -1;
        }
        for (int i = 0; i < nEstratti.length; i++) { // Cicla attraverso l'array
            if (input == nEstratti[i]) {
                System.out.println("Trovato in posizione " + (i + 1)); // Restituisce la posizione trovata
                return i; // Restituisce l'indice del numero trovato
            }
        }
        System.out.println("Non trovato");
        return -1; // Restituisce -1 se non trovato
    }

    // Metodo per cancellare un numero e decrementare la lunghezza del vettore
    public static int[] cancellaNumeroConDecremento(int[] nEstratti, int numero) {
        // Controllo per numero fuori dal range
        if (numero < 1 || numero > 100) {
            System.out.println("Valore out of range: il numero deve essere compreso tra 1 e 100.");
            return nEstratti; // Restituisce l'array originale se il numero non è valido
        }

        if (nEstratti == null) { // Controlla se non ci sono numeri generati
            System.out.println("Nessun numero generato.");
            return null; // Restituisce null se non ci sono numeri
        }

        // Usa il metodo trovaNumeri per ottenere la posizione del numero
        int posizione = trovaNumeri(nEstratti, numero);
        if (posizione == -1) {
            return nEstratti; // Se il numero non è trovato, restituisce l'array originale
        }

        // Sposta gli elementi successivi indietro di una posizione per ricompattare l'array
        for (int i = posizione; i < nEstratti.length - 1; i++) {
            nEstratti[i] = nEstratti[i + 1]; // Ricompattamento del vettore
        }

        // Crea un nuovo array con una dimensione ridotta
        int[] nuovoVettore = new int[nEstratti.length - 1];
        System.arraycopy(nEstratti, 0, nuovoVettore, 0, nuovoVettore.length); // Copia il contenuto nel nuovo array
        System.out.println("Numero " + numero + " cancellato e vettore ricompattato.");
        return nuovoVettore; // Restituisce il nuovo array ridotto
    }

    // Metodo per cancellare un numero e creare un nuovo array di dimensione 20
    public static int[] cancellaNumeroNuovoVettore(int[] nEstratti, int numero, final int MAXNUMERI) {
        // Controllo per numero fuori dal range
        if (numero < 1 || numero > 100) {
            System.out.println("Valore out of range: il numero deve essere compreso tra 1 e 100.");
            return nEstratti; // Restituisce l'array originale se il numero non è valido
        }

        if (nEstratti == null) { // Controlla se non ci sono numeri generati
            System.out.println("Nessun numero generato.");
            return null; // Restituisce null se non ci sono numeri
        }

        // Usa il metodo trovaNumeri per ottenere la posizione del numero
        int posizione = trovaNumeri(nEstratti, numero);
        if (posizione == -1) {
            return nEstratti; // Se il numero non è trovato, restituisce l'array originale
        }

        // Crea un nuovo array di dimensione 20 senza il numero da cancellare
        int[] nuovoVettore = new int[20];
        int indice = 0; // Indice per il nuovo array
        for (int i = 0; i < nEstratti.length; i++) {
            if (i != posizione) { // Salta il numero da cancellare
                nuovoVettore[indice] = nEstratti[i];
                indice++;
            }
        }

        // Riempie i posti vuoti nel nuovo array con nuovi numeri casuali
        Random numeroRandom = new Random();
        while (indice < nuovoVettore.length) { // Finché ci sono posti vuoti
            int nuovoNumero;
            boolean presente;
            do {
                nuovoNumero = numeroRandom.nextInt(0, MAXNUMERI) + 1; // Genera un nuovo numero casuale
                presente = false;
                // Controlla se il nuovo numero è già presente nel nuovo array
                for (int j = 0; j < indice; j++) {
                    if (nuovoVettore[j] == nuovoNumero) {
                        presente = true; // Se il numero è già presente, lo segnala
                    }
                }
            } while (presente); // Continua finché il numero è già presente
            nuovoVettore[indice] = nuovoNumero; // Aggiunge il nuovo numero
            indice++; // Incrementa l'indice
        }

        System.out.println("Numero " + numero + " cancellato e nuovo vettore generato.");
        return nuovoVettore; // Restituisce il nuovo array di 20 elementi
    }
}
