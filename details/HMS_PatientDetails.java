/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import GetSet.HMS_Patient;
import connection.HMS_DBConnManager;
import interfaces.HMS_PatientGUI_new;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chinthaka
 */
public class HMS_PatientDetails {
    
    private HMS_DBConnManager dbConnManager = null;  

    public HMS_PatientDetails(){
        dbConnManager = new HMS_DBConnManager();
    } 
    
    
    
    
 public void addPatient(HMS_Patient pt){
   Connection dbConn = null;
   
   try{
       dbConn = dbConnManager.connect();
       Statement stmt = dbConn.createStatement();
       String sql = "insert into patient(patientno,firstname,secondname,nic,gender,age,birthday,mstatus,phone,address,wardno,bedno,blood,description,date) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement pst = dbConn.prepareStatement(sql);
       pst.setString(1, pt.getId());
       pst.setString(2, pt.getFirstname());
       pst.setString(3, pt.getSecondname());
       pst.setString(4, pt.getNic());
       pst.setString(5, pt.getGender());
       pst.setString(6, pt.getAge());
       pst.setString(7, pt.getBirthday());
       pst.setString(8, pt.getMstatus());
       pst.setString(9, pt.getPhone());
       pst.setString(10, pt.getAddress());
       pst.setString(11, pt.getWardno());
       pst.setString(12, pt.getBedno());
       pst.setString(13, pt.getBloodgroup());
       pst.setString(14, pt.getDescription());
       pst.setString(15, pt.getDate());
       pst.executeUpdate();
            
           
   }
       
          catch(SQLException sqlException){
                 JOptionPane.showMessageDialog(null,sqlException + "----------Inset Query Failed!!!","Warning!", JOptionPane.ERROR_MESSAGE);
   }
        finally {
            dbConnManager.connectionClose(dbConn);
           }
  
  } 
 
 
 
