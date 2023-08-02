package gui.admin;

import model.MySQL;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Student_Class_Registration extends javax.swing.JFrame {

    public Student_Class_Registration() {
        initComponents();
        TableLoad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Class Id");

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(69, 75, 75));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_48px.png"))); // NOI18N
        jButton6.setText("Go Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Add ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Update");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Student - Class Registration");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name", "Class Id", "Subject", "Day of  Week", "Starting Time", "End TIme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setText("Student Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel5)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
        
    
    private void reset(){
    
        jComboBox3.setSelectedIndex(0);
                jComboBox4.setSelectedIndex(0);

    }
    
    private void TableLoad() {

        try {
            //loading items for studentcombobox

            ResultSet studentSet = MySQL.execute("SELECT * FROM `student`");
            Vector studentVector = new Vector();
            studentVector.add("Select");
            while (studentSet.next()) {

                studentVector.add(String.valueOf(studentSet.getString("Sno")));

            }
            DefaultComboBoxModel studentComboBox = new DefaultComboBoxModel<>(studentVector);
            jComboBox4.setModel(studentComboBox);

            //loading classid for classComboBox
            ResultSet classSet = MySQL.execute("SELECT * FROM `class`");
            Vector classVector = new Vector();
            classVector.add("Select");
            while (classSet.next()) {
                classVector.add(String.valueOf(classSet.getString("Classno")));

            }
            DefaultComboBoxModel classComboBox = new DefaultComboBoxModel<>(classVector);
            jComboBox3.setModel(classComboBox);

            //loading the table items 
            ResultSet tableset = MySQL.execute("SELECT * FROM `student_has_class` INNER JOIN `student` ON `student`.`Sno`=`student_has_class`.`Student_Sno` INNER JOIN `class` ON `class`.`Classno` = `student_has_class`.`Class_Classno` INNER JOIN `week_days` ON `class`.`Week_Days_id` = `week_days`.`id` INNER JOIN `subject` ON `subject`.`Subno` = `class`.`Subject_Subno`");

            DefaultTableModel tablemodel = (DefaultTableModel) jTable2.getModel();

            while (tableset.next()) {

                Vector vector = new Vector();
                vector.add(tableset.getString("student_has_class.Student_Sno"));
                vector.add(tableset.getString("student.Name_With_Initials"));
                vector.add(tableset.getString("student_has_class.Class_Classno"));
                vector.add(tableset.getString("subject.name"));
                vector.add(tableset.getString("week_days.Day"));
                vector.add(tableset.getString("class.Time_From"));
                vector.add(tableset.getString("class.Time_To"));

                tablemodel.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        this.dispose();
        Main_Page Main_Page = new Main_Page();
        Main_Page.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    Object Studentid;
    Object StudentName;
    Object ClassId;
    Object SubjectName;
    Object Day;
    Object TimeFrom;
    Object TimeTo;


    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
            if (evt.getClickCount() == 2) {
                jButton7.setEnabled(false);

                int selectedRow = jTable2.getSelectedRow();
                Studentid = jTable2.getValueAt(selectedRow, 0);
                StudentName = jTable2.getValueAt(selectedRow, 1);
                ClassId = jTable2.getValueAt(selectedRow, 2);
                SubjectName = jTable2.getValueAt(selectedRow, 3);
                Day = jTable2.getValueAt(selectedRow, 4);
                TimeFrom = jTable2.getValueAt(selectedRow, 5);
                TimeTo = jTable2.getValueAt(selectedRow, 5);

                jComboBox4.setSelectedItem(Studentid);
                                jComboBox3.setSelectedItem(ClassId);

            }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
String Sno = String.valueOf(jComboBox4.getSelectedItem());
        String Classno = String.valueOf(jComboBox3.getSelectedItem());
        
ResultSet resultset = MySQL.execute("INSERT INTO `student_has_class` (`Student_Sno`,`Class_CLassno`,`Student_Attendence`) VALUES ('"+Sno+"','"+Classno+"','false')");

  DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
            reset();

    }//GEN-LAST:event_jButton7ActionPerformed

   
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
String StudentID= String.valueOf(jComboBox4.getSelectedItem());
String ClassID = String.valueOf(jComboBox3.getSelectedItem());

ResultSet resultset = MySQL.execute("UPDATE `student_has_class` SET `Student_Sno`='"+StudentID+"',`Class_Classno`='"+ClassID+"'");

  DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
            reset();
            jButton7.setEnabled(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
String studentID = String.valueOf(Studentid);

        String ClassID = String.valueOf(ClassId);

ResultSet resultset = MySQL.execute("DELETE FROM `student_has_class` WHERE `Student_Sno`='"+studentID+"' AND `Class_Classno`='"+ClassID+"'");
 DefaultTableModel teacher = (DefaultTableModel) jTable2.getModel();
            teacher.setRowCount(0);
            TableLoad();
            reset();
            jButton7.setEnabled(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Class_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
