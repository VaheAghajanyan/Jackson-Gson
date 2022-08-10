package jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import jackson.model.Car;

import java.io.File;
import java.io.IOException;

public class JsonGenerator {
    public static void main(String[] args) throws IOException {
        JsonFactory factory = new JsonFactory();

        com.fasterxml.jackson.core.JsonGenerator generator = factory.createGenerator(
                new File("src/main/resources/output.json"), JsonEncoding.UTF8);

        Car car = new Car("Mercedes", 4);

        generator.writeStartObject();

        generator.writeStringField("brand", "Mercedes");
        generator.writeNumberField("doors", 5);

        generator.writeEndObject();
        generator.close();
    }
}