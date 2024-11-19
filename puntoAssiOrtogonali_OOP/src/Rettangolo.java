import java.util.ArrayList;

public class Rettangolo {
    private double base;
    private double altezza;
    private Punto punto; // Punto di origine (in basso a sinistra) del rettangolo
    public ArrayList<Punto> lati;

    // Costruttore della classe Rettangolo
    public Rettangolo(double base, double altezza, Punto punto) {
        this.base = base;
        this.altezza = altezza;
        this.punto = punto;
        this.lati = calcolaVertici();
    }

    // Metodo per calcolare i quattro vertici del rettangolo
    private ArrayList<Punto> calcolaVertici() {
        ArrayList<Punto> vertici = new ArrayList<>();

        // Punto di origine (in basso a sinistra)
        vertici.add(punto);

        // Punto in basso a destra
        vertici.add(new Punto(punto.getX() + base, punto.getY()));

        // Punto in alto a destra
        vertici.add(new Punto(punto.getX() + base, punto.getY() + altezza));

        // Punto in alto a sinistra
        vertici.add(new Punto(punto.getX(), punto.getY() + altezza));

        return vertici;
    }

    // Metodo per calcolare l'area del rettangolo
    public double calcolaArea() {
        return base * altezza;
    }

    // Metodo per calcolare il perimetro del rettangolo
    public double calcolaPerimetro() {
        return 2 * (base + altezza);
    }

    // Getters e Setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
        this.lati = calcolaVertici(); // Aggiorna i vertici
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
        this.lati = calcolaVertici(); // Aggiorna i vertici
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
        this.lati = calcolaVertici(); // Aggiorna i vertici
    }

    // Metodo toString per rappresentare il rettangolo
    @Override
    public String toString() {
        return "Rettangolo [base=" + base + ", altezza=" + altezza + ", punto di origine=" + punto +
                ", area=" + calcolaArea() + ", perimetro=" + calcolaPerimetro() + "]";
    }
}
