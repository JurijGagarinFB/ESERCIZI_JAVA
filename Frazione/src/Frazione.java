import java.util.ArrayList;

public class Frazione {
    private int numeratore, denominatore;
    private double risultato;

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public double getRisultato() {
        return risultato;
    }

    public Frazione(int numeratore, int denominatore) throws Exception {
        if (denominatore == 0) {
            throw new Exception("Il denominatore non può essere nullo");
        }
        this.numeratore = numeratore;
        this.denominatore = denominatore;
        this.risultato = (double) numeratore / denominatore;
    }

    public Frazione(String frazione) throws Exception {
        ArrayList<Integer> componentiNum = new ArrayList<>();
        ArrayList<Integer> componentiDen = new ArrayList<>();
        boolean trovato = false;
        for (int i = frazione.length() - 1; i > 0; i--) {
            if (frazione.charAt(i) == '/') {
                trovato = true;
            }
            if (!trovato) {
                componentiDen.add((int) frazione.charAt(i));
            } else {
                componentiNum.add((int) frazione.charAt(i - 1));
            }
        }

        int numeratore = 0;
        int denominatore = 0;
        int moltiplicatore = 1;

        for (int i = 0; i < componentiNum.size(); i++) {
            numeratore += componentiNum.get(i) * moltiplicatore;
            moltiplicatore *= 10;
        }
        for (int i = 0; i < componentiDen.size(); i++) {
            denominatore += componentiDen.get(i) * moltiplicatore;
            moltiplicatore *= 10;
        }

        if (denominatore == 0) {
            throw new Exception("Il denominatore non può essere nullo");
        }
        this.numeratore = numeratore;
        this.denominatore = denominatore;
        this.risultato = (double) numeratore / denominatore;
    }

    public String sommaFrazione(Frazione frazione1, Frazione frazione2) {
        if (frazione1.getDenominatore() == frazione2.getDenominatore()) {
            return frazione1.getNumeratore() + frazione2.getNumeratore() + "/" + frazione1.getDenominatore();
        }
        int denominatore = 0;
        int i = 1;
        do {
            if (i % frazione1.getDenominatore() == 0 && i % frazione2.getDenominatore() == 0) {
                denominatore = i;
            }
            i++;
        } while (denominatore == 0);
        double primoAddendo = ((double) denominatore / frazione1.getDenominatore()) * frazione1.getNumeratore();
        double secondoAddendo = ((double) denominatore / frazione2.getDenominatore()) * frazione2.getNumeratore();
        double numeratore = primoAddendo + secondoAddendo;
        return numeratore + "/" + denominatore;
    }

    public double sommaFrazione2(Frazione frazione1, Frazione frazione2) {
        if (frazione1.getDenominatore() == frazione2.getDenominatore()) {
            return (double) (frazione1.getNumeratore() + frazione2.getNumeratore()) / frazione1.getDenominatore();
        }
        int denominatore = 0;
        int i = 1;
        do {
            if (i % frazione1.getDenominatore() == 0 && i % frazione2.getDenominatore() == 0) {
                denominatore = i;
            }
            i++;
        } while (denominatore == 0);
        double primoAddendo = ((double) denominatore / frazione1.getDenominatore()) * frazione1.getNumeratore();
        double secondoAddendo = ((double) denominatore / frazione2.getDenominatore()) * frazione2.getNumeratore();
        double numeratore = primoAddendo + secondoAddendo;
        return numeratore/denominatore;
    }

    @Override
    public String toString() {
        return "Risultato espresso in frazione: " + sommaFrazione() + "Risultato espresso in valore: " + sommaFrazione2();
    }
}
