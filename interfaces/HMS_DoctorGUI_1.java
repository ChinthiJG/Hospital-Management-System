/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Details.HMS_DoctorDetails_1;
import GetSet.HMS_Doctor_1;
import GetSet.WardDAO;
import GetSet.User;
import Validations.Validations1;

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
public class HMS_DoctorGUI_1 extends javax.swing.JFrame {

    HMS_DoctorDetails_1 hms = new HMS_DoctorDetails_1();

    public HMS_DoctorGUI_1() {
        initComponents();
        AutoID();
        doctor_table();
        hms.setDisable(this);
        txtbirthdate1.setMaxSelectableDate(new java.util.Date());
        txtbirthdate1.setDateFormatString("dd-MM-yyyy");
        txtBirthday2.setMaxSelectableDate(new java.util.Date());
        txtBirthday2.setDateFormatString("dd-MM-yyyy");

    }

    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    PreparedStatement pst;
    ResultSet rs;



    public void doctor_table() {
        Connection dbConn = null;
        try {
            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select * from doctor");
            rs = pst.executeQuery();

            ResultSetMetaData Rsm = rs.getMetaData();

            int c;
            c = Rsm.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) tbldoctor.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("doctorId"));
                    v2.add(rs.getString("firstname"));
                    v2.add(rs.getString("secondname"));
                    v2.add(rs.getString("speciality"));
                    v2.add(rs.getString("nic"));
                    v2.add(rs.getString("age"));
                    v2.add(rs.getString("gender"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("birthday"));
                    v2.add(rs.getString("mstatus"));
                    v2.add(rs.getString("phone"));
                    v2.add(rs.getString("ward"));
                    v2.add(rs.getString("room"));

                }
                df.addRow(v2);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex + "----------InValid Doctor Number!!!","Warning!", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(HMS_DoctorGUI_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AutoID() {
        Connection dbConn = null;
        try {

            dbConn = dbConnManager.connect();
            Statement s = dbConn.createStatement();
            rs = s.executeQuery("select MAX(doctorId) from doctor");
            rs.next();
            rs.getString("MAX(doctorId)");

            if (rs.getString("MAX(doctorId)") == null) {
                lbldocno1.setText("DOC001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(doctorId)").substring(3, rs.getString("MAX(doctorId)").length()));
                id++;
                lbldocno1.setText("DOC" + String.format("%03d", id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HMS_DoctorGUI_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtWardNo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblAdminHome = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNic1 = new javax.swing.JTextField();
        txtFirst1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        txtSecond1 = new javax.swing.JTextField();
        txtPhone1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboGender1 = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        txtspeciality1 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtAge1 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        comboReleationship1 = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtroom1 = new javax.swing.JTextField();
        lbldocno1 = new javax.swing.JLabel();
        txtbirthdate1 = new com.toedter.calendar.JDateChooser();
        txtWard1 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txtWardType4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtdocno2 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtFirst2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtAge2 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtroom2 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        txtWard2 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtPhone2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtNic2 = new javax.swing.JTextField();
        txtSecond2 = new javax.swing.JTextField();
        txtspeciality2 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        txtBirthday2 = new com.toedter.calendar.JDateChooser();
        txtWardType5 = new javax.swing.JTextField();
        comboGender2 = new javax.swing.JComboBox();
        comboReleationship2 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtdocno3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        btnSearch2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtFirst3 = new javax.swing.JTextField();
        txtspeciality3 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtAge3 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtroom3 = new javax.swing.JTextField();
        txtAddress3 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtPhone3 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtNic3 = new javax.swing.JTextField();
        txtSecond3 = new javax.swing.JTextField();
        txtGender3 = new javax.swing.JTextField();
        txtBirthdate3 = new javax.swing.JTextField();
        txtMarried3 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        txtWard3 = new javax.swing.JTextField();
        txtWardType3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldoctor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtWardNo.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Doctor");
        txtWardNo.add(jLabel2);
        jLabel2.setBounds(120, 40, 260, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/doc circle icon.png"))); // NOI18N
        txtWardNo.add(jLabel3);
        jLabel3.setBounds(0, 20, 110, 110);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        txtWardNo.add(jLabel15);
        jLabel15.setBounds(1340, 50, 60, 60);

        lblAdminHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        lblAdminHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminHomeMouseClicked(evt);
            }
        });
        txtWardNo.add(lblAdminHome);
        lblAdminHome.setBounds(1270, 50, 60, 60);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        txtWardNo.add(jLabel9);
        jLabel9.setBounds(60, 40, 1380, 80);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("NIC");
        txtWardNo.add(jLabel1);
        jLabel1.setBounds(690, 330, 120, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("ID");
        txtWardNo.add(jLabel4);
        jLabel4.setBounds(80, 200, 120, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("First Name");
        txtWardNo.add(jLabel5);
        jLabel5.setBounds(80, 260, 120, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Gender");
        txtWardNo.add(jLabel6);
        jLabel6.setBounds(80, 400, 160, 50);

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
        txtWardNo.add(txtNic1);
        txtNic1.setBounds(860, 340, 370, 40);

        txtFirst1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirst1ActionPerformed(evt);
            }
        });
        txtWardNo.add(txtFirst1);
        txtFirst1.setBounds(240, 270, 370, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Birth Date");
        txtWardNo.add(jLabel7);
        jLabel7.setBounds(690, 400, 160, 40);

        lbldate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbldate.setForeground(new java.awt.Color(0, 153, 255));
        lbldate.setText(" ");
        txtWardNo.add(lbldate);
        lbldate.setBounds(1090, 160, 160, 50);

        txtSecond1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSecond1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecond1ActionPerformed(evt);
            }
        });
        txtWardNo.add(txtSecond1);
        txtSecond1.setBounds(860, 270, 370, 40);

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
        txtWardNo.add(txtPhone1);
        txtPhone1.setBounds(860, 475, 370, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setText("Phone");
        txtWardNo.add(jLabel12);
        jLabel12.setBounds(690, 470, 120, 50);

        comboGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboGender1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        txtWardNo.add(comboGender1);
        comboGender1.setBounds(240, 410, 370, 40);

        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        txtWardNo.add(btnAdd);
        btnAdd.setBounds(1080, 790, 280, 60);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 153, 255));
        jLabel36.setText("Speciality");
        txtWardNo.add(jLabel36);
        jLabel36.setBounds(80, 330, 120, 50);

