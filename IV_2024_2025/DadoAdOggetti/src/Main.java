/*
modifica la classe partita in modo che:
    -sia possibile gicare sia le partite base che le partite avanzate
    -la partita base funziona come nella vecchia versione
    -la partita avanzata aggiunge un sistema di bonus:
        -tiene traccia delle vittorie consecutive. Dopo 3 vittorie consecutive, assegna un punto (una vincita) bonus al giocatore.
        -il bonus viene azzerato in caso di pareggio.

    -Si consideri di implementare il polimorfismo implementando nel main un metodo che permette di giocare
    una partita standard o una partita avanzata
    giocaPartita(partitaBase);
    giocaPartita(partitaAvanzata);
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean partitaBase = true, inserimentoCorretto;
        do {
            inserimentoCorretto = true;
            System.out.println("Inserire tipo di partita (Base o Avanzata): ");
            if (sc.nextLine().equalsIgnoreCase("base")) {
                partitaBase = true;
            } else if (sc.nextLine().equalsIgnoreCase("avanzata")) {
                partitaBase = false;
            } else {
                inserimentoCorretto = false;
            }
        } while (!inserimentoCorretto);

        System.out.println("Inserire nome Giocatore 1: ");
        String nome1 = sc.nextLine();
        System.out.println("Inserire nome Giocatore 2: ");
        String nome2 = sc.nextLine();


        int numeroRound;
        int numeroFacce;
        do {
            System.out.println("Inserire numero di round: ");
            numeroRound = Integer.parseInt(sc.nextLine());
        } while (numeroRound < 1);
        do {
            System.out.println("Inserire numero di facce dei dadi: ");
            numeroFacce = Integer.parseInt(sc.nextLine());
        } while (numeroFacce <= 1);

        Gara gara = new Gara(nome1, nome2, numeroRound, new Dado(numeroFacce));
        while (!gara.isFineGara()) {
            System.out.println(gara.round(partitaBase));
            attesa(2);
        }
        System.out.println(gara.getVincitore());
    }

    public static void attesa(int x) {
        try {
            Thread.sleep(1000 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
