/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.view.manager.internels;

import cmjdproject.learner.controller.RegisterController;
import cmjdproject.learner.models.CandidateMod;
import cmjdproject.learner.other.FormatedDate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.joda.time.DateTimeComparator;

/**
 *
 * @author oshanz
 */
public class ClearRecords extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClearRecords
     */
    private DefaultTableModel dtm;

    public ClearRecords() {
        initComponents();
        //  SearchViaCombo searchViaCombo = new SearchViaCombo();
        //   searchViaCombo.setResultViaCombo(jComboBox1, true, "");
//
//        SwingSorter swingSorter = new SwingSorter();
//        swingSorter.sortComboBox(jComboBox1);
//        new AutoCompletion(jComboBox1);
        // new JComboBoxAutoCompletador(jComboBox1);
        dtm = (DefaultTableModel) jTable1.getModel();
        loadexpires();



    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Expired Registrations"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Clear All");

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadexpires();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public boolean loadexpires() {
        boolean exists = false;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            ArrayList<String> regdate = new RegisterController().getregdate();
            for (String rdate : regdate) {
                String[] split = rdate.split("-\\s*");
                String b = (Integer.parseInt(split[2]) + 1) + "-" + (Integer.parseInt(split[1]) + 6) + "-" + split[0];
                Date valueOf = Date.valueOf(b);
                Date valueOf1 = Date.valueOf(new FormatedDate().getDate("yyyy-MM-dd"));
                int compare = DateTimeComparator.getInstance().compare(valueOf1, valueOf);
                if (compare >= 0) {//valuof < valuof1 /////// valueof is old ////clean
                    //System.out.println("win " + valueOf + " " + valueOf1);

                    arrayList.add(rdate);
                    //System.out.println("win " + valueOf + " " + valueOf1);

                    exists = true;
                } else {
                    // System.out.println("hik " + valueOf + " " + valueOf1);
                }
            }
            ArrayList<CandidateMod> nidfromdate = RegisterController.getnidfromdate(arrayList);
            for (CandidateMod candidateMod : nidfromdate) {
                // System.out.println(candidateMod.getNid() + "  " + candidateMod.getName());
                if (dtm.getRowCount() == 0) {
                    dtm.addRow(new String[]{candidateMod.getNid(), candidateMod.getName()});
                } else {
                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        String valueAt = (String) dtm.getValueAt(i, 0);
                        //   System.out.println(valueAt);
                        if (valueAt.equalsIgnoreCase(candidateMod.getNid())) {
                            break;
                        }
                        if (i == dtm.getRowCount() - 1) {
                            dtm.addRow(new String[]{candidateMod.getNid(), candidateMod.getName()});
                            break;
                        }

                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showConfirmDialog(null, "Error at : " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null, "Error at : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error at : " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Error at : " + ex.getMessage());
        }
        return exists;
    }
}
