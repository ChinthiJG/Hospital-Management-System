/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import connection.HMS_DBConnManager;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Details.UserDetails;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_ChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form HMS_ChangePassword
     */
    public HMS_ChangePassword() {
        initComponents();
    }

    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    PreparedStatement pst;
    ResultSet rs; 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtCurrentpwrd = new javax.swing.JPasswordField();
        txtnewpwrd2 = new javax.swing.JPasswordField();
        txtnewpwrd1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel18);
        jLabel18.setBounds(1280, 50, 60, 60);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19);
        jLabel19.setBounds(1340, 50, 60, 60);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/admin circle.png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 20, 110, 110);

        jLabel13.setBackground(new java.awt.Color(0, 204, 204));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Change Password");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(120, 40, 460, 80);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel1.add(jLabel17);
        jLabel17.setBounds(60, 40, 1380, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/create user.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(860, 250, 410, 400);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("User Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 220, 120, 50);

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername);
        txtusername.setBounds(290, 230, 370, 35);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("New Password");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(80, 360, 190, 50);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 255));
        jLabel14.setText("Repeat Password");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(80, 430, 190, 50);

        btnCreate.setBackground(new java.awt.Color(0, 153, 255));
        btnCreate.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Change");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate);
        btnCreate.setBounds(260, 580, 320, 60);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("Current Password");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(80, 290, 200, 50);

        txtCurrentpwrd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtCurrentpwrd);
        txtCurrentpwrd.setBounds(290, 300, 370, 40);

        txtnewpwrd2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtnewpwrd2);
        txtnewpwrd2.setBounds(290, 440, 370, 40);

        txtnewpwrd1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtnewpwrd1);
        txtnewpwrd1.setBounds(290, 370, 370, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

        HMS_AdminPanel ad = new HMS_AdminPanel();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked

        LoginPanel lg = new LoginPanel();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed
public String x;
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        
        try {
            Connection dbConn = null;
            
            String username = txtusername.getText();
            //String cPassword = txtCurrentpwrd.getText();
            String currentpwrd = txtCurrentpwrd.getText();
            String newpwrd1 = txtnewpwrd1.getText();
            String newpwrd2 = txtnewpwrd2.getText();
            dbConn = dbConnManager.connect();
            
            pst=dbConn.prepareStatement("select password from user where username=?");
            pst.setString(1,username);
            rs=pst.executeQuery();
            if(rs.next()){
                x = rs.getString("password");
                
            }
            System.out.println(x);
            UserDetails ud = new UserDetails();
             boolean y = ud.valPassword(newpwrd1);
             if(y == true ){
            if(x.equals(currentpwrd)){
            if(newpwrd1.equals(newpwrd2))
            {
                try {
                    
                    String query = "update user set password=? where username = ? ";
                    PreparedStatement pst = dbConn.prepareStatement(query);
                    
                    pst.setString(1,newpwrd1);
                    pst.setString(2,username);
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Password Changed");
                    txtCurrentpwrd.setText(null);
                    txtnewpwrd1.setText(null);
                    txtnewpwrd2.setText(null);
                    txtusername.setText(null);
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(HMS_ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                finally {
                    dbConnManager.connectionClose(dbConn);
                }
            }
            
            else
                JOptionPane.showMessageDialog(this, "Password does not match");
            }
             }
        } catch (SQLException ex) {
            Logger.getLogger(HMS_ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_btnCreateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HMS_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtCurrentpwrd;
    private javax.swing.JPasswordField txtnewpwrd1;
    private javax.swing.JPasswordField txtnewpwrd2;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
