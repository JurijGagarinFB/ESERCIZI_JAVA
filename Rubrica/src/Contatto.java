/**
 * La classe Contatto rappresenta un contatto telefonico.
 */
public class Contatto {
    /** Il nome del contatto. */
    public String nome;

    /** Indica se il contatto è nascosto o meno. */
    public boolean nascosto = false;

    /** Il numero telefonico del contatto. */
    public String numTelefono;

    /** Il numero di chiamate effettuate al contatto. */
    public int numChiamate;

    /**
     * Restituisce una stringa che rappresenta l'anagrafica del contatto.
     *
     * @return Una stringa con il nome, il numero di telefono e il numero di chiamate del contatto.
     */
    public String anagrafica() {
        return String.format("Nome: %s Telefono: %s Numero di chiamate: %s", nome, numTelefono, numChiamate);
    }

    /**
     * Restituisce una stringa che rappresenta il contatto nel formato "nome, numero di telefono, numero di chiamate, nascosto".
     *
     * @return Una stringa nel formato specificato.
     */
    @Override
    public String toString() {
        return nome + "," + numTelefono + "," + numChiamate + "," + nascosto;
    }
}
