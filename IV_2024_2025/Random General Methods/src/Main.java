/*
Bazaj Francesco     4F     30/09/2024
Collezione generale di metodi legati alla generazione random/interazione con array
 */

import java.util.Random;
import java.util.Scanner;

import static Utility.Tools.Menu;

public class Main {
    public static void main(String[] args) {
        // Scanner per la lettura dell'input da tastiera
        Scanner tastiera = new Scanner(System.in);

        // Array di stringhe per le opzioni del menu
        String[] opzioni = {"Menu", "1 Genera Random", "2 Visualizzazione", "3 Ricerca", "4 Cancella numero con decremento", "5 Cancella numero e ritorna nuovo vettore", "6 Randomizza posizione numeri", "7 Raddoppia", "8 Selection Sort", "9 Fine"};

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
                    int posizione = trovaNumeri(nEstratti, inputUtente); // Ricerca il numero nel vettore
                    if (posizione >= 0) {
                        System.out.println("Trovato in posizione " + (posizione + 1));
                    } else {
                        System.out.println("Non trovato");
                    }
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
                case 6 -> {
                    System.out.println("Randomizza posizione numeri");
                    int[] nuovoVettore = randomizzaPosizioneNumeri(nEstratti);
                    stampaNumeri(nuovoVettore);
                }
                case 7 -> { // Raddoppia il vettore
                    System.out.println("Raddoppia Vettore");
                    int[] nuovoVettore = raddoppiaVettore(nEstratti);
                    stampaNumeri(nuovoVettore);
                    System.out.println("Numero di elementi aggiunti al vettore: " + (nuovoVettore.length - nEstratti.length));
                }
                case 8 -> { // Ordina il vettore usando il Selection Sort
                    System.out.println("Ordinamento Selection Sort");
                    nEstratti = selectionSort(nEstratti); // Ordina l'array
                    stampaNumeri(nEstratti); // Mostra l'array ordinato
                }
                case 9 -> { // Uscita dal programma
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
            return -1;
        }
        for (int i = 0; i < nEstratti.length; i++) { // Cicla attraverso l'array
            if (input == nEstratti[i]) {
                return i; // Restituisce l'indice del numero trovato
            }
        }
        return -1; // Restituisce -1 se non trovato
    }

    // Metodo per cancellare un numero e decrementare la lunghezza del vettore
    public static int[] cancellaNumeroConDecremento(int[] nEstratti, int numero) {
        if (nEstratti == null || numero < 1 || numero > 100) {
            return nEstratti; // Se l'array è nullo o il numero è fuori range, restituisce l'array originale
        }

        int posizione = trovaNumeri(nEstratti, numero);
        if (posizione == -1) {
            return nEstratti; // Se il numero non è trovato, restituisce l'array originale
        }

        // Crea un nuovo array con una dimensione ridotta
        int[] nuovoVettore = new int[nEstratti.length - 1];

        // Copia manualmente i valori nel nuovo array, saltando il numero da cancellare
        for (int i = 0, j = 0; i < nEstratti.length; i++) {
            if (i != posizione) {
                nuovoVettore[j++] = nEstratti[i];
            }
        }
        return nuovoVettore; // Restituisce il nuovo array ridotto
    }

    // Metodo per cancellare un numero e creare un nuovo array di dimensione 20
    public static int[] cancellaNumeroNuovoVettore(int[] nEstratti, int numero, final int MAXNUMERI) {
        if (nEstratti == null || numero < 1 || numero > 100) {
            return nEstratti; // Se l'array è nullo o il numero è fuori range, restituisce l'array originale
        }

        // Trova la posizione del numero da cancellare
        int posizione = trovaNumeri(nEstratti, numero);
        if (posizione == -1) {
            return nEstratti; // Se il numero non è trovato, restituisce l'array originale
        }

        // Crea un nuovo array di dimensione 20
        int[] nuovoVettore = new int[20];
        int indice = 0; // Indice per tracciare la posizione nel nuovo array

        // Copia i numeri nel nuovo array, saltando quello da cancellare
        for (int i = 0; i < nEstratti.length && indice < nuovoVettore.length; i++) {
            if (i != posizione) {
                nuovoVettore[indice] = nEstratti[i];
                indice++;
            }
        }

        // Riempie i posti vuoti nel nuovo array con nuovi numeri casuali
        Random numeroRandom = new Random();
        while (indice < nuovoVettore.length) { // Finché ci sono spazi vuoti nel nuovo array
            int nuovoNumero;
            boolean presente;
            do {
                nuovoNumero = numeroRandom.nextInt(1, MAXNUMERI + 1); // Genera un nuovo numero casuale
                presente = false;
                // Verifica che il nuovo numero non sia già presente nel nuovo array
                for (int j = 0; j < indice; j++) {
                    if (nuovoVettore[j] == nuovoNumero) {
                        presente = true;
                    }
                }
            } while (presente); // Ripeti finché trovi un numero che non è già presente
            nuovoVettore[indice] = nuovoNumero; // Aggiungi il nuovo numero casuale
            indice++;
        }

        return nuovoVettore; // Restituisce il nuovo array con numeri casuali
    }


    // Metodo per randomizzare la posizione dei numeri in un vettore
    public static int[] randomizzaPosizioneNumeri(int[] nEstratti) {
        if (nEstratti == null) {
            return null; // Se l'array è nullo, restituisce null
        }
        Random random = new Random();
        for (int i = nEstratti.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Seleziona un indice casuale
            int temp = nEstratti[i];
            nEstratti[i] = nEstratti[j];
            nEstratti[j] = temp; // Scambia i valori
        }
        return nEstratti; // Restituisce l'array con i numeri randomizzati
    }

    // Metodo per raddoppiare la dimensione dell'array
    public static int[] raddoppiaVettore(int[] nEstratti) {
        if (nEstratti == null) {
            return null; // Se l'array è nullo, restituisce null
        }
        int[] nuovoVettore = new int[nEstratti.length * 2]; // Nuovo array di dimensione doppia
        for (int i = 0; i < nEstratti.length; i++) {
            nuovoVettore[i] = nEstratti[i]; // Copia i numeri originali
        }
        return nuovoVettore; // Restituisce il nuovo array con la dimensione raddoppiata
    }

    // Metodo per ordinare i numeri con l'algoritmo Selection Sort
    public static int[] selectionSort(int[] nEstratti) {
        if (nEstratti == null) {
            return null; // Se l'array è nullo, restituisce null
        }

        for (int i = 0; i < nEstratti.length - 1; i++) {
            int minIndex = i; // Assume che l'elemento corrente sia il minimo
            for (int j = i + 1; j < nEstratti.length; j++) {
                if (nEstratti[j] < nEstratti[minIndex]) {
                    minIndex = j; // Trova l'indice del valore minimo
                }
            }
            // Scambia il valore minimo con quello corrente
            int temp = nEstratti[minIndex];
            nEstratti[minIndex] = nEstratti[i];
            nEstratti[i] = temp;
        }

        return nEstratti; // Restituisce l'array ordinato
    }
}
