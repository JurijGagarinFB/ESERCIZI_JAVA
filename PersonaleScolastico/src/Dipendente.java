import java.util.Objects;

public class Dipendente {
    //nominativo.genere,incentivo
    private final String nominativo;
    private final char genere;
    private final String indirizzo;
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

    public double getIncentivo() {
        return incentivo;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "nominativo='" + nominativo + '\'' +
                ", genere=" + genere +
                ", indirizzo='" + indirizzo + '\'' +
                ", incentivo=" + incentivo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dipendente that)) return false;
        return Objects.equals(getNominativo(), that.getNominativo());
    }
}