package gui.admin;

import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Class_Registration extends javax.swing.JFrame {

    public Class_Registration() {
        initComponents();
        TableLoad();
    }
    HashMap<String, String> subjectMap = new HashMap<>();
    HashMap<String, String> teacherMap = new HashMap<>();
    Vector weekVectorS;
    Vector timeVectorS;

    
       public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null; // Value not found in the map
    }

    
    private void TableLoad() {

        try {
//        Subject add to combobox
            ResultSet subjectSet = MySQL.execute("SELECT * FROM `subject`");
            Vector subjectVector = new Vector();
            subjectVector.add("Select");
            while (subjectSet.next()) {
                subjectVector.add(subjectSet.getString(String.valueOf("name")));
                subjectMap.put(String.valueOf(subjectSet.getString("Subno")), subjectSet.getString("name"));
            }
            DefaultComboBoxModel subjectComboModel = new DefaultComboBoxModel<>(subjectVector);
            jComboBox1.setModel(subjectComboModel);

            //teacher add to combobox
            ResultSet teacherset = MySQL.execute("SELECT * FROM `teacher`");
            Vector teacherVector = new Vector();
            teacherVector.add("Select");
            while (teacherset.next()) {
                teacherVector.add(teacherset.getString("Name_With_Initials"));
                teacherMap.put(String.valueOf(teacherset.getString("Tno")), teacherset.getString("Name_With_Initials"));

            }
            DefaultComboBoxModel teacherComboModel = new DefaultComboBoxModel<>(teacherVector);
            jComboBox3.setModel(teacherComboModel);



            //add Items to table
            DefaultTableModel tablemodel = (DefaultTableModel) jTable1.getModel();

            ResultSet classSet = MySQL.execute("SELECT * FROM `class` INNER JOIN `subject` ON `subject`.`Subno`=`class`.`Subject_Subno` INNER JOIN `week_days` ON `week_days`.`id` = `class`.`Week_Days_id` INNER JOIN `teacher` ON `teacher`.`Tno` = `class`.`Teacher_Tno`");

            while (classSet.next()) {
                Vector vector = new Vector();
                vector.add(String.valueOf(classSet.getString("class.Classno")));
                vector.add(String.valueOf(classSet.getString("subject.name")));
                vector.add(classSet.getString("teacher.Name_With_Initials"));
                vector.add(classSet.getString("week_days.Day"));
                vector.add(classSet.getString("class.Time_From"));
                vector.add(classSet.getString("class.Time_To"));
                tablemodel.addRow(vector);
            }
//geting data from week combobox
            DefaultComboBoxModel weekdays = (DefaultComboBoxModel) jComboBox5.getModel();
            weekVectorS = new Vector();

            for (int i = 0; i < weekdays.getSize(); i++) {
                String day = String.valueOf(weekdays.getElementAt(i));
                weekVectorS.add(day);
            }

            //geting data from week combobox
            DefaultComboBoxModel timedays = (DefaultComboBoxModel) jComboBox5.getModel();
            timeVectorS = new Vector();

            for (int i = 0; i < timedays.getSize(); i++) {
                String time = String.valueOf(timedays.getElementAt(i));
                timeVectorS.add(time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jComboBox1.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Day");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        jButton3.setText("Update Class");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 120, 30));

        jLabel5.setText("Time - From");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, 30));

        jLabel6.setText("Time -  To");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel1.setText("Subject Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 134, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Class Registration");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel7.setText("Teacher");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 134, 31));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "class No.", "Subject Name", "Teacher", "Date", "From", "To"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 580, 270));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 134, 31));

        jButton6.setText("Add Class");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 130, 30));

        jButton1.setText("Delete Class");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 130, 30));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 134, 31));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM" }));
        jPanel1.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 134, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Object Classno;

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String clas = String.valueOf(Classno);
        String subject = String.valueOf(jComboBox1.getSelectedItem());
        String teacher = String.valueOf(jComboBox3.getSelectedIndex());
        String day = String.valueOf(jComboBox5.getSelectedIndex());
        String TimeFrom = String.valueOf(jComboBox6.getSelectedItem());
        String TimeTo = String.valueOf(jComboBox2.getSelectedItem());

            String key = getKeyByValue(subjectMap, subject);

        if (key != null) {
      
        ResultSet resultset = MySQL.execute("UPDATE `class` SET `class`.`Time_From`='" + TimeFrom + "',`Time_To`='" + TimeTo + "',`Subject_Subno`='" + key + "',`Week_Days_id`='" + day + "',`Teacher_Tno`='" + teacher + "' WHERE `Classno`='" + clas + "'");

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        TableLoad();
        reset();
                jButton6.setEnabled(true);

          } else {
            System.out.println("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String cls = String.valueOf(Classno);
ResultSet resultset = MySQL.execute("DELETE FROM `class` WHERE `Classno`='"+cls+"'");

  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        TableLoad();
        reset();
        jButton6.setEnabled(true);
        } catch (Exception e) {
        
        e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        Main_Page Main_Page = new Main_Page();
        Main_Page.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String subjectname = String.valueOf(jComboBox1.getSelectedIndex());
        String Teacher = String.valueOf(jComboBox3.getSelectedIndex());
        String day = String.valueOf(jComboBox5.getSelectedIndex());
        String from = String.valueOf(jComboBox6.getSelectedItem());
        String to = String.valueOf(jComboBox2.getSelectedItem());

        ResultSet resultset = MySQL.execute("INSERT INTO `class` (`Time_From`,`Time_To`,`Subject_Subno`,`Week_Days_id`,`Teacher_Tno`,`teacher_attendence`) VALUES ('" + from + "','" + to + "','" + subjectname + "','" + day + "','" + Teacher + "','false')");

        DefaultTableModel cls = (DefaultTableModel) jTable1.getModel();
        cls.setRowCount(0);
        TableLoad();
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed
    Object SubjectNames;
    Object Teachers;
    Object Dates;
    Object TimeFroms;
    Object TimeTos;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {

            try {
                jButton6.setEnabled(false);

                int selectedRow = jTable1.getSelectedRow();
                Classno = jTable1.getValueAt(selectedRow, 0);
                SubjectNames = jTable1.getValueAt(selectedRow, 1);
                Teachers = jTable1.getValueAt(selectedRow, 2);
                Dates = jTable1.getValueAt(selectedRow, 3);
                TimeFroms = jTable1.getValueAt(selectedRow, 4);
                TimeTos = jTable1.getValueAt(selectedRow, 5);

                jComboBox1.setSelectedItem(SubjectNames);
                jComboBox3.setSelectedItem(Teachers);
                jComboBox5.setSelectedItem(Dates);

                jComboBox6.setSelectedItem(TimeFroms);
                jComboBox2.setSelectedItem(TimeTos);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Class_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.raven.swing.TimePicker timePicker1;
    // End of variables declaration//GEN-END:variables
}
