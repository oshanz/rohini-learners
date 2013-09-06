/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rohini.learners;

import cmjdproject.learner.view.Progress;
import cmjdproject.learner.view.common.SetUp;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author oshanz
 */
public class RohiniLearners {

    private Properties properties;
    private SetUp settings;
    private int done = 0;
    private boolean stop = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new RohiniLearners();

    }

    public RohiniLearners() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream("dbconfig.properties"));
            properties.load(new FileInputStream("loginconfig.properties"));
            new Progress().setVisible(true);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Please SetUp Properties");


            settings = new SetUp();
            settings.setVisible(true);

            while (!stop) {


                if (settings.setup() == 2) {
                    new Progress().setVisible(true);
                    stop = true;
                }
            }

        }

    }
}
