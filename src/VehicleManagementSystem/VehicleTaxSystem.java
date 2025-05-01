package VehicleManagementSystem;

import java.time.Year;
import java.util.*;

public class VehicleTaxSystem {

    private static final List<Vehicle> vehicles = new ArrayList<>();
    private static final HashSet<String> vehicleIds = new HashSet<>();
    private static final HashSet<String> regNum = new HashSet<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        while (true){
            System.out.println("Exercise 1: Advanced Vehicle Tax Management System");
            System.out.println("---------------------------------------------------");
            System.out.println("Choose the option you want to interact with below:");
            System.out.println("1. Register a new vehicle \n2. View registered vehicles \n2. View registered vehicles \n3. Calculate tax for all vehicles \n4. Generate tax reports \n5. Exit");
            System.out.println("Enter your option: ");

            String option = sc.nextLine();
            switch (option){
                case "1":
                    vehicleRegistration();
                    break;
                case "2":
                    allVehicles();
                    break;
                case "3":
                    calculateAllTax();
                    break;
                case "4":
                    AllTaxReports();
                    break;
                case "5":
                    System.out.println("Exited!");
                    return;
                default:
                    System.out.println("Your choice is invalid. Try again!");

            }
        }
    }
    public static void vehicleRegistration() {
        System.out.println("What is your name?");
        String name = sc.nextLine();

        System.out.println("What is your vehicle type? [Car, Truck, Motorcycle, Bus, or SUV]");
        String vehicleType = sc.nextLine();

        System.out.println("Enter the " + vehicleType + "'s registration number:");
        String regNumber = sc.nextLine().trim();
        if (regNum.contains(regNumber)) {
            System.out.println("This registration number is taken. Try again!");
        }

        System.out.println("Enter it's ID:");
        String vehicleId = sc.nextLine().trim();
        if (!vehicleIds.contains(vehicleId)) {
            vehicleIds.add(vehicleId);
        } else {
            System.out.println("This ID is taken. Try again!");
        }

        System.out.print("Enter year of fabrication: ");
        int year;
        try {
            year = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("The year is invalid.");
            return;
        }

        if (year > Year.now().getValue()) {
            System.out.println("The year of fabrication of the vehicle is in the future.");
            return;
        }

        System.out.print("Enter the base tax rate: ");
        double baseTax = 0;
        try {
            baseTax = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("The tax rate invalid!");
        }

        Vehicle vehicle = null;
        switch (vehicleType.toLowerCase()) {
            case "car":
                System.out.println("Is your car electric? answer with true/false:");
                boolean isElectric = false;
                try {
                    isElectric = Boolean.parseBoolean(sc.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("Invalid input can only be true/false or yes/no");
                }
                vehicle = new Car(vehicleId, year, name, regNumber, baseTax, isElectric);

            case "truck":
                System.out.print("Enter load capacity in tons: ");
                double load;
                try {
                    load = Double.parseDouble(sc.nextLine().trim());
                    if (load <= 0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid load capacity.");
                    return;
                }
                vehicle = new Truck(vehicleId, year, name, regNumber, baseTax, load);
                break;

            case "motorcycle":
                System.out.print("Enter engine capacity in cc: ");
                int engine;
                try {
                    engine = Integer.parseInt(sc.nextLine().trim());
                    if (engine <= 0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid engine capacity.");
                    return;
                }
                vehicle = new Motorcycle(vehicleId, year, name, regNumber, baseTax, engine);
                break;

            case "bus":
                System.out.print("Enter passenger capacity: ");
                int passengers;
                try {
                    passengers = Integer.parseInt(sc.nextLine().trim());
                    if (passengers <= 0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid passenger capacity.");
                    return;
                }
                vehicle = new Bus(vehicleId, year, name, regNumber, baseTax, passengers);
                break;

            case "suv":
                System.out.print("Is it four-wheel drive (true/false)? ");
                boolean is4WD;
                try {
                    is4WD = Boolean.parseBoolean(sc.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("Invalid input for 4WD.");
                    return;
                }
                vehicle = new SUV(vehicleId, year, name, regNumber, baseTax, is4WD);
                break;

            default:
                System.out.println("You entered a vehicle type that is not included.");
                return;
        }

        vehicles.add(vehicle);
        vehicleIds.add(vehicleId);
        regNum.add(regNumber);
        System.out.println("Your vehicle has been registered successfully! \n" + vehicle);
        System.out.println("\n \n");
    }

    public static void allVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("You haven't registered any vehicles yet!");
        } else {
            for(Vehicle vehicle:vehicles){
                System.out.println(vehicle);
            }
        }
    }

    public static void calculateAllTax(){
        if (vehicles.isEmpty()){
            System.out.println("No vehicles registered yet! Can't calculate the tax!");
        } else{
            for(Vehicle ve : vehicles){
                System.out.printf("%s - Tax: %.2f%n", ve.getRegistrationNumber(), ve.calculateTax());
            }
        }
    }

    public static void AllTaxReports(){
        if (vehicles.isEmpty()){
            System.out.println("No vehicles registered yet! Can't report tax!");
        } else{
            for(Vehicle ve : vehicles){
                ve.generateTaxReport();
            }
        }
    }

}