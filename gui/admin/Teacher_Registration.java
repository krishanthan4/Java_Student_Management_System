package gui.admin;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Teacher_Registration extends javax.swing.JFrame {

    HashMap<String, String> map = new HashMap<>();

    public Teacher_Registration() {
        initComponents();

    }

    private void TableLoad() {

        try {
            String Tno = String.valueOf(jSpinField1.getValue());

            ResultSet cityset = MySQL.execute("SELECT * FROM `city`");
            ResultSet Subjectset = MySQL.execute("SELECT `price`.`Price`,`subject`.`Subno`,`subject`.`name` FROM `subject_has_teacher` INNER JOIN `teacher` ON `teacher`.`Tno`=`subject_has_teacher`.`Teacher_Tno` INNER JOIN `subject`  ON `subject`.`Subno`=`subject_has_teacher`.`Subject_Subno` INNER JOIN `price` ON `subject`.`Price_id` = `price`.`id` WHERE `teacher`.`Tno`='" + Tno + "'");
            ResultSet Subjectset2 = MySQL.execute("SELECT name FROM `subject`");
            ResultSet resultset = MySQL.execute("SELECT * FROM `teacher` INNER JOIN `gender` ON `teacher`.`Gender_id`=`gender`.`id` INNER JOIN `city` ON `teacher`.`city_id`=`city`.`id` ORDER BY `teacher`.`Tno` ASC");

//            :) checking for cityCOmbobox
//            :) checking for cityCOmbobox
            Vector cityVector = new Vector();
            cityVector.add("Select");
            while (cityset.next()) {
                cityVector.add(cityset.getString("name"));
                map.put(String.valueOf(cityset.getString("id")), cityset.getString("name"));

            }

            DefaultComboBoxModel ComboBox = new DefaultComboBoxModel<>(cityVector);
            jComboBox3.setModel(ComboBox);

            DefaultTableModel subjectTable = (DefaultTableModel) jTable1.getModel();

            Vector subjectVector1 = new Vector();

            subjectVector1.add("Select");

            while (Subjectset2.next()) {

                subjectVector1.add(Subjectset2.getString("name"));

            }

            while (Subjectset.next()) {

                Vector subjectVector2 = new Vector();

                subjectVector2.add(Subjectset.getString("subject.Subno"));

                subjectVector2.add(Subjectset.getString("subject.name"));
                subjectVector2.add(Subjectset.getString("price.Price"));
                subjectTable.addRow(subjectVector2);
            }
            DefaultComboBoxModel ComboBox3 = new DefaultComboBoxModel<>(subjectVector1);
            jComboBox2.setModel(ComboBox3);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            while (resultset.next()) {

                String Teacher_No = resultset.getString(String.valueOf("teacher.Tno"));
                String Full_Name = resultset.getString("teacher.Full_Name");
                String Name_With_Initials = resultset.getString("teacher.Name_With_Initials");
                String Address = resultset.getString("teacher.Address");
                String City = resultset.getString(String.valueOf("city.name"));
                String Gender = resultset.getString(String.valueOf("gender.name"));

                Vector vector = new Vector();
                vector.add(Teacher_No);
                vector.add(Full_Name);
                vector.add(Name_With_Initials);
                vector.add(Address);
                vector.add(City);
                vector.add(Gender);

                model.addRow(vector);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField5.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jRadioButton2.setSelected(true);
//jComboBox3.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSpinField1 = new com.toedter.components.JSpinField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setText(" ");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 177, 33));

        jLabel2.setText("Name With Initials");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jTextField3.setText(" ");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 177, 33));

        jLabel4.setText("Gender");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Female");
        jRadioButton1.setActionCommand("2");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Male");
        jRadioButton2.setActionCommand("1");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jButton1.setText("Delete Teacher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 170, 30));

        jButton2.setText("Update Teacher Deatails");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 170, 30));

        jTextField5.setText(" ");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 177, 33));

        jLabel6.setText("Teacher Number");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel7.setText("Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Teacher Registration");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject No.", "Subject Name", "Subject Fees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 410));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 160, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset_16px.png"))); // NOI18N
        jLabel9.setText("Refresh");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher No.", "Full Name", "Name With Initials", "Address", "city", "gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 600, 410));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 910, 550));

        jButton4.setText("Add New Teacher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 170, 30));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, -1, 30));

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 177, 30));

        jLabel10.setText("city");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jButton3.setBackground(new java.awt.Color(217, 252, 217));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("add Subject");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, 177, 31));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 177, 30));

        jLabel3.setText("Subjects");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, -1, 30));

        jSpinField1.setValue(1);
        jSpinField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinField1PropertyChange(evt);
            }
        });
        jPanel1.add(jSpinField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 30));

        jLabel11.setText("Full Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
//mou

       DefaultTableModel subject = (DefaultTableModel) jTable1.getModel();
        subject.setRowCount(0);

        DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
        teacher.setRowCount(0);
        TableLoad();
        reset();
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String Subject = String.valueOf(jComboBox2.getSelectedIndex());
        String Tno = String.valueOf(jSpinField1.getValue());

        try {
            ResultSet resultset = MySQL.execute("INSERT INTO `subject_has_teacher` (`Subject_Subno`,`Teacher_Tno`) VALUES ('" + Subject + "','" + Tno + "')");

            DefaultTableModel subject = (DefaultTableModel) jTable1.getModel();
            subject.setRowCount(0);

            DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    Object TeacherNo;
    Object FullName;
    Object NameWithInitials;
    Object Address;
    Object gender;
    Object City;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String TeacherNo = String.valueOf(jSpinField1.getValue());
        String FullName = jTextField5.getText();
        String NameWithInitials = jTextField2.getText();
        String Address = jTextField3.getText();
        ButtonModel genderSelection = buttonGroup1.getSelection();
        String genderId = genderSelection.getActionCommand();
        String City = String.valueOf(jComboBox3.getSelectedIndex());

        try {
            ResultSet resultset = MySQL.execute("UPDATE `teacher` SET `teacher`.`Full_Name`='" + FullName + "',`teacher`.`Name_With_Initials`='" + NameWithInitials + "',`teacher`.`Address`='" + Address + "',`teacher`.`city_id`='" + City + "',`teacher`.`Gender_id`='" + genderId + "' WHERE `teacher`.`Tno`='" + TeacherNo + "' ");

            DefaultTableModel subject = (DefaultTableModel) jTable1.getModel();
            subject.setRowCount(0);

            DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
            reset();

            jButton4.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//Delete

        String TeacherNo = String.valueOf(jSpinField1.getValue());

        try {

            ResultSet resultset = MySQL.execute("DELETE  FROM `teacher` WHERE `Tno` = '" + TeacherNo + "'");
            ResultSet resultset2 = MySQL.execute("DELETE  FROM `subject_has_teacher` WHERE `Teacher_Tno`='" + TeacherNo + "'");

            DefaultTableModel subject = (DefaultTableModel) jTable1.getModel();
            subject.setRowCount(0);

            DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
            reset();
            jButton4.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        this.dispose();
        Main_Page Main_Page = new Main_Page();
        Main_Page.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jSpinField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinField1PropertyChange
//Tno :)(:

        DefaultTableModel subject = (DefaultTableModel) jTable1.getModel();
        subject.setRowCount(0);

        DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
        teacher.setRowCount(0);
//        try {
//            String Tno = String.valueOf(jSpinField1.getValue());
//                 ResultSet Subjectset = MySQL.execute("SELECT `price`.`Price`,`subject`.`Subno`,`subject`.`name` FROM `subject_has_teacher` INNER JOIN `teacher` ON `teacher`.`Tno`=`subject_has_teacher`.`Teacher_Tno` INNER JOIN `subject`  ON `subject`.`Subno`=`subject_has_teacher`.`Subject_Subno` INNER JOIN `price` ON `subject`.`Price_id` = `price`.`id` WHERE `teacher`.`Tno`='" + Tno + "'");
//            
//        
//        
//         DefaultTableModel subjectTable = (DefaultTableModel) jTable1.getModel();
//
//         
//            while (Subjectset.next()) {
//
//                Vector subjectVector2 = new Vector();
//
//                subjectVector2.add(Subjectset.getString("subject.Subno"));
//
//                subjectVector2.add(Subjectset.getString("subject.name"));
//                subjectVector2.add(Subjectset.getString("price.Price"));
//                subjectTable.addRow(subjectVector2);
//            }
//            
//        } catch (Exception e) {
//        }
//           
        TableLoad();
        reset();

    }//GEN-LAST:event_jSpinField1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String TeacherNo = String.valueOf(jSpinField1.getValue());
        String FullName = jTextField5.getText();
        String NameWithInitials = jTextField2.getText();
        String Address = jTextField3.getText();
        ButtonModel genderSelection = buttonGroup1.getSelection();
        String genderId = genderSelection.getActionCommand();
        String City = String.valueOf(jComboBox3.getSelectedIndex());

        try {

            ResultSet resultset = MySQL.execute("INSERT INTO `teacher` (`Tno`,`Full_Name`,`Name_With_Initials`,`Address`,`city_id`,`Gender_id`) VALUES ('" + TeacherNo + "','" + FullName + "','" + NameWithInitials + "','" + Address + "','" + City + "','" + genderId + "')");
            DefaultTableModel subject = (DefaultTableModel) jTable1.getModel();
            subject.setRowCount(0);

            DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
            reset();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed

        if (evt.getClickCount() == 2) {
            jButton4.setEnabled(false);

            int selectedRow = jTable2.getSelectedRow();
            TeacherNo = jTable2.getValueAt(selectedRow, 0);
            FullName = jTable2.getValueAt(selectedRow, 1);
            NameWithInitials = jTable2.getValueAt(selectedRow, 2);
            Address = jTable2.getValueAt(selectedRow, 3);
            City = jTable2.getValueAt(selectedRow, 4);
            gender = jTable2.getValueAt(selectedRow, 5);

            jSpinField1.setValue(Integer.parseInt((String) TeacherNo));
            jTextField5.setText(String.valueOf(FullName));
            jTextField2.setText(String.valueOf(NameWithInitials));
            jTextField3.setText(String.valueOf(Address));

            if (String.valueOf(gender).equals("female")) {
                jRadioButton1.setSelected(true);

            }
            if (String.valueOf(gender).equals("male")) {
                jRadioButton2.setEnabled(true);
            }

            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(String.valueOf(City))) {
                    String key = entry.getKey();
                    jComboBox3.setSelectedIndex(Integer.parseInt(key));
                }

            }

        }
    }//GEN-LAST:event_jTable2MousePressed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased

        try {
            String FullNam = jTextField6.getText();
            System.out.println(FullNam);

            if (FullNam.equals("")) {
//            TableLoad();

            } else {
                
                       DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
                ResultSet resultset = MySQL.execute("SELECT * FROM `teacher` INNER JOIN `gender` ON `teacher`.`Gender_id`=`gender`.`id` INNER JOIN `city` ON `teacher`.`city_id`=`city`.`id` WHERE `teacher`.`Full_Name` LIKE '" + FullNam + "%'");

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                Vector vector = new Vector();
                while (resultset.next()) {

                    String Teacher_N = resultset.getString(String.valueOf("teacher.Tno"));
                    String Full_Nam = resultset.getString("teacher.Full_Name");
                    String Name_With_Initial = resultset.getString("teacher.Name_With_Initials");
                    String Addres = resultset.getString("teacher.Address");
                    String Cit = resultset.getString("city.name");
                    String Gender = resultset.getString("gender.name");

                    vector.add(Teacher_N);
                    vector.add(Full_Nam);
                    vector.add(Name_With_Initial);
                    vector.add(Addres);
                    vector.add(Cit);
                    vector.add(Gender);

                }
                model.addRow(vector);
            }

     
            reset();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
