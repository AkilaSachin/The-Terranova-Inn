/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

import database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class tour_customer_oop extends tour_customer_abstract{
    
    
    
      Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    int vehicle_avalable_count =0;
    int location_avalable_count = 0 ; 
    int loopnumber =0;
   int  guider_avalable_count = 0 ; 
    
    
    
    
     
    
    
    
    public String  table2_car() {
        
         con = DBconnect.connect();
        
        String sql = " select vehicle_id from vehicle" ; 
        
          con = DBconnect.connect();
        
             
                int loopnumber =0;
                 Statement stmt;
          try {
              stmt = con.createStatement();
              rs = stmt.executeQuery(sql);
              
              
              while (rs.next()) {
                  
                   String count = rs.getString("vehicle_id");
                  vehicle_avalable_count++ ; 
                  
              }
         //     System.out.println(vehicle_avalable_count);
              
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_select_package_2.class.getName()).log(Level.SEVERE, null, ex);
          }
            String numberAsString = Integer.toString(vehicle_avalable_count);
            return numberAsString ;
        
    } 
    
    
    
    
      public String set_location_count(){
        
        
             
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
             // System.out.println(location_avalable_count);
              
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_select_package_2.class.getName()).log(Level.SEVERE, null, ex);
          }
            String numberAsString_0 = Integer.toString(location_avalable_count);
             return numberAsString_0 ;
        
        
        
    }
      
      
      
      
      
      
      public String set_guider_count(){
        
        
             
        String sql = " select id from guider" ; 
        
        
        
             
               
                 Statement stmt;
          try {
              stmt = con.createStatement();
              rs = stmt.executeQuery(sql);
              
              
              while (rs.next()) {
                  
                   String count = rs.getString("id");
                  guider_avalable_count++ ; 
                  
              }
          //    System.out.println(guider_avalable_count);
              
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(tour_customer_select_package_2.class.getName()).log(Level.SEVERE, null, ex);
          }
            String numberAsString_0 = Integer.toString(guider_avalable_count);
             return numberAsString_0 ;
        
        
        
    }
      
      
      
   
    
    public void table(){
        
    }
    
    
}
