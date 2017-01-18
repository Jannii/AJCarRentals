package Beans;
// Generated 2017-jan-18 18:27:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Booking generated by hbm2java
 */
public class Booking  implements java.io.Serializable {


     private Integer idBooking;
     private Car car;
     private String clientName;
     private String clientAdress;
     private String clientEmail;
     private String clientPhone;
     private String paymentStatus;
     private String price;
     private String bookingDate;
     private String startDate;
     private String returnDate;
     private String pickUpLocation;
     private String returnLocation;
     private Set offices = new HashSet(0);

    public Booking() {
    }

	
    public Booking(Car car, String clientName, String clientAdress, String clientEmail, String clientPhone, String paymentStatus, String price, String bookingDate, String startDate, String returnDate, String pickUpLocation, String returnLocation) {
        this.car = car;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.paymentStatus = paymentStatus;
        this.price = price;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
    }
    public Booking(Car car, String clientName, String clientAdress, String clientEmail, String clientPhone, String paymentStatus, String price, String bookingDate, String startDate, String returnDate, String pickUpLocation, String returnLocation, Set offices) {
       this.car = car;
       this.clientName = clientName;
       this.clientAdress = clientAdress;
       this.clientEmail = clientEmail;
       this.clientPhone = clientPhone;
       this.paymentStatus = paymentStatus;
       this.price = price;
       this.bookingDate = bookingDate;
       this.startDate = startDate;
       this.returnDate = returnDate;
       this.pickUpLocation = pickUpLocation;
       this.returnLocation = returnLocation;
       this.offices = offices;
    }
   
    public Integer getIdBooking() {
        return this.idBooking;
    }
    
    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }
    public Car getCar() {
        return this.car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }
    public String getClientName() {
        return this.clientName;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientAdress() {
        return this.clientAdress;
    }
    
    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }
    public String getClientEmail() {
        return this.clientEmail;
    }
    
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public String getClientPhone() {
        return this.clientPhone;
    }
    
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
    public String getPaymentStatus() {
        return this.paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    public String getBookingDate() {
        return this.bookingDate;
    }
    
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public String getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public String getPickUpLocation() {
        return this.pickUpLocation;
    }
    
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }
    public String getReturnLocation() {
        return this.returnLocation;
    }
    
    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }
    public Set getOffices() {
        return this.offices;
    }
    
    public void setOffices(Set offices) {
        this.offices = offices;
    }




}


