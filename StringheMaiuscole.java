import java.util.Scanner;

public class StringheMaiuscole {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int lunghezza;
        System.out.println("Quanto è lungo l'array");
        lunghezza = tastiera.nextInt();
        String[] stringhe = new String[lunghezza];
        for (int i=0; i<stringhe.length; i++){
            System.out.println("Inserisci una parola");
            String parola = tastiera.nextLine();
            stringhe[i]=parola;
            }
        for (int i=0; i<stringhe.length; i++){
            if (stringhe[i].charAt(0)>='A' && stringhe[i].charAt(0)<='Z'){
                System.out.println("La parola seguente gha una lettera maiuscola: "+stringhe[i]);
            }
        }
    }
}