/*
Bazaj Francesco     4F     07/10/2024

Programma che elimina tutte le occorrenze di un numero scelto dall'utente
da un array di interi, testando poi che la rimozione sia avvenuta con successo
 */


import java.util.Scanner;

public class Esercizio_Rimuovi_Numero_Vettore {
    public static void main(String[] args) {
        // Inizializza lo scanner per leggere input da tastiera
        Scanner tastiera = new Scanner(System.in);
        int n;

        // Inizializza l'array di interi
        int[] vettore = {1, 4, 6, 1, 7, 8, 9, 10, 1};

        // Richiede all'utente di inserire il numero da rimuovere dall'array
        System.out.println("Che numero vuoi rimuovere dal vettore?");
        n = tastiera.nextInt();  // Lettura del numero

        // Chiamata al metodo removeNum per rimuovere il numero scelto
        int[] newVettore = removeNum(vettore, n);

        // Se nessun numero è stato rimosso (array restituito è null)
        if (newVettore == null) {
            System.out.println("Nessun elemento rimosso.");
        }
        // Se il test di coerenza fallisce (errore rilevato nella rimozione)
        else if (!test(vettore, newVettore, n)) {
            System.out.println("Errore rilevato");
        }
        // Se la rimozione è avvenuta con successo, stampa il nuovo array
        else if (newVettore != null) {
            for (int i = 0; i < newVettore.length; i++) {
                System.out.printf(newVettore[i] + " ");  // Stampa il nuovo array senza il numero rimosso
            }
        }
    }

    // Metodo che rimuove tutte le occorrenze di 'n' dall'array originale
    public static int[] removeNum(int[] array, int n) {
        int cont = 0;

        // Conta il numero di occorrenze di 'n' nell'array originale
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                cont++;  // Incrementa il contatore per ogni elemento uguale a 'n'
            }
        }

        // Se non ci sono elementi da rimuovere, restituisce null
        if (cont == 0) {
            return null;
        }

        // Crea un nuovo array con la dimensione corretta (senza gli elementi da rimuovere)
        int[] newArray = new int[array.length - cont];
        int index = 0;

        // Copia solo gli elementi che non sono uguali a 'n' nel nuovo array
        for (int i = 0; i < array.length; i++) {
            if (array[i] != n) {
                newArray[index++] = array[i];  // Aggiunge l'elemento al nuovo array
            }
        }

        // Restituisce il nuovo array senza gli elementi rimossi
        return newArray;
    }

    // Metodo di test che verifica se la rimozione degli elementi è avvenuta correttamente
    public static boolean test(int[] array, int[] newArray, int n) {
        // Crea un array per memorizzare gli indici degli elementi rimossi
        int[] indexArray = new int[array.length - newArray.length];
        int indexCont = 0;  // Contatore per tracciare la posizione in indexArray

        // Popola indexArray con gli indici degli elementi rimossi (che erano uguali a 'n')
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                indexArray[indexCont] = i;  // Salva l'indice dell'elemento da rimuovere
                indexCont++;
            }
        }

        int j = 0, newIndex = 0;

        // Crea un array temporaneo per simulare la ricostruzione dell'array originale
        int[] testArray = new int[newArray.length + indexCont];

        // Posiziona i valori 'n' (elementi rimossi) agli indici corretti nell'array di test
        for (int i = 0; i < indexArray.length; i++) {
            newIndex = indexArray[i];
            j = newIndex;
            testArray[j] = n;  // Inserisce 'n' agli indici dove erano presenti nel vecchio array
        }

        int index = 0;

        // Riempie il resto del testArray con i valori del newArray (gli elementi rimasti)
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] != n) {
                testArray[i] = newArray[index++];  // Popola con gli elementi non rimossi
            }
        }

        /*
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Simulazione di un errore, in newArray viene messo un numero diverso da quello presente nel vecchio array,
        quindi durante il riempimento dell'array di test un numero sarà
        diverso da quello nel vecchio array (in questo esempio il numero in posizione 1), e nel controllo
        produrrà un errore.
        Togliere commento per testare.
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        */
        // testArray[1] = 15;

        // Confronta l'array originale con l'array di test per verificarne la correttezza
        for (int i = 0; i < testArray.length; i++) {
            if (array[i] != testArray[i]) {
                return false;  // Se c'è una discrepanza, il test fallisce
            }
        }

        // Se il confronto è positivo, la rimozione è stata eseguita correttamente
        return true;
    }
}
