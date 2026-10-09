
package work;

public abstract class Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private double rentalPrice;

    public Vehicle(String registrationNumber, String brand,
                   String model, double rentalPrice) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        setRentalPrice(rentalPrice);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        if (rentalPrice < 0) {
            throw new IllegalArgumentException(
                    "Rental price cannot be negative."
            );
        }
        this.rentalPrice = rentalPrice;
    }

    public void displayInfo() {
        System.out.println("Registration: " + registrationNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.printf("Daily rental price: %,.2f RWF%n",
                rentalPrice);
    }

    public abstract double calculateRentalCost(int days);
}
