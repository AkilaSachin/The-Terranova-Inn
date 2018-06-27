/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reservation;

import com.mysql.jdbc.Connection;
import database.DBconnect;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.List;
import java.awt.event.KeyEvent;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;


/**
 *
 * @author Akila Fernando
 */
public class Check_In extends javax.swing.JInternalFrame {

    java.sql.Connection con=null;
    PreparedStatement pst=null;
    PreparedStatement pst2=null;
    PreparedStatement pst3=null;
    ResultSet rs=null;
    ResultSet rst=null;
    ResultSet rs1=null;
    ArrayList name=new ArrayList();
    ArrayList CID=new ArrayList();
    /** Creates new form Check_In */
    
    String gen;
    String RID;
    Double tot;
    String tot1;
    
    public Check_In() {
        
        initComponents();
        con=DBconnect.connect();
     //   Savaroom();
       // Pavaroom();
        //Aavaroom();
        generatecusid();
        getnicdetails();
        getciddetails();
        loadguestdeatils1();
        loadguestdeatils();
        generateresid();
         prereser();
         selectreser();
    }
    
    
   /* public void roomex(){
        try{
        String q="select r.price from room r, reservation re where r.roomID=re.roomid and r.roomid=? and re.checkoutdate between ? and ?";
        pst=con.prepareStatement(q);
        pst.setString(1, jTextField10.getText());
        SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
        String doj1=myformat.format(jCalendarComboBox1.getDate());
        String doj2=myformat.format(jCalendarComboBox2.getDate());    
        ResultSet myresult=pst.executeQuery();
        if(myresult.next()){
        Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
                       if(x>=1){
          
               this.jLabel11.setText(Integer.toString(x));
                double tott,Days;
                tott = Double.parseDouble(jLabel10.getText());
                Days=Double.parseDouble(jLabel11.getText());
                tott=tott*days;
              //  jTextField3.setText(Double.toString(tot));
                jLabel9.setText(Double.toString(tott));
               
               
           }else{
                           JOptionPane.showMessageDialog(null, "Enter valid date period", "Error", JOptionPane.INFORMATION_MESSAGE);
                       }
            
        }else{
            JOptionPane.showMessageDialog(null, "Room Reserved", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        }catch(Exception e){
            
        }
        
    }*/
    public void loadre(){
          try{
           String sql="select * from room r,reservation re where re.roomid=r.roomID and re.checkindate=?";
               pst=con.prepareStatement(sql);    
               SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
               String dod98=myformat.format(jCalendarComboBox1.getDate());
               pst.setString(1,dod98);
                    DefaultTableModel mymodel=(DefaultTableModel) jTable1.getModel();
                    mymodel.setNumRows(0);
               ResultSet myresult=pst.executeQuery();
               if(myresult.next()){
                   String type=myresult.getString("type");
                   if(type.equals("Standard")){
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                jRadioButton3.setSelected(false);
                    }else if(type.equals("Premium")){
                jRadioButton2.setSelected(false);
                jRadioButton1.setSelected(false);
                jRadioButton3.setSelected(false);
                   }else{
                jRadioButton3.setSelected(false);
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                    }  
                   String price=myresult.getString("price");
                  // jLabel10.setText(price);
                   
                   
                     jScrollPane1.setVisible(true);
                     getContentPane().validate();
                        do
                        {
                        String RID=myresult.getString("roomID");   
                        String Rtype=myresult.getString("type");
                        String Rsize=myresult.getString("number");
                        String Rrate=myresult.getString("price");

                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate});
                    }
                        while(myresult.next());
                   
                   
                   
               }
               
          }catch(Exception e){
          JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
          }    
               
    }
    public void reset(){
         jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        jLabel11.setText("");
                jLabel10.setText("");
                        jLabel9.setText("");
                              //  jTextField4.setText(" ");
                jTextField5.setText("");
                        jTextField6.setText("");
                                jTextField7.setText("");
                jTextField8.setText("");
                      //  jTextField9.setText(" ");
                                jTextField10.setText("");
                jTextField11.setText("");
                        jTextArea1.setText("");
                        Date date = new Date();
                        jCalendarComboBox1.setDate(date);
                        jCalendarComboBox2.setDate(date);
                        jCalendarComboBox3.setDate(date);
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        jComboBox1.removeAllItems();
                                                  jLabel20.setIcon(null);
                          jLabel29.setIcon(null);
                          jLabel30.setIcon(null);
                          jLabel32.setIcon(null);
                          jLabel34.setIcon(null);
                          jLabel35.setIcon(null);
                          jLabel33.setIcon(null);
                        
    }
            
        public void selectreser(){
          try
            {
                String q="select * from reservation where checkindate=?";
                pst=con.prepareStatement(q);
                pst.setString(1,jComboBox1.getSelectedItem().toString());
                ResultSet myresult=pst.executeQuery();
                
                if(myresult.next())
                {
                    do
                    {
              //  jTextField9.setText(myresult.getString("reservationID"));
                //jTextField10.setText(myresult.getString("roomid"));
                jTextField11.setText(myresult.getString("deposit"));
                jCalendarComboBox1.setDate(myresult.getDate("checkindate"));
                jCalendarComboBox2.setDate(myresult.getDate("checkoutdate"));
                  // jLabel9.setText(myresult.getString("reservprice"));
                   
                           Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           this.jLabel11.setText(Integer.toString(x));
                    }
                    while(myresult.next());
                }
            }catch(Exception e){
                //JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
        }
    public void prereser(){
        try
            {
                String q="select distinct r.checkindate from reservation r,customer c where r.customerID=c.customerID and r.customerID=?";
                pst=con.prepareStatement(q);
                pst.setString(1, jTextField4.getText());
                ResultSet myresult=pst.executeQuery();
                
                if(myresult.next())
                {
                    do
                    {
                        jComboBox1.addItem(myresult.getString("checkindate"));
                    }
                    while(myresult.next());
                }
            }catch(Exception e){
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    public void generateresid(){
                        try
                {
                    String q="select max(reservationID) from reservation";
                    pst=con.prepareStatement(q);
                    
                     ResultSet myresult=pst.executeQuery();
                
                      if(myresult.next())
                      {
                          int resid=myresult.getInt(1);
                          if(resid>0)
                          {
                    //      jTextField9.setText(String.valueOf(resid+1));
                          }
                         
                      
                       else
                         {
                      //    jTextField9.setText("100");
                         }
                            }
                   
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    
    
    
    
    
    public void generatecusid(){
                        try
                {
                    String q="select max(customerid) from customer";
                    pst=con.prepareStatement(q);
                    
                     ResultSet myresult=pst.executeQuery();
                
                      if(myresult.next())
                      {
                          int custid=myresult.getInt(1);
                          if(custid>0)
                          {
                          jTextField4.setText(String.valueOf(custid+1));
                          }
                         
                      
                       else
                         {
                          jTextField4.setText("100");
                         }
                            }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    
   /* public void timedu(){
        Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
         // String y= Integer.toString(x);
           
           if(x>=0){
          
               this.jLabel11.setText(Integer.toString(x));
           }
           else{
                 JOptionPane.showMessageDialog(null, "Enter valid date period", "Error", JOptionPane.INFORMATION_MESSAGE);
           }
    }*/
           public void Aavaroom(){
               try
                {
                    String q="select r.roomid,r.type,r.number,r.price from room r, reservation re where r.status='Available' and r.type='Apartment' and r.roomid NOT IN (select roomid from reservation where checkindate between ? and ? and checkoutdate between ? and ?) group by r.roomid";
                    pst=con.prepareStatement(q);
                    SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                         String doj1=myformat.format(jCalendarComboBox1.getDate());
                         String doj2=myformat.format(jCalendarComboBox2.getDate());
                         String doj3=myformat.format(jCalendarComboBox1.getDate());
                         String doj4=myformat.format(jCalendarComboBox2.getDate());
                          pst.setString(1,doj1);
                          pst.setString(2,doj2);
                          pst.setString(3,doj3);
                          pst.setString(4,doj4);
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

                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate});
                    }
                        while(myresult.next());
                    }     
                     /*else
                     {
                         jScrollPane1.setVisible(false);
                     getContentPane().validate();
                        JOptionPane.showMessageDialog(rootPane, "No Records ", "Error",JOptionPane.ERROR_MESSAGE); 
                     } */  
                       
                        
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    
    
           public void Pavaroom(){
               try
                {
                    String q="select r.roomid,r.type,r.number,r.price from room r, reservation re where r.status='Available' and r.type='Premium' and r.roomid NOT IN (select roomid from reservation where checkindate between ? and ? and checkoutdate between ? and ?) group by r.roomid";
                    pst=con.prepareStatement(q);
                    SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                         String doj1=myformat.format(jCalendarComboBox1.getDate());
                         String doj2=myformat.format(jCalendarComboBox2.getDate());
                         String doj3=myformat.format(jCalendarComboBox1.getDate());
                         String doj4=myformat.format(jCalendarComboBox2.getDate());
                          pst.setString(1,doj1);
                          pst.setString(2,doj2);
                          pst.setString(3,doj3);
                          pst.setString(4,doj4);
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

                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate});
                    }
                        while(myresult.next());
                    }     
                     /*else
                     {
                         jScrollPane1.setVisible(false);
                     getContentPane().validate();
                        JOptionPane.showMessageDialog(rootPane, "No Records ", "Error",JOptionPane.ERROR_MESSAGE); 
                     } */  
                       

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
    
    
    
       public void Savaroom(){
               try
                {
                    String q="select r.roomid,r.type,r.number,r.price from room r, reservation re where r.status='Available' and r.type='Standard' and r.roomid NOT IN (select roomid from reservation where checkindate between ? and ? and checkoutdate between ? and ?) group by r.roomid";
                    pst=con.prepareStatement(q);
                    SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                         String doj1=myformat.format(jCalendarComboBox1.getDate());
                         String doj2=myformat.format(jCalendarComboBox2.getDate());
                         String doj3=myformat.format(jCalendarComboBox1.getDate());
                         String doj4=myformat.format(jCalendarComboBox2.getDate());
                          pst.setString(1,doj1);
                          pst.setString(2,doj2);
                          pst.setString(3,doj3);
                          pst.setString(4,doj4);
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

                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate});
                    }
                        while(myresult.next());
                    }     
                     else
                     {
                         jScrollPane1.setVisible(false);
                     getContentPane().validate();
                        JOptionPane.showMessageDialog(rootPane, "No Records ", "Error",JOptionPane.ERROR_MESSAGE); 
                     }  
                       
       /* Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
           String y= Integer.toString(x);
           
           if(!y.matches("-?[0-9]+([0-9]+[0-9])?")){
          
               this.jLabel11.setText(Integer.toString(x));
           }else{
        //this.jTextField1.setText(Integer.toString(x));
        //this.jLabel11.setText(Integer.toString(x));
           // JOptionPane.showMessageDialog(null, "Enter valid date period", "Error", JOptionPane.INFORMATION_MESSAGE);
           }*/
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
    }
