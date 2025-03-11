public class Smartphone extends ProdottoElettronico {
    private String modello;
    private int memoria;

    public Smartphone(int codice, String marca, double prezzo, String modello, int memoria) {
        super(codice, marca, prezzo);
        if (memoria <= 0) throw new IllegalArgumentException("La memoria deve essere maggiore di 0.");
        this.modello = modello;
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return super.toString() + ", Modello: " + modello + ", Memoria: " + memoria + "GB";
    }
}