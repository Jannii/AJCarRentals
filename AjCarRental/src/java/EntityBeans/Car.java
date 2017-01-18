package EntityBeans;
// Generated 2017-jan-18 18:27:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Car generated by hbm2java
 */
public class Car  implements java.io.Serializable {


     private Integer idCar;
     private String carName;
     private String carType;
     private String carHome;
     private String carlocation;
     private int dailyPrice;
     private Set bookings = new HashSet(0);

    public Car() {
    }

	
    public Car(String carName, String carType, String carHome, String carlocation, int dailyPrice) {
        this.carName = carName;
        this.carType = carType;
        this.carHome = carHome;
        this.carlocation = carlocation;
        this.dailyPrice = dailyPrice;
    }
    public Car(String carName, String carType, String carHome, String carlocation, Set bookings) {
       this.carName = carName;
       this.carType = carType;
       this.carHome = carHome;
       this.carlocation = carlocation;
       this.bookings = bookings;
    }
   
    public Integer getIdCar() {
        return this.idCar;
    }
    
    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }
    public String getCarName() {
        return this.carName;
    }
    
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarType() {
        return this.carType;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarHome() {
        return this.carHome;
    }
    
    public void setCarHome(String carHome) {
        this.carHome = carHome;
    }
    public String getCarlocation() {
        return this.carlocation;
    }
    
    public void setCarlocation(String carlocation) {
        this.carlocation = carlocation;
    }
    public Set getBookings() {
        return this.bookings;
    }
    
    public void setBookings(Set bookings) {
        this.bookings = bookings;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }




}


