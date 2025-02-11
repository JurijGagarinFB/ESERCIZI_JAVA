import java.util.Scanner;

public class Binario {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        int contatore = 0, num = 0, controllo = 0;
        String bin;
        System.out.println("Inserisci un byte in binario \n");
        bin = tastiera.nextLine();

        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                num += 1 << (bin.length() - 1 - i);
            }
            contatore++;
        }
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1' || bin.charAt(i) == '0') {

            } else {
                controllo++;
            }
        }
        contatore++;
        if (contatore < 8 || controllo > 0) {
            System.out.println("Il numero non è un byte");
        } else {
            System.out.println("E' un byte e vale " + num);
        }
    }
}