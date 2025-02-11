// Classe PCPortatile (Notebook), sottoclasse di PC
public class PCPortatile extends PC {
    private double peso;            // in Kg
    private double altezza;         // in cm
    private double larghezza;       // in cm
    private double profondità;      // in cm
    private double dimensioneVideo; // in pollici

    public PCPortatile(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, double peso, double altezza, double larghezza, double profondità, double dimensioneVideo) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo);
        this.peso = peso;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondità = profondità;
        this.dimensioneVideo = dimensioneVideo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public double getProfondità() {
        return profondità;
    }

    public void setProfondità(double profondità) {
        this.profondità = profondità;
    }

    public double getDimensioneVideo() {
        return dimensioneVideo;
    }

    public void setDimensioneVideo(double dimensioneVideo) {
        this.dimensioneVideo = dimensioneVideo;
    }

    @Override
    public String toString() {
        return super.toString() + "PCPortatile [peso=" + peso + "Kg, altezza=" + altezza + "cm, larghezza=" + larghezza + "cm, profondità=" + profondità + "cm, dimensioneVideo=" + dimensioneVideo + " pollici]\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || !(obj instanceof PCPortatile)) return false;
        PCPortatile other = (PCPortatile) obj;
        return Double.compare(this.peso, other.peso) == 0 && Double.compare(this.altezza, other.altezza) == 0 && Double.compare(this.larghezza, other.larghezza) == 0 && Double.compare(this.profondità, other.profondità) == 0 && Double.compare(this.dimensioneVideo, other.dimensioneVideo) == 0;
    }
}
