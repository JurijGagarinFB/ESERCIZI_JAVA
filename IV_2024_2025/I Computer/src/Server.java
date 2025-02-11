// Classe Server, sottoclasse di PCFisso
public class Server extends PCFisso {
    private int numeroProcessori;
    private boolean hasRAID;

    public Server(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, tipoContenitore grandezzaCase, int numeroProcessori, boolean hasRAID) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo, grandezzaCase);
        this.numeroProcessori = numeroProcessori;
        this.hasRAID = hasRAID;
    }

    public int getNumeroProcessori() {
        return numeroProcessori;
    }

    public void setNumeroProcessori(int numeroProcessori) {
        this.numeroProcessori = numeroProcessori;
    }

    public boolean getHasRAID() {
        return hasRAID;
    }

    public void setHasRAID(boolean hasRAID) {
        this.hasRAID = hasRAID;
    }

    @Override
    public String toString() {
        return super.toString() + "Server [numeroProcessori=" + numeroProcessori + ", hasRAID=" + hasRAID + "]\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || !(obj instanceof Server)) return false;
        Server other = (Server) obj;
        return this.numeroProcessori == other.numeroProcessori && this.hasRAID == other.hasRAID;
    }
}
