package Tools;

import java.util.Scanner;

/**
 * La classe Utility fornisce metodi utili per operazioni di utilità generale.
 */
public class Utility {
    /**
     * Pulisce lo schermo del terminale.
     */
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Attende per un numero specificato di secondi.
     *
     * @param x Il numero di secondi da attendere.
     */
    public static void Wait(int x) {
        try {
            Thread.sleep(1000 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra un menu con le opzioni specificate e chiede all'utente di selezionarne una.
     *
     * @param opzioni Un array di stringhe contenente le opzioni del menu. L'elemento in posizione 0 è il titolo del menu.
     * @param keyboard Uno scanner per leggere l'input dell'utente.
     * @return Il numero della scelta dell'utente.
     */
    public static int menu(String[] opzioni, Scanner keyboard) {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== " + opzioni[0] + " ===");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = Integer.parseInt(keyboard.nextLine());
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }
}
