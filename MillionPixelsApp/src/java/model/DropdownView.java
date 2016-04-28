/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author it3530114
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean(name ="dropdownView")
@ViewScoped
public class DropdownView implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private String city;  
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    private Map<String,String> countries;
    private Map<String,String> cities;
    private Map<String,String> states;
     
    @PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");
         
        states  = new HashMap<String, String>();
        states.put("AL","Alabama");
	states.put("AK","Alaska");
	states.put("AZ","Arizona");
	states.put("AR","Arkansas");
	states.put("CA","California");
	states.put("CO","Colorado");
	states.put("CT","Connecticut");
	states.put("DE","Delaware");
	states.put("DC","District of Columbia");
        states.put("FL","Florida");
        states.put("GA","Georgia");
	states.put("HI","Hawaii");
	states.put("ID","Idaho");
	states.put("IL","Illinois");
	states.put("IN","Indiana");
	states.put("IA","Iowa");
	states.put("KS","Kansas");
	states.put("KY","Kentucky");
	states.put("LA","Louisiana");
	states.put("ME","Maine");
	states.put("MD","Maryland");
	states.put("MA","Massachusetts");
	states.put("MI","Michigan");
	states.put("MN","Minnesota");
	states.put("MS","Mississippi");
	states.put("MO","Missouri");
	states.put("MT","Montana");
	states.put("NE","Nebraska");
	states.put("NV","Nevada");
	states.put("NH","New Hampshire");
	states.put("NJ","New Jersey");
        states.put("NM","New Mexico");
	states.put("NY","New York");
	states.put("NC","North Carolina");
	states.put("ND","North Dakota");
	states.put("OH","Ohio");
	states.put("OK","Oklahoma");
	states.put("OR","Oregon");
	states.put("PA","Pennsylvania");
	states.put("PR","Puerto Rico");
	states.put("RI","Rhode Island");
	states.put("SC","South Carolina");
	states.put("SD","South Dakota");
	states.put("TN","Tennessee");
	states.put("TX","Texas");
	states.put("VI","U.S. Virgin Islands");
	states.put("UT","Utah");
	states.put("VT","Vermont");
	states.put("VA","Virginia");
	states.put("WA","Washington");
	states.put("WV","West Virginia");
	states.put("WI","Wisconsin");
	states.put("WY","Wyoming");
        
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paolo", "Sao Paolo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }

    public Map<String, String> getStates() {
        return states;
    }

    public void setStates(Map<String, String> states) {
        this.states = states;
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
 
    public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
   
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Selected", city + " of " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}