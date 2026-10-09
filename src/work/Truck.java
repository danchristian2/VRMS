
package work;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String registrationNumber, String brand,
                 String model, double rentalPrice,
                 double loadCapacity) {
        super(registrationNumber, brand, model, rentalPrice);
        setLoadCapacity(loadCapacity);
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException(
                    "Load capacity must be positive."
            );
        }
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck");
        System.out.println("Load capacity: " + loadCapacity + " tonnes");
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be positive."
            );
        }

        double total = getRentalPrice() * days;

        if (loadCapacity > 5) {
            total *= 1.20; // 20% surcharge
        }

        return total;
    }
}
