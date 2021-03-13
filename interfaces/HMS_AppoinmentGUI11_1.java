package interfaces;

import Details.HMS_AppoinmentDetails;
import GetSet.HMS_Appoinment;
import GetSet.HMS_Doctor_1;
import Validations.Validations_Appoinment;
import com.sun.glass.events.KeyEvent;

import connection.HMS_DBConnManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HMS_AppoinmentGUI11_1 extends javax.swing.JFrame {

    private Vector<Vector<String>> data;
    private Vector<String> heading;
    HMS_AppoinmentDetails d = new HMS_AppoinmentDetails();

    public HMS_AppoinmentGUI11_1() {
        initComponents();
        heading = new Vector<String>();
        heading.add("Appoinment Number");
        heading.add("Doctor ID");
        heading.add("Doctor Name");
        heading.add("Date");
        heading.add("Time");
        heading.add("Patient Name");
        heading.add("Age");
        heading.add("Phone Number");
        heading.add("Description");
        loadTable();
      
        loadSpeciality();
        AutoID();
        d.setDisable(this);

    }

    ResultSet rs;
    HMS_DBConnManager dbConnManager = new HMS_DBConnManager();
    PreparedStatement pst;

       
    
    

    public void AutoID() {
        Connection dbConn = null;
        try {

            dbConn = dbConnManager.connect();
            Statement s = dbConn.createStatement();
            rs = s.executeQuery("select MAX(appoinmentno) from appoinment");
            rs.next();
            rs.getString("MAX(appoinmentno)");

            if (rs.getString("MAX(appoinmentno)") == null) {
                lblId.setText("APP001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(appoinmentno)").substring(3, rs.getString("MAX(appoinmentno)").length()));
                id++;
                lblId.setText("APP" + String.format("%03d", id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HMS_AppoinmentGUI11_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadTable() {
        HMS_AppoinmentDetails app = new HMS_AppoinmentDetails();
        data = app.getAppoinmentDetails();

        tbldetails1.setModel(new javax.swing.table.DefaultTableModel(data, heading));

    }

    public void loadSpeciality() {
        try {
            Connection dbConn = null;

            dbConn = dbConnManager.connect();
            pst = dbConn.prepareStatement("select distinct speciality from doctor");
            rs = pst.executeQuery();
            comboSpeciality.removeAll();
            cmb6.removeAll();
            while (rs.next()) {
                comboSpeciality.addItem(rs.getString("speciality"));
                cmb6.addItem(rs.getString("speciality"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Specialist loading Error" + ex);
            //Logger.getLogger(HMS_AppoinmentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDoctorname() {
        if (comboSpeciality.getSelectedIndex() != -1) {
            String special = comboSpeciality.getSelectedItem().toString();

            try {
                Connection dbConn = null;

                dbConn = dbConnManager.connect();
                pst = dbConn.prepareStatement("SELECT distinct doctor.firstname from doctor WHERE doctor.speciality=?");
                pst.setString(1, special);
                rs = pst.executeQuery();
                cmb1.removeAll();
                cmb7.removeAll();
                while (rs.next()) {

                    cmb1.addItem(rs.getString("firstname"));
                    cmb7.addItem(rs.getString("firstname"));

                }

            } catch (Exception ex) {
                System.out.println("vjk ");
            }

        }
    }

    public void loadDoctornameUpdate() {
        if (cmb6.getSelectedIndex() != -1) {
            String special = cmb6.getSelectedItem().toString();

            try {
                Connection dbConn = null;

                dbConn = dbConnManager.connect();
                pst = dbConn.prepareStatement("SELECT distinct doctor.firstname from doctor WHERE doctor.speciality=?");
                pst.setString(1, special);
                rs = pst.executeQuery();

                cmb7.removeAll();
                while (rs.next()) {

                    cmb7.addItem(rs.getString("firstname"));

                }

            } catch (Exception ex) {
                System.out.println("vjk ");
            }

        }
    }

    public void loadLabels() {
        if (cmb1.getItemCount() != 0) {
            String name = cmb1.getSelectedItem().toString();
            try {
                Connection dbConn = null;

                dbConn = dbConnManager.connect();
                Statement stmt = dbConn.createStatement();
                String query = "select * from doctor where firstname='" + name + "'";
                rs = stmt.executeQuery(query);
                rs.next();
                String roomno = rs.getString("room");
                lblRoom.setText(roomno);

                String docid = rs.getString("doctorId");
                lblDocId.setText(docid);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex + "--------Exception");
            }
        }

    }

    public void loadLabelsUpdate() {
        if (cmb7.getItemCount() != 0) {
            String name = cmb7.getSelectedItem().toString();
            try {
                Connection dbConn = null;

                dbConn = dbConnManager.connect();
                Statement stmt = dbConn.createStatement();
                String query = "select * from doctor where firstname='" + name + "'";
                rs = stmt.executeQuery(query);
                rs.next();
                String roomno = rs.getString("room");
                lblRoom2.setText(roomno);

                String docid = rs.getString("doctorId");
                lblDocId2.setText(docid);

                lblDocName.setText(name);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex + "--------Exception");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmb2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        btnadd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        comboSpeciality = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        lblDocId = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbldetails1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cmb5 = new javax.swing.JComboBox();
        lblDocId2 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtname2 = new javax.swing.JTextField();
        txtage2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtphone2 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdescription2 = new javax.swing.JTextArea();
        jLabel57 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        txtappno2 = new javax.swing.JTextField();
        datechooser2 = new com.toedter.calendar.JDateChooser();
        jLabel59 = new javax.swing.JLabel();
        btnsearch = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cmb7 = new javax.swing.JComboBox();
        lblRoom2 = new javax.swing.JLabel();
        lblDocName = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        cmb6 = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        cmb3 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cmb4 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtname1 = new javax.swing.JTextField();
        txtage1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtphone1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescription1 = new javax.swing.JTextArea();
        btndelete = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtappno1 = new javax.swing.JTextField();
        datechooser1 = new com.toedter.calendar.JDateChooser();
        jLabel44 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Select Time");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(60, 360, 200, 40);

        cmb2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb2.setForeground(new java.awt.Color(0, 153, 255));
        cmb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Time", "10:00 - 11:00", "11:00-1200", "13:00-14:00", "14:00-15:00", "15:00-16:00" }));
        cmb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb2ActionPerformed(evt);
            }
        });
        jPanel4.add(cmb2);
        cmb2.setBounds(300, 360, 390, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Room No");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(740, 290, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Select Date");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(60, 290, 200, 40);

        cmb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb1.setForeground(new java.awt.Color(0, 153, 255));
        cmb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Doctor" }));
        cmb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb1ItemStateChanged(evt);
            }
        });
        jPanel4.add(cmb1);
        cmb1.setBounds(920, 230, 390, 40);

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Appointments");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(120, 40, 330, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/appointment circel icon.png"))); // NOI18N
        jPanel4.add(jLabel5);
        jLabel5.setBounds(10, 20, 110, 110);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel14);
        jLabel14.setBounds(1280, 50, 60, 60);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel15);
        jLabel15.setBounds(1340, 50, 60, 60);

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

        txtname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel5.add(txtname);
        txtname.setBounds(190, 40, 370, 35);

        txtage.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtageActionPerformed(evt);
            }
        });
        txtage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtageKeyPressed(evt);
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
        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphoneKeyPressed(evt);
            }
        });
        jPanel5.add(txtphone);
        txtphone.setBounds(720, 40, 370, 35);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Patient Name");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(30, 30, 150, 50);

        txtdescription.setColumns(20);
        txtdescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtdescription.setRows(5);
        jScrollPane1.setViewportView(txtdescription);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(190, 120, 750, 140);

        btnadd.setBackground(new java.awt.Color(0, 153, 255));
        btnadd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel5.add(btnadd);
        btnadd.setBounds(1060, 220, 250, 60);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Patient Details");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(10, 0, 140, 30);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(40, 440, 1370, 320);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Appointment Number");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(60, 150, 260, 40);

        datechooser.setForeground(new java.awt.Color(0, 153, 255));
        datechooser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        datechooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datechooserKeyPressed(evt);
            }
        });
        jPanel4.add(datechooser);
        datechooser.setBounds(300, 290, 390, 40);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 255));
        jLabel20.setText("Speciality");
        jPanel4.add(jLabel20);
        jLabel20.setBounds(60, 220, 200, 40);

        lblId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(lblId);
        lblId.setBounds(300, 150, 380, 40);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 255));
        jLabel21.setText("Select Doctor");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(740, 230, 200, 40);

        comboSpeciality.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        comboSpeciality.setForeground(new java.awt.Color(0, 153, 255));
        comboSpeciality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Speciality" }));
        comboSpeciality.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSpecialityItemStateChanged(evt);
            }
        });
        jPanel4.add(comboSpeciality);
        comboSpeciality.setBounds(300, 220, 390, 50);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 255));
        jLabel22.setText("Doctor ID");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(740, 360, 120, 40);

        lblDocId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDocId.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(lblDocId);
        lblDocId.setBounds(920, 360, 260, 40);

        lblRoom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRoom.setForeground(new java.awt.Color(0, 153, 255));
        jPanel4.add(lblRoom);
        lblRoom.setBounds(920, 290, 260, 40);

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
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
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

        jPanel2.setPreferredSize(new java.awt.Dimension(1440, 879));

        jPanel6.setLayout(null);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel18);
        jLabel18.setBounds(1280, 50, 60, 60);

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
        jLabel13.setBounds(110, 40, 460, 80);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel6.add(jLabel17);
        jLabel17.setBounds(60, 40, 1380, 80);

        tbldetails1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldetails1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldetails1MouseClicked(evt);
            }
        });
        tbldetails1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbldetails1KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbldetails1);
        if (tbldetails1.getColumnModel().getColumnCount() > 0) {
            tbldetails1.getColumnModel().getColumn(0).setResizable(false);
            tbldetails1.getColumnModel().getColumn(1).setResizable(false);
            tbldetails1.getColumnModel().getColumn(2).setResizable(false);
            tbldetails1.getColumnModel().getColumn(3).setResizable(false);
            tbldetails1.getColumnModel().getColumn(4).setResizable(false);
            tbldetails1.getColumnModel().getColumn(5).setResizable(false);
            tbldetails1.getColumnModel().getColumn(6).setResizable(false);
            tbldetails1.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel6.add(jScrollPane3);
        jScrollPane3.setBounds(70, 160, 1300, 460);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel8);
        jPanel8.setBounds(250, -40, 100, 100);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel10);
        jPanel10.setBounds(510, 10, 100, 100);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addGap(115, 115, 115))
        );

        jTabbedPane1.addTab("View Appointments", jPanel2);

        jPanel18.setLayout(null);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel46);
        jLabel46.setBounds(1370, 50, 60, 60);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel47);
        jLabel47.setBounds(1310, 50, 60, 60);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 153, 255));
        jLabel45.setText("Select Time");
        jPanel18.add(jLabel45);
        jLabel45.setBounds(60, 380, 200, 40);

        cmb5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb5.setForeground(new java.awt.Color(0, 153, 255));
        cmb5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10:00 - 11:00", "11:00-12:00", "13:00-14:00", "14:00-15:00", "15:00-16:00" }));
        jPanel18.add(cmb5);
        cmb5.setBounds(280, 390, 390, 50);

        lblDocId2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDocId2.setForeground(new java.awt.Color(0, 153, 255));
        jPanel18.add(lblDocId2);
        lblDocId2.setBounds(870, 240, 120, 40);

        jLabel48.setBackground(new java.awt.Color(0, 204, 204));
        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Update Appointments");
        jPanel18.add(jLabel48);
        jLabel48.setBounds(120, 40, 430, 80);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/appointment circel icon.png"))); // NOI18N
        jPanel18.add(jLabel49);
        jLabel49.setBounds(10, 20, 110, 110);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel50);
        jLabel50.setBounds(1500, 50, 60, 60);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });
        jPanel18.add(jLabel51);
        jLabel51.setBounds(1560, 50, 60, 60);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel18.add(jLabel52);
        jLabel52.setBounds(90, 40, 1800, 80);

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setLayout(null);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 153, 255));
        jLabel53.setText("Description");
        jPanel19.add(jLabel53);
        jLabel53.setBounds(30, 100, 150, 50);

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 153, 255));
        jLabel54.setText("Age");
        jPanel19.add(jLabel54);
        jLabel54.setBounds(1120, 30, 60, 50);

        txtname2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtname2ActionPerformed(evt);
            }
        });
        jPanel19.add(txtname2);
        txtname2.setBounds(190, 40, 370, 35);

        txtage2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtage2ActionPerformed(evt);
            }
        });
        txtage2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtage2KeyPressed(evt);
            }
        });
        jPanel19.add(txtage2);
        txtage2.setBounds(1220, 40, 110, 35);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 153, 255));
        jLabel55.setText("Phone");
        jPanel19.add(jLabel55);
        jLabel55.setBounds(610, 30, 120, 50);

        txtphone2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtphone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphone2ActionPerformed(evt);
            }
        });
        txtphone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphone2KeyPressed(evt);
            }
        });
        jPanel19.add(txtphone2);
        txtphone2.setBounds(700, 40, 370, 35);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 153, 255));
        jLabel56.setText("Patient Name");
        jPanel19.add(jLabel56);
        jLabel56.setBounds(30, 30, 150, 50);

        txtdescription2.setColumns(20);
        txtdescription2.setRows(5);
        jScrollPane4.setViewportView(txtdescription2);

        jPanel19.add(jScrollPane4);
        jScrollPane4.setBounds(190, 120, 880, 140);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 153, 255));
        jLabel57.setText("Patient Details");
        jPanel19.add(jLabel57);
        jLabel57.setBounds(10, 0, 140, 30);

        btnupdate.setBackground(new java.awt.Color(0, 153, 255));
        btnupdate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel19.add(btnupdate);
        btnupdate.setBounds(1130, 210, 250, 60);

        jPanel18.add(jPanel19);
        jPanel19.setBounds(20, 490, 1440, 300);

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 153, 255));
        jLabel58.setText("Appointment Number");
        jPanel18.add(jLabel58);
        jLabel58.setBounds(40, 160, 260, 40);

        txtappno2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtappno2.setForeground(new java.awt.Color(0, 153, 255));
        jPanel18.add(txtappno2);
        txtappno2.setBounds(290, 160, 380, 40);

        datechooser2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel18.add(datechooser2);
        datechooser2.setBounds(930, 410, 390, 40);

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 153, 255));
        jLabel59.setText("Doctor Name");
        jPanel18.add(jLabel59);
        jLabel59.setBounds(60, 230, 200, 40);

        btnsearch.setBackground(new java.awt.Color(0, 153, 255));
        btnsearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(255, 255, 255));
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel18.add(btnsearch);
        btnsearch.setBounds(720, 150, 220, 50);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 255));
        jLabel23.setText("Speciality");
        jPanel18.add(jLabel23);
        jLabel23.setBounds(60, 300, 200, 40);

        cmb7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb7.setForeground(new java.awt.Color(0, 153, 255));
        cmb7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Doctor" }));
        cmb7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb7ItemStateChanged(evt);
            }
        });
        cmb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb7ActionPerformed(evt);
            }
        });
        jPanel18.add(cmb7);
        cmb7.setBounds(930, 320, 390, 40);

        lblRoom2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRoom2.setForeground(new java.awt.Color(0, 153, 255));
        jPanel18.add(lblRoom2);
        lblRoom2.setBounds(1180, 320, 120, 40);

        lblDocName.setBackground(new java.awt.Color(255, 255, 255));
        lblDocName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDocName.setForeground(new java.awt.Color(0, 153, 255));
        jPanel18.add(lblDocName);
        lblDocName.setBounds(250, 230, 420, 40);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 153, 255));
        jPanel18.add(jLabel62);
        jLabel62.setBounds(750, 240, 120, 40);

        cmb6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb6.setForeground(new java.awt.Color(0, 153, 255));
        cmb6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Speciality" }));
        cmb6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb6ItemStateChanged(evt);
            }
        });
        cmb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb6ActionPerformed(evt);
            }
        });
        jPanel18.add(cmb6);
        cmb6.setBounds(280, 310, 390, 40);

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 153, 255));
        jLabel60.setText("Select Doctor");
        jPanel18.add(jLabel60);
        jLabel60.setBounds(720, 310, 200, 40);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 153, 255));
        jLabel63.setText("Doctor ID");
        jPanel18.add(jLabel63);
        jLabel63.setBounds(720, 240, 120, 40);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 153, 255));
        jLabel61.setText("Select Date");
        jPanel18.add(jLabel61);
        jLabel61.setBounds(720, 400, 200, 40);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Update Appoinment", jPanel11);

        jPanel16.setLayout(null);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 255));
        jLabel30.setText("Select Time");
        jPanel16.add(jLabel30);
        jLabel30.setBounds(70, 380, 200, 40);

        cmb3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb3.setForeground(new java.awt.Color(0, 153, 255));
        cmb3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Time", "10:00 - 11:00", "11:00-1200", "13:00-14:00", "14:00-15:00", "15:00-16:00" }));
        jPanel16.add(cmb3);
        cmb3.setBounds(300, 370, 390, 50);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 255));
        jLabel31.setText("Doctor ID");
        jPanel16.add(jLabel31);
        jLabel31.setBounds(730, 240, 120, 40);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 255));
        jLabel32.setText("Select Date");
        jPanel16.add(jLabel32);
        jLabel32.setBounds(70, 310, 200, 40);

        cmb4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmb4.setForeground(new java.awt.Color(0, 153, 255));
        cmb4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Doctor" }));
        jPanel16.add(cmb4);
        cmb4.setBounds(300, 240, 390, 40);

        jLabel33.setBackground(new java.awt.Color(0, 204, 204));
        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Delete Appointments");
        jPanel16.add(jLabel33);
        jLabel33.setBounds(130, 40, 450, 80);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/appointment circel icon.png"))); // NOI18N
        jPanel16.add(jLabel34);
        jLabel34.setBounds(10, 20, 110, 110);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/home circle icon.png"))); // NOI18N
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel35);
        jLabel35.setBounds(1280, 50, 60, 60);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/logout icon circle.png"))); // NOI18N
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel36);
        jLabel36.setBounds(1340, 50, 60, 60);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hms/images/img2.png"))); // NOI18N
        jPanel16.add(jLabel37);
        jLabel37.setBounds(60, 40, 1380, 80);

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 153, 255));
        jLabel38.setText("Description");
        jPanel17.add(jLabel38);
        jLabel38.setBounds(30, 100, 150, 50);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 153, 255));
        jLabel39.setText("Age");
        jPanel17.add(jLabel39);
        jLabel39.setBounds(1120, 30, 70, 50);

        txtname1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtname1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtname1);
        txtname1.setBounds(190, 40, 370, 35);

        txtage1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtage1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtage1);
        txtage1.setBounds(1180, 40, 110, 35);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 255));
        jLabel40.setText("Phone");
        jPanel17.add(jLabel40);
        jLabel40.setBounds(610, 30, 120, 50);

        txtphone1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtphone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphone1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtphone1);
        txtphone1.setBounds(720, 40, 370, 35);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 255));
        jLabel41.setText("Patient Name");
        jPanel17.add(jLabel41);
        jLabel41.setBounds(30, 30, 150, 50);

        txtdescription1.setColumns(20);
        txtdescription1.setRows(5);
        jScrollPane2.setViewportView(txtdescription1);

        jPanel17.add(jScrollPane2);
        jScrollPane2.setBounds(190, 120, 750, 140);

        btndelete.setBackground(new java.awt.Color(0, 153, 255));
        btndelete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel17.add(btndelete);
        btndelete.setBounds(1060, 220, 250, 60);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 153, 255));
        jLabel42.setText("Patient Details");
        jPanel17.add(jLabel42);
        jLabel42.setBounds(10, 0, 140, 30);

        jPanel16.add(jPanel17);
        jPanel17.setBounds(40, 440, 1370, 320);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 255));
        jLabel43.setText("Appointment Number");
        jPanel16.add(jLabel43);
        jLabel43.setBounds(60, 180, 260, 40);

        txtappno1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtappno1.setForeground(new java.awt.Color(0, 153, 255));
        jPanel16.add(txtappno1);
        txtappno1.setBounds(300, 180, 150, 40);
        jPanel16.add(datechooser1);
        datechooser1.setBounds(300, 310, 390, 40);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 153, 255));
        jLabel44.setText("Select Doctor");
        jPanel16.add(jLabel44);
        jLabel44.setBounds(70, 240, 200, 40);
        jPanel16.add(txtID1);
        txtID1.setBounds(840, 240, 100, 40);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1498, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete Appoinment", jPanel9);

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

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36MouseClicked

    private void txtname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtname1ActionPerformed

    private void txtage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtage1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtage1ActionPerformed

    private void txtphone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphone1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String appno = txtappno1.getText();
        HMS_AppoinmentDetails app = new HMS_AppoinmentDetails();
        app.delete(appno);
         JOptionPane.showMessageDialog(this,"Record Deleted");
        app.clear3(this);
        loadTable();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseClicked

    private void txtname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtname2ActionPerformed

    private void txtage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtage2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtage2ActionPerformed

    private void txtphone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphone2ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String appoinmentno = txtappno2.getText();
        String doctorno = lblDocId2.getText();
        String doctorname = cmb6.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = dateFormat.format(datechooser2.getDate());
        String time = cmb5.getSelectedItem().toString();
        String patientname = txtname2.getText();
        String age = txtage2.getText();
        String phone = txtphone2.getText();
        String description = txtdescription2.getText();

        HMS_Appoinment app = new HMS_Appoinment(appoinmentno, doctorno, doctorname, birthday, time, patientname, age, phone, description);

