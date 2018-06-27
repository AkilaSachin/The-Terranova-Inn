/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author CJ
 */
public class LaundryInN extends javax.swing.JInternalFrame {
    static  String arrr[]=new String[5];
    Connection con=null;
    PreparedStatement pst=null;
    PreparedStatement pst2=null;
    ResultSet rs=null;
    double precost;
    double QTY1;
    double QTY2;
    double QTY3;
    double QTY4;
    double WTT1;
    double WTT2;
    double WTT3;
    double WTT4;
    
    public void temmp(){
        try{
            int i=0;
            String sqlTMP = "select * from laundry_info";
            pst=con.prepareStatement(sqlTMP);
            rs=pst.executeQuery(sqlTMP);
            while(rs.next()){
               arrr[i]=rs.getString("cost");
               i++;
            }
        }
        catch(Exception we){
            
        }
        QTY1=Double.parseDouble(arrr[0]);
        QTY2=Double.parseDouble(arrr[1]);
        QTY3=Double.parseDouble(arrr[2]);
        QTY4=Double.parseDouble(arrr[3]);
    }
    
    
    
    /**
     * Creates new form LaundryInN
     */
    public void getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        odatebox.setText(dateFormat.format(date));
        //System.out.println(dateFormat.format(date));
    }
    public double washCal(){
        double qw=0,wt=0;
        

        if(lt5itemsradio.isSelected()==true){
            //qw=750.00;
            qw=QTY1;
            //desc=desc.concat(" "+aw);
        }

        if(lt2kgradio.isSelected()==true)
        {
            //qw=1000.00;
            qw=QTY2;
        }

        if(lt5kgradio.isSelected()==true)
        {
            //qw=1250.00;
            qw=QTY3;
        }

        if(gt5kgradio.isSelected()==true)
        {
            //qw=1500.00;
            qw=QTY4;
        }

        if(normalradio.isSelected()==true)
        {
            wt=0.00;
        }

        if(dcradio.isSelected()==true)
        {
            wt=2000.00;
        }
        
        if(shradio.isSelected()==true)
        {
            wt=1000.00;
        }
        
        double tcost=qw+wt;
        return tcost;
    }
    
      
    
    public boolean myLAU(String gid,String serType,String qty,String washType,String total){
            boolean chk=true;
            try{
            String sqlW = "select * from service_info";
            pst=con.prepareStatement(sqlW);
            rs=pst.executeQuery(sqlW);
            while(rs.next()){
                if(gid.equals(rs.getString("guestID")) && serType.equals(rs.getString("serviceType"))){
                    String no=rs.getString("serviceID");
                    
                    double tcostC=Double.parseDouble(rs.getString("total"));
                    String ddd=rs.getString("description");
                    String tt=ddd + " " + qty + ":" + washType;
                    double ttcost=tcostC + Double.parseDouble(total);

                    String ficost="0";
                    String fiecost="0";
                    String fitcost=Double.toString(ttcost);
                    
                    String sql2="update service_info SET serviceType='"+serType+"',description='"+tt+"',cost='"+ficost+"',extraCost='"+fiecost+"',total='"+fitcost+"' where serviceID='"+no+"'";
                    pst2=con.prepareStatement(sql2);
                    pst2.execute();
                    chk=false;
                    
                    break;
                }
            }
            }
            catch(Exception er){
                
            }
            return chk;
    }
    
    
    public void reset(){
        onobox.setText("");
        lt5itemsradio.setSelected(false);
        lt2kgradio.setSelected(false);
        lt5kgradio.setSelected(false);
        gt5kgradio.setSelected(false);
        normalradio.setSelected(false);
        dcradio.setSelected(false);
        shradio.setSelected(false);
        ridbox.setText("");
        gidbox.setText("");
        gnamebox.setText("");
        odatebox.setText("");
        tcostchk.setText("");
        edatebox.setCalendar(null);
    }
    
    public LaundryInN() {
        initComponents();
        
        con=DBconnect.connect();
        
        jPanel7.setVisible(false);
        osearchbox.setVisible(false);
        osbtn.setVisible(false);
        orbtn.setVisible(false);
        load_laundry_info();
        load_guest_info();
        hora.setVisible(false);
        //load_guest_info();
        //load_extra_items();
    }

     public void load_order_history(){
        try{
            osearchbox.setVisible(true);
            osbtn.setVisible(true);
            orbtn.setVisible(true);
            
            
            jPanel7.setVisible(true);
            load_order_table();
            
        }
        catch (Exception e){
            
        }
    }
     
    public void load_order_table(){
        try{
            String type="Laundry";
            String sql="select serviceID as ServiceID,guestID as GuestID,description as Description,total as Total from service_info where serviceType='"+type+"'";
            //String sql="select LorderNo,roomID,guestID,guestName,quantity_weight,orderDate,estDate,washType,totalCost from laundry_orders";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    public void load_gid_related_info(String gid){
        try{
            //String gid=gidbox.getText();
            String sql="select LAUNo,roomID as RoomID,guestID as GuestID,qty as Quantity,orderDate as OrderedDate,estDate as EstimatedDate,washType as WashType,cost as Cost from laundry_orders where guestID='"+gid+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception m){
            
        }
    }
    
    public void load_laundry_info(){
        try{
            String sql="select LINo,laundryType as LaundryType,cost as Cost from laundry_info";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    public void load_guest_info(){
        try{
            String sql="select reservation.roomid as RoomID,reservation.customerID as GuestID,customer.fname as FirstName,customer.lname as LastName from customer,reservation where customer.customerID=reservation.customerID";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        gsearchbox = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        hora = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lt5itemsradio = new javax.swing.JRadioButton();
        lt5kgradio = new javax.swing.JRadioButton();
        lt2kgradio = new javax.swing.JRadioButton();
        gt5kgradio = new javax.swing.JRadioButton();
        dcradio = new javax.swing.JRadioButton();
        shradio = new javax.swing.JRadioButton();
        ridbox = new javax.swing.JTextField();
        gidbox = new javax.swing.JTextField();
        gnamebox = new javax.swing.JTextField();
        tcostchk = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        onobox = new javax.swing.JLabel();
        edatebox = new com.toedter.calendar.JDateChooser();
        odatebox = new javax.swing.JLabel();
        normalradio = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        osearchbox = new javax.swing.JTextField();
        osbtn = new javax.swing.JButton();
        orbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(90, 120, 183));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laundry Service", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel3.setBackground(new java.awt.Color(90, 120, 183));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Guest Info");

        gsearchbox.setToolTipText("Use LastName");
        gsearchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gsearchboxKeyReleased(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(68, 145, 162));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.setToolTipText("Use LastName");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Laundry Info");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/lau.png"))); // NOI18N
        jButton8.setToolTipText("View Order History");
        jButton8.setPreferredSize(new java.awt.Dimension(67, 67));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(gsearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(hora)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addGap(92, 482, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gsearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5)
                                    .addComponent(hora)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(90, 120, 183));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ServiceID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Room ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Guest ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Guest Name");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantity/Weight");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Order Date");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Estimated Date");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Wash Type");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total Cost");

        lt5itemsradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lt5itemsradio.setForeground(new java.awt.Color(255, 255, 255));
        lt5itemsradio.setText("< 5 Items");
        lt5itemsradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lt5itemsradioActionPerformed(evt);
            }
        });

        lt5kgradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lt5kgradio.setForeground(new java.awt.Color(255, 255, 255));
        lt5kgradio.setText("< 5 kg");
        lt5kgradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lt5kgradioActionPerformed(evt);
            }
        });

        lt2kgradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lt2kgradio.setForeground(new java.awt.Color(255, 255, 255));
        lt2kgradio.setText("< 2 kg");
        lt2kgradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lt2kgradioActionPerformed(evt);
            }
        });

        gt5kgradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gt5kgradio.setForeground(new java.awt.Color(255, 255, 255));
        gt5kgradio.setText("> 5 kg");
        gt5kgradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gt5kgradioActionPerformed(evt);
            }
        });

        dcradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dcradio.setForeground(new java.awt.Color(255, 255, 255));
        dcradio.setText("Dry Cleaning");
        dcradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcradioActionPerformed(evt);
            }
        });

        shradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        shradio.setForeground(new java.awt.Color(255, 255, 255));
        shradio.setText("Seperate Handwash");
        shradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shradioActionPerformed(evt);
            }
        });

        tcostchk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tcostchkMouseClicked(evt);
            }
        });
        tcostchk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcostchkActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(68, 145, 162));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(68, 145, 162));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(68, 145, 162));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        onobox.setBackground(new java.awt.Color(255, 255, 255));
        onobox.setForeground(new java.awt.Color(255, 255, 255));
        onobox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        onobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onoboxMouseClicked(evt);
            }
        });

        odatebox.setBackground(new java.awt.Color(255, 255, 255));
        odatebox.setForeground(new java.awt.Color(255, 255, 255));
        odatebox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        odatebox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                odateboxMouseClicked(evt);
            }
        });
        odatebox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                odateboxPropertyChange(evt);
            }
        });

        normalradio.setForeground(new java.awt.Color(255, 255, 255));
        normalradio.setText("Normal");
        normalradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalradioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcradio)
                            .addComponent(shradio)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lt5itemsradio)
                                .addGap(18, 18, 18)
                                .addComponent(lt2kgradio))
                            .addComponent(gnamebox)
                            .addComponent(gidbox)
                            .addComponent(ridbox)
                            .addComponent(onobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lt5kgradio)
                                .addGap(34, 34, 34)
                                .addComponent(gt5kgradio))
                            .addComponent(normalradio)
                            .addComponent(tcostchk)
                            .addComponent(odatebox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edatebox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(onobox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ridbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(gidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gnamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lt5itemsradio)
                    .addComponent(lt2kgradio)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lt5kgradio)
                    .addComponent(gt5kgradio))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(odatebox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edatebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(normalradio))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(dcradio)
                        .addGap(18, 18, 18)
                        .addComponent(shradio)
                        .addGap(14, 14, 14)
                        .addComponent(tcostchk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(90, 120, 183));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order History", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        osearchbox.setToolTipText("Use GuestID");
        osearchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                osearchboxKeyReleased(evt);
            }
        });

        osbtn.setBackground(new java.awt.Color(68, 145, 162));
        osbtn.setForeground(new java.awt.Color(255, 255, 255));
        osbtn.setText("Search");
        osbtn.setToolTipText("Use GuestID");
        osbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osbtnActionPerformed(evt);
            }
        });

        orbtn.setBackground(new java.awt.Color(68, 145, 162));
        orbtn.setForeground(new java.awt.Color(255, 255, 255));
        orbtn.setText("Reset");
        orbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(osearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(osbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osbtn)
                    .addComponent(orbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gt5kgradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gt5kgradioActionPerformed
        // TODO add your handling code here:
        
        if(gt5kgradio.isSelected()){
            lt2kgradio.setSelected(false);
            lt5kgradio.setSelected(false);
            lt5itemsradio.setSelected(false);
        }
    }//GEN-LAST:event_gt5kgradioActionPerformed

    private void dcradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcradioActionPerformed
        // TODO add your handling code here:
        
        if(dcradio.isSelected()){
            shradio.setSelected(false);
            normalradio.setSelected(false);
            
        }
    }//GEN-LAST:event_dcradioActionPerformed

    private void tcostchkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcostchkActionPerformed
        // TODO add your handling code here:
        
        //tcostchk.setText("5000");
    }//GEN-LAST:event_tcostchkActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null, "Do you really want to delete this ?");

        if(x==0){
            String no=onobox.getText();
            String gid=gidbox.getText();
            String sql="delete from laundry_orders where guestID='"+gid+"'";

            try{
                pst=con.prepareStatement(sql);
                pst.execute();
                //load table
                load_order_table();
                reset();
                load_gid_related_info(gid);

                try {
                    
                   String id=gidbox.getText();
                    String s="delete from servicemobil where cusid=?";
                    pst=con.prepareStatement(s);
                    pst.setString(1, id);
                    pst.execute();
                
            } catch (Exception e) {
                System.out.println("service"+e);
            }
                
                
                
                
            }
            catch (Exception e){

            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lt5itemsradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lt5itemsradioActionPerformed
        // TODO add your handling code here:
        if(lt5itemsradio.isSelected()){
            lt2kgradio.setSelected(false);
            lt5kgradio.setSelected(false);
            gt5kgradio.setSelected(false);
        }
    }//GEN-LAST:event_lt5itemsradioActionPerformed

    private void lt2kgradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lt2kgradioActionPerformed
        // TODO add your handling code here:
        if(lt2kgradio.isSelected()){
            lt5kgradio.setSelected(false);
            gt5kgradio.setSelected(false);
            lt5itemsradio.setSelected(false);
        }
    }//GEN-LAST:event_lt2kgradioActionPerformed

    private void lt5kgradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lt5kgradioActionPerformed
        // TODO add your handling code here:
        
        if(lt5kgradio.isSelected()){
            lt2kgradio.setSelected(false);
            gt5kgradio.setSelected(false);
            lt5itemsradio.setSelected(false);
        }
    }//GEN-LAST:event_lt5kgradioActionPerformed

    private void shradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shradioActionPerformed
        // TODO add your handling code here:
        
        if(shradio.isSelected()){
            dcradio.setSelected(false);
            normalradio.setSelected(false);
        }
    }//GEN-LAST:event_shradioActionPerformed

    private void normalradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalradioActionPerformed
        // TODO add your handling code here:
        if(normalradio.isSelected()){
            shradio.setSelected(false);
            dcradio.setSelected(false);
        }
    }//GEN-LAST:event_normalradioActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        load_order_history();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //onobox.getText().isEmpty() || 
        if(ridbox.getText().isEmpty() || gidbox.getText().isEmpty() || gnamebox.getText().isEmpty() || odatebox.getText().isEmpty() || tcostchk.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Attention!", JOptionPane.WARNING_MESSAGE);
            
        }
        else{
            String rid=ridbox.getText();
            String gid=gidbox.getText();
            String gname=gnamebox.getText();
            String odate=odatebox.getText();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String edate = dcn.format(edatebox.getDate());

            String qty="",wash="";
            if(lt5itemsradio.isSelected()==true){
                qty="<5";
            }

            if(lt2kgradio.isSelected()==true)
            {
                qty="<2kg";
            }

            if(lt5kgradio.isSelected()==true)
            {
                qty="<5kg";
            }

            if(gt5kgradio.isSelected()==true)
            {
                qty=">5kg";
            }

            if(normalradio.isSelected()==true)
            {
                wash="normal";
            }

            if(dcradio.isSelected()==true)
            {
                wash="dryClean";
            }

            if(shradio.isSelected()==true)
            {
                wash="seperateHandwash";
            }

            String tot=tcostchk.getText();
            String serType="Laundry";
            String cost="0";
            String ecost="0";
            String tcst=tcostchk.getText();

            try{

                String q="insert into laundry_orders (roomID,guestID,qty,orderDate,estDate,washType,cost) values ('"+rid+"','"+gid+"','"+qty+"','"+odate+"','"+edate+"','"+wash+"','"+tcst+"')";
                pst=con.prepareStatement(q);
                pst.execute();

                boolean result=myLAU(gid,serType,qty,wash,tot);
                    if(result==true){
                        String Ntype=qty + ":" + wash;
                        String sql2="insert into service_info (guestID,serviceType,description,cost,extraCost,total) values ('"+gid+"','"+serType+"','"+Ntype+"','"+cost+"','"+ecost+"','"+tot+"')";
                        pst2=con.prepareStatement(sql2);
                        pst2.execute();

                        //break;
                    }
                JOptionPane.showMessageDialog(this,"Successfully saved");
                load_order_history();
                reset();
                
                 try {
                String q1="INSERT INTO servicemobil ( `name`, `desc`, `price`, `cusid`) VALUES ( ?, ?, ?,?) ";
                pst=con.prepareStatement(q1);
                pst.setString(1, serType);
                pst.setString(2, serType);
                pst.setString(3, tot);
                pst.setString(4, gid);
                pst.execute();
                } catch (Exception e) {
                    System.out.println("service mobile"+e);
                }
                 load_gid_related_info(gid);
            }
            catch(Exception et){

            }
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tcostchkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tcostchkMouseClicked
        // TODO add your handling code here:
        double qw=0,wt=0;
        

        if(lt5itemsradio.isSelected()==true){
            qw=750.00;
            //desc=desc.concat(" "+aw);
        }

        if(lt2kgradio.isSelected()==true)
        {
            qw=1000.00;
        }

        if(lt5kgradio.isSelected()==true)
        {
            qw=1250.00;
        }

        if(gt5kgradio.isSelected()==true)
        {
            qw=1500.00;
        }

        if(normalradio.isSelected()==true)
        {
            wt=0.00;
        }

        if(dcradio.isSelected()==true)
        {
            wt=2000.00;
        }
        
        if(shradio.isSelected()==true)
        {
            wt=1000.00;
        }
        
        double tcost=qw+wt;
        tcostchk.setText(Double.toString(tcost));
    }//GEN-LAST:event_tcostchkMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        reset();
        load_laundry_info();
        jLabel3.setText("Laundry Info");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null,"Do you really want to update ?");
        
        if(x==0){
            String lno=onobox.getText();
            String rid=ridbox.getText();
            String gid=gidbox.getText();
            String gname=gnamebox.getText();
            String odate=odatebox.getText();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String edate = dcn.format(edatebox.getDate());
            String ndesc;
        
            String qty="",wash="";
                if(lt5itemsradio.isSelected()==true){
                    qty="<5";
                }

                if(lt2kgradio.isSelected()==true)
                {
                    qty="<2kg";
                }

                if(lt5kgradio.isSelected()==true)
                {
                    qty="<5kg";
                }

                if(gt5kgradio.isSelected()==true)
                {
                    qty=">5kg";
                }

                if(normalradio.isSelected()==true)
                {
                    wash="normal";
                }

                if(dcradio.isSelected()==true)
                {
                    wash="dryClean";
                }

                if(shradio.isSelected()==true)
                {
                    wash="seperateHandwash";
                }
            ndesc=qty + ":" + wash + " ";
            String tot=tcostchk.getText();
            String hr=hora.getText();
            
            try{
                String serType="Laundry";
                    
                String sq = "select * from service_info";
                pst=con.prepareStatement(sq);
                    

                rs= pst.executeQuery(sq);
                    while(rs.next()) {
                        if(gid.equals(rs.getString("guestID")) && serType.equals(rs.getString("serviceType"))){
                            String no=rs.getString("serviceID");
                            Double exTot=Double.parseDouble(rs.getString("total"));
                            String tdesc=rs.getString("description");
                            String Newdesc=" " + tdesc + ndesc;
                            //new next
                            Double nExtot=exTot-precost;
                            Double nTot=Double.parseDouble(tcostchk.getText());

                            //Double fiTot=exTot + nTot;
                            Double fiTot=nExtot + nTot;
                            String todbTot=Double.toString(fiTot);
                            String serUp="update service_info SET description='"+Newdesc+"',total='"+todbTot+"' where serviceID='"+lno+"'";
                            pst=con.prepareStatement(serUp);
                            pst.execute();
                        }
                    }
                /*String sqNew = "select * laundry_orders";
                pst=con.prepareStatement(sqNew);
                
                rs= pst.executeQuery(sqNew);
                    while(rs.next()) {
                        if(hr.equals(rs.getString("LAUNo")) && gid.equals(rs.getString("guestID"))){
                            String ln=rs.getString("LAUNo");
                            String ssql="update laundry_orders SET qty='"+qty+"',estDate='"+edate+"',washType='"+wash+"' where LAUNo='"+hr+"'";
                            pst=con.prepareStatement(ssql);
                            pst.execute();
                        }
                    }*/
                /*String qqq="select * from laundry_orders";
                pst=con.prepareStatement(qqq);
                rs= pst.executeQuery(qqq);
                while(rs.next()){
                    String 
                }*/
                String ssql="update laundry_orders SET qty='"+qty+"',estDate='"+edate+"',washType='"+wash+"',cost='"+tot+"' where LAUNo='"+hr+"'";    
                pst=con.prepareStatement(ssql);
                pst.execute();
                //msgbox
                JOptionPane.showMessageDialog(this,"Successfully upddated");
                
                //load table
                load_order_history();
                reset();
                
                try {
                    String ss="update servicemobil set name=?,desc=?,price=? where cusid=?";
                    pst=con.prepareStatement(ss);
                    pst.setString(1, wash);
                    pst.setString(2, wash);
                    pst.setString(3, tot);
                    pst.setString(4, gid);
                    pst.execute();
                    
                } catch (Exception e1) {
                    System.out.println("service "+e1);
                }
                
            }
            catch (Exception e){
                
            }
        }
        reset();
        load_laundry_info();
        jLabel3.setText("Laundry Info");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void onoboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onoboxMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT serviceID+1 from service_info";
            pst=con.prepareStatement(sql);
            //pst.setString(1,EmployeeIDSearchField.getText());

            rs= pst.executeQuery(sql);
            while(rs.next()) {
                onobox.setText(rs.getString("serviceID+1"));
            }
        }
        catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_onoboxMouseClicked

    private void odateboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odateboxMouseClicked
        // TODO add your handling code here:
        getDateTime();
    }//GEN-LAST:event_odateboxMouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton8MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        
        reset();
        int r3=jTable4.getSelectedRow();

        String ONO=jTable4.getValueAt(r3, 0).toString();
        String GID=jTable4.getValueAt(r3, 1).toString();
        String DES=jTable4.getValueAt(r3, 2).toString();
        String TOTAL=jTable4.getValueAt(r3, 3).toString();
        
        onobox.setText(ONO);
        
        gidbox.setText(GID);
        
        //tcostchk.setText(TOTAL);
        
        
        try{
                //String gid=gidbox.getText();
                String sql = "SELECT * from customer where customerID='"+GID+"'";
                pst=con.prepareStatement(sql);
                //pst.setString(1,EmployeeIDSearchField.getText());

                rs= pst.executeQuery(sql);
                while(rs.next()) {
                    String name1=rs.getString("fname");
                    String name2=rs.getString("lname");
                    String fullname=name1 + " " + name2;
                    gnamebox.setText(fullname);
                    
                }
                
                /*String sql2 = "SELECT customerID,roomid from reservation where customerID='"+GID+"'";
                pst=con.prepareStatement(sql2);
                rs= pst.executeQuery(sql);
                while(rs.next()) {
                    String rid=rs.getString("roomid");
                    
                    ridbox.setText(rid);
                    
                }*/
            }
            catch(Exception m){
                
            }
        jLabel3.setText("All " + GID + " orders");
        load_gid_related_info(GID);
        
        
        
        
    }//GEN-LAST:event_jTable4MouseClicked

    private void osbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osbtnActionPerformed
        // TODO add your handling code here:
        String name=osearchbox.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";

        String sql="select LorderNo,roomID,guestID,guestName,quantity_weight,orderDate,estDate,washType,totalCost from laundry_orders where guestID like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            osearchbox.setText("");
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_osbtnActionPerformed

    private void orbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orbtnActionPerformed
        // TODO add your handling code here:
        load_order_table();
        osearchbox.setText("");
    }//GEN-LAST:event_orbtnActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r=jTable2.getSelectedRow();
        String rid=jTable2.getValueAt(r, 0).toString();
        String gid=jTable2.getValueAt(r, 1).toString();
        String fname=jTable2.getValueAt(r, 2).toString();
        String lname=jTable2.getValueAt(r, 3).toString();

        ridbox.setText(rid);
        gidbox.setText(gid);
        gnamebox.setText(fname+" "+lname);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String name=gsearchbox.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";

        String sql="select reservation.roomid as RoomID,reservation.customerID as GuestID,customer.fname as FirstName,customer.lname as LastName from customer,reservation where customer.customerID=reservation.customerID AND customer.lname like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            gsearchbox.setText("");
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void odateboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_odateboxPropertyChange
        // TODO add your handling code here:
        edatebox.setMinSelectableDate(new Date());
    }//GEN-LAST:event_odateboxPropertyChange

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        String tmp="All " + gidbox.getText() + " orders";
        
        if(tmp.equals(jLabel3.getText())){
            int r=jTable3.getSelectedRow();
            String lau=jTable3.getValueAt(r, 0).toString();
            String rid=jTable3.getValueAt(r, 1).toString();
            String gid=jTable3.getValueAt(r, 2).toString();
            String qty=jTable3.getValueAt(r, 3).toString();
            String odate=jTable3.getValueAt(r, 4).toString();
            String estdate=jTable3.getValueAt(r, 5).toString();
            String wash=jTable3.getValueAt(r, 6).toString();
            String cstt=jTable3.getValueAt(r, 7).toString();
            
            tcostchk.setText(cstt);
            hora.setText(lau);
            ridbox.setText(rid);
            odatebox.setText(odate);
            java.util.Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(estdate);
                edatebox.setDate(date);
            } 
            catch (ParseException ex) {
            }
            
            String qty1="<5";
            String qty2="<2kg";
            String qty3="<5kg";
            String qty4=">5kg";
            String wash1="normal";
            String wash2="dryClean";
            String wash3="seperateHandwash";
            if(qty.equals(qty1)){
                lt5itemsradio.setSelected(true);
                lt2kgradio.setSelected(false);
                lt5kgradio.setSelected(false);
                gt5kgradio.setSelected(false);
            }

            if(qty.equals(qty2))
            {
                lt2kgradio.setSelected(true);
                lt5itemsradio.setSelected(false);
                lt5kgradio.setSelected(false);
                gt5kgradio.setSelected(false);
            }

            if(qty.equals(qty3))
            {
                lt5kgradio.setSelected(true);
                lt2kgradio.setSelected(false);
                lt5itemsradio.setSelected(false);
                gt5kgradio.setSelected(false);
            }

            if(qty.equals(qty4))
            {
                gt5kgradio.setSelected(true);
                lt5kgradio.setSelected(false);
                lt2kgradio.setSelected(false);
                lt5itemsradio.setSelected(false);
            }

            if(wash.equals(wash1))
            {
                normalradio.setSelected(true);
                dcradio.setSelected(false);
                shradio.setSelected(false);
            }

            if(wash.equals(wash2))
            {
                dcradio.setSelected(true);
                normalradio.setSelected(false);
                shradio.setSelected(false);
            }

            if(wash.equals(wash3))
            {
                shradio.setSelected(true);
                normalradio.setSelected(false);
                dcradio.setSelected(false);
            }
            
            
        }
        precost=washCal();
    }//GEN-LAST:event_jTable3MouseClicked

    private void gsearchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gsearchboxKeyReleased
        // TODO add your handling code here:
        String name=gsearchbox.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";

        String sql="select reservation.roomid as RoomID,reservation.customerID as GuestID,customer.fname as FirstName,customer.lname as LastName from customer,reservation where customer.customerID=reservation.customerID AND customer.lname like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            //gsearchbox.setText("");
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_gsearchboxKeyReleased

    private void osearchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_osearchboxKeyReleased
        // TODO add your handling code here:
        String name=osearchbox.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";
        String type="Laundry";
        String sql="select serviceID,guestID,description as Description,total as Total from service_info where serviceType='"+type+"' and guestID like '"+ser+"'";
        //String sql="select LorderNo,roomID,guestID,guestName,quantity_weight,orderDate,estDate,washType,totalCost from laundry_orders where guestID like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            //osearchbox.setText("");
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_osearchboxKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dcradio;
    private com.toedter.calendar.JDateChooser edatebox;
    private javax.swing.JTextField gidbox;
    private javax.swing.JTextField gnamebox;
    private javax.swing.JTextField gsearchbox;
    private javax.swing.JRadioButton gt5kgradio;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JRadioButton lt2kgradio;
    private javax.swing.JRadioButton lt5itemsradio;
    private javax.swing.JRadioButton lt5kgradio;
    private javax.swing.JRadioButton normalradio;
    private javax.swing.JLabel odatebox;
    private javax.swing.JLabel onobox;
    private javax.swing.JButton orbtn;
    private javax.swing.JButton osbtn;
    private javax.swing.JTextField osearchbox;
    private javax.swing.JTextField ridbox;
    private javax.swing.JRadioButton shradio;
    private javax.swing.JTextField tcostchk;
    // End of variables declaration//GEN-END:variables
}
