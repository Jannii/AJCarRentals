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
    public static String paymentStatus;
    public static String pickUpLocation;
    public static String dropOfLocation;

    
    

    public static String getPickUpDate() {
        return pickUpDate;
    }

    public static void setPickUpDate(String pickUpDate) {
        statefulBean.pickUpDate = pickUpDate;
    }

    public static String getDropOfDate() {
        return dropOfDate;
    }

    public static void setDropOfDate(String dropOfDate) {
        statefulBean.dropOfDate = dropOfDate;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        statefulBean.name = name;
    }

    public static String getAddres() {
        return addres;
    }

    public static void setAddres(String addres) {
        statefulBean.addres = addres;
    }

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        statefulBean.mail = mail;
    }

    public static String getPaymentStatus() {
        return paymentStatus;
    }

    public static void setPaymentStatus(String paymentStatus) {
        statefulBean.paymentStatus = paymentStatus;
    }

    public static String getPickUpLocation() {
        return pickUpLocation;
    }

    public static void setPickUpLocation(String pickUpLocation) {
        statefulBean.pickUpLocation = pickUpLocation;
    }

    public static String getDropOfLocation() {
        return dropOfLocation;
    }

    public static void setDropOfLocation(String dropOfLocation) {
        statefulBean.dropOfLocation = dropOfLocation;
    }
    
    
}
