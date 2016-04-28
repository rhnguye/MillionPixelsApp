/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
 
import controller.UserController;
import dao.DAOImpl;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.SlideEndEvent;
 
@ManagedBean(name ="sliderView")
@SessionScoped
@RequestScoped
public class SliderView
{
    private int number3;  //number of pixels bought; 
    private double donation;
    private double finalDonation;
    private String message;//display name
    private final double PIXEL_PRICE =.22;
    private String state;
    
    @ManagedProperty(value="#{userController}")
    private UserController uc;
    @ManagedProperty(value="#{dropdownView}")
    private DropdownView dv;

    public String donate(){
        DAOImpl d=new DAOImpl();
        if(d.donate(number3, message, getUc().getUid(), dv.getState())==1)
            return "https://www.sandbox.paypal.com/cgi-bin/webscr";
        return "error.xhtml";
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public double getFinalDonation() {
        return finalDonation;
    }

    public void setFinalDonation(double finalDonation) {
        this.finalDonation = finalDonation;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getNumber3() 
    {
        return number3;
    }

    public double getDonation() 
    {
        return donation;
    }

    public void setDonation(double donation) 
    {
        this.donation = donation;
        toString();
    }
 
    public void setNumber3(int number3) 
    {
        this.number3 = number3;
    }

    //.22 assumed price per pixel
    public double calculateDonation()
    {
        setDonation(number3 * PIXEL_PRICE);
        return donation;
    }
     
    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + getDonation());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 

    @Override
    public String toString() {
        return "SliderView{" + "number3=" + number3 + ", donation=" + donation + ", message=" + message + '}';
    }

    /**
     * @return the uc
     */
    public UserController getUc() {
        return uc;
    }

    /**
     * @param uc the uc to set
     */
    public void setUc(UserController uc) {
        this.uc = uc;
    }

    /**
     * @return the dv
     */
    public DropdownView getDv() {
        return dv;
    }

    /**
     * @param dv the dv to set
     */
    public void setDv(DropdownView dv) {
        this.dv = dv;
    }  
}