
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

// Shows the menu and handles keyboard input.
public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);
    private DealershipFileManager fileManager = new DealershipFileManager();

    // Load the dealership from the CSV file
    private void init() {
        dealership = fileManager.getDealership();
    }

    // Display the main menu
    public void display() {

        init();

        if (dealership == null) {
            System.out.println("Check that inventory.csv is in the project folder.");
            return;
        }

        int choice = 0;

        while (choice != 99) {

            System.out.println("\n=== " + dealership.getName() + " ===");
            System.out.println("1 - Find vehicles by price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");

            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1: processGetByPriceRequest(); break;
                case 2: processGetByMakeModelRequest(); break;
                case 3: processGetByYearRequest(); break;
                case 4: processGetByColorRequest(); break;
                case 5: processGetByMileageRequest(); break;
                case 6: processGetByVehicleTypeRequest(); break;
                case 7: processGetAllVehiclesRequest(); break;
                case 8: processAddVehicleRequest(); break;
                case 9: processRemoveVehicleRequest(); break;
                case 99: System.out.println("Goodbye!"); break;
                default: System.out.println("Please choose a menu option.");
            }
        }
    }

    // Read a whole number safely
    private int readInt(String question) {
        while (true) {
            System.out.print(question);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a whole number.");
            }
        }
    }

    // Read a decimal number safely
    private double readDouble(String question) {
        while (true) {
            System.out.print(question);

            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number.");
            }
        }
    }

    // Read a vehicle price
    private BigDecimal readPrice(String question) {
        while (true) {
            System.out.print(question);

            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid price.");
            }
        }
    }

    // Display vehicles returned by a search
    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Option 1 - Search by price
    private void processGetByPriceRequest() {

        double min = readDouble("Minimum price: ");
        double max = readDouble("Maximum price: ");

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    // Option 2 - Search by make and model
    private void processGetByMakeModelRequest() {

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    // Option 3 - Search by year
    private void processGetByYearRequest() {

        int min = readInt("Minimum year: ");
        int max = readInt("Maximum year: ");

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    // Option 4 - Search by color
    private void processGetByColorRequest() {

        System.out.print("Color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    // Option 5 - Search by mileage
    private void processGetByMileageRequest() {

        int min = readInt("Minimum mileage: ");
        int max = readInt("Maximum mileage: ");

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    // Option 6 - Search by vehicle type
    private void processGetByVehicleTypeRequest() {

        System.out.print("Type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    // Option 7 - Display all vehicles
    private void processGetAllVehiclesRequest() {

        displayVehicles(dealership.getAllVehicles());
    }

    // Option 8 - Add a vehicle
    private void processAddVehicleRequest() {

        int vin = readInt("VIN: ");

        // Check if VIN already exists
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                System.out.println("That VIN already exists.");
                return;
            }
        }

        int year = readInt("Year: ");

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        int mileage = readInt("Mileage: ");
        BigDecimal price = readPrice("Price: ");

        // Create a vehicle object
        Vehicle vehicle = new Vehicle(
                vin, year, make, model,
                type, color, mileage, price);

        // Add vehicle to inventory
        dealership.addVehicle(vehicle);

        // Save changes to inventory.csv
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added.");
    }

    // Option 9 - Remove a vehicle
    private void processRemoveVehicleRequest() {

        int vin = readInt("VIN to remove: ");

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {

                dealership.removeVehicle(vehicle);

                // Save changes to inventory.csv
                fileManager.saveDealership(dealership);

                System.out.println("Vehicle removed.");
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }
}

