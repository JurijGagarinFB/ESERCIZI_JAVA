import java.util.ArrayList;

public class NegozioElettronica {
    private ArrayList<Prodotto> prodotti = new ArrayList<>();

    public void aggiungiProdotto(Prodotto prodotto) {
        for (Prodotto p : prodotti) {
            if (p.getCodice() == prodotto.getCodice()) {
                throw new ProdottoException("Prodotto con codice " + prodotto.getCodice() + " già esistente.");
            }
        }
        prodotti.add(prodotto);
    }

    public void rimuoviProdotto(int codice) {
        boolean trovato = false;
        for (Prodotto p : prodotti) {
            if (p.getCodice() == codice) {
                prodotti.remove(p);
                trovato = true;
                break;
            }
        }
        if (!trovato) {
            throw new ProdottoException("Prodotto con codice " + codice + " non trovato.");
        }
    }

    public Prodotto cercaProdotto(int codice) {
        for (Prodotto p : prodotti) {
            if (p.getCodice() == codice) {
                return p;
            }
        }
        throw new ProdottoException("Prodotto con codice " + codice + " non trovato.");
    }

    public int getIndexProdotto(int codice) {
        for (int i = 0; i < prodotti.size(); i++) {
            if (prodotti.get(i).getCodice() == codice) {
                return i;
            }
        }
        return -1;
    }

    public void modificaPrezzo(int codice, double nuovoPrezzo) {
        prodotti.get(getIndexProdotto(codice)).setPrezzo(nuovoPrezzo);
    }

    public void visualizzaProdotti() {
        for (Prodotto p : prodotti) {
            System.out.println(p);
        }
    }
}