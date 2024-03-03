package models.entity.customer;

import models.entity.Facility;

public class Booking {
    private String bookingCode;
    private String startDate;
    private String endDate;
    private String customerID;
    private Facility service;

    public Booking() {
    }

    public Booking(String bookingCode, String startDate, String endDate, String customerID, Facility facility) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.service = facility;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Facility getService() {
        return service;
    }

    public void setService(Facility facility) {
        this.service = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerID='" + customerID + '\'' +
                ", service=" + service +
                '}';
    }
}
