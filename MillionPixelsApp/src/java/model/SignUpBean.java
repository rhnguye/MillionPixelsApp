/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author it3530216
 */
public class SignUpBean {
    private String fname,
                   lname, 
                   uid, 
                   pass,
                   confirmpass,
                   email,
                   secques,
                   secanswer;
    public SignUpBean(){
    }
    
    public SignUpBean(String fname, String lname, String uid, String pass, String confirmpass, String email, String secques, String secanswer){
        this.fname=fname;
        this.lname=lname;
        this.uid=uid;
        this.pass=pass;
        this.confirmpass=confirmpass;
        this.email=email;
        this.secques=secques;
        this.secanswer=secanswer;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the confirmpass
     */
    public String getConfirmpass() {
        return confirmpass;
    }

    /**
     * @param confirmpass the confirmpass to set
     */
    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the secques
     */
    public String getSecques() {
        return secques;
    }

    /**
     * @param secques the secques to set
     */
    public void setSecques(String secques) {
        this.secques = secques;
    }

    /**
     * @return the secanswer
     */
    public String getSecanswer() {
        return secanswer;
    }

    /**
     * @param secanswer the secanswer to set
     */
    public void setSecanswer(String secanswer) {
        this.secanswer = secanswer;
    }
    
}
