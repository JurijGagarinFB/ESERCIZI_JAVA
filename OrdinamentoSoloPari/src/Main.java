/*Dato un insieme disordinato (di dimensione minima 8 e massima 10 elementi) di numeri interi non ripetuti (valore minimo 1, valore massimo 30),
ordini, in ordine crescente, i soli numeri PARI, lasciando gli eventuali dispari nella loro posizione originaria.*/


/*
Ho modificato il codice rispetto a quanto scritto in verifica in questo modo:
Invece che effettuare il controllo del pari/dispari nel bubble sort saltando i dispari, ho prima estratto i numeri pari dall'array originale, li ho ordinati usando il bubble sort e poi li ho reinseriti nell'array originale (scorro l'array originale, il primo numero pari lo rimpiazzo con il primo dell'array pari ordinato, il secondo con il secondo e avanti così)
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int[] array = new int[0];
        int inserimento;
        boolean presente;
        boolean inputValido = false;

        // Chiedi il numero di elementi
        System.out.println("Quanti elementi vuoi inserire?");
        do {
            try {
                int numElementi = Integer.parseInt(tastiera.nextLine());
                if (numElementi >= 8 && numElementi <= 10) {
                    array = new int[numElementi];
                    inputValido = true;
                } else {
                    System.out.println("Inserire una quantità valida (tra 8 e 10)");
                }
            } catch (Exception e) {
                System.out.println("Inserisci un numero valido");
            }
        } while (!inputValido);

        // Inserisci i numeri nell'array
        for (int i = 0; i < array.length; i++) {
            boolean numeroValido = false;
            do {
                presente = false;
                System.out.println("Inserisci il " + (i + 1) + "° numero (tra 1 e 30)");
                try {
                    inserimento = Integer.parseInt(tastiera.nextLine());
                    if (inserimento >= 1 && inserimento <= 30) {
                        for (int j = 0; j < i; j++) {
                            if (array[j] == inserimento) {
                                presente = true;
                                System.out.println("Numero già inserito");
                            }
                        }
                        if (!presente) {
                            array[i] = inserimento;
                            numeroValido = true;
                        }
                    } else {
                        System.out.println("Numero fuori dal range (1-30)");
                    }
                } catch (Exception e) {
                    System.out.println("Inserisci un numero valido");
                }
            } while (!numeroValido);
        }

        // Estrai e ordina i numeri pari
        int countPari = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                countPari++;
            }
        }

        int[] numeriPari = new int[countPari];
        int indexPari = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                numeriPari[indexPari++] = num;
            }
        }

        // Ordina i numeri pari usando il bubble sort
        for (int i = 0; i < numeriPari.length - 1; i++) {
            for (int j = i + 1; j < numeriPari.length; j++) {
                if (numeriPari[i] > numeriPari[j]) {
                    int temp = numeriPari[i];
                    numeriPari[i] = numeriPari[j];
                    numeriPari[j] = temp;
                }
            }
        }

        // Reinserisci i numeri pari ordinati nell'array mantenendo la posizione dei dispari
        indexPari = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = numeriPari[indexPari++];
            }
        }

        // Stampa l'array risultante
        System.out.println("Array risultante:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
