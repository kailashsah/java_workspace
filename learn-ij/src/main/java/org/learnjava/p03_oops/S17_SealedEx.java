package org.learnjava.p03_oops;

/*
 	1.

*/
public class S17_SealedEx {
    public void Run() {
        int seats = 0;
        Vehicle vehicle = new Car(2, "a");
        if (vehicle instanceof Car car) {

            seats = ((Car) vehicle).getNumberOfSeats();
            // 2.
            car.getNumberOfSeats();

        } else if (vehicle instanceof Truck) {
            seats = ((Truck) vehicle).getLoadCapacity();
        } else {
            throw new RuntimeException("Unknown instance of Vehicle" + seats);
        }
        System.out.println(seats);
    }

    public static void main(String[] args) {
        new S17_SealedEx().Run();
    }

}

sealed interface Service permits Car, Truck {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }

}

abstract sealed class Vehicle permits Car, Truck {

    protected final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}

final class Truck extends Vehicle implements Service {

    private final int loadCapacity;

    public Truck(int loadCapacity, String registrationNumber) {
        super(registrationNumber);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 18;
    }

}

non-sealed class Car extends Vehicle implements Service {

    private final int numberOfSeats;

    public Car(int numberOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 12;
    }

}