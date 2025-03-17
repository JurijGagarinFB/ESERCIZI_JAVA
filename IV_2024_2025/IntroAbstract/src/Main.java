import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sfera s1 = new Sfera(3, 15);
        Cubo c1 = new Cubo(4, 2);

        GalleriaDeiSolidi galleria = new GalleriaDeiSolidi();

        try{
            galleria.addSolido(s1);
            galleria.addSolido(c1);
            galleria.getGalleria().forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}