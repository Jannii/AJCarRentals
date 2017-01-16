package EntityBeans;
// Generated 2017-jan-16 15:21:22 by Hibernate Tools 4.3.1



/**
 * Login generated by hbm2java
 */
public class Login  implements java.io.Serializable {


     private Integer idLogin;
     private String username;
     private String userpass;
     private String status;

    
     private User user;

    public Login() {
    }

	
    public Login(String username, String userpass, String status) {
        this.username = username;
        this.userpass = userpass;
        this.status = status;
    }
    public Login(String username, String userpass, String status, User user) {
       this.username = username;
       this.userpass = userpass;
       this.status = status;
       this.user = user;
    }
   
    public Integer getIdLogin() {
        return this.idLogin;
    }
    
    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpass() {
        return this.userpass;
    }
    
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

     


}


