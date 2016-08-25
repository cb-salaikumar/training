package me.salai.practice.beans;

/**
 * Bean : User
 * Models the user table present in the database.
 */
public class User implements java.io.Serializable{
    private String firstname;
    private String lastname;
    private String address;
    private boolean isActive;
    private String email;
    
    // No Getters and Setters
    private String password; 
    
    public User(){
        
    }
    public User(String firstname, String lastname, String address, boolean isActive, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.isActive = isActive;
        this.email = email;
    }

    public User(String firstname, String lastname, boolean isActive, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.isActive = isActive;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firtname) {
        this.firstname = firtname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
      return password;  
    }
}
