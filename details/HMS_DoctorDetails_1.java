
package Details;

import GetSet.HMS_Doctor_1;
import GetSet.WardDAO;
import com.sun.glass.events.KeyEvent;
import GetSet.User;

import connection.HMS_DBConnManager;
import interfaces.HMS_DoctorGUI_1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_DoctorDetails_1 {
 
    private HMS_DBConnManager dbConnManager = null;  
   
    
    public HMS_DoctorDetails_1(){
    dbConnManager = new HMS_DBConnManager();
} 
    
    
    public void addDoctor(HMS_Doctor_1 doc,WardDAO ward){
        Connection dbConn = null;
       
        try{
       dbConn = dbConnManager.connect();
       Statement stmt = dbConn.createStatement();
       String sql1 = "insert into doctor(doctorId,firstname,secondname,speciality,nic,age,gender,address,birthday,mstatus,phone,ward,room) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
       String sql2 = "insert into ward (wardId,wardtype) Values(?,?)";
       
       PreparedStatement pst1 = dbConn.prepareStatement(sql1);
        PreparedStatement pst2 = dbConn.prepareStatement(sql2);
       pst1.setString(1, doc.getId());
       
       pst1.setString(2, doc.getFirstname());
       pst1.setString(3, doc.getSecondname());
       pst1.setString(4, doc.getSpeciality());
       pst1.setString(5, doc.getNic());
       pst1.setString(6, doc.getAge());
       pst1.setString(7, doc.getGender());
       pst1.setString(8, doc.getAddress());
       pst1.setString(9, doc.getBirthday());
       pst1.setString(10, doc.getMstatus());
       pst1.setString(11, doc.getPhone());
       pst1.setString(12, doc.getAssignedward());
       pst1.setString(13, doc.getRoom());
       pst2.setString(1, ward.getWardno());
       pst2.setString(2, ward.getWardtype());
       pst2.executeUpdate();
       
     
       pst1.executeUpdate();
            
           
   }
       
          catch(SQLException sqlException){
     JOptionPane.showMessageDialog(null,sqlException+ "Insert Query Fail", "Warning!", JOptionPane.ERROR_MESSAGE); 
   }
        finally {
            dbConnManager.connectionClose(dbConn);
           }
  
  } 
 
 
 
 public HMS_Doctor_1 find1(String id) {
        Connection dbConn = null;
        HMS_Doctor_1 doc = new HMS_Doctor_1();
       // WardDAO ward = new WardDAO();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query1 = "SELECT * FROM doctor WHERE doctorId = '" + id + "'";
//            String query2 = "SELECT * FROM ward WHERE ward.doctorId='" + id + "'"; 
            ResultSet rs = stmt.executeQuery(query1);
//            ResultSet rs1 = stmt.executeQuery(query2);
            if (rs.next()) {
                doc.setId(rs.getString(1));
                doc.setFirstname(rs.getString(2));
                doc.setSecondname(rs.getString(3));
                doc.setSpeciality(rs.getString(4));
                doc.setNic(rs.getString(5));
                doc.setAge(rs.getString(6));
                doc.setGender(rs.getString(7));
                doc.setAddress(rs.getString(8));
                doc.setBirthday(rs.getString(9));
                doc.setMstatus(rs.getString(10));
                doc.setPhone(rs.getString(11));
                doc.setAssignedward(rs.getString(12));
                doc.setRoom(rs.getString(13));
//                ward.setWardno(rs1.getString(1));
//                ward.setWardtype(rs1.getString(2));
            }
        else{
        JOptionPane.showMessageDialog( null, "The entered Doctor ID cannot be found.");  
        }
                
            
        } catch (Exception sQLException) {
            JOptionPane.showMessageDialog(null,sQLException + "----------InValid Doctor Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        return doc;
    
    
    }
    
 
 
    public WardDAO find2(String id){
            Connection dbConn = null;
            WardDAO ward = new WardDAO();
        try {
            
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query2 = "SELECT * FROM ward,doctor WHERE ward.wardId=doctor.ward AND doctor.doctorId='" + id + "'";
            ResultSet rs1 = stmt.executeQuery(query2);
            if(rs1.next()){
                ward.setWardno(rs1.getString(1));
                ward.setWardtype(rs1.getString(2));
            }
            else{
                JOptionPane.showMessageDialog( null, "The entered Doctor ID cannot be found.","Warning!", JOptionPane.ERROR_MESSAGE);  
            }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex + "----------InValid Doctor Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        }
        
        return ward;
    }
    
    public void updateRecord(HMS_Doctor_1 pt) {
 Connection dbConn = null;
 try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "update doctor set firstname=?,secondname=?,speciality=?,nic=?,age=?,gender=?,address=?, birthday=?, mstatus=?, phone=?, ward=?, room=?  where doctorId = ?";
            PreparedStatement pst = dbConn.prepareStatement(query);
            pst.setString(1,pt.getFirstname());
            pst.setString(2,pt.getSecondname());
            pst.setString(3,pt.getSpeciality());
            pst.setString(4,pt.getNic());
            pst.setString(5,pt.getAge());
            pst.setString(6,pt.getGender());
            pst.setString(7,pt.getAddress());
            pst.setString(8,pt.getBirthday());
            pst.setString(9,pt.getMstatus());
            pst.setString(10,pt.getPhone());
            pst.setString(11,pt.getAssignedward());
            pst.setString(12,pt.getRoom());
            pst.setString(13,pt.getId());
            
            pst.executeUpdate();
            
           
            } catch (SQLException sQLException) {
           JOptionPane.showMessageDialog(null,sQLException + "----------InValid Doctor Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
 } finally {
     
            dbConnManager.connectionClose(dbConn);
 }
    }
    
    public void delete(String doctorId) {
        Connection dbConn = null;
       
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query1 = "DELETE FROM doctor WHERE doctorId='" + doctorId + "'";
            String query2 = "delete from appoinment where doctorId='" + doctorId + "'";
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query1);
            //System.out.println(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null,sQLException + "----------Deleting Error!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        }
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
       public void setDisable(HMS_DoctorGUI_1 gui){
        
        gui.txtFirst3.setEnabled(false);
        gui.txtSecond3.setEnabled(false);
        gui.txtspeciality3.setEnabled(false);
        gui.txtGender3.setEnabled(false);
        gui.txtAge3.setEnabled(false);
        gui.txtMarried3.setEnabled(false);
        gui.txtNic3.setEnabled(false);
        gui.txtPhone3.setEnabled(false);
        gui.txtBirthdate3.setEnabled(false);
        gui.txtAddress3.setEnabled(false);
        gui.txtroom3.setEnabled(false);
        gui.txtWard3.setEnabled(false);
        gui.txtWardType3.setEnabled(false);
        gui.txtdocno3.requestFocus();
    }
        public void clear1(HMS_DoctorGUI_1 gui) {

        gui.txtFirst1.setText("");
        gui.txtSecond1.setText("");
        gui.txtNic1.setText("");
        gui.txtbirthdate1.setDate(null);
        gui.txtAge1.setText("");
        gui.txtWard1.setText("");
        gui.txtroom1.setText("");
        gui.txtPhone1.setText("");
        gui.comboGender1.setSelectedIndex(-1);
        gui.txtspeciality1.setText("");
        gui.comboReleationship1.setSelectedIndex(-1);
        gui.txtAddress1.setText("");
        gui.txtWardType4.setText("");
        gui.txtFirst1.requestFocus();

    }

    public void clear2(HMS_DoctorGUI_1 gui) {

        gui.txtdocno2.setText("");
        gui.txtFirst2.setText("");
        gui.txtSecond2.setText("");
        gui.txtNic2.setText("");
        gui.txtBirthday2.setDate(null);
        gui.txtAge2.setText("");
        gui.txtWard2.setText("");
        gui.txtroom2.setText("");
        gui.txtPhone2.setText("");
        gui.comboGender2.setSelectedIndex(-1);
        gui.txtspeciality2.setText("");
        gui.comboReleationship2.setSelectedIndex(-1);
        gui.txtAddress2.setText("");
        gui.txtdocno2.requestFocus();
        gui.txtWard2.setText("");

    }

    public void clear3(HMS_DoctorGUI_1 gui) {

        gui.txtdocno3.setText("");
        gui.txtFirst3.setText("");
        gui.txtSecond3.setText("");
        gui.txtNic3.setText("");
        gui.txtBirthdate3.setText("");
        gui.txtAge3.setText("");
        gui.txtWard3.setText("");
        gui.txtroom3.setText("");
        gui.txtPhone3.setText("");
        gui.txtGender3.setText("");
        gui.txtspeciality3.setText("");
        gui.txtMarried3.setText("");
        gui.txtAddress3.setText("");
        gui.txtWardType3.setText("");
        gui.txtdocno3.requestFocus();
    }
    
       
       
}
