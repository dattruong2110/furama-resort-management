package models.entity.employee;

import models.entity.Person;

public class Employee extends Person {
    private String employeeCode;
    private String literacy;
    private String position;
    private double salary;

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                this.getId(),
                this.getEmployeeCode(),
                this.getFullName(),
                this.getDateOfBirth(),
                this.getGender(),
                this.getIdCardNumber(),
                this.getPhoneNumber(),
                this.getEmail(),
                this.getLiteracy(),
                this.getPosition(),
                this.getSalary());
    }

    public Employee(Long id, String employeeCode, String fullName, String dateOfBirth, String gender, String idCardNumber, String phoneNumber, String email, String literacy, String position, double salary) {
        super(id, fullName, dateOfBirth, gender, idCardNumber, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.literacy = literacy;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String employeeCode, String fullName, String dateOfBirth, String gender, String idCardNumber, String phoneNumber, String email, String literacy, String position, double salary) {
        super(fullName, dateOfBirth, gender, idCardNumber, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.literacy = literacy;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLiteracy() {
        return literacy;
    }

    public void setLiteracy(String literacy) {
        this.literacy = literacy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", educationLevel='" + literacy + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
