package interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import interfaces.HMS_Login;
import interfaces.CreateUser;



import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;



/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_AdminPanel extends javax.swing.JFrame {

  
    public HMS_AdminPanel() {
        initComponents();
        clock();
    }

    
    HMS_ReceptionistGUI rec = new HMS_ReceptionistGUI();
    HMS_DoctorGUI_1 doctor = new HMS_DoctorGUI_1();
     HMS_NurseGUI nurse = new HMS_NurseGUI();
     CreateUser user = new CreateUser();
     WardGUI ward = new WardGUI();
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblReceptionist = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblNurse = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblCreateUser = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 20));

        jPanel1.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/admin circle.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 60, 110, 110);

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMIN PORTAL");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 80, 420, 80);

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 153, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout);
        btnLogout.setBounds(1240, 100, 170, 50);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 255));
        jLabel13.setText("Doctor Details");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13);
        jLabel13.setBounds(550, 730, 240, 60);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 80, 1380, 80);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("Receptionist");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15);
        jLabel15.setBounds(1070, 450, 220, 60);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/receptionist icon2.jpg"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(1110, 310, 120, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/doc icon2.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(590, 590, 120, 120);

        lblDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/whiteBackground.png"))); // NOI18N
        lblDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoctorMouseClicked(evt);
            }
        });
        jPanel1.add(lblDoctor);
        lblDoctor.setBounds(470, 570, 390, 260);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 255));
        jLabel17.setText("Nurse Details");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17);
        jLabel17.setBounds(540, 450, 240, 60);

        lblReceptionist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/whiteBackground.png"))); // NOI18N
        lblReceptionist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReceptionistMouseClicked(evt);
            }
        });
        jPanel1.add(lblReceptionist);
        lblReceptionist.setBounds(960, 270, 410, 260);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/nurse icon2.jpg"))); // NOI18N
        jPanel1.add(jLabel16);
        jLabel16.setBounds(590, 300, 130, 130);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("to");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(150, 500, 40, 50);

        lblNurse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/whiteBackground.png"))); // NOI18N
        lblNurse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNurseMouseClicked(evt);
            }
        });
        jPanel1.add(lblNurse);
        lblNurse.setBounds(460, 270, 390, 260);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("WELCOME");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(60, 400, 230, 70);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("ADMIN PORTAL");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(30, 590, 290, 70);

        jLabel22.setBackground(new java.awt.Color(0, 153, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/background color image.jpg"))); // NOI18N
        jPanel1.add(jLabel22);
        jLabel22.setBounds(0, 250, 350, 610);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/admin circle.png"))); // NOI18N
        jPanel1.add(jLabel23);
        jLabel23.setBounds(1110, 580, 150, 150);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Create User");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel27);
        jLabel27.setBounds(1080, 730, 210, 90);

        lblCreateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/whiteBackground.png"))); // NOI18N
        lblCreateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCreateUserMouseClicked(evt);
            }
        });
        jPanel1.add(lblCreateUser);
        lblCreateUser.setBounds(960, 570, 410, 250);

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 153, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTime.setText("Time");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDate.setForeground(new java.awt.Color(0, 153, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(840, 0, 580, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        
        this.dispose();
        rec.setVisible(true);
        
        
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

          
          doctor.setVisible(true);
          this.dispose();
        
        
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked

          
           nurse.setVisible(true);
           this.dispose();
        
        
    }//GEN-LAST:event_jLabel17MouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

      
        
        
        HMS_Login lp = new HMS_Login();
        lp.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        
      
    }//GEN-LAST:event_jLabel27MouseClicked

    private void lblReceptionistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReceptionistMouseClicked
        
        rec.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_lblReceptionistMouseClicked

    private void lblDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoctorMouseClicked
        
        doctor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDoctorMouseClicked

    private void lblNurseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNurseMouseClicked
        
        nurse.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblNurseMouseClicked

    private void lblCreateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateUserMouseClicked
        
        user.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblCreateUserMouseClicked

    public void clock(){
        Thread th = new Thread(){
            public void run(){
                try{
                    for(;;)
                    {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH)+1;
                        int year = cal.get(Calendar.YEAR);
                        
                        int sec = cal.get(Calendar.SECOND);
                        int min = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        int am_pm = cal.get(Calendar.AM_PM);
                        
                        String d_n = "";
                        if(am_pm == 1){
                            d_n = "PM";
                        }
                        else
                            d_n = "AM";
                        lblTime.setText("" + hour+":"+min+":"+sec+" "+d_n + "");
                        lblDate.setText("" + day +"/" + month+"/"+year + "");
                        sleep(1000);
                    }
                }catch(Exception ex){
                    System.out.println(ex + "Error in displaying time");
                }
            }
        };
        th.start();
    }
    
    
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
            java.util.logging.Logger.getLogger(HMS_AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCreateUser;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblNurse;
    private javax.swing.JLabel lblReceptionist;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
