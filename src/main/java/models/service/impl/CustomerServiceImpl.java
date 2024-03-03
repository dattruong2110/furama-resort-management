package models.service.impl;

import models.entity.customer.Customer;
import models.entity.customer.CustomerType;
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
        String address;
        System.out.println("Please enter address: ");
        address = scanner.nextLine();
        scanner.nextLine();

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

    public void update() {
        System.out.println("Enter the ID of the customer you want to edit:");
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
            System.out.println("Current details of the customer:");
            System.out.println(targetCustomer.getInfo());

            Customer updateCustomer = getInfo();

            targetCustomer.setCustomerCode(updateCustomer.getCustomerCode());
            targetCustomer.setFullName(updateCustomer.getFullName());
            targetCustomer.setDateOfBirth(updateCustomer.getDateOfBirth());
            targetCustomer.setGender(updateCustomer.getGender());
            targetCustomer.setIdCardNumber(updateCustomer.getIdCardNumber());
            targetCustomer.setPhoneNumber(updateCustomer.getPhoneNumber());
            targetCustomer.setEmail(updateCustomer.getEmail());
            targetCustomer.setCustomerType(updateCustomer.getCustomerType());
            targetCustomer.setAddress(updateCustomer.getAddress());

            MY_WRITE_FILE.writeCustomerFile(DATA_PATH, customers);
            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer with ID " + targetId + " not found.");
        }
    }
}
