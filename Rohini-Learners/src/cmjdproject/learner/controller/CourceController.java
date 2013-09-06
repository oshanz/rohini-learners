/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import cmjdproject.learner.models.CourcesMod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oshanz
 */
public class CourceController {

    public static boolean updateInfo(List<CourcesMod> courceslist) throws FileNotFoundException, SQLException, IOException, ClassNotFoundException, Exception {

        Connection connection = null;
        boolean returnValue = false;

        connection = DBConnection.getDirectConnection();
        connection.setAutoCommit(false);

        List<CourcesMod> detailList = courceslist;

        try {
            for (CourcesMod courcesMod : detailList) {
                String query = "UPDATE learner.cources SET `payment` = '" + courcesMod.getPayment() + "' WHERE  cource = '" + courcesMod.getCource() + "'";
                //order
                int r = DBHandler.setData(connection, query);
                if (r == 1) {
                    //detsil
                    //if ==1 comii
                    // System.out.println("fefwef");
                } else {
                    connection.rollback();
                    returnValue = false;
                }
            }

            connection.commit();
            returnValue = true;
        } catch (Exception ex) {
            if (connection != null) {
                connection.rollback();
                throw ex;
            }

        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
        }

        return returnValue;

    }

    public CourceController() {
    }

    public static List<CourcesMod> viewCources() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {



        List<CourcesMod> ar = new ArrayList<CourcesMod>();
        String query = "SELECT cource,payment FROM cources";

        ResultSet rs = DBHandler.viewData(DBConnection.getDirectConnection(), query);
        CourcesMod courcesMod;
        while (rs.next()) {

            courcesMod = new CourcesMod(null, rs.getString(1), rs.getDouble(2));
            ar.add(courcesMod);
        }
        return ar;
    }

    public int getfees(String cid) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

        int fee = 0;
        String query = "SELECT payment FROM cources WHERE cid = '" + cid + "'";

        ResultSet rs = DBHandler.viewData(DBConnection.getDirectConnection(), query);

        while (rs.next()) {
            fee = rs.getInt(1);


        }
        return fee;
    }
}
