/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Johan Nilsson
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByIdBooking", query = "SELECT b FROM Booking b WHERE b.idBooking = :idBooking")
    , @NamedQuery(name = "Booking.findByClientName", query = "SELECT b FROM Booking b WHERE b.clientName = :clientName")
    , @NamedQuery(name = "Booking.findByClientAdress", query = "SELECT b FROM Booking b WHERE b.clientAdress = :clientAdress")
    , @NamedQuery(name = "Booking.findByClientEmail", query = "SELECT b FROM Booking b WHERE b.clientEmail = :clientEmail")
    , @NamedQuery(name = "Booking.findByClientPhone", query = "SELECT b FROM Booking b WHERE b.clientPhone = :clientPhone")
    , @NamedQuery(name = "Booking.findByPaymentStatus", query = "SELECT b FROM Booking b WHERE b.paymentStatus = :paymentStatus")
    , @NamedQuery(name = "Booking.findByPrice", query = "SELECT b FROM Booking b WHERE b.price = :price")
    , @NamedQuery(name = "Booking.findByBookingDate", query = "SELECT b FROM Booking b WHERE b.bookingDate = :bookingDate")
    , @NamedQuery(name = "Booking.findByStartDate", query = "SELECT b FROM Booking b WHERE b.startDate = :startDate")
    , @NamedQuery(name = "Booking.findByReturnDate", query = "SELECT b FROM Booking b WHERE b.returnDate = :returnDate")
    , @NamedQuery(name = "Booking.findByPickUpLocation", query = "SELECT b FROM Booking b WHERE b.pickUpLocation = :pickUpLocation")
    , @NamedQuery(name = "Booking.findByReturnLocation", query = "SELECT b FROM Booking b WHERE b.returnLocation = :returnLocation")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBooking")
    private Integer idBooking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ClientName")
    private String clientName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ClientAdress")
    private String clientAdress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ClientEmail")
    private String clientEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ClientPhone")
    private String clientPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PaymentStatus")
    private String paymentStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "BookingDate")
    private String bookingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "StartDate")
    private String startDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ReturnDate")
    private String returnDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PickUpLocation")
    private String pickUpLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ReturnLocation")
    private String returnLocation;
    @JoinTable(name = "office_has_booking", joinColumns = {
        @JoinColumn(name = "Booking_idBooking", referencedColumnName = "idBooking")}, inverseJoinColumns = {
        @JoinColumn(name = "Office_idOffice", referencedColumnName = "idOffice")})
    @ManyToMany
    private Collection<Office> officeCollection;
    @JoinColumn(name = "Car_idCar", referencedColumnName = "idCar")
    @ManyToOne(optional = false)
    private Car caridCar;

    public Booking() {
    }

    public Booking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Booking(Integer idBooking, String clientName, String clientAdress, String clientEmail, String clientPhone, String paymentStatus, String price, String bookingDate, String startDate, String returnDate, String pickUpLocation, String returnLocation) {
        this.idBooking = idBooking;
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

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    @XmlTransient
    public Collection<Office> getOfficeCollection() {
        return officeCollection;
    }

    public void setOfficeCollection(Collection<Office> officeCollection) {
        this.officeCollection = officeCollection;
    }

    public Car getCaridCar() {
        return caridCar;
    }

    public void setCaridCar(Car caridCar) {
        this.caridCar = caridCar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.Booking[ idBooking=" + idBooking + " ]";
    }
    
}