public void getnicdetails(){
        try {
            String sql = "select * from customer";
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery();
            
            while(rst.next()){
                String Name=rst.getString("NIC");
                name.add(Name);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to load Guest NIC ","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
public void getciddetails(){
        try {
            String sql = "select * from customer";
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery();
            
            while(rst.next()){
                String Name=rst.getString("customerID");
                CID.add(Name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to load Guest ID ","Error", JOptionPane.WARNING_MESSAGE);
        }  
    }
           public void autoComplete(String txt){
        String complete = "";
        int start= txt.length();
        int last=txt.length();
        int a;
        
        for (a=0;a<name.size();a++){
            if(name.get(a).toString().startsWith(txt)){
                complete = name.get(a).toString();
                last = complete.length();
                break;
            }
        }
        if (last>start){
            jTextField7.setText(complete);
            jTextField7.setCaretPosition(last);
            jTextField7.moveCaretPosition(start);
        }
    }
               public void autoComplete1(String txt){
        String complete = "";
        int start= txt.length();
        int last=txt.length();
        int a;
        
        for (a=0;a<CID.size();a++){
            if(CID.get(a).toString().startsWith(txt)){
                complete = CID.get(a).toString();
                last = complete.length();
                break;
            }
        }
        if (last>start){
            jTextField4.setText(complete);
            jTextField4.setCaretPosition(last);
            jTextField4.moveCaretPosition(start);
        }
    }
           
               public void loadguestdeatils1(){
        String CID=jTextField4.getText();
        try {
            String sql="select * from customer where customerID=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,CID);
            rst=pst.executeQuery();
            
            if(rst.next()){
                jTextField7.setText(rst.getString("NIC"));
                jTextField5.setText(rst.getString("fname"));
                jTextField6.setText(rst.getString("lname"));
                jTextField8.setText(rst.getString("telephone"));
                jTextArea1.setText(rst.getString("address"));
                
                String r=rst.getString("DOB");
                DateFormat f=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date d=f.parse(r);
                jCalendarComboBox3.setDate(d);
                
                String g=rst.getString("gender");
                if ("Male".equals(g)){
                    jRadioButton4.setSelected(true);
                    jRadioButton5.setSelected(false);
                }
                else
                {
                    jRadioButton5.setSelected(true);
                    jRadioButton4.setSelected(false);                    
                }
            }
            
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to load Guest Details","Error", JOptionPane.WARNING_MESSAGE);
        }   
    }
           
           
           
           
           
           
           
           public void loadguestdeatils(){
        String NIC=jTextField7.getText();
        try {
            String sql="select * from customer where NIC=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, NIC);
            rst=pst.executeQuery();
            
            if(rst.next()){
                jTextField4.setText(rst.getString("customerID"));
                jTextField5.setText(rst.getString("fname"));
                jTextField6.setText(rst.getString("lname"));
                jTextField8.setText(rst.getString("telephone"));
                jTextArea1.setText(rst.getString("address"));
                String r=rst.getString("DOB");
                DateFormat f=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date d=f.parse(r);
                jCalendarComboBox3.setDate(d);
                
                String g=rst.getString("gender");
                if ("Male".equals(g)){
                    jRadioButton4.setSelected(true);
                    jRadioButton5.setSelected(false);
                }
                else
                {
                    jRadioButton5.setSelected(true);
                    jRadioButton4.setSelected(false);                    
                }
            }
            
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to load Guest Details","Error", JOptionPane.WARNING_MESSAGE);
        }   
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton4.setText("Update");
        jButton4.setActionCommand("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1055, 590));

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));

        jPanel2.setBackground(new java.awt.Color(47, 71, 123));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reservation Duration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jRadioButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Standard");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Premium");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Apartment");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Check Out");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Check In");

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Room Type");

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Number of Days");

        jLabel11.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButton1))
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jRadioButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );

        jPanel3.setBackground(new java.awt.Color(47, 71, 123));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Available or Reserved Rooms ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room ID", "Type", "Persons", "Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(47, 71, 123));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reservation Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Initial Room Price");

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Room Price");

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(47, 71, 123));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Customer and Reservation Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Customer ID");

        jLabel22.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("First Name");

        jLabel23.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Last Name");

        jLabel28.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Gender");

        jLabel24.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Date of Birth");

        jLabel25.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("NIC/Passport");

        jLabel26.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Contact Number");

        jLabel27.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Address");

        jLabel31.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Deposit");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Male");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Female");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Room ID");

        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Previous Resrv.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel28))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel24))
                                .addGap(14, 14, 14))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jRadioButton4)
                            .addGap(45, 45, 45)
                            .addComponent(jRadioButton5))
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton5)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(47, 71, 123));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Room Facilities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Palatino Linotype", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("1. Mini Fridge");

        jLabel14.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("2. I Pod / I Phone Docking Station");

        jLabel15.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("3. Wide screen 32\" LCD TV");

        jLabel16.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("4. Personal WIFI");

        jLabel17.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("5. Tea and coffee making facilities");

        jLabel18.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("6. Hair Dryer");

        jLabel19.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("7. DVD player");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel18))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel7.setBackground(new java.awt.Color(47, 71, 123));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setBackground(new java.awt.Color(68, 145, 162));
        jButton5.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Cancel");
        jButton5.setActionCommand("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.setActionCommand("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(68, 145, 162));
        jButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Check In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 145, 162));
        jButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

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
  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       String cusid = jTextField4.getText();
       String fname = jTextField5.getText();
       String lname = jTextField6.getText();
       String nic = jTextField7.getText(); 
       String contact = jTextField8.getText();
