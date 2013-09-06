/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import java.io.IOException;

/**
 *
 * @author oshanz
 */
public class StartSQL {

    public void startmysql() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
            runtime.exec("gksudo start mysql");
        } else if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
            runtime.exec("net start MySQL");
        }

    }
}
