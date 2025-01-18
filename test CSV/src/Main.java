import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<>();
        Persona p1 = new Persona("Diego", "Renesto", 112);
        Persona p2 = new Persona("Il sus", "Amongus", 1488);
        Persona p3 = new Persona("Adolfo", "Suriname", 314);
        Persona p4 = new Persona("Carlo Alberto", "di Savoia", 54);
        Persona p5 = new Persona("Filippo", "Gasparini", 312);
        persone.add(p1);
        persone.add(p2);
        persone.add(p3);
        persone.add(p4);
        persone.add(p5);

        scriviPersona(persone, "Persone.csv");
        for (int i = 0; i < leggiPersona("Persone.csv").size(); i++) {
            System.out.println(leggiPersona("Persone.csv").get(i));
        }
    }

    public static void scriviPersona(ArrayList<Persona> persone, String fileName) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            for (Persona p : persone) {
                lista.add(p.csv());
            }
            Files.write(Paths.get(fileName), lista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Persona> leggiPersona(String fileName) {
        ArrayList<Persona> archivio = new ArrayList<>();
        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(fileName));
            String[] attributi;
            for (String s : lines) {
                attributi = s.split(",");
                archivio.add(new Persona(attributi[0], attributi[1], Integer.parseInt(attributi[2])));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return archivio;
    }
}