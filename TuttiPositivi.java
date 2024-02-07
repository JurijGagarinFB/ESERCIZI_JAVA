import java.util.Scanner;

public class TuttiPositivi {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in); // Creazione di un oggetto Scanner per l'input da tastiera
        int lunghezza; // Dichiarazione della variabile per la lunghezza dell'array
        System.out.println("Quanto è lungo l'array?"); // Richiesta di input per la lunghezza dell'array
        lunghezza = tastiera.nextInt(); // Acquisizione della lunghezza dell'array dall'utente
        tastiera.nextLine(); // Pulizia del buffer di input
        Positivi(tastiera, lunghezza); // Chiamata alla funzione per inserire i numeri nell'array
    }

    // Funzione per inserire numeri nell'array e visualizzarli tutti positivi
    private static void Positivi(Scanner tastiera, int lunghezza) {
        int[] numeri = new int[lunghezza]; // Creazione dell'array di interi con la lunghezza specificata
        for (int i = 0; i < numeri.length; i++) { // Ciclo per l'inserimento dei numeri nell'array
            System.out.println("Inserisci un numero"); // Richiesta di input per un numero
            numeri[i] = tastiera.nextInt(); // Acquisizione del numero dall'utente e inserimento nell'array
        }
        for (int i = 0; i < numeri.length; i++) { // Ciclo per visualizzare i numeri tutti positivi
            if (numeri[i] < 0) { // Se il numero è negativo
                numeri[i] = numeri[i] * -1; // Converti il numero in positivo
            }
            System.out.println("Ecco i numeri tutti positivi: " + numeri[i]); // Visualizzazione del numero positivo
        }
    }
}
