
package work;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String registrationNumber, String brand,
               String model, double rentalPrice, int numberOfSeats) {
        super(registrationNumber, brand, model, rentalPrice);
        setNumberOfSeats(numberOfSeats);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException(
                    "Number of seats must be positive."
            );
        }
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car");
        System.out.println("Number of seats: " + numberOfSeats);
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be positive."
            );
        }

        double total = getRentalPrice() * days;

        if (days >= 7) {
            total *= 0.90; // 10% discount for 7 or more days
        }

        return total;
    }
}
