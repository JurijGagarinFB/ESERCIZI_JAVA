package mensola;

public class Libro {
    public String autore;
    public String titolo;
    final double COSTOPAGINA = 0.05;
    public int pagine;
    public Genere tipo;

    public String formattaDati() {
        return String.format("Autore: %s, Titolo: %s, Tipologia: %s, Prezzo: %07.2f, Pagine: %d", titolo, autore, tipo, (COSTOPAGINA * pagine), pagine);
    }
}