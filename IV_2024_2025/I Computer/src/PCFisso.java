// Classe PCFisso, sottoclasse di PC
public class PCFisso extends PC {
    private tipoContenitore grandezzaCase;

    public PCFisso(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, tipoContenitore grandezzaCase) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo);
        this.grandezzaCase = grandezzaCase;
    }

    public tipoContenitore getGrandezzaCase() {
        return grandezzaCase;
    }

    public void setGrandezzaCase(tipoContenitore grandezzaCase) {
        this.grandezzaCase = grandezzaCase;
    }

    @Override
    public String toString() {
        return super.toString() + "PCFisso [tipoContenitore=" + grandezzaCase + "]\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || !(obj instanceof PCFisso)) return false;
        PCFisso other = (PCFisso) obj;
        return this.grandezzaCase.equals(other.grandezzaCase);
    }
}
