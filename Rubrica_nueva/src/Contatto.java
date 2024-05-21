public class Contatto {
    public String nome;
    public boolean nascosto=false;
    public String numTelefono;
    public int numChiamate;

    public String anagrafica() {
        return String.format("Nome: %s Telefono: %s Numero di chiamate: %s", nome, numTelefono, numChiamate);
    }
}