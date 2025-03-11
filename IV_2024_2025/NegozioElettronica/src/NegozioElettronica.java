import java.util.ArrayList;

public class NegozioElettronica {
    private ArrayList<ProdottoElettronico> prodotti = new ArrayList<>();

    public void aggiungiProdotto(ProdottoElettronico prodotto) {
        for (ProdottoElettronico p : prodotti) {
            if (p.getCodice() == prodotto.getCodice()) {
                throw new ProdottoException("Prodotto con codice " + prodotto.getCodice() + " già esistente.");
            }
        }
        prodotti.add(prodotto);
    }

    public void rimuoviProdotto(int codice) {
        boolean trovato = false;
        for (ProdottoElettronico p : prodotti) {
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

    public ProdottoElettronico cercaProdotto(int codice) {
        for (ProdottoElettronico p : prodotti) {
            if (p.getCodice() == codice) {
                return p;
            }
        }
        throw new ProdottoException("Prodotto con codice " + codice + " non trovato.");
    }

    public void modificaPrezzo(int codice, double nuovoPrezzo) {
        cercaProdotto(codice).setPrezzo(nuovoPrezzo);
    }

    public void visualizzaProdotti() {
        for (ProdottoElettronico p : prodotti) {
            System.out.println(p);
        }
    }
}