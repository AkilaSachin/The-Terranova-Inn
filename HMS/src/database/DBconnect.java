/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Akila Sachin
 */
public class DBconnect {
    
    public static Connection connect(){
        Connection conn=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
           conn=(Connection) DriverManager.getConnection("jdbc:mysql://Database link","username","password");
     //conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theterranovainn","root","");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
}
