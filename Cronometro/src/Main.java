import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cronometro cronometro = new Cronometro();
        boolean uscita = false;
        do {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Avvia il cronometro");
            System.out.println("2. Ferma il cronometro");
            System.out.println("3. Mostra tempo trascorso");
            System.out.println("4. Resetta il cronometro");
            System.out.println("5. Esci");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {
                    cronometro.avvia();
                    System.out.println("Cronometro avviato.");
                }
                case 2 -> {
                    cronometro.ferma();
                    System.out.println("Cronometro fermato.");
                }
                case 3 -> {
                    System.out.println("Tempo trascorso: " + cronometro.ottieniTempoTrascorsoSecondi() + " secondi.");
                }
                case 4 -> {
                    cronometro.resetta();
                    System.out.println("Cronometro resettato.");
                }
                case 5 -> {
                    System.out.println("Uscita...");
                    uscita = true;
                }
                default -> {
                    System.out.println("Opzione non valida. Riprova.");
                }
            }
        } while (!uscita);
    }
}
