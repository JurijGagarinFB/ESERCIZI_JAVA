public class Cronometro {
    private long tempoInizio;
    private long tempoFine;
    private boolean inEsecuzione;

    public Cronometro() {
        this.tempoInizio = 0;
        this.tempoFine = 0;
        this.inEsecuzione = false;
    }

    // Avvia il cronometro
    public void avvia() {
        if (!inEsecuzione) {
            this.tempoInizio = System.currentTimeMillis();
            this.inEsecuzione = true;
        } else {
            System.out.println("Il cronometro è già avviato.");
        }
    }

    // Ferma il cronometro
    public void ferma() {
        if (inEsecuzione) {
            this.tempoFine = System.currentTimeMillis();
            this.inEsecuzione = false;
        } else {
            System.out.println("Il cronometro non è avviato.");
        }
    }

    // Resetta il cronometro
    public void resetta() {
        this.tempoInizio = 0;
        this.tempoFine = 0;
        this.inEsecuzione = false;
    }

    // Ottieni il tempo trascorso in millisecondi
    public long ottieniTempoTrascorsoMillis() {
        if (inEsecuzione) {
            return System.currentTimeMillis() - tempoInizio;
        } else {
            return tempoFine - tempoInizio;
        }
    }

    // Ottieni il tempo trascorso in secondi
    public double ottieniTempoTrascorsoSecondi() {
        return ottieniTempoTrascorsoMillis() / 1000.0;
    }
}
