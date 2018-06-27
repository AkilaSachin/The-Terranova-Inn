/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import database.DBconnect;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author acer
 */
public class tour_customer_select_package_details extends javax.swing.JFrame {

    /**
     * Creates new form tour_customer_select_package_details
     */
     Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    
    public tour_customer_select_package_details() {
        initComponents();
    }
    int c_p_id ; 
   String t_cost = "NULL" ;
public tour_customer_select_package_details(int p_id) {
        initComponents();
        con = DBconnect.connect();
        System.out.println(p_id) ; 
        c_p_id = p_id ; 
        table();
        table_location();
        get_cost_location();
        avg_cost();
    }



public void table() {
    
    
        String sql = " select package_ID, name,rate,type,description,image from package where package_ID = '"+c_p_id+"'  "  ;
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
      String job = rs.getString("rate");
         String type =rs.getString("type");
          String description =rs.getString("description");
           String image =rs.getString("image");
        // System.out.println(id + "  " + name+"   "+job);
      
             jLabel3.setText(name);
             jLabel10.setText(type);
             jLabel9.setText(t_cost);
               jLabel5.setText(job);
             jTextArea1.setText(description);
               
             if(!"NO".equals(image)){
       m_path = image.replace("@", "//");
         jLabel1.setIcon(ResiziseImage(m_path));
       
        }
             
             
         
            
            }
            
         }
            catch (SQLException ex) {
           System.out.println(ex);
        }
            
            
          
    
    
    
}

   
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



   
    public void table_location(){
        
        
         String sql = " select id ,location_1,location_2,location_3,location_4,location_5,location_6,location_7,location_8,location_9,location_10  from it160_package_location_history where package_ID   like  '"+c_p_id+"'"  ;
        
        
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
    
    
    
      float avg_package_cost =  0 ; 
    float package_cost ; 
    public void avg_cost(){
        
        
     avg_package_cost =    location_cost1 + location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 +location_cost1 + location_cost1 ; 
        avg_package_cost = (float) (avg_package_cost * 0.70) ; 
        package_cost = avg_package_cost ;
       // System.out.println(avg_package_cost);
       
     
       jLabel9.setText(Float.toString(avg_package_cost) );
         
         
    }
    
    
    
    
    
    public ImageIcon ResiziseImage (String ImagePath){
        ImageIcon myimage=new ImageIcon(ImagePath);
        Image img=myimage.getImage();
        Image newimg=img.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newimg);
        return image;
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
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(150, 280, 30, 70);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Coming Soon ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 10, 160, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Coming Soon");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 320, 90, 20);

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/m5.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 60, 310, 210);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Coming Soon");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 380, 260, 96);

        jLabel6.setText("Description");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(120, 360, 90, 20);

        jLabel7.setText("Rete");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 320, 26, 20);

        jLabel8.setText("Type");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 290, 40, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Coming Soon");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 300, 130, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Coming Soon");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 290, 90, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Cost");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(160, 300, 60, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(tour_customer_select_package_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_package_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_package_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tour_customer_select_package_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tour_customer_select_package_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
