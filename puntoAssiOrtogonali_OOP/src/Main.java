import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci coordiata X primo punto:");
        double coordinataXprimo = tastiera.nextDouble();
        System.out.println("Inserisci coordiata Y primo punto:");
        double coordinataYprimo = tastiera.nextDouble();
        System.out.println("Inserisci coordiata X secondo punto:");
        double coordinataXsecondo = tastiera.nextDouble();
        System.out.println("Inserisci coordiata Y secondo punto:");
        double coordinataYsecondo = tastiera.nextDouble();

        Punto primo = new Punto(coordinataXprimo, coordinataYprimo);
        Punto secondo = new Punto(coordinataXsecondo, coordinataYsecondo);
        Segmento lunghezza = new Segmento(primo, secondo);
        System.out.println(lunghezza.toString());
    }
}


