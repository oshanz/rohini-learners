/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.models;

/**
 *
 * @author oshanz
 */
public class CandidateMod {

    private String nid;
    private String name;
    private String address;
    private String birthDate;
    private int telephone;

    /**
     * @return the nid
     */
    public String getNid() {
        return nid;
    }

    public CandidateMod(String nid, String name, String address, String birthDate, int telephone) {
        this.nid = nid;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.telephone = telephone;
    }

    public CandidateMod() {
    }

    /**
     * @param nid the nid to set
     */
    public void setNid(String nid) {
        this.nid = nid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}