/*
Bazaj Francesco     4F     28/10/2024
 */


import java.util.ArrayList;
import java.util.Scanner;


import mensola.*;

import static utility.Tools.*;
import static frontScreen.FrontEnd.*;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String[] opzioni = {"--Mensola--", "1-Inserimento", "2-Visualizzazione", "3-Visualizzazione Prezzi", "4-Scorri mensola", "5-Ricerca", "6-Elimina", "7-Modifica pagine", "8-Fine"};
        boolean fine = false;

        String[] opzioniScorrimento = {"--Scorrimento--", "1-Precedente", "2-Successivo", "3-Fine"};

        ArrayList<Libro> mensola = new ArrayList<>();
        final int MAXLIBRI = 3;
        int cont = 0, nNuovePagine = 0;

        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {
                    System.out.println("Inserimento");
                    if (cont < MAXLIBRI) {
                        Libro nuovoLibro = LeggiLibro(tastiera);

                        if (ricercaLibro(mensola, cont, nuovoLibro) == -1) {
                            mensola.add(nuovoLibro);
                            cont++;
                        } else {
                            System.out.println("Il libro è già presente.");
                        }
                    } else {
                        System.out.println("Non è possibile inserire altri libri");
                    }
                }


                case 2 -> {
                    System.out.println("Visualizzazione");
                    if (cont > 0) {
                        for (int i = 0; i < cont; i++)
                            System.out.println(mensola.get(i).FormattaDati());
                    } else {
                        System.out.println("Nessun libro da visualizzare ");
                    }
                }


                case 3 -> {
                    System.out.println("Visualizzazione Prezzi");
                    if (cont > 0) {
                        for (int i = 0; i < cont; i++)
                            System.out.println(mensola.get(i).ListaPrezzi());
                    } else {
                        System.out.println("Nessun libro da visualizzare ");
                    }
                }


                case 4 -> {
                    boolean uscitaScorrimento = false;
                    System.out.println("Scorrimento mensola");
                    System.out.println("Numero di libri presenti: " + cont);
                    System.out.println("Inserisci posizione di partenza: ");
                    int posPartenza = Integer.parseInt(tastiera.nextLine());
                    System.out.println("Libro di partenza: \n" + mensola.get(posPartenza - 1).FormattaDati());
                    do {
                        switch (Menu(opzioniScorrimento, tastiera)) {
                            case 1 -> {
                                if (posPartenza > 1) {
                                    posPartenza -= 1;
                                    System.out.println(mensola.get(posPartenza - 1).FormattaDati());
                                } else {
                                    System.out.println("Sei al primo libro");
                                }
                            }

                            case 2 -> {
                                if (posPartenza == cont) {
                                    posPartenza += 1;
                                    System.out.println(mensola.get(posPartenza - 1).FormattaDati());
                                } else {
                                    System.out.println("Sei all'ultimo libro");
                                }
                            }

                            case 3 -> {
                                System.out.println("Uscita dallo scorrimento");
                                uscitaScorrimento = true;
                            }
                        }
                    } while (!uscitaScorrimento);
                }


                case 5 -> {
                    System.out.println("Ricerca");
                    if (cont > 0) {
                        System.out.println("Inserisci titolo e autore del libro da cercare");
                        Libro libroDaCercare = new Libro();
                        System.out.println("Titolo: ");
                        libroDaCercare.Titolo = tastiera.nextLine();
                        System.out.println("Autore: ");
                        libroDaCercare.Autore = tastiera.nextLine();
                        if (ricercaLibro(mensola, cont, libroDaCercare) != -1) {
                            System.out.println("Libro presente in posizione " + ricercaLibro(mensola, cont, libroDaCercare));
                        } else {
                            System.out.println("Libro non presente");
                        }
                    } else {
                        System.out.println("Nessun libro da visualizzare");
                    }
                }


                case 6 -> {
                    System.out.println("Elimina");
                    if (cont > 0) {
                        System.out.println("Inserisci titolo e autore del libro da eliminare");
                        Libro libroDaCancellare = new Libro();
                        System.out.println("Titolo: ");
                        libroDaCancellare.Titolo = tastiera.nextLine();
                        System.out.println("Autore: ");
                        libroDaCancellare.Autore = tastiera.nextLine();
                        if (eliminaLibro(mensola, cont, libroDaCancellare) != -1) {
                            System.out.println("Libro in posizione %d eliminato" + eliminaLibro(mensola, cont, libroDaCancellare));
                            cont--;
                        } else {
                            System.out.println("Nessun libro cancellato");
                        }
                    } else {
                        System.out.println("Nessun libro presente");
                    }
                }


                case 7 -> {
                    System.out.println("Modifica pagine");
                    if (cont > 0) {
                        System.out.println("Inserisci titolo e autore del libro da modificare");
                        Libro libroDaModificare = new Libro();
                        System.out.println("Titolo: ");
                        libroDaModificare.Titolo = tastiera.nextLine();
                        System.out.println("Autore: ");
                        libroDaModificare.Autore = tastiera.nextLine();
                        if (ricercaLibro(mensola, cont, libroDaModificare) != -1) {
                            System.out.println("Inserisci il nuovo numero di pagine");
                            nNuovePagine = Integer.parseInt(tastiera.nextLine());
                            modificaPagine(mensola, cont, libroDaModificare, nNuovePagine);
                            if (modificaPagine(mensola, cont, libroDaModificare, nNuovePagine) != -1) {
                                System.out.printf("Libro in posizione %d modificato\n", modificaPagine(mensola, cont, libroDaModificare, nNuovePagine));
                            } else {
                                System.out.println("Nessun libro modificato");
                            }
                        } else {
                            System.out.println("Libro non trovato");
                        }
                    } else {
                        System.out.println("Nessun libro presente");
                    }
                }


                case 8 -> {
                    System.out.println("Uscita");
                    fine = true;
                }

            }
        } while (!fine);
    }


    public static int ricercaLibro(ArrayList<Libro> mensola, int cont, Libro nuovoLibro) {
        for (int i = 0; i < cont; i++) {
            if (mensola.get(i).Autore.equalsIgnoreCase(nuovoLibro.Autore) && mensola.get(i).Titolo.equalsIgnoreCase(nuovoLibro.Titolo)) {
                return i;
            }
        }
        return -1;
    }


    public static int eliminaLibro(ArrayList<Libro> mensola, int cont, Libro libroDaCancellare) {
        if (ricercaLibro(mensola, cont, libroDaCancellare) != -1) {
            mensola.remove(ricercaLibro(mensola, cont, libroDaCancellare));
            return ricercaLibro(mensola, cont, libroDaCancellare);
        }
        return -1;
    }


    public static int modificaPagine(ArrayList<Libro> mensola, int cont, Libro libroDaModificare, int nNuovePagine) {
        if (ricercaLibro(mensola, cont, libroDaModificare) != -1) {
            mensola.get(ricercaLibro(mensola, cont, libroDaModificare)).pagine = nNuovePagine;
            return ricercaLibro(mensola, cont, libroDaModificare);
        }
        return -1;
    }
}