package jackson.model;

public class Car {
    private String brand = null;
    private int doors = 0;

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }


    public Car() {

    }

    public String getBrand() { return this.brand; }
//    public void   setBrand(String brand){ this.brand = brand;}

    public int  getDoors() { return this.doors; }
//    public void setDoors (int doors) { this.doors = doors; }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", doors=" + doors +
                '}';
    }
}