 public HMS_Patient find(String id) {
        Connection dbConn = null;
        HMS_Patient pt = new HMS_Patient();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "SELECT * FROM patient WHERE patientno = '" + id + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                pt.setId(rs.getString(1));
                pt.setFirstname(rs.getString(2));
                pt.setSecondname(rs.getString(3));
                pt.setNic(rs.getString(4));
                pt.setGender(rs.getString(5));
                pt.setAge(rs.getString(6));
                pt.setBirthday(rs.getString(7));
                pt.setMstatus(rs.getString(8));
                pt.setPhone(rs.getString(9));
                pt.setAddress(rs.getString(10));
                pt.setWardno(rs.getString(11));
                pt.setBedno(rs.getString(12));
                pt.setBloodgroup(rs.getString(13));
                pt.setDescription(rs.getString(14));
                pt.setDate(rs.getString(15));
                
            }
            else{
                JOptionPane.showMessageDialog( null, "The entered student ID cannot be found.");  
            }
        } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null, sQLException+"This is InValid ID");
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return pt;
    }
 
  public void updateRecord(HMS_Patient pt) {
 Connection dbConn = null;
 try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "UPDATE patient SET firstname = '" + pt.getFirstname()+ "' ,secondname = '"+ pt.getSecondname()+ "' ,nic = '" + pt.getNic()+ "',gender = '"+pt.getGender()+ "',age = '" + pt.getAge()+ "',birthday = '" + pt.getBirthday()+ "',mstatus = '" + pt.getMstatus() + "' ,phone = '" +pt.getPhone()+ "',address ='" + pt.getAddress()+ "',wardno='" +pt.getWardno()+ "',bedno='" +pt.getBedno()+ "',blood='"  + pt.getBloodgroup()+ "',description='" +pt.getDescription()+ "',date='" +pt.getDate()+"' WHERE patientno= '" + pt.getId() + "'";
            stmt.executeUpdate(query);
         
            } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null,sQLException + "----------InValid Patient Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
 } finally {
     
            dbConnManager.connectionClose(dbConn);
 }
 }
  
   public void delete(String patientId) {
        Connection dbConn = null;
       
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "DELETE FROM patient WHERE patientno='" + patientId + "'";
            stmt.executeUpdate(query);
          
        } catch (SQLException e) {
        }
    }
 
 
    public void clear1(HMS_PatientGUI_new gui){
        
        gui.txtFirst1.setText("");
        gui.txtbirthdate1.setDate(null);
        gui.txtAge1.setText("");
        gui.txtBed1.setText("");
        gui.txtSecond1.setText("");
        gui.txtWard1.setText("");
        gui.txtBed1.setText("");
        gui.txtNic1.setText("");
        gui.txtPhone1.setText("");
        gui.comboGender1.setSelectedIndex(-1);
        gui.comboBlood1.setSelectedIndex(-1);
        gui.comboReleationship1.setSelectedIndex(-1);
        gui.txtAddress1.setText("");
        gui.txtDescription1.setText("");
        gui.txtFirst1.requestFocus();
        
        
    }
    
    public void clear2(HMS_PatientGUI_new gui){
        
        gui.txtpno2.setText("");
        gui.txtFname2.setText("");
        gui.txtbirthdate2.setDate(null);
        gui.txtage2.setText("");
        gui.txtbed2.setText("");
        gui.txtSecname2.setText("");
        gui.txtward2.setText("");
        gui.txtnic2.setText("");
        gui.txtPhone2.setText("");
        gui.comboGender2.setSelectedIndex(-1);
        gui.comboBlood2.setSelectedIndex(-1);
        gui.comboReleationship2.setSelectedIndex(-1);
        gui.txtAddress2.setText("");
        gui.txtDescription4.setText("");
        gui.txtpno2.requestFocus();
    }
    
    public void clear3(HMS_PatientGUI_new gui){
        
        gui.txtpno3.setText("");
        gui.txtFname3.setText("");
        gui.txtbirthdate3.setText("");
        gui.txtage3.setText("");
        gui.txtBed3.setText("");
        gui.txtSecname3.setText("");
        gui.txtWard3.setText("");
        gui.txtnic3.setText("");
        gui.txtPhone3.setText("");
        gui.txtgender3.setText("");
        gui.txtBlood3.setText("");
        gui.txtMarried3.setText("");
        gui.txtAddress3.setText("");
        gui.txtDescription3.setText("");
        gui.txtpno3.requestFocus();
    }
    
    public void clear4(HMS_PatientGUI_new gui){
        gui.txtpno4.setText("");
        gui.txtFname4.setText("");
        gui.txtbirthdate4.setText("");
        gui.txtage4.setText("");
        gui.txtBed4.setText("");
        gui.txtSecname4.setText("");
        gui.txtWard4.setText("");
        gui.txtnic4.setText("");
        gui.txtPhone4.setText("");
        gui.txtgender4.setText("");
        gui.txtBlood4.setText("");
        gui.txtMarried4.setText("");
        gui.txtAddress4.setText("");
        gui.txtDescription4.setText("");
        gui.txtpno4.requestFocus();
    }
    
 
    public void setDisable(HMS_PatientGUI_new gui){
        
        gui.txtFname3.setEnabled(false);
        gui.txtbirthdate3.setEnabled(false);
        gui.txtage3.setEnabled(false);
        gui.txtBed3.setEnabled(false);
        gui.txtSecname3.setEnabled(false);
        gui.txtWard3.setEnabled(false);
        gui.txtnic3.setEnabled(false);
        gui.txtPhone3.setEnabled(false);
        gui.txtgender3.setEnabled(false);
        gui.txtBlood3.setEnabled(false);
        gui.txtMarried3.setEnabled(false);
        gui.txtAddress3.setEnabled(false);
        gui.txtDescription3.setEnabled(false);
        gui.txtpno3.requestFocus();
    }

}
