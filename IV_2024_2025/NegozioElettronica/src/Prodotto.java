public interface Prodotto {
    String getNome();
    String getDescrizione();
    double getPrezzo();

    int getQuantita();
    int getCodice();
    void setPrezzo(double nuovoPrezzo);
}
