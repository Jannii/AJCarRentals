/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author bumblebee
 */
public class statefulBean {
    
    public static String pickUpDate;
    public static String dropOfDate;
    public static String name;
    public static String addres;
    public static String mail;
    public static String phone;
    public static String paymentStatus;
    public static String pickUpLocation;
    public static String dropOfLocation;
    public static String carHome;
    public static String CarName;
    public static String CarType;
    public static int carPrice;

    
    

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        statefulBean.pickUpDate = pickUpDate;
    }

    public String getDropOfDate() {
        return dropOfDate;
    }

    public void setDropOfDate(String dropOfDate) {
        statefulBean.dropOfDate = dropOfDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        statefulBean.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        statefulBean.addres = addres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        statefulBean.mail = mail;
    }

    public static String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        statefulBean.paymentStatus = paymentStatus;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        statefulBean.pickUpLocation = pickUpLocation;
    }

    public String getDropOfLocation() {
        return dropOfLocation;
    }

    public void setDropOfLocation(String dropOfLocation) {
        statefulBean.dropOfLocation = dropOfLocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        statefulBean.phone = phone;
    }
    
   public void setCarName(String carName) {
       statefulBean.CarName = carName;
   }
   public String getCarName() {
       return CarName;
   }
   public void setCarType(String carType) {
       statefulBean.CarType = carType;
   }
   public String getCarType() {
       return CarType;
   }
   
   public void setCarPrice(int carPrice) {
       statefulBean.carPrice = carPrice;
   }
   
   public int getCarPrice() {
       return carPrice;
   }
   public void setCarHome(String carHome) {
       statefulBean.carHome = carHome;
   }
}
