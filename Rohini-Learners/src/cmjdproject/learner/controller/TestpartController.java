/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import cmjdproject.learner.models.TestpartMod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oshanz
 */
public class TestpartController {

    public static ArrayList<TestpartMod> getall(String ristrationid) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        ArrayList<TestpartMod> arrayList = new ArrayList<TestpartMod>();
        String query = "SELECT * FROM testpart WHERE rid = '" + ristrationid + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        TestpartMod testpartMod;

        while (data.next()) {

            testpartMod = new TestpartMod(ristrationid, data.getString(2), data.getString(3), data.getString(4), data.getString(5));
            arrayList.add(testpartMod);
        }
        return arrayList;
    }

    public int addtotest(ArrayList<TestpartMod> arrayList) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        ArrayList<TestpartMod> al = arrayList;
        int setData = 0;
        String query;

        for (TestpartMod testpartMod : al) {
            query = "INSERT INTO testpart VALUES ('" + testpartMod.getRid() + "','" + testpartMod.getTid() + "','" + testpartMod.getTestdate() + "','" + testpartMod.getPaymentconfirmdate() + "')";
            setData = DBHandler.setData(DBConnection.getDirectConnection(), query);

        }
        return setData;
    }

    public ArrayList<String> getdata(String date) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        String query = "SELECT rid FROM testpart WHERE testdate = '" + date + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        while (data.next()) {
            arrayList.add(data.getString(1));
        }
        return arrayList;
    }
}
