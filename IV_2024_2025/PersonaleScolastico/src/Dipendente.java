import java.util.Objects;

public class Dipendente {
    //nominativo,genere,indirizzo,incentivo
    private final String nominativo;
    private final char genere;
    // protected String indirizzo; VIOLA L'INCAPSULAMENTO
    private String indirizzo;
    private final double incentivo = 0.50;

    public Dipendente(String nominativo, char genere, String indirizzo) {
        this.nominativo = nominativo;
        this.genere = genere;
        this.indirizzo = indirizzo;
    }

    public String getNominativo() {
        return nominativo;
    }

    public char getGenere() {
        return genere;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

//    public final double getIncentivo() {
//        return incentivo;                   DOVESSIMO PORRE UN METODO RIDEFINITO IN UNA CLASSE FIGLIA COME FINAL, DAREBBE ERRORE, IN QUANTO I METODI FINAL NON POSSONO ESSERE RIDEFINITI CON OVERRIDE
//    }
    public double getIncentivo() {
        return incentivo;
    }

    @Override
    public String toString() {
        return String.format("%s - %c - %s - %.2f ", nominativo, genere, indirizzo, incentivo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dipendente d)) return false;
        return this.getNominativo().equals(d.nominativo);
    }
}
