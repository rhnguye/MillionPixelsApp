/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.util.List;
import model.Donation;
import model.LoginBean;
import model.SignUpBean;
/**
 *
 * @author it3530216
 */
public interface DAO {

    /**
     *
     * @param aProfile
     * @return
     */
    public int createProfile(SignUpBean aProfile);
    public LoginBean login(String username, String password);
    public List<Donation> topDonators();
    public List<Donation> allDonators();
    public int donate(int pbought, String dname, String uid, String state);
}
