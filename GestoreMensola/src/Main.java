//Bazaj Francesco     4F     01/10/2024
/*

 */

import static Utility.Tools.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String[] opzioni = {"Menu", "1 Inserisci Libro", "2 Visualizza Mensola", "3 Esci"};
        boolean fine = false;

        final int MAXLIBRI = 3;
        Libro[] mensola = new Libro[MAXLIBRI];

        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                default -> {

                }
            }
        } while (!fine);
    }

    public static void metodo(Libro[] mensola) {

    }
}