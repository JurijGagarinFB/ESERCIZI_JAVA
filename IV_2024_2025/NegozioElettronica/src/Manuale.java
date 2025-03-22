public class Manuale extends Libro {
    private String argomento;

    public Manuale(String nome, String descrizione, String autore, int ISBN, double prezzo, int quantita, String argomento) {
        super(nome, descrizione, autore, ISBN, prezzo, quantita);
        this.argomento = argomento;
    }

    public String getArgomento() {
        return argomento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Argomento: " + argomento;
    }
}
