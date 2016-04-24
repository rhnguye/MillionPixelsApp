/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Donation;

/**
 *
 * @author it3530216
 */
@ManagedBean(name="searchController")
@RequestScoped
public class SearchController {

    /**
     * Creates a new instance of SearchController
     */
    public SearchController() {
    }
    
    public List<Donation> getTopDonations(){
        DAOImpl dao=new DAOImpl();
        return dao.topDonators();
        
    }
    
}
