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

    public static String dado(int faccia){
        switch (faccia){
            case 1: return "\t\t\t\t ╔════════╗\n"
                    + "\t\t\t\t ║        ║\n"
                    + "\t\t\t\t ║    0   ║\n"
                    + "\t\t\t\t ║        ║\n"
                    + "\t\t\t\t ╚════════╝";
            case 2: return "\t\t\t\t ╔════════╗\n"
                    + "\t\t\t\t ║0       ║\n"
                    + "\t\t\t\t ║        ║\n"
                    + "\t\t\t\t ║       0║\n"
                    + "\t\t\t\t ╚════════╝";
            case 3: return "\t\t\t\t ╔════════╗\n"
                    + "\t\t\t\t ║0       ║\n"
                    + "\t\t\t\t ║    0   ║\n"
                    + "\t\t\t\t ║       0║\n"
                    + "\t\t\t\t ╚════════╝";
            case 4: return "\t\t\t\t ╔════════╗\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ║        ║\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ╚════════╝";
            case 5: return "\t\t\t\t ╔════════╗\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ║    0   ║\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ╚════════╝";
            case 6: return "\t\t\t\t ╔════════╗\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ║0      0║\n"
                    + "\t\t\t\t ╚════════╝";
            default: return "Valore non valido";
        }
    }
}