//       String rid = jTextField9.getText();
       String roomid = jTextField10.getText();
       String depo = jTextField11.getText();
       String add = jTextArea1.getText();
      // String gen;
       if(jRadioButton4.isSelected()){
            gen = "Male";
       }else if(jRadioButton5.isSelected()){
             gen = "Female";     
       }
               
                SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                  String dob2=myformat1.format(jCalendarComboBox3.getDate());
                   String dob3=myformat1.format(jCalendarComboBox1.getDate());
                    String dob4=myformat1.format(jCalendarComboBox2.getDate());
                  
       
        
              if(!cusid.isEmpty() && !fname.isEmpty() && !lname.isEmpty() && !nic.isEmpty() /*&& !roomid.isEmpty()*/ && !contact.isEmpty() /*&& !rid.isEmpty() && !depo.isEmpty()*/ && !add.isEmpty()){
            if(nic.matches ("^[0-9]{9}[vV]$")){
           if(contact.matches ("^[0-9]{10}$")){
               if(!fname.matches ("[a-zA-Z]+\\.?")){
JOptionPane.showMessageDialog(null, "First name can only contain Characters", "Error", JOptionPane.WARNING_MESSAGE);
               }else{
           if(!lname.matches ("[a-zA-Z]+\\.?")){
JOptionPane.showMessageDialog(null, "Last name can only contain Characters", "Error", JOptionPane.WARNING_MESSAGE);
               }else{
        try{
            
            String sql="select * from customer where customerID=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, cusid);
            rst=pst.executeQuery();
            if(rst.next()){        
                if(!fname.equals(rst.getString("fname")) || !lname.equals(rst.getString("lname")) || !nic.equals(rst.getString("nic")) || !contact.equals(rst.getString("telephone")) || !add.equals(rst.getString("address")) || !gen.equals(rst.getString("gender")) || !dob2.equals(rst.getString("dob"))){

                           try{
                    String q="update customer set fname=?,lname=?,dob=?,telephone=?,nic=?,gender=?,address=? where customerID=?";
                    pst=con.prepareStatement(q);
                    pst.setString(1,jTextField5.getText());
                    pst.setString(2,jTextField6.getText());
                   SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                  String dob=myformat.format(jCalendarComboBox3.getDate());
                   pst.setString(3,dob);
                   pst.setString(5,jTextField7.getText());
                   pst.setString(4,jTextField8.getText());
                   if(jRadioButton4.isSelected())
                   {
                        pst.setString(6, "Male");
                   }
                   else if(jRadioButton5.isSelected())
                   {
                        pst.setString(6, "Female");
                   }
                   pst.setString(7 ,jTextArea1.getText());
                   pst.setString(8,jTextField4.getText());
                   pst.executeUpdate();
                   //rst=pst.executeQuery();
                
                  JOptionPane.showMessageDialog(rootPane, "Customer details Updated", "Success",JOptionPane.INFORMATION_MESSAGE);
                               //JOptionPane.showMessageDialog(rootPane, "Customer details submitted", "Customer details", JOptionPane.INFORMATION_MESSAGE);
                  
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
                
            }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "NO New Customer Updates !", "Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
        }
       /* try{
                    String q="update customer set fname=?,lname=?,dob=?,telephone=?,nic=?,gender=?,address=? where customerID=?";
                    pst=con.prepareStatement(q);
                    pst.setString(1,jTextField5.getText());
                    pst.setString(2,jTextField6.getText());
                   SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                  String dob=myformat.format(jCalendarComboBox3.getDate());
                   pst.setString(3,dob);
                   pst.setString(5,jTextField7.getText());
                   pst.setString(4,jTextField8.getText());
                   if(jRadioButton4.isSelected())
                   {
                        pst.setString(6, "Male");
                   }
                   else if(jRadioButton5.isSelected())
                   {
                        pst.setString(6, "Female");
                   }
                   pst.setString(7 ,jTextArea1.getText());
                   pst.setString(8,jTextField4.getText());
                   int i=pst.executeUpdate();
                   //rst=pst.executeQuery();
                 if(i>0){
                  JOptionPane.showMessageDialog(rootPane, "Customer details updated", "Success",JOptionPane.INFORMATION_MESSAGE);
                 }              //JOptionPane.showMessageDialog(rootPane, "Customer details submitted", "Customer details", JOptionPane.INFORMATION_MESSAGE);
                  
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
                
            }*/
       // String reid = jTextField9.getText();
        //if(!reid.isEmpty()){
      /*  try{
            String ex="select * from reservation where customerID=?";
            pst=con.prepareStatement(ex);
            pst.setString(1, cusid);
            rst=pst.executeQuery();
            if(rst.next()){        
                if(!depo.equals(rst.getString("deposit")) || !dob3.equals(rst.getString("checkindate")) || !dob4.equals(rst.getString("checkoutdate")) || !roomid.equals(rst.getString("roomid")) ){
        
            try{
                String q="select * from reservation where customerID=?";
                pst=con.prepareStatement(q);
                pst.setString(1, jTextField4.getText());
               ResultSet myresult=pst.executeQuery();
               if(myresult.next()){        
                        
                String sql="Update reservation set roomid=?,deposit=?,checkindate=?,checkoutdate=?,reservprice=? where reservationID=?";
                pst=con.prepareStatement(sql);
                pst.setString(1,jTextField10.getText());
                pst.setString(2,jTextField11.getText());
                SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                String dob=myformat.format(jCalendarComboBox1.getDate());
                String dob1=myformat.format(jCalendarComboBox2.getDate());
                pst.setString(3,dob);
                pst.setString(4,dob1);
                pst.setString(5,jLabel9.getText());
               // pst.setString(6,jTextField9.getText()); 
                int j=pst.executeUpdate();
                 
                if(j>0){
                  JOptionPane.showMessageDialog(rootPane, "Reservation Details Updated", "Success",JOptionPane.INFORMATION_MESSAGE);
                    
                } // JOptionPane.showMessageDialog(rootPane, "Reservation details submitted", "Customer details", JOptionPane.INFORMATION_MESSAGE);
                  
               }
               
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
            }
                                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "NO New Reservation Updates !", "Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
                    }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
            }*/
                       }
               }   
                  reset();
                                       generatecusid();
                                       generateresid();
               
           }else{
               JOptionPane.showMessageDialog(null, "Contact Number should be 10 digits", "Error", JOptionPane.WARNING_MESSAGE);
           }
                      }else{
               JOptionPane.showMessageDialog(null, "Enter valid NIC", "Error", JOptionPane.WARNING_MESSAGE);
           }
       }else{
               JOptionPane.showMessageDialog(null, "Please Enter All Details", "Warrning !", JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
                    String[] strings = jTextField10.getText().split( ", *" );
  //int[] ints = new int[strings.length];
  String lk;
  for( int i = 0; i < strings.length; i++ ){
   //  ints[i] = Integer.parseInt(strings[i].trim() );
               
                lk = strings[i];
                       try{
                    String q="delete from reservation where roomID=? and checkindate=?";
                    pst=con.prepareStatement(q);
                    pst.setString(1,lk);
                SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                String dob=myformat.format(jCalendarComboBox1.getDate());
                pst.setString(2,dob);
                    pst.executeUpdate();
                       
                    //jTextField9.setText("");
                    jTextField10.setText("");
                   jTextField11.setText("");
                    jLabel10.setText("");
                   jLabel9.setText("");
                    // jLabel11.setText("");
                        Date date = new Date();
                     //   jCalendarComboBox1.setDate(date);
                       // jCalendarComboBox2.setDate(date);
                          jLabel20.setIcon(null);
                          jLabel29.setIcon(null);
                          jLabel30.setIcon(null);
                          jLabel32.setIcon(null);
                          jLabel34.setIcon(null);
                          jLabel35.setIcon(null);
                          jLabel33.setIcon(null);
                       jComboBox1.removeAllItems();
                          selectreser();
                              loadre();
                    
                  //JOptionPane.showMessageDialog(rootPane, "Room deleted Successfuly", "Success",JOptionPane.INFORMATION_MESSAGE);
                                    //   JOptionPane.showMessageDialog(rootPane, "Reservation details Deleted", "Reservation details", JOptionPane.INFORMATION_MESSAGE);
                  //jComboBox1.removeAllItems();
                  prereser();
                  generateresid();
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
                
            }}
  JOptionPane.showMessageDialog(rootPane, "Room deleted Successfuly", "Success",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
                if(jRadioButton1.isSelected()){
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            
            
        }
           
        Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
         // String y= Integer.toString(x);
           
           if(x>=1){
          
               this.jLabel11.setText(Integer.toString(x));
               Savaroom();
           }
           else{
                 JOptionPane.showMessageDialog(null, "Enter valid date period", "Error", JOptionPane.ERROR_MESSAGE);
                             jRadioButton1.setSelected(false);
                                     
       jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
           } 
            
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
                if(jRadioButton2.isSelected()){
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            
        }
                 
                         Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
         // String y= Integer.toString(x);
           
           if(x>=1){
          
               this.jLabel11.setText(Integer.toString(x));
               Pavaroom();
           }
           else{
                 JOptionPane.showMessageDialog(null, "Enter valid date period", "Error", JOptionPane.INFORMATION_MESSAGE);
                             jRadioButton2.setSelected(false);
           }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
                if(jRadioButton3.isSelected()){
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            
        }
                 
                         Date in=jCalendarComboBox1.getDate();  
        Date out=jCalendarComboBox2.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
         // String y= Integer.toString(x);
           
           if(x>=1){
          
               this.jLabel11.setText(Integer.toString(x));
               Aavaroom();
           }
           else{
                 JOptionPane.showMessageDialog(null, "Enter valid date period", "Error", JOptionPane.INFORMATION_MESSAGE);
                             jRadioButton3.setSelected(false);
           }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
/*         jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        

       // jTextField1.setText(" ");
        jLabel11.setText(" ");
                jLabel10.setText(" ");
                        jLabel9.setText(" ");
                              //  jTextField4.setText(" ");
                jTextField5.setText(" ");
                        jTextField6.setText(" ");
                                jTextField7.setText(" ");
                jTextField8.setText(" ");
                      //  jTextField9.setText(" ");
                                jTextField10.setText(" ");
                jTextField11.setText(" ");
                        jTextArea1.setText(" ");
                        jCalendarComboBox1.setDate(null);
                        jCalendarComboBox2.setDate(null);
                        jCalendarComboBox3.setDate(null);
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        jComboBox1.removeAllItems();
//                        jCheckBox1.setSelected(false);
//                        jCheckBox2.setSelected(false);
  //                      jCheckBox3.setSelected(false);
    //                    jCheckBox4.setSelected(false);
//                        jCheckBox5.setSelected(false);
  //                      jCheckBox6.setSelected(false);
    //                    jCheckBox7.setSelected(false);
                          jLabel20.setIcon(null);
                          jLabel29.setIcon(null);
                          jLabel30.setIcon(null);
                          jLabel32.setIcon(null);
                          jLabel34.setIcon(null);
                          jLabel35.setIcon(null);
                          jLabel33.setIcon(null);*/
                          reset();
                                       generatecusid();
                                       generateresid();
                        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          try{          int r=jTable1.getSelectedRow();    
            TableModel model=jTable1.getModel();
        String RID=jTable1.getValueAt(r, 0).toString();
        String price= model.getValueAt(r, 3).toString();
        int columns = model.getColumnCount();
//for (int i = 1; i <= columns; i++) {
 jTextField10.setText(jTextField10.getText()+RID+",");
//}
       // jTextField2.setText(price);
      // DecimalFormat dc1 = new DecimalFormat("0.00");
        jLabel10.setText(price);
        //jTextField10.setText(RID);
        double days;
                tot = Double.parseDouble(jLabel10.getText());
                days=Double.parseDouble(jLabel11.getText());
                tot=tot*days;
                tot1 = Double.toString(tot);
              //  jTextField3.setText(Double.toString(tot));
              DecimalFormat dc = new DecimalFormat("0.00");
              //String formattedText = dc.format(tot);
                jLabel9.setText(dc.format(tot));
               // jLabel10.setText(Double.toString(tot));
               String sql="select * from room where roomID=?";
               pst=con.prepareStatement(sql);
               pst.setString(1, RID);
               ResultSet myresult=pst.executeQuery();
               if(myresult.next()){
                   String it1=myresult.getString("it1");
                   if(it1.equals("Yes")){
                                   ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel20.setIcon(image);
                   }else{
                                                          ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel20.setIcon(image);
                   }
                   String it2=myresult.getString("it2");
                   if(it2.equals("Yes")){
                                                          ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel29.setIcon(image);
                   }else{
                                                                                ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel29.setIcon(image);
                   }
                   String it3=myresult.getString("it3");
                   if(it3.equals("Yes")){
                                                                                 ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel30.setIcon(image);
                   }else{
                                                                                            ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel30.setIcon(image);
                   }
                   String it4=myresult.getString("it4");
                   if(it4.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel32.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel32.setIcon(image);
                   }
                   String it5=myresult.getString("it5");
                   if(it5.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel34.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel34.setIcon(image);
                   }
                   String it6=myresult.getString("it6");
                   if(it6.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel35.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel35.setIcon(image);
                   }
                   String it7=myresult.getString("it7");
                   if(it7.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel33.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel33.setIcon(image);
                   }                   
               }
               
          }catch(Exception e){
          JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
          }
               
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
                switch(evt.getKeyCode()){
                case KeyEvent.VK_BACK_SPACE:                    
                    break;
                case KeyEvent.VK_ENTER:
                    loadguestdeatils();
                    break;
              /*  case KeyEvent.VK_V:
                    loadguestdeatils();*/
                default:
                   EventQueue.invokeLater(new Runnable(){
                        @Override
                        public void run(){
                    String txt =jTextField7.getText();
                            autoComplete(txt);                               
                }
                    });
                            } 
               jComboBox1.removeAllItems();
               prereser();
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
                switch(evt.getKeyCode()){
                case KeyEvent.VK_BACK_SPACE:
                    break;
                case KeyEvent.VK_ENTER:
                    loadguestdeatils1();
                    break;
                
                default:
                   EventQueue.invokeLater(new Runnable(){                       
                        
                        @Override
                        public void run(){
                    String txt =jTextField4.getText();
                            autoComplete1(txt);
                }
                    });
                            } 
                               jComboBox1.removeAllItems();
               prereser();
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String cusid = jTextField4.getText();
       String fname = jTextField5.getText();
       String lname = jTextField6.getText();
       String nic = jTextField7.getText(); 
       String contact = jTextField8.getText();
//       String rid = jTextField9.getText();
       String roomid = jTextField10.getText();
       String depo = jTextField11.getText();
       String add = jTextArea1.getText();
       String run;
       /*if(jRadioButton4.isSelected()){
           // jRadioButton4(true);
          //
       }else if(jRadioButton5.isSelected()){
             gen = "Female";     
       }*/
       
       
       if(!cusid.isEmpty() && !fname.isEmpty() && !lname.isEmpty() && !nic.isEmpty() && !roomid.isEmpty() && !contact.isEmpty() && /*!rid.isEmpty() &&*/ !depo.isEmpty() && !add.isEmpty()){
            if(nic.matches ("^[0-9]{9}[vV]$")){
           if(contact.matches ("^[0-9]{10}$")){
               if(!fname.matches ("[a-zA-Z]+\\.?")){
JOptionPane.showMessageDialog(null, "First name can only contain Characters", "Error", JOptionPane.WARNING_MESSAGE);
               }else{
                                  if(!lname.matches ("[a-zA-Z]+\\.?")){
JOptionPane.showMessageDialog(null, "Last name can only contain Characters", "Error", JOptionPane.WARNING_MESSAGE);
               }else{
        try{
            String sql="select * from customer where customerID=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            rst=pst.executeQuery();
             if(!rst.next()){
                    String q="insert into customer(customerID,fname,lname,DOB,telephone,NIC,gender,address,email,password) values(?,?,?,?,?,?,?,?,?,?)";
                    pst=con.prepareStatement(q);
                    pst.setString(1, jTextField4.getText());
                    pst.setString(2,jTextField5.getText());
                    pst.setString(3,jTextField6.getText());
                    SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                    String dod=myformat.format(jCalendarComboBox3.getDate());
                    pst.setString(4, dod);
                    pst.setString(5, jTextField8.getText());
                    pst.setString(6, jTextField7.getText());

                    
                   if(jRadioButton4.isSelected())
                   {
                        pst.setString(7, "Male");
                   }
                   else if(jRadioButton5.isSelected())
                   {
                        pst.setString(7, "Female");
                   }
                    pst.setString(8 ,jTextArea1.getText());
                    pst.setString(9 ,"");
                    pst.setString(10 ,"");
                    pst.executeUpdate();

                     /*jTextField6.setText("");
                     jTextField7.setText("");
                     jTextField8.setText("");
                     //jTextField4.setText("");
                     jTextField5.setText("");
                     jTextArea1.setText("");
                     jCalendarComboBox1.setDate(null);*/
                     
                     
                     JOptionPane.showMessageDialog(rootPane, "Customer details submitted", "Customer details", JOptionPane.INFORMATION_MESSAGE);
             }
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Cus_Error",JOptionPane.WARNING_MESSAGE);
                
            }
        /* try{
            String sql="select * from reservation where customerID=? and roomid=? and checkindate=? ";
            pst=con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField10.getText());
            SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
            String dod85=myformat.format(jCalendarComboBox1.getDate());
            pst.setString(3, dod85);
            rst=pst.executeQuery();
            if(rst.next()){     
               
                if(!roomid.equals(rst.getString("roomid"))){*/
         try{
            String[] strings = jTextField10.getText().split( ", *" );
  //int[] ints = new int[strings.length];
  String lk=null;
  for( int i = 0; i < strings.length; i++ ){
   //  ints[i] = Integer.parseInt(strings[i].trim() );
               
                lk = strings[i];
                
             String q="insert into reservation(customerID,checkindate,checkoutdate,deposit,roomid,reservprice) values(?,?,?,?,?,?)";
             pst=con.prepareStatement(q);
            // pst.setString(1, jTextField9.getText());
             pst.setString(1, jTextField4.getText());
                   SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
                    String dod=myformat.format(jCalendarComboBox1.getDate());
                    pst.setString(2, dod);
                    SimpleDateFormat myformat1=new SimpleDateFormat("yyyy-MM-dd");
                    String dod1=myformat1.format(jCalendarComboBox2.getDate());
                    pst.setString(3, dod1);
                    pst.setString(4,jTextField11.getText());
                    
                    pst.setString(5, lk);
                    pst.setString(6,tot1);
                    pst.executeUpdate();
  }
                    /* jTextField9.setText("");
                     jTextField4.setText("");
                     jCalendarComboBox1.setDate(null);
                     jCalendarComboBox2.setDate(null);
                     jTextField11.setText("");
                     jTextField10.setText("");
                     jLabel9.setText("");*/
                    
                   
                        String mo="insert into mobilelogin (cusid,nic,roomid) values (?,?,?)";
                        pst=con.prepareStatement(mo);
                        pst.setString(1, jTextField4.getText());
                        pst.setString(2, jTextField7.getText());
                        pst.setString(3, lk);
                        pst.executeQuery();
                
                    
                     JOptionPane.showMessageDialog(rootPane, "Reservation successful", "Reservation details", JOptionPane.INFORMATION_MESSAGE);
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(rootPane, "eError in query due to"+e.getMessage(), "Re_Error",JOptionPane.ERROR_MESSAGE);
         }
                  /*   jTextField6.setText("");
                     jTextField7.setText("");
                     jTextField8.setText("");
                     jTextField4.setText("");
                     jTextField5.setText("");
                     jTextArea1.setText("");
                        jCalendarComboBox1.setDate(null);*/
               /* }else{
                    JOptionPane.showMessageDialog(rootPane, "Reservation Already Exist", "Reservation Details", JOptionPane.INFORMATION_MESSAGE);
                }
            }
          }catch(Exception e){
             JOptionPane.showMessageDialog(rootPane, "eError in query due to"+e.getMessage(), "Re_Error",JOptionPane.ERROR_MESSAGE);
         }
           */ 
                                       reset();
                                       generatecusid();
                                       generateresid();
               }
               }  
           }else{
               JOptionPane.showMessageDialog(null, "Contact Number should be 10 digits", "Error", JOptionPane.WARNING_MESSAGE);
           }
                      }else{
               JOptionPane.showMessageDialog(null, "Enter valid NIC", "Error", JOptionPane.WARNING_MESSAGE);
           }
       }else{
               JOptionPane.showMessageDialog(null, "Please Enter All Details", "Warrning !", JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
      selectreser();
      loadre();
      /* try{
           String sql="select * from room r,reservation re where re.roomid=r.roomID and re.checkindate=?";
               pst=con.prepareStatement(sql);    
               SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
               String dod98=myformat.format(jCalendarComboBox1.getDate());
               pst.setString(1,dod98);
                    DefaultTableModel mymodel=(DefaultTableModel) jTable1.getModel();
                    mymodel.setNumRows(0);
               ResultSet myresult=pst.executeQuery();
               if(myresult.next()){*/
               /*  String it1=myresult.getString("it1");
                   if(it1.equals("Yes")){
                                   ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel20.setIcon(image);
                   }else{
                                                          ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel20.setIcon(image);
                   }
                   String it2=myresult.getString("it2");
                   if(it2.equals("Yes")){
                                                          ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel29.setIcon(image);
                   }else{
                                                                                ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel29.setIcon(image);
                   }
                   String it3=myresult.getString("it3");
                   if(it3.equals("Yes")){
                                                                                 ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel30.setIcon(image);
                   }else{
                                                                                            ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel30.setIcon(image);
                   }
                   String it4=myresult.getString("it4");
                   if(it4.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel32.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel32.setIcon(image);
                   }
                   String it5=myresult.getString("it5");
                   if(it5.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel34.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel34.setIcon(image);
                   }
                   String it6=myresult.getString("it6");
                   if(it6.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel35.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel35.setIcon(image);
                   }
                   String it7=myresult.getString("it7");
                   if(it7.equals("Yes")){
                                                                                             ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Check-tick-approved-okay-round-green-button-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel33.setIcon(image);
                   }else{
                                                                                                        ImageIcon image = new ImageIcon(new ImageIcon("Cimages\\Delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            jLabel33.setIcon(image);
                   }*/
                  /* String type=myresult.getString("type");
                   if(type.equals("Standard")){
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                jRadioButton3.setSelected(false);
                    }else if(type.equals("Premium")){
                jRadioButton2.setSelected(false);
                jRadioButton1.setSelected(false);
                jRadioButton3.setSelected(false);
                   }else{
                jRadioButton3.setSelected(false);
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                    }  
                   String price=myresult.getString("price");
                  // jLabel10.setText(price);
                   
                   
                     jScrollPane1.setVisible(true);
                     getContentPane().validate();
                        do
                        {
                        String RID=myresult.getString("roomID");   
                        String Rtype=myresult.getString("type");
                        String Rsize=myresult.getString("number");
                        String Rrate=myresult.getString("price");

                        
                        mymodel.addRow(new Object[]{RID,Rtype,Rsize,Rrate});
                    }
                        while(myresult.next());
                   
                   
                   
               }
               
          }catch(Exception e){
          JOptionPane.showMessageDialog(rootPane, "Error in query due to"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
          }*/
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
                        if(jRadioButton4.isSelected()){
            jRadioButton5.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
                                if(jRadioButton5.isSelected()){
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jCalendarComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarComboBox1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCalendarComboBox1MouseClicked

    private void jCalendarComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarComboBox2MouseClicked
        // TODO add your handling code here:
        //roomex();
    }//GEN-LAST:event_jCalendarComboBox2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

}
