/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import database.DBconnect;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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



public class tour_customer_select_package_2 extends javax.swing.JFrame {

    
    
      Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    
    /**
     * Creates new form tour_customer_select_package_2
     */
    public tour_customer_select_package_2() {
        initComponents();
        
         con = DBconnect.connect();
          
           image_set();
           table();
        
              // set values 
              
         tour_customer_oop le = new tour_customer_oop();
         jLabel15.setText(le.table2_car());
         
           jLabel22.setText(le.set_location_count());
            jLabel9.setText(le.set_guider_count());
       
        
    }
    int sub_package_id ;
    int sub_count1 = 0 ; 
        int sub_count2 = 0 ; 
            int sub_count3 = 0 ;     
            int sub_count4= 0 ; 
                int sub_count5= 0 ; 
                int sub_count6= 0 ; 
                
            
    tour_customer_select_package_details sub_frame ;
    
    
    
    
     public tour_customer_select_package_2(String s_date ,String e_date ,String c_name) {
        initComponents();
         image_set();
         con = DBconnect.connect();
          table();
          jTextField2.setText(c_name);
         
          
             Date date1;  
              Date date2; 
          try {
              date1 = new SimpleDateFormat("yyyy-MM-dd").parse(s_date);
              jCalendarComboBox1.setDate(date1);
              date2 = new SimpleDateFormat("yyyy-MM-dd").parse(e_date);
              jCalendarComboBox2.setDate(date2);
          } catch (ParseException ex) {
              Logger.getLogger(tour_customer_select_package_2.class.getName()).log(Level.SEVERE, null, ex);
          }
      
        
          
          
          
          // set values 
           tour_customer_oop le = new tour_customer_oop();
         jLabel15.setText(le.table2_car());
          jLabel22.setText(le.set_location_count());
          jLabel9.setText(le.set_guider_count());
          
    
        
    }
    
    
    
       int package_number_0 ;
        int package_number_1 ;
        int package_number_2 ;
        int package_number_3 ;
       int package_number_4 ;
       int package_number_5 ;
       String p_name ; 
       String c_id ; 
        
       public void image_set(){
           
         String    m_path ="C:\\Users\\Akila Sachin\\Desktop\\terra\\FInal Final\\PACKAGE p\\icon\\m5.jpg";
          jLabel2.setIcon(ResiziseImage(m_path));
           jLabel3.setIcon(ResiziseImage(m_path));
            jLabel4.setIcon(ResiziseImage(m_path));
             jLabel5.setIcon(ResiziseImage(m_path));
              jLabel6.setIcon(ResiziseImage(m_path));
               jLabel1.setIcon(ResiziseImage(m_path));
           
           
       } 
       
       
       
      
    public void table()   {
        
        String sql = " select package_ID, name,rate,type,description,image  from package "  ;
       String m_path ; 
      
              
            try{
                
                
                int loopnumber =0;
                 Statement stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
          
           // pst = con.prepareStatement(sql);
           // rs = pst.executeQuery();
            
           
            
            while (rs.next()) {
         int id = rs.getInt("package_ID");
         String name = rs.getString("name");
         int job = rs.getInt("rate");
         String type =rs.getString("type");
          String description =rs.getString("description");
           String image =rs.getString("image");
       
      
                if(loopnumber==0){
                    package_number_0 = id ;
                    jLabel10.setText(name);
                    
                    if(!"NO".equals(image)){
                         System.out.println(image);
                            m_path = image.replace("@", "//");
                               jLabel2.setIcon(ResiziseImage(m_path));
       
                                   }

                    }
                if(loopnumber==1){
                    package_number_1 = id ;
                    c.setText(name);
                    
                     if(!"NO".equals(image)){
                            m_path = image.replace("@", "//");
                               jLabel3.setIcon(ResiziseImage(m_path));
       
                                      }
                    
                    
                    
                    }
                if(loopnumber==2){
                    package_number_2 = id ;
                    jLabel12.setText(name);
                    
                     
                     if(!"NO".equals(image)){
                            m_path = image.replace("@", "//");
                               jLabel4.setIcon(ResiziseImage(m_path));
       
                                      }
                    
                    
                    }
                if(loopnumber==3){
                    package_number_3 = id ;
                    jLabel13.setText(name);
                    
                    if(!"NO".equals(image)){
                            m_path = image.replace("@", "//");
                               jLabel5.setIcon(ResiziseImage(m_path));
       
                                      }
                    
                    
                    
                    
                    }
                if(loopnumber==4){
                    package_number_4 = id ;
                    jLabel7.setText(name);
                    
                    if(!"NO".equals(image)){
                            m_path = image.replace("@", "//");
                               jLabel6.setIcon(ResiziseImage(m_path));
       
                                      }
                    
                    
                    
                    }
                if(loopnumber==5){
                    package_number_5 = id ;
                    jLabel11.setText(name);
                    
                    if(!"NO".equals(image)){
                            m_path = image.replace("@", "//");
                               jLabel1.setIcon(ResiziseImage(m_path));
       
                                      }
                    
                    
                    }
                loopnumber++;
         
            
            }
            
         }
            catch (SQLException ex) {
          //  System.out.println(ex);
        }
            
            
            
      
        
    }
    
