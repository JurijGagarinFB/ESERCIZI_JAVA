import java.util.Objects;

public class Automobile implements Comparable<Automobile> {
    private String marca;
    private String modello;
    private Integer cilindrata;

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public Automobile(String marca, String modello, Integer cilindrata) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
    }

    public Automobile(Automobile automobile) {
        this.marca = automobile.getMarca();
        this.modello = automobile.getModello();
        this.cilindrata = automobile.getCilindrata();
    }

    @Override
    public String toString() {
        return "Automobile:" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cilindrata=" + cilindrata;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Automobile that)) return false;
        return getCilindrata() == that.getCilindrata() && Objects.equals(getMarca(), that.getMarca()) && Objects.equals(getModello(), that.getModello());
    }

    public int compareTo(Automobile that) {
        return this.cilindrata.compareTo(that.getCilindrata());
    }
}
