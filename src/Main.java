import VehicleManagementSystem.VehicleTaxSystem;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the assignment");
        System.out.println("--------------------------");
        System.out.println("Choose the Question assignment of your choice below: ");
        System.out.println("1. Advanced Vehicle Tax Management System \n2. Advanced Tax Enforcement Management System (RRA Focus) \n3. Advanced Internship Management System");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                VehicleTaxSystem.run();
                break;
            case "2":
//                TaxManagementSystem.run();
                break;
            case "3":
//                InternshipManagementSystem.run();
                break;
            case "4":
                System.out.println("Exited.");
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}