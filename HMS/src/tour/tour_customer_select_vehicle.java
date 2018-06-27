/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import database.DBconnect;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class tour_customer_select_vehicle extends javax.swing.JFrame {

    /**
     * Creates new form tour_customer_select_vehicle
     */
       Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
String m_path;
    
    public tour_customer_select_vehicle() {
        initComponents();
        con = DBconnect.connect();
       // table();
           m_path ="C:\\Users\\Akila Sachin\\Desktop\\terra\\FInal Final\\PACKAGE p\\icon\\A.jpg";
          jLabel2.setIcon(ResiziseImage(m_path));
          jLabel4.setIcon(ResiziseImage(m_path));
          jLabel1.setIcon(ResiziseImage(m_path));
           table();
           
    }

    
    
     String Clocation_1 ;
    String Clocation_2 ;
    String Clocation_3 ;
    String Clocation_4 ;
    String Clocation_5 ;
    String Clocation_6 ;
    String Clocation_7 ;
    String Clocation_8 ;
    String Clocation_9 ;
    String Clocation_10 ;
    String Cpackage_id ;
    String Cp_name ;
    String Cc_id ;
    float avg_package_cost = 0 ; 
     float old_package_cost = 0 ; 
    String cost_covert ;
     String cs_date;
   String ce_date;
   String vehicle_driver_ln ; 
   String get_v_number ; 
    
      public tour_customer_select_vehicle(String s_date ,String e_date ,float now_cost , String package_id , String p_name , String c_id , String location_1 , String location_2 , String location_3 ,String location_4 ,String location_5 , String location_6 , String location_7 ,String location_8 ,String location_9 ,String location_10 ) {
        initComponents();
        con = DBconnect.connect();
        
        
          Cpackage_id =package_id;
     Cp_name =p_name;
    Cc_id = c_id ;
         Clocation_1 =location_1;
   Clocation_2  =location_2 ;
   Clocation_3 =location_3 ;
     Clocation_4 =location_4 ;
     Clocation_5 =location_5 ;
    Clocation_6  =location_6;
    Clocation_7  =location_7;
    Clocation_8  =location_8;
     Clocation_9  =location_9;
     Clocation_10  =location_10;
     
    
    
    avg_package_cost = now_cost ;
    old_package_cost  = now_cost ;
        cost_covert = Float.toString(now_cost) ;
                          jLabel9.setText(cost_covert); 
    
     jLabel20.setText(Cp_name);
    
        
         cs_date =s_date;
         ce_date =e_date;
      // System.out.println(s_date);
      // table();
          m_path ="C:\\Users\\acer\\Downloads\\akila\\HMS\\src\\tuor_image\\A.jpg";
          jLabel2.setIcon(ResiziseImage(m_path));
          jLabel4.setIcon(ResiziseImage(m_path));
          jLabel1.setIcon(ResiziseImage(m_path));
           table();
    /*    tour_customer_oop le = new tour_customer_oop();
        jLabel3.setText(le.set_guider_count());*/
          
    }

      public tour_customer_select_vehicle(String v_num ,String s_date ,String e_date ,float now_cost , String package_id , String p_name , String c_id , String location_1 , String location_2 , String location_3 ,String location_4 ,String location_5 , String location_6 , String location_7 ,String location_8 ,String location_9 ,String location_10 ) {
        initComponents();
        con = DBconnect.connect();
        
        
          Cpackage_id =package_id;
     Cp_name =p_name;
    Cc_id = c_id ;
         Clocation_1 =location_1;
   Clocation_2  =location_2 ;
   Clocation_3 =location_3 ;
     Clocation_4 =location_4 ;
     Clocation_5 =location_5 ;
    Clocation_6  =location_6;
    Clocation_7  =location_7;
    Clocation_8  =location_8;
     Clocation_9  =location_9;
     Clocation_10  =location_10;
     
    
    
    avg_package_cost = now_cost ; 
        cost_covert = Float.toString(now_cost) ;
                          jLabel9.setText(cost_covert); 
    
     jLabel20.setText(Cp_name);
    
        
         cs_date =s_date;
         ce_date =e_date;
     //  System.out.println(s_date);
       table();
      // System.out.println(v_num);
       set_vehicle(v_num);
    /*    tour_customer_oop le = new tour_customer_oop();
        jLabel3.setText(le.set_guider_count());*/
          
    }

    
    
int loopnumber =0;
float vehicle_1_cost = 0 ; 
float vehicle_2_cost = 0 ; 
float vehicle_3_cost = 0 ; 

float vehicle_4_cost = 0 ; 

String final_S_date ;
String final_E_date ;
String g = "\'";


public void dateCreat() {
         
   final_S_date  =g+cs_date + g ;
     final_E_date = g+ce_date+g;
} 


    
     public void table(){
           String m_path ;
        dateCreat();
       //  String sql = " select vehicle_id  from vehicle  "  ;
           String sql = "SELECT v.vehicle_id , v.name ,v.type , v.fuel_type , v.ac_cost , v.per_km_cost , v.sunroof ,v.driver_l,v.rate,.v.image FROM vehicle_booking_date vb ,vehicle v WHERE v.vehicle_id NOT IN (SELECT vehicle_id FROM vehicle_booking_date WHERE in_date BETWEEN '"+cs_date+"' and '"+ce_date+"' ) AND v.vehicle_id NOT IN (SELECT vehicle_id FROM vehicle_booking_date WHERE to_date BETWEEN '"+cs_date+"' and '"+ce_date+"' ) GROUP by v.vehicle_id  "  ;
        
          try {
              
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
              
              
              
             while (rs.next()) {
              String vehicle_id  = rs.getString("vehicle_id");
               String v_name  = rs.getString("name");
                String v_type  = rs.getString("type");
                 String fuel_type  = rs.getString("fuel_type");
                  float ac_cost = rs.getFloat("ac_cost");
                   String per_km_cost = rs.getString("per_km_cost");
                    String sunroof = rs.getString("sunroof");
                  String drive_l = rs.getString("driver_l");
                    String rate = rs.getString("rate") ; 
                    String image= rs.getString("image") ; 
            
        //     System.out.println(ac_cost);
           //   System.out.println(drive_l);
              
              if(loopnumber == 0 ){
                  
                  jLabel14.setText(vehicle_id);
                  jLabel11.setText(v_name);
                  jLabel27.setText(v_type);
                  jLabel28.setText(per_km_cost);
                  jLabel41.setText(rate);
                  jLabel47.setText(sunroof);
                    jLabel46.setText(drive_l);
                    vehicle_1_cost = ac_cost ; 
                    

                            if(!"NO".equals(image)){
                      m_path = image.replace("@", "//");
                        jLabel2.setIcon(ResiziseImage(m_path));

                       }

                    
                    
              }
              
              if(loopnumber == 1 ){
                 
                  jLabel48.setText(vehicle_id);
                  jLabel49.setText(v_name);
                  jLabel50.setText(v_type);
                  jLabel51.setText(per_km_cost);
                  jLabel52.setText(rate);
                  jLabel57.setText(sunroof);
                    jLabel56.setText(drive_l);
                    vehicle_2_cost = ac_cost ; 
                    
                        if(!"NO".equals(image)){
                      m_path = image.replace("@", "//");
                        jLabel4.setIcon(ResiziseImage(m_path));

                       }
                    
                    
                    
              }
              if(loopnumber == 2 ){
                 
                  jLabel58.setText(vehicle_id);
                  jLabel65.setText(v_name);
                  jLabel63.setText(v_type);
                  jLabel60.setText(per_km_cost);
                  jLabel53.setText(rate);
                  jLabel64.setText(sunroof);
                    jLabel59.setText(drive_l);
                    vehicle_3_cost = ac_cost ;
                    
                        if(!"NO".equals(image)){
                      m_path = image.replace("@", "//");
                        jLabel1.setIcon(ResiziseImage(m_path));

                       }
                    
                    
                    
              }
              
              
              loopnumber++ ; 
             
             }
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel54 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 150, 130, 2);

        jLabel15.setBackground(new java.awt.Color(0, 0, 204));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("5");
        jLabel15.setOpaque(true);
        jPanel2.add(jLabel15);
        jLabel15.setBounds(180, 400, 40, 29);

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Inn");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(90, 90, 170, 20);

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Dashboard");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(30, 330, 170, 29);

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Guider");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(0, 510, 100, 29);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Available Location");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(10, 440, 150, 29);

        jLabel22.setBackground(new java.awt.Color(0, 0, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("9");
        jLabel22.setOpaque(true);
        jPanel2.add(jLabel22);
        jLabel22.setBounds(180, 440, 40, 29);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 560, 210, 10);

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Next");
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel23);
        jLabel23.setBounds(40, 610, 130, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setOpaque(true);
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 600, 150, 50);

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Packages");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(10, 400, 100, 29);
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(0, 370, 100, 10);

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("The");
        jPanel2.add(jLabel40);
        jLabel40.setBounds(10, 10, 170, 20);

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Terrnova");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(30, 40, 220, 40);

        jLabel67.setBackground(new java.awt.Color(0, 0, 0));
        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("Welcome to Terrnova Inn");
        jPanel2.add(jLabel67);
        jLabel67.setBounds(40, 170, 230, 40);

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(204, 204, 204));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("We Provide the Best Services in ");
        jPanel2.add(jLabel68);
        jLabel68.setBounds(30, 200, 230, 40);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Negombo");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(80, 230, 80, 40);

        jLabel62.setBackground(new java.awt.Color(0, 0, 0));
        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Available Car");
        jPanel2.add(jLabel62);
        jLabel62.setBounds(0, 480, 130, 29);

        jLabel3.setBackground(new java.awt.Color(0, 0, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("4");
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(180, 510, 40, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 700);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(1190, 420, 10, 190);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("package name");
        jLabel20.setOpaque(true);
        jPanel1.add(jLabel20);
        jLabel20.setBounds(640, 50, 290, 50);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText(" can only select one vehicle at a time ");
        jLabel31.setOpaque(true);
        jPanel1.add(jLabel31);
        jLabel31.setBounds(620, 100, 330, 30);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(1100, 10, 20, 170);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("30");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(1180, 70, 110, 30);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("vehicle 4tos");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 170, 310, 210);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Whith AC");
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseEntered(evt);
            }
        });
        jPanel1.add(jCheckBox3);
        jCheckBox3.setBounds(410, 380, 100, 23);

        jLabel7.setText("Number");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(290, 430, 70, 20);

        jLabel12.setText("Type      ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(290, 530, 70, 20);

        jLabel29.setText("Per Km Cost      ");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(290, 580, 110, 20);

        jLabel30.setText("Name        ");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(1030, 480, 70, 20);

        jLabel38.setBackground(new java.awt.Color(51, 51, 51));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Add vehicle ");
        jLabel38.setOpaque(true);
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel38);
        jLabel38.setBounds(370, 640, 160, 40);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(650, 250, 10, 470);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Whith AC");
        jCheckBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox4MouseClicked(evt);
            }
        });
        jPanel1.add(jCheckBox4);
        jCheckBox4.setBounds(1160, 380, 90, 30);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("vehicle 4tos");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(680, 170, 310, 210);

        jLabel37.setText("Number ");
        jPanel1.add(jLabel37);
        jLabel37.setBounds(670, 430, 70, 20);

        jLabel13.setText("Type     ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(670, 530, 70, 20);

        jLabel33.setText("Per Km Cost     ");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(670, 580, 100, 20);

        jLabel32.setText("Rate       ");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(840, 530, 70, 20);

        jLabel39.setBackground(new java.awt.Color(51, 51, 51));
        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Add Vehicle ");
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel39);
        jLabel39.setBounds(720, 640, 160, 40);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(1010, 250, 10, 470);

        jLabel5.setText("Number ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1030, 430, 70, 20);

        jLabel6.setText("Type       ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1030, 530, 70, 20);

        jLabel10.setText("Per Km Cost   ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(1020, 580, 90, 20);

        jLabel34.setText("rate       ");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(1200, 530, 70, 20);

        jLabel36.setBackground(new java.awt.Color(51, 51, 51));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Add Vehicle");
        jLabel36.setOpaque(true);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel36);
        jLabel36.setBounds(1110, 640, 160, 40);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("vehicle 4tos");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1030, 170, 310, 210);

        jLabel11.setText("Not Available");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(370, 480, 80, 14);

        jLabel14.setText("Not Available");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(368, 430, 80, 20);

        jLabel27.setText("Not Available");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(370, 530, 63, 14);

        jLabel28.setText("Not Available");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(380, 580, 80, 14);

        jLabel35.setText("Rate       ");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(480, 520, 70, 20);

        jLabel41.setText("Not Available");
        jPanel1.add(jLabel41);
        jLabel41.setBounds(570, 520, 80, 14);

        jLabel42.setText("Name       ");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(290, 480, 70, 20);

        jLabel43.setText("Name        ");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(670, 480, 70, 20);

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Whith AC");
        jCheckBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox5MouseClicked(evt);
            }
        });
        jPanel1.add(jCheckBox5);
        jCheckBox5.setBounds(790, 380, 90, 30);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator8);
        jSeparator8.setBounds(510, 10, 10, 160);

        jLabel44.setText("Driver Licence");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(1200, 480, 80, 14);

        jLabel45.setText("Sunroof ");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(480, 430, 70, 14);

        jLabel47.setText("Not Available");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(570, 430, 63, 14);

        jLabel48.setText("Not Available");
        jPanel1.add(jLabel48);
        jLabel48.setBounds(750, 430, 80, 14);

        jLabel49.setText("Not Available");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(750, 480, 80, 14);

        jLabel50.setText("Not Available");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(750, 530, 80, 14);

        jLabel51.setText("Not Available");
        jPanel1.add(jLabel51);
        jLabel51.setBounds(750, 580, 80, 14);

        jLabel52.setText("Not Available");
        jPanel1.add(jLabel52);
        jLabel52.setBounds(930, 530, 80, 14);

        jLabel53.setText("Not Available");
        jPanel1.add(jLabel53);
        jLabel53.setBounds(1270, 530, 90, 14);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator9);
        jSeparator9.setBounds(460, 410, 10, 200);

        jLabel54.setText("sunroof ");
        jPanel1.add(jLabel54);
        jLabel54.setBounds(850, 430, 70, 14);

        jLabel56.setText("Not Available");
        jPanel1.add(jLabel56);
        jLabel56.setBounds(930, 480, 63, 14);

        jLabel57.setText("Not Available");
        jPanel1.add(jLabel57);
        jLabel57.setBounds(930, 430, 63, 14);

        jLabel58.setText("Not Available");
        jPanel1.add(jLabel58);
        jLabel58.setBounds(1100, 430, 80, 14);

        jLabel59.setText("Not Available");
        jPanel1.add(jLabel59);
        jLabel59.setBounds(1270, 480, 80, 14);

        jLabel60.setText("Not Available");
        jPanel1.add(jLabel60);
        jLabel60.setBounds(1110, 580, 80, 14);

        jLabel61.setText("Sunroof ");
        jPanel1.add(jLabel61);
        jLabel61.setBounds(1200, 430, 70, 14);

        jLabel63.setText("Not Available");
        jPanel1.add(jLabel63);
        jLabel63.setBounds(1100, 530, 80, 14);

        jLabel64.setText("Not Available");
        jPanel1.add(jLabel64);
        jLabel64.setBounds(1270, 430, 63, 14);

        jLabel65.setText("Not Available");
        jPanel1.add(jLabel65);
        jLabel65.setBounds(1100, 480, 80, 14);

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("RS:");
        jLabel66.setOpaque(true);
        jPanel1.add(jLabel66);
        jLabel66.setBounds(1130, 70, 50, 30);

        jLabel69.setText("Driver Licence");
        jPanel1.add(jLabel69);
        jLabel69.setBounds(470, 480, 80, 14);

        jLabel55.setText("Driver Licence");
        jPanel1.add(jLabel55);
        jLabel55.setBounds(840, 480, 80, 14);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator10);
        jSeparator10.setBounds(830, 420, 10, 190);

        jLabel46.setText("Not Available");
        jPanel1.add(jLabel46);
        jLabel46.setBounds(570, 480, 80, 14);

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Back ");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25);
        jLabel25.setBounds(320, 30, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1351, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    int select_count_vehicle = 0 ; 
     int select_count_vehicle_1=2;
      int select_count_vehicle_2=2;
       int select_count_vehicle_3=2;
       String cc_vehicle_number ;
     
       
    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
     
        if(select_count_vehicle_1 % 2 == 0){
             jLabel38.setBackground(new Color(90, 120, 183));
                    if(select_count_vehicle == 0 ){
                 select_count_vehicle++ ; 
                 select_count_vehicle_1=5;
          //    System.out.println("selecttion_count") ;
                                 avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
                 cost_covert = Float.toString(avg_package_cost) ;
                                   jLabel9.setText(cost_covert); 
                                   cc_vehicle_number=jLabel14.getText();
                                   vehicle_driver_ln= jLabel46.getText();

                    }

                    else {

                                if( select_count_vehicle_2 ==5  ){
                                    jLabel39.setBackground(new Color(51,51,51));
                                         avg_package_cost =  avg_package_cost - vehicle_2_cost ;
                                         select_count_vehicle_1=5;
                                         select_count_vehicle_2=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                               cc_vehicle_number=jLabel14.getText();
                                                   vehicle_driver_ln= jLabel46.getText();

                                     }
                                else if(select_count_vehicle_3==5){
                                    
                                    jLabel36.setBackground(new Color(51,51,51));
                                      avg_package_cost =  avg_package_cost - vehicle_3_cost ;
                                         select_count_vehicle_1=5;
                                         select_count_vehicle_3=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                             cc_vehicle_number=jLabel14.getText();
                                                 vehicle_driver_ln= jLabel46.getText();

                                    
                                    
                                }
                    }
  
           }
        else if (select_count_vehicle_1% 2 == 1) {
            jLabel38.setBackground(new Color(51,51,51));
            
             avg_package_cost= avg_package_cost  - vehicle_1_cost ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                       
                          select_count_vehicle_1 = 2 ;
                          select_count_vehicle = 0 ;
                               cc_vehicle_number="null";
                                   vehicle_driver_ln= "null";

        
    }

        
      //  ********************************************************
        
        /* avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
        cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                          */
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked

        
        
        if(select_count_vehicle_2 % 2 == 0){
             jLabel39.setBackground(new Color(90, 120, 183));
                    if(select_count_vehicle == 0 ){
                 select_count_vehicle++ ; 
                 select_count_vehicle_2=5;
          //    System.out.println("selecttion_count") ;
                                 avg_package_cost =  avg_package_cost + vehicle_2_cost ; 
                 cost_covert = Float.toString(avg_package_cost) ;
                                   jLabel9.setText(cost_covert); 
                                     cc_vehicle_number=jLabel48.getText();
                                        vehicle_driver_ln= jLabel56.getText();
                    }

                    else {

                                if( select_count_vehicle_1 ==5  ){
                                      jLabel38.setBackground(new Color(51,51,51));
                                         avg_package_cost =  avg_package_cost - vehicle_1_cost ;
                                         select_count_vehicle_2=5;
                                          select_count_vehicle_1=2;
                                          // System.out.println(avg_package_cost) ;
                                        avg_package_cost =  avg_package_cost + vehicle_2_cost ; 
                                           
                                     //   System.out.println(avg_package_cost) ;
                                        
                                        cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                                 cc_vehicle_number=jLabel48.getText();
                                                     vehicle_driver_ln= jLabel56.getText();
                                     }
                                else if(select_count_vehicle_3==5){
                                      jLabel36.setBackground(new Color(51,51,51));
                                    
                                      avg_package_cost =  avg_package_cost - vehicle_3_cost ;
                                         select_count_vehicle_2=5;
                                         select_count_vehicle_3 = 2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_2_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                           cc_vehicle_number=jLabel48.getText();
                                               vehicle_driver_ln= jLabel56.getText();
                                    
                                    
                                }
                    }

    
           
           
           
           
           }
        else if (select_count_vehicle_2% 2 == 1) {
            jLabel39.setBackground(new Color(51,51,51));
            
             avg_package_cost= avg_package_cost  - vehicle_2_cost ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                       
                          select_count_vehicle_2 = 2 ;
                          select_count_vehicle = 0 ;
                            cc_vehicle_number="null";
                                vehicle_driver_ln= "null";
        
    }
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked

        
        
        if(select_count_vehicle_3 % 2 == 0){
            jLabel36.setBackground(new Color(90, 120, 183));
                    if(select_count_vehicle == 0 ){
                 select_count_vehicle++ ; 
                 select_count_vehicle_3=5;
          //    System.out.println("selecttion_count") ;
                                 avg_package_cost =  avg_package_cost + vehicle_3_cost ; 
                 cost_covert = Float.toString(avg_package_cost) ;
                                   jLabel9.setText(cost_covert); 
                                     cc_vehicle_number=jLabel58.getText();
                                         vehicle_driver_ln= jLabel59.getText();
                    }

                    else {

                                if( select_count_vehicle_1 ==5  ){
                                     jLabel38.setBackground(new Color(51,51,51));
                                         avg_package_cost =  avg_package_cost - vehicle_1_cost ;
                                         select_count_vehicle_3=5;
                                         select_count_vehicle_1=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_3_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                             cc_vehicle_number=jLabel58.getText();
                                              vehicle_driver_ln= jLabel59.getText();
                                     }
                                else if(select_count_vehicle_2==5){
                                     jLabel39.setBackground(new Color(51,51,51));
                                    
                                      avg_package_cost =  avg_package_cost - vehicle_2_cost ;
                                         select_count_vehicle_3=5;
                                         select_count_vehicle_2=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_3_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                     cc_vehicle_number=jLabel58.getText();
                                      vehicle_driver_ln= jLabel59.getText();
                                    
                                    
                                }
                    }

    
           
           
           
           
           }
        else if (select_count_vehicle_3% 2 == 1) {
              jLabel36.setBackground(new Color(51,51,51));
            
             avg_package_cost= avg_package_cost  - vehicle_3_cost ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                       
                          select_count_vehicle_3 = 2 ;
                          select_count_vehicle = 0 ;
                             cc_vehicle_number=" null";
                              vehicle_driver_ln= jLabel59.getText();
        
    }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jCheckBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3MouseEntered

    
     
    int select_count_vehicle_ac = 0 ; 
     int select_count_vehicle_1_ac =2;
      int select_count_vehicle_2_ac=2;
       int select_count_vehicle_3_ac=2;
        
    private void jCheckBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseClicked


        
        if(select_count_vehicle_1_ac % 2 == 0){
                    if(select_count_vehicle_ac == 0 ){
                 select_count_vehicle_ac++ ; 
                 select_count_vehicle_1_ac=5;
          //    System.out.println("selecttion_count") ;
                                 avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
                 cost_covert = Float.toString(avg_package_cost) ;
                                   jLabel9.setText(cost_covert); 

                    }

                    else {

                                if( select_count_vehicle_2_ac ==5  ){
                                         avg_package_cost =  avg_package_cost - vehicle_2_cost ;
                                         select_count_vehicle_1_ac=5;
                                         select_count_vehicle_2_ac=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 

                                     }
                                else if(select_count_vehicle_3_ac==5){
                                    
                                    
                                      avg_package_cost =  avg_package_cost - vehicle_3_cost ;
                                         select_count_vehicle_1=5;
                                         select_count_vehicle_3_ac=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_1_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                    
                                    
                                    
                                }
                    }

    
           
           
           
           
           }
        else if (select_count_vehicle_1_ac% 2 == 1) {
            
             avg_package_cost= avg_package_cost  - vehicle_1_cost ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                       
                          select_count_vehicle_1_ac = 2 ;
                          select_count_vehicle_ac = 0 ;
                            
        
    }
        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3MouseClicked

    private void jCheckBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox5MouseClicked

   
        if(select_count_vehicle_2_ac % 2 == 0){
                    if(select_count_vehicle_ac == 0 ){
                 select_count_vehicle_ac++ ; 
                 select_count_vehicle_2_ac=5;
          //    System.out.println("selecttion_count") ;
                                 avg_package_cost =  avg_package_cost + vehicle_2_cost ; 
                 cost_covert = Float.toString(avg_package_cost) ;
                                   jLabel9.setText(cost_covert); 

                    }

                    else {

                                if( select_count_vehicle_1_ac ==5  ){
                                         avg_package_cost =  avg_package_cost - vehicle_1_cost ;
                                         select_count_vehicle_2_ac=5;
                                          select_count_vehicle_1_ac=2;
                                         //  System.out.println(avg_package_cost) ;
                                        avg_package_cost =  avg_package_cost + vehicle_2_cost ; 
                                           
                                    //    System.out.println(avg_package_cost) ;
                                        
                                        cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 

                                     }
                                else if(select_count_vehicle_3_ac==5){
                                    
                                    
                                      avg_package_cost =  avg_package_cost - vehicle_3_cost ;
                                         select_count_vehicle_2_ac=5;
                                         select_count_vehicle_3_ac = 2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_2_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                    
                                    
                                    
                                }
                    }

    
           
           
           
           
           }
        else if (select_count_vehicle_2_ac% 2 == 1) {
            
             avg_package_cost= avg_package_cost  - vehicle_2_cost ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                       
                          select_count_vehicle_2_ac = 2 ;
                          select_count_vehicle_ac = 0 ;
                            
        
    }
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5MouseClicked

    private void jCheckBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox4MouseClicked

                
        
        if(select_count_vehicle_3_ac % 2 == 0){
                    if(select_count_vehicle_ac == 0 ){
                 select_count_vehicle_ac++ ; 
                 select_count_vehicle_3_ac=5;
          //    System.out.println("selecttion_count") ;
                                 avg_package_cost =  avg_package_cost + vehicle_3_cost ; 
                 cost_covert = Float.toString(avg_package_cost) ;
                                   jLabel9.setText(cost_covert); 

                    }

                    else {

                                if( select_count_vehicle_1_ac ==5  ){
                                         avg_package_cost =  avg_package_cost - vehicle_1_cost ;
                                         select_count_vehicle_3_ac=5;
                                         select_count_vehicle_1_ac=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_3_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 

                                     }
                                else if(select_count_vehicle_2_ac==5){
                                    
                                    
                                      avg_package_cost =  avg_package_cost - vehicle_2_cost ;
                                         select_count_vehicle_3_ac=5;
                                         select_count_vehicle_2_ac=2;
                                           //System.out.println("selecttion_count") ;
                                        avg_package_cost =  avg_package_cost + vehicle_3_cost ; 
                                             cost_covert = Float.toString(avg_package_cost) ;
                                          jLabel9.setText(cost_covert); 
                                    
                                    
                                    
                                }
                    }

    
           
           
           
           
           }
        else if (select_count_vehicle_3_ac% 2 == 1) {
            
             avg_package_cost= avg_package_cost  - vehicle_3_cost ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel9.setText(cost_covert); 
                       
                          select_count_vehicle_3_ac = 2 ;
                          select_count_vehicle_ac = 0 ;
                            
        
    }
        



        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4MouseClicked

    
    
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

         jLabel23.setBackground(new Color(90, 120, 183));
        
        tour_customer_selecte_guider las = new tour_customer_selecte_guider( vehicle_driver_ln ,cc_vehicle_number,cs_date,ce_date,avg_package_cost ,Cpackage_id ,  Cp_name ,  Cc_id ,Clocation_1 ,Clocation_2 , Clocation_3 ,Clocation_4 , Clocation_5 , Clocation_6 , Clocation_7 ,Clocation_8 ,Clocation_9 ,Clocation_10) ; 
      las.setVisible(true);
        this.dispose();



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked

        tour_customer_selecte_location ll =new tour_customer_selecte_location(  cs_date,ce_date,Integer.parseInt(Cpackage_id),Cp_name,Cc_id ,  Clocation_1, Clocation_2 ,Clocation_3 , Clocation_4 ,Clocation_5 , Clocation_6  ,Clocation_7  ,Clocation_8 , Clocation_9  ,Clocation_10  );
        
        ll.setVisible(true);
        ll.getcost(old_package_cost);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked
  public ImageIcon ResiziseImage (String ImagePath){
        ImageIcon myimage=new ImageIcon(ImagePath);
        Image img=myimage.getImage();
        Image newimg=img.getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newimg);
        return image;
    }
  
  
  public void set_vehicle(String get_number){
      
      if(get_number.equals(jLabel14.getText())){
          
          jLabel38.setBackground(new Color(90, 120, 183));
            select_count_vehicle_1=5;
              select_count_vehicle++ ;
      
            System.out.println("select_count_vehicle_1") ; 
          
      }
      else if(get_number.equals(jLabel48.getText())){
          
          jLabel39.setBackground(new Color(90, 120, 183));
            select_count_vehicle_2=5;
              select_count_vehicle++ ;
             System.out.println("select_count_vehicle_2") ; 
          
      }
      else if(get_number.equals(jLabel58.getText())){
          
          jLabel36.setBackground(new Color(90, 120, 183));
            select_count_vehicle_3=5;
              select_count_vehicle++ ;
           System.out.println("select_count_vehicle_3") ; 
      }
      
      
      
      
      
      
  }
  
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
            java.util.logging.Logger.getLogger(tour_customer_select_vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tour_customer_select_vehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
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
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
