public class Camion extends Veicolo {
    private int pesoTrasportabile;
    private int altezza;
    private int larghezza;
    private Carburante carburante;


    public Camion(String marca, String modello, int prezzo, int pesoTrasportabile, int altezza, int larghezza, Carburante carburante) {
        super(marca, modello, prezzo);
        this.pesoTrasportabile = pesoTrasportabile;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.carburante = carburante;
    }


    public int getPesoTrasportabile() {
        return pesoTrasportabile;
    }

    public void setPesoTrasportabile(int pesoTrasportabile) {
        this.pesoTrasportabile = pesoTrasportabile;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public Carburante getCarburante() {
        return carburante;
    }

    public void setCarburante(Carburante carburante) {
        this.carburante = carburante;
    }

    // Override del metodo toString()
    @Override
    public String toString() {
        return String.format("%s | Peso Trasportabile: %d kg | Altezza: %d cm | Larghezza: %d cm | Carburante: %s",
                super.toString(), pesoTrasportabile, altezza, larghezza, carburante);
    }
}
