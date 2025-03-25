// Scuole Elementari
public class ScuolaElementare extends Scuola {
    private final double CONTRIBUTO_STUDENTE = 125;
    private final double CONTRIBUTO_SEDE = 9000;

    public ScuolaElementare(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroSediAggiuntive) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, 0, numeroSediAggiuntive, 0);
    }

    @Override
    public double calcolaContributo() {
        return numeroStudenti * CONTRIBUTO_STUDENTE + numeroSediAggiuntive * CONTRIBUTO_SEDE;
    }
}