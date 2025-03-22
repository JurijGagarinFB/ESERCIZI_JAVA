import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NegozioElettronica negozio = new NegozioElettronica();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserisci prodotto");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Cerca prodotto");
            System.out.println("4. Modifica prezzo");
            System.out.println("5. Visualizza prodotti");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");
            int scelta = Integer.parseInt(scanner.nextLine());

            try {
                switch (scelta) {
                    case 1 -> {
                        System.out.print("Codice: ");
                        int codice = Integer.parseInt(scanner.nextLine());
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Prezzo: ");
                        double prezzo = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Modello: ");
                        String modello = scanner.nextLine();
                        System.out.println("Quantita: ");
                        int quantita = Integer.parseInt(scanner.nextLine());
                        System.out.print("Memoria (GB): ");
                        int memoria = Integer.parseInt(scanner.nextLine());


                        negozio.aggiungiProdotto(new Smartphone(codice, marca, prezzo,quantita, modello, memoria));
                        System.out.println("Smartphone aggiunto con successo.");
                    }
                    case 2 -> {
                        System.out.print("Codice: ");
                        int codice = Integer.parseInt(scanner.nextLine());
                        negozio.rimuoviProdotto(codice);
                        System.out.println("Prodotto rimosso.");
                    }
                    case 3 -> {
                        System.out.print("Codice: ");
                        int codice = Integer.parseInt(scanner.nextLine());
                        System.out.println(negozio.cercaProdotto(codice));
                    }
                    case 4 -> {
                        System.out.print("Codice: ");
                        int codice = scanner.nextInt();
                        System.out.print("Nuovo prezzo: ");
                        double nuovoPrezzo = scanner.nextDouble();
                        scanner.nextLine();
                        negozio.modificaPrezzo(codice, nuovoPrezzo);
                        System.out.println("Prezzo aggiornato.");
                    }
                    case 5 -> negozio.visualizzaProdotti();
                    case 6 -> {
                        System.out.println("Uscita...");
                        return;
                    }
                    default -> System.out.println("Scelta non valida.");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}