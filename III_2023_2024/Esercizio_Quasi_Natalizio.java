import java.util.Scanner;

public class Esercizio_Quasi_Natalizio {
    static int contUova = 0;
    static double totaleLavoro2;
    static double totaleFinaleLavoro2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta, scelta1 = 1;

        do {
            // Stampa il menu
            System.out.println("1. Lavoro 1: Cuocere uova");
            System.out.println("2. Lavoro 2: Pagare il conto");
            System.out.println("3. Lavoro 3: Stampare incasso");

            // Legge la scelta dell'utente
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    // Esegui il lavoro 1
                    cotturaUovo();
                    break;
                case 2:
                    // Esegui il lavoro 2
                    lavoro2();
                    break;
                case 3:
                    // Esegui il lavoro 3
                    int prezzoUova = contUova * 4;
                    if (prezzoUova != 0) {
                        System.out.println("Il prezzo delle uova e': " + prezzoUova + " euro");
                    } else {
                        System.out.println("Non sono state acquistate uova");
                    }
                    System.out.println("Totale da pagare per il cibo: " + totaleLavoro2 + " euro");
                    System.out.println("Totale complessivo: " +  (totaleFinaleLavoro2 + prezzoUova) + " euro");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
            System.out.println("Vuoi fare un altro lavoro?\nInserire 0 per chiudere o qualsiasi altro valore per rifare");
            scelta1 = scanner.nextInt();
        } while (scelta1 != 0);
    }

    //Metodo per attendere x secondi
    public static void attesa(int x) {
        try {
            Thread.sleep(1000 * x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Metodo per mostrare la cottura dell'uovo
    public static void cotturaUovo() {
        Scanner lettore = new Scanner(System.in);
        int scelta = 1;
        do {
            contUova++;
            System.out.println("Inizia la cottura dell'uovo");
            System.out.println("                                                                          \n" +
                    "                                                                          \n" +
                    "                                                                          \n" +
                    "                                ████████                                  \n" +
                    "                              ██        ██                                \n" +
                    "                            ██▒▒▒▒        ██                              \n" +
                    "                          ██▒▒▒▒▒▒      ▒▒▒▒██                            \n" +
                    "                          ██▒▒▒▒▒▒      ▒▒▒▒██                            \n" +
                    "                        ██  ▒▒▒▒        ▒▒▒▒▒▒██                          \n" +
                    "                        ██                ▒▒▒▒██                          \n" +
                    "                      ██▒▒      ▒▒▒▒▒▒          ██                        \n" +
                    "                      ██      ▒▒▒▒▒▒▒▒▒▒        ██                        \n" +
                    "                      ██      ▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒██                        \n" +
                    "                      ██▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒██                        \n" +
                    "                        ██▒▒▒▒  ▒▒▒▒▒▒    ▒▒▒▒██                          \n" +
                    "                        ██▒▒▒▒            ▒▒▒▒██                          \n" +
                    "                          ██▒▒              ██                            \n" +
                    "                            ████        ████                              \n" +
                    "                                ████████                                  \n" +
                    "                                                                          \n" +
                    "                                                                          \n" +
                    "                                                                          \n");
            attesa(5);
            System.out.println("          ▒▒                                                                                  \n" +
                    "      ▓▓██░░▒▒▓▓▓▓░░░░██                                                                      \n" +
                    "      ▓▓                ██                                                                    \n" +
                    "    ▓▓░░▓▓██              ▓▓██                                                                \n" +
                    "    ██░░░░██                  ████                                                            \n" +
                    "  ▓▓░░░░▓▓░░                  ░░██                                                            \n" +
                    "  ██░░░░░░██░░                    ▓▓██                                                        \n" +
                    "  ██░░░░░░░░██░░░░                    ██████████                                              \n" +
                    "██░░░░░░▒▒██░░░░░░░░░░░░                        ██                                            \n" +
                    "██░░░░▒▒░░░░██░░░░░░░░░░░░░░░░  ░░░░        ░░░░██                                            \n" +
                    "██░░░░░░░░░░░░▓▓░░░░░░░░░░░░░░░░░░░░  ░░░░░░░░▓▓██                                            \n" +
                    "██░░░░░░░░░░░░██████████░░░░░░░░░░░░░░░░░░░░██░░██                                            \n" +
                    "██░░░░░░░░░░░░░░▒▒░░░░░░██░░░░▓▓████░░░░░░██░░██                ████████████                  \n" +
                    "██░░░░░░░░░░░░░░▒▒░░░░░░░░██▓▓░░░░░░████░░██░░██            ████            ████              \n" +
                    "  ██░░░░░░░░░░▒▒▒▒░░░░░░░░░░░░▒▒░░░░░░░░██░░██        ██████                    ████          \n" +
                    "  ██░░░░░░░░▒▒░░░░▒▒░░░░░░░░░░░░▒▒░░░░░░░░██      ████                              ██        \n" +
                    "    ██░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░██  ██████                                    ██      \n" +
                    "    ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██  ██                                          ██      \n" +
                    "    ░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓██▓▓░░              ██░░░░██████████            ██      \n" +
                    "        ████░░░░░░░░░░░░░░░░░░░░████                ██████░░░░░░░░░░░░░░░░████        ██      \n" +
                    "            ██▓▓██░░░░░░░░██████                ████░░░░░░░░░░░░░░░░░░░░░░░░░░██        ██    \n" +
                    "                  ████████                  ████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░    ██    \n" +
                    "                  ░░░░██                  ██▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░    ░░██  \n" +
                    "                    ██                  ░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒██░░        ██\n" +
                    "                    ██                  ░░░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒██░░      ░░██\n" +
                    "                  ██                      ░░██░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒██        ░░██\n" +
                    "                  ██                          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██        ░░██\n" +
                    "                  ██                            ████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████          ░░██\n" +
                    "                  ██                                ██████████▒▒▒▒▒▒████████░░          ░░░░██\n" +
                    "                  ██                                  ░░░░░░  ██████░░░░░░░░░░        ░░░░░░██\n" +
                    "                  ██                                          ░░░░                    ░░░░░░██\n" +
                    "                  ██                                                              ░░░░░░░░░░██\n" +
                    "                  ██░░                      ░░░░░░░░░░                ░░░░░░░░░░░░░░░░░░░░░░██\n" +
                    "                    ▓▓░░  ░░    ░░░░░░░░░░  ░░░░░░░░    ░░      ░░░░░░░░░░░░░░░░░░░░░░░░░░██  \n" +
                    "                      ████░░░░░░░░░░░░░░░░██████████▓▓██▓▓████████░░░░░░░░░░░░░░░░░░██████    \n" +
                    "                          ▓▓▓▓▓▓▓▓▓▓██▓▓██░░                      ██████▓▓▒▒▓▓▓▓▒▒▓▓    ░░    \n" +
                    "                                                                                              \n" +
                    "                                                                                              \n" +
                    "                                                                                              \n" +
                    "                                                                                              \n" +
                    "                                                                                              \n" +
                    "  ░░░░                                                        ░░░░  ░░                        \n" +
                    "  ░░░░  ░░░░  ░░  ░░                                                                          \n");
            attesa(5);
            System.out.println("████████████████        \n" +
                    "          ██                ██      \n" +
                    "      ████    ░░░░░░░░        ██    \n" +
                    "    ██      ░░      ░░░░        ██  \n" +
                    "  ██      ░░          ░░░░        ██\n" +
                    "  ██      ░░          ░░░░        ██\n" +
                    "██        ░░▒▒░░  ░░░░░░░░        ██\n" +
                    "██░░        ░░░░░░░░░░░░        ░░██\n" +
                    "  ██░░        ░░░░░░░░        ░░██  \n" +
                    "  ██░░░░                    ░░██    \n" +
                    "    ████░░░░            ░░░░██      \n" +
                    "        ████░░░░░░░░░░░░████        \n" +
                    "            ████████████            \n");
            System.out.println("L'uovo e' cotto!\nUova cotte: " + contUova);
            System.out.println("Vuoi cuocere un altro uovo? Inserire 1 per sì o qualsiasi altro valore per no");
            scelta = lettore.nextInt();
        } while (scelta == 1);
    }

    //Metodo per comprare hamburger e bevande
    public static void lavoro2() {
        final double hamburgerVeganoCosto = 1.0;
        final double hamburgerRennaCosto = 2.0;
        final double bevandaAnalcolicaCosto = 1.0;
        final double bevandaAlcolicaCosto = 2.0;
        final double scontoPercentuale = 15.0;
        final double sogliaSconto = 10.0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di hamburger vegani: ");
        int numHamburgerVegani = scanner.nextInt();

        System.out.print("Inserisci il numero di hamburger di renna: ");
        int numHamburgerRenna = scanner.nextInt();

        System.out.print("Inserisci il numero di bevande analcoliche: ");
        int numBevandeAnalcoliche = scanner.nextInt();

        System.out.print("Inserisci il numero di bevande alcoliche: ");
        int numBevandeAlcoliche = scanner.nextInt();

        // Calcola il totale senza sconto
        totaleLavoro2 = (numHamburgerVegani * hamburgerVeganoCosto) +
                (numHamburgerRenna * hamburgerRennaCosto) +
                (numBevandeAnalcoliche * bevandaAnalcolicaCosto) +
                (numBevandeAlcoliche * bevandaAlcolicaCosto);

        // Applica lo sconto se il totale supera la soglia
        if (totaleLavoro2 > sogliaSconto) {
            totaleLavoro2 -= totaleLavoro2 * (scontoPercentuale / 100);
        }
        totaleFinaleLavoro2 += totaleLavoro2;
    }
}