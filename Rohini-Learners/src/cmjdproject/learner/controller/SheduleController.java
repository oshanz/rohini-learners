/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import cmjdproject.learner.models.SheduleMod;
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
public class SheduleController {

    public ArrayList<Integer> getSheduleinfo(String day1, String day2, String day3) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Connection connection = DBConnection.getDirectConnection();
        String query = "SELECT studentsamount FROM `learner`.`shedules` WHERE dayofweek = '" + day1 + "' or dayofweek = '" + day2 + "' or dayofweek = '" + day3 + "'";
        ResultSet data = DBHandler.getData(connection, query);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (data.next()) {
            arrayList.add(data.getInt(1));
        }
        return arrayList;
    }

    public int updateShedules(String dayofweek, String time) throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {

        String dow = dayofweek;
        String tm = time;
        int studentamount = new SheduleController().getStudentamount(dow, tm);
        int setData = -1;
        String query;
        if (studentamount > 0) {


            query = "UPDATE `learner`.`shedules` SET studentsamount = " + studentamount + "  WHERE dayofweek = '" + dayofweek + "' AND `time` = '" + time + "'";
            setData = DBHandler.setData(DBConnection.getDirectConnection(), query);
        }
        return setData;
    }

    public int setshedule(ArrayList<SheduleMod> arrayList) throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
        ArrayList<SheduleMod> al = arrayList;
        int setData = 0;
        String query;

        for (SheduleMod sheduleMod : al) {
            query = "UPDATE `learner`.`shedules` SET studentsamount = " + sheduleMod.getStudentsamount() + " WHERE dayofweek = '" + sheduleMod.getDayofweek() + "' AND `time` = '" + sheduleMod.getTime() + "'";
            setData = DBHandler.setData(DBConnection.getDirectConnection(), query);

        }
        return setData;
    }

    private int getStudentamount(String dow, String tm) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        int done = 0;
        String query = "SELECT studentsamount -1 FROM `learner`.`shedules` WHERE dayofweek = '" + dow + "' AND `time` = '" + tm + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        if (data.next()) {
            done = data.getInt(1);
        }
        return done;
    }

    public String getSheduleId(String dayofweek, String time) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        String query = "SELECT sid FROM shedules where dayofweek = '" + dayofweek + "' AND `time` = '" + time + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        String sid = "";
        if (data.next()) {
            sid = data.getString(1);
        }
        return sid;
    }
}
