/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.SlideEndEvent;
 
@ManagedBean(name ="sliderView")
@SessionScoped
@RequestScoped
public class SliderView
{
    private int number3;   
    private double donation;
    private double finalDonation;
    private String message;
    private final double PIXEL_PRICE =.22;

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

    
    
    
}