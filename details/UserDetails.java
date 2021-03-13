package Details;



import GetSet.Occupation;

import java.sql.*;
import connection.HMS_DBConnManager;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mekhala Sewwandi
 */
public class UserDetails {
    
    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    Connection dbConn = null;
    
    
    
    
    public void addUser(Occupation u){
       try{
           
           dbConn = dbConnManager.connect();
           Statement stmt = dbConn.createStatement();
           String sql = "insert into user(id,username,job,password)Values (?,?,?,?)";
           PreparedStatement pst = dbConn.prepareStatement(sql);
           pst.setString(1, u.getId());
           pst.setString(2, u.getUsername());
           pst.setString(3, u.getOccupation());
           pst.setString(4, u.getPassword());
           
           pst.executeUpdate();
           
        }
       catch(Exception ex)
        {
            System.out.println(ex + "-----------Insert query failed");  
        }
    
       finally{
           dbConnManager.connectionClose(dbConn);
       }
       
    }
    
    
    public Occupation finduser(String un){
        Connection dbConn = null;
        Occupation ut = new Occupation();
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "SELECT * FROM user WHERE username = '" + un + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                ut.setId(rs.getString(1));
                ut.setUsername(rs.getString(2));
                ut.setOccupation(rs.getString(3));
                ut.setPassword(rs.getString(4));
                
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------The entered Pateint ID cannot be found.");
        } finally {
            dbConnManager.connectionClose(dbConn);
        }
        
        return ut;
    }
 public static boolean checkPass(String password)
    {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;
        
        for(int i =0 ; i<password.length(); i++)
        {
          c = password.charAt(i);
          if(Character.isDigit(c))
          {
              hasNum = true;
          }
          else if(Character.isUpperCase(c))
          {
              hasCap = true;
          }
          else if(Character.isLowerCase(c))
          {
              hasLow= true;
          }
          if(hasNum && hasCap && hasLow)
          {
             return true; 
          }   
        }
        JOptionPane.showMessageDialog(null, "Password must contain at least one or more lowercase letter,Uppercase letter and Number");
        return false;
    }
    
    public static boolean valPassword(String password)
    {
        if(password.length()>7)
        {
            return checkPass(password);
        }
    
        else
        {
            JOptionPane.showMessageDialog(null, "Password must contain minimum 8 characters");
        return false;
        }
    }

    
 }
    
  
    

