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

    public static int trovaVeicolo(Veicolo veicoloDaTrovare) throws Exception {
        if (officina.contains(veicoloDaTrovare)) {
            return officina.indexOf(veicoloDaTrovare);
        }else{
            throw new Exception("Veicolo non trovato");
        }
    }
}