        int vehicle_avalable_count  = 0 ; 
 

    
    int location_avalable_count = 0 ; 
    public void set_location_count(){
        
        
             
        String sql = " select place_id from place" ; 
        
        
        
             
                int loopnumber =0;
                 Statement stmt;
          try {
              stmt = con.createStatement();
              rs = stmt.executeQuery(sql);
              
              
              while (rs.next()) {
                  
                   String count = rs.getString("place_id");
                  location_avalable_count++ ; 
                  
              }
          //    System.out.println(location_avalable_count);
              
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_select_package_2.class.getName()).log(Level.SEVERE, null, ex);
          }
            String numberAsString_0 = Integer.toString(location_avalable_count);
             jLabel22.setText(numberAsString_0);
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
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
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jCalendarComboBox1 = new de.wannawork.jcalendar.JCalendarComboBox();
        jCalendarComboBox2 = new de.wannawork.jcalendar.JCalendarComboBox();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Coming Soon");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(320, 410, 240, 30);

        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Coming Soon");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(330, 660, 220, 30);

        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Coming Soon");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(980, 410, 260, 30);

        jLabel11.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Coming Soon ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(1060, 650, 200, 40);

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Coming Soon");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(700, 660, 210, 30);

        c.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        c.setForeground(new java.awt.Color(102, 102, 102));
        c.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c.setText("Coming Soon");
        jPanel1.add(c);
        c.setBounds(660, 410, 240, 30);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText(" use mouse wheel to get more details about the package");
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
        jLabel1.setBounds(950, 450, 310, 200);

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setToolTipText("\n use mouse wheel to get more details about the package");
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
        jLabel2.setBounds(280, 190, 310, 210);

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setToolTipText(" use mouse wheel to get more details about the package");
        jLabel3.setOpaque(true);
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel3MouseWheelMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(610, 190, 310, 210);

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setToolTipText(" use mouse wheel to get more details about the package");
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
        jLabel4.setBounds(950, 190, 310, 210);

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setToolTipText(" use mouse wheel to get more details about the package");
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
        jLabel5.setBounds(280, 450, 310, 200);

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setToolTipText(" use mouse wheel to get more details about the package");
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
        jLabel6.setBounds(620, 450, 310, 210);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(830, 10, 10, 150);

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Customer ID");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(830, 20, 170, 40);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(1030, 20, 200, 30);

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText(" selection steps again.");
        jLabel29.setOpaque(true);
        jPanel1.add(jLabel29);
        jLabel29.setBounds(410, 120, 240, 30);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText(" Can only select one package at a time ");
        jLabel31.setOpaque(true);
        jPanel1.add(jLabel31);
        jLabel31.setBounds(360, 60, 330, 30);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText(" to select more than one packages do the ");
        jLabel30.setOpaque(true);
        jPanel1.add(jLabel30);
        jLabel30.setBounds(350, 90, 360, 30);

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("End Date ");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(860, 100, 110, 30);

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
        jLabel15.setBounds(180, 450, 40, 29);

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Inn");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(100, 110, 170, 20);

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Dashboard");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(30, 290, 170, 29);

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Guider ");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(10, 490, 80, 29);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Available Location");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(10, 410, 150, 29);

        jLabel22.setBackground(new java.awt.Color(0, 0, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("42");
        jLabel22.setOpaque(true);
        jPanel2.add(jLabel22);
        jLabel22.setBounds(180, 410, 40, 29);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 560, 210, 10);

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("contact us");
        jLabel23.setOpaque(true);
        jPanel2.add(jLabel23);
        jLabel23.setBounds(40, 610, 130, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setOpaque(true);
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 600, 150, 50);

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Packages");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(10, 370, 100, 29);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(0, 340, 100, 10);

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("The");
        jPanel2.add(jLabel33);
        jLabel33.setBounds(0, 30, 170, 20);

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Terrnova");
        jPanel2.add(jLabel34);
        jLabel34.setBounds(20, 60, 220, 40);

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Available Car");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(0, 450, 130, 29);

        jLabel9.setBackground(new java.awt.Color(0, 0, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("?");
        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9);
        jLabel9.setBounds(180, 490, 40, 30);

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("We Provide the Best Services in ");
        jPanel2.add(jLabel37);
        jLabel37.setBounds(30, 200, 230, 40);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Negombo");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(80, 230, 80, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 700);

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Start Date ");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(860, 60, 110, 30);

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 204, 204));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Welcome to Terrnova Inn");
        jPanel1.add(jLabel38);
        jLabel38.setBounds(40, 170, 230, 40);

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Welcome to Terrnova Inn");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(360, 20, 350, 40);
        jPanel1.add(jCalendarComboBox1);
        jCalendarComboBox1.setBounds(1030, 65, 200, 30);
        jPanel1.add(jCalendarComboBox2);
        jCalendarComboBox2.setBounds(1030, 100, 200, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked


            tour_customer_selecte_location me2  = new tour_customer_selecte_location();
            
                me2.setVisible(true);
                this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
            
        /// sub frame close
               if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
            }
            
        
        
        /*String s_date = jTextField3.getText() ;
         String e_date  =jTextField4.getText();*/
        String temp = jTextField2.getText();
        
            if(temp.isEmpty() )
      {
           JOptionPane.showMessageDialog(null, "Please enter Customer ID", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(!temp.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Customer ID should have 4 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
      else if( !validcustomer(temp)) {
          JOptionPane.showMessageDialog(null, "Invalid Customer ID ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
        
      else {
                    SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String s_date=myformat1.format(jCalendarComboBox1.getDate());
                     SimpleDateFormat myformat2=new SimpleDateFormat("yyyy-MM-dd");
                  String e_date=myformat2.format(jCalendarComboBox2.getDate());
                    
      //              mystatement.setString(4, dod);
        
        
         if("".equals(jTextField2.getText()) || " ".equals(jTextField2.getText()) ){     
        
        
         

             
                    JFrame parent = new JFrame();

                     JOptionPane.showMessageDialog(parent, "If you need to select a location  ... \n" + "pleas Enter your  coustomer id ");  
        
            

                    
         }
         
         else {
                    
                        if(jLabel10.getText()=="Coming Soon"){
                             JFrame parent = new JFrame();
                              JOptionPane.showMessageDialog(parent, "This Package not Available");  
                        }
                        else{
             
                                       c_id = jTextField2.getText() ; 
                                      p_name = jLabel10.getText();
                                     tour_customer_selecte_location me2  = new tour_customer_selecte_location(s_date,e_date,package_number_0 ,p_name,c_id);
                      //  System.out.println(package_number_0);
                                        me2.setVisible(true);
                                        this.dispose();
                        }
         }
                
      }      
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
            
        /// sub frame close
               if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
            }
            
        
        

 SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String s_date=myformat1.format(jCalendarComboBox1.getDate());
                     SimpleDateFormat myformat2=new SimpleDateFormat("yyyy-MM-dd");
                  String e_date=myformat2.format(jCalendarComboBox2.getDate());
      String temp = jTextField2.getText();    
          
            if(temp.isEmpty() )
      {
           JOptionPane.showMessageDialog(null, "Please enter Customer ID", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(!temp.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Customer ID should have 4 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
      else if( !validcustomer(temp)) {
          JOptionPane.showMessageDialog(null, "Invalid Customer ID ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
         
         else {
                         if(c.getText()=="Coming Soon"){
                             JFrame parent = new JFrame();
                              JOptionPane.showMessageDialog(parent, "This Package not Available");  
                        }
                         else {
                                        c_id = jTextField2.getText() ; 
                                      p_name = c.getText();
                                tour_customer_selecte_location me2  = new tour_customer_selecte_location(s_date,e_date,package_number_1 ,p_name,c_id);
                      //  System.out.println(package_number_0);
                           me2.setVisible(true);
                           this.dispose();
                         }
             
         }


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

                    
        /// sub frame close
               if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
            }
             String temp = jTextField2.getText();
        
        SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String s_date=myformat1.format(jCalendarComboBox1.getDate());
                     SimpleDateFormat myformat2=new SimpleDateFormat("yyyy-MM-dd");
                  String e_date=myformat2.format(jCalendarComboBox2.getDate());
                  
           if(temp.isEmpty() )
      {
           JOptionPane.showMessageDialog(null, "Please enter Customer ID", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(!temp.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Customer ID should have 4 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
      else if( !validcustomer(temp)) {
          JOptionPane.showMessageDialog(null, "Invalid Customer ID ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
         
         else {
             if(jLabel12.getText()=="Coming Soon"){
                             JFrame parent = new JFrame();
                              JOptionPane.showMessageDialog(parent, "This Package not Available");  
                        }
                         else {

                                        c_id = jTextField2.getText() ; 
                                      p_name = jLabel12.getText();
                                tour_customer_selecte_location me2  = new tour_customer_selecte_location(s_date,e_date,package_number_2 ,p_name,c_id);
                     //   System.out.println(package_number_0);
                           me2.setVisible(true);
                           this.dispose();
             }
             
         }




        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

                    
        /// sub frame close
               if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
            }
            
        
        SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String s_date=myformat1.format(jCalendarComboBox1.getDate());
                     SimpleDateFormat myformat2=new SimpleDateFormat("yyyy-MM-dd");
                  String e_date=myformat2.format(jCalendarComboBox2.getDate());
               String temp = jTextField2.getText();    
        if(temp.isEmpty() )
      {
           JOptionPane.showMessageDialog(null, "Please enter Customer ID", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(!temp.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Customer ID should have 4 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
      else if( !validcustomer(temp)) {
          JOptionPane.showMessageDialog(null, "Invalid Customer ID ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
         
         else {
                if(jLabel13.getText()=="Coming Soon"){
                             JFrame parent = new JFrame();
                              JOptionPane.showMessageDialog(parent, "This Package not Available");  
                        }
                        else{
             
                                        c_id = jTextField2.getText() ; 
                                      p_name = jLabel13.getText();
                                tour_customer_selecte_location me2  = new tour_customer_selecte_location(s_date,e_date,package_number_3 ,p_name,c_id);
                     //   System.out.println(package_number_0);
                           me2.setVisible(true);
                           this.dispose();
                }

         }



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

                    
        /// sub frame close
               if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
            }
            
        
        SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String s_date=myformat1.format(jCalendarComboBox1.getDate());
                     SimpleDateFormat myformat2=new SimpleDateFormat("yyyy-MM-dd");
                  String e_date=myformat2.format(jCalendarComboBox2.getDate());
        String temp = jTextField2.getText();
           if(temp.isEmpty() )
      {
           JOptionPane.showMessageDialog(null, "Please enter Customer ID", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(!temp.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Customer ID should have 4 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
      else if( !validcustomer(temp)) {
          JOptionPane.showMessageDialog(null, "Invalid Customer ID ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
         
         else {
                   if(jLabel7.getText()=="Coming Soon"){
                             JFrame parent = new JFrame();
                              JOptionPane.showMessageDialog(parent, "This Package not Available");  
                        }
             
                   else{             c_id = jTextField2.getText() ; 
                                      p_name = jLabel7.getText();
                                tour_customer_selecte_location me2  = new tour_customer_selecte_location(s_date,e_date,package_number_4 ,p_name,c_id);
                     //   System.out.println(package_number_0);
                           me2.setVisible(true);
                           this.dispose();
                   }
             
         }


            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
            
        /// sub frame close
               if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
            }
            
        
        
        
SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String s_date=myformat1.format(jCalendarComboBox1.getDate());
                     SimpleDateFormat myformat2=new SimpleDateFormat("yyyy-MM-dd");
                  String e_date=myformat2.format(jCalendarComboBox2.getDate());
                   String temp = jTextField2.getText();
          if(temp.isEmpty() )
      {
           JOptionPane.showMessageDialog(null, "Please enter Customer ID", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(!temp.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Customer ID should have 4 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
      else if( !validcustomer(temp)) {
          JOptionPane.showMessageDialog(null, "Invalid Customer ID ", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
         
         else {
                        
                if(jLabel11.getText()=="Coming Soon "){
                             JFrame parent = new JFrame();
                              JOptionPane.showMessageDialog(parent, "This Package not Available");  
                        }
                        else{
                                    c_id = jTextField2.getText() ; 
                                  p_name = jLabel11.getText();
                            tour_customer_selecte_location me2  = new tour_customer_selecte_location(s_date,e_date,package_number_5 ,p_name,c_id);
                 //   System.out.println(package_number_0);
                       me2.setVisible(true);
                       this.dispose();
                }
             
         }


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
         
        if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }
 /*  
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count1==0){    
                     sub_count1 = 1; 
                      
                     sub_package_id = package_number_0 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
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

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved

                if(sub_count1 == 1 || sub_count3 ==1|| sub_count4==1 || sub_count5==1 || sub_count6==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count2==0){    
                     sub_count2 = 1; 
                      
                       sub_package_id = package_number_1 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
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
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
          if(sub_count1 ==  1 || sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1 || sub_count6==1){
           sub_frame.  dispose(); 
            
        sub_count1 = 0;
        sub_count2 = 0;
        sub_count3 = 0;
           sub_count4 = 0;
             sub_count5 = 0;
               sub_count6 = 0;
                sub_frame.  dispose(); 
      }
         
            
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved



                      if(sub_count1 == 1 || sub_count2 ==1|| sub_count4==1 || sub_count5==1 || sub_count6==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count3==0){    
                     sub_count3 = 1; 
                      
                       sub_package_id = package_number_2 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
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

        

                      if(sub_count1 == 1 || sub_count2 ==1|| sub_count3==1 || sub_count5==1 || sub_count6==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count4==0){    
                     sub_count4 = 1; 
                      
                       sub_package_id = package_number_3 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
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

               if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count1==1|| sub_count6==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count1 =0 ;
              sub_count6 =0 ;
        }

      /*    Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count5==0){    
                     sub_count5 = 1; 
                      
                       sub_package_id = package_number_4 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
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

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved


          if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count1==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count1 =0 ;
        }
/*
          Timer timer = new Timer();
        timer.schedule(new TimerTask() {

              public void run() {
                       if(sub_count6==0){    
                     sub_count6 = 1; 
                      
                       sub_package_id = package_number_5 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
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

         if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count6==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }

       

             
                       if(sub_count1==0){    
                     sub_count1 = 1; 
                      
                     sub_package_id = package_number_0 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
  
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseWheelMoved

    private void jLabel3MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel3MouseWheelMoved

                if(sub_count1 == 1 || sub_count3 ==1|| sub_count4==1 || sub_count5==1 || sub_count6==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }

          
        

             
                       if(sub_count2==0){    
                     sub_count2 = 1; 
                      
                       sub_package_id = package_number_1 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseWheelMoved

    private void jLabel4MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel4MouseWheelMoved

        
                      if(sub_count1 == 1 || sub_count2 ==1|| sub_count4==1 || sub_count5==1 || sub_count6==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }

    
                       if(sub_count3==0){    
                     sub_count3 = 1; 
                      
                       sub_package_id = package_number_2 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
                    
    

            
      
      

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseWheelMoved

    private void jLabel5MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel5MouseWheelMoved
            
                      if(sub_count1 == 1 || sub_count2 ==1|| sub_count3==1 || sub_count5==1 || sub_count6==1){
              sub_frame.  dispose();
              sub_count1 =0 ;
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count5 =0 ;
              sub_count6 =0 ;
        }

                       if(sub_count4==0){    
                     sub_count4 = 1; 
                      
                       sub_package_id = package_number_3 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
    
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseWheelMoved

    private void jLabel6MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel6MouseWheelMoved



               if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count1==1|| sub_count6==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count1 =0 ;
              sub_count6 =0 ;
        }

         
   

           
                       if(sub_count5==0){    
                     sub_count5 = 1; 
                      
                       sub_package_id = package_number_4 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseWheelMoved

    private void jLabel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel1MouseWheelMoved
        
        
          if(sub_count2 == 1|| sub_count3 ==1|| sub_count4==1|| sub_count5==1|| sub_count1==1){
              sub_frame.  dispose();
              sub_count2 =0 ;
              sub_count3 =0 ;
              sub_count4 =0 ;
              sub_count5 =0 ;
              sub_count1 =0 ;
        }

   
                       if(sub_count6==0){    
                     sub_count6 = 1; 
                      
                       sub_package_id = package_number_5 ; 
                     sub_frame =   new tour_customer_select_package_details(sub_package_id);
                     sub_frame.setVisible(true);
                       }
 
      

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseWheelMoved

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed

       

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyPressed

    
    
    public ImageIcon ResiziseImage (String ImagePath){
        ImageIcon myimage=new ImageIcon(ImagePath);
        Image img=myimage.getImage();
        Image newimg=img.getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newimg);
        return image;
    }
    public boolean validcustomer(String cid){
          boolean valid = false ; 
        try {
             
              String sql = "select fname  from customer  where 	customerID = '"+cid+"'" ;
              Statement stmt;
              stmt = con.createStatement();
              rs = stmt.executeQuery(sql);
              
              while (rs.next()) {
                 String id = rs.getString("fname");
                  if(!id.isEmpty()){
                      valid = true ; 
                  }
              }
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_select_package_2.class.getName()).log(Level.SEVERE, null, ex);
          }
         
    
        return valid  ; 
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
            java.util.logging.Logger.getLogger(tour_customer_select_package_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_package_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_package_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_package_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tour_customer_select_package_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendarComboBox1;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendarComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
