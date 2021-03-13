package log;



import connection.HMS_DBConnManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mekhala Sewwandi
 */
public class Appointments {
    
   HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
   
   public void addAppointment(String appno,String docid,String docname,String room,String date,String time,String pname,String age,String phone,String des){
   Connection dbConn = null;
   
   try{
       dbConn = dbConnManager.connect();
       Statement stmt = dbConn.createStatement();
       String sql = "insert into appointment(appointmentno,doctorid,doctorname,roomno,date,time,pname,age,phone,description) Values(?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement pst = dbConn.prepareStatement(sql);
       pst.setString(1,appno );
       pst.setString(2, docid);
       pst.setString(3, docname);
       pst.setString(4, room);
       pst.setString(5, date);
       pst.setString(6, time);
       pst.setString(7, pname);
       pst.setString(8, age);
       pst.setString(9, phone);
       pst.setString(10, des);
      
       pst.executeUpdate();
            
           
   }
       
          catch(SQLException sqlException){
                System.out.println(sqlException + "-----------Insert query failed");  
   }
        finally {
            dbConnManager.connectionClose(dbConn);
           }
  
  } 
 
   
    
     
}
