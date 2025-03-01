public class Cubo extends Solido {
    private double lato;

    protected Cubo(double pesoSpecifico, double lato) {
        super(pesoSpecifico);
        this.lato = lato;
    }

    @Override
    public double volume() {
        return Math.pow(lato, 3);
    }

    @Override
    public double superficie() {
        return Math.pow(lato, 2) * 6;
    }

    @Override
    public String toString() {
        return super.toString() + (" , sono un cubo, la mia superficie: " + superficie() + " , il mio volume: " + volume());
    }
}
