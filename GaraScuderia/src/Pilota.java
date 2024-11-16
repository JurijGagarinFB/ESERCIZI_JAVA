

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    public Pilota(String nome, String cognome, String nazionalita, int eta) throws Exception {
        setNome(nome);
        setCognome(cognome);
        setNazionalita(nazionalita);
        setEta(eta);
    }

    public void setNome(String nome) throws Exception {
        try {
            this.nome = nome;
        } catch (Exception e) {
            throw new Exception("Errore nome");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) throws Exception {
        try {
            this.cognome = cognome;
        } catch (Exception e) {
            throw new Exception("Errore cognome");
        }
    }

    public String getCognome() {
        return cognome;
    }

    public void setNazionalita(String nazionalita) throws Exception {
        try {
            this.nazionalita = nazionalita;
        } catch (Exception e) {
            throw new Exception("Errore nazionalità");
        }
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setEta(int eta) throws Exception {
        try {
            this.eta = eta;
        } catch (Exception e) {
            throw new Exception("Errore età");
        }
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " - Cognome: " + getCognome() + " - Nazionalità: " + getNazionalita() + " - Età: " + getEta();
    }
}

