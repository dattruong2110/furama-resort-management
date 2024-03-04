package models.service.impl;

import models.entity.customer.Customer;
import models.entity.customer.CustomerType;
import models.entity.employee.Employee;
import models.service.CustomerService;
import models.utils.MyReadFile;
import models.utils.MyWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final List<Customer> customers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final MyWriteFile MY_WRITE_FILE = new MyWriteFile();
    private static final MyReadFile MY_READ_FILE = new MyReadFile();
    private static final String DATA_PATH = "src/main/java/models/data/customer.csv";

    static {
        try {
            customers.addAll(MY_READ_FILE.readFileCustomer(DATA_PATH));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public CustomerServiceImpl() {
    }

    private String getCustomerType() {
        System.out.println("Please choose customer type \n" +
                "1.Diamond \n" +
                "2.Platinum\n" +
                "3.Gold\n" +
                "4.Silver\n" +
                "5.Member\n"
        );
        int choose = scanner.nextInt();
        String customerType;
        switch (choose) {
            case 1:
                customerType = String.valueOf(CustomerType.DIAMOND);
                break;
            case 2:
                customerType = String.valueOf(CustomerType.PLATINIUM);
                break;
            case 3:
                customerType = String.valueOf(CustomerType.GOLD);
                break;
            case 4:
                customerType = String.valueOf(CustomerType.SILVER);
                break;
            case 5:
                customerType = String.valueOf(CustomerType.MEMBER);
                break;
            default:
                customerType = "";
                break;
        }

        return customerType;
    }

    private Customer getInfo() {
        System.out.println("Please enter customer name: ");
        String fullName = scanner.nextLine();
        System.out.println("Please enter customer code: ");
        String customerCode = scanner.nextLine();
        System.out.println("Please enter date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Please enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Please enter identity card number: ");
        String idCardNumber = scanner.nextLine();
        System.out.println("Please enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter customerType: ");
        String customerType = getCustomerType();
        scanner.nextLine();
        System.out.println("Please enter address: ");
        String address = scanner.nextLine();

        return new Customer(customerCode, fullName, dateOfBirth, gender, idCardNumber, phoneNumber, email, customerType, address);
    }

    public void add() {
        long id;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            id = customers.stream().mapToLong(Customer::getId).max().orElse(0) + 1;
        }

        Customer customer = getInfo();
        customer.setId(id);
        customers.add(customer);
        MY_WRITE_FILE.writeCustomerFile(DATA_PATH, customers);
    }

    public void display() {
        System.out.println("----------- List customers -----------");
        for (Customer customer : customers) {
            System.out.println(customer.getInfo());
        }
    }

    private void displayUpdateMenu() {
        System.out.println("Select fields to update by number: ");
        System.out.println("0. Exit");
        System.out.println("1. Employee Code");
        System.out.println("2. Full Name");
        System.out.println("3. Date Of Birth");
        System.out.println("4. Gender");
        System.out.println("5. Id Card Number");
        System.out.println("6. Phone Number");
        System.out.println("7. Email");
        System.out.println("8. Customer Type");
        System.out.println("9. Address");
    }

    private void updateCustomerCode(Customer customer) {
        System.out.println("Enter new employee code: ");
        customer.setCustomerCode(scanner.nextLine());
    }

    private void updateFullName(Customer customer) {
        System.out.println("Enter new employee name: ");
        customer.setFullName(scanner.nextLine());
    }

    private void updateDateOfBirth(Customer customer) {
        System.out.println("Enter new date of birth: ");
        customer.setDateOfBirth(scanner.nextLine());
    }

    private void updateGender(Customer customer) {
        System.out.println("Enter new gender: ");
        customer.setGender(scanner.nextLine());
    }

    private void updateIdCardNumber(Customer customer) {
        System.out.println("Enter new id card number: ");
        customer.setIdCardNumber(scanner.nextLine());
    }

    private void updatePhoneNumber(Customer customer) {
        System.out.println("Enter new phone number: ");
        customer.setPhoneNumber(scanner.nextLine());
    }

    private void updateEmail(Customer customer) {
        System.out.println("Enter new email: ");
        customer.setEmail(scanner.nextLine());
    }

    private void updateCustomerType(Customer customer) {
        String newLiteracy = getCustomerType();
        customer.setCustomerType(newLiteracy);
    }

    private void updateAddress(Customer customer) {
        System.out.println("Enter new address: ");
        customer.setAddress(scanner.nextLine());
    }

    public void update() {
        System.out.println("Enter the ID of the customer you want to edit: ");
        long targetId = scanner.nextLong();
        scanner.nextLine();

        Customer targetCustomer = null;

        for (Customer customer : customers) {
            if (customer.getId() == targetId) {
                targetCustomer = customer;
                break;
            }
        }

        if (targetCustomer != null) {
            System.out.println("Current details of the customer: ");
            System.out.println(targetCustomer.getInfo());

            int choice;
            do {
                displayUpdateMenu();

                System.out.println("Select a field to update (or enter 0 to exit): ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("Exiting update menu.");
                        break;
                    case 1:
                        updateCustomerCode(targetCustomer);
                        break;
                    case 2:
                        updateFullName(targetCustomer);
                        break;
                    case 3:
                        updateDateOfBirth(targetCustomer);
                        break;
                    case 4:
                        updateGender(targetCustomer);
                        break;
                    case 5:
                        updateIdCardNumber(targetCustomer);
                        break;
                    case 6:
                        updatePhoneNumber(targetCustomer);
                        break;
                    case 7:
                        updateEmail(targetCustomer);
                        break;
                    case 8:
                        updateCustomerType(targetCustomer);
                        break;
                    case 9:
                        updateAddress(targetCustomer);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

            } while (choice != 0);

            MY_WRITE_FILE.writeCustomerFile(DATA_PATH, customers);
            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer with ID " + targetId + " not found.");
        }
    }
}
