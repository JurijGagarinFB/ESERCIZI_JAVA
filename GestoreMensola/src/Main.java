/*
Bazaj Francesco     4F    21/10/2023
*/

import mensola.Libro;

import java.time.LocalDate;
import java.util.Scanner;

import static utility.Tools.*;
import static frontScreen.FrontEnd.*;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        final int MAXLIBRI = 3;
        Libro[] mensola = new Libro[MAXLIBRI];

        boolean uscita = false;
        int cont = 0;
        do {
            String[] opzioni = {"---MENSOLA---", "1. Inserimento", "2. Visualizza", "3. Elimina", "4. Ricerca", "5. Modifica data di pubblicazione", "6. Fine"};
            int scelta = Menu(opzioni, tastiera);
            switch (scelta) {

                case 1 -> {
                    System.out.println("Inserimento");
                    if (cont < MAXLIBRI) {
                        Libro nuovoLibro = LeggiLibro(tastiera);
                        boolean presente = libroDoppio(mensola, cont, nuovoLibro);
                        if (!presente) {
                            mensola[cont] = nuovoLibro;
                            cont++;
                        } else
                            System.out.println("Il libro è già presente.");

                    } else
                        System.out.println("Non è possibile inserire altri libri");

                }
                case 2 -> {
                    System.out.println("Visualizzazione");
                    System.out.println("Quale tra i " + cont + " vuoi visualizzare?");
                    int sceltaLibro = Integer.parseInt(tastiera.nextLine());
                    if (sceltaLibro <= cont && sceltaLibro > 0)
                        System.out.println(mensola[sceltaLibro - 1].FormattaDati());
                    else
                        System.out.println("Scelta non valida");

                }

                case 3 -> {
                    System.out.println("Elimina");
                    System.out.println("Quale libro vuoi cancellare? (1-" + cont + ")");
                    int sceltaLibro = Integer.parseInt(tastiera.nextLine());
                    cancellaLibro(mensola, cont, sceltaLibro);
                    if (cancellaLibro(mensola, cont, sceltaLibro) > 0)
                        System.out.println("Libro cancellato con successo.");
                    else
                        System.out.println("Scelta non valida.");

                }

                case 4 -> {
                    System.out.println("Ricerca per titolo e autore");
                    System.out.print("Inserisci il titolo: ");
                    String titolo = tastiera.nextLine();
                    System.out.print("Inserisci l'autore: ");
                    String autore = tastiera.nextLine();
                    Libro trovato = ricerca(mensola, cont, titolo, autore);
                    if (trovato != null)
                        System.out.println("Libro trovato: " + trovato.FormattaDati());
                    else
                        System.out.println("Libro non trovato.");

                }

                case 5 -> {
                    System.out.println("Modifica data di pubblicazione");
                    System.out.println("Inserisci il titolo: ");
                    String titolo = tastiera.nextLine();
                    System.out.println("Inserisci l'autore: ");
                    String autore = tastiera.nextLine();
                    Libro libroMod = ricerca(mensola, cont, titolo, autore);
                    if (libroMod != null) {
                        System.out.println("Inserisci la nuova data: ");
                        String nuovaData = tastiera.nextLine();
                        if (modificaData(libroMod, nuovaData))
                            System.out.println("Data di pubblicazione modificata");
                        else
                            System.out.println("Errore nella modifica!");

                    } else
                        System.out.println("Libro non trovato");
                }

                case 6 -> {
                    System.out.println("Fine");
                    uscita = true;
                }
            }
        } while (!uscita);
    }

    public static boolean libroDoppio(Libro[] mensola, int cont, Libro nuovoLibro) {

        for (int i = 0; i < cont; i++) {
            if (mensola[i].Autore.equalsIgnoreCase(nuovoLibro.Autore) &&
                    mensola[i].Titolo.equalsIgnoreCase(nuovoLibro.Titolo)) {
                return true; // Doppione trovato
            }
        }
        return false; // Nessun doppione trovato
    }

    public static int cancellaLibro(Libro[] mensola, int cont, int sceltaLibro) {

        if (sceltaLibro > 0 && sceltaLibro <= cont) {
            for (int i = sceltaLibro - 1; i < cont - 1; i++) {
                mensola[i] = mensola[i + 1]; // Sposta i libri verso sinistra
            }
            mensola[cont - 1] = null; // Libera l'ultimo spazio
            cont--;
            return 1;


        } else {

            return 0;
        }
    }


    public static Libro ricerca(Libro[] mensola, int cont, String titolo, String autore) {
        for (int i = 0; i < cont; i++) {
            if (mensola[i].Titolo.equalsIgnoreCase(titolo) && mensola[i].Autore.equalsIgnoreCase(autore))
                return mensola[i];  // Libro trovato

        }
        return null;  // Libro non trovato
    }

    public static boolean modificaData(Libro libro, String nuovaData) {
        if (libro != null) {
            libro.dataDiPubblicazione = LocalDate.parse(nuovaData);  // Modifica la data di pubblicazione
            return true;
        }
        return false;
    }


}