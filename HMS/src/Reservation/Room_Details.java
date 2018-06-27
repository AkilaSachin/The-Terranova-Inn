/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation;

import com.mysql.jdbc.Connection;
import database.DBconnect;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Akila Fernando
 */
public class Room_Details extends javax.swing.JInternalFrame {

    java.sql.Connection con=null;
    PreparedStatement pst=null;
    PreparedStatement pst2=null;
    PreparedStatement pst3=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    /**
     * Creates new form Room_Details
     */
     
    public Room_Details() {
        initComponents();
         con=DBconnect.connect();
        avatable();
        unavatable();
       generatecroomid();
       iniprice();
       revalidate();
       repaint();
      //totalcal();
    }
    
    
   // public double total;
    
    
   /* public void totalcal(){
                     double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }*/
    
    public void avatable(){
                        try
                {
                    String q="select * from room where status='Available' ";
                    pst=con.prepareStatement(q);
                    DefaultTableModel mymodel=(DefaultTableModel) jTable3.getModel();
                    mymodel.setNumRows(0);
                    ResultSet myresult=pst.executeQuery();
                     if(myresult.next())
                    {
                           jScrollPane1.setVisible(true);
                     getContentPane().validate();
                        do
                        {
                        String RID=myresult.getString("roomID");   
                        String Rtype=myresult.getString("type");
                        String Rsize=myresult.getString("number");
                        String Rrate=myresult.getString("price");
                        String it1=myresult.getString("it1");
                        String it2=myresult.getString("it2");
                        String it3=myresult.getString("it3");
                        String it4=myresult.getString("it4");
                        String it5=myresult.getString("it5");
                        String it6=myresult.getString("it6");
                        String it7=myresult.getString("it7");
                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate,it1,it2,it3,it4,it5,it6,it7});
                    }
                        while(myresult.next());
                    }
                  else
                     {
                         jScrollPane1.setVisible(false);
                     getContentPane().validate();
                        JOptionPane.showMessageDialog(rootPane, "No Records ", "Error",JOptionPane.ERROR_MESSAGE); 
                     }       
                       
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    
        public void unavatable(){
                        try
                {
                    String q="select * from room where status='Unavailable' ";
                    pst=con.prepareStatement(q);
                    DefaultTableModel mymodel=(DefaultTableModel) jTable1.getModel();
                    mymodel.setNumRows(0);
                    ResultSet myresult=pst.executeQuery();
                     if(myresult.next())
                    {
                           jScrollPane1.setVisible(true);
                     getContentPane().validate();
                        do
                        {
                        String RID=myresult.getString("roomID");   
                        String Rtype=myresult.getString("type");
                        String Rsize=myresult.getString("number");
                        String Rrate=myresult.getString("price");
                        String it1=myresult.getString("it1");
                        String it2=myresult.getString("it2");
                        String it3=myresult.getString("it3");
                        String it4=myresult.getString("it4");
                        String it5=myresult.getString("it5");
                        String it6=myresult.getString("it6");
                        String it7=myresult.getString("it7");
                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate,it1,it2,it3,it4,it5,it6,it7});
                    }
                        while(myresult.next());
                    }
                  else
                     {
                         jScrollPane1.setVisible(false);
                     getContentPane().validate();
                        JOptionPane.showMessageDialog(rootPane, "No Records ", "Error",JOptionPane.ERROR_MESSAGE); 
                     }       
                       
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    
 void generatecroomid()
{
    try
                {
                    String q="select max(roomID) from room";
                    pst=con.prepareStatement(q);
                    ResultSet myresult=pst.executeQuery();
                
                      if(myresult.next())
                      {
                          int roomid=myresult.getInt(1);
                          if(roomid>0)
                          {
                             jTextField4.setText(String.valueOf(roomid+1));
                          }
                         
                      
                       else
                         {
                             jTextField4.setText("1000");
                         }
                            }
                   
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                         
}

    
    
    public void iniprice(){
            double standard = 2500;
            double premium = 3500;
            double apartment = 6500;
            
            if(jRadioButton3.isSelected()){
                 jTextField2.setText(Double.toString(standard));                
            } else if(jRadioButton4.isSelected()){
                 jTextField2.setText(Double.toString(premium));
            }else if(jRadioButton5.isSelected()){
                 jTextField2.setText(Double.toString(apartment));
            }

    }
    public void totprice(){
        double total;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));

