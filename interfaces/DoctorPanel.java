package interfaces;

import interfaces.HMS_DoctorViewAppointmentsOk;
import interfaces.HMS_Login;
import interfaces.HMS_ChangePassword1_Doc;
import connection.HMS_DBConnManager;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;




public class DoctorPanel extends javax.swing.JFrame {


    public DoctorPanel(String lbl) {
        initComponents();
        clock();
        this.lbldocno1.setText(lbl);
 }
    public DoctorPanel(){
         initComponents();
    }
    
    
    
    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    PreparedStatement pst;
    ResultSet rs; 
   
     public void appoinment_table()
    {
        Connection dbConn = null;
        HMS_DoctorViewAppointmentsOk ok = new HMS_DoctorViewAppointmentsOk();
        String id = lbldocno1.getText();

        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select * from appoinment");
            pst.setString(1, id);
            rs = pst.executeQuery();
        
            ResultSetMetaData Rsm = rs.getMetaData();
        
            int c;
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)ok.tblAppointments.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString(1));
                    v2.add(rs.getString(4));
                    v2.add(rs.getString(5));
                    v2.add(rs.getString(6));
                   v2.add(rs.getString(7));
                   v2.add(rs.getString(8));
                    
                   
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HMS_DoctorGUI_1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    

// public void appointment_table()
//    {       HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
//            Connection dbConn = null;
//            //DoctorPanel panel = new DoctorPanel();
//            String id = lbldocno1.getText();
//            HMS_DoctorViewAppointmentsOk app = new HMS_DoctorViewAppointmentsOk();
//            try {
//                dbConn = dbConnManager.connect();
//                PreparedStatement pst = dbConn.prepareStatement("select * from appointment");
//                pst.setString(1, id);
//                ResultSet rs = pst.executeQuery();
//                
//                ResultSetMetaData Rsm = rs.getMetaData();
//
//                int c;
//                c = Rsm.getColumnCount();
//
//                DefaultTableModel df = (DefaultTableModel)app.tblAppointments.getModel();
//                df.setRowCount(0);
//
//                while(rs.next())
//                {
//                    Vector v2 = new Vector();
//
//                    for(int i=1;i<=c;i++)
//                    {
//                        v2.add(rs.getString("appoinmentno"));
//                        v2.add(rs.getString("date"));
//                        v2.add(rs.getString("time"));
//                        v2.add(rs.getString("patientname"));
//                        v2.add(rs.getString("age"));
//                        v2.add(rs.getString("description"));
//                        
//
//                    }
//                    df.addRow(v2);
//                }
//            
//            } catch (SQLException ex) {
//            Logger.getLogger(HMS_DoctorViewAppointmentsOk.class.getName()).log(Level.SEVERE, null, ex);
//            }
//       
//    }
    public String docID = null;
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
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbldocno1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("You are login as");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 16, 210, 30);

        lbldocno1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbldocno1.setForeground(new java.awt.Color(0, 153, 255));
        lbldocno1.setText("Doctor ID");
        jPanel1.add(lbldocno1);
        lbldocno1.setBounds(280, 10, 220, 40);

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTime.setText("Time");
        jPanel1.add(lblTime);
        lblTime.setBounds(1110, 10, 310, 29);

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("Date");
        jPanel1.add(lblDate);
        lblDate.setBounds(1110, 40, 310, 29);

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DOCTOR PORTAL");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 420, 80);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(-10, 70, 490, 100);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 40)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 255));
        jButton2.setText("Appointments");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(230, 240, 390, 90);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 40)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 255));
        jButton3.setText("Change Password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(250, 430, 390, 90);

        btnLogout.setBackground(new java.awt.Color(0, 153, 255));
        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout);
        btnLogout.setBounds(330, 670, 190, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/doctor panel.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1440, 810);

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        HMS_ChangePassword1_Doc change = new HMS_ChangePassword1_Doc();
        change.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

       HMS_Login lp = new HMS_Login();
        lp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String label = lbldocno1.getText();
        new HMS_DoctorViewAppointmentsOk(label).setVisible(true);
//        HMS_DoctorViewAppointmentsOk ap = new HMS_DoctorViewAppointmentsOk();
//        ap.setVisible(true);
        this.setVisible(false);
        // appoinment_table();
       
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    public javax.swing.JLabel lbldocno1;
    // End of variables declaration//GEN-END:variables
}
