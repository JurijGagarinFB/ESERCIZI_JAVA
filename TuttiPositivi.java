import java.util.Scanner;

public class TuttiPositivi {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int lunghezza;
        System.out.println("Quanto è lungo l'array?");
        lunghezza = tastiera.nextInt();
        tastiera.nextLine();
        Positivi(tastiera, lunghezza);
    }

    private static void Positivi(Scanner tastiera, int lunghezza) {
        int[] numeri = new int[lunghezza];
        for (int i = 0; i < numeri.length; i++) {
            System.out.println("Inserisci un numero");
            numeri[i] = tastiera.nextInt();
        }
        for (int i = 0; i < numeri.length; i++) {
            if (numeri[i]<0) {
                numeri[i]=numeri[i]*-1;
            }
            System.out.println("Ecco i numeri tutti positivi: " + numeri[i]);
        }
    }
}