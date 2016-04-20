/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dao.DAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import model.SignUpBean;

/**
 *
 * @author it3530216
 */
@ManagedBean(name = "signUpController")
@SessionScoped

/**
 *
 * @author it3530216
 */
public class SignUpController {
    private SignUpBean model;
    private String message;
    public SignUpController(){
        model=new SignUpBean();
        message="";
    }
    /**
     * @return the model
     */
    public SignUpBean getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(SignUpBean model) {
        this.model = model;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        if(message.equals(""))
            message="Username already exists<br>";
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    public void sendMail(){
        String to=model.getEmail();
        String from="jmsalvador2395@gmail.com";
        String usr="jmsalvador2395@gmail.com";
        String pass="jmsalvador2319@yahoo.com";
        String host="smtp.gmail.com";
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(properties,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usr, pass);
            }
        });
        
        try{
            MimeMessage message=new MimeMessage(session);
            MimeMultipart mp=new MimeMultipart();
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Welcome");
            message.setText("hey it worked");
            BodyPart bp=new MimeBodyPart();
            String htmlText="<img src=\"cid:image\">";
            bp.setContent(htmlText, "text/html");
            mp.addBodyPart(bp);
            
            bp=new MimeBodyPart();
            DataSource fds=new FileDataSource("image.png");
            bp.setDataHandler(new DataHandler(fds));
            bp.setHeader("Content-ID", "<image>");
            //message.setContent(mp);
            Transport.send(message);
            
        }
        catch (MessagingException mex){
        }
    }
    
    public String createProfile(){
        boolean error=false;
        message="";
        DAO sud=new DAOImpl();
        int rowcount=0;
        if(!error)
           rowcount=sud.createProfile(model);
        model=new SignUpBean();
        if(rowcount==1){
            //this.sendMail();
            return "echo.xhtml";
        }
        return "error.xhtml";
    }
}
