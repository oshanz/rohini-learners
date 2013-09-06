/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.models;

import cmjdproject.learner.controller.*;

/**
 *
 * @author oshanz
 */
public class SheduleMod {

    private String sid;
    private String dayofweek;
    private String time;
    private int studentsamount;

    public SheduleMod() {
    }

    public SheduleMod(String sid, String dayofweek, String time, int studentsamount) {
        this.sid = sid;
        this.dayofweek = dayofweek;
        this.time = time;
        this.studentsamount = studentsamount;
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the dayofweek
     */
    public String getDayofweek() {
        return dayofweek;
    }

    /**
     * @param dayofweek the dayofweek to set
     */
    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the studentsamount
     */
    public int getStudentsamount() {
        return studentsamount;
    }

    /**
     * @param studentsamount the studentsamount to set
     */
    public void setStudentsamount(int studentsamount) {
        this.studentsamount = studentsamount;
    }

}
