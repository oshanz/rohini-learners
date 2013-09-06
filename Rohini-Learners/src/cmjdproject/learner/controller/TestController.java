/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author oshanz
 */
public class TestController {
    
    public void setfake(String testType) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        String query = "INSERT INTO tests VALUES ('" + testType + "','trial',500)";
        DBHandler.setData(DBConnection.getDirectConnection(), query);
    }
}
