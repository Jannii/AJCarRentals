package Beans;
// Generated 2017-jan-18 18:27:56 by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer loginIdLogin;
     private Login login;
     private String name;
     private String adress;
     private String email;
     private String phone;

    public User() {
    }

    public User(Login login, String name, String adress, String email, String phone) {
       this.login = login;
       this.name = name;
       this.adress = adress;
       this.email = email;
       this.phone = phone;
    }
   
    public Integer getLoginIdLogin() {
        return this.loginIdLogin;
    }
    
    public void setLoginIdLogin(Integer loginIdLogin) {
        this.loginIdLogin = loginIdLogin;
    }
    public Login getLogin() {
        return this.login;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }




}


