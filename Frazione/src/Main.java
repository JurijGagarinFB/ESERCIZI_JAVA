import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        try {
            System.out.println("Inserisci numeratore della prima frazione:");
            int numeratore1 = Integer.parseInt(tastiera.nextLine());
            System.out.println("Inserisci denominatore della prima frazione:");
            int denominatore1 = Integer.parseInt(tastiera.nextLine());

            Frazione frazione = new Frazione(numeratore1, denominatore1);


            System.out.println("Inserisci la seconda frazione (formato x/y):");
            String frazioneInput = tastiera.nextLine();

            System.out.println("Risultato come frazione: " + frazione.sommaFrazioneRitornaStringa(frazioneInput));
            System.out.println("Risultato come valore: " + frazione.sommaFrazioneRitornaValore(frazioneInput));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
