/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;

/**
 *
 * @author oshanz
 */
////////////http://www.java2s.com
public class LaunchURL {

    public void run(JLabel jLabel) {

        try {
            URI uri = new URI(jLabel.getText());
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            if (desktop != null) {
                desktop.browse(uri);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException use) {
            use.printStackTrace();
        }
    }
}
