/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.controller;

import cmjdproject.learner.db.DBConnection;
import cmjdproject.learner.db.DBHandler;
import cmjdproject.learner.models.SheduleMod;
import cmjdproject.learner.models.ShedulepartMod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oshanz
 */
public class ShedulepartController {

    public ArrayList<ShedulepartMod> getparicipationInfo(String rid) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        ArrayList<ShedulepartMod> arrayList = new ArrayList<ShedulepartMod>();
        String query = "select dayofweek,time from shedulepart where rid = '" + rid + "'";
        ResultSet viewData = DBHandler.viewData(DBConnection.getDirectConnection(), query);
        ShedulepartMod shedulepartMod;

        while (viewData.next()) {
            //  System.out.println(viewData.getString(1) + "," + viewData.getString(2));
            shedulepartMod = new ShedulepartMod(null, null, viewData.getString(1), viewData.getString(2));
            arrayList.add(shedulepartMod);
        }

        return arrayList;

    }

    public int setParticipationinfo(ArrayList<ShedulepartMod> arrayList) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        ArrayList<ShedulepartMod> al = arrayList;
        int setData = 0;
        for (ShedulepartMod shedulepartMod : al) {
            String sheduleId = new SheduleController().getSheduleId(shedulepartMod.getDayofweek(), shedulepartMod.getTime());
            String query;

            if (!sheduleId.equalsIgnoreCase("")) {
                query = "INSERT INTO shedulepart VALUES('" + shedulepartMod.getRid() + "','" + sheduleId + "','" + shedulepartMod.getDayofweek() + "','" + shedulepartMod.getTime() + "')";
                setData = DBHandler.setData(DBConnection.getDirectConnection(), query);
            }
        }
        return setData;

    }

    public int remove(String selectedrid) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        String query = "Delete From shedulepart where rid='" + selectedrid + "'";
        return DBHandler.setData(DBConnection.getDirectConnection(), query);
    }

    public ArrayList<String> getparticipants(String dayofweek, String time) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

        String query = "SELECT rid FROM shedulepart WHERE dayofweek = '" + dayofweek + "' AND `time` = '" + time + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        ArrayList<String> idList = new ArrayList<String>();
        while (data.next()) {
            idList.add(data.getString(1));
        }
        return idList;
    }

    public ArrayList<ShedulepartMod> getparticipantsofday(String dayofweek) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

        String query = "SELECT rid,`time` FROM shedulepart WHERE dayofweek = '" + dayofweek + "'";
        ResultSet data = DBHandler.getData(DBConnection.getDirectConnection(), query);
        ArrayList<ShedulepartMod> idList = new ArrayList<ShedulepartMod>();
        ShedulepartMod shedulepartMod;

        while (data.next()) {
            shedulepartMod = new ShedulepartMod();
            shedulepartMod.setRid(data.getString(1));
            shedulepartMod.setTime(data.getString(2));
            idList.add(shedulepartMod);
        }
        return idList;

    }
}
