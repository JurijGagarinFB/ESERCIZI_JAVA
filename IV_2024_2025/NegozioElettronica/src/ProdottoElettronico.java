public abstract class ProdottoElettronico implements Prodotto {
    protected int codice;
    protected String marca;
    protected double prezzo;
    protected int quantita;

    public ProdottoElettronico(int codice, String marca, double prezzo, int quantita) {
        if (prezzo <= 0) throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0.");
        if (quantita < 0) throw new IllegalArgumentException("La quantità non può essere negativa.");
        this.codice = codice;
        this.marca = marca;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public int getCodice() {
        return codice;
    }

    public String getMarca() {
        return marca;
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
        return "Codice: " + codice + ", Marca: " + marca + ", Prezzo: " + prezzo + ", Quantità: " + quantita;
    }
}
