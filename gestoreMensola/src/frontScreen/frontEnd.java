package frontScreen;
import java.util.Scanner;
import mensola.*;
import Utility.Tools.*;

import static Utility.Tools.Menu;

public class frontEnd {
    public static Libro leggiLibro(Scanner tastiera){
        Libro l = new Libro();
        System.out.println("Inserisci l'autore");
        l.autore = tastiera.nextLine();
        System.out.println("Inserisci il titolo");
        l.titolo = tastiera.nextLine();
        System.out.println("Inserisci il tipo");
        String[] opzioni = {"Tipi libro", ""};
        switch (Menu(opzioni, tastiera)){
            case 1 -> l.tipo = Genere.romanzo;
            case 2 -> l.tipo = Genere.manuale;
            case 3 -> l.tipo = Genere.thriller;
        }
        System.out.println("Inserisci la data di pubblicazione");
        l.titolo = tastiera.nextLine();

        return l;

        //CIAOOOO :))
    }
}
