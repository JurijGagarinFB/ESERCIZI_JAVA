import java.util.ArrayList;
import java.util.Random;

public class Gara {
    private String nomeGara;
    private ArrayList<Auto> auto;
    private Pilota risultato;

    public Gara(String nomeGara, ArrayList<Auto> auto) {
        setNomeGara(nomeGara);
        setAuto(auto);
        setRisultato(corriGara());
    }

    public Pilota corriGara() {
        Random random = new Random();
        return risultato = auto.get(random.nextInt(0, auto.size())).getPilota();
    }

    public void setNomeGara(String nomeGara) {
        this.nomeGara = nomeGara;
    }

    public String getNomeGara() {
        return nomeGara;
    }

    public void setAuto(ArrayList<Auto> auto) {
        this.auto = auto;
    }

    public ArrayList<Auto> getAuto() {
        return auto;
    }

    public void setRisultato(Pilota risultato) {
        this.risultato = risultato;
    }

    public Pilota getRisultato() {
        return risultato;
    }

    /* test randomizzazione auto nell'arraylist di auto per fare una "classifica" da stampare attraverso il metodo di visualizzazione (randomizzo le posizioni delle auto nell'arraylist e stampo l'arraylist per ottenere la classifica)

    public ArrayList<Auto> randomizeAuto() {
        Random random = new Random();
        ArrayList<Auto> copiaAuto = auto;
        int indice = 0; // Indice per il nuovo array
        boolean presente;
        int finale = 0;
        do {
            int numeroPosizione = random.nextInt(0, auto.size()) + 1;
            presente = false;
            // Controlla se il nuovo numero è già presente nel nuovo array
            for (int j = 0; j < copiaAuto.size(); j++) {
                if (copiaAuto.get(j) == auto.get(numeroPosizione)) {
                    presente = true; // Se il numero è già presente, lo segnala
                }
            }
            finale = numeroPosizione;
            indice++;
        } while (presente); // Continua finché il numero è già presente
        copiaAuto.add(indice, auto.get(finale)); // Aggiunge il nuovo numero
        return copiaAuto;
    }
    */
}