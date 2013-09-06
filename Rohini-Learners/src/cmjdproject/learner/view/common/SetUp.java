/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.view.common;

import cmjdproject.learner.other.BackUp;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author oshanz
 */
public class SetUp extends javax.swing.JFrame {

    private int showConfirmDialog;
    private Properties dbproperties;
    private Properties logproperties;
    private StandardPBEStringEncryptor standardPBEStringEncryptor;
    //private String adminpass;
    private StrongPasswordEncryptor strongPasswordEncryptor;
    private char[] password;
    private String string;
    private String encrypt;
    private FileOutputStream fileOutputStream;
    private int done = 0;
    private String usrencryptPassword;
    private String adminencryptPassword;
    private String url;

    /**
     * Creates new form SetUp
     */
    public SetUp() {

        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        this.dbproperties = new Properties();
        this.logproperties = new Properties();
        this.strongPasswordEncryptor = new StrongPasswordEncryptor();
        this.standardPBEStringEncryptor.setPassword("Rohini");
        this.url = "jdbc:mysql://localhost/";
        //   System.out.println(url);
        //  usrButton.setEnabled(false);

//
//        try {
//            initComponents();
//            FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
//            dbproperties.load(fileInputStream);
//
//            dbUrlTxt.setText(dbproperties.getProperty("dburl"));
//            dbUserTxt.setText(dbproperties.getProperty("dbuser"));
//            //  dbPasswordField.setText(properties.getProperty("dbpassword"));
//
//        } catch (IOException ex) {
//            Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
//        }


        dbPasswordField.requestFocus(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dBSetting = new javax.swing.JLabel();
        urlLable = new javax.swing.JLabel();
        userLable = new javax.swing.JLabel();
        passLable = new javax.swing.JLabel();
        dbUrlTxt = new javax.swing.JTextField();
        dbUserTxt = new javax.swing.JTextField();
        dbPasswordField = new javax.swing.JPasswordField();
        Separator = new javax.swing.JSeparator();
        userSettLable = new javax.swing.JLabel();
        usretLabel = new javax.swing.JLabel();
        newPassLabel = new javax.swing.JLabel();
        adminPasswordField = new javax.swing.JPasswordField();
        tryAgLabel = new javax.swing.JLabel();
        adminconfirmPasswordField = new javax.swing.JPasswordField();
        dbButton = new javax.swing.JButton();
        usrButton = new javax.swing.JButton();
        tryAgLabel1 = new javax.swing.JLabel();
        usrconfirmPasswordField = new javax.swing.JPasswordField();
        usrnewPasswordField = new javax.swing.JPasswordField();
        newPassLabel1 = new javax.swing.JLabel();
        ussetLabel1 = new javax.swing.JLabel();
        dbtryAgLabel = new javax.swing.JLabel();
        dbconfirmPasswordField = new javax.swing.JPasswordField();
        Separator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        Separator2 = new javax.swing.JSeparator();
        operlable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dBSetting.setText("Database Settings");

        urlLable.setText("Database");

        userLable.setText("User");

        passLable.setText("Password");

        dbUrlTxt.setEditable(false);
        dbUrlTxt.setText("learner");
        dbUrlTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbUrlTxtActionPerformed(evt);
            }
        });

        dbUserTxt.setText("root");
        dbUserTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbUserTxtActionPerformed(evt);
            }
        });

        dbPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbPasswordFieldActionPerformed(evt);
            }
        });
        dbPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dbPasswordFieldKeyReleased(evt);
            }
        });

        userSettLable.setText("Users Setting");

        usretLabel.setText("Admin");

        newPassLabel.setText("New Password");

        adminPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPasswordFieldActionPerformed(evt);
            }
        });

        tryAgLabel.setText("Confirm");

        adminconfirmPasswordField.setEnabled(false);
        adminconfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminconfirmPasswordFieldActionPerformed(evt);
            }
        });
        adminconfirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adminconfirmPasswordFieldKeyReleased(evt);
            }
        });

        dbButton.setText("Save");
        dbButton.setEnabled(false);
        dbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbButtonActionPerformed(evt);
            }
        });
        dbButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dbButtonKeyReleased(evt);
            }
        });

        usrButton.setText("Save");
        usrButton.setEnabled(false);
        usrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrButtonActionPerformed(evt);
            }
        });
        usrButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usrButtonKeyReleased(evt);
            }
        });

        tryAgLabel1.setText("Confirm");

        usrconfirmPasswordField.setEnabled(false);
        usrconfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrconfirmPasswordFieldActionPerformed(evt);
            }
        });
        usrconfirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usrconfirmPasswordFieldKeyReleased(evt);
            }
        });

        usrnewPasswordField.setEnabled(false);
        usrnewPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrnewPasswordFieldActionPerformed(evt);
            }
        });

        newPassLabel1.setText("New Password");

        ussetLabel1.setText("User");

        dbtryAgLabel.setText("Confirm");

        dbconfirmPasswordField.setEnabled(false);
        dbconfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbconfirmPasswordFieldActionPerformed(evt);
            }
        });
        dbconfirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dbconfirmPasswordFieldKeyReleased(evt);
            }
        });

        Separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setText("store Database");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Separator)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userSettLable)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPassLabel)
                                    .addComponent(tryAgLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usretLabel)
                                    .addComponent(adminPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminconfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPassLabel1)
                                    .addComponent(tryAgLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ussetLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usrnewPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usrconfirmPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(urlLable)
                                    .addComponent(passLable)
                                    .addComponent(dBSetting)
                                    .addComponent(userLable)
                                    .addComponent(dbtryAgLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dbUserTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dbPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dbconfirmPasswordField)
                                    .addComponent(dbUrlTxt)))
                            .addComponent(Separator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dbButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(operlable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dBSetting)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLable)
                    .addComponent(dbUrlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLable)
                    .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLable)
                    .addComponent(dbPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbconfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbtryAgLabel))
                .addGap(18, 18, 18)
                .addComponent(dbButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(operlable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ussetLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(newPassLabel1)
                                    .addComponent(usrnewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tryAgLabel1)
                                    .addComponent(usrconfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usretLabel)
                                    .addComponent(userSettLable))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(newPassLabel)
                                    .addComponent(adminPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tryAgLabel)
                                    .addComponent(adminconfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usrButton))
                    .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbButtonActionPerformed

        try {
            // TODO add your handling code here:
            // TODO add your handling code here:
            // FileInputStream fileInputStream = new FileInputStream("loginconfig.properties");
            // logproperties.load(fileInputStream);
            // adminpass = logproperties.getProperty("adminpass");
            //standardPBEStringEncryptor.setPassword(adminpass);
            password = dbPasswordField.getPassword();
            string = new String(password);
            encrypt = standardPBEStringEncryptor.encrypt(string);

            dbproperties.setProperty("dburl", url + dbUrlTxt.getText());
            dbproperties.setProperty("dbuser", dbUserTxt.getText());
            dbproperties.setProperty("dbpassword", encrypt);
            System.out.println(dbUrlTxt.getText() + " " + dbUserTxt.getText() + " " + encrypt);

            fileOutputStream = new FileOutputStream("dbconfig.properties");
            dbproperties.store(fileOutputStream, null);
            fileOutputStream.close();

        } catch (IOException ex) {
            Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.done += 1;
        JOptionPane.showMessageDialog(this, "Settings Saved");
        checkdispose();
        adminPasswordField.requestFocus(true);
    }//GEN-LAST:event_dbButtonActionPerformed

    private void dbUrlTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbUrlTxtActionPerformed
        // TODO add your handling code here:
        dbUserTxt.requestFocus(true);
    }//GEN-LAST:event_dbUrlTxtActionPerformed

    private void dbPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbPasswordFieldActionPerformed
        // TODO add your handling code here:
        dbPasswordField.setEditable(false);
        dbconfirmPasswordField.setEnabled(true);
        dbconfirmPasswordField.requestFocus(true);
        //  dbButtonActionPerformed(evt);
    }//GEN-LAST:event_dbPasswordFieldActionPerformed

    private void adminPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPasswordFieldActionPerformed
        // TODO add your handling code here:
        adminconfirmPasswordField.setEnabled(true);
        adminconfirmPasswordField.requestFocus(true);
        adminPasswordField.setEditable(false);
    }//GEN-LAST:event_adminPasswordFieldActionPerformed

    private void adminconfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminconfirmPasswordFieldActionPerformed
        // TODO add your handling code here
        if (new String(adminPasswordField.getPassword()).equals(new String(adminconfirmPasswordField.getPassword()))) {

            usrnewPasswordField.setEnabled(true);
            usrnewPasswordField.requestFocus(true);
        } else {
            JOptionPane.showMessageDialog(this, "Password Dosent Match");
            adminPasswordField.setBackground(Color.red);
            adminPasswordField.setText("");
            adminconfirmPasswordField.setText("");
            adminconfirmPasswordField.setBackground(Color.red);
        }
    }//GEN-LAST:event_adminconfirmPasswordFieldActionPerformed

    private void usrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrButtonActionPerformed
        // TODO add your handling code here:


        adminencryptPassword = strongPasswordEncryptor.encryptPassword(new String(adminPasswordField.getPassword()));
        usrencryptPassword = strongPasswordEncryptor.encryptPassword(new String(usrnewPasswordField.getPassword()));
        try {
            logproperties.setProperty("userpass", usrencryptPassword);
            logproperties.setProperty("adminpass", adminencryptPassword);
            logproperties.store(new FileOutputStream("loginconfig.properties"), null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
        }



        //        String user = usersComboBox.getSelectedItem().toString();
        //        char[] usrpassword = confirmPasswordField.getPassword();
        //        String usrstring = new String(usrpassword);
        //        String encryptPassword = strongPasswordEncryptor.encryptPassword(usrstring);

//        if (user == "User") {
//            try {
//                logproperties.store(new FileOutputStream("loginconfig.properties"), null);
//
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//            try {
//                logproperties.store(new FileOutputStream("loginconfig.properties"), null);
//                logproperties.setProperty("adminpass", encryptPassword);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
        JOptionPane.showMessageDialog(null, "Settings Saved");
        this.done += 1;
        checkdispose();

    }//GEN-LAST:event_usrButtonActionPerformed

    private void adminconfirmPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminconfirmPasswordFieldKeyReleased
        // TODO add your handling code here:
