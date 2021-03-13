
package Details;

import GetSet.HMS_Doctor_1;
import GetSet.WardDAO;
import connection.HMS_DBConnManager;
import interfaces.WardGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class WardDetails {
  
     private HMS_DBConnManager dbConnManager = null;  
   
    
    public WardDetails(){
    dbConnManager = new HMS_DBConnManager();
} 
    PreparedStatement pst;
     ResultSet rs;

     
     public HMS_Doctor_1 LoadDoctor(String wardno)
    {
        Connection dbConn = null;
       WardDAO ward = new WardDAO();
       HMS_Doctor_1 doc = new HMS_Doctor_1();
        WardGUI gui = new WardGUI();
        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select doctor.firstname from doctor,ward where doctor.ward=ward.wardId and ward.wardId='" + wardno + "'");
           
            rs = pst.executeQuery();
            
            
            if(rs.next())
            {
               doc.setFirstname(rs.getString(1));
            }
            else{
                gui.lblDoc.setText("");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex + "----------InValid Ward Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        }
        return doc;
    }
    
    
}
