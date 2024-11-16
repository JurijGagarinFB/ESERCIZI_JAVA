import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static Scuderia.src.Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        boolean esci = false;
        int nBiglietto = 0;
        int nPersone = 0;
        Scanner tastiera = new Scanner(System.in);
        final int MAXPERSONE = 10;
        ArrayList<Persona> listaBiglietti = new ArrayList<>();
        String[] opzioni = {"GESTORE LUNAPARK", "1-Registra entrata", "2-Nuova giostra", "3-Lista giostre per biglietto", "4-Registra uscita", "Esci"};
        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> { //ingresso
                    try {
                        if (nPersone > MAXPERSONE)
                            throw new Exception();
                        nPersone++;
                        Persona p = registraEntrata(++nBiglietto);
                        listaBiglietti.add(p);
                        System.out.println("Numero assegnato al cliente: " + nBiglietto);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Numero biglietto cliente: ");
                    int numeroB = Integer.parseInt(tastiera.nextLine());
                    if (trovaBiglietto(listaBiglietti, numeroB)) {
                        Persona p = nuovaGiostra(numeroB, tastiera);
                        listaBiglietti.add(p);
                    }
                }
                case 3 -> {

                }
                case 4 -> esci = true;
            }
        } while (!esci);
    }

    public static Persona registraEntrata(int nBiglietto) {
        Persona cliente = new Persona();
        cliente.nBiglietto = nBiglietto;
        cliente.momentoEvento = LocalDateTime.now();
        return cliente;
    }

    public static Persona nuovaGiostra(int numeroB, Scanner tastiera) {
        Persona cliente = new Persona();
        boolean esci = false;
        do {
            try {
                System.out.println("GIOSTRE: tagada, ottovolante, ruotapanoramica, autoscontro");
                cliente.giostreProvate = ListaGiostre.valueOf(tastiera.nextLine().toUpperCase());
            } catch (Exception e) {
                System.out.println("Giostra non valida");
                esci = true;
            }
        } while (!esci);

        cliente.nBiglietto = numeroB;
        cliente.momentoEvento = LocalDateTime.now();
        return cliente;
    }

    public static boolean trovaBiglietto(ArrayList<Persona> gestore, int numeroB) {
        for (Persona persona : gestore) {
            if (persona.numeroB == nBiglietto) {
                return true;
            }
        }
        return false;
    }
}