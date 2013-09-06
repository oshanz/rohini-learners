/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oshanz
 */
public class DBHandler {
    
    public static int setData(Connection connection, String query) throws SQLException {
        
        Statement stm = (Statement) connection.createStatement();
        int result = stm.executeUpdate(query);
        
//        int result = stm.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//        ResultSet generatedKeys = stm.getGeneratedKeys();
//        generatedKeys.next();
//        int aInt = generatedKeys.getInt(2);
//        System.out.println(aInt);
        
        return result;
    }
    
    public static ResultSet getData(Connection connection, String query) throws SQLException {
        
        Statement stm = (Statement) connection.createStatement();
        ResultSet result = stm.executeQuery(query);
        return result;
    }
    
    public static ResultSet viewData(Connection connection, String query) throws SQLException {
        
        Statement stm = (Statement) connection.createStatement();
        ResultSet result = stm.executeQuery(query);
        return result;
    }
}
