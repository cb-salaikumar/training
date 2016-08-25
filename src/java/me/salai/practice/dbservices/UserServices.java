package me.salai.practice.dbservices;

/**
 * User Services
 * Helps to perform the DB CRUD operations for User table
 * Provides static query services for the model
 * TODO: Write SQL queries and complete the methods
 * @author salaikumar
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.salai.practice.beans.*;
import me.salai.practice.dbconnections.MySqlConnection;


// FixMe -> No DB connections opened are closed. Need torewrite the code for it
public class UserServices {
    
    private static Connection conn;
    private static Statement stmt;
    
    
    public static void connectToDB(){
        MySqlConnection mysql = MySqlConnection.getInstance();
        conn = mysql.getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static boolean isEmailPresent(String email){
        
        boolean presence = false;
        String query = "select * from users where email = "+"'" + email +"'";
        try {
            ResultSet rset = stmt.executeQuery(query);
            presence = rset.isBeforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return presence;
    }
    
    
    public static User getUserUsingEmail(String email){
        String query   = "select * from users where email = "+"'" + email +"'";
        ResultSet rset;
        User user      = new User();
        try {
            rset = stmt.executeQuery(query);
            while(rset.next()){
            // Prepare the user object and send it;
                while(rset.next()){
                    user.setFirstname(rset.getString("firstname"));
                    user.setLastname(rset.getString("lastname"));
                    user.setEmail(rset.getString("email"));
                    user.setAddress(rset.getString("address"));
                    user.setIsActive(rset.getBoolean("active"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return user;
    }
    
    
    public static void createUser(User user){
        String query = " insert into users (firstname, lastname, email, password, active)"
                    + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, user.getFirstname());
            preparedStmt.setString (2, user.getLastname());
            preparedStmt.setString (3, user.getEmail());
            preparedStmt.setString (4, user.getPassword());
            preparedStmt.setBoolean(5, true);
            
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static boolean updateUser(User user){
        return false;
    }
    
    
    public static boolean isUserValid(String email, String password){
        return false;
    }
}
