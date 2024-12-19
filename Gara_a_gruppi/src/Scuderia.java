public class Scuderia implements Comparable{
    private String nomescuderia;
    private Pilota nomepilota;
    private Integer nauto;
    private int tempogiro;

    public Scuderia(String nomescuderia, Pilota nomepilota, int nauto) {
        this.nomescuderia = nomescuderia;
        this.nomepilota = nomepilota;
        this.nauto = nauto;
    }

    public String getNomescuderia() {
        return nomescuderia;
    }

    public Pilota getNomepilota() {
        return nomepilota;
    }

    public int getNauto() {
        return nauto;
    }

    public int getTempogiro() {
        return tempogiro;
    }

    @Override
    public String toString() {
        return "Scuderia{" +
                "nomescuderia='" + nomescuderia + '\'' +
                ", nomepilota=" + nomepilota +
                ", nauto=" + nauto +
                ", tempogiro=" + tempogiro +
                '}';
    }

    public boolean equals(Scuderia s){

    }
    @Override
   public int compareto(Scuderia s){
        this.nauto.compareTo(s.nauto);
   }
}