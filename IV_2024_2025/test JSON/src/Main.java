import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Gson tGson = new Gson();
        Persona persona = new Persona("Giovanni", "Sus", 30);
        String json = tGson.toJson(persona); //Serializzazione
        System.out.println(json);
        Persona PersonaFromJson = tGson.fromJson(json, Persona.class);
        System.out.println(PersonaFromJson.toString());
        ArrayList<Persona> persone = new ArrayList<>();
        persone.add(persona);
        persone.add(new Persona("Mohamed", "Guezam", 88));
        persone.add(new Persona("Nicolò", "Zanforlin", 99));

        //Serializzazione della collezzione persone su file in formato json
        Gson newGson = new GsonBuilder().setPrettyPrinting().create();
        String jsonContent = newGson.toJson(persone);
        // System.out.printf("Persona JSON: %s\n", jsonContent);


        try {
            Files.write(Paths.get("persone.json"), jsonContent.getBytes());
        } catch (Exception e) {
            e.getMessage();
        }

        //DESERIALIZZAZIONE DA FILE
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("persone.json"));
            Persona[] collezione = tGson.fromJson(new String(jsonData), Persona[].class);
            ArrayList<Persona> archivio = new ArrayList<>(Arrays.asList(collezione));
            System.out.printf("Archivo Deserializzato: %s%n", archivio);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}