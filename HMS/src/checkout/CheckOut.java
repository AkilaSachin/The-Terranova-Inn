/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import com.mysql.jdbc.Connection;
import database.DBconnect;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Akila Sachin
 */
public class CheckOut extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst = null;
    Connection con1=null;
    PreparedStatement pst1 = null;
    ResultSet rst=null;
    ArrayList name1=new ArrayList();
    ArrayList CID=new ArrayList();
    String cusID=null;
    DefaultTableModel model;


    /**
     * Creates new form CheckOut
     */
    
    
    public CheckOut() {
        initComponents();
        
        getContentPane().setBackground(new Color(90, 120, 183));
        
        con=DBconnect.connect();
        con1=DBconnect.connect();
        
        getciddetails();
        
        
        Reservations.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        
        jPanel7.setOpaque(false);
        
        model=(DefaultTableModel)jTable2.getModel();
        
       
        
    }
    public void calculationload(){
        int rowc=jTable2.getRowCount();
        double roomtot=0;
        double foodtot=0;
        double otheritot=0;
        double rarrtot=0;
        double secu=0;
        double lan=0;
        
        for(int x=0;x<rowc;x++){
            try {
                String rpric= (String) jTable2.getValueAt(x, 1); 
                double rprice=Double.parseDouble(rpric);
                int days=(int) jTable2.getValueAt(x, 2);
                roomtot=roomtot+(days*rprice); 
                
                String fodt= (String) jTable2.getValueAt(x,3);
                if(fodt!=null){
                    double foodt=Double.parseDouble(fodt);
                    foodtot=foodtot+foodt;
                }
                
                String oti=(String) jTable2.getValueAt(x,4);
                if(oti!=null){
                double othi=Double.parseDouble(oti);
                otheritot=otheritot+othi;
                }
                
                String rart=(String) jTable2.getValueAt(x,5);
                if(rart!=null){
                double rarrt=Double.parseDouble(rart);
                rarrtot=rarrtot+rarrt;
                }
                
                String secuu=(String) jTable2.getValueAt(x,6);
                if(secuu!=null){
                double secuuu=Double.parseDouble(secuu);
                secu=secu+secuuu;
                }
                
                String lann=(String) jTable2.getValueAt(x,7);
                if(lann!=null){
                double lannn=Double.parseDouble(lann);
                lan=lan+lannn;
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog( this, " Failed to load Bill Information "+e,"Error", JOptionPane.ERROR_MESSAGE);
            }            
        }
        broom.setText(Double.toString(roomtot));
        food.setText(Double.toString(foodtot));
        otheritems.setText(Double.toString(otheritot));
        rarrangement.setText(Double.toString(rarrtot));
        laundary.setText(Double.toString(lan));
        security.setText(Double.toString(secu));
    }
    
    public void clear(){
        cID.setText("");
        name.setText("");
       
        conn.setText("");
       
        broom.setText("");
        rarrangement.setText("");
        food.setText("");
        otheritems.setText("");
       // tourcharges.setText("");
        laundary.setText("");
        dis.setText("0");
        totc.setText("");
        deposit.setText("");
        nettot.setText("");
        subtotal.setText("0");
        security.setText("0");
        
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        model1.setRowCount(0);
        
        model.setRowCount(0);
      
    }

    
    public void getciddetails(){
        try {
            String sql = "SELECT c.NIC FROM customer c, reservation r WHERE c.customerID = r.customerID";
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery();
            
            while(rst.next()){
                String cusid=rst.getString("NIC");
                CID.add(cusid);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to load Guest ID ","Error", JOptionPane.ERROR_MESSAGE);
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
            cID.setText(complete);
            cID.setCaretPosition(last);
            cID.moveCaretPosition(start);
        }
    }
      
     public void loadguestdeatils1(){
       
        String nic=cID.getText();
        
        
        try {
            String sql="select * from customer where NIC=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,nic);
            rst=pst.executeQuery();
            
            if(rst.next()){
               
                String f=(rst.getString("fname"));
                String l=(rst.getString("lname"));
                conn.setText(rst.getString("telephone"));
                name.setText(f+" "+l); 
                cusID=rst.getString("customerID");
                
            }
  
        } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Guest Details","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        Date d= new Date();
        DateFormat f=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String da=f.format(d);
        
        try {
             String sql1="SELECT roomid as 'Room ID',checkindate as 'Check In',checkoutdate as 'Check Out' FROM reservation where customerID=? and checkindate < ? ";
            pst=con.prepareStatement(sql1);
            pst.setString(1, cusID);
            pst.setString(2, da);
            rst=pst.executeQuery();
            
               jTable1.setModel(DbUtils.resultSetToTableModel(rst));

         } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to load Checkin Details"+ e,"Error", JOptionPane.ERROR_MESSAGE);
         }
        
        try {
             String sql6="SELECT sum(deposit) FROM reservation where customerID=?";
            pst=con.prepareStatement(sql6);
            pst.setString(1, cusID);
            rst=pst.executeQuery();
            if(rst.next()){
                deposit.setText(rst.getString("sum(deposit)"));

            }
              
         } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to load Checkin Details"+ e,"Error", JOptionPane.ERROR_MESSAGE);
         }
        

//         tourcharges();
//         security();
//         laundry();
         total();
    }
 

