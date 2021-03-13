package log;



import interfaces.HMS_AdminPanel;
import interfaces.ReceptionistPanel;
import logFromGroupProject.LoginPanel;
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
public class HMS_Appointments extends javax.swing.JFrame {

    /**
     * Creates new form Appointments
     */
    public HMS_Appointments() {
        initComponents();
        FillDoctorName();
        appointment_table();
    }

    private void FillDoctorName(){
        Connection dbConn = null;
        HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
        try{
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            String query = "select * from doctor";
            PreparedStatement pst = dbConn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String fname = rs.getString("firstname");
                String sname = rs.getString("secondname");
                comboDoctorname.addItem(fname);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }finally{
            dbConnManager.connectionClose(dbConn);
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblRoomNo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combotime = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboDoctorname = new javax.swing.JComboBox();
        txtDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblHome1a = new javax.swing.JLabel();
        lblHome1b = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtappNO = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblDocID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblHome2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblappointment = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

        jPanel4.setLayout(null);

        lblRoomNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRoomNo.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(lblRoomNo);
        lblRoomNo.setBounds(970, 270, 390, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Select Time");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(740, 360, 200, 40);

        combotime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        combotime.setForeground(new java.awt.Color(0, 153, 255));
        combotime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10:00 - 11:00", "11:00-1200", "13:00-14:00", "14:00-15:00", "15:00-16:00" }));
        jPanel4.add(combotime);
        combotime.setBounds(970, 360, 390, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Room Number");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(740, 270, 200, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Select Date");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(70, 360, 200, 40);

        comboDoctorname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        comboDoctorname.setForeground(new java.awt.Color(0, 153, 255));
        comboDoctorname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Doctor" }));
        comboDoctorname.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboDoctornamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboDoctorname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboDoctornameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboDoctornameMouseReleased(evt);
            }
        });
        comboDoctorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDoctornameActionPerformed(evt);
            }
        });
        comboDoctorname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboDoctornameKeyPressed(evt);
            }
        });
        jPanel4.add(comboDoctorname);
        comboDoctorname.setBounds(280, 200, 390, 40);

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtDate.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(txtDate);
        txtDate.setBounds(280, 360, 390, 40);

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Appointments");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(120, 40, 330, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/appointment circel icon.png"))); // NOI18N
        jPanel4.add(jLabel5);
        jLabel5.setBounds(0, 20, 110, 110);

        lblHome1a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lblHome1a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHome1aMouseClicked(evt);
            }
        });
        jPanel4.add(lblHome1a);
        lblHome1a.setBounds(1280, 50, 60, 60);

        lblHome1b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lblHome1b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHome1bMouseClicked(evt);
            }
        });
        jPanel4.add(lblHome1b);
        lblHome1b.setBounds(1280, 50, 60, 60);

        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        jPanel4.add(lblLogout);
        lblLogout.setBounds(1340, 50, 60, 60);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel4.add(jLabel9);
        jLabel9.setBounds(60, 40, 1380, 80);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Description");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(30, 100, 150, 50);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 255));
        jLabel16.setText("Age");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(1120, 30, 70, 50);

        txtpname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpnameActionPerformed(evt);
            }
        });
        jPanel5.add(txtpname);
        txtpname.setBounds(190, 40, 370, 35);

        txtage.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtageActionPerformed(evt);
            }
        });
        jPanel5.add(txtage);
        txtage.setBounds(1180, 40, 110, 35);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Phone");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(610, 30, 120, 50);

        txtphone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });
        jPanel5.add(txtphone);
        txtphone.setBounds(720, 40, 370, 35);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Patient Name");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(30, 30, 150, 50);

        txtdes.setColumns(20);
        txtdes.setRows(5);
        jScrollPane1.setViewportView(txtdes);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(190, 120, 750, 140);

        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdd);
        btnAdd.setBounds(1060, 220, 250, 60);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Patient Details");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(10, 0, 140, 30);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(40, 440, 1370, 320);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Doctor ID");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(70, 280, 230, 40);

        txtappNO.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtappNO.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(txtappNO);
        txtappNO.setBounds(970, 190, 390, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 255));
        jLabel14.setText("Select Doctor");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(70, 200, 200, 40);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("Appointment Number");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(740, 190, 260, 40);

        lblDocID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDocID.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(lblDocID);
        lblDocID.setBounds(280, 270, 390, 40);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New Appointment", jPanel1);

        jPanel6.setLayout(null);

        lblHome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lblHome2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHome2MouseClicked(evt);
            }
        });
        jPanel6.add(lblHome2);
        lblHome2.setBounds(1280, 50, 60, 60);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel19);
        jLabel19.setBounds(1340, 50, 60, 60);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/appointment circel icon.png"))); // NOI18N
        jPanel6.add(jLabel11);
        jLabel11.setBounds(0, 20, 110, 110);

        jLabel13.setBackground(new java.awt.Color(0, 204, 204));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("View Appointments");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(120, 40, 460, 80);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel6.add(jLabel17);
        jLabel17.setBounds(60, 40, 1380, 80);

        tblappointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment Number", "Doctor ID", "Doctor Name", "Room No", "Date", "Time", "Patient Name", "Age", "Phone", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblappointment);
        if (tblappointment.getColumnModel().getColumnCount() > 0) {
            tblappointment.getColumnModel().getColumn(0).setResizable(false);
            tblappointment.getColumnModel().getColumn(1).setResizable(false);
            tblappointment.getColumnModel().getColumn(2).setResizable(false);
            tblappointment.getColumnModel().getColumn(4).setResizable(false);
            tblappointment.getColumnModel().getColumn(5).setResizable(false);
            tblappointment.getColumnModel().getColumn(6).setResizable(false);
            tblappointment.getColumnModel().getColumn(7).setResizable(false);
            tblappointment.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(20, 160, 1400, 600);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("View Appointments", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHome1aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHome1aMouseClicked

        ReceptionistPanel rp = new ReceptionistPanel();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblHome1aMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked

        LoginPanel lp = new LoginPanel();
        lp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void txtpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpnameActionPerformed

    private void txtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtageActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void lblHome2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHome2MouseClicked
        
        ReceptionistPanel rp = new ReceptionistPanel();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblHome2MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void comboDoctornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDoctornameActionPerformed
        
       HMS_DBConnManager dbConnManager2 = new HMS_DBConnManager();
        Connection dbConn = null;
        try{
            String name = comboDoctorname.getSelectedItem().toString();
            dbConn = dbConnManager2.connect();
            Statement stmt = dbConn.createStatement();
            String query = "select * from doctor where firstname = '"+name+"'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String roomno = rs.getString("room");
            lblRoomNo.setText(roomno);
            
            String docid = rs.getString("doctorno");
            lblDocID.setText(docid);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex + "---------Exception");
        }

        
    }//GEN-LAST:event_comboDoctornameActionPerformed

    private void comboDoctornameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboDoctornameKeyPressed
        
    }//GEN-LAST:event_comboDoctornameKeyPressed

    private void comboDoctornameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboDoctornameMouseReleased
        
    }//GEN-LAST:event_comboDoctornameMouseReleased

    private void comboDoctornameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboDoctornameMouseExited
       
    }//GEN-LAST:event_comboDoctornameMouseExited

    private void comboDoctornamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboDoctornamePopupMenuWillBecomeInvisible
        
         
    }//GEN-LAST:event_comboDoctornamePopupMenuWillBecomeInvisible

    public void clear(){
        txtappNO.setText(null);
        lblDocID.setText(null);
        comboDoctorname.setSelectedIndex(-1);
        lblRoomNo.setText(null);
        txtDate.setText(null);
        combotime.setSelectedIndex(-1);
        txtpname.setText(null);
        txtage.setText(null);
        txtphone.setText(null);
        txtdes.setText(null);
    
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
        String appno = txtappNO.getText();
        String docid = lblDocID.getText();
        String docname = comboDoctorname.getSelectedItem().toString();
        String room = lblRoomNo.getText();
        String date = txtDate.getText();
        String time = combotime.getSelectedItem().toString();
        String pname = txtpname.getText();
        String age = txtage.getText();
        String phone = txtphone.getText();
        String des = txtdes.getText();
        Appointments ap = new Appointments();
        ap.addAppointment(appno,docid,docname,room,date,time,pname,age,phone,des);
        JOptionPane.showMessageDialog(this, "Appointment Inserted");
        clear();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void lblHome1bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHome1bMouseClicked
        
        HMS_AdminPanel ad = new HMS_AdminPanel();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblHome1bMouseClicked

    
    public void appointment_table()
    {       HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
            Connection dbConn = null;
            try {
                dbConn = dbConnManager.connect();
                PreparedStatement pst = dbConn.prepareStatement("select * from appointment");
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
                        v2.add(rs.getString("appointmentno"));
                        v2.add(rs.getString("doctorid"));
                        v2.add(rs.getString("doctorname"));
                        v2.add(rs.getString("roomno"));
                        v2.add(rs.getString("date"));
                        v2.add(rs.getString("time"));
                        v2.add(rs.getString("pname"));
                        v2.add(rs.getString("age"));
                        v2.add(rs.getString("phone"));
                        v2.add(rs.getString("description"));
                        

                    }
                    df.addRow(v2);
                }
            
            } catch (SQLException ex) {
            Logger.getLogger(HMS_Appointments.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(HMS_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_Appointments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox comboDoctorname;
    private javax.swing.JComboBox combotime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDocID;
    public javax.swing.JLabel lblHome1a;
    public javax.swing.JLabel lblHome1b;
    private javax.swing.JLabel lblHome2;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblRoomNo;
    private javax.swing.JTable tblappointment;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtappNO;
    private javax.swing.JTextArea txtdes;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtpname;
    // End of variables declaration//GEN-END:variables
}