//        usrButton.setEnabled(false);
//        char[] password = newPasswordField.getPassword();
//        String string = new String(password);
//        char[] password1 = confirmPasswordField.getPassword();
//        String string1 = new String(password);
//        if (string.equals(string1)) {
//            usrButton.setEnabled(true);
//        }
    }//GEN-LAST:event_adminconfirmPasswordFieldKeyReleased

    private void usrconfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrconfirmPasswordFieldActionPerformed
        // TODO add your handling code here:
        if (new String(usrnewPasswordField.getPassword()).equals(new String(usrconfirmPasswordField.getPassword()))) {
            usrButton.setEnabled(true);
            usrButton.requestFocus(true);


        } else {
            JOptionPane.showMessageDialog(this, "Password Dosent Match");
            usrnewPasswordField.setBackground(Color.red);
            usrnewPasswordField.setText("");
            usrconfirmPasswordField.setText("");
            usrconfirmPasswordField.setBackground(Color.red);
        }
    }//GEN-LAST:event_usrconfirmPasswordFieldActionPerformed

    private void usrconfirmPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usrconfirmPasswordFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_usrconfirmPasswordFieldKeyReleased

    private void usrnewPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrnewPasswordFieldActionPerformed
        // TODO add your handling code here:
        usrconfirmPasswordField.setEnabled(true);
        usrconfirmPasswordField.requestFocus(true);
        usrnewPasswordField.setEditable(false);
    }//GEN-LAST:event_usrnewPasswordFieldActionPerformed

    private void dbPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbPasswordFieldKeyReleased
        // TODO add your handling code here:
        //     dbButton.setEnabled(true);
    }//GEN-LAST:event_dbPasswordFieldKeyReleased

    private void dbconfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbconfirmPasswordFieldActionPerformed
        // TODO add your handling code here:
        if (new String(dbPasswordField.getPassword()).equals(new String(dbconfirmPasswordField.getPassword()))) {

            dbButton.setEnabled(true);
            dbButton.requestFocus(true);
        } else {
            JOptionPane.showMessageDialog(this, "Password Dosent Match");
            dbPasswordField.setBackground(Color.red);
            dbPasswordField.setText("");
            dbconfirmPasswordField.setText("");
            dbconfirmPasswordField.setBackground(Color.red);
        }
    }//GEN-LAST:event_dbconfirmPasswordFieldActionPerformed

    private void dbconfirmPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbconfirmPasswordFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dbconfirmPasswordFieldKeyReleased

    private void dbUserTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbUserTxtActionPerformed
        // TODO add your handling code here:
        dbPasswordField.requestFocus(true);
    }//GEN-LAST:event_dbUserTxtActionPerformed

    private void dbButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbButtonKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dbButtonActionPerformed(null);
        }
    }//GEN-LAST:event_dbButtonKeyReleased

    private void usrButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usrButtonKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usrButtonActionPerformed(null);
        }
    }//GEN-LAST:event_usrButtonKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        operlable.setText("");
        showConfirmDialog = JOptionPane.showConfirmDialog(this, "This may Reset Database, Are You Sure?", "Store Database", JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog == 0) {

            JFileChooser jFileChooser = new JFileChooser();
            FileFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.SQL File", "sql");
            jFileChooser.setFileFilter(fileNameExtensionFilter);
            jFileChooser.showOpenDialog(this);
            File selectedFile = jFileChooser.getSelectedFile();
            //     jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //     jFileChooser.showDialog(this, "select folder");
            //  System.out.println(jFileChooser.getSelectedFile().toString());

            try {
                //  System.out.println(selectedFile);
                int restoreBackup = new BackUp().storeDataBase(selectedFile);
                if (restoreBackup == 1) {
                    operlable.setText("Done");
                }
            } catch (IOException ex) {
                errorAtSetup(ex);
            } catch (ClassNotFoundException ex) {
                errorAtSetup(ex);
            } catch (SQLException ex) {
                errorAtSetup(ex);
            } catch (InterruptedException ex) {
                errorAtSetup(ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separator;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JPasswordField adminPasswordField;
    private javax.swing.JPasswordField adminconfirmPasswordField;
    private javax.swing.JLabel dBSetting;
    private javax.swing.JButton dbButton;
    private javax.swing.JPasswordField dbPasswordField;
    private javax.swing.JTextField dbUrlTxt;
    private javax.swing.JTextField dbUserTxt;
    private javax.swing.JPasswordField dbconfirmPasswordField;
    private javax.swing.JLabel dbtryAgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JLabel newPassLabel1;
    private javax.swing.JLabel operlable;
    private javax.swing.JLabel passLable;
    private javax.swing.JLabel tryAgLabel;
    private javax.swing.JLabel tryAgLabel1;
    private javax.swing.JLabel urlLable;
    private javax.swing.JLabel userLable;
    private javax.swing.JLabel userSettLable;
    private javax.swing.JButton usrButton;
    private javax.swing.JPasswordField usrconfirmPasswordField;
    private javax.swing.JLabel usretLabel;
    private javax.swing.JPasswordField usrnewPasswordField;
    private javax.swing.JLabel ussetLabel1;
    // End of variables declaration//GEN-END:variables

    public int setup() {
        //
        return done;

    }

    private void checkdispose() {
        if (done == 2) {
            dispose();
        }
    }

    private void errorAtSetup(Exception ex) {
        operlable.setText("Store Database is'nt complete" + ex.getMessage());
    }
}