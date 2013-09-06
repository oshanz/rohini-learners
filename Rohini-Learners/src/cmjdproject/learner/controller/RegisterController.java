/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import cmjdproject.learner.models.CandidateMod;
import cmjdproject.learner.models.RegisterMod;
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
public class RegisterController {

    public static String getRistrationid(String nid) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Connection connection = DBConnection.getDirectConnection();
        String query = "SELECT rid FROM `register` WHERE nid = '" + nid + "'";
        ResultSet data = DBHandler.getData(connection, query);
        if (data.next()) {
            return data.getString(1);
        } else {
            return -1 + "";
        }
    }

    public static String getnid(String regid) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
        String query = "SELECT nid FROM register WHERE rid = '" + regid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        String nid = "";
        if (data.next()) {
            nid = data.getString(1);

        }
        return nid;
    }

    public static ArrayList<CandidateMod> getnidfromdate(ArrayList<String> arrayList) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {


        ArrayList<CandidateMod> arrayList1 = new ArrayList<CandidateMod>();
        for (String string : arrayList) {
            String query = "SELECT nid FROM register WHERE regdate = '" + string + "'";
            ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
            while (data.next()) {

                //  System.out.println(nid);
                arrayList1.add(CandidateController.getname(data.getString(1)));

            }
            // return null;
        }
        return arrayList1;

    }

    public static String getregdate(String nid) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

        String query = "select regdate from register WHERE nid='" + nid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        if (data.next()) {
            return (data.getString(1));
        }
        return null;
    }

    public static String payrest(String nid) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
        String query = "select payment from register WHERE nid='" + nid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        if (data.next()) {
            return (data.getString(1));
        }
        return null;
    }

    public static String getcid(String nid) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
        String query = "select cid from register WHERE nid='" + nid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        if (data.next()) {
            return (data.getString(1));
        }
        return null;
    }

    public ArrayList<String> getregdate() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        String query = "select regdate from register";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        while (data.next()) {
            arrayList.add(data.getString(1));
        }
        return arrayList;
    }

    public ArrayList<RegisterMod> getpayrest() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
        String query = "select payment,nid,rid from register";
        ArrayList<RegisterMod> arrayList = new ArrayList<RegisterMod>();
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        RegisterMod registerMod;
        while (data.next()) {


            registerMod = new RegisterMod();
            registerMod.setPayment(data.getString(1));
            registerMod.setNid(data.getString(2));
            registerMod.setRid(data.getString(3));
            arrayList.add(registerMod);
        }
        return arrayList;
    }
}
