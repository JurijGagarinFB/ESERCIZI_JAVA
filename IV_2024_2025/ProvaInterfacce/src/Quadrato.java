public class Quadrato implements CorpoSolido{
    private double lato;
    private double pesoSpecifico;

    public Quadrato(double pesoSpecifico, double lato) {
        this.pesoSpecifico = pesoSpecifico;
        this.lato = lato;
    }

    public double peso(){
        return pesoSpecifico * volume();
    }

    public double volume() {
        return lato*lato;
    }

    public double superficie() {
        return lato*4;
    }

    @Override
    public String toString() {
        return String.format("Sono un quadrato, il mio perimetro è: %.2f e la mia area è: %.2f", superficie(), volume());
    }
}
