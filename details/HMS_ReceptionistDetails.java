
package Details;

import GetSet.HMS_Receptionist;
import connection.HMS_DBConnManager;
import interfaces.HMS_ReceptionistGUI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_ReceptionistDetails {
    
    private HMS_DBConnManager dbConnManager = null;  
    
    public HMS_ReceptionistDetails(){
        dbConnManager = new HMS_DBConnManager();
    } 
    
    
    public void addReceptionist(HMS_Receptionist recp){
        Connection dbConn = null;
       
        try{
       dbConn = dbConnManager.connect();
       String sql = "insert into receptionist(receptionistno,firstname,secondname,nic,age,gender,address,birthday,mstatus,phone,experience,startdate) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement pst = dbConn.prepareStatement(sql);
       pst.setString(1, recp.getId());
       pst.setString(2, recp.getFirstname());
       pst.setString(3, recp.getSecondname());
       pst.setString(4, recp.getNic());
       pst.setString(5, recp.getAge());
       pst.setString(6, recp.getGender());
       pst.setString(7, recp.getAddress());
       pst.setString(8, recp.getBirthday());
       pst.setString(9, recp.getMstatus());
       pst.setString(10, recp.getPhone());
       pst.setString(11, recp.getExperience());
       pst.setString(12, recp.getStartDate());
       
       pst.executeUpdate();
            
           
   }
       
          catch(SQLException sqlException){
     JOptionPane.showMessageDialog(null,sqlException+ "----------Insert Query Failed!!!","Warning!", JOptionPane.ERROR_MESSAGE); 
   }
        finally {
            dbConnManager.connectionClose(dbConn);
           }
  
  } 
 
 
 
 public HMS_Receptionist find(String id) {
        Connection dbConn = null;
        HMS_Receptionist recp = new HMS_Receptionist();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "SELECT * FROM receptionist WHERE receptionistno = '" + id + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                recp.setId(rs.getString(1));
                recp.setFirstname(rs.getString(2));
                recp.setSecondname(rs.getString(3));
                recp.setNic(rs.getString(4));
                recp.setAge(rs.getString(5));
                recp.setGender(rs.getString(6));
                recp.setAddress(rs.getString(7));
                recp.setBirthday(rs.getString(8));
                recp.setMstatus(rs.getString(9));
                recp.setPhone(rs.getString(10));
                recp.setExperience(rs.getString(11));
                recp.setStartDate(rs.getString(12));
                
            }
            else{
                JOptionPane.showMessageDialog( null, "The entered Receptionist ID cannot be found.","Warning!", JOptionPane.ERROR_MESSAGE);  
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null,sQLException+ "----------InValid Receptionist Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return recp;
    
    
    }
    
    
 public void deleteReceptionist(String recpno){
  
     Connection dbConn = null;
     try{
            dbConn = dbConnManager.connect();
            String query = "delete from receptionist where receptionistno = ?";
            PreparedStatement pst = dbConn.prepareStatement(query);
            
            pst.setString(1,recpno );
            pst.executeUpdate();
       
            
        } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex+ "----------InValid Doctor Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
            dbConnManager.connectionClose(dbConn);
           }
 }
 
 public void updateRecord(HMS_Receptionist pt) {
 Connection dbConn = null;
 try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "UPDATE receptionist SET firstname = '" + pt.getFirstname()+ "' ,secondname = '"+ pt.getSecondname()+ "' ,nic = '" + pt.getNic()+ "',age = '" + pt.getAge()+ "',gender = '"+pt.getGender()+ "',address ='" + pt.getAddress()+   "',birthday = '" + pt.getBirthday()+ "',mstatus = '" + pt.getMstatus() + "' ,phone = '" +pt.getPhone()+ "',experience='"+pt.getExperience()+"',startdate='" +pt.getStartDate()+ "' WHERE receptionistno= '" + pt.getId() + "'";
            stmt.executeUpdate(query);
         
            } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null,sQLException + "----------InValid Receptionist Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
 } finally {
     
            dbConnManager.connectionClose(dbConn);
 }
 }
 
    public void clear1(HMS_ReceptionistGUI gui){
        
        gui.txtFirst1.setText("");
        gui.txtSecond1.setText("");
        gui.txtNic1.setText("");
        gui.txtbirthdate1.setDate(null);
        gui.txtAge1.setText("");
        gui.txtExperience1.setText("");
        gui.txtStartDate1.setDate(null);
        gui.txtPhone1.setText("");
        gui.comboGender1.setSelectedIndex(-1);
        gui.comboReleationship1.setSelectedIndex(-1);
        gui.txtAddress1.setText("");
        gui.txtFirst1.requestFocus();
    }
    
    public void clear2(HMS_ReceptionistGUI gui){
        
        gui.txtrecpno2.setText("");
        gui.txtFirst2.setText("");
        gui.txtSecond2.setText("");
        gui.txtNic2.setText("");
        gui.txtbirthdate2.setDate(null);
        gui.txtAge2.setText("");
        gui.txtExperience2.setText("");
        gui.txtStartDate2.setText("");
        gui.txtPhone2.setText("");
        gui.comboGender2.setSelectedIndex(-1);
        gui.comboReleationship2.setSelectedIndex(-1);
        gui.txtAddress2.setText("");
        gui.txtrecpno2.requestFocus();
    }
    
    public void clear3(HMS_ReceptionistGUI gui){
        
        
        gui.txtrecpno3.setText("");
        gui.txtFirst3.setText("");
        gui.txtSecond3.setText("");
        gui.txtNic3.setText("");
        gui.txtbirthdate3.setText("");
        gui.txtExperience3.setText("");
        gui.txtAge3.setText("");
        gui.txtStartDate3.setText("");
        gui.txtPhone3.setText("");
        gui.txtGender3.setText("");
        gui.txtMarried3.setText("");
        gui.txtAddress3.setText("");
        gui.txtrecpno3.requestFocus();
    }
    
    
    public void setDisable(HMS_ReceptionistGUI gui){
        
        gui.txtFirst3.setEnabled(false);
        gui.txtSecond3.setEnabled(false);
        gui.txtNic3.setEnabled(false);
        gui.txtbirthdate3.setEnabled(false);
        gui.txtExperience3.setEnabled(false);
        gui.txtAge3.setEnabled(false);
        gui.txtStartDate3.setEnabled(false);
        gui.txtPhone3.setEnabled(false);
        gui.txtGender3.setEnabled(false);
        gui.txtMarried3.setEnabled(false);
        gui.txtAddress3.setEnabled(false);
        gui.txtrecpno3.requestFocus();
    }
    
  public static boolean validNic(String nic)
 { 
    boolean result = false;
     boolean hasNum = false;
    boolean hasV = false;
    char c;
    int nlength = nic.length();
    if(nlength == 10)
    {
        for(int i = 0 ; i<nlength -1 ;i++)
        {
            c = nic.charAt(i);
            if(Character.isDigit(c))
                hasNum = true;
            if(i==9)
            {
              if(nic.charAt(i) == 'V')
                  hasV=true;      
            }
            if(hasNum && hasV)
            {
                result = true;
            }
            
        }
        
    }
    else
    {
        //JOptionPane.showMessageDialog(null, "Invalid NIC");
    }
    return result;
    
 }
}
