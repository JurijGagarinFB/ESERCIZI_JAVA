package backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mensola {
    private int numeroLibri = 0;
    private int maxLibri;
    private ArrayList<Libro> mensola = new ArrayList<>();

    public Mensola(int numeroLibri) {
        this.maxLibri = numeroLibri;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public ArrayList<Libro> getMensola() {
        return mensola;
    }

    public boolean checkSpace() throws Exception {
        boolean piena = true;
        if (numeroLibri == maxLibri)
            throw new Exception("La mensola è piena");
        else
            return false;
    }

    public void addLibro(Libro l) throws Exception {
        if (l != null && !mensola.contains(l)) {
            mensola.add(l);
            numeroLibri++;
        } else
            throw new Exception("Il libro è presente nella mensola");
    }

//    public void removeBook(Libro l) {
//        if (mensola.contains(l))
//            mensola.remove(l);
//    }

    public void setInto(Libro l, int posizione, Scanner tastiera) {
        System.out.println("In che posizione vuoi settare il libro: ");
        posizione = tastiera.nextInt();
        mensola.set(posizione, l);
    }

    public boolean containsBook(Libro l) {
        return mensola.contains(l);
    }

    public ArrayList<Libro> getVolumi() {
        ArrayList<Libro> nuovaMensola = new ArrayList<>();
        for (Libro libro : mensola) {
            nuovaMensola.add(new Libro(libro));
        }
        return nuovaMensola;
    }

    public boolean isEmpty() {
        return mensola.isEmpty();
    }

    public void salvaFile(String nomeFile) throws Exception {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        // Gson json = new Gson();
        String jsonContent = json.toJson(mensola);
        try{
            Files.write(Paths.get(nomeFile), jsonContent.getBytes());
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public void leggiFile(String nomeFile) throws Exception {
        try{
            byte[] jsonData = Files.readAllBytes(Path.of(nomeFile));
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            Libro[] collezione = json.fromJson(new String (jsonData), Libro[].class);
            mensola = new ArrayList<>(Arrays.asList(collezione));
        }catch(Exception e){
            throw new Exception(e);
        }
    }


}