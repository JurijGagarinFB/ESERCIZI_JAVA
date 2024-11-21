import java.util.ArrayList;

public class Rettangolo {
    private double base;
    private double altezza;
    private Punto punto;
    private ArrayList<Segmento> segmenti;

    // Costruttore
    public Rettangolo(double base, double altezza, Punto punto) throws Exception {
        this.base = base;
        this.altezza = altezza;
        this.punto = punto;

        // Controllo se il rettangolo rimane nel primo quadrante
        if (punto.getX() < 0 || punto.getY() < 0 || punto.getY() - altezza < 0) {
            throw new Exception("Il rettangolo esce dal primo quadrante!");
        }

        this.segmenti = calcolaSegmenti();
    }

    // Metodo per calcolare i quattro segmenti del rettangolo
    private ArrayList<Segmento> calcolaSegmenti() {
        ArrayList<Segmento> segmenti = new ArrayList<>();

        // Calcolo dei quattro vertici (il vertice in alto a sinistra è già presente e quindi viene usato per il calcolo degli altri tre togliendo dalle coordinate x e y del punto le lunghezze di base e altezza in base a ciò che bisogna calcolare)
        Punto bassoSinistra = new Punto(punto.getX(), punto.getY() - altezza);
        Punto bassoDestra = new Punto(punto.getX() + base, punto.getY() - altezza);
        Punto altoDestra = new Punto(punto.getX() + base, punto.getY());

        // Creazione dei segmenti
        segmenti.add(new Segmento(punto, altoDestra)); // Lato superiore
        segmenti.add(new Segmento(altoDestra, bassoDestra)); // Lato destro
        segmenti.add(new Segmento(bassoDestra, bassoSinistra)); // Lato inferiore
        segmenti.add(new Segmento(bassoSinistra, punto)); // Lato sinistro

        return segmenti;
    }

    // Metodo per calcolare l'area
    private double calcolaArea() {
        return base * altezza;
    }

    // Metodo per calcolare il perimetro
    private double calcolaPerimetro() {
        return 2 * (base + altezza);
    }


    public double getBase() {
        return base;
    }

    public double getAltezza() {
        return altezza;
    }

    public Punto getPunto() {
        return punto;
    }

    public ArrayList<Segmento> getSegmenti() {
        return segmenti;
    }


    @Override
    public String toString() {
        return "Rettangolo: Base=" + base + " , Altezza=" + altezza + " - Punto in alto a sinistra: " + punto + " - Area=" + calcolaArea() + " - Perimetro=" + calcolaPerimetro();
    }

    /* TEST METODI PER RAPPRESENTARE GRAFICAMENTE RETTANGOLO. NON APPLICATI CAUSA INCERTEZZA FUNZIONAMENTO CORRETTO
    // Metodo per visualizzare il rettangolo e il piano cartesiano in ASCII
    public void visualizzaPianoCartesiano() {
        int larghezza = (int) Math.ceil(punto.getX()); // Estensione sull'asse X
        int altezzaMassima = (int) Math.ceil(punto.getY()); // Estensione sull'asse Y
        int baseInt = (int) Math.ceil(base);
        int altezzaInt = (int) Math.ceil(altezza);

        // Disegno del piano cartesiano
        for (int y = altezzaMassima + 1; y >= 0; y--) { // Scorriamo le righe dall'alto verso il basso
            for (int x = 0; x <= larghezza + 1; x++) { // Scorriamo le colonne da sinistra a destra

                // Disegna gli assi
                if (x == 0 && y == 0) {
                    System.out.print("+"); // Origine
                } else if (x == 0) {
                    System.out.print("|"); // Asse Y
                } else if (y == 0) {
                    System.out.print("-"); // Asse X
                } else if (isInsideRettangolo(x, y, baseInt, altezzaInt)) {
                    System.out.print("*"); // Parte del rettangolo
                } else {
                    System.out.print(" "); // Vuoto
                }
            }
            System.out.println();
        }
    }

    // Metodo per verificare se un punto è all'interno del rettangolo
    private boolean appartenenzaRettangolo(int x, int y, int baseInt, int altezzaInt) {
        int xInizio = (int) Math.ceil(punto.getX()) - baseInt;
        int xFine = (int) Math.ceil(punto.getX());
        int yInizio = (int) Math.ceil(punto.getY()) - altezzaInt;
        int yFine = (int) Math.ceil(punto.getY());

        return x >= xInizio && x <= xFine && y >= yInizio && y <= yFine;
    }
     */
}
