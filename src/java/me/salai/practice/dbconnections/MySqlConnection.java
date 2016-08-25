package me.salai.practice.dbconnections;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * MySQLConnection
 * connects to the my sql database and returns the connection object
 * @author salaikumar
 * 
 * TODO: Establish database connection by using JSON file.
 *       All parameters should be configured over there.
 */
public class MySqlConnection {

    // Fields are not made final considering future enhancements
    // FIXME -> Separate the host, db, url, driver and port 
    private  String connectionUrl = "jdbc:mysql://localhost:3306/";
    private  Connection connection;
    private  String username = "root";
    private  String password = "";
    private  String database = "portal";
    
    // Instance of this class
    private static MySqlConnection mySqlConn = new MySqlConnection();
    
    private MySqlConnection(){
    }
   
    public static MySqlConnection getInstance(){
        return mySqlConn;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getDatabase() {
        return database;
    }
    
    public String getConnectionUrl() {
        return connectionUrl;
    }

    public Connection getConnection() {
        if (connection == null) {
            // Frame the connection full string
            String connPath = connectionUrl + database + "?useSSL=false" ;
            try {
                connection = (Connection) DriverManager.getConnection(
                        connPath, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
}
