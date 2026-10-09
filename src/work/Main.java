
package work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car(
                "RAC 123 A", "Toyota", "Corolla", 30000, 5
        ));

        vehicles.add(new Car(
                "RAC 456 B", "Hyundai", "Tucson", 50000, 5
        ));

        vehicles.add(new Motorcycle(
                "RMC 111 C", "Honda", "CBR 600", 15000, 600
        ));

        vehicles.add(new Motorcycle(
                "RMC 222 D", "TVS", "Apache 160", 8000, 160
        ));

        vehicles.add(new Truck(
                "RTC 333 E", "Isuzu", "NPR", 80000, 4.5
        ));

        vehicles.add(new Truck(
                "RTC 444 F", "Mercedes-Benz", "Actros", 150000, 12
        ));

        System.out.println("======================================");
        System.out.println("     VEHICLE RENTAL MANAGEMENT");
        System.out.println("======================================");

        System.out.println("\nAVAILABLE VEHICLES");

        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("\nVehicle " + (i + 1));
            System.out.println("--------------------------------------");
            vehicles.get(i).displayInfo();
        }

        int choice = readPositiveInt(
                scanner,
                "\nEnter the vehicle number you want to rent: ",
                vehicles.size()
        );

        Vehicle selectedVehicle = vehicles.get(choice - 1);

        int days = readPositiveInt(
                scanner,
                "Enter the number of rental days: ",
                Integer.MAX_VALUE
        );

        double totalCost = selectedVehicle.calculateRentalCost(days);

        System.out.println("\n========== RENTAL SUMMARY ==========");
        System.out.println("Vehicle: " + selectedVehicle.getBrand()
                + " " + selectedVehicle.getModel());
        System.out.println("Registration: "
                + selectedVehicle.getRegistrationNumber());
        System.out.println("Rental days: " + days);
        System.out.printf("Base daily price: %,.2f RWF%n",
                selectedVehicle.getRentalPrice());
        System.out.printf("Total rental cost: %,.2f RWF%n",
                totalCost);
        System.out.println("====================================");
        System.out.println("Thank you for choosing our company!");

        scanner.close();
    }

    private static int readPositiveInt(
            Scanner scanner, String message, int maximum) {

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value > 0 && value <= maximum) {
                    return value;
                }

                System.out.println(
                        "Please enter a number between 1 and "
                                + maximum + "."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
            }
        }
    }
}