//         
        if (cmb7.getSelectedIndex() != 0 || cmb5.getSelectedIndex() != 0) {

            HMS_AppoinmentDetails app1 = new HMS_AppoinmentDetails();
            app1.updateRecord(app);
             JOptionPane.showMessageDialog(this,"Record Updated");
            app1.clear2(this);
            loadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all the neccessary requirements", "Warning!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String appno = txtappno2.getText();

        HMS_AppoinmentDetails app = new HMS_AppoinmentDetails();
        HMS_Appoinment appoinment = app.find(appno);

        try {
            lblDocName.setText(appoinment.getDoctorname());
            //cmb7.setSelectedItem(appoinment.getDoctorname());

            if (appoinment.getTime().equals("10:00 - 11:00")) {
                cmb5.setSelectedIndex(0);
            } else if (appoinment.getTime().equals("11:00-12:00")) {
                cmb5.setSelectedIndex(1);
            } else if (appoinment.getTime().equals("13:00-14:00")) {
                cmb5.setSelectedIndex(2);
            } else if (appoinment.getTime().equals("14:00 - 15:00")) {
                cmb5.setSelectedIndex(3);
            } else if (appoinment.getTime().equals("15:00-16:00")) {
                cmb5.setSelectedIndex(4);
            }

            lblDocId2.setText(appoinment.getDoctorno());
            //cmb5.setSelectedItem(appoinment.getTime());
            txtname2.setText(appoinment.getPatientname());
            txtage2.setText(appoinment.getAge());
            txtphone2.setText(appoinment.getPhone());
            txtdescription2.setText(appoinment.getDescription());
//        int x = tbldetails1.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel)tbldetails1.getModel();
//        Date date;
//        date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(x, 3));
//        datechooser2.setDate(date);

            String bdate = appoinment.getDate();
            java.util.Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex + "InValid Doctor Number!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            datechooser2.setDate(date);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "InValid Doctor Number!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnsearchActionPerformed

    private void cmb7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb7ItemStateChanged
        loadLabelsUpdate();
    }//GEN-LAST:event_cmb7ItemStateChanged

    private void cmb6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb6ItemStateChanged
        cmb7.removeAllItems();
        loadDoctornameUpdate();
    }//GEN-LAST:event_cmb6ItemStateChanged

    private void cmb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb6ActionPerformed

    private void txtphone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphone2KeyPressed
       char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtphone2.getText();
        Validations_Appoinment val = new Validations_Appoinment();
        val.phone2(c1, c2, text, this);

    }//GEN-LAST:event_txtphone2KeyPressed

    private void tbldetails1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbldetails1KeyPressed

    }//GEN-LAST:event_tbldetails1KeyPressed

    private void tbldetails1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldetails1MouseClicked

        try {
            boolean a = tbldetails1.isEditing();
            a = false;
            int x = tbldetails1.getSelectedRow();
            String appno = tbldetails1.getValueAt(x, 0).toString();
            String doctorid = tbldetails1.getValueAt(x, 1).toString();
            String doctorname = tbldetails1.getValueAt(x, 2).toString();

            //int x = tbldetails1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tbldetails1.getModel();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(x, 3));
            datechooser1.setDate(date);
            datechooser2.setDate(date);
            String time = tbldetails1.getValueAt(x, 4).toString();
            String patientname = tbldetails1.getValueAt(x, 5).toString();
            String age = tbldetails1.getValueAt(x, 6).toString();
            String phone = tbldetails1.getValueAt(x, 7).toString();
            String description = tbldetails1.getValueAt(x, 8).toString();

            txtappno1.setText(appno);
            txtappno2.setText(appno);
            cmb4.setSelectedItem(doctorname);
            cmb6.setSelectedItem(doctorname);
            txtID1.setText(doctorid);
            lblDocId2.setText(doctorid);
            cmb3.setSelectedItem(time);
            cmb5.setSelectedItem(time);
            txtname1.setText(patientname);
            txtname2.setText(patientname);
            txtphone1.setText(phone);
            txtphone2.setText(phone);
            txtage1.setText(age);
            txtage2.setText(age);
            txtdescription1.setText(description);
            txtdescription2.setText(description);

        } catch (ParseException ex) {
            Logger.getLogger(HMS_AppoinmentGUI11_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tbldetails1MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        HMS_Login l = new HMS_Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        ReceptionistPanel rec = new ReceptionistPanel();
        rec.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void comboSpecialityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSpecialityItemStateChanged
        cmb1.removeAllItems();
        loadDoctorname();
    }//GEN-LAST:event_comboSpecialityItemStateChanged

    private void datechooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datechooserKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_datechooserKeyPressed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String appoinmentno = lblId.getText();
        String doctorno = lblDocId.getText();
        String doctorname = cmb1.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = dateFormat.format(datechooser.getDate());
        String time = cmb2.getSelectedItem().toString();
        String patientname = txtname.getText();
        String age = txtage.getText();
        String phone = txtphone.getText();
        String description = txtdescription.getText();

        HMS_Appoinment app = new HMS_Appoinment(appoinmentno, doctorno, doctorname, birthday, time, patientname, age, phone, description);

        if (cmb1.getSelectedIndex() != 0 || cmb2.getSelectedIndex() != 0) {
            HMS_AppoinmentDetails app1 = new HMS_AppoinmentDetails();
            app1.addAppoinment(app);
            JOptionPane.showMessageDialog(this, "Record Inserted");
            app1.clear1(this);
            loadTable();
            AutoID();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all the neccessary requirements", "Warning!", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Please fill all neccessary requirements");
        }
        //    }else{
        //       JOptionPane.showMessageDialog(null, "Please fill date", "Warning!", JOptionPane.ERROR_MESSAGE);
        //    }
    }//GEN-LAST:event_btnaddActionPerformed

    private void txtphoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtphone.getText();
        Validations_Appoinment val = new Validations_Appoinment();
        val.phone1(c1, c2, text, this);
    }//GEN-LAST:event_txtphoneKeyPressed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtageKeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtage.getText();
        Validations_Appoinment val = new Validations_Appoinment();
        val.age1(c1, c2, text, this);
    }//GEN-LAST:event_txtageKeyPressed

    private void txtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtageActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        ReceptionistPanel r =new ReceptionistPanel();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void cmb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb1ItemStateChanged
        loadLabels();
    }//GEN-LAST:event_cmb1ItemStateChanged

    private void cmb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb2ActionPerformed

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void cmb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb7ActionPerformed

    private void txtage2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtage2KeyPressed
        char c1 = evt.getKeyChar();
        char c2 = (char) evt.getExtendedKeyCode();
        String text = txtage2.getText();
        Validations_Appoinment val = new Validations_Appoinment();
        val.age2(c1, c2, text, this);
    }//GEN-LAST:event_txtage2KeyPressed

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
            java.util.logging.Logger.getLogger(HMS_AppoinmentGUI11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_AppoinmentGUI11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_AppoinmentGUI11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_AppoinmentGUI11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new HMS_AppoinmentGUI11_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    public javax.swing.JComboBox cmb1;
    public javax.swing.JComboBox cmb2;
    public javax.swing.JComboBox cmb3;
    public javax.swing.JComboBox cmb4;
    public javax.swing.JComboBox cmb5;
    public javax.swing.JComboBox cmb6;
    public javax.swing.JComboBox cmb7;
    public javax.swing.JComboBox<String> comboSpeciality;
    public com.toedter.calendar.JDateChooser datechooser;
    public com.toedter.calendar.JDateChooser datechooser1;
    public com.toedter.calendar.JDateChooser datechooser2;
    private javax.swing.ButtonGroup group;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDocId;
    public javax.swing.JLabel lblDocId2;
    private javax.swing.JLabel lblDocName;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblRoom2;
    private javax.swing.JTable tbldetails1;
    public javax.swing.JTextField txtID1;
    public javax.swing.JTextField txtage;
    public javax.swing.JTextField txtage1;
    public javax.swing.JTextField txtage2;
    public javax.swing.JTextField txtappno1;
    public javax.swing.JTextField txtappno2;
    public javax.swing.JTextArea txtdescription;
    public javax.swing.JTextArea txtdescription1;
    public javax.swing.JTextArea txtdescription2;
    public javax.swing.JTextField txtname;
    public javax.swing.JTextField txtname1;
    public javax.swing.JTextField txtname2;
    public javax.swing.JTextField txtphone;
    public javax.swing.JTextField txtphone1;
    public javax.swing.JTextField txtphone2;
    // End of variables declaration//GEN-END:variables
}
