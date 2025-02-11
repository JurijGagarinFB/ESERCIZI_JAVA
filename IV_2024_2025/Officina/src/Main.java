import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concessionaria c = new Concessionaria();

        // Creazione di veicoli e aggiunta alla concessionaria
        Veicolo v1 = new Veicolo("Ford", "Fiesta", 3000);
        Veicolo a1 = new Automobile("Ford", "Fiesta", 3000, 3);
        Veicolo m1 = new Moto("Suzuki", "TTT", 1200, 500);

        c.addVeicolo(a1);
        c.addVeicolo(v1);
        c.addVeicolo(m1);

        System.out.println("Ci sono " + c.numeroVeicoli() + " veicoli in concessionaria.");

        // Ricerca di un veicolo
        System.out.println("\nTrova Veicolo:");
        System.out.print("Inserisci marca: ");
        String marca = sc.nextLine();

        System.out.print("Inserisci modello: ");
        String modello = sc.nextLine();

        System.out.print("Inserisci prezzo: ");
        int prezzo = Integer.parseInt(sc.nextLine());
        System.out.println("");
        Veicolo veicoloRicercato = new Veicolo(marca, modello, prezzo);

        try {
            Veicolo trovato = Concessionaria.trovaVeicolo(veicoloRicercato);
            System.out.println("Veicolo trovato: " + trovato);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().equals("Veicolo non trovato")) {
                c.addVeicolo(veicoloRicercato);
                System.out.println("Veicolo aggiunto. Ecco la lista aggiornata:");
                System.out.println(c);
            }
        }

        // Chiudere lo scanner
        sc.close();
    }
}
