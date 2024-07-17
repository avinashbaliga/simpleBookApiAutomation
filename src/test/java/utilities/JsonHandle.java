package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonHandle {

    public static JsonElement getJsonPayload(String key) {
        try {
            FileReader reader = new FileReader("src/main/resources/requestPayload.json");
            return ((JsonObject) JsonParser.parseReader(reader)).get(key);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
