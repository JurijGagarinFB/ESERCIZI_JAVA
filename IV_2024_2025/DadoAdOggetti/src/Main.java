public class Main {
    public static void main(String[] args) {
        Gara gara = new Gara("Giocatore1", "Giocatore2", 5);
        while (!gara.isFineGara()) {
            gara.round();
        }
        System.out.println(gara.getWinner());
    }
}