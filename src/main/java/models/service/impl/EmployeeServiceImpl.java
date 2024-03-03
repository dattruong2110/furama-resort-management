package models.service.impl;

import models.entity.employee.Literacy;
import models.entity.employee.Employee;
import models.entity.employee.Position;
import models.service.EmployeeService;
import models.utils.MyReadFile;
import models.utils.MyWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final MyWriteFile MY_WRITE_FILE = new MyWriteFile();
    private static final MyReadFile MY_READ_FILE = new MyReadFile();
    private static final String DATA_PATH = "src/main/java/models/data/employee.csv";

    static {
        try {
            employees.addAll(MY_READ_FILE.readFileEmployee(DATA_PATH));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public EmployeeServiceImpl() {
    }

    private String getLiteracy() {
        System.out.println("Please choose literacy: \n" +
                "1. High School \n" +
                "2. College \n" +
                "3. University \n" +
                "4. Post Graduate \n"
        );
        int choose = scanner.nextInt();
        String literacy;
        switch (choose) {
            case 1:
                literacy = String.valueOf(Literacy.HIGH_SCHOOL);
                break;
            case 2:
                literacy = String.valueOf(Literacy.COLLEGE);
                break;
            case 3:
                literacy = String.valueOf(Literacy.UNIVERSITY);
                break;
            case 4:
                literacy = String.valueOf(Literacy.POSTGRADUATE);
                break;
            default:
                literacy = "";
                break;
        }

        return literacy;
    }

    public String getPosition() {
        System.out.println("Please choose position: \n" +
                "1. Receptionist \n" +
                "2. Server \n" +
                "3. Specialist \n" +
                "4. Supervisor \n" +
                "5. Manager \n" +
                "6. Director \n"
        );
        int choose = scanner.nextInt();
        String position;
        switch (choose) {
            case 1:
                position = String.valueOf(Position.RECEPTIONIST);
                break;
            case 2:
                position = String.valueOf(Position.SERVER);
                break;
            case 3:
                position = String.valueOf(Position.SPECIALIST);
                break;
            case 4:
                position = String.valueOf(Position.SUPERVISOR);
                break;
            case 5:
                position = String.valueOf(Position.MANAGER);
                break;
            case 6:
                position = String.valueOf(Position.DIRECTOR);
                break;
            default:
                position = "";
                break;
        }

        return position;
    }

    private Employee getInfo() {
        System.out.println("Please enter employee code: ");
        String employeeCode = scanner.nextLine();
        System.out.println("Please enter employee name: ");
        String fullName = scanner.nextLine();
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
        String literacy = getLiteracy();
        String position = getPosition();
        System.out.println("Please enter salary: ");
        double salary = scanner.nextDouble();

        return new Employee(employeeCode, fullName, dateOfBirth, gender, idCardNumber, phoneNumber, email, literacy, position, salary);
    }

    public void add() {
        long id;
        if (employees.isEmpty()) {
            id = 1;
        } else {
            id = employees.stream().mapToLong(Employee::getId).max().orElse(0) + 1;
        }

        Employee employee = getInfo();
        employee.setId(id);
        employees.add(employee);
        MY_WRITE_FILE.writeEmployeeFile(DATA_PATH, employees);
    }

    public void display() {
        System.out.println("----------- List employees -----------");
        for (Employee employee : employees) {
            System.out.println(employee.getInfo());
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
        System.out.println("8. Literacy");
        System.out.println("9. Position");
        System.out.println("10. Salary");
    }

    private void updateEmployeeCode(Employee employee) {
        System.out.println("Enter new employee code: ");
        employee.setEmployeeCode(scanner.nextLine());
    }

    private void updateFullName(Employee employee) {
        System.out.println("Enter new employee name: ");
        employee.setFullName(scanner.nextLine());
    }

    private void updateDateOfBirth(Employee employee) {
        System.out.println("Enter new date of birth: ");
        employee.setDateOfBirth(scanner.nextLine());
    }

    private void updateGender(Employee employee) {
        System.out.println("Enter new gender: ");
        employee.setGender(scanner.nextLine());
    }

    private void updateIdCardNumber(Employee employee) {
        System.out.println("Enter new id card number: ");
        employee.setIdCardNumber(scanner.nextLine());
    }

    private void updatePhoneNumber(Employee employee) {
        System.out.println("Enter new phone number: ");
        employee.setPhoneNumber(scanner.nextLine());
    }

    private void updateEmail(Employee employee) {
        System.out.println("Enter new email: ");
        employee.setEmail(scanner.nextLine());
    }

    private void updateLiteracy(Employee employee) {
        String newLiteracy = getLiteracy();
        employee.setLiteracy(newLiteracy);
    }

    private void updatePosition(Employee employee) {
        String newPosition = getPosition();
        employee.setPosition(newPosition);
    }

    private void updateSalary(Employee employee) {
        System.out.println("Enter new salary: ");
        employee.setSalary(scanner.nextDouble());
        scanner.nextLine();
    }


    public void update() {
        System.out.println("Enter the ID of the employee you want to edit: ");
        long targetId = scanner.nextLong();
        scanner.nextLine();

        Employee targetEmployee = null;

        for (Employee employee : employees) {
            if (employee.getId() == targetId) {
                targetEmployee = employee;
                break;
            }
        }

        if (targetEmployee != null) {
            System.out.println("Current details of the employee: ");
            System.out.println(targetEmployee.getInfo());

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
                        updateEmployeeCode(targetEmployee);
                        break;
                    case 2:
                        updateFullName(targetEmployee);
                        break;
                    case 3:
                        updateDateOfBirth(targetEmployee);
                        break;
                    case 4:
                        updateGender(targetEmployee);
                        break;
                    case 5:
                        updateIdCardNumber(targetEmployee);
                        break;
                    case 6:
                        updatePhoneNumber(targetEmployee);
                        break;
                    case 7:
                        updateEmail(targetEmployee);
                        break;
                    case 8:
                        updateLiteracy(targetEmployee);
                        break;
                    case 9:
                        updatePosition(targetEmployee);
                        break;
                    case 10:
                        updateSalary(targetEmployee);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

            } while (choice != 0);

            MY_WRITE_FILE.writeEmployeeFile(DATA_PATH, employees);
            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee with ID " + targetId + " not found.");
        }
    }

}
