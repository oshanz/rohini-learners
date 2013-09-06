/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.models;

/**
 *
 * @author oshanz
 */
public class TestpartMod {

    private String rid;
    private String tid;
    private String testdate;
    private String paymentconfirmdate;
    private String result;

    public TestpartMod() {
    }

    public TestpartMod(String rid, String tid, String testdate, String paymentconfirmdate) {
        this.rid = rid;
        this.tid = tid;
        this.testdate = testdate;
        this.paymentconfirmdate = paymentconfirmdate;

    }

    public TestpartMod(String rid, String tid, String testdate, String paymentconfirmdate, String result) {
        this.rid = rid;
        this.tid = tid;
        this.testdate = testdate;
        this.paymentconfirmdate = paymentconfirmdate;
        this.result = result;
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
     * @return the testdate
     */
    public String getTestdate() {
        return testdate;
    }

    /**
     * @param testdate the testdate to set
     */
    public void setTestdate(String testdate) {
        this.testdate = testdate;
    }

    /**
     * @return the paymentconfirmdate
     */
    public String getPaymentconfirmdate() {
        return paymentconfirmdate;
    }

    /**
     * @param paymentconfirmdate the paymentconfirmdate to set
     */
    public void setPaymentconfirmdate(String paymentconfirmdate) {
        this.paymentconfirmdate = paymentconfirmdate;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }
}
