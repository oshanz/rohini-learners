/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import cmjdproject.learner.models.CandidateMod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oshanz
 */
public class CandidateController {

    public static ArrayList<String> getCandidateDetails() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {


        Connection connection = DBConnection.getDirectConnection();
        String sql = "SELECT r.nid,c.`name` From candidates c, register r WHERE r.nid=c.nid";
        ResultSet data = DBHandler.getData(connection, sql);

        ArrayList<String> arrayList = new ArrayList<String>();
        while (data.next()) {
            arrayList.add(data.getString(1) + "," + data.getString(2));
        }
        return arrayList;
    }

    public static CandidateMod getname(String nid) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        String query = "SELECT * FROM candidates WHERE nid = '" + nid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        CandidateMod candidateMod;

        if (data.next()) {

            candidateMod = new CandidateMod();
            candidateMod.setNid(nid);
            candidateMod.setName(data.getString(2));
            candidateMod.setAddress(data.getString(3));
            candidateMod.setTelephone(data.getInt(4));
            return candidateMod;
        }
        return null;
    }

    public CandidateMod getCandidateInfo(String rid) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        String regid = rid;
        String nid = new RegisterController().getnid(regid);
        String query = "SELECT * FROM candidates WHERE nid = '" + nid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);

        CandidateMod candidateMod;
        if (data.next()) {

            candidateMod = new CandidateMod();
            candidateMod.setNid(nid);
            candidateMod.setName(data.getString(2));
            candidateMod.setAddress(data.getString(3));
            candidateMod.setTelephone(data.getInt(4));
            return candidateMod;
        }
        return null;

    }
}
