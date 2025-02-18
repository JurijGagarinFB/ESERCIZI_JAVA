import java.util.Random;

public class Dado {
    private int nFacce;
    private Random random;

    public Dado(int numeroFacce) {
        random = new Random();
        this.nFacce = numeroFacce;
    }

    public int lancia() {
        return random.nextInt(nFacce) + 1;
    }

    public String stampaFacce(int faccia) {
        if (this.nFacce == 6){
            return switch (faccia) {
                case 1 -> "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ║    0   ║\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ╚════════╝";
                case 2 -> "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║0       ║\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ║       0║\n"
                        + "\t\t\t\t ╚════════╝";
                case 3 -> "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║0       ║\n"
                        + "\t\t\t\t ║    0   ║\n"
                        + "\t\t\t\t ║       0║\n"
                        + "\t\t\t\t ╚════════╝";
                case 4 -> "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ╚════════╝";
                case 5 -> "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ║    0   ║\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ╚════════╝";
                case 6 -> "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ║0      0║\n"
                        + "\t\t\t\t ╚════════╝";
                default -> "Valore non valido";
            };
        }else{
            if (faccia < 10){
                return    "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ║    "+faccia+"   ║\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ╚════════╝";
            }else{
                return    "\t\t\t\t ╔════════╗\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ║   "+faccia+"   ║\n"
                        + "\t\t\t\t ║        ║\n"
                        + "\t\t\t\t ╚════════╝";
            }
        }
    }
}