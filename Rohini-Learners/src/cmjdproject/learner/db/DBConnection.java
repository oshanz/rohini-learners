/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author oshanz
 */
public class DBConnection {

    private static DBConnection dBConnection;
    private static Connection connection;
    private Properties dbproperties;
    //   private Properties logproperties;
    private StandardPBEStringEncryptor standardPBEStringEncryptor;
    private String dburl, dbuser, dbpassword, decrypt;

    private DBConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        this.standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        //    this.logproperties = new Properties();
        this.dbproperties = new Properties();


        //   logproperties.load(new FileInputStream("loginconfig.properties"));
        //   String property = logproperties.getProperty("adminpass");
        standardPBEStringEncryptor.setPassword("Rohini");


        dbproperties.load(new FileInputStream("dbconfig.properties"));
        dburl = dbproperties.getProperty("dburl");
        dbuser = dbproperties.getProperty("dbuser");
        dbpassword = dbproperties.getProperty("dbpassword");
        decrypt = standardPBEStringEncryptor.decrypt(dbpassword);



        // System.out.println(dburl + " " + dbuser + " " + decrypt);
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dburl, dbuser, decrypt);

    }

    private Connection getConnection() {

        return connection;
    }

    private static DBConnection getDBConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public static Connection getDirectConnection() throws ClassNotFoundException, IOException, FileNotFoundException, SQLException {
        return getDBConnection().getConnection();

    }
}
