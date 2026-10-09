
package work;

public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String registrationNumber, String brand,
                      String model, double rentalPrice,
                      int engineCapacity) {
        super(registrationNumber, brand, model, rentalPrice);
        setEngineCapacity(engineCapacity);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException(
                    "Engine capacity must be positive."
            );
        }
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle");
        System.out.println("Engine capacity: " + engineCapacity + " cc");
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be positive."
            );
        }

        double dailyPrice = getRentalPrice();

        if (engineCapacity > 500) {
            dailyPrice *= 1.15; // 15% surcharge
        }

        return dailyPrice * days;
    }
}
