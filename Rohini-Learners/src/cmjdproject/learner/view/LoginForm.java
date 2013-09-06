/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.view;

import cmjdproject.learner.other.Theme;
import cmjdproject.learner.view.manager.AdminForm;
import cmjdproject.learner.view.user.UserForm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author oshanz
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    int count = 0;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    String userpass = "+null", adminpass = "+null";
    Properties properties;
    StrongPasswordEncryptor strongPasswordEncryptor;
    int selectedIndex;

    public LoginForm() {
        this.properties = new Properties();
        setLocationRelativeTo(this);
        initComponents();
        passwordField.requestFocus(true);
        themeComboBox.setToolTipText("Select Theme");
        passwordField.setToolTipText("Input Password");
        strongPasswordEncryptor = new StrongPasswordEncryptor();
        try {
            properties.load(new FileInputStream("loginconfig.properties"));
            userpass = properties.getProperty("userpass");
            adminpass = properties.getProperty("adminpass");


        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        MouseWheelListener mouseWheelListener = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent evt) {

                int index = comboBox.getSelectedIndex() + evt.getWheelRotation();
                if (index >= 0 && index < comboBox.getItemCount()) {
                    comboBox.setSelectedIndex(index);
                }

            }
        };

        comboBox.addMouseWheelListener(mouseWheelListener);
        //themeComboBox.addMouseWheelListener(mouseWheelListener);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox();
        passwordField = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        themeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        userNameLabel.setText("User Name");

        passwordLabel.setText("Password");

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User", "Admin" }));
        comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxItemStateChanged(evt);
            }
        });
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        comboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboBoxKeyReleased(evt);
            }
        });

        passwordField.setToolTipText("");
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        submitButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                submitButtonFocusGained(evt);
            }
        });
        submitButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                submitButtonKeyReleased(evt);
            }
        });

        themeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "AeroLookAndFeel", "GTKLookAndFeel", "MotifLookAndFeel", "AluminiumLookAndFeel", "BernsteinLookAndFeel", "new FastLookAndFeel", "MintLookAndFeel", "SmartLookAndFeel", "new MetalLookAndFeel" }));
        themeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                themeComboBoxItemStateChanged(evt);
            }
        });
        themeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLabel)
                            .addComponent(passwordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(themeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addComponent(themeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
        submitButton.requestFocus();
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String login = comboBox.getSelectedItem().toString();
        if ("User".equals(login)) {
            String pass = userpass;
            if (strongPasswordEncryptor.checkPassword(new String(passwordField.getPassword()), userpass)) {

                UserForm userForm = new UserForm();
                userForm.setSize(screenSize);
                userForm.setVisible(true);
                dispose();
            } else {
                passwordField.setForeground(Color.red);
                count += 1;

            }
        } else {
            String pass = adminpass;
            if (strongPasswordEncryptor.checkPassword(new String(passwordField.getPassword()), adminpass)) {

                AdminForm adminForm = new AdminForm();
                adminForm.setSize(screenSize);
                adminForm.setVisible(true);
                dispose();
            } else {
                passwordField.setForeground(Color.red);
                passwordField.requestFocus(true);
                count += 1;

            }
        }

        if (count > 3) {
            setTitle(count + " attempts this insident will be reported");
            properties.setProperty("count", "" + count);
            properties.setProperty("Date", dateFormat.format(date));
            //  properties.setProperty("userpass", strongPasswordEncryptor.encryptPassword("upass"));
            //  properties.setProperty("adminpass", strongPasswordEncryptor.encryptPassword("apass"));
            try {
                properties.store(new FileOutputStream("loginconfig.properties"), null);


            } catch (FileNotFoundException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (count == 1) {
            setTitle(" Invalid password");
        } else {
            setTitle(count + " attempts");
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldFocusGained

    private void submitButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_submitButtonKeyReleased
    }//GEN-LAST:event_submitButtonKeyReleased

    private void themeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_themeComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_themeComboBoxItemStateChanged

    private void themeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeComboBoxActionPerformed
        // TODO add your handling code here:


        selectedIndex = themeComboBox.getSelectedIndex();

        try {
            new Theme().theme(selectedIndex, this);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Theam files not found");
        };

    }//GEN-LAST:event_themeComboBoxActionPerformed

    private void submitButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_submitButtonFocusGained
        // TODO add your handling code here:
        //  submitButtonActionPerformed(null);
    }//GEN-LAST:event_submitButtonFocusGained

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        // TODO add your handling code here:
        passwordField.setForeground(null);
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void comboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxKeyReleased
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        if (KeyEvent.VK_ENTER == keyCode) {
            comboBox.showPopup();
        }
    }//GEN-LAST:event_comboBoxKeyReleased

    private void comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxItemStateChanged

    private void comboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        // PasswordField.requestFocus(true);
    }//GEN-LAST:event_comboBoxPopupMenuWillBecomeInvisible
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBox;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox themeComboBox;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
