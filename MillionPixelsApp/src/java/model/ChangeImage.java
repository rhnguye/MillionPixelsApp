/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

/**
 *
 * @author it3530118
 */
public class ChangeImage {
    
    private BufferedImage img = null;
    private File file = null;
    private int pixelsBought = 0;
    
    public ChangeImage(BufferedImage img, File file, int pixelsBought)
    {
        this.img = img;
        this.file = file;
        this.pixelsBought = pixelsBought;
    }
    public ChangeImage( )
    {
        this.img = null;
        this.file = null;
        this.pixelsBought = 0;
    }
    
    public void updateImage(int pixelsBought, String filename, String filename2)
    {
       try{
        System.out.println(filename);
        String relativeWebPath = filename;
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) ext.getContext();
        String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
        System.out.println("absoluteDiskPath = " + absoluteDiskPath);
        
        File file = new File(absoluteDiskPath);
        img = ImageIO.read(file);
       }
       catch(IOException e){
         System.out.println(e);
         System.out.println(System.getProperty("user.dir"));

       }
       
        int width = img.getWidth();
        int height = img.getHeight();
        int startingpixle = (width * height)- pixelsBought;
        
        int startblacking =  (pixelsBought / width);
        int leftoverStartpixels = (pixelsBought % width);

        for(int i = startblacking; i < height; i++)
        {
         for(int k = 0; k < width; k++)
         {
          int p = img.getRGB(k,i);

             int a = (p>>24)&0xFF000000;
             int r = (p>>16)&0xFF000000;
             int g = (p>>8)&0xFF000000;
             int b = p&0xFF000000;

             //calculate average
             int avg = (r+g+b)/3;

             //replace RGB value with avg
             p = (a<<24) | (avg<<16) | (avg<<8) | avg;

             img.setRGB(k, i, p);
         }
        }
        for(int i = leftoverStartpixels; i < width; i++)
        {
          int p = img.getRGB(i,startblacking-1);

             int a = (p>>24)&0xFF000000;
             int r = (p>>16)&0xFF000000;
             int g = (p>>8)&0xFF000000;
             int b = p&0xFF000000;

             //calculate average
             int avg = (r+g+b)/3;
             //replace RGB value with avg
             
             p = (a<<24) | (avg<<16) | (avg<<8) | avg;
             
             img.setRGB(i, startblacking-1, p);
        }


        //write image
        try{
            String relativeWebPath2 = filename2;
            ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
            ServletContext servletContext = (ServletContext) ext.getContext();
            String absoluteDiskPath2 = servletContext.getRealPath(relativeWebPath2);
            File file2 = new File(absoluteDiskPath2);
          ImageIO.write(img, "png", file2);
          System.out.println("pic1.png was updated");
        }catch(IOException e){
          System.out.println(e);
        }
    }
 
}
