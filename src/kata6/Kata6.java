package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Kata6 {

    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/apple");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonArray.class)
                .get(0).getAsJsonObject()
                .get("phonetics").getAsJsonArray()
                .get(1).getAsJsonObject();               
        Dictionary phonetic = gson.fromJson(jsonObject, Dictionary.class);
        JAXBContext context = JAXBContext.newInstance(Dictionary.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(phonetic, System.out);        
        
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
    
}
