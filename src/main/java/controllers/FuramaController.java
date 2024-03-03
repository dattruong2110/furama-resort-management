package controllers;

import models.service.impl.CustomerServiceImpl;
import models.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static final EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
    private static final CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    private final static Scanner scanner = new Scanner(System.in);

    private static int getChoice() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    public static void displayMainMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Exit");
        int choice = getChoice();

        switch (choice) {
            case 1:
                employeeManagement();
                break;
            case 2:
                customerManagement();
                break;
            case 3:
                System.out.println("Exiting program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void employeeManagement() {
        System.out.println("Employee Management Menu:");
        System.out.println("1. Display list of employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Return main menu");
        int choice = getChoice();

        switch (choice) {
            case 1:
                employeeServiceImpl.display();
                break;
            case 2:
                employeeServiceImpl.add();
                break;
            case 3:
                employeeServiceImpl.update();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void customerManagement() {
        System.out.println("Customer Management Menu:");
        System.out.println("1. Display list of customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu");
        int choice = getChoice();

        switch (choice) {
            case 1:
                customerServiceImpl.display();
                break;
            case 2:
                customerServiceImpl.add();
                break;
            case 3:
                customerServiceImpl.update();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}
