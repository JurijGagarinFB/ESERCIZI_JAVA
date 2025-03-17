public class Cubo implements CorpoSolido{
    private double lato;
    private double pesoSpecifico;

    public Cubo(double pesoSpecifico, double lato) {
        this.pesoSpecifico = pesoSpecifico;
        this.lato = lato;
    }

    public double peso(){
        return pesoSpecifico * volume();
    }

    public double volume() {
        return Math.pow(lato, 3);
    }

    public double superficie() {
        return 6 * Math.pow(lato, 2);
    }

    @Override
    public String toString() {
        return String.format("Sono un cubo, la mia superficie è: %.2f e il mio volume è: %.2f", superficie(), volume());
    }
}
