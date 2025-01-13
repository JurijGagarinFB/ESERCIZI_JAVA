import java.util.ArrayList;
import java.util.Scanner;

import static FRONTEND.Tools.*;

import BACKEND.*;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String[] opzioni = {"Biblioteca", "Inserisci Libro", "Stampa Libri", "Exit"};
        boolean exit = false;
        ArrayList<Libro> mensola = new ArrayList<>();

        do {
            try {
                switch (Menu(opzioni, tastiera)) {
                    case 1 -> {
                        System.out.println("Inserimento Libro");
                        Libro l = new Libro(leggiLibro(tastiera));
                        mensola.add(l);
                    }
                    case 2 -> {
                        System.out.println("Stampa Info Libri");
                        for (int i = 0; i < mensola.size(); i++) {
                            System.out.println(mensola.get(i).toString());
                        }
                    }
                    case 3 -> {
                        System.out.println("Exit");
                        exit = true;
                    }
                    case 4 -> {

                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!exit);
    }
}