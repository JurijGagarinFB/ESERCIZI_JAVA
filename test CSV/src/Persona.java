public class Persona {
    private String nome;
    private String cognome;
    private int età;

    public Persona(String nome, String cognome, int età) {
        this.nome = nome;
        this.cognome = cognome;
        this.età = età;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", età=" + età +
                '}';
    }

    public String csv() {
        return String.format("%s,%s,%d", nome, cognome, età);
    }
}
