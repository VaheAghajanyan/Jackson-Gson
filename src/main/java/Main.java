import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import jackson.model.Car;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        // Testing Jackson

        long start = System.nanoTime();
        String name = "";
        File file = new File("src/main/resources/test.json");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        name = jsonNode.get("stringTest").asText();

        long end = System.nanoTime();
        long elapsedTime = (end - start) / 1000;
        System.out.println("Time: " + elapsedTime + "\nResult: " + name);

        // Testing Gson
        long start1 = System.nanoTime();
        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/test.json")));
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(json);
        JsonObject jsonObject = jsonTree.getAsJsonObject();
        String ttt = jsonObject.getAsJsonPrimitive("stringTest").getAsString();
        long end1 = System.nanoTime();
        long elapsedTime1 = (end1 - start1) / 1000;
        System.out.println("Time: " + elapsedTime1 + "\nResult: " + ttt);
    }
}
