import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Persona {
    public int nBiglietto;
    public LocalDateTime momentoEvento = LocalDateTime.now();
    public ListaGiostre giostreProvate;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Biglietto " + nBiglietto + ", Orario" + momentoEvento.format(formatter);
    }
}
