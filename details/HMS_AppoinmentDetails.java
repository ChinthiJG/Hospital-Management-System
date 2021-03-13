/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import GetSet.HMS_Appoinment;
import GetSet.HMS_Doctor_1;
import connection.HMS_DBConnManager;
import interfaces.HMS_AppoinmentGUI11_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class HMS_AppoinmentDetails {
    private HMS_DBConnManager dbConnManager = null;

    public HMS_AppoinmentDetails() {
        dbConnManager = new HMS_DBConnManager();
    }
    
     ResultSet rs;
     PreparedStatement pst;
   public boolean addAppoinment(HMS_Appoinment app){
        Connection dbConn = null;
        boolean result = false;
    
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "INSERT INTO appoinment VALUES('" + app.getAppoinmentno()+ "','" + app.getDoctorno() + "','"+app.getDoctorname()+"','"+ app.getDate() + "','" + app.getTime()
                    + "','" + app.getPatientname() + "','" +app.getAge()  + "','" + app.getPhone() + "','"+app.getDescription()+"')";
            
            int val = stmt.executeUpdate(query);
            if (val == 1) {
                result = true;
            } else {
                result = false;
            }
           
       } catch (SQLException sqlException) {
           JOptionPane.showMessageDialog(null,sqlException + "-----------Insert query failed");
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return result;
       }
   
   public void delete(String appno) {
        Connection dbConn = null;
        //HMS_Appoinment app = new HMS_Appoinment();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "DELETE FROM appoinment WHERE appoinmentno = '" + appno + "' " ;
            stmt.executeUpdate(query);
        } catch (SQLException e) {
        }
    }
   
   public void updateRecord(HMS_Appoinment app) {
        Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "UPDATE appoinment SET doctorId = '" + app.getDoctorno() + "' ,doctorfullname = '" + app.getDoctorname() + "' ,date = '" + app.getDate() + "',time = '" +app.getTime() +"', patientname = '"+app.getPatientname()+"', age = '"+app.getAge()+ "',phone = '"+app.getPhone()+"',description= '" +app.getDescription() + "' WHERE appoinmentno= '" + app.getAppoinmentno() + "'";
            stmt.executeUpdate(query);
        } catch (SQLException sQLException) {
             JOptionPane.showMessageDialog(null,sQLException + "----------Update Query Failed!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
    }
   
    public HMS_Appoinment find(String appno) {
        Connection dbConn = null;
        HMS_Appoinment app = new HMS_Appoinment();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "SELECT * FROM appoinment WHERE appoinmentno = '" + appno + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                app.setAppoinmentno(rs.getString(1));
                app.setDoctorno(rs.getString(2));
                app.setDoctorname(rs.getString(3));
                app.setDate(rs.getString(4));
                app.setTime(rs.getString(5));
                app.setPatientname(rs.getString(6));
                app.setAge(rs.getString(7));
                app.setPhone(rs.getString(8));
                app.setDescription(rs.getString(9));
            }
            else{
                JOptionPane.showMessageDialog( null, "The entered Appoinment ID cannot be found.");  
            }
        } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null,sQLException + "----------InValid Appoinment Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return app;
    }
   
    public Vector getAppoinmentDetails() {

        Vector<Vector<String>> appoinmentDetailsVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM appoinment";

            ResultSet rs = stmt.executeQuery(query);
            appoinmentDetailsVector = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> appoinment = new Vector<String>();
                appoinment.add(rs.getString(1));
                appoinment.add(rs.getString(2));
                appoinment.add(rs.getString(3));
                appoinment.add(rs.getString(4));
                appoinment.add(rs.getString(5));
                appoinment.add(rs.getString(6));
                appoinment.add(rs.getString(7));
                appoinment.add(rs.getString(8));
                appoinment.add(rs.getString(9));
                appoinmentDetailsVector.add(appoinment);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return appoinmentDetailsVector;
    }
     public void setDisable(HMS_AppoinmentGUI11_1 gui){
        
       
        gui.txtappno1.setEnabled(false);
        gui.cmb4.setEnabled(false);
        gui.txtID1.setEnabled(false);
        gui.datechooser1.setEnabled(false);
        gui.cmb3.setEnabled(false);
        gui.txtname1.setEnabled(false);
        gui.txtphone1.setEnabled(false);
        gui.txtage1.setEnabled(false);
        gui.txtdescription1.setEnabled(false);
        gui.txtappno1.requestFocus();
    }
     
     
 public void clear1(HMS_AppoinmentGUI11_1 gui) {
        
        gui.cmb1.setSelectedIndex(0);
        gui.comboSpeciality.setSelectedIndex(0);
        gui.cmb2.setSelectedIndex(0);
        
        gui.datechooser.setDate(null);
        gui.cmb2.setSelectedIndex(0);
        gui.txtname.setText("");
        gui.txtphone.setText("");
        gui.txtage.setText("");
        gui.txtdescription.setText("");

    }

    public void clear2(HMS_AppoinmentGUI11_1 gui) {
        gui.txtappno2.setText("");
        gui.cmb6.setSelectedIndex(0);
        gui.lblDocId2.setText("");
        gui.datechooser2.setDate(null);
        gui.cmb5.setSelectedIndex(0);
        gui.txtname2.setText("");
        gui.txtphone2.setText("");
        gui.txtage2.setText("");
        gui.txtdescription2.setText("");

    }

    public void clear3(HMS_AppoinmentGUI11_1 gui) {
        gui.txtappno1.setText("");
        gui.cmb4.setSelectedIndex(0);
        gui.txtID1.setText("");
        gui.datechooser1.setDate(null);
        gui.cmb3.setSelectedIndex(0);
        gui.txtname1.setText("");
        gui.txtphone1.setText("");
        gui.txtage1.setText("");
        gui.txtdescription1.setText("");

    }
     
     
      public HMS_Doctor_1 loadSpeciality() {
           HMS_Doctor_1 doctor = new HMS_Doctor_1();
           HMS_AppoinmentGUI11_1 gui = new HMS_AppoinmentGUI11_1();
        try {
            Connection dbConn = null;
           

            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select distinct speciality from doctor");
            rs = pst.executeQuery();
            
            
            while (rs.next()) {
                doctor.setSpeciality(rs.getString("speciality"));
                
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Specialist loading Error" + ex);
            //Logger.getLogger(HMS_AppoinmentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor;
    }
     
     
     
     
     
     
     
     
     
     
    
    }
   
   
