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
public class ShedulepartMod {

    private String rid;
    private String sid;
    private String dayofweek;
    private String time;

    public ShedulepartMod() {
    }

    public ShedulepartMod(String rid, String sid, String dayofweek, String time) {
        this.rid = rid;
        this.sid = sid;
        this.dayofweek = dayofweek;
        this.time = time;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
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
    
    
    
}
