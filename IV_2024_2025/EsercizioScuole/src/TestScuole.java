// Classe di test
public class TestScuole {
    public static void main(String[] args) {
        Scuola[] scuole = {
                new ScuolaElementare("E001", "Scuola Primaria Roma", "Via Roma 10", "Roma", 200, 2),
                new ScuolaMedia("M001", "Scuola Media Milano", "Via Milano 5", "Milano", 300, 1, 10),
                new Liceo("L001", "Liceo Classico Torino", "Piazza Torino 3", "Torino", 300, 10),
                new Tecnico("T001", "Istituto Tecnico Napoli", "Corso Napoli 8", "Napoli", 20, 8),
                new Professionale("P001", "Istituto Professionale Firenze", "Via Firenze 7", "Firenze", 15, 6),
        };

        for (Scuola scuola : scuole) {
            System.out.println(scuola);
        }
    }
}