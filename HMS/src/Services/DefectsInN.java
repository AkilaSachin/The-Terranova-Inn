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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author CJ
 */
public class DefectsInN extends javax.swing.JInternalFrame {

    Connection con=null;
    PreparedStatement pst=null;
    PreparedStatement pst2=null;
    PreparedStatement pst3=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    
    public void reset2(){
        //ravbox.setText("");
        ddbox.setText("");
        empbox.setText("");
        roombox.setText("");
        adatebox.setText("");
        rdatebox.setText("");
        disbox.setText("");
        costbox.setText("");
        aradio.setSelected(false);
        sradio.setSelected(false);
        hradio.setSelected(false);
    }
    
    public void reset(){
        didbox.setText("");
        eidbox.setText("");
        codbox.setText("");
        ridbox.setText("");
        dbox.setText("");
        rtradio.setSelected(false);
    }
    
    public void load_emp_to_left(){
        
        
        int r=jTable3.getSelectedRow();
            String did=jTable3.getValueAt(r, 0).toString();
            String empid=jTable3.getValueAt(r, 1).toString();
            String asdate=jTable3.getValueAt(r, 2).toString();
            String rooid=jTable3.getValueAt(r, 3).toString();
            String cout=jTable3.getValueAt(r, 4).toString();
            
            rtradio.setSelected(true);

            didbox.setText(did);
            eidbox.setText(empid);
            codbox.setText(cout);
            ridbox.setText(rooid);
            dbox.setText(asdate);
            rtradio.setSelected(true);
    }
    
    public void load_room_to_right(){
        
        
        int r=jTable3.getSelectedRow();
            //String rav=jTable3.getValueAt(r, 0).toString();
            String di=jTable3.getValueAt(r, 0).toString();
            String rid=jTable3.getValueAt(r, 1).toString();
            String eid=jTable3.getValueAt(r, 2).toString();
            String aDate=jTable3.getValueAt(r, 3).toString();
            String rDate=jTable3.getValueAt(r, 4).toString();
            String rtype=jTable3.getValueAt(r, 5).toString();
            String des=jTable3.getValueAt(r, 6).toString();
            String cst=jTable3.getValueAt(r, 7).toString();

            //ravbox.setText(rav);
            ddbox.setText(di);
            empbox.setText(eid);
            
            String av="Available";
            String sr="Soft Repair";
            String hr="Hard Repair";
            
            if(av.equals(rtype)){
                sradio.setSelected(false);
                hradio.setSelected(false);
                aradio.setSelected(true);
                
            }
            
            else if(sr.equals(rtype)){
                aradio.setSelected(false);
                hradio.setSelected(false);
                sradio.setSelected(true);
                
            }
            
            else if(hr.equals(rtype)){
                aradio.setSelected(false);
                sradio.setSelected(false);
                hradio.setSelected(true);
                
            }
            
            else{
                aradio.setSelected(false);
                sradio.setSelected(false);
                hradio.setSelected(false);
            }
            
            roombox.setText(rid);
            adatebox.setText(aDate);
            rdatebox.setText(rDate);
            disbox.setText(des);
            costbox.setText(cst);
    }
    
    public void load_checked_out_info(){
        try{
            lblchange.setVisible(true);
            jPanel6.setVisible(true);
            String sql="select customerID as GuestID,roomid as RoomID,Billdate as CheckedOutDate from reservation_history";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            lblchange.setText("Checked-out Information");
        }
        catch (Exception e){
            
        }
    }
    
