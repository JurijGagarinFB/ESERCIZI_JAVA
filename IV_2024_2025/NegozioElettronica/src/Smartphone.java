public class Smartphone extends ProdottoElettronico {
    private String modello;
    private int memoria;

    public Smartphone(int codice, String marca, double prezzo, int quantita, String modello, int memoria) {
        super(codice, marca, prezzo, quantita);
        if (memoria <= 0) throw new IllegalArgumentException("La memoria deve essere maggiore di 0.");
        this.modello = modello;
        this.memoria = memoria;
    }

    @Override
    public String getNome() {
        return modello;
    }

    @Override
    public String getDescrizione() {
        return "Smartphone " + marca + " modello " + modello + " con " + memoria + "GB di memoria.";
    }

    @Override
    public String toString() {
        return super.toString() + ", Modello: " + modello + ", Memoria: " + memoria + "GB";
    }
}
