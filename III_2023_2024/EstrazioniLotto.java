import java.util.Scanner;
import java.util.Random;

public class EstrazioniLotto {
    public static void main(String[] args) {
        // Array di opzioni per il menu
        String[] opzioni = {"Estrazioni lotto", "[1] Ruota Venezia", "[2] Visualizza", "[3] Exit"};

        // Oggetto Scanner per la lettura dell'input
        Scanner tastiera = new Scanner(System.in);

        // Flag per controllare la fine del programma
        boolean fine = true;

        // Flag per verificare se sono stati estratti numeri
        boolean estratti = false;

        // Array per memorizzare i numeri estratti
        int[] nEstratti = new int[0];

        do {
            // Switch-case per gestire le opzioni del menu
            switch (menu(opzioni, tastiera)) {
                case 1:
                    System.out.println("Estrazioni Ruota Venezia");
                    Wait(2000);
                    // Esegui l'estrazione dei numeri
                    nEstratti = estraiNumeri();
                    estratti = true;
                    break;
                case 2:
                    if (estratti) {
                        System.out.println("Visualizzazione Ruota Venezia");
                        // Visualizza i numeri estratti
                        VisualizzaNumeri(nEstratti);
                        Wait(2000);
                    } else {
                        System.out.println("Devi prima effettuare l'estrazione (Opzione 1).");
                        Wait(2000);
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    // Imposta il flag per terminare il programma
                    fine = false;
                    break;
            }
            Wait(2000);
        } while (fine);
    }

    // Metodo per gestire il menu e restituire la scelta dell'utente
    private static int menu(String[] opzioni, Scanner tastiera) {
        int scelta;
        do {
            ClrScr();
            System.out.println("----" + opzioni[0] + "----");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            System.out.println("------------");
            // Legge la scelta dell'utente
            scelta = tastiera.nextInt();
            // Controlla se la scelta è valida, altrimenti richiede l'input
            if (!(scelta >= 1 && scelta <= opzioni.length)) {
                System.out.println("Scelta errata");
            }
            Wait(2000);
        } while (!(scelta >= 1 && scelta <= opzioni.length));
        return scelta;
    }

    // Metodo per pulire lo schermo della console
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo per attendere per un periodo specificato in millisecondi
    private static void Wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Metodo per estrarre 5 numeri casuali tra 1 e 90 senza ripetizioni
    private static int[] estraiNumeri() {
        Random casuale = new Random();
        int[] nEstratti = new int[5];

        for (int i = 0; i < nEstratti.length; i++) {
            nEstratti[i] = casuale.nextInt(90) + 1;

            // Verifica che il numero estratto non sia già presente nell'array
            for (int j = 0; j < i; j++) {
                while (nEstratti[i] == nEstratti[j]) {
                    nEstratti[i] = casuale.nextInt(90) + 1;
                    j = 0;
                }
            }
        }
        return nEstratti;
    }

    // Metodo per visualizzare i numeri estratti
    private static void VisualizzaNumeri(int[] nEstratti) {
        for (int numero : nEstratti) {
            System.out.println(numero + "\n");
        }
    }
}
