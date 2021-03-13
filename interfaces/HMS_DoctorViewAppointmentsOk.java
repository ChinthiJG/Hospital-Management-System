package interfaces;

import connection.HMS_DBConnManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
public class HMS_DoctorViewAppointmentsOk extends javax.swing.JFrame {

    /**
     * Creates new form ViewAppointments
     */
    String id;
    public HMS_DoctorViewAppointmentsOk() {
        initComponents();
       // DoctorPanel dp = new DoctorPanel();
       // String id = dp.lbldocno.getText();
        //lbldocno.setText(id);
     //DoctorPanel p = new DoctorPanel();
        
       //appoinment_table();
       
    }

    public HMS_DoctorViewAppointmentsOk(String doc){
        
         initComponents();
         this.id=doc;
         lbldocno2.setText(id);
         appoinment_table();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbldocno2 = new javax.swing.JLabel();
        lblDocHome = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbldocno1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

        jPanel1.setLayout(null);

        lbldocno2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbldocno2.setForeground(new java.awt.Color(0, 153, 255));
        lbldocno2.setText("Doctor ID");
        jPanel1.add(lbldocno2);
        lbldocno2.setBounds(340, 0, 220, 40);

        lblDocHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lblDocHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDocHomeMouseClicked(evt);
            }
        });
        jPanel1.add(lblDocHome);
        lblDocHome.setBounds(1280, 50, 60, 60);

        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        jPanel1.add(lblLogout);
        lblLogout.setBounds(1340, 50, 60, 60);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/appointment circel icon.png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 20, 110, 110);

        jLabel13.setBackground(new java.awt.Color(0, 204, 204));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Appointments");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(120, 40, 460, 80);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel1.add(jLabel17);
        jLabel17.setBounds(60, 40, 1380, 80);

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment Number", "Date", "Time", "Patient Name", "Age", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAppointments);
        if (tblAppointments.getColumnModel().getColumnCount() > 0) {
            tblAppointments.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 160, 1400, 600);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("You are logged as :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 0, 240, 40);

        lbldocno1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbldocno1.setForeground(new java.awt.Color(0, 153, 255));
        lbldocno1.setText("Doctor ID");
        jPanel1.add(lbldocno1);
        lbldocno1.setBounds(350, 220, 220, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1441, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDocHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDocHomeMouseClicked
       
        DoctorPanel dp =new DoctorPanel();
        dp.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblDocHomeMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
    
        LoginPanel lp = new LoginPanel();
        lp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked
HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
PreparedStatement pst;
    ResultSet rs; 
   
     public void appoinment_table()
    {
    String id = lbldocno2.getText();
        System.out.println(id);
        Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select * from appoinment where doctorId=?");
            pst.setString(1, id);
            rs = pst.executeQuery();
        
            ResultSetMetaData Rsm = rs.getMetaData();
        
            int c;
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)tblAppointments.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("appoinmentno"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("time"));
                    v2.add(rs.getString("patientname"));
                    v2.add(rs.getString("age"));
                    v2.add(rs.getString("description"));
                    
                   
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HMS_DoctorGUI_1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
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
            java.util.logging.Logger.getLogger(HMS_DoctorViewAppointmentsOk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_DoctorViewAppointmentsOk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_DoctorViewAppointmentsOk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_DoctorViewAppointmentsOk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_DoctorViewAppointmentsOk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDocHome;
    private javax.swing.JLabel lblLogout;
    public javax.swing.JLabel lbldocno1;
    public javax.swing.JLabel lbldocno2;
    public javax.swing.JTable tblAppointments;
    // End of variables declaration//GEN-END:variables
}
