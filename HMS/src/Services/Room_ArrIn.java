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
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author CJ
 */
public class Room_ArrIn extends javax.swing.JInternalFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
    PreparedStatement pst2=null;
    ResultSet rs=null;
    String req=" ";
    
    public void load_room_arr_history(){
        try{
            searchbox.setVisible(true);
            sbutton.setVisible(true);
            rbutton.setVisible(true);
            
            
            jPanel4.setVisible(true);
            load_guest_ra_history();
            
            
        }
        catch (Exception e){
            
        }
    }
    //test
    
    public String chkreq(){
        for(int i=0;i<1;i++){
            if(lightchk.isSelected()){
                req=req + "Light Furniture, ";
            }
            if(heavychk.isSelected()){
                req=req + "Heavy Furniture, ";
            }
            if(elecchk.isSelected()){
                req=req + "Electronic Appliances, ";
            }
            if(int1chk.isSelected()){
                req=req + "Internet-Package 1, ";
            }
            if(int2chk.isSelected()){
                req=req + "Internet-Package 2, ";
            }
            if(otherchk.isSelected()){
                req=req + "Other, ";
            }
        }
        return req;
    }
    
    
    private void my(java.awt.event.ActionEvent evt) {                                         
    Double cb1,cb2,cb3,cb4,cb5,cb6;
    Double total=0d;
    if (lightchk.isSelected() == true) {
        lightchk.setText("50");
    }
     else lightchk.setText("");
    if (heavychk.isSelected() == true) {heavychk.setText("50");}
     else heavychk.setText("");
    if (elecchk.isSelected() == true) {elecchk.setText("50");}
     else elecchk.setText("");
    /*if (jCheckBox4.isSelected() == true) {jCheckBox4.setText("50");}
     else jCheckBox4.setText("");
    if (jCheckBox5.isSelected() == true) {jCheckBox5.setText("50");}
     else jCheckBox5.setText("");
    if (jCheckBox6.isSelected() == true) {jCheckBox6.setText("50");}
     else jCheckBox6.setText("");*/
    cb1=Double.parseDouble((lightchk.getText().equals(""))?"0":"50");
    cb2=Double.parseDouble((heavychk.getText().equals(""))?"0":"50");
    cb3=Double.parseDouble((elecchk.getText().equals(""))?"0":"50");
    /*cb4=Double.parseDouble((jCheckBox4.getText().equals(""))?"0":"50");
    cb5=Double.parseDouble((jCheckBox5.getText().equals(""))?"0":"50");
    cb6=Double.parseDouble((jCheckBox6.getText().equals(""))?"0":"50");*/
    total=cb1+cb2+cb3;
    totalbox.setText(""+total);    
}
    
    //test
    
    public void reset(){
        nobox.setText("");
        idbox.setText("");
        ridlbl.setText("");
        namebox.setText("");
        desbox.setText("");
        totalbox.setText("");
        lightchk.setSelected(false);
        heavychk.setSelected(false);
        elecchk.setSelected(false);
        int1chk.setSelected(false);
        int2chk.setSelected(false);
        otherchk.setSelected(false);
    }

    /**
     * Creates new form Room_ArrIn
     */
    public Room_ArrIn() {
        initComponents();
        
        
        //db connect
        con=DBconnect.connect();
        
        jPanel4.setVisible(false);
        searchbox.setVisible(false);
        sbutton.setVisible(false);
        rbutton.setVisible(false);
        hide.setVisible(false);
        
        
        load_guest_info();
        load_extra_items();
        //load_guest_ra_history();
    }
    
    public boolean myRA(String gid,String rid,String serType,String req,String des,String total){
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
                    String tt=ddd + ", " + req;
                    String co=rs.getString("comments");
                    String comm=co + ";" + des;
                    double ttcost=tcostC + Double.parseDouble(total);

                    String ficost="0";
                    String fiecost="0";
                    String fitcost=Double.toString(ttcost);
                    
                    String sql2="update service_info SET serviceType='"+serType+"',description='"+tt+"',comments='"+comm+"',cost='"+ficost+"',extraCost='"+fiecost+"',total='"+fitcost+"' where serviceID='"+no+"'";
                    pst2=con.prepareStatement(sql2);
                    pst2.execute();
                    chk=false;
                    
                    /*String sql3="insert into room_arr (guestID,roomID,description,cost) values ('"+gid+"','"+rid+"','"+des+"','"+total+"')";
                    pst2=con.prepareStatement(sql3);
                    pst2.execute();*/
                    
                    break;
                }
            }
            }
            catch(Exception er){
                
            }
            return chk;
    }
    
    public void load_guest_info(){
        try{
            String sql="select reservation.roomid as RoomID,reservation.customerID as GuestID,customer.fname as FirstName,customer.lname as LastName from customer,reservation where customer.customerID=reservation.customerID";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    public void load_extra_items(){
        try{
            String sql="select itemNo as ItemNo,item_type as ItemType,description as Description,cost as Cost from extra_items_info";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    
    public void load_gid_related_info(String gid){
        try{
            //String gid=gidbox.getText();
            String sql="select guestID as GuestID,roomID as RoomID,description as Description,cost as Cost from room_arr where guestID='"+gid+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception m){
            
        }
    }
    
    
    public void load_guest_ra_history(){
        try{
            String ser="RoomArrangement";
            String sql="select serviceID as ServiceID,guestID as GuestID,description as Requirements,comments as Description,total as Total from service_info where serviceType='"+ser+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lightchk = new javax.swing.JCheckBox();
        heavychk = new javax.swing.JCheckBox();
        elecchk = new javax.swing.JCheckBox();
        int1chk = new javax.swing.JCheckBox();
        int2chk = new javax.swing.JCheckBox();
        otherchk = new javax.swing.JCheckBox();
        desbox = new javax.swing.JTextField();
        totalbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nobox = new javax.swing.JLabel();
        namebox = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        ridlbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        gsearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        searchbox = new javax.swing.JTextField();
        sbutton = new javax.swing.JButton();
        rbutton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        hide = new javax.swing.JLabel();

        setBackground(new java.awt.Color(90, 120, 183));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));
        jPanel1.setPreferredSize(new java.awt.Dimension(1060, 650));

        jPanel2.setBackground(new java.awt.Color(90, 120, 183));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Arrangement", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Guest ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Guest Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Requirements");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Description");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total");

        lightchk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lightchk.setForeground(new java.awt.Color(255, 255, 255));
        lightchk.setText("Light Furniture");
        lightchk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightchkActionPerformed(evt);
            }
        });

        heavychk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        heavychk.setForeground(new java.awt.Color(255, 255, 255));
        heavychk.setText("Heavy Furniture");
        heavychk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heavychkActionPerformed(evt);
            }
        });

        elecchk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        elecchk.setForeground(new java.awt.Color(255, 255, 255));
        elecchk.setText("Electrical Appliances");
        elecchk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elecchkActionPerformed(evt);
            }
        });

        int1chk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        int1chk.setForeground(new java.awt.Color(255, 255, 255));
        int1chk.setText("Internet - Package 1");
        int1chk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int1chkActionPerformed(evt);
            }
        });

        int2chk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        int2chk.setForeground(new java.awt.Color(255, 255, 255));
        int2chk.setText("Internet - Package 2");
        int2chk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int2chkActionPerformed(evt);
            }
        });

        otherchk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        otherchk.setForeground(new java.awt.Color(255, 255, 255));
        otherchk.setText("Other");
        otherchk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherchkActionPerformed(evt);
            }
        });

        totalbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalboxActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(68, 145, 162));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 145, 162));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ServiceID");

        nobox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nobox.setForeground(new java.awt.Color(255, 255, 255));
        nobox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noboxMouseClicked(evt);
            }
        });

        namebox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namebox.setForeground(new java.awt.Color(255, 255, 255));
        namebox.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        idbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idbox.setForeground(new java.awt.Color(255, 255, 255));
        idbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ridlbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ridlbl.setForeground(new java.awt.Color(255, 255, 255));
        ridlbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Room ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel10))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(desbox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nobox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ridlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(int1chk)
                                    .addComponent(int2chk)
                                    .addComponent(otherchk)
                                    .addComponent(elecchk)
                                    .addComponent(heavychk)
                                    .addComponent(lightchk)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
                        .addComponent(jButton2)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nobox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ridlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lightchk)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(heavychk)
                .addGap(18, 18, 18)
                .addComponent(elecchk)
                .addGap(18, 18, 18)
                .addComponent(int1chk)
                .addGap(18, 18, 18)
                .addComponent(int2chk)
                .addGap(18, 18, 18)
                .addComponent(otherchk)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(desbox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(90, 120, 183));
        jPanel3.setForeground(new java.awt.Color(85, 68, 162));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Guest Info");

        gsearch.setToolTipText("Use LastName");
        gsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gsearchActionPerformed(evt);
            }
        });
        gsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gsearchKeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(68, 145, 162));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search");
        jButton4.setToolTipText("Use LastName");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Extra Requirements");

        jPanel4.setBackground(new java.awt.Color(90, 120, 183));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Arrangement History", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(90, 120, 183));

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

        searchbox.setToolTipText("Use GuestID");
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchboxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchboxKeyTyped(evt);
            }
        });

        sbutton.setBackground(new java.awt.Color(68, 145, 162));
        sbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sbutton.setForeground(new java.awt.Color(255, 255, 255));
        sbutton.setText("Search");
        sbutton.setToolTipText("Use GuestID");
        sbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbuttonActionPerformed(evt);
            }
        });

        rbutton.setBackground(new java.awt.Color(68, 145, 162));
        rbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbutton.setForeground(new java.awt.Color(255, 255, 255));
        rbutton.setText("Reset");
        rbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbuttonActionPerformed(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbutton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sbutton)
                        .addComponent(rbutton))
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/roomarr.png"))); // NOI18N
        jButton7.setToolTipText("Room Arrangement History");
        jButton7.setPreferredSize(new java.awt.Dimension(75, 75));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(gsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(453, 453, 453))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(hide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
        //load_guest_info();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(ridlbl.getText().isEmpty() || idbox.getText().isEmpty() || namebox.getText().isEmpty() || totalbox.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Attention!", JOptionPane.WARNING_MESSAGE);
            
        }
        else{
            
            String id=idbox.getText();
            String rid=ridlbl.getText();
            String name=namebox.getText();
            String rreq="";
            Boolean tmp=false;
            String a1="",a2="",a3="",a4="",a5="",a6="";
            String req1="",req2="",req3="",req4="",req5="",req6="";
            String s1="",s2="",s3="",s4="",s5="",s6="";
            String desc=desbox.getText();
            String ssname="";
            /*
            if(lightchk.isSelected()==true){
                    req1="IT01";
                    s1="Light Furniture";
                    hide.setText(hide.getText() + req1 + ":" + s1 + " ");
                }
                
                if(heavychk.isSelected()==true)
                {
                    req2="IT02";
                    s2="Heavy Furniture";
                    hide.setText(hide.getText() + req3 + ":" + s2 + " ");
                }
                 
                if(elecchk.isSelected()==true)
                {
                    req3="IT03";
                    s3="Electrical Appliances";
                    hide.setText(hide.getText() + req3 + ":" + s3 + " ");
                }
                
                if(int1chk.isSelected()==true)
                {
                    req4="IT04";
                    s4="Internet Package-1";
                    hide.setText(hide.getText() + req4 + ":" + s4 + " ");
                }
                
                if(int2chk.isSelected()==true)
                {
                    req5="IT05";
                    s5="Internet Package-2";
                    hide.setText(hide.getText() + req5 + ":" + s5 + " ");
                }
                
                if(otherchk.isSelected()==true)
                {
                    req6="IT06";
                    s6="Other";
                    hide.setText(hide.getText() + req6 + ":" + s6 + " ");

                }*/
            
            desc=desbox.getText();
            String tot=totalbox.getText();
            


            try{
                    String q="";
                    String serType="RoomArrangement";
                    String cost="0";
                    String ecost="0";
                    String Ntype=hide.getText();
                    String reqs=chkreq();
                    
                    String sqlM="select * from reservation where roomid='"+rid+"'";
                    pst2=con.prepareStatement(sqlM);
                    rs= pst2.executeQuery(sqlM);
                    while(rs.next()){
                        if(rid.equals(rs.getString("roomid"))){
                            String chkIN=rs.getString("checkindate");
                            String chkOUT=rs.getString("checkoutdate");
                            
                            String sql22="insert into room_arr (guestID,roomID,description,cost,checkIN,checkOUT) values ('"+id+"','"+rid+"','"+reqs+"','"+tot+"','"+chkIN+"','"+chkOUT+"')";
                            pst2=con.prepareStatement(sql22);
                            pst2.execute();
                            break;
                        }
                     }
                    
                    

                    boolean result=myRA(id,rid,serType,reqs,desc,tot);
                        if(result==true){
                            

                            String sql2="insert into service_info (guestID,roomID,serviceType,description,comments,cost,extraCost,total) values ('"+id+"','"+rid+"','"+serType+"','"+reqs+"','"+desc+"','"+cost+"','"+ecost+"','"+tot+"')";
                            pst2=con.prepareStatement(sql2);
                            pst2.execute();
                            
                            

                            //break;
                        }
                        

                        JOptionPane.showMessageDialog(this,"Successfully saved");

                        load_guest_ra_history();
                        hide.setText("");
                        reset();

                        try {


                            String q1="INSERT INTO servicemobil ( `name`, `desc`, `price`, `cusid`) VALUES ( ?, ?, ?,?) ";
                            pst=con.prepareStatement(q1);
                            pst.setString(1, Ntype);
                            pst.setString(2, desc);
                            pst.setString(3, tot);
                            pst.setString(4, id);
                            pst.execute();
                            } catch (Exception e) {
                                System.out.println("service mobile"+e);
                            }
                        }
            catch(Exception ew){

            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null, "Do you really want to delete this ?");

        if(x==0){
            String stype="RoomArrangement";
            String id=idbox.getText();
            String sql="delete from service_info where guestID='"+id+"' and serviceType='"+stype+"'";

            try{
                pst=con.prepareStatement(sql);
                pst.execute();

                //load table
                load_guest_ra_history();
                reset();
            }
            catch (Exception e){

            }
            
            try {
                String s="delete from servicemobil where cusid=?";
                pst=con.prepareStatement(s);
                pst.setString(1, id);
                pst.execute();
                
            } catch (Exception e) {
                System.out.println("service"+e);
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void noboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noboxMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT serviceID+1 from service_info";
            pst=con.prepareStatement(sql);
            //pst.setString(1,EmployeeIDSearchField.getText());

            rs= pst.executeQuery(sql);
            while(rs.next()) {
                nobox.setText(rs.getString("serviceID+1"));
            }
        }
        catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_noboxMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int r=jTable1.getSelectedRow();
        String rid=jTable1.getValueAt(r, 0).toString();
        String gid=jTable1.getValueAt(r, 1).toString();
        String fname=jTable1.getValueAt(r, 2).toString();
        String lname=jTable1.getValueAt(r, 3).toString();

        ridlbl.setText(rid);
        idbox.setText(gid);
        namebox.setText(fname+" "+lname);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        /*String tt="";
        int r2=jTable2.getSelectedRow();
        String ino=jTable2.getValueAt(r2, 0).toString();
        String ina=jTable2.getValueAt(r2, 1).toString();
        String dc=jTable2.getValueAt(r2, 2).toString();
        String cs=jTable2.getValueAt(r2, 3).toString();
        String temp="";

        String s1="IT01";
        String s2="IT02";
        String s3="IT03";
        String s4="IT04";
        String s5="IT05";
        String s6="IT06";

        double now=Double.parseDouble(cs);
        double old=0;
        String f=null;
        if(totalbox.getText().equals(temp)){
            old=0;
            f=Double.toString(now);
            totalbox.setText(f);
        }
        else{
            old=Double.parseDouble(totalbox.getText());
            double total=old + now;
            f=Double.toString(total);
            totalbox.setText(f);
        }
        /*totalbox.setText(cs);
        //double now=Double.parseDouble(totalbox.getText());
        double old=Double.parseDouble(totalbox.getText());
        double total=old + now;
        String a="A";
        totalbox.setText(cs);
        desbox.setText(dc);

        if(ino.equals(s1)){
            lightchk.setSelected(true);

            //lightchk.setEnabled(true);
        }
        if(ino.equals(s2)){
            heavychk.setSelected(true);
        }
        if(ino.equals(s3)){
            elecchk.setSelected(true);
        }
        if(ino.equals(s4)){
            int1chk.setSelected(true);
        }
        if(ino.equals(s5)){
            int2chk.setSelected(true);
        }
        if(ino.equals(s6)){
            otherchk.setSelected(true);
        }*/
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        
        int r3=jTable3.getSelectedRow();
        
        String sid=jTable3.getValueAt(r3, 0).toString();
        String gid=jTable3.getValueAt(r3, 1).toString();
        //String rid=jTable3.getValueAt(r3, 2).toString();
        String des=jTable3.getValueAt(r3, 2).toString();
        String comm=jTable3.getValueAt(r3, 3).toString();
        String cst=jTable3.getValueAt(r3, 4).toString();
        
        //ridlbl.setText(rid);
        nobox.setText(sid);
        idbox.setText(gid);
        

        desbox.setText(des + " " + comm);
        //totalbox.setText(cst);
        try {
            String sql = "SELECT * from customer where customerID='"+gid+"'";
            pst=con.prepareStatement(sql);
            //pst.setString(1,EmployeeIDSearchField.getText());

            rs= pst.executeQuery(sql);
            while(rs.next()) {
                String fname=(rs.getString("fname"));
                String lname=(rs.getString("lname"));
                String full=(fname + " " +lname);
                namebox.setText(full);
            }
        }
        catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
        jLabel9.setText("All " + gid + " orders");
        load_gid_related_info(gid);

    }//GEN-LAST:event_jTable3MouseClicked

    private void sbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbuttonActionPerformed
        // TODO add your handling code here:
        String name=searchbox.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";

        String sql="select RANo,guestID,name,Requirements,description,cost from guest_ra_cost where guestID like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_sbuttonActionPerformed

    private void rbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbuttonActionPerformed
        // TODO add your handling code here:
        load_guest_ra_history();
    }//GEN-LAST:event_rbuttonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        load_room_arr_history();
        try{
            String ser="RoomArrangement";
            String sql="select serviceID as ServiceID,guestID as GuestID,description as Requirements,comments as Description,total as Total from service_info where serviceType='"+ser+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String name=gsearch.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";

        String sql="select customerID,fname,lname from customer where lname like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void totalboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalboxActionPerformed

    private void lightchkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightchkActionPerformed
        // TODO add your handling code here:
        /*double test=0;*/
        double cal=0;
        String dis="";
        String nxt="";
        String blank=null;
        String ini=totalbox.getText();
        if(lightchk.isSelected()){
        
            if(ini.equals(nxt)|ini.equals(blank)){

                cal=0 + 850;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
            else{
                cal=Double.parseDouble(ini) + 850;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        
        }
        else{
            if(ini.equals(nxt)|ini.equals(blank)){
                totalbox.setText("");
            }
            else{
                cal=Double.parseDouble(ini) - 850;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        }
        /*if(lightchk.isSelected()){
            test=Double.parseDouble(totalbox.getText());
            
                test =0;
                cal=test + 500;
                dis=Double.toString(cal);
            if(test==0)
                totalbox.setText("Null");
            else{
                double cal=test + 500;
                String dis=Double.toString(cal);
                totalbox.setText(dis);
            }
                
            
            
        }
        else
            /*test=Double.parseDouble(totalbox.getText());
            cal=test - 500;
            dis=Double.toString(cal);
            totalbox.setText("-500");*/
    }//GEN-LAST:event_lightchkActionPerformed

    private void heavychkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heavychkActionPerformed
        // TODO add your handling code here:
        double cal=0;
        String dis="";
        String nxt="";
        String blank=null;
        String ini=totalbox.getText();
        if(heavychk.isSelected()){
        
            if(ini.equals(nxt)|ini.equals(blank)){

                cal=0 + 1500;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
            else{
                cal=Double.parseDouble(ini) + 1500;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        
        }
        else{
            if(ini.equals(nxt)|ini.equals(blank)){
                totalbox.setText("");
            }
            else{
                cal=Double.parseDouble(ini) - 1500;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        }
    }//GEN-LAST:event_heavychkActionPerformed

    private void elecchkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elecchkActionPerformed
        // TODO add your handling code here:
        double cal=0;
        String dis="";
        String nxt="";
        String blank=null;
        String ini=totalbox.getText();
        if(elecchk.isSelected()){
        
            if(ini.equals(nxt)|ini.equals(blank)){

                cal=0 + 1500;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
            else{
                cal=Double.parseDouble(ini) + 1500;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        
        }
        else{
            if(ini.equals(nxt)|ini.equals(blank)){
                totalbox.setText("");
            }
            else{
                cal=Double.parseDouble(ini) - 1500;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        }
    }//GEN-LAST:event_elecchkActionPerformed

    private void int1chkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_int1chkActionPerformed
        // TODO add your handling code here:
        double cal=0;
        String dis="";
        String nxt="";
        String blank=null;
        String ini=totalbox.getText();
        if(int1chk.isSelected()){
        
            if(ini.equals(nxt)|ini.equals(blank)){

                cal=0 + 250;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
            else{
                cal=Double.parseDouble(ini) + 250;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        
        }
        else{
            if(ini.equals(nxt)|ini.equals(blank)){
                totalbox.setText("");
            }
            else{
                cal=Double.parseDouble(ini) - 250;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        }
    }//GEN-LAST:event_int1chkActionPerformed

    private void int2chkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_int2chkActionPerformed
        // TODO add your handling code here:
        double cal=0;
        String dis="";
        String nxt="";
        String blank=null;
        String ini=totalbox.getText();
        if(int2chk.isSelected()){
        
            if(ini.equals(nxt)|ini.equals(blank)){

                cal=0 + 550;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
            else{
                cal=Double.parseDouble(ini) + 550;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        
        }
        else{
            if(ini.equals(nxt)|ini.equals(blank)){
                totalbox.setText("");
            }
            else{
                cal=Double.parseDouble(ini) - 550;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        }
    }//GEN-LAST:event_int2chkActionPerformed

    private void otherchkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherchkActionPerformed
        // TODO add your handling code here:
        double cal=0;
        String dis="";
        String nxt="";
        String blank=null;
        String ini=totalbox.getText();
        if(otherchk.isSelected()){
        
            if(ini.equals(nxt)|ini.equals(blank)){

                cal=0 + 1000;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
            else{
                cal=Double.parseDouble(ini) + 1000;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        
        }
        else{
            if(ini.equals(nxt)|ini.equals(blank)){
                totalbox.setText("");
            }
            else{
                cal=Double.parseDouble(ini) - 1000;
                dis=Double.toString(cal);
                totalbox.setText(dis);
            }
        }
    }//GEN-LAST:event_otherchkActionPerformed

    private void gsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gsearchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_gsearchKeyPressed

    private void searchboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchboxKeyPressed

    private void searchboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchboxKeyTyped

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        String name=searchbox.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";
        String type="RoomArrangement";

        //String sql="select RANo,guestID,name,Requirements,description,cost from guest_ra_cost where guestID like '"+ser+"' and serviceType='"+type+"'";

        String sql="select serviceID,guestID as GuestID,roomID as RoomID,description as Requirements,comments as Description,total as Total from service_info where guestID like '"+ser+"' and serviceType='"+type+"'";
        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_searchboxKeyReleased

    private void gsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gsearchKeyReleased
        // TODO add your handling code here:
        String name=gsearch.getText();
        //String ser="%" + name + "%";
        String ser=name + "%";

        String sql="select customerID,fname,lname from customer where lname like '"+ser+"'";

        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){

        }
    }//GEN-LAST:event_gsearchKeyReleased

    private void gsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gsearchActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        String tmp="All " + idbox.getText() + " orders";
        
        if(tmp.equals(jLabel9.getText())){
            int r=jTable4.getSelectedRow();
            String gid=jTable4.getValueAt(r, 0).toString();
            String rid=jTable4.getValueAt(r, 1).toString();
            String des=jTable4.getValueAt(r, 2).toString();
            String cst=jTable4.getValueAt(r, 3).toString();
            
            ridlbl.setText(rid);
            
            totalbox.setText(cst);
        }
            
    }//GEN-LAST:event_jTable4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desbox;
    private javax.swing.JCheckBox elecchk;
    private javax.swing.JTextField gsearch;
    private javax.swing.JCheckBox heavychk;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel idbox;
    private javax.swing.JCheckBox int1chk;
    private javax.swing.JCheckBox int2chk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JCheckBox lightchk;
    private javax.swing.JLabel namebox;
    private javax.swing.JLabel nobox;
    private javax.swing.JCheckBox otherchk;
    private javax.swing.JButton rbutton;
    private javax.swing.JLabel ridlbl;
    private javax.swing.JButton sbutton;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField totalbox;
    // End of variables declaration//GEN-END:variables
}
