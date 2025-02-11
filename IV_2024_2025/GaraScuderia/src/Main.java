/*
Bazaj Francesco     4F     15/11/2024
Creare classe "Pilota" che contiene nome, cognome, nazionalità, età;
Creare classe "Auto" che contiene una scuderia(stringa), il pilota, cilindrata;
Creare le classi definite con metodi ed i costruttori considerando che le classi devono implementare i metodi toString ed il metodo Equals, gestendo eventuali eccezioni che si potrebbero generare.
Verificare la funzionalità delle classi considerando che non possono esistere due piloti con lo stesso nome, cognome ed età

16/11/2024
Creare la classe gara considerando una gara è composta dal nome della gara, da un risultato e da una collezione di auto.
Definire il metodo corriGara che permette di correre una gara e determinarne il risultato (nome del pilota vincitore).
Considerando gli attributi delle classi create determinare un soluzione per il metodo corriGara.
Testare il codice realizzato.
*/

import java.util.Scanner;
import java.util.ArrayList;

import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String[] opzioni = {"GARA", "1-Inserisci Auto", "2-Visualizza Auto", "3-Rimuovi Auto", "4-Inizia Gara", "5-Esci"};
        boolean fine = false;

        ArrayList<Auto> corsa = new ArrayList<>();
        final int MAXAUTO = 10;
        int nAuto = 0;
        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {
                    System.out.println("Inserimento Auto");
                    if (nAuto <= MAXAUTO) {
                        try {
                            Pilota pilota = aggiuntaPilota(tastiera);
                            if (cercaPilota(corsa, pilota) != -1) {
                                System.out.println("Questo pilota è già in gara!");
                            } else {
                                corsa.add(aggiuntaAuto(tastiera, pilota));
                                nAuto++;
                                System.out.println("Hai inserito la seguente auto: ");
                                System.out.println(corsa.getLast().toString());
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Sono già presenti tutte le auto della gara (max 10)");
                    }
                }

                case 2 -> {
                    System.out.println("Visualizzazione Auto");
                    for (int i = 0; i < corsa.size(); i++) {
                        System.out.println(corsa.get(i).toString());
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Rimozione Auto");
                        Pilota pilota = aggiuntaPilota(tastiera);
                        if (cercaPilota(corsa, pilota) != -1) {
                            corsa.remove(cercaPilota(corsa, pilota));
                            nAuto--;
                        } else {
                            System.out.println("Pilota e corrispondente auto da rimuovere non trovati");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.println("INIZIO GARA");
                    System.out.println("Inserisci nome gara: ");
                    String nomeGara = tastiera.nextLine();
                    System.out.println("Auto gareggianti: ");
                    for (int i = 0; i < corsa.size(); i++) {
                        System.out.println(corsa.get(i).toString());
                    }
                    Gara gara = new Gara(nomeGara, corsa);
                    System.out.println("Vincitore: " + gara.getRisultato().toString());
                    System.out.println("Fine gara");
                }

                case 5 -> {
                    System.out.println("Uscita programma");
                    fine = true;
                }
            }
        } while (!fine);
    }

    public static int cercaPilota(ArrayList<Auto> corsa, Pilota pilota) {
        for (int i = 0; i < corsa.size(); i++) {
            if (pilota.getNome().equals(corsa.get(i).getPilota().getNome()) && pilota.getCognome().equals(corsa.get(i).getPilota().getCognome()) && pilota.getEta() == corsa.get(i).getPilota().getEta()) {
                return i;
            }
        }
        return -1;
    }

    public static Pilota aggiuntaPilota(Scanner tastiera) throws Exception {
        System.out.println("Inserisci nome pilota: ");
        String nomePilota = tastiera.nextLine();
        System.out.println("Inserisci cognome pilota: ");
        String cognomePilota = tastiera.nextLine();
        System.out.println("Inserisci nazionalità pilota: ");
        String nazionalitaPilota = tastiera.nextLine();
        System.out.println("Inserisci età pilota: ");
        int etaPilota = Integer.parseInt(tastiera.nextLine());
        Pilota pilota = new Pilota(nomePilota, cognomePilota, nazionalitaPilota, etaPilota);
        return pilota;
    }

    public static Auto aggiuntaAuto(Scanner tastiera, Pilota pilota) throws Exception {
        System.out.println("Inserisci scuderia (redbull,mercedes,ferrari): ");
        Scuderie scuderia = Scuderie.valueOf(tastiera.nextLine().toUpperCase());
        System.out.println("Inserisci cilindrata: ");
        int cilindrata = Integer.parseInt(tastiera.nextLine());
        return new Auto(scuderia, pilota, cilindrata);
    }
}