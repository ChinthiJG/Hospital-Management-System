/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Details.WardDetails;
import GetSet.HMS_Doctor_1;
import GetSet.WardDAO;
import Validations.Validations_Ward;
import com.sun.glass.events.KeyEvent;
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



/**
 *
 * @author Mekhala Sewwandi
 */
public class WardGUI extends javax.swing.JFrame {

    /**
     * Creates new form WardGUI
     */
    public WardGUI() {
        initComponents();
    }
    
    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    PreparedStatement pst;
    ResultSet rs;

    
     
     int beds = 30;
     public int available_beds;
      public int table()
    {
        String wardno = txtWardno.getText();
             Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select patient.patientno,patient.firstname,patient.bedno From patient,ward where patient.wardno=ward.wardId and ward.wardId=?");
            pst.setString(1, wardno);
             rs = pst.executeQuery();
        
            ResultSetMetaData Rsm = rs.getMetaData();
        
            int c;
            c = Rsm.getColumnCount();
            //JOptionPane.showMessageDialog(this,c);
            
            DefaultTableModel df = (DefaultTableModel)tblPatient.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1;i<=c;i++)
                {
                v2.add(rs.getString("patientno"));
                 v2.add(rs.getString("firstname"));
                 v2.add(rs.getString("bedno"));
               }
                df.addRow(v2);
                
            }
             
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex + "----------ERROR!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        }
            int rows = tblPatient.getRowCount();
            available_beds = beds-rows;
            lblBeds.setText(String.valueOf(available_beds));
         return available_beds;
    }
     
    public void nurseTable()
    {
        String wardno = txtWardno.getText();
             Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select nurse.nurseno,nurse.firstname,nurse.phone From nurse,ward WHERE ward.wardId=nurse.ward AND ward.wardId=?");
            pst.setString(1, wardno);
             rs = pst.executeQuery();
        
            ResultSetMetaData Rsm = rs.getMetaData();
        
            int c;
            c = Rsm.getColumnCount();
            //JOptionPane.showMessageDialog(this,c);
            
            DefaultTableModel df = (DefaultTableModel)tblNurse.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1;i<=c;i++)
                {
                v2.add(rs.getString("nurseno"));
                 v2.add(rs.getString("firstname"));
                 v2.add(rs.getString("phone"));
               }
                df.addRow(v2);
                
            }
             
           
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex + "----------ERROR!!!","Warning!", JOptionPane.ERROR_MESSAGE);
        }
            
    }
     
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        lblDoc = new javax.swing.JTextField();
        lbladminHome = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        lblBeds = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        txtWardno = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNurse = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 153, 255));
        jLabel82.setText("Assigned Doctor");
        jPanel1.add(jLabel82);
        jLabel82.setBounds(870, 250, 180, 40);

        lblDoc.setEditable(false);
        lblDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblDocActionPerformed(evt);
            }
        });
        jPanel1.add(lblDoc);
        lblDoc.setBounds(1060, 250, 360, 40);

        lbladminHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lbladminHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbladminHomeMouseClicked(evt);
            }
        });
        jPanel1.add(lbladminHome);
        lbladminHome.setBounds(1280, 50, 60, 60);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel29);
        jLabel29.setBounds(1340, 50, 60, 60);

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ward");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 40, 400, 80);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 40, 1380, 80);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 153, 255));
        jLabel79.setText("Number of Available Beds : ");

        lblBeds.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblBeds.setForeground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBeds, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblBeds, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(990, 140, 430, 70);

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 153, 255));
        jLabel81.setText("Ward Number : ");
        jPanel1.add(jLabel81);
        jLabel81.setBounds(50, 240, 230, 50);

        txtWardno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWardno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWardnoActionPerformed(evt);
            }
        });
        txtWardno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtWardnoKeyPressed(evt);
            }
        });
        jPanel1.add(txtWardno);
        txtWardno.setBounds(260, 250, 370, 40);

        btnSelect.setBackground(new java.awt.Color(0, 153, 255));
        btnSelect.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelect);
        btnSelect.setBounds(670, 230, 150, 60);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Bed No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPatient);

        tblNurse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nurse Id", "Nurse name", "Contact No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNurse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNurseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNurse);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(157, 157, 157))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(30, 320, 1390, 470);

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

    private void lbladminHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladminHomeMouseClicked
NursePanel n = new NursePanel();
n.setVisible(true);
        this.dispose();
        
        
        

    }//GEN-LAST:event_lbladminHomeMouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
HMS_Login l = new HMS_Login();
l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void txtWardnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWardnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWardnoActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed

       
        String wardno = txtWardno.getText();
        WardDetails ward = new WardDetails();
        HMS_Doctor_1 id = ward.LoadDoctor(wardno);
        
        lblDoc.setText(id.getFirstname());
        
      // LoadDoctor();
       table();
       nurseTable();
        
    }//GEN-LAST:event_btnSelectActionPerformed

    
    
    
    
    private void lblDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDocActionPerformed

    private void tblPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientMouseClicked
        boolean a = tblPatient.isEditing();
        if(a==false){
            tblPatient.setEnabled(a);
        }
    }//GEN-LAST:event_tblPatientMouseClicked

    private void tblNurseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNurseMouseClicked
       boolean a = tblNurse.isEditing();
        if(a==false){
            tblNurse.setEnabled(a);
        }
    }//GEN-LAST:event_tblNurseMouseClicked

    private void txtWardnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWardnoKeyPressed
          char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtWardno.getText();
        Validations_Ward val = new Validations_Ward();
        val.ward1(c1, c2, text, this);
    }//GEN-LAST:event_txtWardnoKeyPressed

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
            java.util.logging.Logger.getLogger(WardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WardGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBeds;
    public javax.swing.JTextField lblDoc;
    public javax.swing.JLabel lbladminHome;
    private javax.swing.JTable tblNurse;
    private javax.swing.JTable tblPatient;
    public javax.swing.JTextField txtWardno;
    // End of variables declaration//GEN-END:variables
}
