// Istituti Professionali
public class Professionale extends Tecnico {
    private final double CONTRIBUTO_REGIONALE = 2400;
    private final double CONTRIBUTO_LABORATORIO_PROF = 3000;

    public Professionale(String codice, String denominazione, String indirizzo, String citta, int numeroClassi, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroClassi, numeroLaboratori);
    }

    @Override
    public double calcolaContributo() {
        return super.calcolaContributo() + numeroClassi * CONTRIBUTO_REGIONALE + numeroLaboratori * CONTRIBUTO_LABORATORIO_PROF;
    }
}