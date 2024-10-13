import mensola.Libro;
import frontScreen.FrontEnd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        final int MAXLIBRI = 3;
        Libro[] mensola = new Libro[MAXLIBRI];

        int i = 0; // numero di libri
        double costoTotale = 0.0;

        while (i < MAXLIBRI) {
            System.out.println("Vuoi aggiungere un libro? S/N");
            String risposta = tastiera.nextLine();

            if (risposta.equals("S")) {

                mensola[i] = FrontEnd.LeggiLibro(tastiera);
                System.out.println("Libro aggiunto con successo!");
                System.out.println(mensola[i].FormattaDati()); // metodo dalla classe Libro


                costoTotale += mensola[i].pagine * mensola[i].PREZZOPAGINA;
                i++;
            } else {
                break; // esci dal ciclo se l'utente non vuole aggiungere più libri
            }
        }

        // Visualizza il numero totale di libri e il costo totale
        System.out.println("Hai aggiunto un totale di " + i + " libri");
        System.out.printf("Il costo totale dei libri è: %f euro", costoTotale);


    }
}