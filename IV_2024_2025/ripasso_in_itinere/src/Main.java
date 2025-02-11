import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        creare classe Automobile
        att marca modello cilindrata
        getter setter
        1 costruttore accetta attributi
        1 costruttore accetta un auto
        metodo toString (con override) per la stampa dei tre attributi
        metodo per verificare se due auto sono uguali
        provare il metodo del punto precedente nel main
        meto per confrontare due auto in base alla cilindrata
        provare il metodo del punto precedente nel main
        creare lista di auto (5-6) e stamparla
        ordinare la lista in ordine crescente di cilindrata e stampare
        ordinare la lista in ordine decrescente di cilindrata e stampare
         */

        Automobile auto1 = new Automobile("", "sus", 150);
        Automobile auto2 = new Automobile("Fiat", "500", 50);
        if (auto1.equals(auto2)) {
            System.out.println("Le auto sono uguali");
        } else {
            System.out.println("Le auto non sono uguali");
        }

        if (auto1.compareTo(auto2)==0) {
            System.out.println("Le auto sono uguali");
        }else if (auto1.compareTo(auto2)>0) {
            System.out.println("auto1 ha una cilindrata diversa da auto2");
        }else if (auto1.compareTo(auto2)<0) {
            System.out.println("errore");
        }

        ArrayList<Automobile> lista = new ArrayList<Automobile>();
        lista.add(auto1);
        lista.add(auto2);
        Automobile auto3 = new Automobile("SUS", "3000", 500);
    }
}