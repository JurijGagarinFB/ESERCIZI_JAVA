import backend.Genere;
import backend.Libro;
import backend.Mensola;
import frontend.Tools;

import static frontend.Tools.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean uscita = false;

        Scanner tastiera = new Scanner(System.in);
        boolean soluzioni = false;
        Mensola libreria = new Mensola(3);

        String[] opzioni = {"---LIBRERIA---", "1. Inserimento", "2. Visualizzazione", "3. Salva file", "4. Apri file", "5. Fine"};
        do {
            clrScr();
            int scelta = Menu(opzioni, tastiera);
            switch (scelta) {
                case 1 -> {
                    try {
                        System.out.println("Inserimento");
                        if (!libreria.checkSpace()) {
                            libreria.addLibro(Tools.leggiLibro(tastiera, soluzioni));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("Visualizzazione");
                    if (!libreria.isEmpty()) {
                        visualizzaMensola(libreria.getVolumi());
                    }
                }

                case 3 -> {
                    System.out.println("Salva file");
                    try{
                        System.out.println("Inserisci il nome del file:");
                        String nomeFile = tastiera.nextLine();
                        libreria.salvaFile(nomeFile);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.println("Apri file");
                    try{
                        System.out.println("Inserisci il nome del file:");
                        String nomeFile = tastiera.nextLine();
                        libreria.leggiFile(nomeFile);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 5 -> {
                    System.out.println("Fine");
                    uscita = true;
                }
            }
        } while (!uscita);


    }
}