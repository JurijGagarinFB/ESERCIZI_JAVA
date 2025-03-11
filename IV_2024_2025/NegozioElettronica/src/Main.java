import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NegozioElettronica negozio = new NegozioElettronica();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserisci smartphone");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Cerca prodotto");
            System.out.println("4. Modifica prezzo");
            System.out.println("5. Visualizza prodotti");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (scelta) {
                    case 1 -> {
                        System.out.print("Codice: ");
                        int codice = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Prezzo: ");
                        double prezzo = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Modello: ");
                        String modello = scanner.nextLine();
                        System.out.print("Memoria (GB): ");
                        int memoria = scanner.nextInt();
                        scanner.nextLine();

                        negozio.aggiungiProdotto(new Smartphone(codice, marca, prezzo, modello, memoria));
                        System.out.println("Smartphone aggiunto con successo.");
                    }
                    case 2 -> {
                        System.out.print("Codice: ");
                        int codice = scanner.nextInt();
                        scanner.nextLine();
                        negozio.rimuoviProdotto(codice);
                        System.out.println("Prodotto rimosso.");
                    }
                    case 3 -> {
                        System.out.print("Codice: ");
                        int codice = scanner.nextInt();
                        scanner.nextLine();
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