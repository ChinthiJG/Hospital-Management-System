/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import GetSet.HMS_Nurse;
import connection.HMS_DBConnManager;
import interfaces.HMS_NurseGUI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_NurseDetails {
    
    private HMS_DBConnManager dbConnManager = null;  
    
    
    public HMS_NurseDetails(){
        dbConnManager = new HMS_DBConnManager();
    } 
    
    
    public void addNurse(HMS_Nurse nurse){
        Connection dbConn = null;
       
        try{
            dbConn = dbConnManager.connect();
            String sql = "insert into nurse(nurseno,firstname,secondname,nic,age,gender,address,birthday,mstatus,phone,qualification,ward) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = dbConn.prepareStatement(sql);
            pst.setString(1, nurse.getId());
            pst.setString(2, nurse.getFirstname());
            pst.setString(3, nurse.getSecondname());
            pst.setString(4, nurse.getNic());
            pst.setString(5, nurse.getAge());
            pst.setString(6, nurse.getGender());
            pst.setString(7, nurse.getAddress());
            pst.setString(8, nurse.getBirthday());
            pst.setString(9, nurse.getMstatus());
            pst.setString(10, nurse.getPhone());
            pst.setString(11, nurse.getQualification());
            pst.setString(12, nurse.getAssignedward());

            pst.executeUpdate();
         
   }
       
        catch(SQLException sqlException){
            JOptionPane.showMessageDialog(null,sqlException + "-----------Insert query failed");  
          }
        
        finally {
            dbConnManager.connectionClose(dbConn);
           }
  
  } 
 
 
 
 public HMS_Nurse find(String id) {
        Connection dbConn = null;
        HMS_Nurse nurse = new HMS_Nurse();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "SELECT * FROM nurse WHERE nurseno = '" + id + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                nurse.setId(rs.getString(1));
                nurse.setFirstname(rs.getString(2));
                nurse.setSecondname(rs.getString(3));
                nurse.setNic(rs.getString(4));
                nurse.setAge(rs.getString(5));
                nurse.setGender(rs.getString(6));
                nurse.setAddress(rs.getString(7));
                nurse.setBirthday(rs.getString(8));
                nurse.setMstatus(rs.getString(9));
                nurse.setPhone(rs.getString(10));
                nurse.setQualification(rs.getString(11));
                nurse.setAssignedward(rs.getString(12));
                
            }
            else{
                JOptionPane.showMessageDialog( null, "The entered Nurse ID cannot be found."); 
            }
        } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null,sQLException+ "----------InValid Doctor Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return nurse;
    
    
    }
    
  public void updateRecord(HMS_Nurse pt) {
 Connection dbConn = null;
 try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "UPDATE nurse SET firstname = '" + pt.getFirstname()+ "' ,secondname = '"+ pt.getSecondname()+ "' ,nic = '" + pt.getNic()+ "',age = '" + pt.getAge()+ "',gender = '"+pt.getGender()+ "',address ='" + pt.getAddress()+   "',birthday = '" + pt.getBirthday()+ "',mstatus = '" + pt.getMstatus() + "' ,phone = '" +pt.getPhone()+ "',qualification='"+pt.getQualification()+"',ward='" +pt.getAssignedward()+ "' WHERE nurseno= '" + pt.getId() + "'";
            stmt.executeUpdate(query);
         
            } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null,sQLException + "----------InValid Patient Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
 } finally {
     
            dbConnManager.connectionClose(dbConn);
 }
 }
    
 public void deleteReceptionist(String nurseno){
  
     Connection dbConn = null;
     try{
            dbConn = dbConnManager.connect();
            String query = "delete from nurse where nurseno = ?";
            PreparedStatement pst = dbConn.prepareStatement(query);
            
            pst.setString(1,nurseno );
            pst.executeUpdate();
       
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex+ "Delete Query Fail", "Warning!", JOptionPane.ERROR_MESSAGE); 
        }
        
        finally {
            dbConnManager.connectionClose(dbConn);
           }
 }
 
 
 
 public void clear1(HMS_NurseGUI gui){
        
        gui.txtFirst1.setText(null);
        gui.txtSecond1.setText(null);
        gui.txtNic1.setText(null);
        gui.txtbirthdate1.setDate(null);
        gui.txtAge1.setText(null);
        gui.txtqualification1.setText(null);
        gui.txtward1.setText(null);
        gui.txtPhone1.setText(null);
        gui.comboGender1.setSelectedIndex(-1);
        gui.comboReleationship1.setSelectedIndex(-1);
        gui.txtAddress1.setText(null);
        gui.txtFirst1.requestFocus();
    }
    
    public void clear2(HMS_NurseGUI gui){
        
        gui.txtnurseno2.setText(null);
        gui.txtFirst2.setText(null);
        gui.txtSecond2.setText(null);
        gui.txtNic2.setText(null);
        gui.txtbirthdate2.setDate(null);
        gui.txtAge2.setText(null);
        gui.txtqualification2.setText(null);
        gui.txtward2.setText(null);
        gui.txtPhone2.setText(null);
        gui.comboGender2.setSelectedIndex(-1);
        gui.comboReleationship2.setSelectedIndex(-1);
        gui.txtAddress2.setText(null);
        gui.txtnurseno2.requestFocus();
    }
    
    public void clear3(HMS_NurseGUI gui){
   
        gui.txtnurseno3.setText(null);
        gui.txtFirst3.setText(null);
        gui.txtSecond3.setText(null);
        gui.txtNic3.setText(null);
        gui.txtbirthdate3.setText(null);
        gui.txtqualification3.setText(null);
        gui.txtAge3.setText(null);
        gui.txtward3.setText(null);
        gui.txtPhone3.setText(null);
        gui.txtGender3.setText(null);
        gui.txtMarried3.setText(null);
        gui.txtAddress3.setText(null);
        gui.txtnurseno3.requestFocus();
    }
    
    public void setDisable(HMS_NurseGUI gui){
   
        gui.txtFirst3.setEnabled(false);
        gui.txtSecond3.setEnabled(false);
        gui.txtNic3.setEnabled(false);
        gui.txtbirthdate3.setEnabled(false);
        gui.txtqualification3.setEnabled(false);
        gui.txtAge3.setEnabled(false);
        gui.txtward3.setEnabled(false);
        gui.txtPhone3.setEnabled(false);
        gui.txtGender3.setEnabled(false);
        gui.txtMarried3.setEnabled(false);
        gui.txtAddress3.setEnabled(false);
        gui.txtnurseno3.requestFocus();
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