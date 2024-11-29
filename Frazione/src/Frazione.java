import java.util.ArrayList;

public class Frazione {
    private int numeratore, denominatore;

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public Frazione(int numeratore, int denominatore) throws Exception {
        if (denominatore == 0) {
            throw new Exception("Il denominatore non può essere nullo");
        }
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public Frazione(String frazione) throws Exception {
        ArrayList<Integer> componentiNum = new ArrayList<>();
        ArrayList<Integer> componentiDen = new ArrayList<>();
        boolean trovato = false;

        for (int i = frazione.length() - 1; i >= 0; i--) {
            char carattere = frazione.charAt(i);
            if (carattere == '/') {
                trovato = true;
                continue;
            }
            if (!trovato) {
                componentiDen.add(carattere - '0'); //uso -'0' perché in questo caso sto usando gli ascii. codice ascii dello 0 è 48. se ad esempio il numero è 1, 49-48 = 1.
            } else {
                componentiNum.add(carattere - '0');
            }
        }

        int numeratore = 0;
        int denominatore = 0;
        int moltiplicatore = 1;

        for (int i = 0; i < componentiNum.size(); i++) {
            numeratore += componentiNum.get(i) * moltiplicatore;
            moltiplicatore *= 10;
        }

        moltiplicatore = 1;
        for (int i = 0; i < componentiDen.size(); i++) {
            denominatore += componentiDen.get(i) * moltiplicatore;
            moltiplicatore *= 10;
        }

        if (denominatore == 0) {
            throw new Exception("Il denominatore non può essere nullo");
        }

        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }


    private String sommaFrazioneRitornaStringa(Frazione frazione2) {
        if (this.denominatore == frazione2.getDenominatore()) {
            return (this.numeratore + frazione2.getNumeratore()) + "/" + this.denominatore;
        }

        int denominatore = 0;
        int i = 1;
        do {
            if (i % this.denominatore == 0 && i % frazione2.getDenominatore() == 0) {
                denominatore = i;
            }
            i++;
        } while (denominatore == 0);

        double primoAddendo = ((double) denominatore / this.denominatore) * this.numeratore;
        double secondoAddendo = ((double) denominatore / frazione2.getDenominatore()) * frazione2.getNumeratore();
        double numeratore = primoAddendo + secondoAddendo;

        return (int) numeratore + "/" + denominatore;
    }


    public String sommaFrazioneRitornaStringa(String frazioneInput) throws Exception {
        Frazione frazione2 = new Frazione(frazioneInput);
        return this.sommaFrazioneRitornaStringa(frazione2);
    }


    public String sommaFrazioneRitornaStringa(int numeratore, int denominatore) throws Exception {
        Frazione frazione2 = new Frazione(numeratore, denominatore);
        return this.sommaFrazioneRitornaStringa(frazione2);
    }


    private double sommaFrazioneRitornaValore(Frazione frazione2) {
        if (this.denominatore == frazione2.getDenominatore()) {
            return (double) (this.numeratore + frazione2.getNumeratore()) / this.denominatore;
        }

        int denominatore = 0;
        int i = 1;
        do {
            if (i % this.denominatore == 0 && i % frazione2.getDenominatore() == 0) {
                denominatore = i;
            }
            i++;
        } while (denominatore == 0);

        double primoAddendo = ((double) denominatore / this.denominatore) * this.numeratore;
        double secondoAddendo = ((double) denominatore / frazione2.getDenominatore()) * frazione2.getNumeratore();
        double numeratore = primoAddendo + secondoAddendo;

        return numeratore / denominatore;
    }


    public double sommaFrazioneRitornaValore(String frazioneInput) throws Exception {
        Frazione frazione2 = new Frazione(frazioneInput);
        return this.sommaFrazioneRitornaValore(frazione2);
    }


    public double sommaFrazioneRitornaValore(int numeratore, int denominatore) throws Exception {
        Frazione frazione2 = new Frazione(numeratore, denominatore);
        return this.sommaFrazioneRitornaValore(frazione2);
    }
}