//      public void tourcharges(){
//         try {
//              String que="select * from it160_customer_selection_package_2 where customer__id=?";
//               pst=con.prepareStatement(que);
//               pst.setString(1, cusID);
//               rst=pst.executeQuery();
//                            
//               if(rst.next()){
//                   String d=rst.getString("A_cost");
//                   tourcharges.setText(d);
//               }
//               else{
//                   tourcharges.setText("0");
//               }
//  
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog( this, " Failed to load Tour Package Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
//         } 
//     }
      
//      public void security(){
//        String tot=null; 
//        try {
//              String que="select sum(total) from service_info where guestID=? and serviceType=?";
//               pst=con.prepareStatement(que);
//               pst.setString(1, cusID);
//               pst.setString(2, "Security");
//               rst=pst.executeQuery();
//                            
//               if(rst.next())
//               {
//                   tot=rst.getString("sum(total)");
//                   if(tot==null){
//                       security.setText("0");
//                   }
//                   else{
//                       security.setText(tot);
//                   }
//                   
//                }
//  
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog( this, " Failed to load Room Arrangements Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
//         }    
//     }
//      
//      public void laundry(){
//        String tot=null; 
//        try {
//              String que="select sum(total) from service_info where guestID=? and serviceType=?";
//               pst=con.prepareStatement(que);
//               pst.setString(1, cusID);
//               pst.setString(2, "Laundry");
//               rst=pst.executeQuery();
//                            
//               if(rst.next())
//               {
//                   tot=rst.getString("sum(total)");
//                   if(tot==null){
//                       laundary.setText("0");
//                   }
//                   else{
//                        laundary.setText(tot);
//                   }                  
//                }
//              
//  
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog( this, " Failed to load Room Arrangements Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
//         }    
//     }      
  
     
     public void total(){
         Double room=Double.parseDouble(broom.getText());
         Double rarang=Double.parseDouble(rarrangement.getText());
         Double foodc=Double.parseDouble(food.getText());
         Double iother=Double.parseDouble(otheritems.getText());
//         Double tour=Double.parseDouble(tourcharges.getText());
         Double sother=Double.parseDouble(laundary.getText());
         Double sec=Double.parseDouble(security.getText());
         
         Double sub=room+rarang+foodc+iother+sother+sec;
         subtotal.setText(Double.toString(sub));
         
         Double disc=0.0;
         String ds=dis.getText();
         if("".equals(ds)){
             disc=0.0;
         }
         else{
             disc=Double.parseDouble(dis.getText());
         }
         
         
         Double totdisc=(sub/100)*disc;
         Double total=sub-totdisc;
         
         totc.setText(Double.toString(total));
         
         Double dep=Double.parseDouble(deposit.getText());
         
         Double net=total-dep;
         nettot.setText(Double.toString(net));
     } 
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cID = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        conn = new javax.swing.JLabel();
        Reservations = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        broom = new javax.swing.JLabel();
        rarrangement = new javax.swing.JLabel();
        food = new javax.swing.JLabel();
        otheritems = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        deposit = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        nettot = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        dis = new javax.swing.JTextField();
        subtotal = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        laundary = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        totc = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        security = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Guest Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Name");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Contact Number");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("NIC/Passport");

        cID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cIDKeyPressed(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        conn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        conn.setForeground(new java.awt.Color(255, 255, 255));
        conn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cID)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(20, 20, 20))
        );

        Reservations.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reservations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Check In", "Check Out"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        javax.swing.GroupLayout ReservationsLayout = new javax.swing.GroupLayout(Reservations);
        Reservations.setLayout(ReservationsLayout);
        ReservationsLayout.setHorizontalGroup(
            ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
        ReservationsLayout.setVerticalGroup(
            ReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "To Check Out", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Room Price", "No of Days", "Food", "Other Items", "Room Arrangement", "Security", "Laundary"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(160);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(160);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(80);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bill Calculation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Room Rental");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Other Requsted Items");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Food & Beverage Charges");

        broom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        broom.setForeground(new java.awt.Color(255, 255, 255));
        broom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        broom.setText("0");
        broom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rarrangement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rarrangement.setForeground(new java.awt.Color(255, 255, 255));
        rarrangement.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rarrangement.setText("0");
        rarrangement.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        food.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        food.setForeground(new java.awt.Color(255, 255, 255));
        food.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food.setText("0");
        food.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        otheritems.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        otheritems.setForeground(new java.awt.Color(255, 255, 255));
        otheritems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        otheritems.setText("0");
        otheritems.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Total Charges");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Deposit");

        deposit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deposit.setForeground(new java.awt.Color(255, 255, 255));
        deposit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deposit.setText("0");
        deposit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Subtotal");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Discount (%)");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Total");

        nettot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nettot.setForeground(new java.awt.Color(255, 255, 255));
        nettot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nettot.setText("0");
        nettot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        print.setBackground(new java.awt.Color(68, 145, 162));
        print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print Bill");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        dis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dis.setText("0");
        dis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                disKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                disKeyTyped(evt);
            }
        });

        subtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subtotal.setForeground(new java.awt.Color(255, 255, 255));
        subtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subtotal.setText("0");
        subtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Room Arrangment Charges");

        laundary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        laundary.setForeground(new java.awt.Color(255, 255, 255));
        laundary.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        laundary.setText("0");
        laundary.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Laundary");

        totc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totc.setForeground(new java.awt.Color(255, 255, 255));
        totc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totc.setText("0");
        totc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Check Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        security.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        security.setForeground(new java.awt.Color(255, 255, 255));
        security.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        security.setText("0");
        security.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Security");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel23)
                    .addComponent(jLabel37)
                    .addComponent(jLabel34)
                    .addComponent(jLabel39)
                    .addComponent(jLabel24)
                    .addComponent(jLabel38)
                    .addComponent(jLabel43)
                    .addComponent(jLabel36)
                    .addComponent(jLabel44)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(subtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(security, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(laundary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(otheritems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(food, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rarrangement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(broom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nettot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(117, 117, 117))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(broom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rarrangement, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(food, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(otheritems, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(laundary, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(security, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(dis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nettot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        text.setColumns(20);
        text.setRows(5);
        jScrollPane3.setViewportView(text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Reservations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cIDKeyPressed
        // TODO add your handling code here:
        switch(evt.getKeyCode()){
                case KeyEvent.VK_BACK_SPACE:                    
                    break;
                case KeyEvent.VK_ENTER:
                    loadguestdeatils1();
                    break;
                case KeyEvent.VK_V:
                    loadguestdeatils1();
                default:
                   EventQueue.invokeLater(new Runnable(){
                        @Override
                        public void run(){
                    String txt =cID.getText();
                            autoComplete1(txt);            
                }
                    });
                            }   
    }//GEN-LAST:event_cIDKeyPressed

    private void disKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disKeyReleased
        // TODO add your handling code here:
            total();    
    }//GEN-LAST:event_disKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {                
        String roorent=broom.getText();
        String roomarr=rarrangement.getText();
        String fod=food.getText();
        String otherr=otheritems.getText();
//        String tour=tourcharges.getText();
        String laund=laundary.getText();
        String secu=security.getText();
        String discount=dis.getText();
        String depo=deposit.getText();
        String total=nettot.getText();
        
        String roomn=null;
         DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();   
         
         for(int i=0;i<model2.getRowCount();i++){
                if(roomn==null){
                    roomn=model2.getValueAt(i, 0).toString();
                }
                else{
                    roomn=roomn +","+ model2.getValueAt(i, 0);
                }
                
                deleterecord(model2.getValueAt(i, 0).toString());
         }
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today=new Date();
        
        String billda=df.format(today);
        
          
            String que="insert into reservation_history (customerID,Billdate,roomid,roomrent,roomarrang,food,other,laundary,security,discount,deposit,total) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=con.prepareStatement(que);
            pst.setString(1,cusID);
            pst.setString(2,billda);
            pst.setString(3,roomn);
            pst.setString(4,roorent);
            pst.setString(5,roomarr);
            pst.setString(6,fod);
            pst.setString(7,otherr);
            pst.setString(8,laund);
            pst.setString(9,secu);
            pst.setString(10,discount);
            pst.setString(11,depo);
            pst.setString(12,total);
            pst.execute();
            
            printere();
            
         for(int i=0;i<model2.getRowCount();i++){

                deleterecord(model2.getValueAt(i, 0).toString());
         }            
            
            JOptionPane.showMessageDialog(this,"Check Out Successful","Reservation Status",JOptionPane.INFORMATION_MESSAGE);
            
            clear();           
            
          }
          catch(Exception e){
              JOptionPane.showMessageDialog( this, "Error in chekout process "+e,"Error", JOptionPane.ERROR_MESSAGE);    
          }
        
    }//GEN-LAST:event_jButton3ActionPerformed
       
    public void deleterecord(String roo){
      
        try {
                String que="delete from reservation where customerID=? and roomID=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete reservation "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }

        try {
                String que="delete from food where customerID=? and roomNo=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete Food info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
                String que="delete from delivery where customerID=? and roomNo=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete other items info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
                String que="delete from mobilelogin where cusid=? and roomid=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete app login info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
                String que="delete from security_info where guestID=? and roomID=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete Security info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
                String que="delete from laundry_orders where guestID=? and roomID=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete Laundary info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
                String que="delete from room_arr where guestID=? and roomID=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.setString(2,roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete Room Arrangment info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }
        
        try {
                String que="delete from mobi_cart where roomno=?";
                pst=con.prepareStatement(que);
                pst.setString(1, roo);
                pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to delete Mobi_cart info "+e,"Error", JOptionPane.ERROR_MESSAGE);   
        }       
        
    }
   
    public void printere(){
        String gname=name.getText();
        String cno=conn.getText();
        String lan=laundary.getText();
        String sec=security.getText();
        String subtot=subtotal.getText();
        String des=dis.getText();
        String dep=deposit.getText();
        String tot=nettot.getText();
        
        int nro=0;
        String rnum="0";
        String rprice="0";
        String cin=null;
        String days="0";
        double rrental=0;
        String rarr="0";
        String fod="0";
        String other="0";
        String cusid="0";
        String se="0";
        String la="0";
        
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        nro=model2.getRowCount();
        String rline="";
        
        for(int i=0;i<model2.getRowCount();i++){
            
            rnum=model2.getValueAt(i,0).toString();
            System.out.println(rnum);
            rprice=model2.getValueAt(i,1).toString();
            days=model2.getValueAt(i,2).toString();
            fod=model2.getValueAt(i,3).toString();
            other=model2.getValueAt(i,4).toString();
            rarr=model2.getValueAt(i,5).toString();
            se=model2.getValueAt(i, 6).toString();
            la=model2.getValueAt(i, 7).toString();
            
        try {
            String que1="Select * from customer where NIC=?";
            pst=con.prepareStatement(que1);
            pst.setString(1, cID.getText());
            rst=pst.executeQuery();
            
            if(rst.next())
            {
                cusid=rst.getString("customerID");
            }
            
            String que="select * from reservation where roomid=? and customerID=?";
            pst=con.prepareStatement(que);
            pst.setString(1, rnum);
            pst.setString(2, cusid);
            rst=pst.executeQuery();
            
            if(rst.next())
            {
                cin=rst.getString("checkindate");
            }
            
            rrental=Double.parseDouble(rprice)*Integer.parseInt(days);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog( this, "error getting checkin"+ e,"Error", JOptionPane.ERROR_MESSAGE);
        }
        
            rline=rline+ rnum+"\t"+rprice+"          "+cin+"        "+days+"             "+rrental+"\t"+rarr+"\t"+fod+"           "+other+"           "+se+"         "+la+"      \n";
        }
        
    String mText="                                                                               The Terranova inn                                           \n"
            + "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
            + "Guest Name    : " +gname+ "\n"
            + "Contact No      : " +cno+ "\n"
            + "No. Of Rooms : "+nro+"\n\n"
            + "  Room No | Room Price |   Check In    | No.of Days | Room Rental | Room Arrangment |    Food    | Other Items | Security | Laundary  \n\n"
//              + "|  Room No\t Room Price\t Check In\t No. of Days\t Room Rental\t Room Arrangment\t Food\t Other Items | \n\n"   
            + rline 
            +"\nLaundary      : Rs "+lan+"\n"
            +"Security        : Rs "+sec+"\n"
            +"Sub Total      : Rs "+subtot+"\n"
            +"Discount       : Rs "+des+"\n"
            +"Deposit         : Rs "+dep+"\n"
            +"Total             : Rs "+tot+"\n\n"
            + "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
            +"                                                                                        THANK YOU                                                       \n"
            +"The Terranova Inn\n"
            +"23/B, Kattuwa Road,\n"
            +"Ettukala,\n"
            +"Negombo,\n"
            +"Sri Lanka.\n"
            +"Tel : +9477 847 5698\n\n"
            + "This is computer generated invoice no signature required";

                    text.setText(mText);
    
        try {
                boolean complete=text.print();
                
                if(complete){
                    JOptionPane.showMessageDialog(null, "done printing","information",JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null,"printing","printer",JOptionPane.ERROR_MESSAGE);
                }
                
        } catch (Exception e) {
        }
 
    }
    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        printere();
        
    }//GEN-LAST:event_printActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                int r= jTable1.getSelectedRow();
                String roomid=jTable1.getValueAt(r,0).toString();
                String cin=jTable1.getValueAt(r,1).toString();
                String cout=jTable1.getValueAt(r,2).toString();
                
                int days=getdaye(cin,cout);
                String food=loadfoodbeverage(roomid);
                String other=deliverycharges(roomid);
                String rarr=roomarrangements(roomid);
                String schg=securitychg(roomid);
                String lonchg=laundarychg(roomid);
                String roprice=roomprice(roomid);
                
                
               model.insertRow(model.getRowCount(), new Object[]{roomid,roprice,days,food,other,rarr,schg,lonchg});
               DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
               model1.removeRow(jTable1.getSelectedRow());

       calculationload();
       total();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int r= jTable2.getSelectedRow();
        String roomid=jTable2.getValueAt(r,0).toString();
        
        try {
             String sql1="SELECT checkindate,checkoutdate FROM reservation where roomid=? and customerID=?";
            pst=con.prepareStatement(sql1);
            pst.setString(1, roomid);
            pst.setString(2, cusID);
            rst=pst.executeQuery();
            
            String Cin=null;
              String Cout=null;
            if(rst.next())
            {
                Cin=rst.getString("checkindate");
                Cout=rst.getString("checkoutdate");
            }
            DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
            model1.insertRow(model1.getRowCount(), new Object[]{roomid,Cin,Cout});
            
                model.removeRow(r);

         } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to load Checkin Details"+ e,"Error", JOptionPane.ERROR_MESSAGE);
         }
        calculationload();
        total();
    }//GEN-LAST:event_jTable2MouseClicked

    private void disKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disKeyTyped
        char c=evt.getKeyChar();
        String s=dis.getText();
         
         if(!(Character.isDigit(c))||(c==com.sun.glass.events.KeyEvent.VK_BACKSPACE) || (c== com.sun.glass.events.KeyEvent.VK_DELETE))
         {
             evt.consume();
         }
         else if(s.length()==3){
             evt.consume();
         }
    }//GEN-LAST:event_disKeyTyped
        
    public String roomprice(String roomid){
        String tot="0";
         try {
              String que="select price from room where roomID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, roomid);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   tot=rst.getString("price");  
                   
                   if("".equals(tot)){
                       tot="0";
                   }
               }

         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Food & Beverage Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
         return tot;
    }
    
     public int getdaye(String cin,String cout){
         int x=0;
         try {
            DateFormat f=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);                
            Date in=f.parse(cin);
            
            Date out = new Date();
 
            long ind = in.getTime();
            long outd = out.getTime();        
            long days=outd -ind;
         
           x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load no of days"+e,"Error", JOptionPane.ERROR_MESSAGE);
         }
        return x;
    }
     
    public String loadfoodbeverage(String room){
        String tot="0";
         try {
              String que="select sum(totcost) from food where roomNo=?";
               pst=con.prepareStatement(que);
               pst.setString(1, room);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   tot=rst.getString("sum(totcost)");  
                   
                   if(tot==null){
                       tot="0";
                   }
               }

         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Food & Beverage Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
         return tot;
     } 
    
    public String deliverycharges(String room){
        String tot="0";
         try {
              String que="select sum(cost) from delivery where roomNo=?";
               pst=con.prepareStatement(que);
               pst.setString(1, room);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   tot=rst.getString("sum(cost)");
                   if(tot==null){
                       tot="0";
                   }
               }

         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Other Item Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         }
             return tot;
                  
     }
    
    public String roomarrangements(String room){
        String tot=null; 
        try {
              String que="select sum(cost) from room_arr where roomID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, room);
               rst=pst.executeQuery();
                            
               if(rst.next())
               {
                   tot=rst.getString("sum(cost)");
                   if(tot==null){
                       tot="0";
                   }
                }
  
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Room Arrangements Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
         
         return tot;
     }
    
     public String securitychg(String room){
        String tot=null; 
        try {
              String que="select sum(cost) from security_info where roomID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, room);
               rst=pst.executeQuery();
                            
               if(rst.next())
               {
                   tot=rst.getString("sum(cost)");
                   if(tot==null){
                       tot="0";
                   }
                }
  
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Security Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
         
         return tot;
     }
     
    public String laundarychg(String room){
        String tot=null; 
        try {
              String que="select sum(cost) from laundry_orders where roomID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, room);
               rst=pst.executeQuery();
                            
               if(rst.next())
               {
                   tot=rst.getString("sum(cost)");
                   if(tot==null){
                       tot="0";
                   }
                }
  
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Laundary Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
         
         return tot;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Reservations;
    private javax.swing.JLabel broom;
    private javax.swing.JTextField cID;
    private javax.swing.JLabel conn;
    private javax.swing.JLabel deposit;
    private javax.swing.JTextField dis;
    private javax.swing.JLabel food;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel laundary;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nettot;
    private javax.swing.JLabel otheritems;
    private javax.swing.JButton print;
    private javax.swing.JLabel rarrangement;
    private javax.swing.JLabel security;
    private javax.swing.JLabel subtotal;
    private javax.swing.JTextArea text;
    private javax.swing.JLabel totc;
    // End of variables declaration//GEN-END:variables
}
