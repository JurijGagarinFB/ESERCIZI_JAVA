/*Dato un insieme disordinato (di dimensione minima 8 e massima 10 elementi) di numeri interi non ripetuti (valore minimo 1, valore massimo 30),
ordini, in ordine crescente, i soli numeri PARI, lasciando gli eventuali dispari nella loro posizione originaria.*/


/*
Ho modificato il codice rispetto a quanto scritto in verifica in questo modo:
Invece che effettuare il controllo del pari/dispari nel bubble sort saltando i dispari,
ho prima estratto i numeri pari dall'array originale,
li ho ordinati usando il bubble sort e poi li ho reinseriti nell'array originale 
(scorro l'array originale, il primo numero pari lo rimpiazzo con il primo dell'array pari ordinato, il secondo con il secondo e avanti così)
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int[] array = new int[0];
        int inserimento; // Variabile per memorizzare l'inserimento dell'utente
        boolean presente; // Variabile per verificare se un numero è già presente nell'array
        boolean inputValido = false; // Variabile per controllare la validità dell'input dell'utente

        // Chiedo il numero di elementi da inserire
        System.out.println("Quanti elementi vuoi inserire?");
        do {
            try {
                int numElementi = Integer.parseInt(tastiera.nextLine()); // Leggo il numero di elementi da inserire
                if (numElementi >= 8 && numElementi <= 10) { // Controllo che il numero sia compreso tra 8 e 10
                    array = new int[numElementi]; // Inizializzo l'array con il numero specificato di elementi
                    inputValido = true; // Imposto la variabile di input valido a true
                } else {
                    System.out.println("Inserire una quantità valida (tra 8 e 10)"); // Messaggio di errore per input non valido
                }
            } catch (Exception e) {
                System.out.println("Inserisci un numero valido"); // Messaggio di errore per eccezione
            }
        } while (!inputValido); // Ripeto finché non viene inserito un input valido

        // Inserisco i numeri nell'array
        for (int i = 0; i < array.length; i++) {
            boolean numeroValido = false; // Variabile per controllare la validità del numero inserito
            do {
                presente = false; // Resetta la variabile presente
                System.out.println("Inserisci il " + (i + 1) + "° numero (tra 1 e 30)"); // Chiedo l'inserimento del numero
                try {
                    inserimento = Integer.parseInt(tastiera.nextLine()); // Leggo il numero inserito
                    if (inserimento >= 1 && inserimento <= 30) { // Controllo che il numero sia nel range 1-30
                        for (int j = 0; j < i; j++) {
                            if (array[j] == inserimento) { // Controllo se il numero è già presente nell'array
                                presente = true; // Imposto presente a true se il numero è già nell'array
                                System.out.println("Numero già inserito"); // Messaggio di errore per numero duplicato
                            }
                        }
                        if (!presente) {
                            array[i] = inserimento; // Aggiungo il numero all'array se non è già presente
                            numeroValido = true; // Imposto la variabile numeroValido a true
                        }
                    } else {
                        System.out.println("Numero fuori dal range (1-30)"); // Messaggio di errore per numero fuori range
                    }
                } catch (Exception e) {
                    System.out.println("Inserisci un numero valido"); // Messaggio di errore per eccezione
                }
            } while (!numeroValido); // Ripeto finché non viene inserito un numero valido
        }

        // Estraggo e conto i numeri pari
        int contaPari = 0; // Contatore dei numeri pari
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) { // Controllo se il numero è pari
                contaPari++; // Incremento il contatore dei numeri pari
            }
        }

        int[] numeriPari = new int[contaPari]; // Inizializzo un array per i numeri pari
        int indexPari = 0; // Indice per l'array dei numeri pari
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) { // Controllo se il numero è pari
                numeriPari[indexPari] = array[i]; // Aggiungo il numero pari all'array dei numeri pari
                indexPari++; // Incremento l'indice dei numeri pari
            }
        }

        // Ordino i numeri pari usando il bubble sort
        for (int i = 0; i < numeriPari.length - 1; i++) {
            for (int j = i + 1; j < numeriPari.length; j++) {
                if (numeriPari[i] > numeriPari[j]) { // Scambio i numeri se non sono in ordine
                    int temp = numeriPari[i]; // Variabile temporanea per lo scambio
                    numeriPari[i] = numeriPari[j];
                    numeriPari[j] = temp;
                }
            }
        }

        // Reinserisco i numeri pari ordinati nell'array mantenendo la posizione dei dispari
        indexPari = 0; // Reimposto l'indice dei numeri pari
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) { // Controllo se il numero è pari
                array[i] = numeriPari[indexPari++]; // Sostituisco il numero pari con il numero ordinato
            }
        }

        // Stampo l'array risultante
        System.out.println("Array risultante:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