        txtspeciality1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtspeciality1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtspeciality1ActionPerformed(evt);
            }
        });
        txtWardNo.add(txtspeciality1);
        txtspeciality1.setBounds(240, 340, 370, 40);

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 153, 255));
        jLabel72.setText("Age");
        txtWardNo.add(jLabel72);
        jLabel72.setBounds(80, 470, 120, 50);

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
        txtWardNo.add(txtAge1);
        txtAge1.setBounds(240, 480, 370, 40);

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 153, 255));
        jLabel73.setText("Maritial Status");
        txtWardNo.add(jLabel73);
        jLabel73.setBounds(80, 540, 160, 50);

        comboReleationship1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboReleationship1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        txtWardNo.add(comboReleationship1);
        comboReleationship1.setBounds(240, 540, 370, 40);

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 153, 255));
        jLabel74.setText("Address");
        txtWardNo.add(jLabel74);
        jLabel74.setBounds(690, 530, 120, 50);

        txtAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress1ActionPerformed(evt);
            }
        });
        txtWardNo.add(txtAddress1);
        txtAddress1.setBounds(860, 540, 370, 40);

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 153, 255));
        jLabel75.setText("----------------------------------------Ward Details---------------------------------------------------------------------------");
        txtWardNo.add(jLabel75);
        jLabel75.setBounds(140, 670, 1230, 40);

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 153, 255));
        jLabel76.setText("Ward Type");
        txtWardNo.add(jLabel76);
        jLabel76.setBounds(410, 800, 160, 50);

        txtroom1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtroom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroom1ActionPerformed(evt);
            }
        });
        txtroom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtroom1KeyPressed(evt);
            }
        });
        txtWardNo.add(txtroom1);
        txtroom1.setBounds(240, 610, 370, 40);

        lbldocno1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbldocno1.setText("Doctor Id");
        txtWardNo.add(lbldocno1);
        lbldocno1.setBounds(240, 206, 360, 30);

        txtbirthdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtbirthdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtbirthdate1MousePressed(evt);
            }
        });
        txtWardNo.add(txtbirthdate1);
        txtbirthdate1.setBounds(860, 410, 360, 40);

        txtWard1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtWard1KeyPressed(evt);
            }
        });
        txtWardNo.add(txtWard1);
        txtWard1.setBounds(170, 800, 230, 40);

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 153, 255));
        jLabel87.setText("Room Number");
        txtWardNo.add(jLabel87);
        jLabel87.setBounds(80, 610, 160, 50);

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 153, 255));
        jLabel88.setText("Ward No");
        txtWardNo.add(jLabel88);
        jLabel88.setBounds(60, 800, 160, 50);
        txtWardNo.add(txtWardType4);
        txtWardType4.setBounds(590, 800, 230, 40);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 255));
        jLabel20.setText("Second Name");
        txtWardNo.add(jLabel20);
        jLabel20.setBounds(690, 260, 160, 50);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtWardNo, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtWardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Doctor", jPanel1);

        jPanel10.setLayout(null);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jPanel10.add(jLabel16);
        jLabel16.setBounds(1280, 50, 60, 60);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel18);
        jLabel18.setBounds(1340, 50, 60, 60);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/doc circle icon.png"))); // NOI18N
        jPanel10.add(jLabel13);
        jLabel13.setBounds(0, 20, 110, 110);

        jLabel52.setBackground(new java.awt.Color(0, 204, 204));
        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Update Doctor");
        jPanel10.add(jLabel52);
        jLabel52.setBounds(120, 40, 320, 80);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel10.add(jLabel54);
        jLabel54.setBounds(60, 40, 1380, 80);

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

        txtdocno2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtdocno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocno2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtdocno2);
        txtdocno2.setBounds(240, 170, 370, 40);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 153, 255));
        jLabel62.setText("Second Name");
        jPanel10.add(jLabel62);
        jLabel62.setBounds(690, 260, 160, 50);

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
        btnUpdate.setBounds(950, 840, 280, 60);
        jPanel10.add(jSeparator3);
        jSeparator3.setBounds(10, 240, 1430, 2);

        txtFirst2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirst2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtFirst2);
        txtFirst2.setBounds(240, 270, 370, 40);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 153, 255));
        jLabel37.setText("Speciality");
        jPanel10.add(jLabel37);
        jLabel37.setBounds(80, 330, 120, 50);

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
        txtAge2.setBounds(240, 480, 370, 40);

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 153, 255));
        jLabel77.setText("Age");
        jPanel10.add(jLabel77);
        jLabel77.setBounds(80, 470, 120, 50);

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 153, 255));
        jLabel78.setText("Ward Type");
        jPanel10.add(jLabel78);
        jLabel78.setBounds(70, 860, 160, 50);

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 153, 255));
        jLabel79.setText("Maritial Status");
        jPanel10.add(jLabel79);
        jLabel79.setBounds(80, 540, 160, 50);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Gender");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(80, 400, 160, 50);

        txtroom2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtroom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroom2ActionPerformed(evt);
            }
        });
        txtroom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtroom2KeyPressed(evt);
            }
        });
        jPanel10.add(txtroom2);
        txtroom2.setBounds(240, 610, 370, 40);

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 153, 255));
        jLabel80.setText("-------------------------------------------------------------Ward Details---------------------------------------------------------------");
        jPanel10.add(jLabel80);
        jLabel80.setBounds(140, 690, 1270, 50);

        txtWard2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWard2ActionPerformed(evt);
            }
        });
        txtWard2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtWard2KeyPressed(evt);
            }
        });
        jPanel10.add(txtWard2);
        txtWard2.setBounds(250, 790, 370, 40);

        txtAddress2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtAddress2);
        txtAddress2.setBounds(860, 540, 370, 40);

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 153, 255));
        jLabel81.setText("Address");
        jPanel10.add(jLabel81);
        jLabel81.setBounds(690, 530, 120, 50);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 255));
        jLabel32.setText("Phone");
        jPanel10.add(jLabel32);
        jLabel32.setBounds(690, 470, 120, 50);

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
        txtPhone2.setBounds(860, 475, 370, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Birth Date");
        jPanel10.add(jLabel10);
        jLabel10.setBounds(690, 400, 160, 40);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 153, 255));
        jLabel38.setText("NIC");
        jPanel10.add(jLabel38);
        jLabel38.setBounds(690, 330, 120, 50);

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
        txtNic2.setBounds(860, 340, 370, 40);

        txtSecond2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSecond2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecond2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtSecond2);
        txtSecond2.setBounds(860, 270, 370, 40);

        txtspeciality2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtspeciality2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtspeciality2ActionPerformed(evt);
            }
        });
        jPanel10.add(txtspeciality2);
        txtspeciality2.setBounds(240, 340, 370, 40);

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 153, 255));
        jLabel89.setText("Assigned Ward");
        jPanel10.add(jLabel89);
        jLabel89.setBounds(70, 780, 160, 50);

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 153, 255));
        jLabel90.setText("Room Number");
        jPanel10.add(jLabel90);
        jLabel90.setBounds(80, 610, 160, 50);

        txtBirthday2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel10.add(txtBirthday2);
        txtBirthday2.setBounds(860, 410, 360, 40);

        txtWardType5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWardType5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWardType5ActionPerformed(evt);
            }
        });
        jPanel10.add(txtWardType5);
        txtWardType5.setBounds(250, 860, 370, 40);

        comboGender2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboGender2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jPanel10.add(comboGender2);
        comboGender2.setBounds(240, 410, 370, 40);

        comboReleationship2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboReleationship2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        jPanel10.add(comboReleationship2);
        comboReleationship2.setBounds(240, 540, 370, 50);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update Doctor", jPanel2);

        jPanel7.setLayout(null);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jPanel7.add(jLabel25);
        jLabel25.setBounds(1280, 50, 60, 60);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel26);
        jLabel26.setBounds(1340, 50, 60, 60);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/doc circle icon.png"))); // NOI18N
        jPanel7.add(jLabel29);
        jLabel29.setBounds(0, 20, 110, 110);

        jLabel17.setBackground(new java.awt.Color(0, 204, 204));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Delete Doctor");
        jPanel7.add(jLabel17);
        jLabel17.setBounds(120, 40, 320, 80);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel7.add(jLabel19);
        jLabel19.setBounds(60, 40, 1380, 80);

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

        txtdocno3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtdocno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocno3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtdocno3);
        txtdocno3.setBounds(240, 170, 370, 40);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Second Name");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(690, 260, 160, 50);

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
        btnDelete.setBounds(1040, 860, 280, 60);
        jPanel7.add(jSeparator1);
        jSeparator1.setBounds(10, 240, 1430, 2);

        txtFirst3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirst3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtFirst3);
        txtFirst3.setBounds(240, 270, 370, 40);

        txtspeciality3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtspeciality3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtspeciality3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtspeciality3);
        txtspeciality3.setBounds(240, 340, 370, 40);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 153, 255));
        jLabel39.setText("Speciality");
        jPanel7.add(jLabel39);
        jLabel39.setBounds(80, 330, 120, 50);

        txtAge3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtAge3);
        txtAge3.setBounds(240, 480, 370, 40);

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 153, 255));
        jLabel82.setText("Age");
        jPanel7.add(jLabel82);
        jLabel82.setBounds(80, 470, 120, 50);

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 153, 255));
        jLabel83.setText("Room Number");
        jPanel7.add(jLabel83);
        jLabel83.setBounds(80, 610, 160, 50);

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 153, 255));
        jLabel84.setText("Maritial Status");
        jPanel7.add(jLabel84);
        jLabel84.setBounds(80, 540, 160, 50);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 255));
        jLabel40.setText("Gender");
        jPanel7.add(jLabel40);
        jLabel40.setBounds(80, 400, 160, 50);

        txtroom3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtroom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroom3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtroom3);
        txtroom3.setBounds(240, 610, 370, 40);

        txtAddress3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtAddress3);
        txtAddress3.setBounds(860, 540, 370, 40);

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 153, 255));
        jLabel86.setText("Address");
        jPanel7.add(jLabel86);
        jLabel86.setBounds(690, 530, 120, 50);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 255));
        jLabel41.setText("Phone");
        jPanel7.add(jLabel41);
        jLabel41.setBounds(690, 470, 120, 50);

        txtPhone3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhone3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtPhone3);
        txtPhone3.setBounds(860, 475, 370, 40);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 153, 255));
        jLabel42.setText("Birth Date");
        jPanel7.add(jLabel42);
        jLabel42.setBounds(690, 400, 160, 40);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 255));
        jLabel43.setText("NIC");
        jPanel7.add(jLabel43);
        jLabel43.setBounds(690, 330, 120, 50);

        txtNic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNic3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtNic3);
        txtNic3.setBounds(860, 340, 370, 40);

        txtSecond3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSecond3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecond3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtSecond3);
        txtSecond3.setBounds(860, 270, 370, 40);

        txtGender3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGender3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGender3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtGender3);
        txtGender3.setBounds(240, 410, 370, 40);

        txtBirthdate3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBirthdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdate3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtBirthdate3);
        txtBirthdate3.setBounds(860, 410, 370, 40);

        txtMarried3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtMarried3);
        txtMarried3.setBounds(240, 550, 370, 40);

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 153, 255));
        jLabel91.setText("-------------------------------------------------------------Ward Details---------------------------------------------------------------");
        jPanel7.add(jLabel91);
        jLabel91.setBounds(140, 690, 1270, 50);

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 153, 255));
        jLabel92.setText("Assigned Ward");
        jPanel7.add(jLabel92);
        jLabel92.setBounds(70, 780, 160, 50);

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 153, 255));
        jLabel93.setText("Ward Type");
        jPanel7.add(jLabel93);
        jLabel93.setBounds(70, 860, 160, 50);

        txtWard3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWard3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtWard3);
        txtWard3.setBounds(250, 780, 370, 40);

        txtWardType3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWardType3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWardType3ActionPerformed(evt);
            }
        });
        jPanel7.add(txtWardType3);
        txtWardType3.setBounds(250, 860, 370, 40);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Delete Doctor", jPanel3);

        jPanel9.setLayout(null);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jPanel9.add(jLabel30);
        jLabel30.setBounds(1280, 50, 60, 60);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel31);
        jLabel31.setBounds(1340, 50, 60, 60);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/doc circle icon.png"))); // NOI18N
        jPanel9.add(jLabel33);
        jLabel33.setBounds(0, 20, 110, 110);

        jLabel49.setBackground(new java.awt.Color(0, 204, 204));
        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("View Doctors");
        jPanel9.add(jLabel49);
        jLabel49.setBounds(120, 40, 310, 80);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel9.add(jLabel51);
        jLabel51.setBounds(60, 40, 1380, 80);

        tbldoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Second Name", "Speciality", "NIC", "Age", "Gender", "Address", "BirthDate", "Married Status", "Phone", "Assigned Ward", "Room No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbldoctor);
        if (tbldoctor.getColumnModel().getColumnCount() > 0) {
            tbldoctor.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel9.add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 1420, 560);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("View Doctor", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1411, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone1ActionPerformed

    }//GEN-LAST:event_txtPhone1ActionPerformed

    private void txtSecond1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecond1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecond1ActionPerformed

    private void txtFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirst1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirst1ActionPerformed

    private void txtNic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNic1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNic1ActionPerformed

    private void txtspeciality1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtspeciality1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspeciality1ActionPerformed

    private void txtAge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge1ActionPerformed

    private void txtAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress1ActionPerformed

    private void txtroom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroom1ActionPerformed

    private void lblAdminHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminHomeMouseClicked
        HMS_AdminPanel p = new HMS_AdminPanel();
        p.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_lblAdminHomeMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        HMS_Login lg = new HMS_Login();
        lg.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked

        this.dispose();

    }//GEN-LAST:event_jLabel31MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        HMS_DoctorDetails_1 doc = new HMS_DoctorDetails_1();

        String dno = lbldocno1.getText();
        String firstname = txtFirst1.getText();
        String secondname = txtSecond1.getText();
        String nic = txtNic1.getText();
        String gender = comboGender1.getSelectedItem().toString();
        String age = txtAge1.getText();
        String speciality = txtspeciality1.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = dateFormat.format(txtbirthdate1.getDate());
        String room = txtroom1.getText();
        String mstatus = comboReleationship1.getSelectedItem().toString();
        String phone = txtPhone1.getText();
        String address = txtAddress1.getText();

        String ward = txtWard1.getText();
        String wardtype = txtWardType4.getText();
        // String wardname = txtWardName1.getText();

        HMS_Doctor_1 id1;
        id1 = new HMS_Doctor_1(dno, firstname, secondname, nic, gender, age, birthday, mstatus, phone, address, speciality, ward, room);

        WardDAO id2;
        id2 = new WardDAO(ward, wardtype);

        doc.addDoctor(id1, id2);
        JOptionPane.showMessageDialog(this, "Record Inserted");

        AutoID();
        doctor_table();
        doc.clear1(this);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

       HMS_DoctorDetails_1 doc = new HMS_DoctorDetails_1();

        String dno = txtdocno2.getText();
        String firstname = txtFirst2.getText();
        String secondname = txtSecond2.getText();
        String nic = txtNic2.getText();
        String gender = comboGender2.getSelectedItem().toString();
        String age = txtAge2.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = dateFormat.format(txtBirthday2.getDate());
        String mstatus = comboReleationship2.getSelectedItem().toString();
        String speciality = txtspeciality2.getText();
        String address = txtAddress2.getText();
        String ward = txtWard2.getText();
        String room = txtroom2.getText();
        String phone = txtPhone2.getText();
        String wardtype = txtWardType5.getText();

       
            
        HMS_Doctor_1 id1=new HMS_Doctor_1(dno, firstname, secondname, nic, gender, age, birthday, mstatus, phone, address, speciality, ward, room);
        
         doc.updateRecord(id1);
         JOptionPane.showMessageDialog(this, "Record Updated");
         doc.clear2(this);
         doctor_table();

       


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed

        String id = txtdocno2.getText();

        HMS_DoctorDetails_1 doc = new HMS_DoctorDetails_1();

        HMS_Doctor_1 doctor = doc.find1(id);
        WardDAO ward = doc.find2(id);

        txtFirst2.setText(doctor.getFirstname());
        txtSecond2.setText(doctor.getSecondname());
        txtNic2.setText(doctor.getNic());

        if (doctor.getGender().equals("Male")) {
            comboGender2.setSelectedIndex(0);
        } else  {
            comboGender2.setSelectedIndex(1);
        }

        if (comboReleationship2.equals("Single")) {
           comboReleationship2.setSelectedIndex(0);
        } else  {
            comboReleationship2.setSelectedIndex(1);
        }

        txtAge2.setText(doctor.getAge());

        String bdate = doctor.getBirthday();
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "InValid Doctor Number!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        txtBirthday2.setDate(date);

        txtspeciality2.setText(doctor.getSpeciality());
        txtAddress2.setText(doctor.getAddress());
        txtWard2.setText(doctor.getAssignedward());
        txtroom2.setText(doctor.getRoom());
        txtPhone2.setText(doctor.getPhone());
        txtWard2.setText(ward.getWardno());
        txtWardType5.setText(ward.getWardtype());


    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void txtdocno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocno2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void txtFirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirst2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirst2ActionPerformed

    private void txtAge2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge2ActionPerformed

    private void txtroom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroom2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroom2ActionPerformed

    private void txtWard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWard2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWard2ActionPerformed

    private void txtAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress2ActionPerformed

    private void txtPhone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhone2ActionPerformed

    private void txtNic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNic2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNic2ActionPerformed

    private void txtSecond2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecond2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecond2ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed

        String id = txtdocno3.getText();
        try {
            HMS_DoctorDetails_1 doc = new HMS_DoctorDetails_1();
            HMS_Doctor_1 doctor = doc.find1(id);
            WardDAO ward = doc.find2(id);

            txtFirst3.setText(doctor.getFirstname());
            txtSecond3.setText(doctor.getSecondname());
            txtNic3.setText(doctor.getNic());
            txtGender3.setText(doctor.getGender());
            txtAge3.setText(doctor.getAge());
            txtBirthdate3.setText(doctor.getBirthday());
            txtMarried3.setText(doctor.getMstatus());
            txtspeciality3.setText(doctor.getSpeciality());
            txtAddress3.setText(doctor.getAddress());

            txtroom3.setText(doctor.getRoom());
            txtPhone3.setText(doctor.getPhone());

            txtWard3.setText(ward.getWardno());
            txtWardType3.setText(ward.getWardtype());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "----------InValid Doctor Number!!!", "Warning!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void txtdocno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocno3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocno3ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void txtFirst3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirst3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirst3ActionPerformed

    private void txtspeciality3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtspeciality3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspeciality3ActionPerformed

    private void txtAge3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge3ActionPerformed

    private void txtroom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroom3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroom3ActionPerformed

    private void txtAddress3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress3ActionPerformed

    private void txtPhone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhone3ActionPerformed

    private void txtNic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNic3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNic3ActionPerformed

    private void txtSecond3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecond3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecond3ActionPerformed

    private void txtspeciality2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtspeciality2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspeciality2ActionPerformed

    private void txtGender3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGender3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGender3ActionPerformed

    private void txtBirthdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdate3ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        
        String dno = txtdocno3.getText();

        HMS_DoctorDetails_1 id = new HMS_DoctorDetails_1();
          id.delete(dno);

            JOptionPane.showMessageDialog(this, "Record Deleted");
            id.clear3(this);
            doctor_table();

       

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtWard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWard3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWard3ActionPerformed

    private void txtWardType3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWardType3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWardType3ActionPerformed

    private void txtWardType5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWardType5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWardType5ActionPerformed

    private void txtNic1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNic1KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtNic1.getText();
        Validations1 val = new Validations1();
        val.key1(c1, c2, text, this);
    }//GEN-LAST:event_txtNic1KeyPressed

    private void txtbirthdate1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbirthdate1MousePressed
        SimpleDateFormat dcn = new SimpleDateFormat("yyyyMMdd");
        String date = dcn.format(txtbirthdate1.getDate());
        lbldate.setText(date);
    }//GEN-LAST:event_txtbirthdate1MousePressed

    private void txtPhone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhone1KeyPressed
       char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtPhone1.getText();
        Validations1 val = new Validations1();
        val.phone1(c1, c2, text, this);
    }//GEN-LAST:event_txtPhone1KeyPressed

    private void txtAge1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAge1KeyPressed
       char c = evt.getKeyChar();
        Validations1 val = new Validations1();
        val.age1(c,this);
    }//GEN-LAST:event_txtAge1KeyPressed

    private void txtroom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtroom1KeyPressed
        char c = evt.getKeyChar();
        Validations1 val = new Validations1();
        val.room1(c,this);
    }//GEN-LAST:event_txtroom1KeyPressed

    private void txtWard1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWard1KeyPressed
          char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtWard1.getText();
        Validations1 val = new Validations1();
        val.ward1(c1, c2, text, this);
    }//GEN-LAST:event_txtWard1KeyPressed

    private void txtAge2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAge2KeyPressed
        char c = evt.getKeyChar();
        Validations1 val = new Validations1();
        val.age2(c,this);
    }//GEN-LAST:event_txtAge2KeyPressed

    private void txtNic2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNic2KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtNic2.getText();
        Validations1 val = new Validations1();
        val.key2(c1, c2, text, this);
        
        
        
    }//GEN-LAST:event_txtNic2KeyPressed

    private void txtroom2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtroom2KeyPressed
       char c = evt.getKeyChar();
        Validations1 val = new Validations1();
        val.room2(c,this);
    }//GEN-LAST:event_txtroom2KeyPressed

    private void txtWard2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWard2KeyPressed
    char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtWard2.getText();
        Validations1 val = new Validations1();
        val.ward2(c1, c2, text, this);
    }//GEN-LAST:event_txtWard2KeyPressed

    private void txtPhone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhone2KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtPhone2.getText();
        Validations1 val = new Validations1();
        val.phone2(c1, c2, text, this);
    }//GEN-LAST:event_txtPhone2KeyPressed

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
            java.util.logging.Logger.getLogger(HMS_DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_DoctorGUI_1().setVisible(true);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAdminHome;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldocno1;
    private javax.swing.JTable tbldoctor;
    public javax.swing.JTextField txtAddress1;
    public javax.swing.JTextField txtAddress2;
    public javax.swing.JTextField txtAddress3;
    public javax.swing.JTextField txtAge1;
    public javax.swing.JTextField txtAge2;
    public javax.swing.JTextField txtAge3;
    public javax.swing.JTextField txtBirthdate3;
    public com.toedter.calendar.JDateChooser txtBirthday2;
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
    public javax.swing.JTextField txtWard1;
    public javax.swing.JTextField txtWard2;
    public javax.swing.JTextField txtWard3;
    private javax.swing.JPanel txtWardNo;
    public javax.swing.JTextField txtWardType3;
    public javax.swing.JTextField txtWardType4;
    public javax.swing.JTextField txtWardType5;
    public com.toedter.calendar.JDateChooser txtbirthdate1;
    public javax.swing.JTextField txtdocno2;
    public javax.swing.JTextField txtdocno3;
    public javax.swing.JTextField txtroom1;
    public javax.swing.JTextField txtroom2;
    public javax.swing.JTextField txtroom3;
    public javax.swing.JTextField txtspeciality1;
    public javax.swing.JTextField txtspeciality2;
    public javax.swing.JTextField txtspeciality3;
    // End of variables declaration//GEN-END:variables
}
