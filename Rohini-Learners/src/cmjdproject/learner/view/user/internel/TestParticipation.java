/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.view.user.internel;

import cmjdproject.learner.controller.CandidateController;
import cmjdproject.learner.controller.RegisterController;
import cmjdproject.learner.controller.TestController;
import cmjdproject.learner.controller.TestpartController;
import cmjdproject.learner.models.CandidateMod;
import cmjdproject.learner.models.TestpartMod;
import cmjdproject.learner.other.FormatedDate;
import cmjdproject.learner.other.LoadtoCombo;
import com.toedter.calendar.JCalendar;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author oshanz
 */
public class TestParticipation extends javax.swing.JInternalFrame {

    private Calendar instance;
    private DefaultTableModel dtm;
    private DefaultTableModel updatedtm;
    private TableRowSorter<TableModel> sorter;

    /**
     * Creates new form TestParticipation
     */
    public TestParticipation() {

        initComponents();
        dtm = (DefaultTableModel) testTable.getModel();
        updatedtm = (DefaultTableModel) updateTable.getModel();
        instance = Calendar.getInstance();

        // System.out.println(jDateChooser1.set);
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //  String format = simpleDateFormat.format(instance.getTime());
        //System.out.println(format);
        dateChooser.setDate(instance.getTime());
        dateChooser.setMinSelectableDate(new JCalendar().getDate());

        updaDateChooser.setDate(instance.getTime());

        try {
            new LoadtoCombo().load(candidatesCombox);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        }

        MouseWheelListener mouseWheelListener = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent evt) {

                int index = candidatesCombox.getSelectedIndex() + evt.getWheelRotation();
                if (index >= 0 && index < candidatesCombox.getItemCount()) {
                    candidatesCombox.setSelectedIndex(index);
                }

            }
        };

        candidatesCombox.addMouseWheelListener(mouseWheelListener);

        sorter = new TableRowSorter<TableModel>(updatedtm);
        updateTable.setRowSorter(sorter);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        testsComboBox = new javax.swing.JComboBox();
        statusRadioBuddon = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        candidatesCombox = new javax.swing.JComboBox();
        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        amountlable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        updaDateChooser = new com.toedter.calendar.JDateChooser();
        loadButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        updateTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);

        testTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                testTabbedPaneMouseReleased(evt);
            }
        });

        dateChooser.setDateFormatString("dd-MM-yyyy");
        dateChooser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateChooserFocusLost(evt);
            }
        });
        dateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateChooserKeyReleased(evt);
            }
        });

        testsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Literal", "Trial" }));
        testsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testsComboBoxActionPerformed(evt);
            }
        });

        statusRadioBuddon.setSelected(true);
        statusRadioBuddon.setText("Newbies");

        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(testTable);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Amount");

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        amountlable.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(testsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusRadioBuddon))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(amountlable, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(candidatesCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(testsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusRadioBuddon))
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(candidatesCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(jLabel1)
                    .addComponent(amountlable))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        testTabbedPane.addTab("    Add to Test    ", jPanel1);

        updaDateChooser.setDateFormatString("dd-MM-yyyy");

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        updateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "Name", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(updateTable);

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("Search");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(updaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loadButton)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(35, 35, 35))
        );

        testTabbedPane.addTab("Update Informations", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testsComboBoxActionPerformed

    private void testTabbedPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testTabbedPaneMouseReleased
        // TODO add your handling code here:
        if (testTabbedPane.getModel().getSelectedIndex() == 1) {
//
        }

    }//GEN-LAST:event_testTabbedPaneMouseReleased

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        // save to db
        String date = new FormatedDate().getDate(dateChooser.getDate());
        //String testType = testsComboBox.getSelectedIndex() + "";

        ArrayList<TestpartMod> arrayList = new ArrayList<TestpartMod>();
        Random random = new Random();
        int seed = random.nextInt(99);
        String testType = seed + "";
        try {
            new TestController().setfake(testType);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        }

        for (int i = 0; i < testTable.getRowCount(); i++) {
            //System.out.println(dtm.getValueAt(i, 0)); //nic
            //  System.out.println(dtm.getValueAt(i, 1)); //name
            // System.out.println(dtm.getValueAt(i, 2)); //status
            String ristrationid;
            try {
                ristrationid = RegisterController.getRistrationid(dtm.getValueAt(i, 0).toString());
                arrayList.add(new TestpartMod(ristrationid, testType, date, dtm.getValueAt(i, 2).toString()));
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());

            }

        }
        //      System.out.println("ok");
        try {
            int addtotest = new TestpartController().addtotest(arrayList);
            if (addtotest < 0) {
                JOptionPane.showMessageDialog(this, "Error  ");
            } else {
                JOptionPane.showMessageDialog(this, "Done");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        }


        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Do you want to print the address only Report ? ", "Print Report", JOptionPane.YES_NO_CANCEL_OPTION);
        if (showConfirmDialog == 0) {//yes
            //report address only
        }
        if (showConfirmDialog == 1) {//no
            //report name address telephone
        }
        if (showConfirmDialog == 2) {//cancel
            //nothing
        }


    }//GEN-LAST:event_saveButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String[] split = candidatesCombox.getSelectedItem().toString().split(",\\s*");
        //   System.out.println(split[1] + " " + split[0]);
        String status = statusRadioBuddon.isSelected() ? "new" : "not";
        //System.out.println(status);
        if (dtm.getRowCount() == 0) {
            dtm.addRow(new String[]{split[0], split[1], status});
        } else {
            String valueAt;
            for (int i = 0; i < dtm.getRowCount(); i++) {
                valueAt = (String) dtm.getValueAt(i, 0);
                //   System.out.println(split[0] + " " + valueAt);
                if (valueAt.equalsIgnoreCase(split[0])) {
                    JOptionPane.showMessageDialog(this, "Candidate exsits");
                    break;
                }
                if (i == dtm.getRowCount() - 1) {
                    dtm.addRow(new String[]{split[0], split[1], status});
                    break;
                }

            }
        }


        amountlable.setText(testTable.getRowCount() + "");

        // new RegisterController().
    }//GEN-LAST:event_addButtonActionPerformed

    private void dateChooserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateChooserKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserKeyReleased

    private void dateChooserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateChooserFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserFocusLost

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        String date = new FormatedDate().getDate(updaDateChooser.getDate());
        updatedtm.getDataVector().removeAllElements();
        // updateTable.setModel(updatedtm);
        try {
            ArrayList<String> data = new TestpartController().getdata(date);//rid
            CandidateMod candidateInfo;
            for (String string : data) {
                candidateInfo = new CandidateController().getCandidateInfo(string);
                updatedtm.addRow(new String[]{candidateInfo.getNid(), candidateInfo.getName()});
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error at : " + ex.getMessage());
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        String text = jTextField1.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.err.println("Bad regex pattern");
            }
        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        //   jTextField1.setText("Search");
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //  ArrayList<TestpartMod> arrayList = new ArrayList<TestpartMod>();
        //TestpartController.insertresult(new FormatedDate().getDate(updaDateChooser.getDate()));
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel amountlable;
    private javax.swing.JComboBox candidatesCombox;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton statusRadioBuddon;
    private javax.swing.JTabbedPane testTabbedPane;
    private javax.swing.JTable testTable;
    private javax.swing.JComboBox testsComboBox;
    private com.toedter.calendar.JDateChooser updaDateChooser;
    private javax.swing.JTable updateTable;
    // End of variables declaration//GEN-END:variables
}
