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
public class Donation {
    private String uid;
    private String displayname;
    private String state;
    private int pixelsbought;
    public Donation(String uid, String displayname, String state, int pixelsbought){
        this.uid=uid;
        this.displayname=displayname;
        this.state=state;
        this.pixelsbought=pixelsbought;
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
     * @return the displayname
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * @param displayname the displayname to set
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the pixelsbought
     */
    public int getPixelsbought() {
        return pixelsbought;
    }

    /**
     * @param pixelsbought the pixelsbought to set
     */
    public void setPixelsbought(int pixelsbought) {
        this.pixelsbought = pixelsbought;
    }
}
