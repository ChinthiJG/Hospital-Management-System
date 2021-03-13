
package connection;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HMS_DBConnManager {
    
   String sourceURL;
    public HMS_DBConnManager() {
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sourceURL = new String("jdbc:mysql://localhost:3306/new hospital?zeroDateTimeBehavior");
    
        } catch (ClassNotFoundException classNotFoundException) {
                System.out.println(classNotFoundException + "-----------Unable to load database driver classes");
                }
    }
  
    public Connection connect() {
    
        Connection dbConn = null;
    
        try {
            dbConn = (Connection) DriverManager.getConnection(sourceURL, "chinthaka", "");
        
        }catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------DB connection failure");
        }
            
    return dbConn;
    }

    public void connectionClose(Connection dbConn) {
 
        try {
            dbConn.close();
        
        }catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------DB connection closing failure");
            }
    }

   
    
}