        jPanel2.setBackground(new java.awt.Color(47, 71, 123));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Basic Room Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room Type :");

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Initial Price :");

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Number of Persons :");

        jRadioButton3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Standard");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Premium");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Apartment");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Room ID :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jRadioButton3)
                                .addGap(45, 45, 45)
                                .addComponent(jRadioButton4)
                                .addGap(70, 70, 70)
                                .addComponent(jRadioButton5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                            .addComponent(jLabel2))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4))
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField2)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(47, 71, 123));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Other Facilities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("1. Mini Fridge");

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("2. I Pod / I Phone Docking Station");

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("3. Wide screen 32\" LCD TV");

        jLabel10.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("4. Personal WIFI");

        jLabel11.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("5. Tea and coffee making facilities");

        jLabel12.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("6. Hair Dryer");

        jLabel13.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("7. DVD player");

        jCheckBox4.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("ADD");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("ADD");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("ADD");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("ADD");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setText("ADD");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox9.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("ADD");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jCheckBox10.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jCheckBox10.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setText("ADD");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBox5))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jCheckBox10)))
        );

        jPanel4.setBackground(new java.awt.Color(47, 71, 123));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Totall Price");

        jTextField3.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 102, 102));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(47, 71, 123));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Available Rooms", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setForeground(new java.awt.Color(0, 102, 204));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RID", "R_Type", "Persons", "Price", "1", "2", "3", "4", "5", "6", "7"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMaxWidth(1000);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(47, 71, 123));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Unavailable Rooms", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RID", "R_Type", "Persons", "Price", "1", "2", "3", "4", "5", "6", "7"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(47, 71, 123));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Room Maintains availablity");

        jRadioButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Available ");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Unavailable");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addGap(38, 38, 38)
                .addComponent(jRadioButton2)
                .addGap(34, 34, 34))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(47, 71, 123));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 145, 162));
        jButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(68, 145, 162));
        jButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(68, 145, 162));
        jButton5.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(51, 51, 51)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Room Details");
        jPanel2.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
          double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
                // TODO add your handling code here:
                   double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String roomid = jTextField4.getText();
       String count = jTextField1.getText();
       String price = jTextField3.getText();
       String iniprice = jTextField2.getText();
       
       
       
      if(!roomid.isEmpty() && !count.isEmpty() && !price.isEmpty() && !iniprice.isEmpty() )
      {
         try{
                   String q="insert into room(roomID,type,number,price,it1,it2,it3,it4,it5,it6,it7,status) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                   pst=con.prepareStatement(q);
                   pst.setString(1, jTextField4.getText());
                   if(jRadioButton3.isSelected())
                   {
                        pst.setString(2, "Standard");
                   }
                   else if(jRadioButton4.isSelected())
                   {
                        pst.setString(2, "Premium");
                   }
                   else if(jRadioButton5.isSelected())
                   {
                        pst.setString(2, "Apartment");
                   }
                   pst.setString(3, jTextField1.getText());
                   pst.setString(4, jTextField3.getText());
                  if(jCheckBox4.isSelected()==true){
                         pst.setString(5,"Yes");
                  }else if(jCheckBox4.isSelected()==false){
                         pst.setString(5,"No");
                  }
                  if(jCheckBox5.isSelected()==true){
                         pst.setString(6,"Yes");
                  }else if(jCheckBox5.isSelected()==false){
                         pst.setString(6,"No");
                  }
                  if(jCheckBox6.isSelected()==true){
                         pst.setString(7,"Yes");
                  }else if(jCheckBox6.isSelected()==false){
                         pst.setString(7,"No");
                  }
                  if(jCheckBox7.isSelected()==true){
                         pst.setString(8,"Yes");
                  }else if(jCheckBox7.isSelected()==false){
                         pst.setString(8,"No");
                  }
                  if(jCheckBox8.isSelected()==true){
                         pst.setString(9,"Yes");
                  }else if(jCheckBox8.isSelected()==false){
                         pst.setString(9,"No");
                  } 
                  if(jCheckBox9.isSelected()==true){
                         pst.setString(10,"Yes");
                  }else if(jCheckBox9.isSelected()==false){
                         pst.setString(10,"No");
                  }    
                  if(jCheckBox10.isSelected()==true){
                         pst.setString(11,"Yes");
                  }else if(jCheckBox10.isSelected()==false){
                         pst.setString(11,"No");
                  } 
                  if(jRadioButton1.isSelected())
                   {
                        pst.setString(12, "Available");
                   }
                   else if(jRadioButton2.isSelected())
                   {
                        pst.setString(12, "Unavailable");
                   }
                    pst.executeUpdate();

                           jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        
        jCheckBox4.setSelected(false);
                jCheckBox5.setSelected(false);
                        jCheckBox6.setSelected(false);
                                jCheckBox7.setSelected(false);
                                        jCheckBox8.setSelected(false);
                                                jCheckBox9.setSelected(false);
                                                        jCheckBox10.setSelected(false);
        jTextField1.setText("");
                jTextField2.setText("");
                        jTextField3.setText("");
                        jTextField4.setText("");
                     
                     JOptionPane.showMessageDialog(rootPane, "Room details submitted", "Room details", JOptionPane.INFORMATION_MESSAGE);
                          avatable();
        unavatable();
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                
            } 
                         /*}else{
                    JOptionPane.showMessageDialog(null, "Get initial value", "Warrning !", JOptionPane.INFORMATION_MESSAGE);
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Calculate totall value", "Warrning !", JOptionPane.INFORMATION_MESSAGE);
                }*/
           }else{
               JOptionPane.showMessageDialog(null, "Please Enter All Details", "Warrning !", JOptionPane.WARNING_MESSAGE);
           }
          generatecroomid();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       String roomid = jTextField4.getText();
       String count = jTextField1.getText();
       String price = jTextField3.getText();
       String iniprice = jTextField2.getText();
       
      if(!roomid.isEmpty() && !count.isEmpty() && !price.isEmpty() && !iniprice.isEmpty())
      { 
           
        try{
                    String q="update room set type=?,number=?,price=?,it1=?,it2=?,it3=?,it4=?,it5=?,it6=?,it7=?,status=? where roomID=?";
                    pst=con.prepareStatement(q);
                   if(jRadioButton3.isSelected())
                   {
                        pst.setString(1, "Standard");
                   }
                   else if(jRadioButton4.isSelected())
                   {
                        pst.setString(1, "Premium");
                   }
                   else if(jRadioButton5.isSelected())
                   {
                        pst.setString(1, "Apartment");
                   }
                   pst.setString(2, jTextField1.getText());
                   pst.setString(3, jTextField3.getText());
                  if(jCheckBox4.isSelected()==true){
                         pst.setString(4,"Yes");
                  }else if(jCheckBox4.isSelected()==false){
                         pst.setString(4,"No");
                  }
                  if(jCheckBox5.isSelected()==true){
                         pst.setString(5,"Yes");
                  }else if(jCheckBox5.isSelected()==false){
                         pst.setString(5,"No");
                  }
                  if(jCheckBox6.isSelected()==true){
                         pst.setString(6,"Yes");
                  }else if(jCheckBox6.isSelected()==false){
                         pst.setString(6,"No");
                  }
                  if(jCheckBox7.isSelected()==true){
                         pst.setString(7,"Yes");
                  }else if(jCheckBox7.isSelected()==false){
                         pst.setString(7,"No");
                  }
                  if(jCheckBox8.isSelected()==true){
                         pst.setString(8,"Yes");
                  }else if(jCheckBox8.isSelected()==false){
                         pst.setString(8,"No");
                  } 
                  if(jCheckBox9.isSelected()==true){
                         pst.setString(9,"Yes");
                  }else if(jCheckBox9.isSelected()==false){
                         pst.setString(9,"No");
                  }    
                  if(jCheckBox10.isSelected()==true){
                         pst.setString(10,"Yes");
                  }else if(jCheckBox10.isSelected()==false){
                         pst.setString(10,"No");
                  } 
                  if(jRadioButton1.isSelected())
                   {
                        pst.setString(11, "Available");
                   }
                   else if(jRadioButton2.isSelected())
                   {
                        pst.setString(11, "Unavailable");
                   }
                  pst.setString(12, jTextField4.getText());
                    pst.executeUpdate();

                           jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        
        jCheckBox4.setSelected(false);
                jCheckBox5.setSelected(false);
                        jCheckBox6.setSelected(false);
                                jCheckBox7.setSelected(false);
                                        jCheckBox8.setSelected(false);
                                                jCheckBox9.setSelected(false);
                                                        jCheckBox10.setSelected(false);
        jTextField1.setText(" ");
                jTextField2.setText(" ");
                        jTextField3.setText(" ");
                        jTextField4.setText(" ");
                             jPanel1.revalidate();
                             jPanel1.repaint();
                     JOptionPane.showMessageDialog(rootPane, "Room details Updated", "Room details", JOptionPane.INFORMATION_MESSAGE);
        avatable();
        unavatable();
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                
            }
                        }else{
               JOptionPane.showMessageDialog(null, "Please Enter All Details", "Error", JOptionPane.WARNING_MESSAGE);
           }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton5.isSelected()){
            jRadioButton4.setSelected(false);
            jRadioButton3.setSelected(false);
            
        }
        double apartment=6500.00;
        jTextField2.setText(Double.toString(apartment));
        jTextField3.setText(Double.toString(apartment));
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       try{
           String sql="delete from room where roomID=?";
           pst=con.prepareStatement(sql);
           pst.setString(1,jTextField4.getText());
           pst.executeUpdate();
           
           JOptionPane.showMessageDialog(rootPane, "Process Successful", "Success",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(rootPane, "Room details Deleted", "Room details", JOptionPane.INFORMATION_MESSAGE);
                            avatable();
        unavatable();
       }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton3.isSelected()){
            jRadioButton4.setSelected(false);
            jRadioButton5.setSelected(false);
            
        }
        double standard=2500.00;
        jTextField2.setText(Double.toString(standard));
          jTextField3.setText(Double.toString(standard));
       
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton4.isSelected()){
            jRadioButton3.setSelected(false);
            jRadioButton5.setSelected(false);}
                double premium=3500.00;
        jTextField2.setText(Double.toString(premium));
        jTextField3.setText(Double.toString(premium));
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        
        jCheckBox4.setSelected(false);
                jCheckBox5.setSelected(false);
                        jCheckBox6.setSelected(false);
                                jCheckBox7.setSelected(false);
                                        jCheckBox8.setSelected(false);
                                                jCheckBox9.setSelected(false);
                                                        jCheckBox10.setSelected(false);
        jTextField1.setText("");
                jTextField2.setText("");
                        jTextField3.setText("");
                      //  jTextField4.setText(" ");
                      generatecroomid();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
            if(jRadioButton1.isSelected()){
            jRadioButton2.setSelected(false);}
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
            if(jRadioButton2.isSelected()){
            jRadioButton1.setSelected(false);}
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
                    jRadioButton1.setSelected(true);
                    jRadioButton2.setSelected(false);
            int r=jTable3.getSelectedRow();    
        String RID=jTable3.getValueAt(r, 0).toString();
        TableModel model=jTable3.getModel();
        String type= model.getValueAt(r, 1).toString();
            if(type.equals("Standard")){
                jRadioButton3.setSelected(true);
                jRadioButton4.setSelected(false);
                jRadioButton5.setSelected(false);
            }else if(type.equals("Premium")){
                jRadioButton4.setSelected(true);
                jRadioButton3.setSelected(false);
                jRadioButton5.setSelected(false);
            }else{
                jRadioButton5.setSelected(true);
                jRadioButton4.setSelected(false);
                jRadioButton3.setSelected(false);
            }
        String persons=jTable3.getValueAt(r, 2).toString();
        String price=jTable3.getValueAt(r, 3).toString();
        String it1=jTable3.getValueAt(r, 4).toString();
            if(it1.equals("Yes")){
                jCheckBox4.setSelected(true);                
            }else{
                jCheckBox4.setSelected(false);
            }
        String it2=jTable3.getValueAt(r, 5).toString();
            if(it2.equals("Yes")){
                jCheckBox5.setSelected(true);
            }else{
                jCheckBox5.setSelected(false);
            }
        String it3=jTable3.getValueAt(r, 6).toString();
                    if(it3.equals("Yes")){
                jCheckBox6.setSelected(true);
            }else{
                jCheckBox6.setSelected(false);
            }
        String it4=jTable3.getValueAt(r, 7).toString();
                    if(it4.equals("Yes")){
                jCheckBox7.setSelected(true);
            }else{
                jCheckBox7.setSelected(false);
            }
        String it5=jTable3.getValueAt(r, 8).toString();
                    if(it5.equals("Yes")){
                jCheckBox8.setSelected(true);
            }else{
                jCheckBox8.setSelected(false);
            }
        String it6=jTable3.getValueAt(r, 9).toString();
                    if(it6.equals("Yes")){
                jCheckBox9.setSelected(true);
            }else{
                jCheckBox9.setSelected(false);
            }
        String it7=jTable3.getValueAt(r, 10).toString();
            if(it7.equals("Yes")){
                jCheckBox10.setSelected(true);
            }else{
                jCheckBox10.setSelected(false);
            }
        
        jTextField4.setText(RID);
        jTextField1.setText(persons);
        jTextField3.setText(price);
        iniprice();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
                    jRadioButton1.setSelected(false);
                    jRadioButton2.setSelected(true);
                    int r=jTable1.getSelectedRow();    
            TableModel model=jTable1.getModel();
        String RID=jTable1.getValueAt(r, 0).toString();
        String type= model.getValueAt(r, 1).toString();
            if(type.equals("Standard")){
                jRadioButton3.setSelected(true);
                jRadioButton4.setSelected(false);
                jRadioButton5.setSelected(false);
            }else if(type.equals("Premium")){
                jRadioButton4.setSelected(true);
                jRadioButton3.setSelected(false);
                jRadioButton5.setSelected(false);
            }else{
                jRadioButton5.setSelected(true);
                jRadioButton4.setSelected(false);
                jRadioButton3.setSelected(false);
            }
        String persons=jTable1.getValueAt(r, 2).toString();
        String price=jTable1.getValueAt(r, 3).toString();
        String it1=jTable1.getValueAt(r, 4).toString();
            if(it1.equals("Yes")){
                jCheckBox4.setSelected(true);                
            }else{
                jCheckBox4.setSelected(false);
            }
        String it2=jTable1.getValueAt(r, 5).toString();
            if(it2.equals("Yes")){
                jCheckBox5.setSelected(true);
            }else{
                jCheckBox5.setSelected(false);
            }
        String it3=jTable1.getValueAt(r, 6).toString();
                    if(it3.equals("Yes")){
                jCheckBox6.setSelected(true);
            }else{
                jCheckBox6.setSelected(false);
            }
        String it4=jTable1.getValueAt(r, 7).toString();
                    if(it4.equals("Yes")){
                jCheckBox7.setSelected(true);
            }else{
                jCheckBox7.setSelected(false);
            }
        String it5=jTable1.getValueAt(r, 8).toString();
                    if(it5.equals("Yes")){
                jCheckBox8.setSelected(true);
            }else{
                jCheckBox8.setSelected(false);
            }
        String it6=jTable1.getValueAt(r, 9).toString();
                    if(it6.equals("Yes")){
                jCheckBox9.setSelected(true);
            }else{
                jCheckBox9.setSelected(false);
            }
        String it7=jTable1.getValueAt(r, 10).toString();
            if(it7.equals("Yes")){
                jCheckBox10.setSelected(true);
            }else{
                jCheckBox10.setSelected(false);
            }
        
        jTextField4.setText(RID);
        jTextField1.setText(persons);
        jTextField3.setText(price);
        iniprice();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:
        /*  double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));*/
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed

          double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
          double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));           

    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
          double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
          double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
           double total;
        total = Double.parseDouble(jTextField2.getText());
        if(jCheckBox4.isSelected()){
            total = total + 500;
        }if(jCheckBox5.isSelected()){
            total = total + 200;
        }if(jCheckBox6.isSelected()){
            total = total + 500;
        }if(jCheckBox7.isSelected()){
            total = total + 500;
        }if(jCheckBox8.isSelected()){
            total = total + 200;
        }if(jCheckBox9.isSelected()){
            total = total + 200;
        }if(jCheckBox10.isSelected()){
            total = total + 300;
        }
        jTextField3.setText(Double.toString(total));
    }//GEN-LAST:event_jCheckBox10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
