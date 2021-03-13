/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Details.HMS_DoctorDetails_1;
import Details.HMS_NurseDetails;
import GetSet.HMS_Nurse;
import Validations.Validations_Nurse;
import Validations.Validations_Patient;
import com.sun.glass.events.KeyEvent;
import connection.HMS_DBConnManager;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mekhala Sewwandi
 */
public class HMS_NurseGUI extends javax.swing.JFrame {

    /**
     * Creates new form PatientDetails
     */
    public HMS_NurseGUI() {
        initComponents();
        AutoID();
        nurse_table();  
        HMS_NurseDetails nd = new HMS_NurseDetails();
        nd.setDisable(this);
         txtbirthdate1.setMaxSelectableDate(new java.util.Date());
        txtbirthdate1.setDateFormatString("dd-MM-yyyy");
        txtbirthdate2.setMaxSelectableDate(new java.util.Date());
        txtbirthdate2.setDateFormatString("dd-MM-yyyy");
    }

    
    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    PreparedStatement pst;
    ResultSet rs; 

    
    
     public void nurse_table()
    {
        
        Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select * from nurse");
            rs = pst.executeQuery();
        
            ResultSetMetaData Rsm = rs.getMetaData();
        
            int c;
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)tblnurse.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("nurseno"));
                    v2.add(rs.getString("firstname"));
                    v2.add(rs.getString("secondname"));
                    v2.add(rs.getString("nic"));
                    v2.add(rs.getString("age"));
                    v2.add(rs.getString("gender"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("birthday"));
                    v2.add(rs.getString("mstatus"));
                    v2.add(rs.getString("phone"));
                    v2.add(rs.getString("qualification"));
                    v2.add(rs.getString("ward"));
                    
                   
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HMS_NurseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     
     public void AutoID()
    {
        Connection dbConn = null;
        try {
            
            dbConn = dbConnManager.connect();
            Statement s = dbConn.createStatement();
            rs = s.executeQuery("select MAX(nurseno) from nurse");
            rs.next();
            rs.getString("MAX(nurseno)");
            
            if(rs.getString("MAX(nurseno)")==null)
            {
                lblnurseno1.setText("NS001");
                
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(nurseno)").substring(2,rs.getString("MAX(nurseno)").length()));
                id++;
                lblnurseno1.setText("NS"+String.format("%03d",id));
            }
            

            
        } catch (SQLException ex) {
            Logger.getLogger(HMS_NurseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtward1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtqualification1 = new javax.swing.JTextField();
        lblnurseno1 = new javax.swing.JLabel();
        txtFirst1 = new javax.swing.JTextField();
        txtSecond1 = new javax.swing.JTextField();
        txtNic1 = new javax.swing.JTextField();
        comboGender1 = new javax.swing.JComboBox();
        txtAge1 = new javax.swing.JTextField();
        txtbirthdate1 = new com.toedter.calendar.JDateChooser();
        comboReleationship1 = new javax.swing.JComboBox();
        txtPhone1 = new javax.swing.JTextField();
        txtAddress1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtnurseno2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtFirst2 = new javax.swing.JTextField();
        txtSecond2 = new javax.swing.JTextField();
        txtNic2 = new javax.swing.JTextField();
        txtAge2 = new javax.swing.JTextField();
        txtPhone2 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtqualification2 = new javax.swing.JTextField();
        txtward2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtbirthdate2 = new com.toedter.calendar.JDateChooser();
        comboReleationship2 = new javax.swing.JComboBox();
        comboGender2 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtnurseno3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnSearch2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtNic3 = new javax.swing.JTextField();
        txtFirst3 = new javax.swing.JTextField();
        txtAge3 = new javax.swing.JTextField();
        txtAddress3 = new javax.swing.JTextField();
        txtqualification3 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtward3 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtPhone3 = new javax.swing.JTextField();
        txtSecond3 = new javax.swing.JTextField();
        txtGender3 = new javax.swing.JTextField();
        txtbirthdate3 = new javax.swing.JTextField();
        txtMarried3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnurse = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 50));

        jPanel6.setLayout(null);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel32);
        jLabel32.setBounds(1280, 50, 60, 60);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel34);
        jLabel34.setBounds(1340, 50, 60, 60);

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Nurse");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(120, 40, 260, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/nurse circle icon.png"))); // NOI18N
        jPanel6.add(jLabel3);
        jLabel3.setBounds(0, 20, 120, 120);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel6.add(jLabel9);
        jLabel9.setBounds(60, 40, 1380, 80);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("NIC");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(80, 330, 120, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("ID");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(80, 200, 120, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("First Name");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(80, 260, 120, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Gender");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(690, 320, 160, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Birth Date");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(690, 400, 160, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Maritial Status");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(80, 460, 160, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Address");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(80, 530, 120, 50);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 255));
        jLabel11.setText("Second Name");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(690, 260, 160, 50);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Phone");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(690, 470, 120, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 255));
        jLabel14.setText("Assigned Ward");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(690, 600, 160, 50);

        txtward1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtward1ActionPerformed(evt);
            }
        });
        txtward1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtward1KeyPressed(evt);
            }
        });
        jPanel6.add(txtward1);
        txtward1.setBounds(860, 610, 370, 35);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("Age");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(80, 390, 120, 50);

        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel6.add(btnAdd);
        btnAdd.setBounds(1040, 680, 280, 60);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 255));
        jLabel16.setText("Qualification");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(80, 600, 140, 50);

        txtqualification1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel6.add(txtqualification1);
        txtqualification1.setBounds(250, 610, 370, 40);

        lblnurseno1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblnurseno1.setText("Nurse Id");
        jPanel6.add(lblnurseno1);
        lblnurseno1.setBounds(240, 210, 360, 30);

        txtFirst1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirst1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtFirst1);
        txtFirst1.setBounds(250, 270, 370, 40);

        txtSecond1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSecond1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecond1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtSecond1);
        txtSecond1.setBounds(860, 270, 370, 40);

        txtNic1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNic1ActionPerformed(evt);
            }
        });
        txtNic1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNic1KeyPressed(evt);
            }
        });
        jPanel6.add(txtNic1);
        txtNic1.setBounds(250, 328, 370, 40);

        comboGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboGender1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jPanel6.add(comboGender1);
        comboGender1.setBounds(860, 330, 370, 40);

        txtAge1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge1ActionPerformed(evt);
            }
        });
        txtAge1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAge1KeyPressed(evt);
            }
        });
        jPanel6.add(txtAge1);
        txtAge1.setBounds(250, 400, 370, 40);

        txtbirthdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel6.add(txtbirthdate1);
        txtbirthdate1.setBounds(860, 400, 370, 40);

        comboReleationship1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboReleationship1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        jPanel6.add(comboReleationship1);
        comboReleationship1.setBounds(250, 470, 370, 40);

        txtPhone1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhone1ActionPerformed(evt);
            }
        });
        txtPhone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhone1KeyPressed(evt);
            }
        });
        jPanel6.add(txtPhone1);
        txtPhone1.setBounds(860, 470, 370, 40);

        txtAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtAddress1);
        txtAddress1.setBounds(250, 540, 980, 50);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1435, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Nurse", jPanel1);

        jPanel10.setLayout(null);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jPanel10.add(jLabel35);
        jLabel35.setBounds(1280, 50, 60, 60);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel36);
        jLabel36.setBounds(1340, 50, 60, 60);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/nurse circle icon.png"))); // NOI18N
        jPanel10.add(jLabel13);
        jLabel13.setBounds(0, 20, 120, 120);

        jLabel52.setBackground(new java.awt.Color(0, 204, 204));
        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Update Nurse");
        jPanel10.add(jLabel52);
        jLabel52.setBounds(120, 40, 320, 80);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel10.add(jLabel54);
        jLabel54.setBounds(60, 40, 1380, 80);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 153, 255));
        jLabel55.setText("NIC");
        jPanel10.add(jLabel55);
        jLabel55.setBounds(80, 320, 120, 50);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 153, 255));
        jLabel56.setText("ID");
        jPanel10.add(jLabel56);
        jLabel56.setBounds(80, 160, 120, 50);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 153, 255));
        jLabel57.setText("First Name");
        jPanel10.add(jLabel57);
        jLabel57.setBounds(80, 260, 120, 50);

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 153, 255));
        jLabel58.setText("Gender");
        jPanel10.add(jLabel58);
        jLabel58.setBounds(690, 320, 160, 50);

        txtnurseno2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnurseno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnurseno2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtnurseno2);
        txtnurseno2.setBounds(240, 170, 370, 40);

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 153, 255));
        jLabel59.setText("Birth Date");
        jPanel10.add(jLabel59);
        jLabel59.setBounds(690, 400, 160, 40);

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 153, 255));
        jLabel60.setText("Maritial Status");
        jPanel10.add(jLabel60);
        jLabel60.setBounds(80, 460, 160, 50);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 153, 255));
        jLabel61.setText("Address");
        jPanel10.add(jLabel61);
        jLabel61.setBounds(80, 530, 120, 50);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 153, 255));
        jLabel62.setText("Second Name");
        jPanel10.add(jLabel62);
        jLabel62.setBounds(690, 260, 160, 50);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 153, 255));
        jLabel63.setText("Phone");
        jPanel10.add(jLabel63);
        jLabel63.setBounds(690, 470, 120, 50);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 153, 255));
        jLabel66.setText("Age");
        jPanel10.add(jLabel66);
        jLabel66.setBounds(80, 390, 120, 50);

        btnSearch1.setBackground(new java.awt.Color(0, 153, 255));
        btnSearch1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });
        jPanel10.add(btnSearch1);
        btnSearch1.setBounds(680, 160, 280, 60);

        btnUpdate.setBackground(new java.awt.Color(0, 153, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel10.add(btnUpdate);
        btnUpdate.setBounds(1070, 680, 280, 60);
        jPanel10.add(jSeparator3);
        jSeparator3.setBounds(10, 240, 1430, 2);

        txtFirst2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirst2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtFirst2);
        txtFirst2.setBounds(250, 270, 370, 40);

        txtSecond2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSecond2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecond2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtSecond2);
        txtSecond2.setBounds(860, 270, 370, 40);

        txtNic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNic2ActionPerformed(evt);
            }
        });
        txtNic2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNic2KeyPressed(evt);
            }
        });
        jPanel10.add(txtNic2);
        txtNic2.setBounds(250, 328, 370, 40);

        txtAge2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge2ActionPerformed(evt);
            }
        });
        txtAge2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAge2KeyPressed(evt);
            }
        });
        jPanel10.add(txtAge2);
        txtAge2.setBounds(250, 400, 370, 40);

        txtPhone2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhone2ActionPerformed(evt);
            }
        });
        txtPhone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhone2KeyPressed(evt);
            }
        });
        jPanel10.add(txtPhone2);
        txtPhone2.setBounds(860, 470, 370, 40);

        txtAddress2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtAddress2);
        txtAddress2.setBounds(250, 540, 980, 50);

        txtqualification2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel10.add(txtqualification2);
        txtqualification2.setBounds(250, 610, 370, 40);

        txtward2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtward2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtward2ActionPerformed(evt);
            }
        });
        txtward2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtward2KeyPressed(evt);
            }
        });
        jPanel10.add(txtward2);
        txtward2.setBounds(860, 610, 370, 35);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 255));
        jLabel18.setText("Qualification");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(80, 600, 140, 50);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 255));
        jLabel41.setText("Assigned Ward");
        jPanel10.add(jLabel41);
        jLabel41.setBounds(690, 600, 160, 50);

        txtbirthdate2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel10.add(txtbirthdate2);
        txtbirthdate2.setBounds(860, 400, 370, 40);

        comboReleationship2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboReleationship2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        jPanel10.add(comboReleationship2);
        comboReleationship2.setBounds(250, 470, 370, 40);

        comboGender2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboGender2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jPanel10.add(comboGender2);
        comboGender2.setBounds(860, 330, 370, 40);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1435, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update Nurse", jPanel2);

        jPanel7.setLayout(null);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jPanel7.add(jLabel37);
        jLabel37.setBounds(1280, 50, 60, 60);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel38);
        jLabel38.setBounds(1340, 50, 60, 60);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/nurse circle icon.png"))); // NOI18N
        jPanel7.add(jLabel29);
        jLabel29.setBounds(0, 20, 120, 120);

        jLabel17.setBackground(new java.awt.Color(0, 204, 204));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Delete Nurse");
        jPanel7.add(jLabel17);
        jLabel17.setBounds(120, 40, 320, 80);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel7.add(jLabel19);
        jLabel19.setBounds(60, 40, 1380, 80);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 255));
        jLabel20.setText("NIC");
        jPanel7.add(jLabel20);
        jLabel20.setBounds(80, 320, 120, 50);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 255));
        jLabel21.setText("ID");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(80, 160, 120, 50);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 255));
        jLabel22.setText("First Name");
        jPanel7.add(jLabel22);
        jLabel22.setBounds(80, 260, 120, 50);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 255));
        jLabel23.setText("Gender");
        jPanel7.add(jLabel23);
        jLabel23.setBounds(690, 320, 160, 50);

        txtnurseno3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnurseno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnurseno3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtnurseno3);
        txtnurseno3.setBounds(240, 170, 370, 40);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 255));
        jLabel24.setText("Birth Date");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(690, 400, 160, 40);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 255));
        jLabel25.setText("Maritial Status");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(80, 460, 160, 50);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 255));
        jLabel26.setText("Address");
        jPanel7.add(jLabel26);
        jLabel26.setBounds(80, 530, 120, 50);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Second Name");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(690, 260, 160, 50);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 255));
        jLabel28.setText("Phone");
        jPanel7.add(jLabel28);
        jLabel28.setBounds(690, 470, 120, 50);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 255));
        jLabel31.setText("Age");
        jPanel7.add(jLabel31);
        jLabel31.setBounds(80, 390, 120, 50);

        btnSearch2.setBackground(new java.awt.Color(0, 153, 255));
        btnSearch2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setText("Search");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });
        jPanel7.add(btnSearch2);
        btnSearch2.setBounds(680, 160, 280, 60);

        btnDelete.setBackground(new java.awt.Color(0, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel7.add(btnDelete);
        btnDelete.setBounds(1050, 680, 280, 60);
        jPanel7.add(jSeparator1);
        jSeparator1.setBounds(10, 240, 1430, 2);

        txtNic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNic3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtNic3);
        txtNic3.setBounds(250, 328, 370, 40);

        txtFirst3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirst3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtFirst3);
        txtFirst3.setBounds(250, 270, 370, 40);

        txtAge3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtAge3);
        txtAge3.setBounds(250, 400, 370, 40);

        txtAddress3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtAddress3);
        txtAddress3.setBounds(250, 540, 980, 50);

        txtqualification3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtqualification3);
        txtqualification3.setBounds(250, 610, 370, 40);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 153, 255));
        jLabel42.setText("Assigned Ward");
        jPanel7.add(jLabel42);
        jLabel42.setBounds(690, 600, 160, 50);

        txtward3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtward3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtward3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtward3);
        txtward3.setBounds(860, 610, 370, 35);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 255));
        jLabel43.setText("Qualification");
        jPanel7.add(jLabel43);
        jLabel43.setBounds(80, 600, 140, 50);

        txtPhone3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhone3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtPhone3);
        txtPhone3.setBounds(860, 470, 370, 40);

        txtSecond3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSecond3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecond3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtSecond3);
        txtSecond3.setBounds(860, 270, 370, 40);

        txtGender3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtGender3);
        txtGender3.setBounds(860, 330, 370, 40);

        txtbirthdate3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtbirthdate3);
        txtbirthdate3.setBounds(860, 400, 370, 40);

        txtMarried3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtMarried3);
        txtMarried3.setBounds(250, 470, 370, 40);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1435, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Delete Nurse", jPanel3);

        jPanel9.setLayout(null);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jPanel9.add(jLabel39);
        jLabel39.setBounds(1280, 50, 60, 60);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel40);
        jLabel40.setBounds(1340, 50, 60, 60);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/nurse circle icon.png"))); // NOI18N
        jPanel9.add(jLabel33);
        jLabel33.setBounds(0, 20, 120, 120);

        jLabel49.setBackground(new java.awt.Color(0, 204, 204));
        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("View Nurse");
        jPanel9.add(jLabel49);
        jLabel49.setBounds(120, 40, 310, 80);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel9.add(jLabel51);
        jLabel51.setBounds(60, 40, 1380, 80);

        tblnurse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Second Name", "NIC", "Age", "Gender", "Address", "BirthDate", "Married Status", "Phone", "Qualification", "Assigned Ward"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblnurse);

        jPanel9.add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 1420, 560);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1435, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("View Nurse", jPanel5);

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

    private void txtward1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtward1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtward1ActionPerformed

    private void txtnurseno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnurseno3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnurseno3ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        
        String id = txtnurseno3.getText();
        
         HMS_NurseDetails nd = new HMS_NurseDetails();
         HMS_Nurse nurse = nd.find(id);
        
         txtFirst3.setText(nurse.getFirstname());
         txtSecond3.setText(nurse.getSecondname());
         txtNic3.setText(nurse.getNic());
         txtGender3.setText(nurse.getGender());
         txtAge3.setText(nurse.getAge());
         txtbirthdate3.setText(nurse.getBirthday());
         txtMarried3.setText(nurse.getMstatus());
         txtAddress3.setText(nurse.getAddress());
         txtqualification3.setText(nurse.getQualification());
         txtward3.setText(nurse.getAssignedward());
         txtPhone3.setText(nurse.getPhone());
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void txtnurseno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnurseno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnurseno2ActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        
        String id = txtnurseno2.getText();
        
        HMS_NurseDetails nd = new HMS_NurseDetails();
        HMS_Nurse nurse = nd.find(id);
        
        txtFirst2.setText(nurse.getFirstname());
        txtSecond2.setText(nurse.getSecondname());
        txtNic2.setText(nurse.getNic());
        
        txtAge2.setText(nurse.getAge());
        String bdate = nurse.getBirthday();
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
        } catch (ParseException ex) {
            Logger.getLogger(HMS_NurseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtbirthdate2.setDate(date);
       
         if (nurse.getGender().equals("Male")) {
            comboGender2.setSelectedIndex(0);
        } else  {
            comboGender2.setSelectedIndex(1);
        }
        
         if (nurse.getMstatus().equals("Single")) {
           comboReleationship2.setSelectedIndex(0);
        } else {
            comboReleationship2.setSelectedIndex(1);
        }
        
        txtAddress2.setText(nurse.getAddress());
        txtqualification2.setText(nurse.getQualification());
        txtward2.setText(nurse.getAssignedward());
        txtPhone2.setText(nurse.getPhone());
        
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        
        
        String nurseno = txtnurseno2.getText();
        String firstname = txtFirst2.getText();
        String secondname = txtSecond2.getText();
        String nic = txtNic2.getText();
        String gender = comboGender2.getSelectedItem().toString();
        String age = txtAge2.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday=dateFormat.format(txtbirthdate2.getDate());
        String mstatus = comboReleationship2.getSelectedItem().toString();
        String address = txtAddress2.getText();
        String qualification = txtqualification2.getText();
        String ward = txtward2.getText();
        String phone = txtPhone2.getText();
        
        HMS_Nurse id =   new HMS_Nurse(nurseno,firstname, secondname, nic, gender,age,birthday,mstatus,phone,address,qualification,ward);
        
        HMS_NurseDetails pd = new HMS_NurseDetails();
        pd.updateRecord(id);
        JOptionPane.showMessageDialog(this,"Record Updated");
        nurse_table();
        pd.clear2(this);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
HMS_Login l = new HMS_Login();
l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked

        this.dispose();

    }//GEN-LAST:event_jLabel36MouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked

        this.dispose();

    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked

        this.dispose();

    }//GEN-LAST:event_jLabel40MouseClicked

    private void txtFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirst1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirst1ActionPerformed

    private void txtSecond1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecond1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecond1ActionPerformed

    private void txtNic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNic1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNic1ActionPerformed

    private void txtAge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge1ActionPerformed

    private void txtPhone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhone1ActionPerformed

    private void txtAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress1ActionPerformed

    private void txtFirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirst2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirst2ActionPerformed

    private void txtSecond2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecond2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecond2ActionPerformed

    private void txtNic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNic2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNic2ActionPerformed

    private void txtAge2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge2ActionPerformed

    private void txtPhone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhone2ActionPerformed

    private void txtAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress2ActionPerformed

    private void txtward2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtward2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtward2ActionPerformed

    private void txtNic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNic3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNic3ActionPerformed

    private void txtFirst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirst3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirst3ActionPerformed

    private void txtAge3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge3ActionPerformed

    private void txtAddress3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress3ActionPerformed

    private void txtward3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtward3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtward3ActionPerformed

    private void txtPhone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhone3ActionPerformed

    private void txtSecond3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecond3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecond3ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
        HMS_NurseDetails nurse = new HMS_NurseDetails();
        
        String nurseno = lblnurseno1.getText();
        String firstname = txtFirst1.getText();
        String secondname= txtSecond1.getText();
        String nic=txtNic1.getText();
        String gender=comboGender1.getSelectedItem().toString();
        String age=txtAge1.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday=dateFormat.format(txtbirthdate1.getDate());
        String qualification = txtqualification1.getText();
        String mstatus=comboReleationship1.getSelectedItem().toString();
        String phone=txtPhone1.getText();
        String address=txtAddress1.getText();
        String ward = txtward1.getText();
        
        
        HMS_Nurse id; 
              id =   new HMS_Nurse(qualification,ward,nurseno,firstname,secondname,nic,gender,age,birthday,mstatus, phone,address);
 
              
        nurse.addNurse(id);
        JOptionPane.showMessageDialog(this,"Record Inserted");
        
        AutoID();
        nurse_table();
        HMS_NurseDetails nd = new HMS_NurseDetails();
        nd.clear1(this);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        String recpno = txtnurseno3.getText();
        
        HMS_NurseDetails rd = new HMS_NurseDetails();
        
        rd.deleteReceptionist(recpno);
        
        JOptionPane.showMessageDialog(this, "Record Deleted");
        HMS_NurseDetails nd = new HMS_NurseDetails();
        nd.clear3(this);
        nurse_table();
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        HMS_AdminPanel a = new HMS_AdminPanel();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void txtNic2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNic2KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtNic2.getText();
        Validations_Nurse val = new Validations_Nurse();
        val.key2(c1, c2, text, this);
    }//GEN-LAST:event_txtNic2KeyPressed

    private void txtNic1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNic1KeyPressed
         char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtNic1.getText();
        Validations_Nurse val = new Validations_Nurse();
        val.key1(c1, c2, text, this);
    }//GEN-LAST:event_txtNic1KeyPressed

    private void txtAge1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAge1KeyPressed
          char c = evt.getKeyChar();
        Validations_Nurse val = new Validations_Nurse();
        val.age1(c,this);
    }//GEN-LAST:event_txtAge1KeyPressed

    private void txtPhone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhone1KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtPhone1.getText();
        Validations_Nurse val = new Validations_Nurse();
        val.phone1(c1, c2, text, this);
    }//GEN-LAST:event_txtPhone1KeyPressed

    private void txtward1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtward1KeyPressed
          char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtward1.getText();
        Validations_Nurse val = new Validations_Nurse();
        val.ward1(c1, c2, text, this);
    }//GEN-LAST:event_txtward1KeyPressed

    private void txtAge2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAge2KeyPressed
         char c = evt.getKeyChar();
        Validations_Nurse val = new Validations_Nurse();
        val.age2(c,this);
    }//GEN-LAST:event_txtAge2KeyPressed

    private void txtPhone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhone2KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtPhone2.getText();
        Validations_Nurse val = new Validations_Nurse();
        val.phone2(c1, c2, text, this);
    }//GEN-LAST:event_txtPhone2KeyPressed

    private void txtward2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtward2KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtward2.getText();
        Validations_Nurse val = new Validations_Nurse();
        val.ward2(c1, c2, text, this); 
    }//GEN-LAST:event_txtward2KeyPressed

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
            java.util.logging.Logger.getLogger(HMS_NurseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_NurseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_NurseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_NurseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new HMS_NurseGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnUpdate;
    public javax.swing.JComboBox comboGender1;
    public javax.swing.JComboBox comboGender2;
    public javax.swing.JComboBox comboReleationship1;
    public javax.swing.JComboBox comboReleationship2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblnurseno1;
    private javax.swing.JTable tblnurse;
    public javax.swing.JTextField txtAddress1;
    public javax.swing.JTextField txtAddress2;
    public javax.swing.JTextField txtAddress3;
    public javax.swing.JTextField txtAge1;
    public javax.swing.JTextField txtAge2;
    public javax.swing.JTextField txtAge3;
    public javax.swing.JTextField txtFirst1;
    public javax.swing.JTextField txtFirst2;
    public javax.swing.JTextField txtFirst3;
    public javax.swing.JTextField txtGender3;
    public javax.swing.JTextField txtMarried3;
    public javax.swing.JTextField txtNic1;
    public javax.swing.JTextField txtNic2;
    public javax.swing.JTextField txtNic3;
    public javax.swing.JTextField txtPhone1;
    public javax.swing.JTextField txtPhone2;
    public javax.swing.JTextField txtPhone3;
    public javax.swing.JTextField txtSecond1;
    public javax.swing.JTextField txtSecond2;
    public javax.swing.JTextField txtSecond3;
    public com.toedter.calendar.JDateChooser txtbirthdate1;
    public com.toedter.calendar.JDateChooser txtbirthdate2;
    public javax.swing.JTextField txtbirthdate3;
    public javax.swing.JTextField txtnurseno2;
    public javax.swing.JTextField txtnurseno3;
    public javax.swing.JTextField txtqualification1;
    public javax.swing.JTextField txtqualification2;
    public javax.swing.JTextField txtqualification3;
    public javax.swing.JTextField txtward1;
    public javax.swing.JTextField txtward2;
    public javax.swing.JTextField txtward3;
    // End of variables declaration//GEN-END:variables
}
