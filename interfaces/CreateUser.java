package interfaces;



import connection.HMS_DBConnManager;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Details.UserDetails;
import GetSet.Occupation;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mekhala Sewwandi
 */
public class CreateUser extends javax.swing.JFrame {

    /**
     * Creates new form CreateUser
     */
    public CreateUser() {
        initComponents();
      // txtpwrd1.setEchoChar('\u25CF');
    }

    
    public void clear(){
        txtidno.setText(null);
        comboJob.setSelectedIndex(-1);
        txtusername.setText(null);
        txtpwrd1.setText(null);
        txtpwrd2.setText(null);
    }
    
  HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
//    public boolean validId(){
//        Connection dbConn = null;
//            
//            dbConn = dbConnManager.connect();
//            pst = dbConn.prepareStatement("select distinct speciality from doctor");
//            rs = pst.executeQuery();
//    }
//    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboJob = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        image2 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        check = new javax.swing.JCheckBox();
        txtpwrd1 = new javax.swing.JPasswordField();
        txtpwrd2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

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
        jLabel13.setText("Create User");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(120, 40, 460, 80);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel1.add(jLabel17);
        jLabel17.setBounds(60, 40, 1380, 80);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("User Type");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 220, 120, 50);

        txtidno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtidno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtidno);
        txtidno.setBounds(290, 300, 370, 35);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("User Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 360, 120, 50);

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername);
        txtusername.setBounds(290, 370, 370, 35);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Password");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(80, 450, 160, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/create user.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(860, 250, 410, 400);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("ID");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 290, 120, 50);

        comboJob.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        comboJob.setForeground(new java.awt.Color(0, 153, 255));
        comboJob.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Doctor", "Nurse", "Receptionist" }));
        jPanel1.add(comboJob);
        comboJob.setBounds(290, 230, 370, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 255));
        jLabel14.setText("Repeat Password");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(80, 530, 190, 50);

        btnCreate.setBackground(new java.awt.Color(0, 153, 255));
        btnCreate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate);
        btnCreate.setBounds(510, 670, 320, 60);

        image2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/log/show_hide_password-10-512.png"))); // NOI18N
        image2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                image2MousePressed(evt);
            }
        });
        jPanel1.add(image2);
        image2.setBounds(670, 460, 50, 40);

        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/log/download.png"))); // NOI18N
        image1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                image1MousePressed(evt);
            }
        });
        jPanel1.add(image1);
        image1.setBounds(670, 460, 50, 40);

        check.setText("Show Password");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel1.add(check);
        check.setBounds(430, 500, 140, 25);

        txtpwrd1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtpwrd1);
        txtpwrd1.setBounds(290, 452, 370, 40);

        txtpwrd2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtpwrd2);
        txtpwrd2.setBounds(290, 530, 370, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1444, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

        HMS_AdminPanel ad = new HMS_AdminPanel();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
       
      HMS_Login lg = new HMS_Login();
       lg.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void txtidnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnoActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        
        UserDetails ud = new UserDetails();
        
        String id = txtidno.getText();
        String job = comboJob.getSelectedItem().toString();
        String username = txtusername.getText();
        String pwrd1 = txtpwrd1.getText();
        String pwrd2 = txtpwrd2.getText();
      
         boolean x = ud.valPassword(pwrd1);
         if(x == true)
        {
          if(pwrd1.equals(pwrd2))
           {
               Occupation user = new Occupation(id, username, job, pwrd1);
        
            ud.addUser(user);
            JOptionPane.showMessageDialog(this,"User Created");
            clear();
           }
        
        else{
            JOptionPane.showMessageDialog(this,"Passwords does not match");
            clear();
        }   
        
        
        } 
         
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
       
         if(check.isSelected())
        {
         txtpwrd1.setEchoChar((char)0);
         image1.setVisible(true);
         image2.setVisible(false);
        }
        else
        {
          txtpwrd1.setEchoChar('\u25CF');
          image2.setVisible(true);
          image1.setVisible(false);
         
          
        }
        
    }//GEN-LAST:event_checkActionPerformed

    private void image1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image1MousePressed
         image2.setVisible(true);
        image1.setVisible(false);
        txtpwrd1.setEchoChar('\u25CF');
    }//GEN-LAST:event_image1MousePressed

    private void image2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image2MousePressed
      image1.setVisible(true);
        image2.setVisible(false);
         txtpwrd1.setEchoChar((char)0);
    }//GEN-LAST:event_image2MousePressed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JCheckBox check;
    private javax.swing.JComboBox comboJob;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtidno;
    private javax.swing.JPasswordField txtpwrd1;
    private javax.swing.JPasswordField txtpwrd2;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
