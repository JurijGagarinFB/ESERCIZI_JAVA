public class Main {
    public static void main(String[] args) {

        Cubo cubo = new Cubo(7,2);
        System.out.println(cubo.peso());
        System.out.println(cubo);

        Sfera sfera = new Sfera(2,2);
        System.out.println(sfera.peso());
        System.out.println(sfera);

        Quadrato quadrato = new Quadrato(2,2);
        System.out.println(quadrato.peso());
        System.out.println(quadrato);


    }
}