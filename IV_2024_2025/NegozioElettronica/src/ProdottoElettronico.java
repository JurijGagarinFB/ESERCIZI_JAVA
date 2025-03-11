abstract public class ProdottoElettronico {
    private int codice;
    private String marca;
    private double prezzo;

    public ProdottoElettronico(int codice, String marca, double prezzo) throws IllegalArgumentException {
        if (prezzo <= 0) throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0.");
        this.codice = codice;
        this.marca = marca;
        this.prezzo = prezzo;
    }

    public int getCodice() {
        return codice;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) throws IllegalArgumentException {
        if (prezzo <= 0) throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0.");
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Codice: " + codice + ", Marca: " + marca + ", Prezzo: " + prezzo;
    }
}
