/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.view;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.other.StartSQL;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author oshanz
 */
public class Progress extends javax.swing.JFrame {

    private Timer timer;
    private ActionListener action;
    private Connection connection;
    private DatabaseMetaData metaData;
    private ActionListener start;
    private Timer waitTimer;

    /**
     * Creates new form Progress
     */
    public Progress() {

        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        ProgressBar.setStringPainted(true);



        action = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                ProgressBar.setValue(ProgressBar.getValue() + 3);
                if (ProgressBar.getValue() == 100) {
                    timer.stop();
                    LoginForm loginForm = new LoginForm();
                    loginForm.setResizable(false);
                    // loginForm.setLocationRelativeTo();
                    loginForm.setVisible(true);
                    dispose();
                }
                if (ProgressBar.getValue() < 10) {
                    loadLabel.setText("OS : " + System.getProperty("os.name") + "  " + System.getProperty("os.arch") + "  " + System.getProperty("os.version"));
                } else if (ProgressBar.getValue() < 20) {
                    loadLabel.setText("Desktop Dimention  : " + (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() + " * " + (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

                } else if (ProgressBar.getValue() < 25) {
                    loadLabel.setText("JRE version    : " + System.getProperty("java.version"));

                } else if (ProgressBar.getValue() < 40) {
                    long totalMemory = Runtime.getRuntime().totalMemory();
                    long freeMemory = Runtime.getRuntime().freeMemory();
                    loadLabel.setText("Free Memory  : " + (double) ((int) ((double) (freeMemory) * 10000 / (totalMemory))) / 100 + " %");
                    //    timer.stop();
                } else if (ProgressBar.getValue() < 50) {
                    loadLabel.setText("Check Database Connection");
                } else if (ProgressBar.getValue() < 60) {

                    try {
                        connection = DBConnection.getDirectConnection();
                    } catch (ClassNotFoundException ex) {
                        loadLabel.setText("Database Connection Fail : ClassNotFound");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    } catch (SQLException ex) {
                        loadLabel.setText("Database Connection Fail : SQL Error");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    } catch (FileNotFoundException ex) {
                        loadLabel.setText("Database Connection Fail : FileNotFound");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    } catch (IOException ex) {
                        loadLabel.setText("Database Connection Fail : IO Error");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    } catch (NullPointerException ex) {
                        loadLabel.setText("Database Connection Fail : Null Error");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    }

                } else if (ProgressBar.getValue() < 70) {
                    loadLabel.setText("Database Connection : Pass");
                } else if (ProgressBar.getValue() < 80) {
                    loadLabel.setText("Chack Database Transactions Support");

                } else if (ProgressBar.getValue() < 90) {
                    try {
                        metaData = connection.getMetaData();
                    } catch (Exception ex) {
                        loadLabel.setText("Database Dosent Supports Transactions : SQL Error");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    }

                    try {
                        if (metaData.supportsTransactions()) {
                            loadLabel.setText("Database Supports Transactions");
                        }
                    } catch (Exception ex) {
                        loadLabel.setText("Database Dosent Supports Transactions : SQL Error");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    }
                } else if (ProgressBar.getValue() < 100) {
                    try {
                        if (!metaData.supportsTransactions()) {
                            loadLabel.setText("Database Dosent Supports Transactions");
                        }
                    } catch (Exception ex) {
                        loadLabel.setText("Database Dosent Supports Transactions : SQL Error");
                        errorFound(ProgressBar.getValue(), loadLabel.getText());
                    }
                }
            }
        };

        timer = new Timer(500, action);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProgressBar = new javax.swing.JProgressBar();
        waitLabel = new javax.swing.JLabel();
        loadLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        waitLabel.setText("Please Wait...");

        loadLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(waitLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waitLabel)
                .addGap(18, 18, 18)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel loadLabel;
    private javax.swing.JLabel waitLabel;
    // End of variables declaration//GEN-END:variables

    public void errorFound(int step, String error) {

        timer.stop();
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, error + ".  Are You Sure to Skip this Test ? ", "Loading Error", JOptionPane.YES_NO_CANCEL_OPTION);

        if (showConfirmDialog == 0) { ///ok(skip)
            ProgressBar.setValue(step + 10);
            timer.start();
        } else if (showConfirmDialog == 1) {//try
            if (error.equalsIgnoreCase("Database Connection Fail : SQL Error")) {

                try {
                    new StartSQL().startmysql();
                } catch (IOException ex) {
                    Logger.getLogger(Progress.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //  ProgressBar.setValue(0);
            start = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ProgressBar.setValue(40);
                    timer.start();
                    waitTimer.stop();
                }
            };

            waitTimer = new Timer(5000, start);
            waitTimer.start();


        } else if (showConfirmDialog == 2) { //cancel
            dispose();
        }



    }
}
