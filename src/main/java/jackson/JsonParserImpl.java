package jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import jackson.model.Car;

import java.io.IOException;

public class JsonParserImpl {
    public static void main(String[] args) throws IOException {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser parser  = factory.createParser(carJson);

        while(!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();

            System.out.println("jsonToken = " + jsonToken);
        }

        Car car = new Car("Lada", 5);

        while(!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();

            if(JsonToken.FIELD_NAME.equals(jsonToken)){
                String fieldName = parser.getCurrentName();
                System.out.println(fieldName);

                jsonToken = parser.nextToken();

                if("brand".equals(fieldName)){
                    //car.brand = parser.getValueAsString();
                } else if ("doors".equals(fieldName)){
                    //car.doors = parser.getValueAsInt();
                }
            }
        }

        /*System.out.println("car.brand = " + car.brand);
        System.out.println("car.doors = " + car.doors);*/
    }
}
