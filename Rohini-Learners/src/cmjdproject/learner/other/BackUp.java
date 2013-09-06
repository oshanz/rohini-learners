
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author oshanz
 */
public class BackUp {

    private String dbpassword, dburl, dbuser;
    private String date;
    private File path;
    // private ConnectionInfo connectionInfo;
    private Properties dbproperties;
    //   private Properties logproperties;
    private StandardPBEStringEncryptor standardPBEStringEncryptor;
    private String decrypt;
    private String database;
    private SimpleDateFormat simpleDateFormat;

    public BackUp() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        Calendar instance = Calendar.getInstance();

        this.simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-a-KK-mm");
        //  System.out.println(simpleDateFormat.format(instance.getTime()));
        this.date = simpleDateFormat.format(instance.getTime());
//
//        this.connectionInfo = DBConnection.getDBConnection().getconnectionInfo();
//        this.dbpassword = connectionInfo.getDbpassword();
//        this.dburl = connectionInfo.getDburl();
//        this.dbuser = connectionInfo.getDbuser();
//
        this.dbproperties = new Properties();
        this.standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("Rohini");

        dbproperties.load(new FileInputStream("dbconfig.properties"));
        this.dburl = dbproperties.getProperty("dburl");
        this.dbuser = dbproperties.getProperty("dbuser");
        this.dbpassword = dbproperties.getProperty("dbpassword");
        this.decrypt = standardPBEStringEncryptor.decrypt(dbpassword);

        // System.out.println(dburl+" "+date);

    }

    public int createBackup(String path, String note) throws IOException, InterruptedException {


        //   --add-drop-database -B
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("mysqldump learner -hlocalhost -u" + dbuser + " -p" + decrypt + " -r " + path + "/" + date + note + "backup.sql");
        int waitFor = exec.waitFor();
        if (waitFor == 0) {
            return 1;
        } else {
            return 0;
        }

    }

    public int restoreBackup(File path) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        // this.path = path;
        String[] executeCmd = new String[]{"mysql", "--host=localhost", "--user=" + dbuser, "--password=" + decrypt, "learner", "-e", "source " + path};
        Process exec = runtime.exec(executeCmd);
        int waitFor = exec.waitFor();
        if (waitFor == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int storeDataBase(File path) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        // this.path = path;
        //  System.out.println(dburl+" "+date);
        //  Connection connection = DBConnection.getDBConnection().getConnection();
        //String query = "CREATE DATABASE learner";

        // int r = DBHandler.setData(connection, query);
        //System.out.println(path);
        // runtime.exec("mysql -hlocalhost -u" + dbuser + " -p" + dbpassword + "; "
        //       + "\n \n \n \n create database learner;");
        //System.out.println("2");
        // runtime.exec("exit");
        //System.out.println("3");
        String[] executeCmd = new String[]{"mysql", "--host=localhost", "--user=" + dbuser, "--password=" + decrypt, "-e", "source " + path};
        Process exec = runtime.exec(executeCmd);

        int waitFor = exec.waitFor();
        if (waitFor == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
