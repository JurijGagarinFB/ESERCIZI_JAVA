import java.util.ArrayList;
import java.util.Random;

public class Gara {
    private ArrayList<Auto> auto;

    public Gara(ArrayList<Auto> auto) {
        setAuto(auto);
    }

    public void setAuto(ArrayList<Auto> auto) {
        this.auto = auto;
    }

    public ArrayList<Auto> getAuto() {
        return auto;
    }

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
}