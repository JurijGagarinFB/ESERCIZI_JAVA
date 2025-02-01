// Classe base: PC
public class PC {
    private String processore;
    private int ram;            // in GB
    private int memoria;        // in GB
    private String marca;
    private String modello;
    private String sistemaOperativo;

    // Costruttore
    public PC(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo) {
        this.processore = processore;
        this.ram = ram;
        this.memoria = memoria;
        this.marca = marca;
        this.modello = modello;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Getters e Setters
    public String getProcessore() {
        return processore;
    }

    public void setProcessore(String processore) {
        this.processore = processore;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    // toString
    @Override
    public String toString() {
        return "PC [processore=" + processore + ", ram=" + ram + "GB, memoria=" + memoria + "GB, marca=" + marca + ", modello=" + modello + ", sistemaOperativo=" + sistemaOperativo + "]\n";
    }

    // equals: due PC sono considerati uguali se hanno marca, modello e sistema operativo uguali (esempio)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof PC)) return false;
        PC other = (PC) obj;
        return this.marca.equals(other.marca) && this.modello.equals(other.modello);
    }
}