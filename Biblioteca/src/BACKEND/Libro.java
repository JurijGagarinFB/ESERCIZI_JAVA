package BACKEND;

import java.util.Objects;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;
    private final double costoPagina = 0.05;
    private Genere tipo;

    public Libro(String autore, String titolo, int nPagine, Genere tipo) throws Exception {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
        try {
            this.tipo = tipo;
        } catch (Exception e) {
            throw new Exception("Errore tipo");
        }
    }

    public Libro(String autore, String titolo) {
        this.autore = autore;
        this.titolo = titolo;
    }

    public Libro(Libro l) {
        this.autore = l.autore;
        this.titolo = l.titolo;
        this.nPagine = l.nPagine;
        this.tipo = l.tipo;
    }

    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getnPagine() {
        return nPagine;
    }

    public double getCostoPagina() {
        return costoPagina;
    }

    @Override
    public String toString() {
        return "Libro: " +
                "autore='" + autore + '\'' +
                " - titolo='" + titolo + '\'' +
                " - nPagine=" + nPagine +
                " - tipo=" + tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;
        return getnPagine() == libro.getnPagine() && Double.compare(getCostoPagina(), libro.getCostoPagina()) == 0 && Objects.equals(getAutore(), libro.getAutore()) && Objects.equals(getTitolo(), libro.getTitolo()) && tipo == libro.tipo;
    }
}
