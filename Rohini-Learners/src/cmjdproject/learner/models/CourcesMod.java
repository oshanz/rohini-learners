/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.models;

/**
 *
 * @author oshanz
 */
public class CourcesMod {

    private String cid;
    private String cource;
    private double payment;

    public CourcesMod() {
    }

    public CourcesMod(String cid, String cource, double payment) {
        this.cid = cid;
        this.cource = cource;
        this.payment = payment;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the cource
     */
    public String getCource() {
        return cource;
    }

    /**
     * @param cource the cource to set
     */
    public void setCource(String cource) {
        this.cource = cource;
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
