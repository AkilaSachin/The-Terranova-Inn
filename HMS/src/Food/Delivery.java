/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Food;

import database.DBconnect;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Piyumi Hansamali
 */
public class Delivery extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form Delivery
     */
    public Delivery() {
        initComponents();
        jDateChooser1.setMinSelectableDate(new Date());
        
        getContentPane().setBackground(new Color(90,120,183));
        con=DBconnect.connect();
  
        this.setSize(1060,768);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //load table
        tableload();
    }
    
    public void delivery_info(){
       try{
            jTextField6.setVisible(true);
            jButton3.setVisible(true);
            jButton5.setVisible(true);
            
            
            jPanel1.setVisible(true);
            String sql="select roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery from delivery";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    public void otherreqfoodlist_tableloard()
    {
        try{
            String sql="SELECT roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery from otherreqlist";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            System.out.println("Error in getting data from db");
            System.out.println(e.getMessage());
        }
    
    }
    
    public void tableload()
    {
        try{
            String sql="SELECT roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery from delivery";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            System.out.println("Error in getting data from db");
            System.out.println(e.getMessage());
        }
    }
    
    public void Reset()
    {
      
      jTextField3.setText("");
      jLabel13.setText("");
      jTextField9.setText("");
      jLabel15.setText("");
      jDateChooser1.setDate(null);
      jTextField1.setText("");
      jTextField4.setText("");
      jTextField7.setText("");
      jTextField5.setText("");
      jTextArea1.setText("");
      jComboBox1.setSelectedItem(0);
      jTextField6.setText("");
      jLabel10.setText("");
      
      
      
        
    }
     public void check(){
         
            if(jTextField3.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Enter room No");
                return;
            }

            if (jLabel10.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter customer ID");
                return;
            }
            if (jTextField9.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter Item Name");
                return;
            }
            if (jLabel15.getText().equals("")) {
                JOptionPane.showMessageDialog(this,"Enter Item No");
                return;
            }
            if (jDateChooser1.getDate().equals("")) {
                JOptionPane.showMessageDialog(this,"Enter req Date");
                return;
            }
            if (jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter req Time");
                return;
            }

            if (jTextField4.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter quentity");
                return;
            }
            if (jTextField7.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter unit price");
                return;
            }

            if (jTextField5.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter total price");
                return;
            }
            if (jTextArea1.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter discription");
                return;
            }
            if (jComboBox1.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog( this, "Enter delivery status");
                return;
            }
            
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(85, 86, 149));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1060, 768));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(90, 120, 183));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cost");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discription");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Unit Price");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Customer ID");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Room No");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Request Date");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Reuest Time");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Delivery");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Done", "Waiting" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item No");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 182, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField1)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 30, 350, 530);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Other Request Item");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(510, 0, 320, 42);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(434, 67, 0, 162);

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Search By name");

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(68, 145, 162));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Quantity", "Room No"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(68, 145, 162));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 145, 162));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(68, 145, 162));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jButton6.setBackground(new java.awt.Color(68, 145, 162));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add To List");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(68, 145, 162));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Remove");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(68, 145, 162));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Refresh");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(400, 60, 570, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try{
           check();
          
            String roomNo=jTextField3.getText();
            String customerID=jLabel10.getText();
            String ItemName=jTextField9.getText();
            String ItemNo=jLabel15.getText();
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date req_Date;
            req_Date=jDateChooser1.getDate();
            String reqDate=df.format(req_Date);
            
            String reqTime=jTextField1.getText();
            String qty=jTextField4.getText();
            String unitprice=jTextField7.getText();
            String cost=jTextField5.getText();
            String description=jTextArea1.getText();
            String deli=jComboBox1.getSelectedItem().toString();
            
            String sql="Select roomNo,itemNo from delivery where roomNo='"+roomNo+"' and itemNo='"+ItemNo+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog( this, "FoodID already exists","Error", JOptionPane.ERROR_MESSAGE);
                jTextField6.setText("");
                jTextField1.setText("");
            }
            else{
            
            String q="INSERT INTO delivery(roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery) values(?,?,?,?,?,?,?,?,?,?,?)";
            pst=con.prepareStatement(q);
            pst.setString(1, roomNo);
            pst.setString(2, customerID);
            pst.setString(3, ItemName);
            pst.setString(4, ItemNo);
            pst.setString(5, reqDate);
            pst.setString(6, reqTime);
            pst.setString(7, qty);
            pst.setString(8, unitprice);
            pst.setString(9, cost );
            pst.setString(10, description);
            pst.setString(11, deli);
            pst.execute();
            
            JOptionPane.showMessageDialog(this,"Successfully Inserted");

            //load table
            tableload();
            Reset();
        }
        }
        catch(Exception e)
        {
            System.out.println("Error in inserting");
            System.out.println(e.getMessage());
        }                                                                          

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int r=jTable1.getSelectedRow();
        String roomNo=jTable1.getValueAt(r, 0).toString();
        String customerID=jTable1.getValueAt(r, 1).toString();
        String ItemName=jTable1.getValueAt(r, 2).toString();
        String ItemNo=jTable1.getValueAt(r, 3).toString();
        String req_Date=jTable1.getValueAt(r, 4).toString();
        String reqTime=jTable1.getValueAt(r, 5).toString();
        String qty=jTable1.getValueAt(r, 6).toString();
        String unitprice=jTable1.getValueAt(r, 7).toString();
        String cost=jTable1.getValueAt(r, 8).toString();
        String description=jTable1.getValueAt(r, 9).toString();
        String deli=jTable1.getValueAt(r, 10).toString();

        jTextField3.setText(roomNo);
        jLabel10.setText(customerID);
        jTextField9.setText(ItemName);
        jLabel15.setText(ItemNo);
        
        try {
            DateFormat f1=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date d;
            d = f1.parse(req_Date);
            jDateChooser1.setDate(d);  
        } catch (ParseException ex) {
            Logger.getLogger(RequestFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTextField1.setText(reqTime);
        jTextField4.setText(qty);
        jTextField7.setText(unitprice);
        jTextField5.setText(cost);
        jTextArea1.setText(description);
        jComboBox1.setSelectedItem(deli);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String roomNo=jTextField6.getText();
        
        String sql="SELECT *from delivery where roomNo = '"+ roomNo +"'";
        
        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));                                        
        }
        catch(Exception e)
        {
            System.out.println("Error in searching");
            System.out.println(e.getMessage());
        }
        Reset();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int y=JOptionPane.showConfirmDialog(null, "Do you want to delete ?");

        if(y==0)
        {
            String ItemNo=jLabel15.getText();
            String roomNo=jTextField3.getText();
            String sql="delete from delivery where itemNo='"+ItemNo+"' and roomNo='"+roomNo+"' ";

            try{
                pst=con.prepareStatement(sql);          
                pst.execute();
                JOptionPane.showMessageDialog(this,"Successfully deleted");

                //load table
                tableload();
                Reset();

            }
            catch(Exception e)
            {
                System.out.println("Error in deleting");
                System.out.println(e.getMessage());

            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int x=JOptionPane.showConfirmDialog(null,"Do you want to update ?");
        if(x==0)
        {

            String roomNo=jTextField3.getText();
            String customerID=jLabel10.getText();
            String ItemName=jTextField9.getText();           
            String ItemNo=jLabel15.getText();
            Date reqDate=jDateChooser1.getDate();
            String reqTime=jTextField1.getText();
            String qty=jTextField4.getText();
            String unitprice=jTextField7.getText();
            String cost=jTextField5.getText();
            String Discription=jTextArea1.getText();
           String deli=jComboBox1.getSelectedItem().toString();
            

            try{
                check();
            
            String sql="UPDATE delivery SET roomNo='"+roomNo+"',customerID='"+customerID +"' , itemName='"+ ItemName+"',reqDate='"+reqDate+"',reqTime='"+reqTime+"',qty='"+qty+"',unitprice='"+unitprice+"',cost='"+cost+"',description='"+Discription+"',delivery='"+deli+"' where itemNo='"+ItemNo+"' ";

            
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this,"Successfully updated");

                //load table
                tableload();
                Reset();

            }
            catch(Exception e)
            {
                System.out.println("error in updating");
                System.out.println(e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
       if("".equals(jTextField7.getText()) || "".equals(jTextField4.getText())){
           jTextField5.setText(null);
        }
        else{
       try
            {
               double a=Double.parseDouble(jTextField4.getText());
        
              double b=Double.parseDouble(jTextField7.getText());
               double amount=0;
               amount=a*b;
        jTextField5.setText(String.valueOf(amount));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
       if("".equals(jTextField7.getText()) || "".equals(jTextField4.getText())){
           jTextField5.setText(null);
        }
        else{
       try
            {
               double a=Double.parseDouble(jTextField4.getText());
        
              double b=Double.parseDouble(jTextField7.getText());
               double amount=0;
               amount=a*b;
        jTextField5.setText(String.valueOf(amount));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        String roomn=jTextField3.getText();
        
        try {
            String que="select * from reservation where roomid=?";
            pst=con.prepareStatement(que);
            pst.setString(1,roomn);
            rs=pst.executeQuery();
            if(rs.next()){
                jLabel10.setText(rs.getString("customerID"));
            }
            else
            {
                jLabel10.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        String ItemName=jTextField9.getText();
        
        try {
            String que="select * from stock_maintaince where productName=?";
            pst=con.prepareStatement(que);
            pst.setString(1,ItemName);
            rs=pst.executeQuery();
            if(rs.next()){
                jLabel15.setText(rs.getString("productID"));
            }
            else
            {
                jLabel15.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
            String que="select * from stock_maintaince where productName=?";
            pst=con.prepareStatement(que);
            pst.setString(1,ItemName);
            rs=pst.executeQuery();
            if(rs.next()){
                jTextField7.setText(rs.getString("unitprice"));
            }
            else
            {
                jTextField7.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);   
        }
        
        
    
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       delivery_info();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         try{
           check();
          
            String roomNo=jTextField3.getText();
            String customerID=jLabel10.getText();
            String ItemName=jTextField9.getText();
            String ItemNo=jLabel15.getText();
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date req_Date;
            req_Date=jDateChooser1.getDate();
            String reqDate=df.format(req_Date);
            
            String reqTime=jTextField1.getText();
            String qty=jTextField4.getText();
            String unitprice=jTextField7.getText();
            String cost=jTextField5.getText();
            String description=jTextArea1.getText();
            String deli=jComboBox1.getSelectedItem().toString();
            
            String sql="Select roomNo,itemNo from otherreqlist where roomNo='"+roomNo+"' and itemNo='"+ItemNo+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog( this, "FoodID already exists","Error", JOptionPane.ERROR_MESSAGE);
                jTextField6.setText("");
                jTextField1.setText("");
            }
            else{

            
            String q="INSERT INTO otherreqlist(roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery) values(?,?,?,?,?,?,?,?,?,?,?)";
            pst=con.prepareStatement(q);
            pst.setString(1, roomNo);
            pst.setString(2, customerID);
            pst.setString(3, ItemName);
            pst.setString(4, ItemNo);
            pst.setString(5, reqDate);
            pst.setString(6, reqTime);
            pst.setString(7, qty);
            pst.setString(8, unitprice);
            pst.setString(9, cost );
            pst.setString(10, description);
            pst.setString(11, deli);
            pst.execute();
            
            JOptionPane.showMessageDialog(this,"Successfully Inserted");

            //load table
            otherreqfoodlist_tableloard();
           
      jTextField9.setText("");
      jLabel15.setText("");
      jTextField4.setText("");
      jTextField7.setText("");
      jTextField5.setText("");
      jTextArea1.setText("");
        }
         }
        catch(Exception e)
        {
            System.out.println("Error in inserting");
            System.out.println(e.getMessage());
        }                                                                          

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int y=JOptionPane.showConfirmDialog(null, "Do you want to delete ?");

        if(y==0)
        {
            String ItemName=jTextField9.getText();
            String sql="delete from otherreqlist where itemName='"+ItemName+"'";

            try{
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this,"Successfully deleted");

               
                otherreqfoodlist_tableloard();
                Reset();

            }
            catch(Exception e)
            {
                System.out.println("Error in deleting");
                System.out.println(e.getMessage());

            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        
         // String it160_g = "insert into delivery select * from otherreqlist ";
            String it160_g = "insert into delivery (ID,roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery) select ID,roomNo,customerID,itemName,itemNo,reqDate,reqTime,qty,unitprice,cost,description,delivery from otherreqlist  ";
        try {
            pst =con.prepareStatement(it160_g);
            pst.execute();
            tableload();

            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        
          String it16 = "delete from otherreqlist ";
        try {
            pst =con.prepareStatement(it16);
            pst.execute();
            tableload();

            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       
       otherreqfoodlist_tableloard();
       Reset();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int r=jTable2.getSelectedRow();
        String roomNo=jTable2.getValueAt(r, 0).toString();
        String customerID=jTable2.getValueAt(r, 1).toString();
        String ItemName=jTable2.getValueAt(r, 2).toString();
        String ItemNo=jTable2.getValueAt(r, 3).toString();
        String req_Date=jTable2.getValueAt(r, 4).toString();
        String reqTime=jTable2.getValueAt(r, 5).toString();
        String qty=jTable2.getValueAt(r, 6).toString();
        String unitprice=jTable2.getValueAt(r, 7).toString();
        String cost=jTable2.getValueAt(r, 8).toString();
        String description=jTable2.getValueAt(r, 9).toString();
        String deli=jTable2.getValueAt(r, 10).toString();

        jTextField3.setText(roomNo);
        jLabel10.setText(customerID);
        jTextField9.setText(ItemName);
        jLabel15.setText(ItemNo);
        
        try {
            DateFormat f1=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date d;
            d = f1.parse(req_Date);
            jDateChooser1.setDate(d);  
        } catch (ParseException ex) {
            Logger.getLogger(RequestFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTextField1.setText(reqTime);
        jTextField4.setText(qty);
        jTextField7.setText(unitprice);
        jTextField5.setText(cost);
        jTextArea1.setText(description);
        jComboBox1.setSelectedItem(deli);
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
