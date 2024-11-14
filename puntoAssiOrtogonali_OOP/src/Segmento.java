import java.lang.Math;

public class Segmento {
    private double lunghezza;
    public Segmento(Punto primo, Punto secondo){
        this.lunghezza=Math.sqrt(Math.pow(primo.getX()-secondo.getX(),2)+Math.pow(primo.getY()- secondo.getY(),2));
    }

    @Override
    public String toString() {
        return "lunghezza" +lunghezza;
    }
}
