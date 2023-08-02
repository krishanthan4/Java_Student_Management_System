package gui.admin;

import model.MySQL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Student_Registration extends javax.swing.JFrame {
    
    public Student_Registration() {
        initComponents();
        TableLoad();
    }

    private void reset() {
        jTextField5.setText("");
        jTextField2.setText("");
        jTextField8.setText("");
        jRadioButton2.setSelected(true);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        
    }

    private void TableLoad() {
        
        try {
            
            ResultSet cityset = MySQL.execute("SELECT * FROM `city`");
            ResultSet parentset = MySQL.execute("SELECT * FROM `parent`");
            ResultSet resultset = MySQL.execute("SELECT * FROM `student` INNER JOIN `gender` ON `student`.`Gender_id`=`gender`.`id` INNER JOIN `parent` ON `student`.`Parent_Mobile_Number1`=`parent`.`Mobile_Number1` INNER JOIN `city` ON `student`.`city_id`= `city`.`id` ");
            
            Vector cityVector = new Vector();
            cityVector.add("Select");
            while (cityset.next()) {
                cityVector.add(cityset.getString("city.name"));
            }
            
            DefaultComboBoxModel ComboBox = new DefaultComboBoxModel<>(cityVector);
            jComboBox2.setModel(ComboBox);
            
            Vector parentVector = new Vector();
            parentVector.add("Select");
            while (parentset.next()) {
                parentVector.add(parentset.getString("Mobile_Number1"));
            }
            
            DefaultComboBoxModel ComboBox3 = new DefaultComboBoxModel<>(parentVector);
            jComboBox3.setModel(ComboBox3);
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (resultset.next()) {
                
                String Student_No = resultset.getString(String.valueOf("student.Sno"));
                String Full_Name = resultset.getString("student.Full_Name");
                String Name_With_Initials = resultset.getString("student.Name_With_Initials");
                String Date_Of_Birth = resultset.getString(String.valueOf("student.dob"));
                String gender = resultset.getString(String.valueOf("gender.Name"));
                String Address = resultset.getString("student.Address");
                String City = resultset.getString("city.name");
                String Parent_Mobile1 = resultset.getString("parent.Mobile_Number1");
                
                Vector vector = new Vector();
                vector.add(Student_No);
                vector.add(Full_Name);
                vector.add(Name_With_Initials);
                vector.add(Date_Of_Birth);
                vector.add(gender);
                vector.add(Address);
                vector.add(City);
                vector.add(Parent_Mobile1);
                
                model.addRow(vector);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField2.setText(" ");

        jLabel2.setText("Name With Initials");

        jLabel4.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Female");
        jRadioButton1.setActionCommand("2");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Male");
        jRadioButton2.setActionCommand("1");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField5.setText(" ");

        jLabel6.setText("Full Name");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Student Registration");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student No.", "Full Name", "Name With Initials", "Date Of Birth", "Gender", "Address", "City", "Mobile No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 870, 330));

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 160, 30));

        jLabel13.setText("Search By Name");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 900, -1));

        jButton3.setText("Add New Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 170, 30));

        jButton2.setText("Update Student Deatails");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 170, 30));

        jButton1.setText("Delete Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 170, 30));

        jButton5.setBackground(new java.awt.Color(69, 75, 75));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_48px.png"))); // NOI18N
        jButton5.setText("Go Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 177, 32));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText("** Register Parent Deatails Before Registering Student Deatails");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        jLabel5.setText("Date Of Birth");

        jLabel9.setText("Address");

        jTextField8.setText(" ");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel10.setText("City");

        jLabel11.setText("Parent Mobile Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton2)
                                .addGap(21, 21, 21)
                                .addComponent(jRadioButton1))
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        this.dispose();
        Main_Page Main_Page = new Main_Page();
        Main_Page.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        String StudentName = jTextField6.getText();
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if(StudentName.equals("")){
            model.setRowCount(0);
            
        TableLoad();
        }else{
            model.setRowCount(0);
            ResultSet resultset = MySQL.execute("SELECT * FROM `student` INNER JOIN `gender` ON `student`.`Gender_id`=`gender`.`id` INNER JOIN `parent` ON `student`.`Parent_Mobile_Number1`=`parent`.`Mobile_Number1` INNER JOIN `city` ON `student`.`city_id`= `city`.`id` WHERE `student`.`Full_Name` LIKE '"+StudentName+"%'");
            
            while (resultset.next()) {
                
                String Student_No = resultset.getString(String.valueOf("student.Sno"));
                String Full_Name = resultset.getString("student.Full_Name");
                String Name_With_Initials = resultset.getString("student.Name_With_Initials");
                String Date_Of_Birth = resultset.getString(String.valueOf("student.dob"));
                String gender = resultset.getString(String.valueOf("gender.Name"));
                String Address = resultset.getString("student.Address");
                String City = resultset.getString("city.name");
                String Parent_Mobile1 = resultset.getString("parent.Mobile_Number1");
                
                Vector vector = new Vector();
                vector.add(Student_No);
                vector.add(Full_Name);
                vector.add(Name_With_Initials);
                vector.add(Date_Of_Birth);
                vector.add(gender);
                vector.add(Address);
                vector.add(City);
                vector.add(Parent_Mobile1);
                
                model.addRow(vector);
                
            } 
        }
            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String FullName = jTextField5.getText();
        String NameWithInitials = jTextField2.getText();
        
        Date date = jDateChooser1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
//        System.out.println(formattedDate);

        ButtonModel genderSelection = buttonGroup1.getSelection();
        String genderId = genderSelection.getActionCommand();
//System.out.print(genderId);

        String Address = jTextField8.getText();
        String City = String.valueOf(jComboBox2.getSelectedIndex());
        String ParentMobile = String.valueOf(jComboBox3.getSelectedItem());
        
        try {
            
            ResultSet resultset = MySQL.execute("INSERT INTO `student` (`Full_Name`,`Name_With_Initials`,`Address`,`dob`,`Gender_id`,`city_id`,`Parent_Mobile_Number1`) VALUES ('" + FullName + "','" + NameWithInitials + "','" + Address + "','" + formattedDate + "',"
                    + "'" + genderId + "','" + City + "','" + ParentMobile + "')");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            TableLoad();
            reset();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    Object StudentNo;    
    Object FullName;
    Object NameWithInitials;
    Object Address;
    Object DateOfBirth;
    Object gender;
    Object City;
    Object Mobile;
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if (evt.getClickCount() == 2) {
            
            try {
                int selectedRow = jTable1.getSelectedRow();
                StudentNo = jTable1.getValueAt(selectedRow, 0);
                FullName = jTable1.getValueAt(selectedRow, 1);
                NameWithInitials = jTable1.getValueAt(selectedRow, 2);
                DateOfBirth = jTable1.getValueAt(selectedRow, 3);
                gender = jTable1.getValueAt(selectedRow, 4);
                
                Address = jTable1.getValueAt(selectedRow, 5);
                City = jTable1.getValueAt(selectedRow, 6);
                Mobile = jTable1.getValueAt(selectedRow, 7);
                jTextField5.setText(String.valueOf(FullName));
                jTextField2.setText(String.valueOf(NameWithInitials));
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirth = dateFormat.parse((String) DateOfBirth);
                jDateChooser1.setDate(dateOfBirth);
                
                if (String.valueOf(gender).equals("male")) {
                    jRadioButton2.setSelected(true);
                } else {
                    jRadioButton1.setSelected(true);
                    
                }
                
                jTextField8.setText(String.valueOf(Address));
                
                jComboBox2.setSelectedItem(City);
                jComboBox3.setSelectedItem(Mobile);
                
                jButton3.setEnabled(false);
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jTable1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String fullname = jTextField5.getText();
        String namewithinitials = jTextField2.getText();
        
        Date selectedDate = jDateChooser1.getDate();
        DateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy");
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            String formattedDate = outputFormat.format(inputFormat.parse(inputFormat.format(selectedDate)));
            
            ButtonModel genderSelection = buttonGroup1.getSelection();
            String genderId = genderSelection.getActionCommand();
            String address = jTextField8.getText();
            String City = String.valueOf(jComboBox2.getSelectedIndex());
            String mobile = String.valueOf(jComboBox3.getSelectedItem());
            
            ResultSet UpdateSet = MySQL.execute("UPDATE `student` SET `Sno`='"+String.valueOf(StudentNo)+"', `Full_Name`='"+fullname+"', `Name_With_Initials`='"+namewithinitials+"', `Address`='"+address+"', `dob`='"+formattedDate+"', `Gender_id`='"+genderId+"', `city_id`='"+City+"', `Parent_Mobile_Number1`='"+mobile+"' WHERE `Sno`='"+String.valueOf(StudentNo)+"'");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            TableLoad();
            reset();
            jButton3.setEnabled(true);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String sno = String.valueOf(StudentNo);

ResultSet resultset =MySQL.execute("DELETE FROM `student` WHERE `Sno`='"+sno+"'");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            TableLoad();
            reset();
            jButton3.setEnabled(true); 
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
