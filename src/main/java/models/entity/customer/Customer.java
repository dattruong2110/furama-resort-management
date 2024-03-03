package models.entity.customer;

import models.entity.Person;

public class Customer extends Person {
    private String customerCode;
    private String customerType;
    private String address;

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                this.getId(),
                this.getCustomerCode(),
                this.getFullName(),
                this.getDateOfBirth(),
                this.getGender(),
                this.getIdCardNumber(),
                this.getPhoneNumber(),
                this.getEmail(),
                this.getCustomerType(),
                this.getAddress());
    }

    public Customer(Long id, String customerCode, String fullName, String dateOfBirth, String gender, String idCardNumber, String phoneNumber, String email, String customerType, String address) {
        super(id, fullName, dateOfBirth, gender, idCardNumber, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String customerCode, String fullName, String dateOfBirth, String gender, String idCardNumber, String phoneNumber, String email, String customerType, String address) {
        super(fullName, dateOfBirth, gender, idCardNumber, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Contract createContract(String contractNumber, double depositAmount, double totalPayment) {
        Booking booking = new Booking();

        return new Contract(contractNumber, booking.getBookingCode(), depositAmount, totalPayment, this.customerCode);
    }
}
