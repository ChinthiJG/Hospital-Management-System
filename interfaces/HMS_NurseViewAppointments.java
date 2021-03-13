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
import javax.swing.JOptionPane;
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
public class HMS_NurseViewAppointments extends javax.swing.JFrame {

    /**
     * Creates new form ViewAppointments
     */
    public HMS_NurseViewAppointments() {
        initComponents();
        appointment_table();
    }

    
    public void appointment_table()
    {       HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
            Connection dbConn = null;
            try {
                dbConn = dbConnManager.connect();
                PreparedStatement pst = dbConn.prepareStatement("select * from appoinment");
                ResultSet rs = pst.executeQuery();

                ResultSetMetaData Rsm = rs.getMetaData();

                int c;
                c = Rsm.getColumnCount();

                DefaultTableModel df = (DefaultTableModel)tblappointment.getModel();
                df.setRowCount(0);

                while(rs.next())
                {
                    Vector v2 = new Vector();

                    for(int i=1;i<=c;i++)
                    {
                        v2.add(rs.getString("appoinmentno"));
                        v2.add(rs.getString("doctorId"));
                        v2.add(rs.getString("doctorfullname"));
                        
                        v2.add(rs.getString("date"));
                        v2.add(rs.getString("time"));
                        v2.add(rs.getString("patientname"));
                        v2.add(rs.getString("age"));
                        v2.add(rs.getString("phone"));
                        v2.add(rs.getString("description"));
                        

                    }
                    df.addRow(v2);
                }
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex+"InValid Appoinments!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
            }
       
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNurseHome = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblappointment = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

        jPanel1.setLayout(null);

        lblNurseHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lblNurseHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNurseHomeMouseClicked(evt);
            }
        });
        jPanel1.add(lblNurseHome);
        lblNurseHome.setBounds(1280, 50, 60, 60);

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

        tblappointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment Number", "Doctor ID", "Doctor Name", "Date", "Time", "Patient Name", "Age", "Phone", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblappointment);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 160, 1400, 600);

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

    private void lblNurseHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNurseHomeMouseClicked
       
        NursePanel np =new  NursePanel();
        np.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblNurseHomeMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        
       HMS_Login lp = new HMS_Login();
        lp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(HMS_NurseViewAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_NurseViewAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_NurseViewAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_NurseViewAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new HMS_NurseViewAppointments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblNurseHome;
    private javax.swing.JTable tblappointment;
    // End of variables declaration//GEN-END:variables
}
