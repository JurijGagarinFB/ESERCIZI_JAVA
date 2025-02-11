import java.util.ArrayList;

public class Istituto {
    //Aggiungi dipendente assicurandosi che il nome non corrisponda, Stampare gli incentivi dei dipendenti
    private ArrayList<Dipendente> scuola;
    private String nome;
    public Istituto(String nome) {
        this.nome = nome;
        scuola = new ArrayList<>();
    }

    public ArrayList<Dipendente> getScuola() {
        return scuola;
    }

    public void setScuola(ArrayList<Dipendente> scuola) {
        this.scuola = scuola;
    }

    public void addDipendente(Dipendente d) throws Exception {
        if (!scuola.contains(d)) {
            scuola.add(d);
        } else {
            throw new Exception("Questo dipendente è già presente nella scuola");
        }
    }
    public void stampaIncentivi(){
        for (Dipendente dipendente : scuola) {
            System.out.println(dipendente.getIncentivo());
        }
    }
}
