/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.models;

/**
 *
 * @author oshanz
 */
public class RegisterMod {

    private String rid;
    private String nid;
    private String cid;
    private String regdate;
    private String payment;

    public RegisterMod() {
    }

    public RegisterMod(String rid, String nid, String cid, String regdate, String payment) {
        this.rid = rid;
        this.nid = nid;
        this.cid = cid;
        this.regdate = regdate;
        this.payment = payment;
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
     * @return the nid
     */
    public String getNid() {
        return nid;
    }

    /**
     * @param nid the nid to set
     */
    public void setNid(String nid) {
        this.nid = nid;
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
     * @return the regdate
     */
    public String getRegdate() {
        return regdate;
    }

    /**
     * @param regdate the regdate to set
     */
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    /**
     * @return the payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }
}
