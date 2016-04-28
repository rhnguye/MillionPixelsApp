/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ChangeImage;
import model.Donation;
import model.LoginBean;

/**
 *
 * @author it3530216
 */
@ManagedBean(name="userController")
@SessionScoped
public class UserController {
    private boolean loggedin;
    private String email, fname, lname, password, uid;
    private int pixelsbought;
    private LoginBean lb;
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
        loggedin=false;
        lb=new LoginBean();
        DAOImpl dao=new DAOImpl();
        ArrayList<Donation> mylist = (ArrayList<Donation>) dao.allDonators();
        int count = 0;
        for(int i = 0; i < mylist.size(); i++)
        {
            count = count + mylist.get(i).getPixelsbought();
        }
        pixelsbought = count;
        imageUpdate();
    }

    /**
     * @return the loggedin
     */
    public boolean isLoggedin() {
        return loggedin;
    }

    /**
     * @param loggedin the loggedin to set
     */
    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }

    /**
     * @return the lb
     */
    public LoginBean getLb() {
        return lb;
    }

    /**
     * @param lb the lb to set
     */
    public void setLb(LoginBean lb) {
        this.lb = lb;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
        
    public String login(){
        DAOImpl dao=new DAOImpl();   
        LoginBean temp=dao.login(lb.getUid(), lb.getPassword());
        //email, fname, lname, password, uid;
        if(temp!=null){
            setEmail(temp.getEmail());
            setFname(temp.getFname());
            setLname(temp.getLname());
            setUid(lb.getUid());
            setPassword(lb.getPassword());
            setLoggedin(true);
            return "homepage.xhtml?faces-redirect=true";
        }
        return "error.xhtml";
    }
    
    public String logout(){
        setUid("");
        setPassword("");
        setEmail("");
        setFname("");
        setLname("");
        setLoggedin(false);
        
        return "homepage.xhtml?faces-redirect=true";
    }
    
    public String imageUpdate()
    {
        ChangeImage myimage = new ChangeImage();
        myimage.updateImage(pixelsbought, "/resources/images/pic1.png", "/resources/images/pic2.png");
        return "homepage.xhtml";
    }
    public String[] getAllDonationNames()
    {
         DAOImpl dao=new DAOImpl();
         List<Donation> mylist = dao.allDonators();
         for(int i = 0; i < mylist.size(); i++)
         {
             if(mylist.get(i).getPixelsbought() == 0)
             {
                 mylist.remove(i);
             }
         }
         String[] temp = new String[mylist.size()];
         for(int i = 0; i < mylist.size(); i++)
         {
             temp[i] = mylist.get(i).getDisplayname();
         }
         return temp;
    }
    public int[] getAllDonationAmout()
    {
        DAOImpl dao=new DAOImpl();
         List<Donation> mylist = dao.allDonators();
         for(int i = 0; i < mylist.size(); i++)
         {
             if(mylist.get(i).getPixelsbought() == 0)
             {
                 mylist.remove(i);
             }
         }
         int[] temp = new int[mylist.size()];
         for(int i = 0; i < mylist.size(); i++)
         {
             temp[i] = mylist.get(i).getPixelsbought();
         }
         return temp;
        
        
    }
}
