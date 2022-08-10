package jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import jackson.model.Car;
import jackson.model.Transaction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ObjectMapper {
    public static void main(String[] args) throws IOException {

        // READING JSON

        // Read Json from String

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {
            Car car = objectMapper.readValue(carJson, Car.class);

            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read Json from Json Reader

        com.fasterxml.jackson.databind.ObjectMapper objectMapper1 = new com.fasterxml.jackson.databind.ObjectMapper();

        String carJson1 =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";

        Reader reader = new StringReader(carJson);

        Car car1 = objectMapper1.readValue(reader, Car.class);
        System.out.println(car1.toString());

        // Read from Json file

        File file = new File("src/main/resources/car.json");

        var objectMapper3 = new com.fasterxml.jackson.databind.ObjectMapper();
        Car car2 = objectMapper3.readValue(new File("src/main/resources/car.json"), Car.class);
        System.out.println(car2);

        // Read from InputStream

        com.fasterxml.jackson.databind.ObjectMapper objectMapper4 = new com.fasterxml.jackson.databind.ObjectMapper();

        InputStream input = new FileInputStream("src/main/resources/car.json");

        //Car car3 = objectMapper4.readValue(input, Car.class);

        //System.out.println(car3);

        // --- Read Object List from Json ---

        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

        List<Car> cars1 = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>(){});

        System.out.println(cars1);

        // --- Read Map from Json

        String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";

        Map<String, Object> jsonMap = objectMapper.readValue(jsonObject,
                new TypeReference<Map<String,Object>>(){});

        System.out.println(jsonMap);

        // WRITING JSON

        Car carWrite = new Car("Lada", 4);
        objectMapper.writeValue(new FileOutputStream("src/main/resources/carWrite.json"), carWrite);
        String test = objectMapper.writeValueAsString(carWrite);

        // Jackson DATE Formats

        Transaction transaction = new Transaction("transfer", new Date());
        String output = objectMapper.writeValueAsString(transaction);
        System.out.println(output);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        objectMapper.setDateFormat(dateFormat);

        String output2 = objectMapper.writeValueAsString(transaction);
        System.out.println(output2);

        // JACKSON TREE MODEL

        String carJsonTreeModel =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        ObjectMapper objectMapperTreeModel = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(carJson);
            JsonNode field1 = jsonNode.get("brand");
            String f2Str = jsonNode.get("f2").asText();
            double f2Dbl = jsonNode.get("f2").asDouble();
            int    f2Int = jsonNode.get("f2").asInt();
            long   f2Lng = jsonNode.get("f2").asLong();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert Object to JsonNode

        Car car = new Car();
      /*  car.brand = "Cadillac";
        car.doors = 4;*/

        JsonNode carJsonNode = objectMapper.valueToTree(car);

        // Convert JsonNode to Object

        JsonNode carJsonNode1 = objectMapper.readTree(carJsonTreeModel);

        Car car5 = objectMapper.treeToValue(carJsonNode1, Car.class);
    }
}
