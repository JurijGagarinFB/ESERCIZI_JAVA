import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {
    private ArrayList<Veicolo> officina = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addVeicolo(Veicolo v) {
        officina.add(v);
    }

    public ArrayList<Veicolo> getOfficina() {
        return officina;
    }

    public int numeroVeicoli() {
        return officina.size();
    }

    public static Veicolo trovaVeicolo(Concessionaria c, Veicolo veicoloDaTrovare) throws Exception {
        for (Veicolo v : c.getOfficina()) {
            if (v.equals(veicoloDaTrovare)) {
                return v;
            }
        }
        throw new Exception("Veicolo non trovato");
    }
}
