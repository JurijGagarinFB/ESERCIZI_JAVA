/*
Bazaj Francesco     4F     15/11/2024
Creare classe "Pilota" che contiene nome, cognome, nazionalità, età;
Creare classe "Auto" che contiene una scuderia(stringa), il pilota, cilindrata;
Creare le classi definite con metodi ed i costruttori considerando che le classi devono implementare i metodi toString ed il metodo Equals, gestendo eventuali eccezioni che si potrebbero generare.
Verificare la funzionalità delle classi considerando che non possono esistere due piloti con lo stesso nome, cognome ed età
 */

import java.util.Scanner;
import java.util.ArrayList;

import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String[] opzioni = {"GARA", "1-Inserisci Auto", "2-Visualizza Auto", "3-Rimuovi Auto", "4-Esci"};
        boolean fine = false;

        ArrayList<Auto> Gara = new ArrayList<>();
        final int MAXAUTO = 10;
        int nAuto = 0;
        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {
                    System.out.println("Inserimento Auto");
                    if (nAuto <= MAXAUTO) {
                        try {
                            System.out.println("Inserisci nome pilota: ");
                            String nomePilota = tastiera.nextLine();
                            System.out.println("Inserisci cognome pilota: ");
                            String cognomePilota = tastiera.nextLine();
                            System.out.println("Inserisci nazionalità pilota: ");
                            String nazionalitaPilota = tastiera.nextLine();
                            System.out.println("Inserisci età pilota: ");
                            int etaPilota = Integer.parseInt(tastiera.nextLine());
                            Pilota pilota = aggiuntaPilota(nomePilota, cognomePilota, nazionalitaPilota, etaPilota);
                            if (cercaPilota(Gara, pilota) != -1) {
                                System.out.println("Questo pilota è già in gara!");
                            } else {
                                System.out.println("Inserisci scuderia (redbull,mercedes,ferrari): ");
                                Scuderie scuderia = Scuderie.valueOf(tastiera.nextLine().toUpperCase());
                                System.out.println("Inserisci cilindrata: ");
                                int cilindrata = Integer.parseInt(tastiera.nextLine());
                                Gara.add(new Auto(scuderia, pilota, cilindrata));
                                nAuto++;
                                System.out.println("Hai inserito la seguente auto: ");
                                System.out.println(Gara.getLast().toString());
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
                    for (int i = 0; i < Gara.size(); i++) {
                        System.out.println(Gara.get(i).toString());
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Rimozione Auto");
                        System.out.println("Inserisci nome pilota: ");
                        String nomePilota = tastiera.nextLine();
                        System.out.println("Inserisci cognome pilota: ");
                        String cognomePilota = tastiera.nextLine();
                        System.out.println("Inserisci nazionalità pilota: ");
                        String nazionalitaPilota = tastiera.nextLine();
                        System.out.println("Inserisci età pilota: ");
                        int etaPilota = Integer.parseInt(tastiera.nextLine());
                        Pilota pilota = aggiuntaPilota(nomePilota, cognomePilota, nazionalitaPilota, etaPilota);
                        if (cercaPilota(Gara, pilota) != -1) {
                            Gara.remove(cercaPilota(Gara, pilota));
                        } else {
                            System.out.println("Pilota e corrispondente auto da rimuovere non trovati");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.println("Uscita programma");
                    fine = true;
                }
            }
        } while (!fine);
    }

    public static int cercaPilota(ArrayList<Auto> Gara, Pilota pilota) {
        for (int i = 0; i < Gara.size(); i++) {
            if (pilota.getNome().equals(Gara.get(i).getPilota().getNome()) && pilota.getCognome().equals(Gara.get(i).getPilota().getCognome()) && pilota.getEta() == Gara.get(i).getPilota().getEta()) {
                return i;
            }
        }
        return -1;
    }

    public static Pilota aggiuntaPilota(String nome, String cognome, String nazionalita, int eta) throws Exception {
        Pilota pilota = new Pilota(nome, cognome, nazionalita, eta);
        return pilota;
    }
}