package GSON;

import com.google.gson.Gson;
import jackson.model.Car;

public class GsonImpl {
    public static void main(String[] args) {
        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";

        Gson gson = new Gson();

        Car car = gson.fromJson(json, Car.class);

        System.out.println(car.toString());

        Car car1 = new Car();
        /*car.brand = "Rover";
        car.doors = 5;*/

        Gson gson1 = new Gson();

        String json1 = gson.toJson(car);

    }
}
