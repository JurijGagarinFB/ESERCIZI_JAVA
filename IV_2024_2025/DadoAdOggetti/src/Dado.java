import java.util.Random;

public class Dado {
    private int nFacce = 6;
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int lancia() {
        return random.nextInt(nFacce) + 1;
    }
}