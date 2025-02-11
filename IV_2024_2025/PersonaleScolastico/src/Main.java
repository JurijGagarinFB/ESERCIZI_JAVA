public class Main {
    public static void main(String[] args) {
        Dipendente d1 = new Dipendente("Giuseppe",'M',"Via dei Pini 92");
        Docente d2 = new Docente("Enrico",'M',"Viale dei Mille","ITP","Informatica");
        Dipendente d3 = new Docente("Enricone",'M',"Viale dei Mille","ITP","Informatica");
        Impiegato d4 = new Impiegato("Rodolfo",'F',"Brontolo","trabajo");
        Dipendente d5 = new Impiegato("Henry",'F',"Brontolo","trabajo");
        Istituto s = new Istituto("IIS VIOLA MARCHESINI");
        try {
            s.addDipendente(d1);
            s.addDipendente(d2);
            s.addDipendente(d3);
            s.addDipendente(d4);
            s.addDipendente(d5);
            s.stampaIncentivi();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}