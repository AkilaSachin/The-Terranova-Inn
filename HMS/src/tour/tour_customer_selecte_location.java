/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import database.DBconnect;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class tour_customer_selecte_location extends javax.swing.JFrame {

    /**
     * Creates new form tour_customer_selecte_location
     */
    
    
      Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    
    public tour_customer_selecte_location() {
        initComponents();
         con = DBconnect.connect();
         jLabel11.setVisible(false);
          jLabel14.setVisible(false);
         jLabel32.setVisible(false);
         jLabel33.setVisible(false);
         jLabel36.setVisible(false);
       jLabel37.setVisible(false);
       jLabel31.setVisible(false);
       jLabel39.setVisible(false);
       jLabel38.setVisible(false);
    }

    
   String c_para ; 
   String c_mame ;
   String c_p_name ; 
   String cs_date;
   String ce_date;
   
    
    public tour_customer_selecte_location(String s_date ,String e_date ,int para , String p_name ,String c_id) {
        initComponents();
         con = DBconnect.connect();
   /*  System.out.println(s_date);
     System.out.println(e_date);*/
     
     
         cs_date =s_date;
         ce_date =e_date;
     
     
     jLabel20.setText(p_name);
     c_p_name =p_name ; 
       
     c_para = Integer.toString(para);  
     table();
        get_cost_location();
        avg_cost() ; 
        
           c_mame =   c_id ; 
           
           // set value lable 
           
            tour_customer_oop re = new tour_customer_oop();
          jLabel15.setText(re.table2_car());
            jLabel22.setText(re.set_guider_count());
           
            System.out.println(cs_date);
     System.out.println(ce_date);
       jLabel11.setVisible(false);
          jLabel14.setVisible(false);
         jLabel32.setVisible(false);
         jLabel33.setVisible(false);
         jLabel36.setVisible(false);
       jLabel37.setVisible(false);
       jLabel31.setVisible(false);
       jLabel39.setVisible(false);
       jLabel38.setVisible(false);
     
    }
    
    
    
    
    String location_1_set ;
    String location_2_set ;
    String location_3_set ;
    String location_4_set ;
    String location_5_set ;
    String location_6_set ;
    String location_7_set ;
    String location_8_set ;
    String location_9_set ;
    String location_10_set ;
        
    
    
    
    
       public tour_customer_selecte_location(String s_date ,String e_date ,int para , String p_name ,String c_id , String location_1 , String location_2 , String location_3 ,String location_4 ,String location_5 , String location_6 , String location_7 ,String location_8 ,String location_9 ,String location_10 ) {
        initComponents();
         con = DBconnect.connect();
   /*  System.out.println(s_date);
     System.out.println(e_date);*/
     
     
         cs_date =s_date;
         ce_date =e_date;
     
     
     jLabel20.setText(p_name);
     c_p_name =p_name ; 
       
     c_para = Integer.toString(para);  
     table();
      
      //  avg_cost() ; 
        
           c_mame =   c_id ; 
           
           // set value lable 
           
            tour_customer_oop re = new tour_customer_oop();
          jLabel15.setText(re.table2_car());
            jLabel22.setText(re.set_guider_count());
            
            
            
            
 location_1_set = location_1 ;
    location_2_set  =location_2 ;
    location_3_set = location_3;
     location_4_set = location_4;
     location_5_set= location_5;
     location_6_set= location_6 ;
     location_7_set= location_7 ;
    location_8_set = location_8;
     location_9_set= location_9 ;
    location_10_set = location_10;
        
             //  System.out.println(location_9);
     
           
       jLabel11.setVisible(false);
          jLabel14.setVisible(false);
         jLabel32.setVisible(false);
         jLabel33.setVisible(false);
         jLabel36.setVisible(false);
       jLabel37.setVisible(false);
       jLabel31.setVisible(false);
       jLabel39.setVisible(false);
       jLabel38.setVisible(false);
        location_set();
        
         get_cost_location();
         get_cost_location2();
    }
    
    

    
    
    
    int selecttion_count =  0 ; 
    String cost_covert  ;
    
    
      String sub_package_id ;
    int sub_count1 = 0 ; 
        int sub_count2 = 0 ; 
            int sub_count3 = 0 ;     
            int sub_count4= 0 ; 
                int sub_count5= 0 ; 
                int sub_count6= 0 ; 
                 int sub_count7= 0 ; 
                int sub_count8= 0 ; 
                
                 int sub_count9= 0 ; 
                int sub_count10= 0 ; 
                
            
    tour_coustomer_selecte_location_details sub_frame ;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    
    String location_1 ;
    String location_2 ;
    String location_3 ;
    String location_4 ;
    String location_5 ;
    String location_6 ;
    String location_7 ;
    String location_8 ;
    String location_9 ;
    String location_10 ;

  /* tour_customer_selecte_location(String Cpackage_id, String Cp_name, String Cc_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public void getcost(float pp_cost){
        
        jLabel34.setText(String.valueOf(pp_cost));
         avg_package_cost =pp_cost ;
        
    }
    
    
       
    
        
    public void location_set(){
        
       
      
            if(location_1_set!=null){
          
                 jLabel11.setVisible(true);
                selecttion_count++ ; 
                p_location_1 = location_1_set ; 
                set_loacation_count_1=5;
                System.out.println(location_1_set);
          }
             if(location_2_set!=null){
            jLabel14.setVisible(true);
            p_location_2 = location_2_set ;
            set_loacation_count_2 = 5 ;
           selecttion_count++ ; 
            
                // jCheckBox3.setSelected(true);
            }
             
              if(location_3_set!=null){
              jLabel32.setVisible(true);
               selecttion_count++ ; 
               p_location_3 = location_3_set ;
                 set_loacation_count_3 = 5 ;
               
            }
               if(location_4_set!=null){
                  jLabel33.setVisible(true);
                    selecttion_count++ ; 
                      p_location_4  = location_4_set ; 
                     set_loacation_count_4=5 ;
            }
                if(location_5_set!=null){
                    jLabel36.setVisible(true);
                     selecttion_count++ ;
                     p_location_5  = location_5_set ; 
                     set_loacation_count_756 = 5 ; 
              
            }
                 if(location_6_set!=null){
                     jLabel37.setVisible(true);
                       selecttion_count++ ;
                       p_location_6 = location_6_set ;
                        set_loacation_count_6=5;
               //  jCheckBox7.setSelected(true);
            }
                  if(location_7_set!=null){
                      jLabel31.setVisible(true);
                        selecttion_count++ ; 
                        p_location_7 = location_7_set ; 
                        set_loacation_count_7=5;
                      
               //     jCheckBox8.setSelected(true);
            }
                  if(location_8_set!=null){
                      jLabel39.setVisible(true);
                        selecttion_count++ ; 
                        p_location_8  = location_8_set ; 
                         set_loacation_count_8=5;
               //      jCheckBox9.setSelected(true);
            }
                    if(location_9_set !=null){
                          jLabel38.setVisible(true);
                         selecttion_count++ ; 
                         p_location_9  = location_9_set ; 
                          set_loacation_count_9=5;
                //         jCheckBox1.setSelected(true);
            }
                     if(!"".equals(location_10_set)){
                      //    jCheckBox3.setSelected(true);
            }
        
       
                   // get_cost_location2();
                  //  avg_cost() ; 
        
    }
    
    
    
    
    public void table(){
        
        
         String sql = " select id ,location_1,location_2,location_3,location_4,location_5,location_6,location_7,location_8,location_9,location_10  from it160_package_location_history where package_ID   like  '"+c_para+"'"  ;
        
        
          try {
              int loopnumber =0;
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql);
              
              
              
             while (rs.next()) {
              int id = rs.getInt("id");
          location_1 = rs.getString("location_1");
          location_2 = rs.getString("location_2");
          location_3 = rs.getString("location_3");
          location_4 = rs.getString("location_4");
          location_5 = rs.getString("location_5");
         location_6 = rs.getString("location_6");
          location_7 = rs.getString("location_7");
          location_8 = rs.getString("location_8");
         location_9 = rs.getString("location_9");
         location_10 = rs.getString("location_10");
        
         
         jLabel40.setText(location_1);
                  jLabel2.setIcon(ResiziseImage( image_set(location_1)));
            jLabel41.setText(location_2);
            jLabel7.setIcon(ResiziseImage( image_set(location_2)));
            
            jLabel42.setText(location_3);
            jLabel4.setIcon(ResiziseImage( image_set(location_3)));
             
            jLabel43.setText(location_4);
               jLabel5.setIcon(ResiziseImage( image_set(location_4)));
            jLabel44.setText(location_5);
               jLabel6.setIcon(ResiziseImage( image_set(location_5)));
            jLabel45.setText(location_6);
               jLabel10.setIcon(ResiziseImage( image_set(location_6)));
            jLabel46.setText(location_7);
               jLabel12.setIcon(ResiziseImage( image_set(location_7)));
            jLabel47.setText(location_8);
               jLabel13.setIcon(ResiziseImage( image_set(location_8)));
            jLabel48.setText(location_9);
               jLabel1.setIcon(ResiziseImage( image_set(location_9)));
             
             
             
             }
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
         int location_cost1 ;
           int location_cost2 ;
             int location_cost3 ;
               int location_cost4 ;
                 int location_cost5 ;
                   int location_cost6 ;
                     int location_cost7 ;
                       int location_cost8 ;
                         int location_cost9 ;
                           int location_cost10 ;
    
    public void get_cost_location(){
         
          try {
              String sql_1 = "select cost from place where  name like '"+location_1+"'"  ;
              
              
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
     
              while (rs.next()) {
                  
                   location_cost1 = rs.getInt("cost");
            //        System.out.println(location_cost1) ;
              
              }
                      
               } 
          
             catch (SQLException ex) {
             Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    
      //***********************************************************************************************    
          try {
          String sql_1 = "select cost from place where  name like '%"+location_2+"%'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost2 = rs.getInt("cost");
                //   System.out.println(location_cost2) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_3+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost3 = rs.getInt("cost");
            //        System.out.println(location_cost3) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                  
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_4+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost4 = rs.getInt("cost");
             //       System.out.println(location_cost4) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                        
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_5+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost5 = rs.getInt("cost");
           //         System.out.println(location_cost5) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                        
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_6+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost6 = rs.getInt("cost");
          //         System.out.println(location_cost6) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                        
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_7+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost7 = rs.getInt("cost");
           //       System.out.println(location_cost7) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                        
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_8+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost8 = rs.getInt("cost");
          //          System.out.println(location_cost8) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                        
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_9+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost9 = rs.getInt("cost");
            //     System.out.println(location_cost9) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
                        
       //******************************************************************************************     
            
                try {
          String sql_1 = "select cost from place where  name like '"+location_10+"'"  ;
              
            
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql_1);
          
                 while (rs.next()) {
                  
                   location_cost10 = rs.getInt("cost");
              //    System.out.println(location_cost10) ;
              
              }
              
              
              }
          
          
                catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
      
          
    }
    
    
        public void get_cost_location2(){
  
      package_cost =    location_cost1 + location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 + location_cost1 ; 
        package_cost = (float) (package_cost * 0.70) ; 
      System.out.println(location_cost1);
    }
    
    float avg_package_cost =  0 ; 
    float package_cost ; 
    public void avg_cost(){
        
        
     avg_package_cost =    location_cost1 + location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 + location_cost1 ; 
        avg_package_cost = (float) (avg_package_cost * 0.70) ; 
        package_cost = avg_package_cost ;
       // System.out.println(avg_package_cost);
       
       cost_covert = Float.toString(avg_package_cost) ;
       jLabel34.setText(cost_covert);
         
         
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/U9.jpg"))); // NOI18N
        jLabel1.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel1.setOpaque(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel1MouseWheelMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(980, 510, 310, 150);

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/m1.jpg"))); // NOI18N
        jLabel2.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel2.setOpaque(true);
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel2MouseWheelMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 120, 310, 150);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("you can only select 6 locations from here. If you add more than 6 locations, each location will charge an additional cost");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(380, 70, 750, 30);

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/l3.jpg"))); // NOI18N
        jLabel5.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel5.setOpaque(true);
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel5MouseMoved(evt);
            }
        });
        jLabel5.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel5MouseWheelMoved(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 320, 310, 150);

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/U3.jpg"))); // NOI18N
        jLabel6.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel6.setOpaque(true);
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel6MouseMoved(evt);
            }
        });
        jLabel6.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel6MouseWheelMoved(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(640, 320, 310, 150);

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/U8.jpg"))); // NOI18N
        jLabel7.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel7.setOpaque(true);
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });
        jLabel7.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel7MouseWheelMoved(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(640, 120, 310, 150);

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/U11.jpg"))); // NOI18N
        jLabel10.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel10.setOpaque(true);
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel10MouseMoved(evt);
            }
        });
        jLabel10.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel10MouseWheelMoved(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(980, 320, 310, 150);

        jLabel12.setBackground(new java.awt.Color(0, 51, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/U10.jpg"))); // NOI18N
        jLabel12.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel12.setOpaque(true);
        jLabel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel12MouseMoved(evt);
            }
        });
        jLabel12.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel12MouseWheelMoved(evt);
            }
        });
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12);
        jLabel12.setBounds(300, 510, 310, 150);

        jLabel13.setBackground(new java.awt.Color(0, 51, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/l1.jpg"))); // NOI18N
        jLabel13.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel13.setOpaque(true);
        jLabel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel13MouseMoved(evt);
            }
        });
        jLabel13.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel13MouseWheelMoved(evt);
            }
        });
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13);
        jLabel13.setBounds(640, 510, 310, 150);

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/U5.jpg"))); // NOI18N
        jLabel4.setToolTipText("If you want mor details about the location please use mouse wheel");
        jLabel4.setOpaque(true);
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel4MouseWheelMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(980, 120, 310, 150);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("RS:");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(1090, 30, 50, 40);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(470, 10, 10, 90);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(1020, 10, 20, 80);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("package name");
        jLabel20.setOpaque(true);
        jPanel1.add(jLabel20);
        jLabel20.setBounds(560, 20, 300, 50);

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("300");
        jLabel34.setOpaque(true);
        jPanel1.add(jLabel34);
        jLabel34.setBounds(1150, 30, 140, 40);

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
        jLabel15.setBounds(190, 450, 40, 29);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Negombo");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(80, 230, 80, 40);

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
        jLabel18.setBounds(30, 300, 170, 29);

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Guider");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(30, 500, 50, 30);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Available location");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(20, 410, 140, 29);

        jLabel22.setBackground(new java.awt.Color(0, 0, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("?");
        jLabel22.setOpaque(true);
        jPanel2.add(jLabel22);
        jLabel22.setBounds(190, 500, 40, 29);
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
        jLabel24.setBounds(10, 370, 100, 29);
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(10, 340, 100, 20);

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("The");
        jPanel2.add(jLabel35);
        jLabel35.setBounds(10, 10, 170, 20);

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Terrnova");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(30, 40, 220, 40);

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Vailable car");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(0, 460, 130, 29);

        jLabel28.setBackground(new java.awt.Color(0, 0, 204));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("4");
        jLabel28.setOpaque(true);
        jPanel2.add(jLabel28);
        jLabel28.setBounds(190, 370, 40, 29);

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Welcome to Terrnova Inn");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(40, 170, 230, 40);

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("We Provide the Best Services in ");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(30, 200, 230, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 700);

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText(" Back ");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25);
        jLabel25.setBounds(300, 20, 110, 34);

        jLabel11.setBackground(new java.awt.Color(90, 120, 183));
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(290, 110, 330, 170);

        jLabel14.setBackground(new java.awt.Color(90, 120, 183));
        jLabel14.setOpaque(true);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(630, 110, 330, 170);

        jLabel31.setBackground(new java.awt.Color(90, 120, 183));
        jLabel31.setOpaque(true);
        jPanel1.add(jLabel31);
        jLabel31.setBounds(290, 500, 330, 170);

        jLabel32.setBackground(new java.awt.Color(90, 120, 183));
        jLabel32.setOpaque(true);
        jPanel1.add(jLabel32);
        jLabel32.setBounds(970, 110, 330, 170);

        jLabel33.setBackground(new java.awt.Color(90, 120, 183));
        jLabel33.setOpaque(true);
        jPanel1.add(jLabel33);
        jLabel33.setBounds(290, 310, 330, 170);

        jLabel36.setBackground(new java.awt.Color(90, 120, 183));
        jLabel36.setOpaque(true);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel36);
        jLabel36.setBounds(630, 310, 330, 170);

        jLabel37.setBackground(new java.awt.Color(90, 120, 183));
        jLabel37.setOpaque(true);
        jPanel1.add(jLabel37);
        jLabel37.setBounds(970, 310, 330, 170);

        jLabel38.setBackground(new java.awt.Color(90, 120, 183));
        jLabel38.setOpaque(true);
        jPanel1.add(jLabel38);
        jLabel38.setBounds(970, 500, 330, 170);

        jLabel39.setBackground(new java.awt.Color(90, 120, 183));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setOpaque(true);
        jPanel1.add(jLabel39);
        jLabel39.setBounds(630, 500, 330, 170);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("po[o'");
        jPanel1.add(jLabel40);
        jLabel40.setBounds(330, 280, 230, 17);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("jLabel41");
        jPanel1.add(jLabel41);
        jLabel41.setBounds(700, 280, 190, 17);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("jLabel42");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(1000, 280, 280, 17);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("jLabel43");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(320, 480, 260, 17);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("jLabel44");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(680, 480, 240, 17);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("jLabel45");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(1000, 480, 270, 17);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("jLabel46");
        jPanel1.add(jLabel46);
        jLabel46.setBounds(310, 670, 260, 17);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("jLabel47");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(660, 670, 260, 17);

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("jLabel48");
        jPanel1.add(jLabel48);
        jLabel48.setBounds(1010, 670, 260, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void set_location(){
    
        
    }
    
    
    
      
    String p_location_1 ;
    String p_location_2 ;
    String p_location_3 ;
    String p_location_4 ;
    String p_location_5 ;
    String p_location_6 ;
    String p_location_7 ;
    String p_location_8 ;
    String p_location_9 ;
    String p_location_10 ;
    
    
        
    
    
  

          float set_loacation_count_71  = 2 ;         float set_loacation_count_81 = 2 ;         float  set_loacation_count_1 =2;
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

              
        if( set_loacation_count_1 %2 ==0 ){
          jLabel11.setVisible(true);
            selecttion_count++ ; 
                    if(selecttion_count <= 6 ){
          // System.out.println(selecttion_count) ;
                p_location_1 =  jLabel40.getText();
                set_loacation_count_1 = 5 ;
                    }         
                  else {   
                        set_loacation_count_1 = 5 ;
                    JFrame parent = new JFrame();
                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
 
                                        avg_package_cost= avg_package_cost  + location_cost1 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_1 =  jLabel40.getText();
                          
                       }  
           }
        else if ( set_loacation_count_1 %2 ==1 ) {
             selecttion_count--;
              jLabel11.setVisible(false);
             if(avg_package_cost > package_cost){
            
             avg_package_cost= avg_package_cost  - location_cost1 ;                 
                            if(package_cost  < avg_package_cost){ 
                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                            }
                            else {
                                cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert);                                
                            }
                            }
                          p_location_1 ="";
                          set_loacation_count_1 = 2 ;
               }
        System.out.println(selecttion_count);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked

        
              if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1 || sub_count7==1|| sub_count8==1 || sub_count9==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
                          sub_count7 = 0;
               sub_count8 = 0;
                          sub_count9 = 0;
              
            }
        
        
        
            tour_customer_select_package_2 ll = new tour_customer_select_package_2(cs_date,ce_date,c_mame);
              ll.setVisible(true);
                this.dispose();
            

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
                       if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1 || sub_count7==1|| sub_count8==1 || sub_count9==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
                          sub_count7 = 0;
               sub_count8 = 0;
                          sub_count9 = 0;
              
            }

                       if(selecttion_count>=6){
                       
                       
        tour_customer_select_vehicle lp = new tour_customer_select_vehicle( cs_date,ce_date,avg_package_cost ,c_para ,  c_p_name ,  c_mame ,p_location_1 ,p_location_2 , p_location_3 ,p_location_4 , p_location_5 , p_location_6 , p_location_7 ,p_location_8 ,p_location_9 ,p_location_10) ; 
      lp.setVisible(true);
        this.dispose();

                       }
                       else if (selecttion_count<6){
         JOptionPane.showMessageDialog(null, "You need to add minimum 6 Location .", "Error", JOptionPane.INFORMATION_MESSAGE);
                 }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved

           if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count1==0){    
                     sub_count1 = 1; 
                      
                       sub_package_id = jCheckBox2.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
        
      
        */



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved

              if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1 || sub_count7==1|| sub_count8==1 || sub_count9==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
                          sub_count7 = 0;
               sub_count8 = 0;
                          sub_count9 = 0;
              
            }


        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        
           if(sub_count1 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
           
           /*

          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count2==0){    
                     sub_count2 = 1; 
                      
                       sub_package_id = jCheckBox3.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
        */
      
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved

                
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count3==0){    
                     sub_count3 = 1; 
                      
                       sub_package_id = jCheckBox4.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
        
      */


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseMoved

                  
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count4==0){    
                     sub_count4 = 1; 
                      
                       sub_package_id = jCheckBox5.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
        
      */

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseMoved

    private void jLabel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseMoved

                    
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count5==0){    
                     sub_count5 = 1; 
                      
                       sub_package_id = jCheckBox6.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
      
*/

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseMoved

    private void jLabel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseMoved

                      
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count6==0){    
                     sub_count6 = 1; 
                      
                       sub_package_id = jCheckBox7.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
      
*/
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseMoved

    private void jLabel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseMoved

                        
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count6 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
           /*

          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count7==0){    
                     sub_count7 = 1; 
                      
                       sub_package_id = jLabel46.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
      */

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseMoved

    private void jLabel13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseMoved

                              
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count6 =0 ;
              sub_count7 =0 ;
                sub_count9 =0 ;
              
              
        }

   /*       Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count8==0){    
                     sub_count8 = 1; 
                      
                       sub_package_id = jCheckBox9.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  */

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseMoved

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved

                                    
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count6 =0 ;
              sub_count7 =0 ;
                sub_count8 =0 ;
              
              
        }
           /*

          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count9==0){    
                     sub_count9 = 1; 
                      
                       sub_package_id = jLabel48.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        }

            }, 1000);
      
        try {
            Thread.sleep(1000);
            
            // TODO add your handling code here:
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
  
*/
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel2MouseWheelMoved

        
           if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }

        
      

              
                       if(sub_count1==0){    
                     sub_count1 = 1; 
                      
                       sub_package_id = jLabel40.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseWheelMoved

    private void jLabel7MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel7MouseWheelMoved


           if(sub_count1 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
           
    
                       if(sub_count2==0){    
                     sub_count2 = 1; 
                      
                       sub_package_id = jLabel41.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
    
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseWheelMoved

    private void jLabel4MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel4MouseWheelMoved

                   if(sub_count1 == 1|| sub_count2 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }

      
             
                       if(sub_count3==0){    
                     sub_count3 = 1; 
                      
                       sub_package_id = jLabel42.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
       
      


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseWheelMoved

    private void jLabel5MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel5MouseWheelMoved
                     
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
      
                       if(sub_count4==0){    
                     sub_count4 = 1; 
                      
                       sub_package_id = jLabel43.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
   

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseWheelMoved

    private void jLabel6MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel6MouseWheelMoved
                          
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count6==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count6 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }

 
                       if(sub_count5==0){    
                     sub_count5 = 1; 
                      
                       sub_package_id = jLabel44.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseWheelMoved

    private void jLabel10MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel10MouseWheelMoved

        
                      
           if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count7==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count7 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }


                       if(sub_count6==0){    
                     sub_count6 = 1; 
                      
                       sub_package_id = jLabel45.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseWheelMoved

    private void jLabel12MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel12MouseWheelMoved

                   if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count8==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count6 =0 ;
              sub_count8 =0 ;
                sub_count9 =0 ;
              
              
        }
           

        if(sub_count7==0){    
                     sub_count7 = 1; 
                      
                       sub_package_id = jLabel46.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
  
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseWheelMoved

    private void jLabel13MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel13MouseWheelMoved

                   if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count9==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count6 =0 ;
              sub_count7 =0 ;
                sub_count9 =0 ;
              
              
        }

          
                       if(sub_count8==0){    
                     sub_count8 = 1; 
                      
                       sub_package_id = jLabel47.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
      


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseWheelMoved

    private void jLabel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel1MouseWheelMoved

                 if(sub_count1 == 1|| sub_count2 ==1|| sub_count3==1|| sub_count4==1|| sub_count5==1|| sub_count6==1|| sub_count7==1|| sub_count8==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
                sub_count6 =0 ;
              sub_count7 =0 ;
                sub_count8 =0 ;
              
              
        }
   

                       if(sub_count9==0){    
                     sub_count9 = 1; 
                      
                       sub_package_id = jLabel48.getText(); 
                     sub_frame =   new tour_coustomer_selecte_location_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseWheelMoved
     float  set_loacation_count_2 =2;
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

               if(set_loacation_count_2 % 2 ==0){
             selecttion_count++ ; 
             jLabel14.setVisible(true);
           if(selecttion_count <= 6 ){
        
               set_loacation_count_2 = 5 ;
  //   System.out.println(location_cost2) ;
     // System.out.println(location_2) ;
       p_location_2 =  jLabel41.getText();

           }
           
           else {
                   set_loacation_count_2 = 5 ;
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost2 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_2 =  jLabel41.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_2 %2==1) {
             selecttion_count--;
              jLabel14.setVisible(false);
            if(avg_package_cost > package_cost){
             avg_package_cost= avg_package_cost  - location_cost2 ;  
             if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
             }
             else {
                     cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
             }
             
             
        }
                          p_location_2 ="*";
                           set_loacation_count_2 = 2;
                       
                            
        
    }
        System.out.println(selecttion_count);
      


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked
     float  set_loacation_count_3 =2;
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
                      
                
                  if(  set_loacation_count_3%2 ==0){
                       selecttion_count++ ; 
                        jLabel32.setVisible(true);
                        if(selecttion_count <= 6 ){     
     // System.out.println(selecttion_count) ;
                            set_loacation_count_3 = 5 ;
                             p_location_3 =  jLabel42.getText();
                           }
           
                          else {
                    
                    JFrame parent = new JFrame();
                                         set_loacation_count_3 = 5 ;
                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
                           
                                        avg_package_cost= avg_package_cost  + location_cost3 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_3 =  jLabel42.getText();
                          
                         }
           
    
           }
        else if ( set_loacation_count_3%2 ==1) {
             selecttion_count--;
             jLabel32.setVisible(false);
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost3 ;  
             if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
             }
             else{
              cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
         }
        }
                          p_location_3 ="";
                      set_loacation_count_3 = 2 ;
                            
        
    }
       System.out.println(selecttion_count);
           
    



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked
 float  set_loacation_count_4 =2;
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked


                                
                  if(set_loacation_count_4%2 ==0){
                        selecttion_count++ ; 
                        jLabel33.setVisible(true);
           if(selecttion_count <= 6 ){
               set_loacation_count_4=5 ;
     // System.out.println(selecttion_count) ;
       p_location_4 =  jLabel43.getText();

           }
           
           else {
             
                    JFrame parent = new JFrame();
                    set_loacation_count_4=5 ;
                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost4 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_4 =  jLabel43.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_4%2 ==1) {
             selecttion_count--;
               jLabel33.setVisible(false);
             set_loacation_count_4=2 ;
            if(avg_package_cost > package_cost){
             avg_package_cost= avg_package_cost  - location_cost4 ;  
                
                            if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                         }
                         else {
                     cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
                     }
              }   
                          p_location_4 ="";
                        
                            
        
            }
          System.out.println(selecttion_count);
           
       


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked
    float  set_loacation_count_5 =2;
    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked

        
                      
                  if( set_loacation_count_5  %2 ==0){
                      selecttion_count++ ; 
           if(selecttion_count <= 6 ){
        set_loacation_count_5=5;
        
     // System.out.println(selecttion_count) ;
       p_location_5 =  jLabel44.getText();

           }
           
           else {
                           set_loacation_count_5=5;
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost5 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_5 =  jLabel44.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_5  %2 ==1) {
             selecttion_count--;
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost5 ;  
                if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                }
                else {
                    cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
                }
        }
                          p_location_5 ="";
                       set_loacation_count_5=2;
                            
        
    }
          System.out.println(selecttion_count);
           
       


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36MouseClicked
  float  set_loacation_count_6 =2;
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

                         if(set_loacation_count_6 %2 ==0){
                         selecttion_count++ ; 
                          jLabel37.setVisible(true);
           if(selecttion_count <= 6 ){
     
      set_loacation_count_6=5;
     // System.out.println(selecttion_count) ;
       p_location_6 =  jLabel45.getText();

           }
           
           else {  set_loacation_count_6=5;
                  
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost6 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_6 =  jLabel45.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_6 %2 ==1) {
             selecttion_count--;
             jLabel37.setVisible(false);
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost6 ;  
              if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
              }
              else {
                  cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert);
              }
        }
                          p_location_6 ="";
                            set_loacation_count_6=2;  
        
    }
      
             System.out.println(selecttion_count);
      



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked
    float  set_loacation_count_756 =2;
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        
                      
                  if(set_loacation_count_756 %2 ==0){
                      selecttion_count++ ; 
                        jLabel36.setVisible(true);
           if(selecttion_count <= 6 ){
        
        set_loacation_count_756 = 5 ; 
     // System.out.println(selecttion_count) ;
       p_location_5 =  jLabel44.getText();

           }
           
           else {
                    set_loacation_count_756 = 5 ; 
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost5 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_5 =  jLabel44.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_756 %2 ==1) {
             selecttion_count--;
             jLabel36.setVisible(false);
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost5 ;  
                if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                }
                else {
                    cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
                }
        }
                          p_location_5 ="";
                       set_loacation_count_756 = 2 ; 
                            
        
    }
          System.out.println(selecttion_count);
           
       



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked
    float set_loacation_count_7 = 2  ;
    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
               if(set_loacation_count_7 % 2 == 0){
                    selecttion_count++ ;
                    jLabel31.setVisible(true);
                        if(selecttion_count <= 6 ){
                    
                     set_loacation_count_7=5;
                  // System.out.println(selecttion_count) ;
                    p_location_7 =  jLabel46.getText();

                        }

           else {
                    set_loacation_count_7=5;
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost7 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_7 =  jLabel46.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_7% 2 == 1) {
             selecttion_count--;
             jLabel31.setVisible(false);
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost7 ; 
              if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
              }
              else {
                         cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
              }
        }
                          p_location_7 ="";
                          set_loacation_count_7 = 2 ;
                            
        
    }
          System.out.println(selecttion_count);
           
       



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked
    float set_loacation_count_8 =2;
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
                
                  if(set_loacation_count_8 % 2 == 0){
                        selecttion_count++ ; 
                          jLabel39.setVisible(true);
           if(selecttion_count <= 6 ){
      
        set_loacation_count_8=5;
     // System.out.println(selecttion_count) ;
       p_location_8 =  jLabel47.getText();

           }
           
           else {
                    set_loacation_count_8=5;
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost8 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_8 =  jLabel47.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_8% 2 == 1) {
             selecttion_count--;
               jLabel39.setVisible(false);
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost8 ;
              if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
              }
              else 
              {
                    cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
              }
        }
                          p_location_8 ="";
                          set_loacation_count_8 = 2 ;
                            
        
    }
     System.out.println(selecttion_count);
           
       


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked
    float set_loacation_count_9 = 2 ; 
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      
                  if(set_loacation_count_9 % 2 == 0){
                        selecttion_count++ ;
                         jLabel38.setVisible(true);
                   //    System.out.println(selecttion_count) ;
           if(selecttion_count <= 6 ){
      
        set_loacation_count_9=5;
    // System.out.println(selecttion_count) ;
       p_location_9 =  jLabel48.getText();

           }
           
           else {
                    set_loacation_count_9=5;
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "You can only add 6 Locations,  \n" + " Else it will costs more than the current cost"); 
        
                         
                                        avg_package_cost= avg_package_cost  + location_cost9 ;  
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
                          p_location_9 =  jLabel48.getText();
                          
           }
           
    
           }
        else if (set_loacation_count_9% 2 == 1) {
             selecttion_count--;
              jLabel38.setVisible(false);
         if(avg_package_cost > package_cost){   
             avg_package_cost= avg_package_cost  - location_cost9 ; 
              if(package_cost  < avg_package_cost){ 
                                           cost_covert = Float.toString(avg_package_cost) ;
                          jLabel34.setText(cost_covert); 
              }
              else {
                      cost_covert = Float.toString(package_cost) ;
                          jLabel34.setText(cost_covert); 
              } 
                  
        }
                          p_location_9 ="";
                          set_loacation_count_9 = 2 ;
                            
        
    }
       System.out.println(selecttion_count);

     
    }//GEN-LAST:event_jLabel1MouseClicked

    
    
    public String  image_set(String location_name) {
        
        String   m_path ="C:\\Users\\Akila Sachin\\Desktop\\terra\\FInal Final\\PACKAGE p\\icon\\m5.jpg" ; 
        for(int i = 0 ; i < 10 ; i ++){
            
        
         String sql = " select image   from place where name   like  '"+location_name+"'"  ;
        
        
          try {
              int loopnumber =0;
              Statement stmt = con.createStatement();
              rs = stmt.executeQuery(sql);
              
              
              
             while (rs.next()) {
             
        String  image = rs.getString("image");
          
             if(!"NO".equals(image)){
       m_path = image.replace("@", "//");
        return m_path; 
        
       
        }
             else {
                  return m_path; 
        
             }
        
          
       
             
             
             }
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
            
            
        }
      return m_path; 

    }
    
    
    
    
    public ImageIcon ResiziseImage (String ImagePath){
        ImageIcon myimage=new ImageIcon(ImagePath);
        Image img=myimage.getImage();
        Image newimg=img.getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newimg);
        return image;
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
            java.util.logging.Logger.getLogger(tour_customer_selecte_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tour_customer_selecte_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tour_customer_selecte_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tour_customer_selecte_location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tour_customer_selecte_location().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables
}
