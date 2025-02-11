import java.util.Scanner;
public class Utilità {
    public static void main(String[] args) {
        String[] opzioni = {"titolo", "[1] opzione 1", "[2] opzione 2", "[3] opzione 3", "[4] exit"};
        Scanner tastiera = new Scanner(System.in);
        boolean fine = true;
        do{
            switch (menu(opzioni, tastiera)) {
                case 1: System.out.println("esecuzione opzione 1");
                    break;
                case 2: System.out.println("esecuzione opzione 2");
                    break;
                case 3: System.out.println("esecuzione opzione 3");
                    break;
                case 4: System.out.println("exit");
                    fine=false;
                    break;
            }Wait(2000);
        }while(fine);
    }
    private static int menu(String[] opzioni, Scanner tastiera) {
        int scelta;
        do {
            ClrScr();
            System.out.println("----" + opzioni[0] + "----");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            System.out.println("------------");
            scelta = tastiera.nextInt();
            if (!(scelta >= 1 && scelta <= opzioni.length)) {
                System.out.println("Scelta errata");
                Wait(2000);
            } Wait(2000);
        } while (!(scelta >= 1 && scelta <= opzioni.length));
        return scelta;
    }
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}