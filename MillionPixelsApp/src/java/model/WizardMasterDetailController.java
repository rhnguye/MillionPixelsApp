/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author it3530114
 */
@ManagedBean  
@ViewScoped  
public class WizardMasterDetailController implements Serializable {  
  
    private static final long serialVersionUID = 20120209L;  
  
    private SignUpBean user = new SignUpBean();  
    private int currentLevel = 1;  
  
    public SignUpBean getUser() {  
        return user;  
    }  
  
    public void setUser(SignUpBean user) {  
        this.user = user;  
    }  
  
    public int getCurrentLevel() {  
        return currentLevel;  
    }  
  
    public void setCurrentLevel(int currentLevel) {  
        this.currentLevel = currentLevel;  
    }  
  
    public void save(ActionEvent actionEvent) {  
        FacesMessage msg = new FacesMessage("Saved successful", "Welcome :" + user.getFname());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
  
        // create new empty user  
        //user = new SignUpBean();  
        currentLevel = 1;  
    }  
}  