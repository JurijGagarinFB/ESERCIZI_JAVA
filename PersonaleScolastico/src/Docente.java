public class Docente extends Dipendente {
    private String ruolo;
    private String disciplina;

    public Docente(String nominativo, char genere, String indirizzo, String ruolo, String disciplina) {
        super(nominativo, genere, indirizzo);
        this.ruolo = ruolo;
        this.disciplina = disciplina;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public double getIncentivo() {
        return super.getIncentivo() * 2;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "ruolo='" + getRuolo() + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
