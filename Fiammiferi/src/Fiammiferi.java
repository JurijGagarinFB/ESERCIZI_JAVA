import java.util.Scanner;

/**
 * La classe Fiammiferi implementa un semplice gioco dove due giocatori prendono
 * a turno un certo numero di fiammiferi da un insieme iniziale e il giocatore
 * che prende l'ultimo fiammifero vince.
 */
public class Fiammiferi {

    /**
     * Il metodo main è il punto di ingresso del programma.
     *
     * @param args gli argomenti passati da riga di comando (non usati in questo caso)
     */
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in); // Scanner per l'input da tastiera
        int nFiammiferi = 21; // Numero iniziale di fiammiferi
        int nPrelevare; // Numero di fiammiferi da prelevare in un turno
        int turno = 1; // Contatore del turno
        System.out.println("Inserire il nome del giocatore n.1");
        String giocatore1 = tastiera.nextLine(); // Nome del primo giocatore
        System.out.println("Inserire il nome del giocatore n.2");
        String giocatore2 = tastiera.nextLine(); // Nome del secondo giocatore

        // Loop principale del gioco
        do {
            turno++; // Incrementa il turno
            // Stampa di cui è il turno e il nome del giocatore corrispondente
            if (turno % 2 == 0) {
                System.out.println("Turno del giocatore " + giocatore1);
            } else {
                System.out.println("Turno del giocatore " + giocatore2);
            }

            // Stampa grafica dei fiammiferi rimanenti
            for (int i = 0; i < nFiammiferi; i++) {
                System.out.print("* ");
            }
            System.out.print("\n");
            for (int i = 0; i < nFiammiferi; i++) {
                System.out.print("| ");
            }
            System.out.print("\n");

            System.out.println("Quanti fiammiferi vuoi prelevare? (max 3)");

            // Loop per assicurarsi che il numero di fiammiferi prelevati sia valido (1-3)
            do {
                nPrelevare = tastiera.nextInt();
            } while (nPrelevare > 3 || nPrelevare < 1);

            nFiammiferi -= nPrelevare; // Sottrae i fiammiferi prelevati da quelli rimanenti

        } while (nFiammiferi > 0); // Continua finché ci sono fiammiferi rimanenti

        // Stampa del risultato finale
        if (turno % 2 == 0) {
            System.out.println("Ha vinto il giocatore " + giocatore1 + " in " + turno + " turni");
        } else {
            System.out.println("Ha vinto il giocatore " + giocatore2 + " in " + turno + " turni");
        }
    }
}
