// Classe base
public abstract class Scuola {
    protected String codice, denominazione, indirizzo, citta;
    protected int numeroStudenti, numeroClassi, numeroSediAggiuntive, numeroLaboratori;

    public Scuola(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiuntive, int numeroLaboratori) {
        this.codice = codice;
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.numeroStudenti = numeroStudenti;
        this.numeroClassi = numeroClassi;
        this.numeroSediAggiuntive = numeroSediAggiuntive;
        this.numeroLaboratori = numeroLaboratori;
    }

    abstract double calcolaContributo();

    @Override
    public String toString() {
        return denominazione + " - contributo: " + calcolaContributo() + "€";
    }
}