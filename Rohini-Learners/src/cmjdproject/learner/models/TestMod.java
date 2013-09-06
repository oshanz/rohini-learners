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
public class TestMod {

    private String tid;
    private String test;
    private double payment;

    public TestMod() {
    }

    public TestMod(String tid, String test, double payment) {
        this.tid = tid;
        this.test = test;
        this.payment = payment;
    }

    /**
     * @return the tid
     */
    public String getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(String tid) {
        this.tid = tid;
    }

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }

    /**
     * @return the payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    
    
}
