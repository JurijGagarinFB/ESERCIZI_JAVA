import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        try {
            System.out.println("Inserisci numeratore prima frazione");
            int numeratore = Integer.parseInt(tastiera.nextLine());
            System.out.println("Inserisci denominatore prima frazione");
            int denominatore = Integer.parseInt(tastiera.nextLine());

            System.out.println("Inserisci seconda frazione come stringa (formato x/y)");
            String frazione = tastiera.nextLine();

            Frazione frazione1 = new Frazione(numeratore, denominatore);
            Frazione frazione2 = new Frazione(frazione);

            String risultato = frazione1.sommaFrazione(frazione1, frazione2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}