// Istituti Tecnici
public class Tecnico extends Scuola {
    private final double CONTRIBUTO_CLASSE = 3500;
    private final double CONTRIBUTO_LABORATORIO = 6000;

    public Tecnico(String codice, String denominazione, String indirizzo, String citta, int numeroClassi, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, 0, numeroClassi, 0, numeroLaboratori);
    }

    @Override
    public double calcolaContributo() {
        return numeroClassi * CONTRIBUTO_CLASSE + numeroLaboratori * CONTRIBUTO_LABORATORIO;
    }
}