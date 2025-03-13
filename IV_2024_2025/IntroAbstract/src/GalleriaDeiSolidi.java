import java.util.ArrayList;

public class GalleriaDeiSolidi {
    private ArrayList<Solido> galleria;

    public GalleriaDeiSolidi() {
        this.galleria = new ArrayList<Solido>();
    }

    public void addSolido(Solido s) throws Exception{
        galleria.add(s.clone());
    }


    public ArrayList<Solido> getGalleria() throws CloneNotSupportedException {
        ArrayList<Solido> lista = new ArrayList<>();
        for (Solido s : galleria) {
            lista.add(s.clone());
        }
        return lista;
    }
}
