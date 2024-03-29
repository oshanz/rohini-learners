/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.view.common;

import cmjdproject.learner.controller.CandidateController;
import cmjdproject.learner.controller.ShedulepartController;
import cmjdproject.learner.models.CandidateMod;
import cmjdproject.learner.models.ShedulepartMod;
import cmjdproject.learner.other.SortJTable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oshanz
 */
public class ViewVisitors extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewVisitors
     */
    public ViewVisitors() {
        initComponents();
        new SortJTable().sort(jTable1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        timeComboBox = new javax.swing.JComboBox();
        loadButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        amountlable = new javax.swing.JLabel();
        reportButton = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        dateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "ThursDay", "Friday", "Saturday" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time", "Telephone", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "9.30 am", "11.30 am", "2.30 pm", "4.30 pm" }));
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });

        loadButton.setText("View");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Amount");

        amountlable.setText(" ");

        reportButton.setText("Print");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(amountlable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadButton)
                    .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(amountlable)
                    .addComponent(reportButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeComboBoxActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        String time = timeComboBox.getSelectedItem().toString();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.getDataVector().removeAllElements();
        //   jTable1.setModel(dtm);

        if (time.equalsIgnoreCase("All")) {
            if (jTable1.getColumnCount() == 3) {
                jTable1.setModel(new DefaultTableModel());
                jTable1.setModel(dtm);
            }
            try {
                ArrayList<ShedulepartMod> participants = new ShedulepartController().getparticipantsofday(dateComboBox.getSelectedItem().toString());
                for (ShedulepartMod partmod : participants) {
                    //  System.out.println(rid);
                    CandidateMod candidateInfo = new CandidateController().getCandidateInfo(partmod.getRid());
                    dtm.addRow(new String[]{candidateInfo.getName(), partmod.getTime(), candidateInfo.getTelephone() + "", candidateInfo.getAddress()});

                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            }

            amountlable.setText(String.valueOf(jTable1.getRowCount()));
        } else {
            if (jTable1.getColumnCount() > 3) {
                jTable1.removeColumn(jTable1.getColumn("Time"));

            }
            try {
                ArrayList<String> participants = new ShedulepartController().getparticipants(dateComboBox.getSelectedItem().toString(), timeComboBox.getSelectedItem().toString());
                for (String rid : participants) {
                    //  System.out.println(rid);
                    CandidateMod candidateInfo = new CandidateController().getCandidateInfo(rid);

                    dtm.addRow(new String[]{candidateInfo.getName(), "", candidateInfo.getTelephone() + "", candidateInfo.getAddress()});

                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewVisitors.class.getName()).log(Level.SEVERE, null, ex);
            }

            amountlable.setText(String.valueOf(jTable1.getRowCount()));
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        // TODO add your handling code here:

        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Do you want to print the address only ? ", "Print Report", JOptionPane.YES_NO_CANCEL_OPTION);

        if (showConfirmDialog == 0) {//yes
            //report address only
        }
        if (showConfirmDialog == 1) {//no
            //report name address telephone
        }
        if (showConfirmDialog == 2) {//cancel
            //nothing
        }

    }//GEN-LAST:event_reportButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountlable;
    private javax.swing.JComboBox dateComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JComboBox timeComboBox;
    // End of variables declaration//GEN-END:variables
}
