public class Sfera implements CorpoSolido {
    private double raggio;
    private double pesoSpecifico;

    public Sfera(double pesoSpecifico, double raggio) {
        this.pesoSpecifico = pesoSpecifico;
        this.raggio = raggio;
    }

    public double peso() {
        return pesoSpecifico * volume();
    }

    public double volume() {
        return (double) 4 / 3 * Math.PI * Math.pow(raggio, 3);
    }

    public double superficie() {
        return (double) 4 * Math.PI * Math.pow(raggio, 2);
    }

    @Override
    public String toString() {
        return String.format("Sono una sfera, la mia superficie è: %.2f e il mio volume è: %.2f", superficie(), volume());
    }
}