    public void getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        dbox.setText(dateFormat.format(date));
        //System.out.println(dateFormat.format(date));
    }
    
    public void getDateTime2(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        rdatebox.setText(dateFormat.format(date));
        //System.out.println(dateFormat.format(date));
    }
    
    public void load_available_emp_info(){
        try{
            lblchange.setVisible(true);
            jPanel6.setVisible(true);
            lblchange.setText("Available Employees");
            String sql="select empdetails.empid as EmployeeID,empdetails.name as EmployeeName,empdetails.job as JobTitle from empdetails,attendance where attendance.empid=empdetails.empid and attendance.Status='1'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            /*int i=0;
            while(rs.next()){
                String emp=rs.getString("empid");
                String name=null;
                String wtype=null;

                String que="select * from empdetails where empid=?";
                pst2=con.prepareStatement(que);
                pst2.setString(PROPERTIES, emp);
                rs1=pst2.executeQuery();
                
                while(rs1.next()){
                    name=rs1.getString("name");
                    wtype=rs1.getString("job");
                }
            jTable4.setValueAt(emp, i, 0);
            jTable4.setValueAt(name, i, 1);
            jTable4.setValueAt(wtype, i, 2);
            
            i++;
            
            
        }*/
            
        }
        catch (Exception e){
            
        }
    }
    
    
    public void load_emp_assignment_info(){
        try{
            searchbox.setVisible(true);
            sbutton.setVisible(true);
            rbutton.setVisible(true);
            
            history.setVisible(true);
            jPanel6.setVisible(true);
            String sql="select RDRNo,empID as EmployeeID,assDate as AssignedDate,roomID as RoomID,chkedOutDate as CheckedOutDate from emp_assign_and_room_status";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            history.setText("Employee Assignment Info");
        }
        catch (Exception e){
            
        }
    }
    
    public void load_room_Status_info(){
        try{
            searchbox.setVisible(true);
            sbutton.setVisible(true);
            rbutton.setVisible(true);
            
            history.setVisible(true);
            jPanel6.setVisible(true);
            String sql="select RDRNo,roomID as RoomID,empID as EmployeeID,assDate as AssignedDate,reportedDate as ReportedDate,roomStatus as RoomStatus,description as Description,cost as Cost from emp_assign_and_room_status";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            history.setText("Room Availability Info");
        }
        catch (Exception e){
            
        }
    }
    /**
     * Creates new form DefectsInN
     */
    public DefectsInN() {
        initComponents();
        
        con=DBconnect.connect();
        
        searchbox.setVisible(false);
        sbutton.setVisible(false);
        rbutton.setVisible(false);
        
        jPanel6.setVisible(false);
        history.setVisible(false);
        lblchange.setVisible(false);
        jPanel3.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ridbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        eidbox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        rtradio = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        didbox = new javax.swing.JLabel();
        dbox = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        codbox = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblchange = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        history = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        sbutton = new javax.swing.JButton();
        rbutton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        aradio = new javax.swing.JRadioButton();
        sradio = new javax.swing.JRadioButton();
        hradio = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        disbox = new javax.swing.JTextArea();
        costbox = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ddbox = new javax.swing.JLabel();
        empbox = new javax.swing.JLabel();
        roombox = new javax.swing.JLabel();
        adatebox = new javax.swing.JLabel();
        rdatebox = new javax.swing.JLabel();

        setBackground(new java.awt.Color(90, 120, 183));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel3.setBackground(new java.awt.Color(90, 120, 183));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Defects and Repairs", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Assignment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(90, 120, 183));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Checked Out Date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Room ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RDRNo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date/Time");

        ridbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ridbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ridboxMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Room Type");

        eidbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eidbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eidboxMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee ID");

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
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(68, 145, 162));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        rtradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rtradio.setForeground(new java.awt.Color(255, 255, 255));
        rtradio.setText("Dirty");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/room.jpg"))); // NOI18N
        jLabel1.setToolTipText("Room Status History");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        didbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        didbox.setForeground(new java.awt.Color(255, 255, 255));
        didbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        didbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                didboxMouseClicked(evt);
            }
        });

        dbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dbox.setForeground(new java.awt.Color(255, 255, 255));
        dbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dboxMouseClicked(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/empass.jpg"))); // NOI18N
        jButton7.setToolTipText("Employee Assignment History");
        jButton7.setPreferredSize(new java.awt.Dimension(86, 86));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        codbox.setForeground(new java.awt.Color(255, 255, 255));
        codbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        codbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codboxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                codboxMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtradio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ridbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(codbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eidbox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(didbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(didbox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(eidbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codbox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ridbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dbox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtradio)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(90, 120, 183));
        jPanel4.setForeground(new java.awt.Color(90, 120, 183));

        jPanel6.setBackground(new java.awt.Color(90, 120, 183));
        jPanel6.setForeground(new java.awt.Color(85, 68, 162));

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
        jScrollPane4.setViewportView(jTable3);

        lblchange.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblchange.setForeground(new java.awt.Color(255, 255, 255));
        lblchange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblchange.setToolTipText("");
        lblchange.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblchange.setPreferredSize(new java.awt.Dimension(167, 30));

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
        jScrollPane5.setViewportView(jTable4);

        history.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        history.setForeground(new java.awt.Color(255, 255, 255));
        history.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        history.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        history.setPreferredSize(new java.awt.Dimension(156, 23));

        searchbox.setToolTipText("Use RDRNo");
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        sbutton.setBackground(new java.awt.Color(68, 145, 162));
        sbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sbutton.setForeground(new java.awt.Color(255, 255, 255));
        sbutton.setText("Search");
        sbutton.setToolTipText("Use RDRNo");
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblchange, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(rbutton)
                .addGap(29, 29, 29))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblchange, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sbutton)
                    .addComponent(rbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel28.setBackground(java.awt.Color.white);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/housekeepingN.jpg"))); // NOI18N
        jLabel28.setText("jLabel28");
        jLabel28.setMaximumSize(new java.awt.Dimension(340, 80));
        jLabel28.setMinimumSize(new java.awt.Dimension(340, 80));
        jLabel28.setPreferredSize(new java.awt.Dimension(340, 80));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(90, 120, 183));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Status", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(90, 120, 183));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("RDRNo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Employee ID");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Room ID");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Assignned Date/Time");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Room Type");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reported Date/Time");

        aradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        aradio.setForeground(new java.awt.Color(255, 255, 255));
        aradio.setText("Available");
        aradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aradioActionPerformed(evt);
            }
        });

        sradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sradio.setForeground(new java.awt.Color(255, 255, 255));
        sradio.setText("Soft Repair");
        sradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sradioActionPerformed(evt);
            }
        });

        hradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hradio.setForeground(new java.awt.Color(255, 255, 255));
        hradio.setText("Hard Repair");
        hradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hradioActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Description");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cost");

        disbox.setColumns(20);
        disbox.setRows(5);
        jScrollPane1.setViewportView(disbox);

        costbox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton5.setBackground(new java.awt.Color(68, 145, 162));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(68, 145, 162));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        ddbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ddbox.setForeground(new java.awt.Color(255, 255, 255));
        ddbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ddbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ddboxMouseClicked(evt);
            }
        });

        empbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        empbox.setForeground(new java.awt.Color(255, 255, 255));
        empbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        empbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empboxMouseClicked(evt);
            }
        });

        roombox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roombox.setForeground(new java.awt.Color(255, 255, 255));
        roombox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roombox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomboxMouseClicked(evt);
            }
        });

        adatebox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adatebox.setForeground(new java.awt.Color(255, 255, 255));
        adatebox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        adatebox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adateboxMouseClicked(evt);
            }
        });

        rdatebox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdatebox.setForeground(new java.awt.Color(255, 255, 255));
        rdatebox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rdatebox.setPreferredSize(new java.awt.Dimension(4, 19));
        rdatebox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdateboxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(aradio)
                                    .addComponent(rdatebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sradio)
                                    .addComponent(hradio)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(costbox)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ddbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adatebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roombox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(empbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton5)
                        .addGap(45, 45, 45)
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(ddbox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(empbox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(roombox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(adatebox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdatebox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(aradio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sradio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hradio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ridboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ridboxMouseClicked
        // TODO add your handling code here:
        jTable4.removeAll();
        jTable4.setVisible(true);
        load_checked_out_info();
    }//GEN-LAST:event_ridboxMouseClicked

    private void eidboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eidboxMouseClicked
        // TODO add your handling code here:
        jTable4.removeAll();
        jTable4.setVisible(true);
        load_available_emp_info();
        load_emp_assignment_info();
    }//GEN-LAST:event_eidboxMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String did=didbox.getText();
        String eid=eidbox.getText();
        String cout=codbox.getText();
        String rid=ridbox.getText();
        String adate=dbox.getText();

        if(rtradio.isSelected()==false || eidbox.getText().isEmpty() || ridbox.getText().isEmpty() || dbox.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields!", "Aleart!",JOptionPane.ERROR_MESSAGE);

        }
        else{
            try{
                String etxt="";
                String rt="Dirty";
                //String q="insert into emp_assign_and_room_status (empID,assDate,roomID,chkedOutDate) values ('"+eid+"','"+cdate+"','"+rid+"','"+cout+"')";
                //String rr="insert into emp_assign_and_room_status (DID,roomID,empID,empAssignnedDate,reportedDateTime,description,cost,roomStatus) values ('"+did+"','"+rid+"','"+eid+"','"+cdate+"','','','','"+rt+"')";
                String exq="INSERT INTO emp_assign_and_room_status (roomID,empID,chkedOutDate,assDate,reportedDate,roomStatus,description,cost) VALUES ('"+rid+"','"+eid+"','"+cout+"','"+adate+"','"+etxt+"','"+rt+"','"+etxt+"','"+etxt+"')";
                pst=con.prepareStatement(exq);
                //pst2=con.prepareStatement(rr);
                pst.execute();
                //pst2.execute();
                JOptionPane.showMessageDialog(null,"Successfully saved");
                load_emp_assignment_info();
                reset();
                
            }
            catch(Exception e){

            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null,"Do you really want to update ?");

        if(x==0){
            String did=didbox.getText();
            String eid=eidbox.getText();
            String chkout=codbox.getText();
            String roomid=ridbox.getText();
            String date=dbox.getText();
            String rt="Dirty";
            String etxt="";

            String sql="UPDATE emp_assign_and_room_status SET RDRNo='"+did+"',roomID='"+roomid+"',empID='"+eid+"',chkedOutDate='"+chkout+"',assDate='"+date+"',reportedDate='"+etxt+"',roomStatus='"+rt+"',description='"+etxt+"',cost='"+etxt+"' WHERE RDRNo='"+did+"'";

            //String sql3="SELECT * from room_availability_info";// where DID='"+did+"'";

            try{
                pst=con.prepareStatement(sql);
                pst.execute();
                load_emp_assignment_info();

                /*pst3=con.prepareStatement(sql3);
                rs= pst3.executeQuery(sql3);

                while(rs.next()) {

                    int rav=rs.getInt("RAV_No");
                    String di=rs.getString("DID");
                    String rno=rs.getString("roomID");
                    String eno=rs.getString("empID");
                    String ead=rs.getString("empAssignnedDate");
                    String rdt=rs.getString("reportedDateTime");
                    String dss=rs.getString("description");
                    String ct=rs.getString("cost");
                    String rst=rs.getString("roomStatus");

                    if(di.equals(did)){
                        String sql2="update room_availability_info SET RAV_No='"+rav+"',DID='"+did+"',roomID='"+roomid+"',empID='"+eid+"',empAssignnedDate='"+date+"',reportedDateTime='"+rdt+"',description='"+dss+"',cost='"+ct+"',roomStatus='"+rt+"' where DID='"+di+"'";
                        pst2=con.prepareStatement(sql2);
                        pst2.execute();
                    }

                }*/
                //pst2.execute();

                //msgbox
                JOptionPane.showMessageDialog(this,"Successfully upddated");
                reset();
                //load table
                //loadnurse_wardboy();
            }
            catch (Exception e){

            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null, "Do you really want to delete this ?");

        if(x==0){
            String id=didbox.getText();
            //String rsts="Available";
            //String sql="delete from emp_assignment_info where guestID='"+id+"'";
            //String sql2="";

            String sql3="SELECT RDRNo,roomStatus from emp_assign_and_room_status";
            try{
                pst3=con.prepareStatement(sql3);
                rs= pst3.executeQuery(sql3);

                while(rs.next()) {

                    int rno=rs.getInt("RDRNo");
                    //String di=rs.getString("DID");
                    String no=Integer.toString(rno);
                    String rst=new String(rs.getString("roomStatus"));
                    String rsts="Available";

                    if(id.equals(no)){
                        if(rst.equals(rsts)){
                            String sql="delete from emp_assign_and_room_status where RDRNo='"+id+"'";
                            pst=con.prepareStatement(sql);
                            pst.execute();

                            //load table
                            load_emp_assignment_info();
                            reset();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Room is not available yet!", "Aleart!",JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                    }

                }
            }
            catch(Exception t){

            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        jTable3.removeAll();
        jTable3.setVisible(true);
        load_room_Status_info();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void didboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_didboxMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT RDRNo+1 from emp_assign_and_room_status";
            pst=con.prepareStatement(sql);
            //pst.setString(1,EmployeeIDSearchField.getText());

            rs= pst.executeQuery(sql);
            while(rs.next()) {
                didbox.setText(rs.getString("RDRNo+1"));
            }
        }
        catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_didboxMouseClicked

    private void dboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dboxMouseClicked
        // TODO add your handling code here:
        getDateTime();
    }//GEN-LAST:event_dboxMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jTable3.removeAll();
        jTable3.setVisible(true);
        load_emp_assignment_info();
        load_available_emp_info();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        //defectsPop s=new defectsPop();
        //s.setVisible(true);
        String lbl1="Employee Assignment Info";
        String lbl2="Room Availability Info";

        if(lbl1.equals(history.getText())){
            load_emp_to_left();
        }

        if(lbl2.equals(history.getText())){
            load_room_to_right();
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        String lblName1="Checked-out Information";
        String lblName2="Available Employees";

        if(lblName1.equals(lblchange.getText())){
            int r=jTable4.getSelectedRow();
            String gid=jTable4.getValueAt(r, 0).toString();
            String rid=jTable4.getValueAt(r, 1).toString();
            String cout=jTable4.getValueAt(r, 2).toString();

            ridbox.setText(rid);
            codbox.setText(cout);
        }

        if(lblName2.equals(lblchange.getText())){
            int r=jTable4.getSelectedRow();
            String eid=jTable4.getValueAt(r, 0).toString();
            String eName=jTable4.getValueAt(r, 1).toString();
            String job=jTable4.getValueAt(r, 2).toString();

            eidbox.setText(eid);

        }

    }//GEN-LAST:event_jTable4MouseClicked

    private void sbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbuttonActionPerformed
        // TODO add your handling code here:
        String h1="Employee Assignment Info";
        String h2="Room Availability Info";

        String name=searchbox.getText();
        String ser="%" + name + "%";

        try{
            if(h1.equals(history.getText())){
                String sql="select RDRNo,empID as EmployeeID,assDate as AssignedDate,roomID as RoomID,chkedOutDate as CheckedOutDate from emp_assign_and_room_status where RDRNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(h2.equals(history.getText())){
                String sql="select RDRNo,roomID as RoomID,empID as EmployeeID,assDate as AssignedDate,reportedDate as ReportedDate,description as Description,cost as Cost,roomStatus as RoomStatus from emp_assign_and_room_status where RDRNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }

        }
        catch (Exception e){

        }
    }//GEN-LAST:event_sbuttonActionPerformed

    private void rbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbuttonActionPerformed
        // TODO add your handling code here:
        String h1="Employee Assignment Info";
        String h2="Room Availability Info";

        if(h1.equals(history.getText())){
            load_emp_assignment_info();
        }

        if(h2.equals(history.getText())){
            load_room_Status_info();
        }
    }//GEN-LAST:event_rbuttonActionPerformed

    private void aradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aradioActionPerformed
        // TODO add your handling code here:
        if(aradio.isSelected()){
            sradio.setSelected(false);
            hradio.setSelected(false);
        }
    }//GEN-LAST:event_aradioActionPerformed

    private void sradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sradioActionPerformed
        // TODO add your handling code here:
        if(sradio.isSelected()){
            aradio.setSelected(false);
            hradio.setSelected(false);
        }
    }//GEN-LAST:event_sradioActionPerformed

    private void hradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hradioActionPerformed
        // TODO add your handling code here:
        if(hradio.isSelected()){
            sradio.setSelected(false);
            aradio.setSelected(false);
        }
    }//GEN-LAST:event_hradioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        reset2();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(aradio.isSelected()==false && sradio.isSelected()==false && hradio.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Check room type!", "Aleart!",JOptionPane.ERROR_MESSAGE);

        }
        else if(ddbox.getText().isEmpty() || empbox.getText().isEmpty() || costbox.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields!", "Aleart!",JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x=JOptionPane.showConfirmDialog(null,"Do you really want to update ?");

            if(x==0){
                //String rbox=ravbox.getText();
                String dbox=ddbox.getText();
                String ebox=empbox.getText();
                String rrbox=roombox.getText();
                String adbox=adatebox.getText();
                String rdbox=rdatebox.getText();
                String dibox=disbox.getText();
                String cbox=costbox.getText();
                String radio;

                if(aradio.isSelected()){
                    radio="Available";
                    String sql="UPDATE emp_assign_and_room_status SET RDRNo='"+dbox+"',roomID='"+rrbox+"',empID='"+ebox+"',assDate='"+adbox+"',reportedDate='"+rdbox+"',roomStatus='"+radio+"',description='"+dibox+"',cost='"+cbox+"' WHERE RDRNo='"+dbox+"'";
                    try{
                        pst=con.prepareStatement(sql);
                        pst.execute();

                        //msgbox
                        JOptionPane.showMessageDialog(this,"Successfully upddated");

                        //load table
                        load_room_Status_info();
                        reset2();
                    }
                    catch (Exception e){

                    }
                }

                if(sradio.isSelected()){
                    radio="Soft Repair";
                    String sql="UPDATE emp_assign_and_room_status SET RDRNo='"+dbox+"',roomID='"+rrbox+"',empID='"+ebox+"',assDate='"+adbox+"',reportedDate='"+rdbox+"',roomStatus='"+radio+"',description='"+dibox+"',cost='"+cbox+"' WHERE RDRNo='"+dbox+"'";
                    try{
                        pst=con.prepareStatement(sql);
                        pst.execute();

                        //msgbox
                        JOptionPane.showMessageDialog(this,"Successfully upddated");

                        //load table
                        load_room_Status_info();
                    }
                    catch (Exception e){

                    }
                }

                if(hradio.isSelected()){
                    radio="Hard Repair";
                    String sql="UPDATE emp_assign_and_room_status SET RDRNo='"+dbox+"',roomID='"+rrbox+"',empID='"+ebox+"',assDate='"+adbox+"',reportedDate='"+rdbox+"',roomStatus='"+radio+"',description='"+dibox+"',cost='"+cbox+"' WHERE RDRNo='"+dbox+"'";
                    try{
                        pst=con.prepareStatement(sql);
                        pst.execute();

                        //msgbox
                        JOptionPane.showMessageDialog(this,"Successfully upddated");

                        //load table
                        load_room_Status_info();
                    }
                    catch (Exception e){

                    }
                }

                //String sql="update room_availability_info SET RAV_No='"+rbox+"',DID='"+dbox+"',roomID='"+ebox+"',empID='"+rrbox+"',empAssignnedDate='"+adbox+"',reportedDateTime='"+rdbox+"',description='"+dibox+"',cost='"+cbox+"',roomStatus='"+radio+"' where RAV_No='"+rbox+"'";

            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ddboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddboxMouseClicked
        // TODO add your handling code here:
        jTable3.removeAll();
        jTable3.setVisible(true);
        load_room_Status_info();
    }//GEN-LAST:event_ddboxMouseClicked

    private void empboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empboxMouseClicked
        // TODO add your handling code here:
        jTable3.removeAll();
        jTable3.setVisible(true);
        load_room_Status_info();
    }//GEN-LAST:event_empboxMouseClicked

    private void roomboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomboxMouseClicked
        // TODO add your handling code here:
        jTable3.removeAll();
        jTable3.setVisible(true);
        load_room_Status_info();
    }//GEN-LAST:event_roomboxMouseClicked

    private void adateboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adateboxMouseClicked
        // TODO add your handling code here:
        jTable3.removeAll();
        jTable3.setVisible(true);
        load_room_Status_info();
    }//GEN-LAST:event_adateboxMouseClicked

    private void rdateboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdateboxMouseClicked
        // TODO add your handling code here:
        getDateTime2();
    }//GEN-LAST:event_rdateboxMouseClicked

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        String h1="Employee Assignment Info";
        String h2="Room Availability Info";

        String name=searchbox.getText();
        String ser="%" + name + "%";

        try{
            if(h1.equals(history.getText())){
                String sql="select RDRNo,empID as EmployeeID,assDate as AssignedDate,roomID as RoomID,chkedOutDate as CheckedOutDate from emp_assign_and_room_status where RDRNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(h2.equals(history.getText())){
                String sql="select RDRNo,roomID as RoomID,empID as EmployeeID,assDate as AssignedDate,reportedDate as ReportedDate,description as Description,cost as Cost,roomStatus as RoomStatus from emp_assign_and_room_status where RDRNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }

        }
        catch (Exception e){

        }
    }//GEN-LAST:event_searchboxKeyReleased

    private void codboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codboxMouseClicked
        // TODO add your handling code here:
        jTable4.removeAll();
        jTable4.setVisible(true);
        load_checked_out_info();
    }//GEN-LAST:event_codboxMouseClicked

    private void codboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codboxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_codboxMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adatebox;
    private javax.swing.JRadioButton aradio;
    private javax.swing.JLabel codbox;
    private javax.swing.JTextField costbox;
    private javax.swing.JLabel dbox;
    private javax.swing.JLabel ddbox;
    private javax.swing.JLabel didbox;
    private javax.swing.JTextArea disbox;
    private javax.swing.JTextField eidbox;
    private javax.swing.JLabel empbox;
    private javax.swing.JLabel history;
    private javax.swing.JRadioButton hradio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblchange;
    private javax.swing.JButton rbutton;
    private javax.swing.JLabel rdatebox;
    private javax.swing.JTextField ridbox;
    private javax.swing.JLabel roombox;
    private javax.swing.JRadioButton rtradio;
    private javax.swing.JButton sbutton;
    private javax.swing.JTextField searchbox;
    private javax.swing.JRadioButton sradio;
    // End of variables declaration//GEN-END:variables
}
