public class Task13 {
    public static void main(String[] args) {
        Car myFirstCar = new Car("Tesla", "Y", 2025, 4);
        myFirstCar.displayDetails();
    }
}

class Vehicle {
    public String make;
    public String model;
    public int year;

}

class Car extends Vehicle {
    public int numberOfDoors;
    Car(String make, String model, int year, int numberOfDoors) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
    }

    public void displayDetails() {
        String output = "Car Details: \nMake: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year + "\nNumber of Doors: " + numberOfDoors;
        System.out.println(output);
    }
}
