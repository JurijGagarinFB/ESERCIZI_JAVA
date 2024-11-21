import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        // Creazione dei due punti per il test delle classi Punto e Segmento
        System.out.println("Inserisci coordinata X del primo punto:");
        double coordinataXprimo = tastiera.nextDouble();
        System.out.println("Inserisci coordinata Y del primo punto:");
        double coordinataYprimo = tastiera.nextDouble();
        System.out.println("Inserisci coordinata X del secondo punto:");
        double coordinataXsecondo = tastiera.nextDouble();
        System.out.println("Inserisci coordinata Y del secondo punto:");
        double coordinataYsecondo = tastiera.nextDouble();

        Punto primo = new Punto(coordinataXprimo, coordinataYprimo);
        Punto secondo = new Punto(coordinataXsecondo, coordinataYsecondo);

        // Test della classe Segmento
        Segmento lunghezza = new Segmento(primo, secondo);
        System.out.println("Lunghezza del segmento: " + lunghezza.toString());

        // Test della classe Rettangolo
        System.out.println("Inserisci la base del rettangolo:");
        double base = tastiera.nextDouble();
        System.out.println("Inserisci l'altezza del rettangolo:");
        double altezza = tastiera.nextDouble();

        // Creazione di un punto di origine per il rettangolo
        System.out.println("Inserisci la coordinata X del punto di origine del rettangolo:");
        double xOrigine = tastiera.nextDouble();
        System.out.println("Inserisci la coordinata Y del punto di origine del rettangolo:");
        double yOrigine = tastiera.nextDouble();
        Punto puntoOrigine = new Punto(xOrigine, yOrigine);

        // Creazione e stampa del rettangolo
        Rettangolo rettangolo = new Rettangolo(base, altezza, puntoOrigine);
        System.out.println(rettangolo.toString());

    }
}
