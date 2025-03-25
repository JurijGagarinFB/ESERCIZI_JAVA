// Scuole Medie
public class ScuolaMedia extends Scuola {
    private final double CONTRIBUTO_STUDENTE = 150;
    private final double CONTRIBUTO_LABORATORIO = 1100;
    private final double CONTRIBUTO_SEDE = 9000;

    public ScuolaMedia(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroSediAggiuntive, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, 0, numeroSediAggiuntive, numeroLaboratori);
    }

    @Override
    public double calcolaContributo() {
        return numeroStudenti * CONTRIBUTO_STUDENTE + numeroLaboratori * CONTRIBUTO_LABORATORIO + numeroSediAggiuntive * CONTRIBUTO_SEDE;
    }
}