public class Gara {
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Dado dado;
    private int roundTotali;
    private int roundCorrente;
    private boolean fineGara;

    public Gara(String nome1, String nome2, int roundTotali) {
        this.giocatore1 = new Giocatore(nome1);
        this.giocatore2 = new Giocatore(nome2);
        this.dado = new Dado();
        this.roundTotali = roundTotali;
        this.roundCorrente = 0;
        this.fineGara = false;
    }

    public boolean isFineGara() {
        return fineGara;
    }

    public String getWinner() {
        if (!fineGara) {
            return "Partita in corso";
        }
        if (giocatore1.getVittorie() > giocatore2.getVittorie()) {
            return "Vincitore: " + giocatore1.getNome();
        } else if (giocatore2.getVittorie() > giocatore1.getVittorie()) {
            return "Vincitore: " + giocatore2.getNome();
        } else {
            return "La partita è finita in parità";
        }
    }

    public void round() {
        if (fineGara) {
            return;
        }
        int lancio1 = dado.lancia();
        int lancio2 = dado.lancia();

        System.out.println("-------------------------------------------------");
        System.out.println(giocatore1.getNome() + " ha lanciato: " + lancio1);
        System.out.println(giocatore2.getNome() + " ha lanciato: " + lancio2);
        System.out.println("Round numero: " + (roundCorrente+1));

        if (lancio1 > lancio2) {
            giocatore1.incrementaVittorie();
            System.out.println("Round vinto da giocatore1");
        } else if (lancio2 > lancio1) {
            giocatore2.incrementaVittorie();
            System.out.println("Round vinto da giocatore2");
        } else {
            giocatore1.incrementaVittorie();
            giocatore2.incrementaVittorie();
            System.out.println("Pareggio");
        }

        roundCorrente++;
        if (roundCorrente >= roundTotali) {
            fineGara = true;
        }
    }

    public void resetGame() {
        giocatore1 = new Giocatore(giocatore1.getNome());
        giocatore2 = new Giocatore(giocatore2.getNome());
        roundCorrente = 0;
        fineGara = false;
    }
}