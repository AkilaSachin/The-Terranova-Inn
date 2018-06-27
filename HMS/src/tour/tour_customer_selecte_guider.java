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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import tour.tour_customer_select_vehicle;

/**
 *
 * @author acer
 */
public class tour_customer_selecte_guider extends javax.swing.JFrame {

    /**
     * Creates new form tour_customer_selecte_guider
     */
    
    
       Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 

    
    
    public tour_customer_selecte_guider() {
        initComponents();
        
        con = DBconnect.connect();
       //  table();
          m_path ="C:\\Users\\Akila Sachin\\Desktop\\terra\\FInal Final\\PACKAGE p\\icon\\A.jpg";
          jLabel2.setIcon(ResiziseImage(m_path));
          jLabel4.setIcon(ResiziseImage(m_path));
          jLabel5.setIcon(ResiziseImage(m_path));
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
    float avg_package_cost_t = 0 ; 
    String cost_covert ; 
    String cs_date;
   String ce_date;
   String c_v_number;
   String vehicle_d ; 
   String m_path;
    
      public tour_customer_selecte_guider(String vehicle_driver ,String v_number ,String s_date ,String e_date ,float now_cost , String package_id , String p_name , String c_id , String location_1 , String location_2 , String location_3 ,String location_4 ,String location_5 , String location_6 , String location_7 ,String location_8 ,String location_9 ,String location_10) {
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
     jLabel32.setText(Cp_name);
     vehicle_d = vehicle_driver ;
    
     avg_package_cost = now_cost ; 
        cost_covert = Float.toString(now_cost) ;
                          jLabel9.setText(cost_covert); 
     
                      avg_package_cost_t = avg_package_cost;    
   cs_date =s_date;
         ce_date =e_date;
         c_v_number =v_number ;
        //  table();
            m_path ="C:\\Users\\Akila Sachin\\Desktop\\terra\\FInal Final\\PACKAGE p\\icon\\A.jpg";
          jLabel2.setIcon(ResiziseImage(m_path));
          jLabel4.setIcon(ResiziseImage(m_path));
          jLabel5.setIcon(ResiziseImage(m_path));
           table();
        // System.out.println(vehicle_driver);
    }
    
    
  int   loopnumber = 0 ;
   int   Set_number = 0 ;
  
  String guider_id[] = new String[5];
  String guider_name[] = new String[5];
  String guider_rate[] = new String[5];
  String guider_type[] = new String[5];
  String guider_specilify[] = new String[5];
  String guider_comment[] = new String[5];
  String guider_pat_cost[] = new String[5];
  String select_guider ;
  String p_image[] =  new String[5]; 
  
  
  
     public void table(){
        
        
       //  String sql = " select vehicle_id  from vehicle  "  ;
         //  String sql = " select id ,name ,rate ,type,specilify,comment,pat_cost from  guider"  ;
          String sql =  "SELECT g.id , g.name ,g.rate ,g.type,g.specilify,g.comment,g.pat_cost,g.image  FROM vehicle_booking_date vb , it160_customer_selection_package_2 p , guider g WHERE vb.guider_id NOT IN (SELECT guider_id FROM vehicle_booking_date WHERE in_date BETWEEN '"+cs_date+"' and '"+ce_date+"' ) AND vb.guider_id NOT IN (SELECT guider_id FROM vehicle_booking_date WHERE to_date BETWEEN '"+cs_date+"' and '"+ce_date+"' ) AND p.customer__id = vb.customer_id and g.id = p.guider GROUP BY g.id " ; 
        
          try {
              
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
              
              
              
             while (rs.next()) {
              String guider_id_c  = rs.getString("id");
               String guider_name_c    = rs.getString("name");
                String guider_rate_c    = rs.getString("rate");
                 String guider_type_c    = rs.getString("type");
                  String  guider_specilify_c   = rs.getString("specilify");
                   String guider_comment_c   = rs.getString("comment");
                    String guider_pat_cost_c  = rs.getString("pat_cost");
                     String image  = rs.getString("image");
                  
            
         
            
              if(loopnumber == 0 ){
            
                  guider_id[loopnumber]=guider_id_c;
                   guider_name[loopnumber]=guider_name_c;
                    guider_rate[loopnumber]=guider_rate_c;
                     guider_type[loopnumber]=guider_type_c;
                      guider_specilify[loopnumber]=guider_specilify_c;
                       guider_comment[loopnumber]=guider_comment_c;
                        guider_pat_cost[loopnumber]=guider_pat_cost_c;
                       p_image[loopnumber] = image ; 
                         
                                  
                            
                        
                     // System.out.println( guider_name[loopnumber]);
    
              }
             if(loopnumber == 1 ){
            
                  guider_id[loopnumber]=guider_id_c;
                   guider_name[loopnumber]=guider_name_c;
                    guider_rate[loopnumber]=guider_rate_c;
                     guider_type[loopnumber]=guider_type_c;
                      guider_specilify[loopnumber]=guider_specilify_c;
                       guider_comment[loopnumber]=guider_comment_c;
                        guider_pat_cost[loopnumber]=guider_pat_cost_c;
                          p_image[loopnumber] = image ; 
                       
                          
                   //   System.out.println( guider_name[loopnumber]);
    
              }
              if(loopnumber == 2){
            
                  guider_id[loopnumber]=guider_id_c;
                   guider_name[loopnumber]=guider_name_c;
                    guider_rate[loopnumber]=guider_rate_c;
                     guider_type[loopnumber]=guider_type_c;
                      guider_specilify[loopnumber]=guider_specilify_c;
                       guider_comment[loopnumber]=guider_comment_c;
                        guider_pat_cost[loopnumber]=guider_pat_cost_c;
                          p_image[loopnumber] = image ; 
                       
                 //         System.out.println( guider_name[loopnumber]);
               //     System.out.println(  guider_pat_cost[loopnumber]);
                  //    System.out.println( guider_name[loopnumber]);
    
              }
                if(loopnumber == 3){
            
                  guider_id[loopnumber]=guider_id_c;
                   guider_name[loopnumber]=guider_name_c;
                    guider_rate[loopnumber]=guider_rate_c;
                     guider_type[loopnumber]=guider_type_c;
                      guider_specilify[loopnumber]=guider_specilify_c;
                       guider_comment[loopnumber]=guider_comment_c;
                        guider_pat_cost[loopnumber]=guider_pat_cost_c;
                          p_image[loopnumber] = image ; 
                       
                         
                  
    
              }
                 if(loopnumber == 4){
            
                  guider_id[loopnumber]=guider_id_c;
                   guider_name[loopnumber]=guider_name_c;
                    guider_rate[loopnumber]=guider_rate_c;
                     guider_type[loopnumber]=guider_type_c;
                      guider_specilify[loopnumber]=guider_specilify_c;
                       guider_comment[loopnumber]=guider_comment_c;
                        guider_pat_cost[loopnumber]=guider_pat_cost_c;
                          p_image[loopnumber] = image ; 
                       
                         
                    //  System.out.println( guider_name[loopnumber]);
    
              }
              loopnumber++;
       
             }
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_selecte_location.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
         String all ="all"; 
          String package_name = "kandy";
          
     for (int i = 0 ; i< loopnumber ;i++){
         if((guider_specilify[Set_number].equalsIgnoreCase(all)||guider_specilify[Set_number].equalsIgnoreCase(package_name))&& Set_number ==0 ){
            
               jLabel6.setText(guider_id[Set_number]);
                jLabel14.setText(guider_name[Set_number]);
                jLabel11.setText(guider_rate[Set_number]);
                   jLabel28.setText(guider_type[Set_number]);   
                    jLabel29.setText(guider_specilify[Set_number]);
                    jTextArea2.setText(  guider_comment[Set_number]);
                      jLabel46.setText(  guider_pat_cost[Set_number]);
                        if(!"NO".equals(p_image[Set_number] )){
                             m_path = p_image[Set_number].replace("@", "//");
                               jLabel2.setIcon(ResiziseImage(m_path));

                              }
                            
        }
         if((guider_specilify[Set_number].equalsIgnoreCase(all)||guider_specilify[Set_number].equalsIgnoreCase(package_name))&& Set_number ==1){
            
               jLabel1.setText(guider_id[Set_number]);
                jLabel34.setText(guider_name[Set_number]);
                jLabel13.setText(guider_rate[Set_number]);
                   jLabel36.setText(guider_type[Set_number]);   
                    jLabel40.setText(guider_specilify[Set_number]);
                    jTextArea1.setText(  guider_comment[Set_number]);
                      jLabel52.setText(  guider_pat_cost[Set_number]);
                       if(!"NO".equals(p_image[Set_number] )){
                             m_path = p_image[Set_number].replace("@", "//");
                               jLabel4.setIcon(ResiziseImage(m_path));

                              }
    
          }
            if((guider_specilify[Set_number].equalsIgnoreCase(all)||guider_specilify[Set_number].equalsIgnoreCase(package_name))&& Set_number ==2){
            
               jLabel10.setText(guider_id[Set_number]);
                jLabel56.setText(guider_name[Set_number]);
                jLabel57.setText(guider_rate[Set_number]);
                   jLabel60.setText(guider_type[Set_number]);   
                    jLabel61.setText(guider_specilify[Set_number]);
                    jTextArea3.setText(  guider_comment[Set_number]);
                      jLabel68.setText(  guider_pat_cost[Set_number]);
                       if(!"NO".equals(p_image[Set_number] )){
                             m_path = p_image[Set_number].replace("@", "//");
                               jLabel5.setIcon(ResiziseImage(m_path));

                              }
                     
    
          }
           Set_number++;
          
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
        jSeparator4 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel66 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel80 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel64 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

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
        jLabel15.setText("1");
        jLabel15.setOpaque(true);
        jPanel2.add(jLabel15);
        jLabel15.setBounds(180, 470, 40, 29);

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
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Guider ");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(-10, 510, 130, 29);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Available Location");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(10, 430, 150, 29);

        jLabel22.setBackground(new java.awt.Color(0, 0, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("1");
        jLabel22.setOpaque(true);
        jPanel2.add(jLabel22);
        jLabel22.setBounds(180, 390, 40, 29);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 560, 210, 10);

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Confirm Tour");
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
        jLabel24.setBounds(10, 390, 100, 29);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(0, 370, 100, 10);

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("The");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(10, 10, 170, 20);

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Terrnova");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(30, 40, 220, 40);

        jLabel27.setBackground(new java.awt.Color(0, 0, 204));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("9");
        jLabel27.setOpaque(true);
        jPanel2.add(jLabel27);
        jLabel27.setBounds(180, 430, 40, 29);

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Available Car");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(0, 470, 130, 29);

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Welcome to Terrnova Inn");
        jPanel2.add(jLabel37);
        jLabel37.setBounds(40, 170, 230, 40);

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("We Provide the Best Services in ");
        jPanel2.add(jLabel39);
        jLabel39.setBounds(30, 200, 230, 40);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Negombo");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(80, 230, 80, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 700);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("vehicle 4tos");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(290, 160, 310, 210);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Not Available");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(360, 490, 80, 16);

        jLabel42.setText("Location count   ");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(710, 390, 110, 20);

        jLabel12.setText("Type       ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(280, 520, 70, 20);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Not Available");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(360, 520, 80, 16);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Not Available");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(360, 560, 80, 16);

        jLabel30.setText("Specility");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(280, 560, 60, 20);

        jLabel35.setText("Rate       ");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(280, 490, 70, 20);

        jLabel44.setText(" Cost");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(970, 620, 80, 20);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Not Available");
        jPanel1.add(jLabel46);
        jLabel46.setBounds(340, 590, 100, 30);

        jLabel45.setText("Comment");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(480, 430, 70, 16);

        jLabel38.setBackground(new java.awt.Color(51, 51, 51));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Add Guider");
        jLabel38.setOpaque(true);
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel38);
        jLabel38.setBounds(400, 640, 160, 40);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(960, 180, 10, 520);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jSeparator7);
        jSeparator7.setBounds(620, 190, 10, 520);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("package name");
        jLabel32.setOpaque(true);
        jPanel1.add(jLabel32);
        jLabel32.setBounds(570, 20, 360, 80);

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText(" can only select one Guider at a time ");
        jLabel33.setOpaque(true);
        jPanel1.add(jLabel33);
        jLabel33.setBounds(580, 110, 330, 30);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(1140, 450, 10, 160);

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(102, 102, 102));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("RS:");
        jLabel66.setOpaque(true);
        jPanel1.add(jLabel66);
        jLabel66.setBounds(1080, 60, 50, 30);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("30");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(1140, 60, 110, 30);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("vehicle 4tos");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(640, 160, 310, 210);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Not Available");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(700, 460, 80, 16);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Not Available");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(680, 490, 100, 16);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Not Available");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(700, 520, 80, 16);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Not Available");
        jPanel1.add(jLabel40);
        jLabel40.setBounds(690, 550, 90, 16);

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Not Available");
        jPanel1.add(jLabel52);
        jLabel52.setBounds(700, 580, 80, 16);

        jLabel54.setBackground(new java.awt.Color(51, 51, 51));
        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Add Guider");
        jLabel54.setOpaque(true);
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel54);
        jLabel54.setBounds(710, 640, 160, 40);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("vehicle 4tos");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(980, 160, 310, 210);

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("Not Available");
        jPanel1.add(jLabel56);
        jLabel56.setBounds(1050, 460, 80, 16);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Not Available");
        jPanel1.add(jLabel57);
        jLabel57.setBounds(1040, 490, 90, 20);

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setText("Not Available");
        jPanel1.add(jLabel60);
        jLabel60.setBounds(1048, 530, 80, 16);

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel61.setText("Not Available");
        jPanel1.add(jLabel61);
        jLabel61.setBounds(1050, 570, 80, 16);

        jLabel65.setBackground(new java.awt.Color(51, 51, 51));
        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Add Guider");
        jLabel65.setOpaque(true);
        jLabel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel65MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel65);
        jLabel65.setBounds(1080, 640, 160, 40);

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setText("Not Available");
        jPanel1.add(jLabel68);
        jLabel68.setBounds(1040, 600, 90, 16);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator8);
        jSeparator8.setBounds(1040, 10, 20, 130);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(800, 450, 140, 160);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(460, 450, 130, 160);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator9);
        jSeparator9.setBounds(510, 10, 20, 130);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator10);
        jSeparator10.setBounds(790, 450, 10, 160);

        jLabel80.setText("comment");
        jPanel1.add(jLabel80);
        jLabel80.setBounds(830, 430, 70, 16);

        jLabel85.setText("comment");
        jPanel1.add(jLabel85);
        jLabel85.setBounds(1180, 430, 70, 16);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(1150, 450, 140, 160);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "1", "2", "3", "4", "5", "6", "7", "8", "9", " " }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(820, 390, 64, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "1", "2", "3", "4", "5", "6", "7", "8", "9", " " }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(440, 390, 70, 22);

        jLabel49.setText("Location count   ");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(330, 390, 110, 20);

        jLabel50.setText("Location count   ");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(1050, 390, 110, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "1", "2", "3", "4", "5", "6", "7", "8", "9", " " }));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(1150, 390, 64, 22);

        jLabel1.setText("Not Available");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(700, 430, 80, 16);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setText("Name        ");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Not Available");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(280, 450, 160, 30);

        jLabel6.setText("Not Available");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(350, 430, 90, 16);

        jLabel7.setText("ID");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(300, 430, 30, 16);

        jLabel10.setText("Not Available");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(1050, 420, 80, 16);

        jLabel55.setText("ID");
        jPanel1.add(jLabel55);
        jLabel55.setBounds(980, 420, 30, 16);

        jLabel58.setText("Name        ");
        jPanel1.add(jLabel58);
        jLabel58.setBounds(970, 460, 70, 20);

        jLabel59.setText("Rate       ");
        jPanel1.add(jLabel59);
        jLabel59.setBounds(970, 490, 70, 20);

        jLabel62.setText("Type       ");
        jPanel1.add(jLabel62);
        jLabel62.setBounds(970, 530, 70, 20);

        jLabel63.setText("Specility");
        jPanel1.add(jLabel63);
        jLabel63.setBounds(970, 570, 60, 20);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator11);
        jSeparator11.setBounds(450, 450, 10, 160);

        jLabel64.setText("one location ");
        jPanel1.add(jLabel64);
        jLabel64.setBounds(970, 590, 80, 40);

        jLabel67.setText("one location ");
        jPanel1.add(jLabel67);
        jLabel67.setBounds(630, 570, 80, 40);

        jLabel69.setText("Rate       ");
        jPanel1.add(jLabel69);
        jLabel69.setBounds(630, 490, 70, 20);

        jLabel70.setText("Type       ");
        jPanel1.add(jLabel70);
        jLabel70.setBounds(630, 520, 70, 20);

        jLabel75.setText("Specility");
        jPanel1.add(jLabel75);
        jLabel75.setBounds(630, 550, 60, 20);

        jLabel79.setText("Name        ");
        jPanel1.add(jLabel79);
        jLabel79.setBounds(630, 460, 70, 20);

        jLabel84.setText("ID");
        jPanel1.add(jLabel84);
        jLabel84.setBounds(640, 430, 30, 16);

        jLabel48.setText("one location ");
        jPanel1.add(jLabel48);
        jLabel48.setBounds(280, 594, 90, 16);

        jLabel51.setText(" Cost");
        jPanel1.add(jLabel51);
        jLabel51.setBounds(280, 610, 80, 20);

        jLabel53.setText(" Cost");
        jPanel1.add(jLabel53);
        jLabel53.setBounds(630, 600, 80, 20);

        jLabel31.setBackground(new java.awt.Color(51, 51, 51));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Back ");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel31);
        jLabel31.setBounds(290, 30, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
float tem_cost ;
   String last_guider_id = "null" ; 
   int guider_set_1 = 2 ; 
    int guider_set_2 = 2 ; 
     int guider_set_3 = 2 ; 
    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
  jLabel54.setBackground(new Color(51,51,51));
    jLabel65.setBackground(new Color(51,51,51));
          guider_set_2 = 2 ; 
    guider_set_3 = 2 ; 
        if( guider_set_1 % 2 == 0) {
            guider_set_1 = 5 ;
          jLabel38.setBackground(new Color(90, 120, 183));
        String loaction_guide_count_string = jComboBox2.getSelectedItem().toString();
                last_guider_id = jLabel6.getText();
            
                
            
                if(loaction_guide_count_string.equals("all")) {
                                                int temp_cost = (int) ((Integer.parseInt(guider_pat_cost[0]))*7);

                                             tem_cost = avg_package_cost + temp_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 


                    }
                else {
                    
                   int loaction_guide_count_int = Integer.parseInt(loaction_guide_count_string);
                     int temp_cost = (int) ((Integer.parseInt(guider_pat_cost[0]))*loaction_guide_count_int);
                      tem_cost = avg_package_cost + temp_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 

                } 
        
        }
        else if (guider_set_1% 2 == 1) {
            guider_set_1 = 2 ;
            jLabel38.setBackground(new Color(51,51,51));
            avg_package_cost = avg_package_cost_t;
              tem_cost = avg_package_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 
            
        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked

           
           if(c_v_number==null){
               c_v_number = "no" ; 
           }
           
        //   System.out.println(cs_date);
        tour_customer_select_vehicle  laspppp = new tour_customer_select_vehicle (c_v_number,cs_date,ce_date, avg_package_cost ,Cpackage_id ,  Cp_name ,  Cc_id ,Clocation_1 ,Clocation_2 , Clocation_3 ,Clocation_4 , Clocation_5 , Clocation_6 , Clocation_7 ,Clocation_8 ,Clocation_9 ,Clocation_10) ; 
      laspppp.setVisible(true);
        this.dispose();

      

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
 jLabel38.setBackground(new Color(51,51,51));
    jLabel65.setBackground(new Color(51,51,51));
         guider_set_1 = 2 ; 
    guider_set_3 = 2 ; 
        if(guider_set_2 %2 == 0){
            jLabel54.setBackground(new Color(90, 120, 183));
            guider_set_2 =5 ;
        String loaction_guide_count_string = jComboBox1.getSelectedItem().toString();
                last_guider_id = jLabel1.getText();
            
                
            
                if(loaction_guide_count_string.equals("all")) {
                                                int temp_cost = (int) ((Integer.parseInt(guider_pat_cost[1]))*7);

                                             tem_cost = avg_package_cost + temp_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 


                    }
                else {
                    
                   int loaction_guide_count_int = Integer.parseInt(loaction_guide_count_string);
                     int temp_cost = (int) ((Integer.parseInt(guider_pat_cost[1]))*loaction_guide_count_int);
                      tem_cost = avg_package_cost + temp_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 

                } 
        
        
        }
        
        else if (guider_set_2% 2 == 1) {
             guider_set_2 =2 ;
             
               
            jLabel54.setBackground(new Color(51,51,51));
            avg_package_cost = avg_package_cost_t;
              tem_cost = avg_package_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 
             
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jLabel65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel65MouseClicked
jLabel38.setBackground(new Color(51,51,51));
    jLabel54.setBackground(new Color(51,51,51));
         guider_set_2 = 2 ; 
    guider_set_1 = 2 ; 
        if(guider_set_3%2 == 0){
             jLabel65.setBackground(new Color(90, 120, 183));
            guider_set_3 =5 ;
                    System.out.println(guider_pat_cost[2]);
        
        String loaction_guide_count_string = jComboBox3.getSelectedItem().toString();
                last_guider_id = jLabel10.getText();
            
                
            
                if(loaction_guide_count_string.equals("all")) {
                                                int temp_cost = (int) ((Integer.parseInt(guider_pat_cost[2]))*7);

                                             tem_cost = avg_package_cost + temp_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 


                    }
                else {
                    
                   int loaction_guide_count_int = Integer.parseInt(loaction_guide_count_string);
                     int temp_cost = (int) ((Integer.parseInt(guider_pat_cost[2]))*loaction_guide_count_int);
                      tem_cost = avg_package_cost + temp_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 

                } 
        
        }
        
         else if (guider_set_3% 2 == 1) {
             
             
             
                guider_set_3 = 2 ;
            jLabel65.setBackground(new Color(51,51,51));
            avg_package_cost = avg_package_cost_t;
              tem_cost = avg_package_cost ;

                                                 cost_covert = Float.toString(tem_cost) ;
                                               jLabel9.setText(cost_covert); 
             
         }


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel65MouseClicked

     
  /*
    String Cpackage_id ;
    String Cp_name ;
    String Cc_id ;
    float avg_package_cost = 0 ; 
    */
    String get_last_cost ; 
    int tem1 =5  ;
    int tem = 6  ; 
    
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

            if(null==c_v_number)
      {
           JOptionPane.showMessageDialog(null, "Please Add Vehecli ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
        
            else{
        
        JOptionPane.showMessageDialog(null, "Tour Add SuccesFull.", "SuccesFull", JOptionPane.INFORMATION_MESSAGE);
     get_last_cost=   jLabel9.getText();
      
             try {
            String sql= "INSERT INTO 160_customer_select_package_1 (package_id ,customer_id ,location_1 ,location_2,location_3,location_4,location_5,location_6,location_7,location_8,location_9,location_10 ) values ('"+Cpackage_id+"','"+Cc_id+"','"+Clocation_1+"','"+Clocation_2+"','"+Clocation_3+"','"+Clocation_4+"','"+Clocation_5+"','"+Clocation_6+"','"+Clocation_7+"','"+Clocation_8+"','"+Clocation_9+"','"+Clocation_10+"')";
            pst =con.prepareStatement(sql);
            pst.execute();

           
            // TODO add your handling code here:
        } catch (SQLException ex) {
           System.out.println(ex);
        }


              
             try {
            String sql= "INSERT INTO it160_customer_selection_package_2 (customer__id  ,package_id ,vehicle_id  ,guider,A_cost  ) values ('"+Cc_id+"','"+Cpackage_id+"','"+c_v_number+"','"+last_guider_id+"','"+get_last_cost+"')";
            pst =con.prepareStatement(sql);
            pst.execute();

           
            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);
        }

            
             try {
            String sql= "INSERT INTO vehicle_booking_date (vehicle_id   ,in_date  ,to_date   ,customer_id,drive_l ,guider_id   ) values ('"+c_v_number+"','"+cs_date+"','"+ce_date+"','"+Cc_id+"','"+vehicle_d+"' , '"+last_guider_id+"')";
            pst =con.prepareStatement(sql);
            pst.execute();

           
            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);
        }

            }


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked
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
            java.util.logging.Logger.getLogger(tour_customer_selecte_guider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tour_customer_selecte_guider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tour_customer_selecte_guider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tour_customer_selecte_guider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tour_customer_selecte_guider().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
