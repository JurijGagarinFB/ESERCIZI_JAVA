public class Libro implements Prodotto {
    private String nome;
    private String descrizione;
    private String autore;
    private int ISBN;
    private double prezzo;
    private int quantita;

    public Libro(String nome, String descrizione, String autore, int ISBN, double prezzo, int quantita) {
        if (prezzo <= 0) throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0.");
        if (quantita < 0) throw new IllegalArgumentException("La quantità non può essere negativa.");
        this.nome = nome;
        this.descrizione = descrizione;
        this.autore = autore;
        this.ISBN = ISBN;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescrizione() {
        return descrizione;
    }

    public String getAutore() {
        return autore;
    }

    public int getCodice() {
        return ISBN;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public int getQuantita() {
        return quantita;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Descrizione: " + descrizione + ", Autore: " + autore + ", ISBN: " + ISBN + ", Prezzo: " + prezzo + ", Quantità: " + quantita;
    }
}
